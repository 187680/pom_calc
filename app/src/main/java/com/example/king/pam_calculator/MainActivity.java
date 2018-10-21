package com.example.king.pam_calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Boolean ifAddition = false;

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
            buttonC, buttonBS, buttonDot,
            buttonEqual,
            buttonPlus, buttonMinus, buttonDivide, buttonMultiply;

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
                    mTextMessage.setText(R.string.title_about);
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
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);



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
                mTextMessage.setText(mTextMessage.getText() + ".");
            }
        });


        //Operation Buttons

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + buttonPlus.getText());
                ifAddition = true;
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + buttonMinus.getText());
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + buttonMultiply.getText());
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + buttonDivide.getText());
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
    }

    private boolean isTextViewEmpty(TextView myTextView) {
        if (myTextView.getText().length() == 0) {
            return true;
        }
        return false;
    }

    private String wynikDzialania(TextView myTextView){

        BigDecimal b1 = null,b2 = null;

        Stack<String> params = signSplitter(myTextView);


        switch (params.pop()){
            case "add":
                b1 = new BigDecimal(params.pop());
                b2 = new BigDecimal(params.pop());
                break;
        }

        return b1.add(b2).toString();
    }

    private Stack<String> signSplitter(TextView textView){

        String[] params = textView.getText().toString().split("\\+");

        Stack<String> stackParams = new Stack<>();

        for (String str : params){
            stackParams.add(str);
        }

        if(ifAddition == true){
            stackParams.add("add");
            ifAddition = false;
        }


        return stackParams;
    }

}


//10 liczb
//+ - * / , =