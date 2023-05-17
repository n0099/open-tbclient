package com.kwad.components.splash.monitor;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static volatile a QH;
    public static double QI;
    public static double QJ;

    public a() {
        init();
    }

    public static void W(@NonNull AdTemplate adTemplate) {
        k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).setType(com.kwad.sdk.core.response.a.a.aC(d.bQ(adTemplate)) ? 2 : 1).toJson());
    }

    public static void X(@NonNull AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(4).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setType(com.kwad.sdk.core.response.a.a.aC(bQ) ? 2 : 1).toJson());
    }

    public static void a(@NonNull AdInfo adInfo, int i, String str) {
        k.f(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(2).setPreloadId(com.kwad.sdk.core.response.a.a.az(adInfo)).setCreativeId(com.kwad.sdk.core.response.a.a.z(adInfo)).setFailUrl(com.kwad.sdk.core.response.a.a.aB(adInfo) ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.at(adInfo).materialUrl).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.a.a.aB(adInfo) ? 1 : 2).setType(1).toJson());
    }

    public static void a(String str, boolean z, int i, String str2) {
        k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setPreloadId(str).setErrorMsg(str2).toJson());
    }

    public static boolean b(long... jArr) {
        for (long j : jArr) {
            if (j <= 0 || j >= 60000) {
                return true;
            }
        }
        return false;
    }

    public static void d(@NonNull AdTemplate adTemplate, int i, String str) {
        AdInfo bQ = d.bQ(adTemplate);
        boolean aC = com.kwad.sdk.core.response.a.a.aC(bQ);
        k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(3).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setPreloadId(com.kwad.sdk.core.response.a.a.az(bQ)).setType(aC ? 2 : 1).setFailUrl(aC ? com.kwad.sdk.core.response.a.a.at(bQ).materialUrl : com.kwad.sdk.core.response.a.a.A(bQ)).setErrorCode(i).setErrorMsg(str).toJson());
    }

    public static void f(int i, String str) {
        k.e(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(3).setErrorCode(i).setErrorMsg(str).toJson());
    }

    public static void f(@NonNull AdTemplate adTemplate, long j) {
        AdInfo bQ = d.bQ(adTemplate);
        k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(2).setType(com.kwad.sdk.core.response.a.a.aC(bQ) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setPreloadId(com.kwad.sdk.core.response.a.a.az(bQ)).toJson());
    }

    public static void h(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.a.a.z(d.bQ(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate)));
        }
        k.g(QJ, new SplashMonitorInfo().setRatioCount(QI).setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).toJson());
    }

    public static void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        double bg = com.kwad.sdk.core.config.d.bg(context);
        QJ = bg;
        if (bg > 0.0d) {
            QI = 1.0d / bg;
        }
    }

    public static void l(String str, int i) {
        k.d(QJ, new SplashMonitorInfo().setRatioCount(QI).setPreloadId(str).setStatus(i).toJson());
    }

    public static a qG() {
        if (QH == null) {
            synchronized (a.class) {
                if (QH == null) {
                    QH = new a();
                }
            }
        }
        return QH;
    }

    public static void qH() {
        k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).toJson());
    }

    public static void qI() {
        k.e(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).toJson());
    }

    public final void U(@NonNull AdTemplate adTemplate) {
        if (b(adTemplate.loadDataTime)) {
            return;
        }
        k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setLoadDataTime(adTemplate.loadDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate))).toJson());
    }

    public final void V(@NonNull AdTemplate adTemplate) {
        if (b(adTemplate.loadDataTime, adTemplate.checkDataTime)) {
            return;
        }
        k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(adTemplate.checkDataTime).setLoadAndCheckDataTime(adTemplate.loadDataTime + adTemplate.checkDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate))).toJson());
    }

    public final void a(@NonNull AdInfo adInfo, long j, int i) {
        if (b(j)) {
            return;
        }
        long j2 = 0;
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.aB(adInfo) ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.at(adInfo).materialUrl);
        if (ad != null && ad.exists()) {
            j2 = ad.length();
        }
        k.f(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).setPreloadId(com.kwad.sdk.core.response.a.a.az(adInfo)).setCostTime(j).setCacheValidTime(adInfo.adPreloadInfo.validityPeriod * 1000).setSize(j2).setMaterialType(com.kwad.sdk.core.response.a.a.aB(adInfo) ? 1 : 2).setType(i).setCreativeId(com.kwad.sdk.core.response.a.a.z(adInfo)).toJson());
    }

    public final void b(@NonNull List<AdTemplate> list, long j) {
        if (b(j)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate)));
        }
        k.e(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).toJson());
    }
}
