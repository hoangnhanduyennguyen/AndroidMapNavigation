package com.example.androidmapnavigation;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    TextView textViewEmail;

    @Override
    public void onCreate (Bundle SavedInstanceState) {

        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome();
    }

    public void welcome(){
        // get the data sent by another activity
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String email = extras.getString("email");
            textViewEmail = findViewById(R.id.textViewEmail);
            textViewEmail.setText("Hello "+ email);
        }

    }
}
