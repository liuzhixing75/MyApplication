package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.model.TestDemo;

/**
 * 数据适配器
 */

public class MyImageAdapter extends BaseAdapter<TestDemo>{

    Context mContext;

    public MyImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHoder = null;

        if(convertView==null){
            convertView = View.inflate(mContext,R.layout.activity_list_item,null);
            viewHoder = new ViewHolder();
            viewHoder.name = (TextView) convertView.findViewById(R.id.name);
            viewHoder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHoder);

        }else{
            viewHoder = (ViewHolder) convertView.getTag();
        }
        TestDemo testDemo = (TestDemo) getItem(position);
        viewHoder.name.setText(testDemo.name);
        viewHoder.text.setText(testDemo.text);
        return convertView;

    }

    class ViewHolder{
        TextView name;
        TextView text;
    }

}
