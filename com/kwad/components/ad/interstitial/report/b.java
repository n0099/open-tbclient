package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class b {

    /* loaded from: classes10.dex */
    public static class a {
        public static final b lq = new b();
    }

    public static b dO() {
        return a.lq;
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
            com.kwad.sdk.commercial.a.d(cl.i(d).L("ad_sdk_interstitial_download_error", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aSy));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, String str) {
        AdInfo dP = e.dP(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void o(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }
}
