package com.hx.pulltorefresh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hx.pulltorefresh.R;
import com.hx.pulltorefresh.impl.ILoadMoreView;


/**
 * 加载更多默认view
 */
public class DefaultLoadMoreView extends RelativeLayout implements ILoadMoreView {

    private TextView mTvMessage;
    private ProgressBar mPbLoading;
    private int viewHeight;

    public DefaultLoadMoreView(Context context) {
        super(context);
        init(context);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = inflate(context, R.layout.loading_view_final_footer_default, null);
        mPbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
        mTvMessage = (TextView) view.findViewById(R.id.tv_loading_msg);



        int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(width, height);
        height = view.getMeasuredHeight();
        width = view.getMeasuredWidth();
        this.viewHeight = height;

        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        addView(view,params);


    }


    @Override
    public void showNormal() {
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setText(R.string.loading_view_click_loading_more);

    }

    @Override
    public void showNoMore() {
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setText(R.string.loading_view_no_more);
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
        mTvMessage.setText(R.string.loading_view_loading);
    }

    @Override
    public void showFail() {
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setText(R.string.loading_view_net_error);
    }

    @Override
    public View getFooterView() {
        return this;
    }

    @Override
    public int getViewHeight() {
        return viewHeight;
    }
}
