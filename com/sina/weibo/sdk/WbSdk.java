package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.network.intercept.CommonParamInterception;
import com.sina.weibo.sdk.utils.AidTask;
import java.util.List;
/* loaded from: classes2.dex */
public class WbSdk {
    private static AuthInfo authInfo;
    private static boolean init = false;

    public static void install(Context context, AuthInfo authInfo2) {
        if (!init) {
            if (authInfo2 == null || TextUtils.isEmpty(authInfo2.getAppKey()) || TextUtils.isEmpty(authInfo2.getRedirectUrl())) {
                throw new RuntimeException("please set right app info (appKey,redirect");
            }
            authInfo = authInfo2;
            CommonParamInterception.setAppKey(authInfo2.getAppKey());
            AidTask.getInstance(context).setAppkey(authInfo2.getAppKey());
            AidTask.getInstance(context).aidTaskInit(authInfo.getAppKey());
            init = true;
        }
    }

    public static void checkInit() {
        if (!init) {
            throw new RuntimeException("weibo sdk was not initall! please use: WbSdk.install() in your app Application or your main Activity. when you want to use weibo sdk function, make sure call WbSdk.install() before this function");
        }
    }

    public static AuthInfo getAuthInfo() {
        checkInit();
        return authInfo;
    }

    public static boolean isWbInstall(Context context) {
        Intent intent = new Intent(WeiboAppManager.WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
    }

    public static boolean supportMultiImage(Context context) {
        WbAppInfo wbAppInfo;
        return isWbInstall(context) && (wbAppInfo = WeiboAppManager.getInstance(context).getWbAppInfo()) != null && wbAppInfo.getSupportVersion() >= 10772;
    }
}
