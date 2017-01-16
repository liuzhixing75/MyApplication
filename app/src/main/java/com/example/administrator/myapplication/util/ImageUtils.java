package com.example.administrator.myapplication.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import com.example.administrator.myapplication.BuildConfig;
import com.example.administrator.myapplication.MyApplication;
import com.squareup.picasso.Picasso;


public class ImageUtils {

    private static Picasso picasso;

    public static void buildPicasso(Context context) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.loggingEnabled(true);
        builder.indicatorsEnabled(false);
        builder.defaultBitmapConfig(Bitmap.Config.RGB_565);
        if (BuildConfig.DEBUG) {
            builder.listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    Log.e(MyApplication.TAG,uri.toString());
                }
            });
        }
        picasso = builder.build();
    }

    public static Picasso getPicasso() {
        return picasso;
    }
}
