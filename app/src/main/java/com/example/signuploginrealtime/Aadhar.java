package com.example.signuploginrealtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Aadhar extends AppCompatActivity {

    EditText userAadhar, userVoter, userNumber;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar);

        userAadhar = findViewById(R.id.laadhaar);
        userVoter = findViewById(R.id.lvoter);
        userNumber = findViewById(R.id.lphone);
        submit = findViewById(R.id.sub_button);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean validateNumber = true;
                if (!validateAadhar() & !validateVoter() & !validateNumber()){

                } else {
                    checkUser();
                }
            }

            private void checkUser() {

                String userUserAadhar = userAadhar.getText().toString().trim();
                String userUserVoter = userVoter.getText().toString().trim();
                String userUserNumber = userNumber.getText().toString().trim();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(Aadhar.this, "You are great!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Aadhar.this, Candidate.class);
                        startActivity(intent);

                    }
                });

            }
        });

    }

    public Boolean validateAadhar(){
        String val = userAadhar.getText().toString();
        if (val.isEmpty()){
            userAadhar.setError("Aadhaar number cannot be empty");
            return false;
        } else {
            userAadhar.setError(null);
            return true;
        }
    }


    public Boolean validateVoter(){
        String val = userVoter.getText().toString();
        if (val.isEmpty()){
            userVoter.setError("Voter Id cannot be empty");
            return false;
        } else {
            userVoter.setError(null);
            return true;
        }
    }

    public Boolean validateNumber(){
        String val = userNumber.getText().toString();
        if (val.isEmpty()){
            userNumber.setError("Number cannot be empty");
            return false;
        } else {
            userNumber.setError(null);
            return true;
        }
    }


}















