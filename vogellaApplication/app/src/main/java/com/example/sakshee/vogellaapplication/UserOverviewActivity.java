package com.example.sakshee.vogellaapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sakshee.vogellaapplication.R;
import com.example.sakshee.vogellaapplication.User;


public class UserOverviewActivity extends AppCompatActivity {
    public  static  final int SUB_ACTIVITY_CREATE_USER = 10;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        boolean userExist = false;

        if(!userExist){
            Intent intent = new Intent(this, createUserActivity.class);
            startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);
        }
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == SUB_ACTIVITY_CREATE_USER && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            if(extras!=null){
                String name = extras.getString(User.USER_NAME);
                boolean gender = extras.getBoolean(User.USER_GENDER);
                user = new User(name, gender);
                updateUserInterface();

            }
        }
    }

    private void updateUserInterface() {
    }
}
