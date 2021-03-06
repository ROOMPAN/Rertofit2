package com.lpp.retrofit2.network;


import com.lpp.retrofit2.models.BaseMessageEntity;
import com.lpp.retrofit2.models.VirtualBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 接口定义api
 */

public interface ApiManagerService {

    /**
     * @param mobile
     * @param type   验证码类型(1注册2找回密码3绑定手机号)
     * @return
     */
    @GET("/common/get_code")
    Observable<BaseMessageEntity> getCode(@Query("mobile") String mobile, @Query("type") int type);


    @GET("frontCategory?")
    Observable<VirtualBean> getVirtualLi(@Query("V330") String V330, @Query("categoryId") String categoryId);

    @GET("defaultdials-0.json")
    Observable<VirtualBean> getdefaultdials();

}
