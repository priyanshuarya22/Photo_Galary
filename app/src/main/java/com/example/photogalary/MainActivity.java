package com.example.photogalary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //initialisation of views
    ImageView imageView;
    Button button;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating objects
        imageView = findViewById(R.id.iv1);
        button = findViewById(R.id.b1);
        //creating array of images
        int[] img = new int[]{R.drawable.picture2, R.drawable.picture3, R.drawable.picture1};
        //setting listener on start/stop button
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //checking condition that button is on start
                if(button.getText().equals("Start")) {
                    //setting button text to stop
                    button.setText("Stop");
                    //creating countdown timer
                    countDownTimer = new CountDownTimer(3600000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            //function returning image
                            int i = setImage();
                            //setting image on imageview
                            imageView.setImageResource(i);
                        }

                        //function for returning a random image
                        private int setImage() {
                            Random r = new Random();
                            //returning a random number between 0 and 3
                            int i1 = r.nextInt(3);
                            //retuning image
                            return img[i1];
                        }

                        @Override
                        public void onFinish() {

                        }
                    };
                    //starting countdown
                    countDownTimer.start();
                }
                //condition if timer is running
                else {
                    //canceling the timer
                    countDownTimer.cancel();
                    //setting text to button
                    button.setText("Start");
                }
            }
        });
    }
}