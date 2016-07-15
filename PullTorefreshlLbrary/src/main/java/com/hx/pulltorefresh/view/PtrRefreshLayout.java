package com.hx.pulltorefresh.view;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 下拉刷新，只支持下拉
 * Created by lenovo on 2016/7/15.
 * 参考：http://a.codekk.com/detail/Android/Grumoon/android-Ultra-Pull-To-Refresh%20源码解析
 *       https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh
 *  ptr_header，设置头部 id。
 *  ptr_content，设置内容 id。
 *  ptr_resistance，阻尼系数，默认: 1.7f，越大，感觉下拉时越吃力。
 *  ptr_ratio_of_header_height_to_refresh，触发刷新时移动的位置比例，默认，1.2f，移动达到头部高度 1.2 倍时可触发刷新操作。
 *  ptr_duration_to_close，回弹延时，默认 200ms，回弹到刷新高度所用时间。
 *  ptr_duration_to_close_header，头部回弹时间，默认 1000ms。
 *  ptr_pull_to_fresh， 下拉刷新 / 释放刷新，默认为释放刷新。
 *  ptr_keep_header_when_refresh，刷新是否保持头部，默认值 true。
 */
public class PtrRefreshLayout extends PtrFrameLayout{

    private PtrDefaultHeader ptrDefaultHeader;
    private float ptr_resistance = 1.7f;
    private float ptr_ratio_of_header_height_to_refresh = 1.2f;
    private int ptr_duration_to_close = 200;
    private int ptr_duration_to_close_header = 200;
    private boolean ptr_pull_to_fresh = false;
    private boolean ptr_keep_header_when_refresh = true;


    public PtrRefreshLayout(Context context) {
        super(context);
        initViews();
    }

    public PtrRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public PtrRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }


    private void initViews() {
        //默认格式
        ptrDefaultHeader = new PtrDefaultHeader(getContext());
        setHeaderView(ptrDefaultHeader);
        addPtrUIHandler(ptrDefaultHeader);

        setResistance(ptr_resistance);
        setRatioOfHeaderHeightToRefresh(ptr_ratio_of_header_height_to_refresh);
        setDurationToClose(ptr_duration_to_close);
        setDurationToCloseHeader(ptr_duration_to_close_header);
        setPullToRefresh(ptr_pull_to_fresh);
        setKeepHeaderWhenRefresh(ptr_keep_header_when_refresh);
    }

    public PtrDefaultHeader getHeader() {
        return ptrDefaultHeader;
    }

    /**
     * Specify the last update time by this key string
     *
     * @param key
     */
    public void setLastUpdateTimeKey(String key) {
        if (ptrDefaultHeader != null) {
            ptrDefaultHeader.setLastUpdateTimeKey(key);
        }
    }

    /**
     * Using an object to specify the last update time.
     *
     * @param object
     */
    public void setLastUpdateTimeRelateObject(Object object) {
        if (ptrDefaultHeader != null) {
            ptrDefaultHeader.setLastUpdateTimeRelateObject(object);
        }
    }

}
