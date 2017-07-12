package com.lpp.retrofit2.utils;

import android.app.Activity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.lpp.retrofit2.MyApplication;

/**
 * Created by xuyanjun on 15/11/10.
 */
public class MobileUtils {

    public static String getIMEI() {
        TelephonyManager tm = (TelephonyManager) MyApplication.getContext().getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            String imei = tm.getDeviceId();
            if (TextUtils.isEmpty(imei)) {
                return "123123123";
            } else {
                return imei;
            }
        }
        return null;
    }

}
