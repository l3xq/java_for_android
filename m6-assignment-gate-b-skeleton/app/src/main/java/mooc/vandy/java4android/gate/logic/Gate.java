package mooc.vandy.java4android.gate.logic;

/**
 * Popunim vam kevu vise
 */
public class Gate {

    // staticke lokalne promenljive za ovu klasu
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    public static final int IN = 1;

    // private instanca koja proverava dostupnost pederluka
    private boolean closed;

    // ljuskamo se
    private int stateOfSwingClub;

    public Gate() {
        stateOfSwingClub = 0;
        closed = true;
    }

    // kupi status kapije Slobodna || Zauzeta || Radodajka
    public boolean isClosed() {
        return closed;
    }

    // vraca svingerski status kapije
    public int getSwingDirection() {
        return stateOfSwingClub;
    }

    // pritvori, promaja je
    public void close() {
        this.closed = true;
    }

    // a ja sam poceo da LUTAAAAM
    public boolean open(int swingDirection) {
        closed = ! (swingDirection == IN || swingDirection == OUT);
        return setSwing(swingDirection);
    }

    // ja vise ne znam s' kiiiiim
    public boolean setSwing(int swing) {
        if(swing == IN || swing == OUT) {
            this.stateOfSwingClub = swing;
            return true;
        }
        return false;
    }


    public int thru(int numberOfPuzoviGuzovi) {
        if(closed)
            return 0;
        else if(getSwingDirection() == IN)
            return numberOfPuzoviGuzovi;
        return OUT * numberOfPuzoviGuzovi;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("This gate");
        if(isClosed())
            stringBuilder.append(" is closed");
        else
        {
            stringBuilder.append(" is open and swings"); //is not closed  and swings
            switch (getSwingDirection())
            {
                case 0:
                    stringBuilder.append(" but the stateOfSwingClub is not set properly");
                    break;
                case 1:
                    stringBuilder.append(" to enter the pen only");
                    break;
                case -1:
                    stringBuilder.append(" to exit the pen only");
                    break;
            }
        }
        return stringBuilder.toString();
    }
}