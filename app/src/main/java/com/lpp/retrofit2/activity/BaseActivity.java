package com.lpp.retrofit2.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lpp.retrofit2.R;
import com.lpp.retrofit2.business.FindviewInterFace;
import com.lpp.retrofit2.business.LoadingInterface;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import rx.Subscription;


/**
 * Created by liupanpan on 2017/7/31.
 */

public class BaseActivity extends SwipeBackActivity implements FindviewInterFace, LoadingInterface {
    protected Subscription subscription;
    private TextView title_text;
    private RelativeLayout mRoomView;
    private FrameLayout contrans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoomView = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_base, null);
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
        findViews();
        bindListener();
        bindData();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void findViews() {

    }

    @Override
    public void bindListener() {

    }

    @Override
    public void bindData() {

    }

    @Override
    public void reLoad() {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void showErrorView(Throwable e) {

    }

    @Override
    public void loadSuccess() {

    }
}
