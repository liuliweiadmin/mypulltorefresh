package com.example.test.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.myapplication.R;

import java.util.List;

/**
 * Created by lenovo on 2016/7/15.
 */
public class ListAdapter extends BaseListAdapter{

    public ListAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflate(R.layout.item_list,null);
        }
        return convertView;
    }

    class ViewHold{

    }
}
