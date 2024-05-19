package com.example.signuploginrealtime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Candidate extends AppCompatActivity {

    TextView name, party;
    Button vote_btn;
    FirebaseDatabase database;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        name = findViewById(R.id.vote_name);
        party = findViewById(R.id.vote_party);
        vote_btn = findViewById(R.id.vote_btn);


        vote_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validateNumber = false;
                if (!validatename() & !validateparty()) {

                } else {
                    checkUser();
                }
            }

            private void checkUser() {

                String userUsername = name.getText().toString().trim();
                String userUserparty = party.getText().toString().trim();

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users1");

                String Name = name.getText().toString();
                String Party = party.getText().toString();


                HelperClasse helperClass = new HelperClasse(Name, Party);
                reference.child(Party).setValue(helperClass);

                Toast.makeText(Candidate.this, "You have voted successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Candidate.this, finalActivity.class);
                startActivity(intent);
            }
        });
    }


        public Boolean validatename(){
            String val = name.getText().toString();
            if (val.isEmpty()){
                name.setError("name cannot be empty");
                return false;
            } else {
                name.setError(null);
                return true;
            }
        }


        public Boolean validateparty(){
            String val = party.getText().toString();
            if (val.isEmpty()){
                party.setError("party cannot be empty");
                return false;
            } else {
                party.setError(null);
                return true;
            }
        }

}