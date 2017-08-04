package com.lpp.retrofit2.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lpp.retrofit2.R;

/**
 * Created by liupanpan on 2017/7/31.
 */

public class BaseActivity extends FragmentActivity {

    private TextView title_text;
    private RelativeLayout mRoomView;
    private FrameLayout contrans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoomView = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_base, null);
        initView();
    }

    private void initView() {
        title_text = mRoomView.findViewById(R.id.activity_base_title_text);
        contrans = mRoomView.findViewById(R.id.activity_base_contrans);
    }

    public void setTitleText(String titleText) {
        if (!TextUtils.isEmpty(titleText)) {
            title_text.setText(titleText);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, contrans);
        super.setContentView(mRoomView);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
