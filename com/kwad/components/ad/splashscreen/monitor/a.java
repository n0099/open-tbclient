package com.kwad.components.ad.splashscreen.monitor;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0629a {
        public static final a CR = new a();
    }

    public static a kM() {
        return C0629a.CR;
    }

    public static SplashMonitorInfo V(@NonNull AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        SplashMonitorInfo creativeId = new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.aZ(dP)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP));
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            i = 1;
        } else {
            i = 2;
        }
        return creativeId.setMaterialType(i).setAdTemplate(adTemplate);
    }

    public final void W(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(2));
    }

    public final void X(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(5));
    }

    public final void Y(@NonNull AdTemplate adTemplate) {
        d(V(adTemplate).setActionType(1));
    }

    public final void l(@NonNull AdTemplate adTemplate) {
        d(V(adTemplate).setActionType(2));
    }

    public final void m(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(1));
    }

    public final void n(@NonNull AdTemplate adTemplate) {
        c(V(adTemplate).setCallbackType(3));
    }

    public final void o(long j) {
        c(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }

    public static void c(com.kwad.sdk.commercial.d.a aVar) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            return;
        }
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_splash_callback", "callback_type").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void d(com.kwad.sdk.commercial.d.a aVar) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            return;
        }
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_splash_action", "action_type").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }
}
