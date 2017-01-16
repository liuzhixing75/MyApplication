package com.example.administrator.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.myapplication.MyApplication;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.AFragment;
import com.example.administrator.myapplication.util.DialogUtils;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

/**
 * Created by Administrator on 2016/10/21 0021.
 */

public class BottomTabActivity extends AppCompatActivity {


    PagerBottomTabLayout pagerBottomTabLayout;

    //int[] testColors = {0xFF7BA3A8,0xFFF4F3DE,0xFFBEAD92,0xFFF35A4A,0xFF5B4947};
    int[] testColors = {0xFF00796B,0xFF8D6E63,0xFF2196F3,0xFF607D8B,0xFFF57C00};
    //int[] testColors = {0xFF00796B,0xFF5B4947,0xFF607D8B,0xFFF57C00,0xFFF57C00};

    Controller controller;

    List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        initFragment();

        testBottomTab();


    }

    private void testBottomTab() {

        pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);

        //用TabItemBuilder构建一个导航按钮
        TabItemBuilder tabItemBuilder = new TabItemBuilder(this).create()
                .setDefaultIcon(android.R.drawable.ic_menu_send)
                .setText("信息")
                .setSelectedColor(testColors[0])
                .setTag("A")
                .build();

        //构建导航栏,得到Controller进行后续控制
        controller = pagerBottomTabLayout.builder()
                .addTabItem(tabItemBuilder)
                .addTabItem(android.R.drawable.ic_menu_compass, "位置",testColors[1])
                .addTabItem(android.R.drawable.ic_menu_search, "搜索",testColors[2])
                .addTabItem(android.R.drawable.ic_menu_help, "帮助",testColors[3])
                .addTabItem(android.R.drawable.ic_menu_upload,"上传",testColors[4])
//                .setMode(TabLayoutMode.HIDE_TEXT)
//                .setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .setMode(TabLayoutMode.HIDE_TEXT| TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .build();

//        controller.setMessageNumber("A",2);
//        controller.setDisplayOval(0,true);

        controller.addTabItemClickListener(listener);



    }

    private void initFragment() {

        mFragments = new ArrayList<>();

        mFragments.add(createFragment("A"));
        mFragments.add(createFragment("B"));
        mFragments.add(createFragment("C"));
        mFragments.add(createFragment("D"));
        mFragments.add(createFragment("E"));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
        transaction.add(R.id.frameLayout,mFragments.get(0));
        transaction.commit();



    }

    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag) {
            Log.d(MyApplication.TAG,"++++++++选中onSelected+++++++:"+index+"   TAG: "+tag.toString());

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
            transaction.replace(R.id.frameLayout,mFragments.get(index));
            transaction.commit();

        }

        @Override
        public void onRepeatClick(int index, Object tag) {
            Log.d(MyApplication.TAG,"++++++++重复点击onRepeatClick++++++++++:"+index+"   TAG: "+tag.toString());
            DialogUtils.showDialog(BottomTabActivity.this,"提示","重复点击"+index+"   TAG: "+tag.toString());
        }
    };



    private Fragment createFragment(String content)
    {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content",content);
        fragment.setArguments(bundle);

        return fragment;
    }
}
