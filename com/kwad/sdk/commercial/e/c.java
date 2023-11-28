package com.kwad.sdk.commercial.e;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
/* loaded from: classes10.dex */
public final class c {
    public static void a(KsScene ksScene) {
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.c.bT(ksScene.getAdStyle())).L("ad_convert_method_call", "method_name").u(b.zU().cq("loadRequest").cd(ksScene.getAdNum()).setPosId(ksScene.getPosId())));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.c.aS(adTemplate)).L("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void j(AdTemplate adTemplate, int i) {
        try {
            a(adTemplate, b.zU().cq("dataReady").cd(i));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(BusinessType businessType, AdTemplate adTemplate, int i, boolean z) {
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).a(businessType).L("ad_convert_method_call", "method_name").u(b.zU().cq("dataReady").bk(true).cd(i).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(BusinessType businessType, boolean z) {
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).a(businessType).L("ad_convert_method_call", "method_name").u(b.zU().cq("requestFinish").bk(z)));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void b(BusinessType businessType, boolean z) {
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).a(businessType).L("ad_convert_method_call", "method_name").u(b.zU().cq("loadRequest").bk(true)));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bA(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("adShowSuccess"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void bz(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.zU().cq("callShow"));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
