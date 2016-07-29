package mooc.vandy.java4android.diamonds.logic;
/* Done by Dr. Strange else known as Imposer
 */

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p/>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p/>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p/>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        crtajZmaja(size);

    }

    // Takes size as parameter to draw ASCII diamond
    private void crtajZmaja(int size) {

        // Calculating total rows and columns of the diamond
        int totalRows = 2 * size + 1;
        int totalColumns = totalRows + 1;
        // Looping through them
        for (int i = 1; i <= totalRows; i++) {

            if (i == 1 || i == totalRows) {
                drawEndLines(totalColumns);
            } else if (i == (size + 1)) {
                //I choose MID LANE (Dota2 reference) XD
                drawMidLine(i, totalColumns);
            } else {
                drawExtraLines(i, totalColumns, size);
            }
        }

    }

    // TODO -- add your code here

    // Draws extra (side) lines
    // Takes parameters column x,y and size
    private void drawExtraLines(int lineNumber, int lineLength, int size) {
        // Even or odd line number
        boolean isEven = lineNumber % 2 == 0;
        // Lower part or upper part of the diamond
        boolean isLower = lineNumber > size;

        int lineSpacing;

        // Calculate spacing
        if (lineNumber <= size) {
            lineSpacing = size - (lineNumber - 1);
        } else {
            lineSpacing = lineNumber - (size + 1);
        }

        // prolazi kroz duzinu linije
        for (int i = 0; i < lineLength; i++) {
            if (i == 0) {
                mOut.print("|");
            } else if (i == lineLength - 1) {
                mOut.println("|");
            } else if (i <= lineSpacing) {
                drawEmptySpace(lineSpacing);
                mOut.print(isLower ? "\\" : "/");
                i = lineSpacing + 1;
            } else if ((lineSpacing + i) == (lineLength - 2)) {
                mOut.print(isLower ? "/" : "\\");
                drawEmptySpace(lineSpacing);
                i += lineSpacing;
            } else {
                notationEvenOddDrawExtras(isEven);
            }
        }
    }

    // Space drawing, cave crawling
    private void drawEmptySpace(int numberOfSpace) {

        for (int i = 0; i < numberOfSpace; i++) {
            mOut.print(" ");
        }
    }


    private void drawEndLines(int lineLength) {

        for (int i = 0; i < lineLength; i++) {
            if (i == 0) {
                mOut.print("+");
            } else if (i == lineLength - 1) {
                mOut.println("+");
            } else {
                mOut.print("-");
            }
        }
    }

    // DJE MI JE SF XD 'Lebe mekani, 14000 sati. (again, Dota2 reference) Sry for those <3
    private void drawMidLine(int lineNumber, int lineLength) {

        if (lineLength == 4) {
            mOut.print("|<>|\n");
        } else {
            boolean even = lineNumber % 2 == 0;

            for (int i = 1; i < lineLength; i++) {
                if (i == 1) {
                    mOut.print("|<");
                } else if (i == lineLength - 2) {
                    mOut.println(">|");
                    break;
                } else {
                    notationEvenOddDrawExtras(even);
                }
            }
        }
    }

    //Draws the even or odd notation (i.e "=" or "-")
    private void notationEvenOddDrawExtras(boolean even) {

        mOut.print(even ? "=" : "-");
    }
}
