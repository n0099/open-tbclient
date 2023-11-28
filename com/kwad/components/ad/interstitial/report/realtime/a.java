package com.kwad.components.ad.interstitial.report.realtime;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.realtime.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0603a {
        public static final a lt = new a((byte) 0);
    }

    public a() {
    }

    public static a dU() {
        return C0603a.lt;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static void a(e eVar) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setErrorCode(eVar.errorCode);
            com.kwad.sdk.commercial.a.d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_interstitial_data_result_monitor", "error_code").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void x(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            com.kwad.sdk.commercial.a.d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_interstitial_service_call_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(String str, AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            com.kwad.sdk.commercial.a.d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_interstitial_render_result_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void b(String str, AdTemplate adTemplate) {
        try {
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            interstitialRealTimeInfo.setMaterialUrl(com.kwad.sdk.core.response.b.a.K(dP));
            com.kwad.sdk.commercial.a.d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_interstitial_resource_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void w(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setRenderType(com.kwad.sdk.core.response.b.e.dP(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType);
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            com.kwad.sdk.commercial.a.d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_interstitial_data_check_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
