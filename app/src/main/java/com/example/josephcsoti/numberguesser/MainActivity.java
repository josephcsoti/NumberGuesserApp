package com.example.josephcsoti.numberguesser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int rNum;
    int minNum = 1;
    int maxNum = 100;
    int num;

    int guessCount = 0;

    String Correct = "Correct";
    String Low = "Low";
    String High = "High";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Random Number
        Random rgen = new Random();
        rNum = rgen.nextInt(100)+1;

        //Number Picker
        NumberPicker pickNum = null;
        pickNum = (NumberPicker)findViewById(R.id.numberPicker);
        pickNum.setMinValue(minNum);
        pickNum.setMaxValue(maxNum);
        pickNum.setWrapSelectorWheel(false);

        //Text
        final TextView rank = (TextView) findViewById(R.id.rank);

        final TextView stats = (TextView) findViewById(R.id.stats);

        final TextView value = (TextView) findViewById(R.id.numvalue);

        //Button
        Button buttonOne = (Button) findViewById(R.id.button1);
        final NumberPicker finalPickNum = pickNum;
        buttonOne.setText("Guess");
        buttonOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                num = finalPickNum.getValue();

                if(rNum == num) {
                    guessCount++;
                    rank.setText(Correct);
                    String guessString = String.valueOf(guessCount);
                    stats.setText(guessString);
                    String numString = String.valueOf(rNum);
                    value.setText(numString);
                }

                else {

                    if (rNum >= num) {
                        guessCount++;
                        finalPickNum.setMinValue(num + 1);
                        rank.setText(Low);
                    }
                    else {}

                    if (rNum <= num) {
                        guessCount++;
                        finalPickNum.setMaxValue(num - 1);
                        rank.setText(High);
                    }
                    else{}
                }

            }
        });

        final Button buttonTwo = (Button) findViewById(R.id.reset);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessCount = 0;
                finalPickNum.setMinValue(1);
                finalPickNum.setMaxValue(100);
                value.setText("");
                rank.setText("");
                stats.setText("");
            }
        });
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
