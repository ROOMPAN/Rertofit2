package com.lpp.retrofit2.network;

import android.util.Log;

import com.lpp.retrofit2.models.VirtualBean;
import com.lpp.retrofit2.utils.JsonFormat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liupanpan on 2017/6/28.
 */

public class HttpClient {
    //    http://offlintab.firefoxchina.cn/data/master-ii
//    http://sp.kaola.com/api/category/
    private static final String DOMAIN = "http://sp.kaola.com/api/category/";
    private static HttpClient sInstance;
    private Retrofit mRetrofit;
    private ApiManagerService mApi;

    private HttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request signRequest = AddCommOnParamter.signRequest(AddCommOnParamter.addCommon(request));
                long t1 = System.nanoTime();
                System.out.println(String.format("Sending request %s on %s%n%s",
                        request.url(), chain.connection(), request.headers()));
                Response response = chain.proceed(signRequest == null ? request : signRequest);
                long t2 = System.nanoTime();

                ResponseBody responseBody = response.peekBody(1024 * 1024);
                Log.e("intercept: ", String.format("接收响应: [%s] %n返回json:[%s] %.1fms%n%s",
                        response.request().url(),
                        JsonFormat.format(responseBody.string()),
                        (t2 - t1) / 1e6d,
                        response.headers()));

                return response;
            }
        }).build();
        //设置超时
        client.newBuilder().connectTimeout(15, TimeUnit.SECONDS);
        client.newBuilder().readTimeout(15, TimeUnit.SECONDS);
        client.newBuilder().writeTimeout(15, TimeUnit.SECONDS);
        //错误重连
        client.newBuilder().retryOnConnectionFailure(true);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new RxThreadCallAdapater(Schedulers.io(), AndroidSchedulers.mainThread()))
                .client(client)
                .build();
        mApi = mRetrofit.create(ApiManagerService.class);
    }

    public synchronized static HttpClient getInstance() {
        if (sInstance == null) {
            sInstance = new HttpClient();
        }
        return sInstance;
    }

    /**
     * 接口请求头方法
     *
     * @param V330
     * @param categoryId
     * @param subscriber
     */
    public void getVirLi(String V330, String categoryId, NetworkSubscriber subscriber) {
        Log.e("v330", "" + V330 + "ID" + categoryId);
        Observable<VirtualBean> observable = mApi.getVirtualLi(V330, categoryId);
        observable.subscribe(subscriber);
    }

    public void getdefaultdials(NetworkSubscriber subscriber) {
        Observable<VirtualBean> observable = mApi.getdefaultdials();
        observable.subscribe(subscriber);
    }

}
