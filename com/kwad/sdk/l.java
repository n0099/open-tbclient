package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes10.dex */
public final class l {
    public static boolean akH;
    public static long akI;

    public static void a(Throwable th, String str) {
        k.a(com.kwai.adclient.kscommerciallogger.model.a.aSl, str);
        com.kwad.components.core.d.a.b(th);
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onInitError revert");
    }

    public static void at(Context context) {
        if (SystemClock.elapsedRealtime() - akI < 10000) {
            com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onException revert");
            au(context);
        }
    }

    public static void au(Context context) {
        b(context, "curversion", "");
    }

    public static SdkConfig av(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(c(context, "sdkconfig", ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            sdkConfig = null;
        }
        if (sdkConfig == null) {
            return new SdkConfig.Builder().build();
        }
        return sdkConfig;
    }

    public static void checkInitSDK(Context context) {
        try {
            if (KsAdSDKImpl.get().hasInitFinish()) {
                return;
            }
            KsAdSDK.init(context, av(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.b(th);
        }
    }

    public static void l(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }

    public static void b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void yN() {
        if (akH) {
            return;
        }
        akH = true;
        akI = SystemClock.elapsedRealtime();
    }
}
