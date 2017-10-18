package com.kevinnguyen.android.assignmenttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.kevinnguyen.android.assignmenttwo.R.id.checkBtn;
import static com.kevinnguyen.android.assignmenttwo.R.id.numberOfGuesses;


public class GuessingActivity extends AppCompatActivity {

    int numberOfGuesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        final TextView headingText = (TextView) findViewById(R.id.GuessNumberTxt);
        final EditText guessingEdit = (EditText) findViewById(R.id.userGuess);
        Button checkBtn = (Button) findViewById(R.id.checkBtn);


        Random randomNumber = new Random();
        final int generatedNumber = randomNumber.nextInt(19) + 1;

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess =  guessingEdit.getText().toString();

                if(guess.length() == 0){//if guess is less than 0 display error toast
                    Toast.makeText(getApplicationContext(), "You have to enter in a number, dude or dudet.", Toast.LENGTH_SHORT).show();
                    headingText.setText("The number is: " + generatedNumber);
                }

                else if(Integer.parseInt(guess) > 20 || Integer.parseInt(guess) < 1){//If guess is less tell them to guess higher
                    Toast.makeText(getApplicationContext(), "The number needs to be between 1 and 20", Toast.LENGTH_SHORT).show();
                }

                else if(Integer.parseInt(guess) < generatedNumber){//If guess is less tell them to guess higher
                    Toast.makeText(getApplicationContext(), "The number is higher", Toast.LENGTH_SHORT).show();
                    numberOfGuesses++;
                }

                else if(Integer.parseInt(guess) > generatedNumber){//If guess is less tell them to guess higher
                    Toast.makeText(getApplicationContext(), "The number is lower", Toast.LENGTH_SHORT).show();
                    numberOfGuesses++;
                }



                else{
                    Intent intent = new Intent(GuessingActivity.this, ResultsActivity.class);
                    intent.putExtra("numberOfGuesses", numberOfGuesses);
                    startActivity(intent);
                }
            }
        });
    }
}
