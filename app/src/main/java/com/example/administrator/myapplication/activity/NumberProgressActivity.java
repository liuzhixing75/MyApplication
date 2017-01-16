package com.example.administrator.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.util.MyUtil;
import com.example.administrator.myapplication.view.NumberProgressBar;
import com.example.administrator.myapplication.view.OnProgressBarListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public class NumberProgressActivity extends AppCompatActivity implements OnProgressBarListener {

    private Timer timer;

    NumberProgressBar numberProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        numberProgressBar = (NumberProgressBar) findViewById(R.id.numberbar1);
        numberProgressBar.setOnProgressBarListener(this);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        numberProgressBar.incrementProgressBy(1);
                    }
                });

            }
        },1000,200);

    }

    @Override
    public void onProgressChange(int current, int max) {
        if(current==max){
            MyUtil.showShort(this,"结束");
            numberProgressBar.setProgress(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
