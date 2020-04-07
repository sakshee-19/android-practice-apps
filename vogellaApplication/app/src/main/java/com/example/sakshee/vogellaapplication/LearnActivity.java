package com.example.sakshee.vogellaapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener{
    List<Integer> buttons = Arrays.asList(R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six, R.id.seven,
            R.id.eight, R.id.nine, R.id.zero, R.id.delete);
    for(Integer i: buttons) {
        View b = findViewById(i);
        b.setOnClickListener(this); // calling onClick() method

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }

    @Override
    public void onClick(View v) {

    }
}
