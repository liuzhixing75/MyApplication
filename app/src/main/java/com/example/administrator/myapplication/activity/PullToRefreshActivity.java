package com.example.administrator.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.MyImageAdapter;
import com.example.administrator.myapplication.model.TestDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
public class PullToRefreshActivity extends AppCompatActivity {

    MyImageAdapter myImageAdapter;
    PtrClassicFrameLayout ptrFrameLayout;

    List<TestDemo> list =new ArrayList<>();;
    ListView refreshList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltofresh);
        ptrFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.freshlayout);
        refreshList = (ListView) findViewById(R.id.freshlistview);
        myImageAdapter = new MyImageAdapter(this);
        myImageAdapter.setmDataList(getData());
        refreshList.setAdapter(myImageAdapter);
        ptrFrameLayout.setLastUpdateTimeRelateObject(this);
        ptrFrameLayout.setLoadingMinTime(1000);
        ptrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrFrameLayout.autoRefresh();
            }
        },100);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,content,header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //刷新数据
                updateData();
            }
        });

    }

    private void updateData() {

        ptrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                TestDemo demo = new TestDemo();
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                demo.text="content"+randomNumber;
                demo.name="fresh"+randomNumber;
                list.add(demo);
                myImageAdapter.setmDataList(list);
                ptrFrameLayout.refreshComplete();
            }
        },0);

    }

    private List<TestDemo> getData() {
        for (int i=0;i<3;i++){
            TestDemo testDemo = new TestDemo();
            testDemo.name = i+"name";
            testDemo.text = i+"text";
            list.add(testDemo);
        }
        return list;
    }
}
