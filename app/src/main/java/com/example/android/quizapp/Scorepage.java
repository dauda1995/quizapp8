package com.example.android.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dauda on 6/29/2018.
 */

public class Scorepage extends Activity {
    TextView score_tv;
    TextView comment_line;
    String user_name;
    int score_line;
    String Q1, Q2, Q3, Q4, Q5, Q6, Q7;
    private String[] ans_arr;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorepage);

        score_tv = (TextView) findViewById(R.id.score_board);
        user_name = getIntent().getExtras().getString("name");
        score_line = getIntent().getExtras().getInt("score");
        score_tv.setText("Score: " + score_line + "%");
        comment_line = (TextView) findViewById(R.id.comment);
        ans_arr = getIntent().getExtras().getStringArray("answers");
        Log.v("Scorepage", String.valueOf(ans_arr));
        Q1 = getResources().getString(R.string.question1);
        Q2 = getResources().getString(R.string.question2);
        Q3 = getResources().getString(R.string.question3);
        Q4 = getResources().getString(R.string.question4);
        Q5 = getResources().getString(R.string.question5);
        Q6 = getResources().getString(R.string.question6);
        Q7 = getResources().getString(R.string.question7);


        if (score_line >= 75) {
            comment_line.setText(user_name + ", Sir wayne says you're Batman!");

        } else if (score_line < 75 && score_line >= 40) {
            comment_line.setText(user_name + ", Sir Batman commends you!");
        } else {
            comment_line.setText(user_name + ", Sir Batman thinks you should try Harder");
        }

    }
    public void showAnswer(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(Scorepage.this).create();
        alertDialog.setTitle("Answers");
        alertDialog.setMessage(Q1 + " : " + ans_arr[0] + "\n" + "\n" + Q2 + " : " + ans_arr[1] + "\n" + "\n" + Q3 + " : " + ans_arr[2] + "\n"  + "\n" + Q4 + " : " + ans_arr[3] + "\n" +  "\n" + Q5 + " : " + ans_arr[4] + "\n" + "\n" + Q6 + " : " + ans_arr[5] + "\n" + "\n" + Q7 + " : " + ans_arr[6]);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alertDialog.show();


    }
    public void onBackPressed(){
        score_line = 0;
        Intent i=new Intent(this, Menu.class);
        i.putExtra("username", user_name );
        startActivity(i);
        return;
    }
    public void reset(View view) {
        score_line = 0;
        Intent i=new Intent(this, Menu.class);
        i.putExtra("username", user_name );
        startActivity(i);
    }
}
