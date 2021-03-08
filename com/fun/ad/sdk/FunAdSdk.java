package com.fun.ad.sdk;

import a.a.a.a.a;
import a.a.a.a.e;
import a.a.a.a.i;
import a.a.a.a.k;
import a.a.a.a.v.d;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
/* loaded from: classes4.dex */
public final class FunAdSdk {
    public static final String PLATFORM_BAIDU = "baidu";
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    public static final String PLATFORM_KS = "ks";
    public static FunAdCallback funAdCallback;
    public static boolean isAdSdkInitialized;
    public static FunAdConfig sFunAdConfig;

    /* loaded from: classes4.dex */
    public interface SdkInitializeCallback {
        void onComplete();
    }

    public static FunAdCallback getAdCallback() {
        return funAdCallback;
    }

    public static FunAdFactory getAdFactory() {
        e eVar = e.zr;
        return eVar == null ? new e() : eVar;
    }

    public static Context getAppContext() {
        return sFunAdConfig.appContext;
    }

    public static FunAdConfig getFunAdConfig() {
        return sFunAdConfig;
    }

    public static String getPlatformId(String str) {
        return i.a(str);
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2) {
        return init(funAdConfig, funAdCallback2, null);
    }

    public static boolean isLogEnabled() {
        FunAdConfig funAdConfig = sFunAdConfig;
        return funAdConfig != null && funAdConfig.logEnabled;
    }

    public static boolean isSdkInitializeComplete() {
        return i.f;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2, SdkInitializeCallback sdkInitializeCallback) {
        if (funAdConfig != null) {
            if (funAdConfig.userId != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    if (isAdSdkInitialized) {
                        if (sFunAdConfig.logEnabled) {
                            d.b("Please don't init FunAdSdk duplicated.", new Object[0]);
                            return false;
                        }
                        return false;
                    }
                    sFunAdConfig = funAdConfig;
                    funAdCallback = funAdCallback2;
                    k.a();
                    k.c = System.currentTimeMillis();
                    k.g = SystemClock.currentThreadTimeMillis();
                    try {
                        Class.forName("com.win.opensdk.PBInitialize");
                    } catch (ClassNotFoundException e) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成win-norm-xxx-release-xxx.aar");
                    }
                    try {
                        Class.forName("com.baidu.mobads.AdView");
                    } catch (ClassNotFoundException e2) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成Baidu_MobAds_SDK-release.aar");
                    }
                    try {
                        Class.forName("com.qq.e.ads.nativ.NativeUnifiedADDataAdapter");
                    } catch (ClassNotFoundException e3) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成GDTSDK.unionNormal.xxx.aar");
                    }
                    try {
                        Class.forName("com.kwad.sdk.api.KsAdSDK");
                    } catch (ClassNotFoundException e4) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成ks_adsdk-xxx.aar");
                    }
                    try {
                        Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
                    } catch (ClassNotFoundException e5) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成open_ad_sdk.aar");
                    }
                    try {
                        Class.forName("com.fun.openid.sdk.b");
                    } catch (ClassNotFoundException e6) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成fun_openid_sdk_xxx.aar");
                    }
                    k.zO.b = System.currentTimeMillis() - k.c;
                    k.zO.c = SystemClock.currentThreadTimeMillis() - k.g;
                    i.zD = sdkInitializeCallback;
                    i.a(true);
                    isAdSdkInitialized = true;
                    k.zO.f = System.currentTimeMillis() - k.b;
                    k.zO.g = SystemClock.currentThreadTimeMillis() - k.f;
                    k.zO.a();
                    return true;
                }
                throw new IllegalStateException("This method could only be called on main thread.");
            }
            throw new IllegalArgumentException("FunAdConfig.userId must not be null!");
        }
        throw new IllegalArgumentException("FunAdConfig must not be null!");
    }
}
