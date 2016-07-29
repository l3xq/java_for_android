package mooc.vandy.java4android.calculator.logic;

import android.graphics.Path;

public class Divide extends Operation{


    public Divide(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int operate() {
        return getFirstNum() / getSecondNum();
    }


    public int remainder(int firstNumber, int secondNumber) {
        return firstNumber % secondNumber;
    }
}
