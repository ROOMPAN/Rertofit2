package com.lpp.rertofit2.network;

import android.util.Log;

import com.lpp.rertofit2.models.BaseEntity;

import rx.Subscriber;

/**
 * Created by liupanpan on 17/6/29.
 */
public class NetworkSubscriber<T extends BaseEntity>  extends Subscriber<T> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        Log.d("data_erro",e.toString());
    }

    @Override
    public void onNext(T data) {
    }
}
