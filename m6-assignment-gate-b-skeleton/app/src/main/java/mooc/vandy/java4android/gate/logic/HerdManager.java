package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

public class HerdManager {

    private OutputInterface mOut;
    private Gate inputGate;
    private Gate outputGate;
    private static final int MAX_ITERATIONS = 10;
    public static final int HERD = 24;

    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        outputGate = westGate;
        outputGate.open(Gate.IN);

        inputGate = eastGate;
        inputGate.open(Gate.OUT);
    }

    // simulation of the herd
    public void simulateHerd(Random rand) {
        int herdSize = HERD;
        for (int index = 0; index < MAX_ITERATIONS; index++) {
            final Gate choosenGate = selectGate(herdSize, rand);
            int range = herdSize;
            if (choosenGate == outputGate) {
                range = HERD - herdSize;
            }
            int randomInt = nextRandomInt(rand, range);

            try {
                herdSize += choosenGate.thru(randomInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mOut.println("There are currently " + herdSize + " snails in the pen and " +
                    (HERD - herdSize) + " snails in the pasture"); // redosled mora da bude ovakav!
            // Al' volim kad ispostujem stil kodiranja, nista preko 80 karaktera u redu <3
        }
    }

    // gate in each iteration
    private Gate selectGate(final int herdSize, final Random rand) {
        Gate selected;
        if (herdSize == HERD) {
            selected = inputGate; // getRandomGate(rand);
        } else {
            selected = getRandomGate(rand);
        }
        if (selected == inputGate && herdSize == 0) {
            selected = outputGate;
        }
        return selected;
    }

    private int nextRandomInt(Random rand, int range) {
        int randValue = rand.nextInt();
        return mod(randValue, range);
    }

    private int mod(int x, int range) {

        return ((x % range + range) % range);
    }

    private Gate getRandomGate(Random rand) {
        final int val = rand.nextBoolean() == true ? 1 : 0; // 1:0 -> ako je uslov true, onda je 1
                                                            //  ako je false, onda je 0
        return val == 0 ? inputGate : outputGate;
    }
}
