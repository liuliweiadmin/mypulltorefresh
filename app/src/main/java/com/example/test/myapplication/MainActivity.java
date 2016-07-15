package com.example.test.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.myapplication.adapter.FragmentAdapter;
import com.example.test.myapplication.fragment.ListViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tableLayout;
    ViewPager viewPager;
    private List<Fragment> fragmentList=new ArrayList<>();
    List<String> fragmentNameList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            tableLayout= (TabLayout) findViewById(R.id.tablayout);
            viewPager= (ViewPager) findViewById(R.id.viewpager);
            fragmentList.add(new ListViewFragment());
            fragmentList.add(new ListViewFragment());
            fragmentList.add(new ListViewFragment());
            fragmentList.add(new ListViewFragment());
            fragmentList.add(new ListViewFragment());
            fragmentList.add(new ListViewFragment());
            fragmentNameList.add("ListView");
            fragmentNameList.add("GridView");
            fragmentNameList.add("StaggeredView");
            fragmentNameList.add("ScrollView");
            fragmentNameList.add("ExpandableListView");
            fragmentNameList.add("WebView");
            viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragmentList,fragmentNameList));
            tableLayout.setupWithViewPager(viewPager);
            viewPager.setCurrentItem(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
