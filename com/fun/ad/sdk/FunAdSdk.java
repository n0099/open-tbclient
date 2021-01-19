package com.fun.ad.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.fun.ad.bc;
import com.fun.ad.bq;
import com.fun.ad.d;
import com.fun.ad.g;
/* loaded from: classes14.dex */
public final class FunAdSdk {
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    public static final String PLATFORM_KS = "ks";
    public static final String SDK_VERSION = "2.4.2";
    public static Context appContext;
    public static FunAdCallback funAdCallback;
    public static FunAdPluginCallback funAdPluginCallback;

    /* loaded from: classes14.dex */
    public static class a implements bq.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdConfig f7789a;

        public a(FunAdConfig funAdConfig) {
            this.f7789a = funAdConfig;
        }

        public void a(String str) {
            com.fun.ad.a aVar = new com.fun.ad.a();
            aVar.a(str);
            g.a(this.f7789a, aVar.f7740a);
            FunAdFactory.getInstance().setSlotIds(aVar.f7741b);
        }
    }

    public static FunAdCallback getAdCallback() {
        return funAdCallback;
    }

    public static String getAdConfigJson(String str) {
        return bq.a(appContext, str);
    }

    public static FunAdFactory getAdFactory() {
        return FunAdFactory.getInstance();
    }

    public static FunAdPluginCallback getAdPluginCallback() {
        return funAdPluginCallback;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static String getPlatformId(String str) {
        return d.a(str);
    }

    public static void init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2) {
        appContext = funAdConfig.getAppContext();
        funAdCallback = funAdCallback2;
        g.a();
        d.a(funAdConfig);
        String a2 = bq.a(appContext, funAdConfig.getAppId());
        if (a2 != null) {
            com.fun.ad.a aVar = new com.fun.ad.a();
            aVar.a(a2);
            g.a(funAdConfig, aVar.f7740a);
            FunAdFactory.getInstance().init(funAdConfig.getAppContext());
            FunAdFactory.getInstance().setSlotIds(aVar.f7741b);
        } else {
            Log.e("FunAdSdk", "未在assets目录下读取到 " + funAdConfig.getAppId() + ".json 配置文件");
        }
        if (funAdConfig.isUseCloudAdConfiguration()) {
            Context context = appContext;
            String appId = funAdConfig.getAppId();
            bq.pFO = new a(funAdConfig);
            HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).postDelayed(new bc(context, appId), 10000L);
        }
    }

    public static void setAdPluginCallback(FunAdPluginCallback funAdPluginCallback2) {
        funAdPluginCallback = funAdPluginCallback2;
    }
}
