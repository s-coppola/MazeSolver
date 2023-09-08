public class RecursiveSequence {
    // fields
    private int baseVal;
    private double changeVal;
    
    // constructor 
    public RecursiveSequence(int baseVal,
                             double changeVal) {
        this.baseVal = baseVal;
        this.changeVal = changeVal;
    }
// methods
    public double arithmetic(int n) {
        if (n == 1) {
            return baseVal;
        }
        return changeVal + arithmetic(n-1);
    }
    
    public double geometric(int n) {
        if (n == 1) {
            return baseVal;
        }
        return changeVal * geometric(n-1);
    }
    
    public static void main(Strings[] args) {
    
    }    
}