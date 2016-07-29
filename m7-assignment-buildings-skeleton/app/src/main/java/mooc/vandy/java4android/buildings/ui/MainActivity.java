package mooc.vandy.java4android.buildings.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mooc.vandy.java4android.buildings.R;

import mooc.vandy.java4android.buildings.logic.Logic;
import mooc.vandy.java4android.buildings.logic.LogicInterface;


public class MainActivity
       extends AppCompatActivity 
       implements OutputInterface {

    private final static String LOG_TAG =
        MainActivity.class.getCanonicalName();


    private LogicInterface mLogic;

    private EditText mOutput;


    private EditText mSize;

    private Button mProcessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // preneseno iz Super klase
        super.onCreate(savedInstanceState);

        // nova instanca Logic klase
        mLogic = new Logic(this);

        // inicijalizacija korisnickog interfejsa
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components.
     */
    private void initializeUI(){

        setContentView(R.layout.activity_main);

        // inicijalizacija pogleda
        // TODO Obnoviti XML
        mOutput = (EditText) findViewById(R.id.outputET);
        mSize = (EditText) findViewById(R.id.sizeET);
        mProcessButton = (Button) findViewById(R.id.button);
    }


    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process();
    }

    private void addToEditText(String string){
        mOutput.setText("" + mOutput.getText() + string);
    }

    @Override
    public void print(String text) {
        Log.d(LOG_TAG, "print(String)"); // TODO vezbaj debugovanje
        addToEditText(text);
    }

    @Override
    public void print(char _char) {
        print("" + _char);
    }


    @Override
    public void println(String text) {
        Log.d(LOG_TAG,"println(String)");
        addToEditText(text + "\n");
    }

    @Override
    public void println(char _char) {
        println("" + _char + "\n");
    }


    @Override
    public void resetText() {
        mOutput.setText("");
    }


    @Override
    public void log(String logtext) {
        Log.d(Logic.TAG, logtext);
    }
}
