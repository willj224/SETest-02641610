import assessments.AssessmentFeed;

public class AITest extends Assessments{
    private final double functionalityGrade;
    private final double verificationGrade;
    public AITest(String CID){
        super(AssessmentFeed.AI_PROJECT,100, true, 70, 45);
        functionalityGrade=AssessmentFeed.getResult(CID, "AI_PROJECT", AssessmentFeed.FUNCTIONALITY_MARK);
        verificationGrade=AssessmentFeed.getResult(CID, "AI_PROJECT", AssessmentFeed.VERIFICATION_MARK);
    }
    @Override
    public double CalculatGrade() {
        return 0.4*functionalityGrade+0.6*verificationGrade;
    }
    @Override


}
