package com.example.administrator.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.model.TestDemo;

/**
 * Created by Administrator on 2016/10/18 0018.
 */

public class ListDatailActivity extends AppCompatActivity {

    TestDemo testDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        TextView detail = (TextView) findViewById(R.id.detail);
        testDemo = (TestDemo) getIntent().getSerializableExtra(ImagePickActivity.MY_DATA);
        detail.setText("+++++"+testDemo.name+"++++"+testDemo.text);

    }


}
