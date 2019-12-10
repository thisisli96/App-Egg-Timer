package com.example.mrpeter1.appeggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonplayback;
    TextView textView ;
    SeekBar VolumeSeekBar;
    Boolean counterIsActive = false;
    Button goButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){

        textView.setText("0:30");
        VolumeSeekBar.setProgress(30);
        VolumeSeekBar.setEnabled(true);
        countDownTimer.cancel();
        buttonplayback.setText("GO!");
        counterIsActive = false;
    }

    public void timerback (View view){

        if (counterIsActive){

            resetTimer();
        } else {

            counterIsActive = true;
            VolumeSeekBar.setEnabled(false);
            buttonplayback.setText("STOP");
        //}
            countDownTimer = new CountDownTimer(VolumeSeekBar.getProgress()*1000 , 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zaplat);
                mediaPlayer.start();
                resetTimer();
            }
        }.start(); }

    };


    public void updateTimer(int secondleft){

        int minute = secondleft / 60;
        int seconds = secondleft - (minute* 60);

        String secondString = Integer.toString(seconds);
        if (seconds <= 9 ){
            secondString = "0" + secondString;
        }

        textView.setText(Integer.toString(minute)+ ":"+ secondString);
        Log.i("tag", "timer all done" + secondleft);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textView = findViewById(R.id.textView);
      buttonplayback = findViewById(R.id.buttonplayback);
        //textView2 = findViewById(R.id.textView2);

     VolumeSeekBar = findViewById(R.id.VolumeSeekBar);

        VolumeSeekBar.setMax(600); // nilai maksimal
        VolumeSeekBar.setProgress(30);

        VolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser) {
                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //step one

//        VolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                int min = 1;
//                int timesTableNumber;
//
//                if (progress < min) {
//                    timesTableNumber = min;
//                    VolumeSeekBar.setProgress(min);
//                }else {
//                    timesTableNumber = progress;
//                    textView2.setText(timesTableNumber/60);
//                }
//                Log.i("seekbar log = ", Integer.toString(timesTableNumber/60));
//
//                //textView2 = Integer.toString(timesTableNumber));
//
//               // generateTimesTable(timesTableNumber);
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });





    }
}
