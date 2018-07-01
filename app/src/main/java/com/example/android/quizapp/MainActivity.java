package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // calls new page
    public void newpage(View view) {
        Intent intent = new Intent(this, ques1.class);
        startActivity(intent);
        finish();
    }

    // popup Activity generated for giving quiz instructions
    public void instruct(View view) {
        Intent intent = new Intent(this, pop.class);
        startActivity(intent);
    }

}
