public abstract class Assessments {
    private final String title;
    private final int maxMark;
    private final boolean AIAllowed;
    private final int UGWeighting;
    private final int MscWeighting;

    public Assessments(String title, int maxMark, boolean AIAllowed, int ugWeighting, int mscWeighting) {
        this.title = title;
        this.maxMark = maxMark;
        this.AIAllowed = AIAllowed;
        this.UGWeighting = ugWeighting;
        this.MscWeighting = mscWeighting;
    }

    abstract double CalculatGrade();

    public int getMaxMark() {
        return maxMark;
    }
    public boolean isAIAllowed() {
        return AIAllowed;
    }
    public int getUGWeighting(){
        return UGWeighting;
    }
    public int getMscWeighting(){
        return MscWeighting;
    }



}
