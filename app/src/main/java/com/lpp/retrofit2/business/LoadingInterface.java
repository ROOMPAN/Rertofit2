package com.lpp.retrofit2.business;

/**
 * Created by liupanpan on 2017/8/7.
 */

public interface LoadingInterface {
    void showLoadingView();

    void hideLoadingView();

    void showErrorView(Throwable e);

    void loadSuccess();
}
