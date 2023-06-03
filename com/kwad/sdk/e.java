package com.kwad.sdk;

import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.utils.w;
/* loaded from: classes10.dex */
public final class e {
    public static boolean QW;
    public static long QX;

    public static void f(Throwable th) {
        d.a(KsAdSDKImpl.get().getContext(), com.kwai.adclient.kscommerciallogger.model.a.arO, Log.getStackTraceString(th));
        com.kwad.components.core.b.a.b(th);
        com.kwad.sdk.core.e.b.d("SDKRevertHelper", "onInitError revert");
    }

    public static void qV() {
        if (QW) {
            return;
        }
        QW = true;
        QX = SystemClock.elapsedRealtime();
    }

    public static void qW() {
        if (SystemClock.elapsedRealtime() - QX < 10000) {
            com.kwad.sdk.core.e.b.d("SDKRevertHelper", "onException revert");
            qX();
        }
    }

    public static void qX() {
        w.c(KsAdSDKImpl.get().getContext(), "kssdk_api_pref", "curversion", "");
    }
}
