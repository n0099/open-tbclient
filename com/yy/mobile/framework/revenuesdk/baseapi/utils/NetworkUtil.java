package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.common.others.lang.StringUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes9.dex */
public class NetworkUtil {
    public static NetworkInfo getActiveNetworkFromService(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    return connectivityManager.getActiveNetworkInfo();
                }
                return null;
            } catch (Throwable th) {
                RLog.error("NetworkUtils", "error on getActiveNetworkInfo " + th, new Object[0]);
                return null;
            }
        }
        return null;
    }

    public static boolean isNetworkStrictlyAvailable(Context context) {
        String str;
        String str2;
        String str3;
        try {
            if (context == null) {
                RLog.error(com.huawei.hms.framework.common.NetworkUtil.TAG, "isNetworkStrictlyAvailable context is NULL", new Object[0]);
                return false;
            }
            NetworkInfo activeNetworkFromService = getActiveNetworkFromService(context);
            if (activeNetworkFromService != null && activeNetworkFromService.isAvailable() && activeNetworkFromService.isConnected()) {
                return true;
            }
            if (activeNetworkFromService != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("network type = ");
                sb.append(activeNetworkFromService.getType());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (activeNetworkFromService.isAvailable()) {
                    str2 = "available";
                } else {
                    str2 = "inavailable";
                }
                sb.append(str2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                String str4 = "";
                if (activeNetworkFromService.isConnected()) {
                    str3 = "";
                } else {
                    str3 = "not";
                }
                sb.append(str3);
                sb.append(" connected, ");
                if (!activeNetworkFromService.isConnectedOrConnecting()) {
                    str4 = "not";
                }
                sb.append(str4);
                sb.append(" isConnectedOrConnecting");
                str = sb.toString();
            } else {
                str = "no active network";
            }
            RLog.error(com.huawei.hms.framework.common.NetworkUtil.TAG, "isNetworkStrictlyAvailable network info" + str, new Object[0]);
            return false;
        } catch (Throwable th) {
            RLog.error("NetworkUtils", th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }
}
