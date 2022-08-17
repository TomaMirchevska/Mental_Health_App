package com.example.mentalhealthapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    String[] questionBank = {
            "Question1",
            "Question2",
            "Question3",
            "Question4",
            "Question5",
            "Question6",
            "Question7",
            "Question8",
            "Question9",
            "Question10",
    };

    String[][] optionBank = {
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
            {"option1","option2","option3","option4"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // questionBank[0]
        // optionBank[0][]
    }



    @Override
    public void onStop() {
        super.onStop();

        // TODO: Remove the Firebase event listener on the adapter.

    }

}
