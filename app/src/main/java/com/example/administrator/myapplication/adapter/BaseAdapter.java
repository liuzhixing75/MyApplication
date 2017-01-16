package com.example.administrator.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17 0017.
 */

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter{

    public BaseAdapter() {
        super();
    }

    List<T> mDataList = new ArrayList<>();

    public void setmDataList(List<T> mDataList) {
        this.mDataList.clear();
        this.mDataList.addAll(mDataList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
