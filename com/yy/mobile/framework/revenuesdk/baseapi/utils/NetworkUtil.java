package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.common.others.lang.StringUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes7.dex */
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
        try {
            if (context == null) {
                RLog.error("NetworkUtil", "isNetworkStrictlyAvailable context is NULL", new Object[0]);
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
                sb.append(activeNetworkFromService.isAvailable() ? "available" : "inavailable");
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                String str2 = "";
                sb.append(activeNetworkFromService.isConnected() ? "" : "not");
                sb.append(" connected, ");
                if (!activeNetworkFromService.isConnectedOrConnecting()) {
                    str2 = "not";
                }
                sb.append(str2);
                sb.append(" isConnectedOrConnecting");
                str = sb.toString();
            } else {
                str = "no active network";
            }
            RLog.error("NetworkUtil", "isNetworkStrictlyAvailable network info" + str, new Object[0]);
            return false;
        } catch (Throwable th) {
            RLog.error("NetworkUtils", th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }
}
