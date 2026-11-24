import assessments.AssessmentFeed;

public class NoAITest extends Assessments {
    private double ExplanationSuccessful;
    private double TestMark;
    public NoAITest(String CID){
        super(AssessmentFeed.PROGRAMMING_TEST,100,false,30,25);
        ExplanationSuccessful=AssessmentFeed.getResult(CID, "Independent Programming Test", AssessmentFeed.EXPLAINED_SUCCESSFULLY);
        TestMark=AssessmentFeed.getResult(CID,"Independent Programming Test", AssessmentFeed.PROGRAM_MARK);
    }

    @Override
    public double CalculatGrade(){
        if(ExplanationSuccessful==1){
            return TestMark;
        }
        return Math.min(TestMark,40);
    }

}
