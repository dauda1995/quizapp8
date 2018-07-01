package com.example.android.quizapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by dauda on 6/29/2018.
 */

public class Menu extends Activity {
    String value;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        value=getIntent().getExtras().getString("username");
        Toast toast=Toast.makeText(getApplicationContext(), "welcome " + value + "!",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Beginner(View view) {
        Intent test= new Intent(this, MainActivity.class);
        test.putExtra("name", value);
        startActivity(test);

    }

    public void Intermediate(View view) {

        Toast toast= Toast.makeText(getApplicationContext(),"Sorry! Not Available yet", Toast.LENGTH_SHORT);
        toast.show();

    }

    public void Expert(View view) {

        Toast toast= Toast.makeText(getApplicationContext(), "Sorry! Not Available yet", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onBackPressed(){
        Intent i = new Intent(this, Layout_intro.class);
        startActivity(i);
        return;
    }

}
