package mooc.vandy.java4android.calculator.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

import mooc.vandy.java4android.calculator.R;
import mooc.vandy.java4android.calculator.logic.Logic;
import mooc.vandy.java4android.calculator.logic.LogicInterface;


public class MainActivity extends
             Activity implements ActivityInterface {

    private Spinner mMathSpinner;


    private Button mCalculate;

    private EditText mValueOne;

    private EditText mValueTwo;

    private EditText mResult;

    private LogicInterface mLogic;

    private ArrayAdapter<CharSequence> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        initializeUI();


        mLogic = (LogicInterface) new Logic(this);
    }

    private void initializeUI(){

        setContentView(R.layout.activity_main);


        mCalculate = (Button) findViewById(R.id.calculate_button);


        mValueOne = (EditText) findViewById(R.id.valueOneEditText);
        mValueTwo = (EditText) findViewById(R.id.valueTwoEditText);


        mMathSpinner = (Spinner) findViewById(R.id.mathSpinner);


        mResult = (EditText) findViewById(R.id.results);


        mAdapter =
            ArrayAdapter.createFromResource(this,
                                            R.array.math_options,
                                            android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mMathSpinner.setAdapter(mAdapter);


        mMathSpinner.setSelection(mAdapter.getPosition("add"));
    }


    public void buttonPressed(View view){

        final int operation = getOperationNumber();


        final int argOne = getValueOne();


        int argTwo = getValueTwo();


        mLogic.process(argOne, argTwo, operation);
    }


    @Override
    public int getValueOne() {
        return Integer.valueOf(mValueOne.getText().toString());
    }


    @Override
    public int getValueTwo() {
        return Integer.valueOf(mValueTwo.getText().toString());
    }


    @Override
    public int getOperationNumber() {
        return Arrays.asList(getResources()
                     .getStringArray(R.array.math_options))
                     // Added 1 to start the selected operation from 1 rather than 0.
                     .indexOf(mMathSpinner.getSelectedItem().toString()) + 1;
    }


    @Override
    public void print(String resultString) {
        mResult.setText(resultString);
    }

    @Override
    public void createToast(String toastText) {
        Toast.makeText(this,toastText,Toast.LENGTH_LONG);
    }
}
