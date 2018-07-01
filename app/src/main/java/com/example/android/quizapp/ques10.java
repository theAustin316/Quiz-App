package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ques10 extends AppCompatActivity {

    int score;
    int count = 0;  // checks the no.of time submit button is clicked

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques10);

        // receive score value from previous activity
        score = getIntent().getIntExtra("score", 0);

        // set showAnswer button as greyed out
        Button button2 = findViewById(R.id.show10);
        button2.setEnabled(false);
    }

    // if back pressed
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }

    // calls next activity
    public void pageend(View view) {
        Intent intent = new Intent(this, check.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    // shows answer if unable to answer it correctly
    public void ans10(View view) {
        ImageView qw = findViewById(R.id.img10);
        TextView qwe = findViewById(R.id.ans10);
        qw.setVisibility(View.INVISIBLE);
        qwe.setVisibility(View.VISIBLE);
    }

    // action of submit button
    public void answer10(View view) {
        Button button2 = findViewById(R.id.show10);
        button2.setEnabled(false);

        RadioGroup radio4;
        radio4 = findViewById(R.id.radio);

        RadioButton op1 = findViewById(R.id.op1);
        RadioButton op2 = findViewById(R.id.op2);
        RadioButton op3 = findViewById(R.id.op3);
        RadioButton op4 = findViewById(R.id.op4);


        // if none are checked
        if (!op1.isChecked() && !op2.isChecked() && !op3.isChecked() && !op4.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.suggest, Toast.LENGTH_LONG).show();
        }

        // right answer given, increment score by 1 and show detailed ansswer
        else if ((op4.isChecked()) && (count == 0)) {
            count = 1;
            radio4.check(R.id.op4);
            ImageView ty = findViewById(R.id.negate);
            ImageView qw = findViewById(R.id.img10);
            ImageView er = findViewById(R.id.appreciate);
            TextView qwe = findViewById(R.id.ans10);
            qw.setVisibility(View.INVISIBLE);
            qwe.setVisibility(View.VISIBLE);
            er.setVisibility(View.VISIBLE);
            ty.setVisibility(View.INVISIBLE);
            score = score + 1;
        }

        // wrong answer given, show answer is set to visible
        else if ((count == 0) && (op1.isChecked() || op3.isChecked() || op2.isChecked())) {
            count = 1;
            radio4.clearCheck();
            ImageView er = findViewById(R.id.appreciate);
            er.setVisibility(View.INVISIBLE);
            ImageView ty = findViewById(R.id.negate);
            ty.setVisibility(View.VISIBLE);
            button2.setEnabled(true);
        }

        // if multiple submissions done
        else if (count == 1) {
            button2.setEnabled(true);
            Toast.makeText(getApplicationContext(), R.string.warn, Toast.LENGTH_SHORT).show();
        }
    }
}
