package com.example.mrpeter1.appeggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final TextView textView = findViewById(R.id.textView);
        //textView2 = findViewById(R.id.textView2);

        final SeekBar VolumeSeekBar = (SeekBar) findViewById(R.id.VolumeSeekBar);

        VolumeSeekBar.setMax(1000); // nilai maksimal
        VolumeSeekBar.setProgress(200);

        VolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minute = progress / 60;
                int seconds = progress - (minute* 60);

                String secondString = Integer.toString(seconds);
                if (secondString == "0"){
                    secondString = "00";
                }
                textView.setText(Integer.toString(minute)+ ":"+ secondString);

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
