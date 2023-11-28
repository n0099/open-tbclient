package com.kwad.components.ad.interstitial.report;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class c {

    /* loaded from: classes10.dex */
    public static class a {
        public static final c lr = new c();
    }

    public static c dQ() {
        return a.lr;
    }

    public static void a(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        double d;
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            return;
        }
        com.kwad.sdk.commercial.b zP = com.kwad.sdk.commercial.b.zP();
        if (z) {
            str = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b cl = zP.cl(str);
        if (z) {
            d = 1.0d;
        } else {
            d = 0.01d;
        }
        com.kwad.sdk.commercial.a.d(cl.i(d).L("ad_sdk_interstitial_load", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public final void b(@NonNull AdTemplate adTemplate, boolean z) {
        int i;
        adTemplate.notNetworkRequest = z;
        InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(3);
        if (adTemplate.notNetworkRequest) {
            i = 2;
        } else {
            i = 1;
        }
        a(false, status.setType(i).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    public final void a(int i, String str, long j) {
        a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public final void a(@NonNull AdTemplate adTemplate, int i) {
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp;
        AdInfo dP = e.dP(adTemplate);
        InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(4);
        if (adTemplate.notNetworkRequest) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        a(false, status.setType(i2).setMaterialType(com.kwad.sdk.core.response.b.a.be(dP)).setRenderDuration(elapsedRealtime).setRenderType(i).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, int i, String str) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, boolean z) {
        int i = 2;
        InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(2);
        if (!z) {
            i = 1;
        }
        a(false, status.setType(i).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void i(long j) {
        a(false, new InterstitialReportInfo().setStatus(1).setPosId(j));
    }

    public final void p(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    public final void q(AdTemplate adTemplate) {
        int i;
        try {
            AdInfo dP = e.dP(adTemplate);
            InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(8);
            if (adTemplate.notNetworkRequest) {
                i = 2;
            } else {
                i = 1;
            }
            a(false, status.setType(i).setMaterialType(com.kwad.sdk.core.response.b.a.be(dP)).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public final void r(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    public final void s(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    public final void t(@NonNull AdTemplate adTemplate) {
        int i;
        InterstitialReportInfo status = new InterstitialReportInfo(adTemplate).setStatus(12);
        if (com.kwad.sdk.core.response.b.b.cR(adTemplate)) {
            i = 3;
        } else {
            i = 1;
        }
        a(true, status.setRenderType(i).setAdTemplate(adTemplate));
    }

    public final void u(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }
}
