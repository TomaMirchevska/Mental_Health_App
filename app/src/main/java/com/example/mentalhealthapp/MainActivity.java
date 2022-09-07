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
    // Index variable to retrieve question from an array and  which question is on display.
    int index;
    // Int variable that holds the question id.
    int question;

    // Question Bank.
    private GoodBad[] questionBank = new com.example.mentalhealthapp.GoodBad[] {
            new GoodBad(R.string.question_1, true),
            new GoodBad(R.string.question_2, true),
            new GoodBad(R.string.question_3, false),
            new GoodBad(R.string.question_4, true),
            new GoodBad(R.string.question_5, false),
            new GoodBad(R.string.question_6, true),
            new GoodBad(R.string.question_7, false),
            new GoodBad(R.string.question_8, true),
            new GoodBad(R.string.question_9, true),
            new GoodBad(R.string.question_10, true),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        goodButton = findViewById(R.id.good_button);
        badButton = findViewById(R.id.bad_button);
        questionTextView = findViewById(R.id.question_text);
        scoreTextView = findViewById(R.id.score_text);
        progressBar = findViewById(R.id.progress_bar);
        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);

        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Quiz", "Good button pressed"); // Test that listener is working.
                Toast tmsg = Toast.makeText(getApplicationContext(), "Good clicked", Toast.LENGTH_SHORT);
                tmsg.show();
                changeQuestion();
            }
        });

        badButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Log.d("Quiz", "Bad button pressed"); // Test that listener is working.
                changeQuestion();
            }
        });
    }

    private void changeQuestion() {
        index = (index +1)% questionBank.length; // So each time we answer
        question = questionBank[index].getQuestionID(); // Get the question id of that item in the array.
        questionTextView.setText(question); // Set the text to what that id holds for the question.
    }

    @Override
    public void onStop() {
        super.onStop();

        // TODO: Remove the Firebase event listener on the adapter.

    }


}
