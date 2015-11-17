package com.converter.craig.androidhigherorlowerapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends ActionBarActivity {

    int randomNumber;
    public void checkGuess(View view){
        EditText guessedNumber = (EditText) findViewById(R.id.guessedNumber);
        String guessedNumberString = guessedNumber.getText().toString();
        int guessedNumberInt;

        try {
            guessedNumberInt = Integer.parseInt(guessedNumberString);
            determineHighLow(guessedNumberInt);
        } catch(NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid Entry, please enter a number!", Toast.LENGTH_LONG).show();
        }
    }

    public void determineHighLow(int guessedNumber){
        String message = "";
        if(guessedNumber > randomNumber){
            message = "Too High!";
        } else if (guessedNumber < randomNumber){
            message = "To Low!";
        } else {
            message = "Correct, well done! A new number has been generated, play again!";
            generateRandomNumber();
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }

    public void generateRandomNumber(){
        Random randomGenerator = new Random();

        randomNumber = randomGenerator.nextInt(21);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
