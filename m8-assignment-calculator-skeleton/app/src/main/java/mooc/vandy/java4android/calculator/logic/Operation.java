package mooc.vandy.java4android.calculator.logic;

public abstract class Operation {

    //Instance variables to get the number to operate on.
    private int firstNum = 0;
    private int secondNum = 0;

    //Public constructor for all of the four operations.
    public Operation (int num1, int num2) {
        firstNum = num1;
        secondNum = num2;
    }


    public abstract int operate();


    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }
}
