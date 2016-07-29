package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

public class FillTheCorral {

    private OutputInterface mOut;

    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    public void setCorralGates(Gate[] gates, Random selectDirection) {
        for (Gate gate : gates) {
            boolean direction = selectDirection.nextBoolean();
            gate.setSwing(direction ? Gate.IN : Gate.OUT);
        }
    }

    public boolean anyCorralAvailable(Gate[] gates) {
        for (Gate gate : gates) {
            if (gate.getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }

    public void corralSnails(Gate[] gates, Random number) {
        int outToPasture = 5;
        int s = number.nextInt(outToPasture + 1);
    }
}
