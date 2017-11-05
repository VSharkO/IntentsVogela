package com.example.vsharko.intents;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;




public class CreateUserActivity extends AppCompatActivity {
    boolean male = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        final RadioGroup radioGroup = findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        male = true;
                        RadioButton button = findViewById(R.id.female);
                        button.setAlpha((float)0.4);
                        RadioButton button1 = findViewById(R.id.male);
                        button1.setAlpha((float)1);
                        break;
                    case R.id.female:
                        male = false;
                        RadioButton button2 = findViewById(R.id.male);
                        button2.setAlpha((float)0.4);
                        RadioButton button3 = findViewById(R.id.female);
                        button3.setAlpha((float)1);
                        break;
                }
            }
        });

    }

    public void onClick(View view) {

        finish();
    }

    @Override
    public void finish() {

        EditText userName = findViewById(R.id.name);

        if (male) {
            User.USER_NAME = userName.getText().toString();

            User.USER_GENDER = "Male";

        } else {
            User.USER_NAME = userName.getText().toString();

            User.USER_GENDER = "Female";

        }
        String message = "Creating: " + userName.getText().toString() + ", Gender: " + User.USER_GENDER;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();



        // Prepare data intent
        Intent data = new Intent();
        data.putExtra(User.USER_NAME, User.USER_NAME);
        data.putExtra(User.USER_GENDER, User.USER_GENDER);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        super.finish();
    }
}




