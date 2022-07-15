package com.kwad.sdk;

import android.content.Context;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.report.k;
import com.kwai.adclient.kscommerciallogger.model.d;
import java.util.Random;
/* loaded from: classes5.dex */
public final class c {
    public static Boolean a;
    public static int b;

    public static void a(Context context, long j) {
        if (a(context)) {
            return;
        }
        long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        b++;
        k.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.i, new SDKInitMsg(context).setLaunchIntervalTime(currentTimeMillis).setInitCount(b).setInitStatus(0).toJson());
    }

    public static void a(Context context, d dVar, String str) {
        if (a(context)) {
            return;
        }
        k.a(ILoggerReporter.Category.ERROR_LOG, dVar, new SDKInitMsg(context).setInitCount(b).setErrorReason(str).setInitStatus(2).toJson());
    }

    public static boolean a(Context context) {
        if (a == null) {
            a = Boolean.valueOf(com.kwad.sdk.core.config.d.d(context) > new Random().nextFloat());
        }
        return !a.booleanValue();
    }

    public static void b(Context context, long j) {
        if (a(context)) {
            return;
        }
        k.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.i, new SDKInitMsg(context).setTotalDurationTime(j).setInitCount(b).setInitStatus(1).toJson());
    }
}
