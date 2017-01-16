package com.example.administrator.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.administrator.myapplication.util.ImageUtils;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class MyApplication extends Application {


    public static final String TAG = "myTag";

    @Override
    public void onCreate() {
        super.onCreate();
        ImageUtils.buildPicasso(this);
    }
}
