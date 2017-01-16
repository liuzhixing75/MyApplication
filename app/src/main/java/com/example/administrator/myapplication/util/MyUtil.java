package com.example.administrator.myapplication.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/14 0014.
 */

public class MyUtil {
    /**
     * 长显示
     * @param context 上下文
     * @param message  信息
     */
    public static void showLong(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    /**
     * 短显示
     * @param context 上下文
     * @param message 信息
     */
    public static void showShort(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

}
