package com.lpp.retrofit2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lpp.retrofit2.R;
import com.lpp.retrofit2.business.FindviewInterFace;
import com.lpp.retrofit2.business.LoadingInterface;

/**
 * Created by liupanpan on 2017/7/24.
 * 所有的fragment 的主fragment
 */

public class BaseFragment extends Fragment implements FindviewInterFace, LoadingInterface {
    private View mRoomView;
    private FrameLayout mContainerLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoomView = inflater.inflate(R.layout.fragment_base, null);
        mContainerLayout = mRoomView.findViewById(R.id.fragment_root_view_container);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void onCreateView(View view) {
        if (mContainerLayout.getChildCount() > 0) {
            mContainerLayout.removeAllViews();
        }
        mContainerLayout.addView(view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        bindListener();
        bindData();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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
