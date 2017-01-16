package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.util.MyUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    boolean isExit = false;

    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showDialog();
                break;
            case R.id.button2:
                gotoWhere(ImagePickActivity.class);
                break;
            case R.id.button3:
                gotoWhere(ImageSelectActivity.class);
                break;
            case R.id.button4:
                gotoWhere(BottomTabActivity.class);
                break;
            case R.id.button5:
                gotoWhere(NumberProgressActivity.class);
                break;
            case R.id.button6:
                gotoWhere(PullToRefreshActivity.class);
                break;

        }

    }

    public void showDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("测试androidstudio!哈哈!");
        builder.setNegativeButton("取消",null);
        builder.setPositiveButton("确定",null);
        builder.show();
    }

    /**
     * 跳转页面
     * @param clazz
     */
    public void gotoWhere(Class<?> clazz){
        Intent intent = new Intent(MainActivity.this,clazz);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (!isExit) {
                            isExit = true;
                            //Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
                            MyUtil.showShort(getApplicationContext(),"再按一次退出程序");
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    isExit = false;
                                }
                            }, 2000);
                            return false;
                        } else {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            startActivity(intent);
                            finish();
                            System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
