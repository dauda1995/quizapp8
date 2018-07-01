package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dauda on 6/29/2018.
 */

public class Layout_intro extends Activity implements View.OnClickListener {
    String username;
    EditText user_name;
    Button continue_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        user_name=(EditText) findViewById(R.id.username_edit);
        continue_btn=(Button) findViewById(R.id.play_btn);
        continue_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        username= user_name.getText().toString();
        Toast toast=Toast.makeText(getApplicationContext(), "welcome " + username + "!",Toast.LENGTH_SHORT);
        toast.show();
        Intent stage= new Intent(this, Menu.class);
        stage.putExtra("username", username);
        startActivity(stage);
    }
}
