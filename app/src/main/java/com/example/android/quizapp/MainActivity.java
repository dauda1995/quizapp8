package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends Activity {
    private CheckBox question11, question12, question13;
    private CheckBox question21, question22, question23;
    private CheckBox question31, question32, question33;
    private CheckBox question41, question42, question43;
    private CheckBox question51, question52, question53;
    private CheckBox question61, question62, question63;
    EditText answer_edit;

    boolean check1,check21,check22,check3, check4, check5, check6;
    String ansInput;
    int score=0;
    String name;
    String ans1, ans2, ans3, ans4, ans5, ans6, ans7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize(this);
        name= getIntent().getExtras().getString("name");
        answer_edit=(EditText) findViewById(R.id.edit_answer);



    }

    private void initialize(MainActivity mainActivity) {
        question11=(CheckBox) findViewById(R.id.option_1);
        question12=(CheckBox) findViewById(R.id.option_2);
        question13=(CheckBox) findViewById(R.id.option_3);


        question21=(CheckBox) findViewById(R.id.option_21);
        question22=(CheckBox) findViewById(R.id.option_22);
        question23=(CheckBox) findViewById(R.id.option_23);


        question31=(CheckBox) findViewById(R.id.option_31);
        question32=(CheckBox) findViewById(R.id.option_32);
        question33=(CheckBox) findViewById(R.id.option_33);

        question41=(CheckBox) findViewById(R.id.option_41);
        question42=(CheckBox) findViewById(R.id.option_42);
        question43=(CheckBox) findViewById(R.id.option_43);

        question51=(CheckBox) findViewById(R.id.option_51);
        question52=(CheckBox) findViewById(R.id.option_52);
        question53=(CheckBox) findViewById(R.id.option_53);

        question61=(CheckBox) findViewById(R.id.option_61);
        question62=(CheckBox) findViewById(R.id.option_62);
        question63=(CheckBox) findViewById(R.id.option_63);

        ans1=getResources().getString(R.string.option13);
        ans2="\n" + getResources().getString(R.string.option21) + "\n" + getResources().getString(R.string.option23);
        ans3=getResources().getString(R.string.option31);
        ans4=getResources().getString(R.string.option43);
        ans5=getResources().getString(R.string.option52);
        ans6=getResources().getString(R.string.option61);
        ans7=getResources().getString(R.string.answer);


    }


    public void onCheckboxClicked1(View view) {
        switch (view.getId()){
            case R.id.option_1:
                question12.setChecked(false);
                question13.setChecked(false);
                break;
            case R.id.option_2:
                question13.setChecked(false);
                question11.setChecked(false);
                break;
            case R.id.option_3:
                question11.setChecked(false);
                question12.setChecked(false);

        }
        check1= question13.isChecked();

    }

    public void onCheckboxClicked2(View view) {

        switch (view.getId()) {
            case R.id.option_21:
                if(question22.isChecked()){
                question23.setChecked(false);}
                else if(question23.isChecked()){
                    question22.setChecked(false);
                }else {
                    question22.setChecked(false);
                    question23.setChecked(false);
                }
                break;
            case R.id.option_22:
                if(question21.isChecked()){
                    question23.setChecked(false);}
                else if(question23.isChecked()){
                    question21.setChecked(false);
                }else {
                    question23.setChecked(false);
                    question21.setChecked(false);
                }
                break;
            case R.id.option_23:
                if(question22.isChecked()){
                    question21.setChecked(false);}
                else if(question21.isChecked()) {
                    question22.setChecked(false);
                }else {
                    question21.setChecked(false);
                    question22.setChecked(false);
                }
                break;
        }
        check21= question21.isChecked();
        check22= question23.isChecked();


    }

    public void onCheckboxClicked3(View view) {

        switch (view.getId()) {
            case R.id.option_31:
                question32.setChecked(false);
                question33.setChecked(false);
                break;
            case R.id.option_32:
                question33.setChecked(false);
                question31.setChecked(false);
                break;
            case R.id.option_33:
                question31.setChecked(false);
                question32.setChecked(false);
                break;
        }
        check3= question31.isChecked();
    }

    public void onCheckboxClicked4(View view) {

        switch (view.getId()) {
            case R.id.option_41:
                question42.setChecked(false);
                question43.setChecked(false);
                break;
            case R.id.option_42:
                question43.setChecked(false);
                question41.setChecked(false);
                break;
            case R.id.option_43:
                question41.setChecked(false);
                question42.setChecked(false);
                break;
        }
        check4=question42.isChecked();
    }

    public void onCheckboxClicked5(View view) {

        switch (view.getId()) {
            case R.id.option_51:
                question52.setChecked(false);
                question53.setChecked(false);
                break;
            case R.id.option_52:
                question53.setChecked(false);
                question51.setChecked(false);
                break;
            case R.id.option_53:
                question51.setChecked(false);
                question52.setChecked(false);
                break;
        }

        check5= question52.isChecked();
    }

    public void onCheckboxClicked6(View view) {

        switch (view.getId()) {
            case R.id.option_61:
                question62.setChecked(false);
                question63.setChecked(false);
                break;
            case R.id.option_62:
                question63.setChecked(false);
                question61.setChecked(false);
                break;
            case R.id.option_63:
                question61.setChecked(false);
                question62.setChecked(false);
                break;
        }
        check6= question61.isChecked();

    }

    public void Submit(View view) {
        
        boolean[] arr={check1,check3,check4,check5,check6};
        for(int i=0; i<arr.length; i++){
            if (arr[i]){
                score +=1;

            }
        }

        if(check21 && check22){
            score +=1;
        }
        if (answer_edit.getText().toString().equalsIgnoreCase(ans7)){
            score +=1;
            Log.v("MainActivity", "this is the " + ansInput + ans7);
        }
        Log.v("MainActivity", "this is the " + ansInput + "a" + ans7);
        int percent_score= ((score*100)/6);
        Intent nextpage= new Intent(this, Scorepage.class);
        nextpage.putExtra("score",percent_score);
        nextpage.putExtra("name", name );
        String[] ans_arr={ans1, ans2, ans3, ans4, ans5, ans6, ans7};
        nextpage.putExtra("answers", ans_arr);
        startActivity(nextpage);

    }


}
