package com.example.mentalhealthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {
    // Member variables here
    private FirebaseAuth mAuth; //This variable to authenticate the user

    // UI references.
    private EditText mPasswordView, mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = findViewById(R.id.login_username);
        mPasswordView = findViewById(R.id.login_password);
        Button StartButton = (Button) findViewById(R.id.start_button);

        StartButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        // This will listen to the enter button on the keyboard.
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.integer.login || id == EditorInfo.IME_NULL) {
                    attemptLogin(mEmailView.getText().toString(), mPasswordView.getText().toString());
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(mEmailView.getText().toString(), mPasswordView.getText().toString());
            }
        });

        // Instance of FirebaseAuth
            mAuth = FirebaseAuth.getInstance();
    }

    // Executed when Sign in button pressed.
    public void signInExistingUser(View v) {
        // Call attemptLogin().
        attemptLogin(mEmailView.getText().toString(), mPasswordView.getText().toString());
    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(this, com.example.mentalhealthapp.RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    // AttemptLogin() method.
    private void attemptLogin(String s, String toString) {
        String email = mEmailView.getText().toString(); // Get email.
        String password = mPasswordView.getText().toString(); // Get password.
        if (email.isEmpty()) // Check so the box isn't left empty by the user.
            if (email.equals("") || password.equals("")) return; // If empty then return.
        Toast.makeText(this, "Logging in....", Toast.LENGTH_SHORT).show();
        // FirebaseAuth to sign in with email & password.
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("firebase", "signInWithEmail () on Complete: " + task.isSuccessful());
                if (!task.isSuccessful()) {
                    Log.d("Firebase", "Problem Signing in: " + task.getException()); // Exception tells us why it wasn't successful.
                    showErrorDialog("There was a problem signing in"); // Will add this method next.
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    finish(); // Finish login activity and start with next one.
                    startActivity(intent);
                }
        }

        });
    }

    // Show error on screen with an alert dialog.
    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



}