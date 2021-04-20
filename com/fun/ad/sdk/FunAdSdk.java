package com.fun.ad.sdk;

import a.a.a.a.a;
import a.a.a.a.d;
import a.a.a.a.h;
import a.a.a.a.j;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public final class FunAdSdk {
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    public static final String PLATFORM_KS = "ks";
    public static FunAdCallback funAdCallback = null;
    public static boolean isAdSdkInitialized = false;
    public static FunAdConfig sFunAdConfig;

    /* loaded from: classes6.dex */
    public interface SdkInitializeCallback {
        void onComplete();
    }

    public static FunAdCallback getAdCallback() {
        return funAdCallback;
    }

    public static FunAdFactory getAdFactory() {
        d dVar = d.f1018c;
        return dVar == null ? new d() : dVar;
    }

    public static Context getAppContext() {
        return sFunAdConfig.appContext;
    }

    public static FunAdConfig getFunAdConfig() {
        return sFunAdConfig;
    }

    public static String getPlatformId(String str) {
        return h.a(str);
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2) {
        return init(funAdConfig, funAdCallback2, null);
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2, SdkInitializeCallback sdkInitializeCallback) {
        if (funAdConfig != null) {
            if (funAdConfig.userId != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    if (isAdSdkInitialized) {
                        if (sFunAdConfig.logEnabled) {
                            a.a.a.a.v.d.b("Please don't init FunAdSdk duplicated.", new Object[0]);
                        }
                        return false;
                    }
                    sFunAdConfig = funAdConfig;
                    funAdCallback = funAdCallback2;
                    j.a();
                    j.f1065c = System.currentTimeMillis();
                    j.f1069g = SystemClock.currentThreadTimeMillis();
                    try {
                        Class.forName("com.win.opensdk.PBInitialize");
                    } catch (ClassNotFoundException unused) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成win-norm-xxx-release-xxx.aar");
                    }
                    try {
                        Class.forName("com.qq.e.ads.nativ.NativeUnifiedADDataAdapter");
                    } catch (ClassNotFoundException unused2) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成GDTSDK.unionNormal.xxx.aar");
                    }
                    try {
                        Class.forName("com.kwad.sdk.api.KsAdSDK");
                    } catch (ClassNotFoundException unused3) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成ks_adsdk-xxx.aar");
                    }
                    try {
                        Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
                    } catch (ClassNotFoundException unused4) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成open_ad_sdk.aar");
                    }
                    try {
                        Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
                    } catch (ClassNotFoundException unused5) {
                        a.a("SDK依赖性错误：请在build.gradle里正确集成fun_openid_sdk_xxx.aar");
                    }
                    j.f1063a.f1072b = System.currentTimeMillis() - j.f1065c;
                    j.f1063a.f1073c = SystemClock.currentThreadTimeMillis() - j.f1069g;
                    h.f1039b = sdkInitializeCallback;
                    h.a(true);
                    isAdSdkInitialized = true;
                    j.f1063a.f1076f = System.currentTimeMillis() - j.f1064b;
                    j.f1063a.f1077g = SystemClock.currentThreadTimeMillis() - j.f1068f;
                    j.f1063a.a();
                    return true;
                }
                throw new IllegalStateException("This method could only be called on main thread.");
            }
            throw new IllegalArgumentException("FunAdConfig.userId must not be null!");
        }
        throw new IllegalArgumentException("FunAdConfig must not be null!");
    }

    public static boolean isLogEnabled() {
        FunAdConfig funAdConfig = sFunAdConfig;
        return funAdConfig != null && funAdConfig.logEnabled;
    }

    public static boolean isSdkInitializeComplete() {
        return h.f1043f;
    }
}
