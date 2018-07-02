package com.example.android.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class check extends AppCompatActivity {

    int score;
    int count = 0; // Checks the no. of times back button is pressed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        // gets final score of all previous questions
        score = getIntent().getIntExtra("score", 0);

        displaymessage(score);
    }


    // if back pressed
    public void onBackPressed() {
        count = count + 1;
        if (count == 1) {
            Toast.makeText(getApplicationContext(), R.string.exit, Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }

    //displays final score and comment regarding it
    public void displaymessage(int score) {
        TextView mess = findViewById(R.id.res);
        mess.setText(getString(R.string.scorevalue) + score);
        Toast.makeText(getApplicationContext(),(getString(R.string.scorevalue) + score), Toast.LENGTH_SHORT).show();
        
        if (score <= 4) {
            TextView remark = findViewById(R.id.rem);
            remark.setText(R.string.rem1);1
        }
        else if ((score > 4) && (score <= 8)) {
            TextView remark = findViewById(R.id.rem);
            remark.setText(R.string.rem2);
        }
        else if ((score > 8) && (score <= 10)) {
            TextView remark = findViewById(R.id.rem);
            remark.setText(R.string.rem3);
        }
    }

    // if physical quit button is pressed to finish
    public void fin(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.QUIT)
                .setMessage(R.string.asking)
                .setPositiveButton(R.string.affirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.negate, null)
                .show();

    }

    // sharing info through social media using intent
    public void lend(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = getString(R.string.sharing) + score + getString(R.string.question);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, R.string.app_name);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.via)));
    }
}
