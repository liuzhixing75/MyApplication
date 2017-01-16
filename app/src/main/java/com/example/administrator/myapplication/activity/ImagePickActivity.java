package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.MyImageAdapter;
import com.example.administrator.myapplication.model.TestDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public class ImagePickActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    MyImageAdapter myImageAdapter;

    public static final String MY_DATA = "TestDemo";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_select);
        ListView listView = (ListView) findViewById(R.id.listview);
        myImageAdapter = new MyImageAdapter(this);
        myImageAdapter.setmDataList(getData());
        listView.setAdapter(myImageAdapter);
        listView.setOnItemClickListener(this);

    }

    private List<TestDemo> getData() {
        List<TestDemo> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            TestDemo testDemo = new TestDemo();
            testDemo.name = i+"name";
            testDemo.text = i+"text";
            list.add(testDemo);
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TestDemo testDemo = (TestDemo) parent.getAdapter().getItem(position);
        Intent intent = new Intent(ImagePickActivity.this,ListDatailActivity.class);
        //intent携带数据跳转
        intent.putExtra(ImagePickActivity.MY_DATA,testDemo);
        startActivity(intent);

    }
}
