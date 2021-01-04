package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher mImageSwitcher;
    Button mBtnStart;
    int[] mArrImages = {R.drawable.hinh1,
                        R.drawable.hinh2,
                        R.drawable.hinh3,
                        R.drawable.hinh4,
                        R.drawable.hinh5,
                        };

    int mCount =0;
    boolean mIsStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageSwitcher = findViewById(R.id.imageSwitcher);
        mBtnStart = findViewById(R.id.buttonStart);

        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);//có thể xóa dòng này
                return imageView;
            }
        });


        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        mImageSwitcher.setOutAnimation(out);
        mImageSwitcher.setInAnimation(in);


        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsStarted == false){

                    CountDownTimer countDownTimer = new CountDownTimer(1200, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            mIsStarted = true;
                            if (millisUntilFinished - 1000>0){
//                            mImageSwitcher.setImageResource(mArrImages[mCount++]);
                                if (mCount >= mArrImages.length){
                                    mCount =0;
                                }
                                mImageSwitcher.setImageResource(mArrImages[mCount++]);
                            }
                        }

                        @Override
                        public void onFinish() {
                            this.start();
                        }
                    };
                    countDownTimer.start();
                }

            }
        });
//        mImageSwitcher.setImageResource(R.drawable.hinh2);



//        mImageSwitcher.setImageResource(mArrImages[0]);


////    COUNNTDOWN đếm ngược
//        CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                if (millisUntilFinished -1000>0){
//
//                    //                Log.d("BBB", millisUntilFinished + "");
//                }
//
//            }
//
//            @Override
//            public void onFinish() {
//                Log.d("BBB", "Finish countdown");
//            }
//        };
//        countDownTimer.start();


    }
}