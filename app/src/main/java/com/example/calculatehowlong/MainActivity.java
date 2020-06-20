package com.example.calculatehowlong;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Guys I don't Why this is causing Error in my Log
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textHours = findViewById(R.id.text_hours);
                String stringHours = textHours.getText().toString();
                EditText textDays = findViewById(R.id.text_days);
                String stringDays = textDays.getText().toString();
                String stringDefaultHours = "4";
                float longUnitDay = Float.parseFloat(stringDays)/ Float.parseFloat(stringDefaultHours);
                float floatAnswer = longUnitDay * Float.parseFloat(stringHours);

                //This is the icing on the cake ... Drum Roll Please

                TextView textAnswer = findViewById(R.id.text_answer);

                textAnswer.setText(Float.toString(floatAnswer) + " Days!");
                String stringLevel = "";
                if (longUnitDay < 1) {
                    stringLevel = "Wow! You Are A Learning Machine";
                } else if (longUnitDay >= 1 && longUnitDay < 2) {
                    stringLevel = "Your Brain Is Hot!";
                } else {
                    stringLevel = "Keep the Pace! You Will Get There";
                }

                // And your Level of Learning
                TextView textLevel = findViewById(R.id.text_level);

                textLevel.setText(stringLevel);

                Snackbar.make(view, "You Will Complete " + stringHours + " Hours of Video in " + Float.toString(floatAnswer) + " Days", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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