package mooc.vandy.java4android.calculator.logic;


public class Subtract extends Operation{


    public Subtract(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int operate() {
        return getFirstNum() - getSecondNum();
    }
}
