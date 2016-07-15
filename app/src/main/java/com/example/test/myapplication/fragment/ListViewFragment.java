package com.example.test.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.test.myapplication.R;
import com.example.test.myapplication.adapter.ListAdapter;
import com.hx.pulltorefresh.impl.OnLoadMoreListener;
import com.hx.pulltorefresh.view.LoadMoreListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/7/15.
 */
public class ListViewFragment extends BaseFragment {
    @Override
    public int getContentViewLayout() {
        return R.layout.fragment_listview;
    }

    LoadMoreListView listView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (LoadMoreListView) view.findViewById(R.id.listview);
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        listView.setAdapter(new ListAdapter(getActivity(), list));

        listView.setNoLoadMoreHideView(false);
        listView.setHasLoadMore(true);

        listView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                Toast.makeText(getActivity(),"loadmore",Toast.LENGTH_SHORT).show();
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listView.showFailUI();
                        listView.onLoadMoreComplete();
                    }
                },1000);
            }
        });


    }

}
