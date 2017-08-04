package com.lpp.retrofit2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lpp.retrofit2.activity.BaseActivity;
import com.lpp.retrofit2.models.VirtualBean;
import com.lpp.retrofit2.network.HttpClient;
import com.lpp.retrofit2.network.ImageLoad;
import com.lpp.retrofit2.network.NetworkSubscriber;

import rx.Subscription;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    protected Subscription subscription;
    private Button bt;
    private ImageView imageView;
    private TextView tv_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setTitleText("首页");
    }

    private void initView() {
        bt = findViewById(R.id.bt);
        imageView = findViewById(R.id.imageView);
        bt.setOnClickListener(this);
        tv_con = findViewById(R.id.tv_con);
        tv_con.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                HttpClient.getInstance().getVirLi("0", "8181", new NetworkSubscriber<VirtualBean>() {
                    @Override
                    public void onNext(VirtualBean data) {
                        super.onNext(data);
                        if (data.isOKCode()) {
                            tv_con.setText(data.getBody().getBrandList().get(0).toString() + "");
                            ImageLoad.into(MainActivity.this, data.getBody().getBrandList().get(0).getBrandLogo(), imageView);
                        } else {
                            Log.e("erro", "" + data.msg);
                        }
                    }
                });
//                HttpClient.getInstance().getdefaultdials(new NetworkSubscriber<defaubean>() {
//                    @Override
//                    public void onNext(defaubean data) {
//                        super.onNext(data);
//                    }
//                });
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
