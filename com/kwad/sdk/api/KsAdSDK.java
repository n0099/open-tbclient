package com.kwad.sdk.api;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.c;
import com.kwad.sdk.api.loader.q;
import java.util.concurrent.atomic.AtomicBoolean;
@KsAdSdkApi
@Keep
/* loaded from: classes6.dex */
public class KsAdSDK {
    public static String sAppTag;
    public static final AtomicBoolean sInited = new AtomicBoolean(false);
    @Keep
    public static IKsAdSDK sSdk;

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
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getContext();
        }
        return null;
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

    @NonNull
    @KsAdSdkApi
    @Keep
    public static KsLoadManager getLoadManager() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAdManager();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        return "3.3.9";
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        boolean z;
        synchronized (KsAdSDK.class) {
            try {
                Context a2 = c.a(context);
                Loader.get().init(a2);
                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                sSdk = ksAdSDKImpl;
                if (ksAdSDKImpl != null) {
                    ksAdSDKImpl.setApiVersion("3.3.9");
                    sSdk.setApiVersionCode(3030900);
                    sSdk.setAppTag(sAppTag);
                    sSdk.init(Wrapper.wrapContextIfNeed(a2), sdkConfig);
                }
                sInited.set(sSdk != null);
                if (sdkConfig != null) {
                    q.a(a2, "sdkconfig", sdkConfig.toJson());
                }
                if (b.f32131a.booleanValue()) {
                    Loader.get().checkUpdate();
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
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }
}
