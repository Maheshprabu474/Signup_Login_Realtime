package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Finger extends AppCompatActivity {


    Button button;
    TextView AadharRedirectText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);

        AadharRedirectText = findViewById(R.id.AadharRedirectText);
        button=findViewById(R.id.print_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BiometricPrompt.PromptInfo promptInfo=new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("please Authenticate")
                        .setDescription("user verification is required")
                        .setNegativeButtonText("cancel")
                        .build();
                getBiometricprompt().authenticate(promptInfo);
            }
        });


        AadharRedirectText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Finger.this, Aadhar.class);
            startActivity(intent);
        }
    });
}

    private BiometricPrompt getBiometricprompt(){
        Executor executor= ContextCompat.getMainExecutor(this);
        BiometricPrompt.AuthenticationCallback callback=new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                Toast.makeText(Finger.this, "Verified", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Finger.this, Aadhar.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        };
        BiometricPrompt biometricPrompt=new BiometricPrompt(this,executor,callback);
        return biometricPrompt;
    }
}






                  //  Toast.makeText(getApplicationContext(), "Login Successful Welcome To Vote", Toast.LENGTH_SHORT).show();
