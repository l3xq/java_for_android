package mooc.vandy.java4android.birthdayprob.logic;
/* Created by aleks.ftn@gmail.com */
import java.util.HashSet;
import java.util.Random;

import mooc.vandy.java4android.birthdayprob.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG =
        Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
    */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process...' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    // I've completely changed assignment 5, and updated it to new version
    // Excuse non-english commenting, it was aimed towards helping a friend
    // Will remove them later down the road.
    public double calculate(int size, int count) {
        // TODO -- add your code here
        int brojac = 0;

        for (int i = 0; i < count; i++) {
            if(jedinstvenaIzvrsena(size, i)){
                brojac++;
            }
        }

        return kojaJeVerovatnoca(brojac, count);
    }

    // TODO -- add your code here
    private static double kojaJeVerovatnoca(int brojac, int izvrsenja)     {
        double verovatnoca = (double) brojac / (double) izvrsenja;
        return verovatnoca*100;
    }

    private static boolean jedinstvenaIzvrsena(int maliKauntic, int pokemonJaje) {
        Random nasumicniGuzicar = new Random(pokemonJaje); // pokemonJaje ti je ustvari ona seed velicina
        HashSet<Integer> rodjendanskiSetPokemona = new HashSet<Integer>(); // ako te ovo zbunjuje, reci da ti dam oficijalano objasnjenje

        for (int i = 0; i < maliKauntic; i++) {
            int brojBrojic = nasumicniGuzicar.nextInt(365); // stavio sam 365 jer je u tvom slucaju moglo od 0 do 364 <3

            if (rodjendanskiSetPokemona.contains(brojBrojic)) {
                return true;
            } else {
                rodjendanskiSetPokemona.add(brojBrojic);
            }
        }
        return false;
    }
}
