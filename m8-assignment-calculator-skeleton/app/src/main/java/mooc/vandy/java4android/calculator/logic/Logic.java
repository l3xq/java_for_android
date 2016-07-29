package mooc.vandy.java4android.calculator.logic;
/* Done by Dr. Strange aka Imposer
    aleks.ftn@gmail.com ttys
 */
import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;


public class Logic 
       implements LogicInterface {

    private static final int ADD = 1;
    private static final int SUBTRACT = 2;
    private static final int MULTIPLY = 3;
    private static final int DIVIDE = 4;

    protected ActivityInterface mOut;

    public Logic(ActivityInterface out){
        mOut = out;
    }

    public void process(int firstArgument, int secondArgument, int anonOP){

        // TODO -- start your code here
            // bacam cari Voodoo

        Operation operationOne = null;
        switch (anonOP) {
            case ADD:
                operationOne = new Add(firstArgument, secondArgument);
                mOut.print("" + operationOne.operate());
                break;

            case SUBTRACT:
                operationOne = new Subtract(firstArgument, secondArgument);
                mOut.print("" + operationOne.operate());
                break;

            case MULTIPLY:
                operationOne = new Multiply(firstArgument, secondArgument);
                mOut.print("" + operationOne.operate());
                break;

            case DIVIDE:
                if(secondArgument == 0) {
                    mOut.createToast("No number can be divided by zero. Please provide a number other then zero in the second argument.");
                    break;
                }

                operationOne = new Divide(firstArgument, secondArgument);

                Divide divisionOperator = (Divide) operationOne;

                int divResult = divisionOperator.operate();
                int remainder = divisionOperator.remainder(firstArgument, secondArgument);

                mOut.print("" + divResult + " R: " + remainder );
                break;
        }
    }
}
