package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0602a {
        public static final a lp = new a();
    }

    public static a dM() {
        return C0602a.lp;
    }

    public static void a(String str, com.kwad.sdk.commercial.d.a aVar) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            return;
        }
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_interstitial_callback", str).a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public final void a(AdTemplate adTemplate, long j, long j2) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j, long j2) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void l(AdTemplate adTemplate) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setAdTemplate(adTemplate));
    }

    public final void m(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void n(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }
}
