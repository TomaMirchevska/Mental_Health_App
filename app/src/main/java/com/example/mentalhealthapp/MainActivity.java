package com.example.mentalhealthapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }



    @Override
    public void onStop() {
        super.onStop();

        // TODO: Remove the Firebase event listener on the adapter.

    }

}
