package com.sdk.base.module.manager;

import android.content.Context;
import androidx.annotation.Keep;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.a.a;
/* loaded from: classes4.dex */
public abstract class SDKManager {
    private static boolean closePermission;
    protected static Context mContext;
    private static String userAgent;
    private static String testHost = "";
    private static String statisticalTestHost = "";
    private static boolean isStrong = true;
    private static boolean useCache = true;

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

    @Keep
    public static void init(Context context, String str) {
        mContext = context;
        a a2 = a.a(context);
        Boolean.valueOf(com.sdk.base.framework.f.a.a.c());
        a2.a(null, str);
    }

    @Keep
    public static void init(Context context, String str, String str2) {
        mContext = context;
        a a2 = a.a(context);
        Boolean.valueOf(com.sdk.base.framework.f.a.a.c());
        a2.a(str, str2);
    }

    public static boolean isClosePermission() {
        return closePermission;
    }

    public static boolean isIsStrong() {
        return isStrong;
    }

    @Keep
    public static void setDebug(boolean z) {
        f.f12821b = z;
    }

    public static void setDebugHead(boolean z) {
        f.d = z;
    }

    public static void setIsStrong(boolean z) {
        isStrong = z;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void toFailed(CallBack<T> callBack, int i, String str) {
        if (callBack != null) {
            callBack.onFailed(1, i, str, null);
        }
    }

    public static boolean useCache() {
        return useCache;
    }
}
