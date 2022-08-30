package com.kwad.sdk.api;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.c;
import com.kwad.sdk.api.loader.t;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public class KsAdSDK {
    public static Context mOriginalAppContext;
    public static String sAppTag;
    public static final AtomicBoolean sInited = new AtomicBoolean(false);
    @Keep
    public static IKsAdSDK sSdk;

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
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

    public static Context getApplicationContext(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
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

    @Nullable
    @KsAdSdkApi
    @Keep
    public static synchronized KsLoadManager getLoadManager() {
        synchronized (KsAdSDK.class) {
            if (sSdk != null) {
                return sSdk.getAdManager();
            }
            return null;
        }
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
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        boolean z;
        synchronized (KsAdSDK.class) {
            boolean z2 = true;
            try {
                Context applicationContext = getApplicationContext(context);
                mOriginalAppContext = applicationContext;
                if (applicationContext == null) {
                    applicationContext = null;
                } else {
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    if (applicationContext2 != null) {
                        applicationContext = !applicationContext2.getClassLoader().equals(applicationContext.getClassLoader()) ? new c.a(applicationContext) : applicationContext.getApplicationContext();
                    }
                }
                Loader.get().init(applicationContext);
                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                sSdk = ksAdSDKImpl;
                if (ksAdSDKImpl != null) {
                    if (Loader.get().isExternalLoaded()) {
                        Loader.get().checkAutoRevert();
                    }
                    sSdk.setApiVersion(BuildConfig.VERSION_NAME);
                    sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                    sSdk.setAppTag(sAppTag);
                    sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                    sSdk.init(Wrapper.wrapContextIfNeed(applicationContext), sdkConfig);
                }
                sInited.set(sSdk != null);
                if (sdkConfig != null) {
                    t.c(applicationContext, "sdkconfig", sdkConfig.toJson());
                }
                Boolean bool = (Boolean) b.a("enableDynamic", new Object[0]);
                if (bool == null || !bool.booleanValue()) {
                    z2 = false;
                }
                if (z2) {
                    Loader.get().checkUpdate(sSdk);
                }
                z = sInited.get();
            }
        }
        return z;
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

    public static void re(Object obj) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.re(obj);
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

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }
}
