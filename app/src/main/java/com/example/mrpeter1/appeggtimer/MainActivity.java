package com.example.mrpeter1.appeggtimer;

import androidx.appcompat.app.AppCompatActivity;

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
    public void timerback (View view){
        CountDownTimer countDownTimer = new CountDownTimer(VolumeSeekBar.getProgress()*1000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                Log.i("tag", "timer all done");
            }
        }.start();

    };


    public void updateTimer(int secondleft){

        int minute = secondleft / 60;
        int seconds = secondleft - (minute* 60);

        String secondString = Integer.toString(seconds);
        if (seconds <= 9 ){
            secondString = "0" + secondString;
        }
        textView.setText(Integer.toString(minute)+ ":"+ secondString);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textView = findViewById(R.id.textView);
      buttonplayback = findViewById(R.id.buttonplayback);
        //textView2 = findViewById(R.id.textView2);

     VolumeSeekBar = findViewById(R.id.VolumeSeekBar);

        VolumeSeekBar.setMax(1000); // nilai maksimal
        //VolumeSeekBar.setProgress(0);

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
