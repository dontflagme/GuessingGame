package com.kevinnguyen.android.assignmenttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView numberOfGuesses = (TextView) findViewById(R.id.numberOfGuesses);
        Button playAgainBtn = (Button) findViewById(R.id.playAgain);

        Intent intent = getIntent();

        int numberOfGuesssIntent = intent.getIntExtra("numberOfGuesses", 0);

        numberOfGuesses.setText("" + numberOfGuesssIntent);

        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
