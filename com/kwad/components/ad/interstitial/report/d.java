package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class d {

    /* loaded from: classes10.dex */
    public static class a {
        public static final d ls = new d();
    }

    public static d dS() {
        return a.ls;
    }

    public static void a(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        double d;
        try {
            com.kwad.sdk.commercial.b cl = com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG);
            if (z) {
                d = 1.0d;
            } else {
                d = 0.01d;
            }
            com.kwad.sdk.commercial.a.d(cl.i(d).L("ad_sdk_interstitial_play", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j) {
        AdInfo dP = e.dP(adTemplate);
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.dZ(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, String str) {
        AdInfo dP = e.dP(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    public final void v(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }
}
