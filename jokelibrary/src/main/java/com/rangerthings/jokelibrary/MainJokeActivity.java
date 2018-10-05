package com.rangerthings.jokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {

    private TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        tvJoke = findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        if (intent !=null){
            String joke = intent.getStringExtra("jokes");
/*
            Toast.makeText(this, "From intent: " + joke, Toast.LENGTH_LONG).show();
*/
            tvJoke.setText(joke);
        }
    }
}
