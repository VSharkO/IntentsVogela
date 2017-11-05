package com.example.vsharko.intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserOverviewActivity extends AppCompatActivity {
    public static final int SUB_ACTIVITY_CREATE_USER = 10;
    public static final int SUB_ACTIVITY_LEARN = 20;
    private static final int REQUEST_LEARN_MATH = 10;
    private User user;
    boolean userExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_overview);

        if (user == null) {
            userExists = false;
        }// TODO check persistence if user exists and load the existing one
        else {
            TextView name = findViewById(R.id.name);
            name.setText(user.name);
        }
        // if no user found, create a new one
        if (!userExists) {

            Intent intent = new Intent(this, CreateUserActivity.class);
            startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);
        }
    }

    // This is the callback for the started sub-activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SUB_ACTIVITY_CREATE_USER && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String name = extras.getString(User.USER_NAME);
                boolean gender = extras.getBoolean(User.USER_GENDER);
                user = new User(name, gender);
                updateUserInterface();
            }
        }
        if (resultCode == RESULT_OK && requestCode == SUB_ACTIVITY_LEARN) {
            if (data.hasExtra("skillLevel")) {
                int result = data.getExtras().getInt("skillLevel");
                if((result-user.skillPoints)>9){
                    user.skillPoints = result;
                    Toast.makeText(this, "New Skill level " + String.valueOf(result), Toast.LENGTH_SHORT).show();

                }




            }
        }

    }

    private void updateUserInterface() {
        // TODO show the new user values in the UI
        TextView nameis = findViewById(R.id.username);
        TextView genderis = findViewById(R.id.genderer);

        nameis.setText(User.USER_NAME);
        genderis.setText(User.USER_GENDER);

    }

    public void onClick(View view) {
        if (user == null) {
            userExists = false;
        }// TODO check persistence if user exists and load the existing one
        else {
            userExists=true;
        }
        // if no user found, create a new one
        if (!userExists) {

            Intent intent = new Intent(this, CreateUserActivity.class);
            startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);
        }else{
           Intent intent = new Intent(this,LearnActivity.class);
           intent.putExtra(User.USER_SKILL_POINTS, user.skillPoints);
           startActivityForResult(intent,SUB_ACTIVITY_LEARN);
        }


    }
}

