package com.kwad.sdk.commercial.h;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class a {
    public static void a(AdTemplate adTemplate, int i, String str, String str2) {
        try {
            a(adTemplate, true, b.zY().cf(3).cv(str).cg(i).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        a(adTemplate, false, aVar);
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
        com.kwad.sdk.commercial.a.d(cl.i(d).a(c.aS(adTemplate)).L("ad_sdk_landing_page_performance", "status").u(aVar));
    }

    public static void d(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            a(adTemplate, true, b.zY().cf(6).cv(str).cg(i).setErrorCode(i2).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void k(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.zY().cf(1).cv(str).cg(i));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void l(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.zY().cf(2).cv(str).cg(i));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void m(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.zY().cf(4).cv(str).cg(i));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void n(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.zY().cf(5).cv(str).cg(i));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
