package com.sdk.base.module.manager;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.a.a;
/* loaded from: classes6.dex */
public abstract class SDKManager {
    public static boolean closePermission = false;
    public static boolean isStrong = true;
    public static Context mContext = null;
    public static boolean smartTrust = true;
    public static String statisticalTestHost = "";
    public static String testHost = "";
    public static boolean useCache = true;
    public static String userAgent;

    public static void closePermission(boolean z) {
        closePermission = z;
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getStatisticalTestHost() {
        return statisticalTestHost;
    }

    public static String getTestHost() {
        return testHost;
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static void init(Context context, String str) {
        mContext = context;
        a a2 = a.a(context);
        com.sdk.base.framework.f.a.a.c();
        a2.a(null, str);
    }

    public static void init(Context context, String str, String str2) {
        mContext = context;
        a a2 = a.a(context);
        com.sdk.base.framework.f.a.a.c();
        a2.a(str, str2);
    }

    public static boolean isClosePermission() {
        return closePermission;
    }

    public static boolean isIsStrong() {
        return isStrong;
    }

    public static boolean isSmartTrust() {
        return smartTrust;
    }

    public static void setDebug(boolean z) {
        f.f38904b = z;
    }

    public static void setDebugHead(boolean z) {
        f.f38906d = z;
    }

    public static void setIsStrong(boolean z) {
        isStrong = z;
    }

    public static void setSmartTrust(boolean z) {
        smartTrust = z;
    }

    public static void setStatisticalTestHost(String str) {
        statisticalTestHost = str;
    }

    public static void setTestHost(String str) {
        testHost = str;
    }

    public static void setUseCache(boolean z) {
        useCache = z;
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }

    public static <T> void toFailed(CallBack<T> callBack, int i, String str) {
        if (callBack != null) {
            callBack.onFailed(1, i, str, null);
        }
    }

    public static boolean useCache() {
        return useCache;
    }
}
