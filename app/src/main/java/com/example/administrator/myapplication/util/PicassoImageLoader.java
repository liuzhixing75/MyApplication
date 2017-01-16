package com.example.administrator.myapplication.util;

import android.app.Activity;
import android.widget.ImageView;

import com.lzy.imagepicker.loader.ImageLoader;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class PicassoImageLoader implements ImageLoader {


    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        Picasso.with(activity)
                .load(new File(path))
                .placeholder(com.lzy.imagepicker.R.mipmap.default_image)
                .error(com.lzy.imagepicker.R.mipmap.default_image)
                .resize(width,height)
                .centerInside()
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
        //清理缓存

    }
}
