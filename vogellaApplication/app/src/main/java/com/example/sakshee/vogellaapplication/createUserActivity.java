package com.example.sakshee.vogellaapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.sakshee.vogellaapplication.R.id.username;

public class createUserActivity extends AppCompatActivity {
    private EditText userName;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        userName = (EditText) findViewById(R.id.username);
        View viewById = findViewById(R.id.female);
        viewById.setAlpha(0.4f);
    }

    public void onClick(View view) {
        finish();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();

        intent.putExtra(User.USER_NAME, userName.getText().toString());
        // TODO replace with real value
        intent.putExtra(User.USER_GENDER, true); // hard-code value for testing

        setResult(RESULT_OK, intent);
        super.finish();
    }
}

