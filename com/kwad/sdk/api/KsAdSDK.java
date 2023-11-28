package com.kwad.sdk.api;

import android.content.Context;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.t;
import com.kwad.sdk.api.loader.u;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
@KsAdSdkApi
@Keep
/* loaded from: classes10.dex */
public class KsAdSDK {
    public static Context mOriginalAppContext;
    public static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    public static final AtomicBoolean sHasRest = new AtomicBoolean(false);
    @Keep
    public static IKsAdSDK sSdk;

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes10.dex */
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    @KsAdSdkApi
    @Keep
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion(int i) {
        return i != 1 ? "" : BuildConfig.VERSION_NAME;
    }

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static synchronized KsLoadManager getLoadManager() {
        synchronized (KsAdSDK.class) {
            if (sSdk != null && sHasInit.get()) {
                return sSdk.getAdManager();
            }
            Log.e("KsAdSDK", "please init sdk before getLoadManager");
            return new b();
        }
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    @KsAdSdkApi
    @Keep
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, final SdkConfig sdkConfig) {
        synchronized (KsAdSDK.class) {
            if (context != null && sdkConfig != null) {
                mOriginalAppContext = context;
                try {
                    final Context aw = com.kwad.sdk.api.loader.c.aw(context);
                    if (aw == null) {
                        revertDynamic(new RuntimeException("wrappApp Exception"), context, sdkConfig);
                        return false;
                    }
                    try {
                        IKsAdSDK init = Loader.get().init(aw, KsAdSDK.class.getClassLoader());
                        sSdk = init;
                        init.setApiVersion(BuildConfig.VERSION_NAME);
                        sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                        sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(aw);
                        if (wrapContextIfNeed == null) {
                            revertDynamic(new RuntimeException("wrapContextIfNeed Exception"), aw, sdkConfig);
                            return false;
                        }
                        sSdk.init(wrapContextIfNeed, sdkConfig);
                        sSdk.setAppTag(sAppTag);
                        u.a(aw, sSdk);
                        sHasInit.set(true);
                        com.kwad.sdk.api.a.a.submit(new Runnable() { // from class: com.kwad.sdk.api.KsAdSDK.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                t.b(aw, "sdkconfig", sdkConfig.toJson());
                            }
                        });
                        return sHasInit.get();
                    } catch (Throwable th) {
                        th = th;
                        context = aw;
                        revertDynamic(th, context, sdkConfig);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                if (sdkConfig != null && sdkConfig.ksInitCallback != null) {
                    sdkConfig.ksInitCallback.onFail(0, "context or config is null");
                }
                return false;
            }
        }
    }

    public static void re(Object obj) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.re(obj);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setAdxEnable(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setProgrammaticRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z);
        }
    }

    public static void setThemeMode(int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i);
        }
    }

    public static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        if (sHasRest.get()) {
            return;
        }
        sHasRest.set(true);
        u.aE(context);
        Loader.get().rest();
        Log.d("KSAdSDK", "init appId after reset:" + sdkConfig.appId);
        init(context, sdkConfig);
        if (sSdk != null && sHasInit.get()) {
            re(th);
        }
    }

    public static void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z, i);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z, i);
        }
    }
}
