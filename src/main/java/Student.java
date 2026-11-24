import assessments.AssessmentFeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


    public List<Assessments> getAsssessments(){
        return Collections.unmodifiableList(assessments);
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
    String modulePercentage() {
        double total = 0;
        for (Assessments assessment : assessments) {

            total += assessment.CalculatGrade() * assessment.getWeighting("Msc".equals(Year)) / 100.0;
        }
        return String.format(Locale.ROOT, "%.2f%%", total); //im doing thish for display later
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
