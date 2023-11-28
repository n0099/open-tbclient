package com.kwad.sdk.commercial.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class a {
    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void f(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.zX().ce(1).cu(str));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void g(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.zX().ce(2).cu(str));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void h(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.zX().ce(3).cu(str));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void i(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.zX().ce(4).cu(str));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void j(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.zX().ce(5).cu(str));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.d.a aVar) {
        double d;
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b cl = com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG);
        if (z) {
            d = 0.1d;
        } else {
            d = 0.01d;
        }
        com.kwad.sdk.commercial.a.d(cl.i(d).a(c.aS(adTemplate)).L("ad_sdk_deeplink_performance", "status").u(aVar));
    }

    public static void d(AdTemplate adTemplate, String str, String str2) {
        try {
            a(adTemplate, true, b.zX().ce(6).cu(str).setErrorCode(100007).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
