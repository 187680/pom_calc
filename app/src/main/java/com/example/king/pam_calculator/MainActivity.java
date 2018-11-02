package com.example.king.pam_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Boolean ifAddition = false, ifDivision = false, ifMultiplication = false, ifSubtraction = false,
                    ifDividedByZero = false,
                    ifPercentagePress = false;

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
            buttonC, buttonBS, buttonDot,
            buttonEqual,
            buttonPlus, buttonSubtract , buttonDivide, buttonMultiply,
            buttonPercentage;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_standard);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_extended);
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(MainActivity.this, AboutMe.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonC = findViewById(R.id.buttonC);
        buttonBS = findViewById(R.id.buttonBS);
        buttonDot = findViewById(R.id.buttonDot);

        buttonEqual = findViewById(R.id.buttonEqual);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonSubtract  = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonPercentage = findViewById(R.id.buttonPercentage);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(wynikDzialania(mTextMessage));
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText("");
            }
        });

        buttonBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isTextViewEmpty(mTextMessage))
                    mTextMessage.setText(mTextMessage.getText().subSequence(0, mTextMessage.getText().length() - 1));
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText() + buttonDot.getText().toString());
            }
        });


        //Operation Buttons

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!signDublicated(mTextMessage)) {
                    mTextMessage.setText(mTextMessage.getText().toString() + buttonPlus.getText());
                    ifAddition = true;
                }
            }
        });

        buttonSubtract .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!signDublicated(mTextMessage)) {
                    mTextMessage.setText(mTextMessage.getText().toString() + buttonSubtract.getText());
                    ifSubtraction = true;
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!signDublicated(mTextMessage)){
                    mTextMessage.setText(mTextMessage.getText().toString() + buttonMultiply.getText());
                    ifMultiplication = true;
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!signDublicated(mTextMessage)) {
                    mTextMessage.setText(mTextMessage.getText().toString() + buttonDivide.getText());
                    ifDivision = true;
                }
            }
        });


        //Numerical buttons

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button1.getText());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button2.getText());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button3.getText());
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button4.getText());
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button5.getText());
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button6.getText());
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button7.getText());
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button8.getText());
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button9.getText());
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + button0.getText());
            }
        });


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState != null){
            mTextMessage.setText(savedInstanceState.getString("mTextView"));

            ifAddition = savedInstanceState.getBoolean("ifAddition");
            ifSubtraction = savedInstanceState.getBoolean("ifSubtraction");
            ifDivision = savedInstanceState.getBoolean("ifDivision");
            ifMultiplication = savedInstanceState.getBoolean("ifMultiplication");
            ifDividedByZero = savedInstanceState.getBoolean("ifDividedByZero");
        }
    }

    private boolean isTextViewEmpty(TextView myTextView) {
        if (myTextView.getText().length() == 0) {
            return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("mTextView", mTextMessage.getText().toString());

        outState.putBoolean("ifAddition", ifAddition);
        outState.putBoolean("ifSubtraction", ifSubtraction);
        outState.putBoolean("ifDivision", ifDivision);
        outState.putBoolean("ifMultiplication", ifMultiplication);
        outState.putBoolean("ifDividedByZero", ifDividedByZero);
    }

    private String wynikDzialania(TextView myTextView){

        BigDecimal b1 = null,b2 = null;

        Stack<String> params = signSplitter(myTextView);


        switch (params.pop()){
            case "add":
                b2 = new BigDecimal(params.pop());
                b1 = new BigDecimal(params.pop());
                return b1.add(b2).toString();
            case "sub":
                b2 = new BigDecimal(params.pop());
                b1 = new BigDecimal(params.pop());
                return b1.subtract(b2).toString();
            case "mul":
                b2 = new BigDecimal(params.pop());
                b1 = new BigDecimal(params.pop());
                return b1.multiply(b2).toString();
            case "div":
                b2 = new BigDecimal(params.pop());
                b1 = new BigDecimal(params.pop());
                if(ifDividedByZero){
                    ifDividedByZero = false;
                    return "0";
                }else{
                    return b1.divide(b2, BigDecimal.ROUND_HALF_UP).toString();
                }
            default:
                return myTextView.getText().toString();

        }


    }

    private Stack<String> signSplitter(TextView textView){

        String[] params;

        Stack<String> stackParams = new Stack<>();

        if(ifAddition){
            params = textView.getText().toString().split("\\+");
            for (String str : params){
                stackParams.add(str);
            }

            stackParams.add("add");

            ifAddition = false;
        }else if(ifSubtraction){
            params = textView.getText().toString().split("\\-");

            for (String str : params){
                stackParams.add(str);
            }

            stackParams.add("sub");

            ifSubtraction = false;
        }else if(ifMultiplication){
            params = textView.getText().toString().split("\\*");

            for (String str : params){
                stackParams.add(str);
            }

            stackParams.add("mul");

            ifMultiplication = false;
        }else if(ifDivision){
            params = textView.getText().toString().split("\\/");
            if(Integer.parseInt(params[1]) == 0){
                ifDividedByZero = true;
            }
            for (String str : params){
                stackParams.add(str);
            }

            stackParams.add("div");

            ifDivision = false;
        }else{
            stackParams.add("noEntry");
        }


        return stackParams;
    }

    private Boolean signDublicated(TextView textView){

        Character[] signs = {'+', '-','*', '/', '.'};

        if((textView.getText().toString().length()) > 0){
            Character lastChar = textView.getText().toString().charAt(
                    textView.getText().toString().length() -1);

            for (Character sg : signs){
                if(lastChar.equals(sg)){
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }

}


//Dodac zabezpieczenie jezeli mam kropke kropka tylko jezeli mamy liczbe przed
//Jezeli mamy +3 jezeli string spliter ma 2 elemeny dodac 0 jako pierwszy
