package com.example.test.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lenovo on 2016/7/15.
 */
public abstract class BaseListAdapter<T> extends BaseAdapter{

    protected List<T> mData;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public BaseListAdapter(Context context,List list){
        this.mContext = context;
        this.mData = list;
        mInflater=LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mData!=null?mData.size():0;
    }

    public View inflate(int resLayout, ViewGroup parent) {
        return mInflater.inflate(resLayout, parent, false);
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);
}
