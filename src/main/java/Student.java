import assessments.AssessmentFeed;

import java.util.ArrayList;

public class Student {
    private String name;
    private String CID;
    private String Year;
    public ArrayList<Assessments> assessments;

    public Student(String CID){
        this.CID=CID;
        this.name= AssessmentFeed.getStudentName(CID);
        this.Year=AssessmentFeed.getStudentType(CID);
    }


}
