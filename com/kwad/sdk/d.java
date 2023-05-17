package com.kwad.sdk;

import android.content.Context;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.report.k;
/* loaded from: classes9.dex */
public final class d {
    public static int QV;

    public static void a(Context context, com.kwai.adclient.kscommerciallogger.model.d dVar, String str) {
        if (context == null) {
            return;
        }
        k.a(aD(context), ILoggerReporter.Category.ERROR_LOG, dVar, new SDKInitMsg(context).setInitCount(QV).setRatioCount(aE(context)).setErrorReason(str).setInitStatus(2).toJson());
    }

    public static double aD(Context context) {
        return com.kwad.sdk.core.config.d.ba(context);
    }

    public static double aE(Context context) {
        return 1.0d / com.kwad.sdk.core.config.d.ba(context);
    }

    public static void b(Context context, long j) {
        if (context == null) {
            return;
        }
        long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        QV++;
        k.a(aD(context), ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.arG, new SDKInitMsg(context).setLaunchIntervalTime(currentTimeMillis).setRatioCount(aE(context)).setInitCount(QV).setInitStatus(0).toJson());
    }

    public static void c(Context context, long j) {
        if (context == null) {
            return;
        }
        k.a(aD(context), ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.arG, new SDKInitMsg(context).setTotalDurationTime(j).setRatioCount(aE(context)).setInitCount(QV).setInitStatus(1).toJson());
    }
}
