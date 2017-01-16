package com.example.administrator.myapplication.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class DialogUtils {


    static AlertDialog.Builder builder;

    public static void showDialog(Context context,String title,String msg){
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("确定",null);
        builder.show();
    }
}
