package com.example.mentalhealthapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    // Member variables accessible in all methods of MainActivity.
    Button goodButton;
    Button badButton;
    TextView scoreTextView;
    TextView questionTextView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        goodButton = findViewById(R.id.good_button);
        badButton = findViewById(R.id.bad_button);
        questionTextView = findViewById(R.id.question_text);
        scoreTextView = findViewById(R.id.score_text);
        progressBar = findViewById(R.id.progress_bar);

        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Quiz", "Good button pressed"); // Test that listener is working.
                Toast tmsg = Toast.makeText(getApplicationContext(), "Good clicked", Toast.LENGTH_SHORT);
                tmsg.show();
            }
        });

        badButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Log.d("Quiz", "Bad button pressed"); // Test that listener is working.
            }
        });



    @Override
    public void onStop() {
        super.onStop();

        // TODO: Remove the Firebase event listener on the adapter.

    }
}
