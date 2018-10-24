package com.example.king.pam_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutMe extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        bringMeBackToMainActivity();

    }

    private void bringMeBackToMainActivity(){


        Button aboutMeBackButton = findViewById(R.id.aboutMeBackButton);

        aboutMeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutMe.this, MainActivity.class));
            }
        });
    }

}
