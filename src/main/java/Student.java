import assessments.AssessmentFeed;

import java.util.ArrayList;
import java.util.Locale;

public class Student {
    private String name;
    private String CID;
    private String Year;
    public ArrayList<Assessments> assessments;

    public Student(String CID){
        this.CID=CID;
        this.name= AssessmentFeed.getStudentName(CID);
        this.Year=AssessmentFeed.getStudentType(CID);
        assessments.add(new NoAITest(CID));
        assessments.add(new AITest(CID));
        if(Year.equals("Msc")){
            assessments.add(new VivaTest(CID));
        }
    }



    public String getName(){
        return name;
    }
    public String getCID(){
        return CID;
    }
    public String getYear(){
        return Year;
    }
    double modulePercentage() {
        double total = 0;
        for (Assessments assessment : assessments) {

            total += assessment.CalculatGrade() * assessment.getWeighting("Msc".equals(Year)) / 100.0;
        }
        return total;
    }
    String markFor(String title) {
        for (Assessments assessment : assessments) {
            if (assessment.getTitle().equals(title)) {
                return String.format(Locale.ROOT, "%.2f%%", assessment.CalculatGrade());
            }
        }
        return "N/A";
    }




}
