package com.example.cronometro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class cronometro extends AppCompatActivity implements View.OnClickListener{
    private Chronometer chronometerj;
    private boolean running;
    private long pausaoff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        chronometerj = (Chronometer) findViewById(R.id.cronometro1);
        chronometerj.setFormat("Time: %");
        chronometerj.setBase(SystemClock.elapsedRealtime());
        chronometerj.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()-chronometer.getBase())>=600000){

                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(cronometro.this, "bing!", Toast.LENGTH_SHORT);
                }
            }
        });


    }

    public void starChronometer (View m){
        if(!running){
            chronometerj.setBase(SystemClock.elapsedRealtime()-pausaoff);
            chronometerj.start();
            running = true;
        }
    }

    public void pausaChronometer (View n){
        if(!running){

            chronometerj.stop();
            pausaoff=SystemClock.elapsedRealtime()-chronometerj.getBase();
            running = false;
        }

    }

    public void stopChronometer (View o){
        if(!running){

            chronometerj.setBase(SystemClock.elapsedRealtime());
            pausaoff=0;
        }

    }

    @Override
    public void onClick(View v){

    }

}