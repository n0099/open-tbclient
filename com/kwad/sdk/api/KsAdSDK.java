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
/* loaded from: classes3.dex */
public class KsAdSDK {
    private static String sAppTag;
    @Keep
    private static IKsAdSDK sSdk = null;
    private static final AtomicBoolean sInited = new AtomicBoolean(false);

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        if (sSdk != null) {
            sSdk.deleteCache();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        if (sSdk != null) {
            return sSdk.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        if (sSdk != null) {
            return sSdk.getAppName();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        if (sSdk != null) {
            return sSdk.getContext();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        if (sSdk != null) {
            return sSdk.getDid();
        }
        return null;
    }

    @NonNull
    @KsAdSdkApi
    @Keep
    public static KsLoadManager getLoadManager() {
        if (sSdk != null) {
            return sSdk.getAdManager();
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
            Context a2 = c.a(context);
            Loader.get().init(a2);
            sSdk = Loader.get().getKsAdSDKImpl();
            if (sSdk != null) {
                sSdk.setApiVersion("3.3.9");
                sSdk.setApiVersionCode(3030900);
                sSdk.setAppTag(sAppTag);
                sSdk.init(Wrapper.wrapContextIfNeed(a2), sdkConfig);
            }
            sInited.set(sSdk != null);
            if (sdkConfig != null) {
                q.a(a2, "sdkconfig", sdkConfig.toJson());
            }
            if (b.f8177a.booleanValue()) {
                Loader.get().checkUpdate();
            }
            z = sInited.get();
        }
        return z;
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        if (sSdk != null) {
            return sSdk.isDebugLogEnable();
        }
        return false;
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        if (sSdk != null) {
            sSdk.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        if (sSdk != null) {
            sSdk.unInit();
        }
        sSdk = null;
    }
}
