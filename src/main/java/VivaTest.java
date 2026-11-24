import assessments.AssessmentFeed;

public class VivaTest extends Assessments{
    private final double designUnderstanding;
    private final double explanation;
    public VivaTest(String CID){
        super(AssessmentFeed.DESIGN_VIVA, 100,false, 0, 30);
        designUnderstanding= AssessmentFeed.getResult(CID, "Software Design Viva",AssessmentFeed.DESIGN_MARK);
        explanation=AssessmentFeed.getResult(CID,"Software Design Viva", AssessmentFeed.EXPLANATION_MARK);


    }
    @Override
    public double CalculatGrade(){
        return 0.5*designUnderstanding + 0.5*explanation;

    }



}
