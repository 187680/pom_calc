package com.example.king.pam_calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2,
            buttonC, buttonBS, buttonDot,
            buttonEqual,
            buttonPlus;

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


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

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

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression current = new Expression(mTextMessage.getText().toString());
                BigDecimal equal = BigDecimal.valueOf(current.calculate());
                mTextMessage.setText(equal.toString());
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText(mTextMessage.getText().toString() + buttonPlus.getText());
            }
        });

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

    private BigDecimal wynikDzialania(TextView myTextView){
        BigDecimal bd = new BigDecimal(1);

        String sign = "";
        Character[] mathOpertators = {'+', '.'};

        for (String findRegex : myTextView.getText().toString().split("")) {
            for (int i = 0; i < mathOpertators.length; i++)
                if (findRegex.charAt(0) == (mathOpertators[i])) {
                    String[] params = myTextView.getText().toString().split(findRegex);
                    BigDecimal b1 = new BigDecimal(params[0]);
                    BigDecimal b2 = new BigDecimal(params[1]);
                }
        }



        return bd;
    }
}
