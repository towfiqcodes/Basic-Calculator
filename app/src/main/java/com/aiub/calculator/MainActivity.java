package com.aiub.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView inputTV, resultTV;
    private Button oneBT, twoBT, threeBT, fourBT, fiveBT, sixBT,
            sevenBT, eightBT, nineBT, zeroBT, plusBT, minusBT, multiplyBT, divideBT,
            dotBT, ansBT, clearBT, equalBT, backspaceBT;
    private String input = "";
    private Double result = 0.0;
    private ImageView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization() {
        info=findViewById( R.id.info );
        inputTV = findViewById(R.id.inputTV);
        resultTV = findViewById(R.id.resultTV);
        oneBT = findViewById(R.id.oneBT);
        twoBT = findViewById(R.id.twoBT);
        threeBT = findViewById(R.id.threeBT);
        fourBT = findViewById(R.id.fourBT);
        fiveBT = findViewById(R.id.fiveBT);
        sixBT = findViewById(R.id.sixBT);
        sevenBT = findViewById(R.id.sevenBT);
        eightBT = findViewById(R.id.eightBT);
        nineBT = findViewById(R.id.nineBT);
        zeroBT = findViewById(R.id.zeroBT);
        dotBT = findViewById(R.id.dotBT);
        equalBT = findViewById(R.id.equalBT);
        ansBT = findViewById(R.id.ansBT);
        plusBT = findViewById(R.id.plusBT);
        multiplyBT = findViewById(R.id.multiplyBT);
        divideBT = findViewById(R.id.divideBT);
        minusBT = findViewById(R.id.minusBT);
        clearBT = findViewById(R.id.clearBT);
        backspaceBT = findViewById(R.id.backspaceBT);

        info.setOnClickListener( this );
        oneBT.setOnClickListener(this);
        twoBT.setOnClickListener(this);
        threeBT.setOnClickListener(this);
        fourBT.setOnClickListener(this);
        fiveBT.setOnClickListener(this);
        sixBT.setOnClickListener(this);
        sevenBT.setOnClickListener(this);
        eightBT.setOnClickListener(this);
        nineBT.setOnClickListener(this);
        zeroBT.setOnClickListener(this);
        plusBT.setOnClickListener(this);
        minusBT.setOnClickListener(this);
        multiplyBT.setOnClickListener(this);
        divideBT.setOnClickListener(this);
        dotBT.setOnClickListener(this);
        ansBT.setOnClickListener(this);
        clearBT.setOnClickListener(this);
        equalBT.setOnClickListener(this);
        ansBT.setOnClickListener(this);
        backspaceBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.oneBT) {
            setInput("1");
            //Toast.makeText(getApplicationContext(), "One Pressed", Toast.LENGTH_LONG).show();
        } else if (id == R.id.twoBT) {
            setInput("2");
        } else if (id == R.id.threeBT) {
            setInput("3");
        } else if (id == R.id.fourBT) {
            setInput("4");
        } else if (id == R.id.fiveBT) {
            setInput("5");
        } else if (id == R.id.sixBT) {
            setInput("6");
        } else if (id == R.id.sevenBT) {
            setInput("7");
        } else if (id == R.id.eightBT) {
            setInput("8");
        } else if (id == R.id.nineBT) {
            setInput("9");
        } else if (id == R.id.zeroBT) {
            setInput("0");
        } else if (id == R.id.plusBT) {
            setInput("+");
        } else if (id == R.id.minusBT) {
            setInput("-");
        } else if (id == R.id.divideBT) {
            setInput("/");
        } else if (id == R.id.multiplyBT) {
            setInput("*");
        } else if (id == R.id.dotBT) {
            setInput(".");
        } else if (id == R.id.equalBT) {
            makeCalculation();

        } else if (id == R.id.ansBT) {
            makeAnswer();
        } else if (id == R.id.backspaceBT) {
            removeLastCharacter();
        } else if (id == R.id.clearBT) {
            makeInputClear();
            makeResultClear();
        }else if(id==R.id.info){
            InfoDialogFragment infoDialogFragment=new InfoDialogFragment();
          //  infoDialogFragment;
            infoDialogFragment.show(getSupportFragmentManager(), "Dialog");
        }
    }

    private void makeAnswer() {
        input = String.valueOf(result);
        inputTV.setText(input);
    }

    private void makeCalculation() {
        char[] chars = input.toCharArray();



        if (Character.isDigit(chars[0]) && Character.isDigit( chars[input.length() - 1])){
            for (int i = 0; i < input.length(); i++) {
                if (chars[i] == '+' || chars[i] == '-'
                        || chars[i] == '/' || chars[i] == '*' || chars[i]==' ') {
                    String oneNum = input.substring(0, i);
                    String twoNum = input.substring(i + 1, input.length());

                    Double firstNum = Double.parseDouble(oneNum);
                    Double secondNum = Double.parseDouble(twoNum);



                    makeResult(firstNum, secondNum, chars[i]);
                }

            }
        } else {
            Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
        }
    }

    private void makeResult(Double firstNum, Double secondNum, char aChar) {

        if (aChar == '+') {
            result = firstNum + secondNum;
        } else if (aChar == '-') {
            result = firstNum - secondNum;
        } else if (aChar == '/') {
            result = firstNum / secondNum;
        } else if (aChar == '*') {
            result = firstNum * secondNum;
        }

        makeInputClear();
        resultTV.setText( String.valueOf( result ) );
    }

    private void removeLastCharacter() {
        if (input != null && input.length() > 0) {
            input = input.substring(0, (input.length() - 1));
            inputTV.setText(input);
        }
    }

    private void makeInputClear() {
        input = "";
        inputTV.setText(input);
    }

    private void makeResultClear() {
        result = 0.0;
        resultTV.setText("");
    }

    private void setInput(String s) {
        input = input + s;
        inputTV.setText(input);
        Log.e(TAG, s + " Pressed");
    }

}
