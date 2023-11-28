package com.kwad.sdk.commercial.i;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class a {
    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            a(adTemplate, b.zZ().ch(1).cy(str).cx(str2).cw(str3));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void b(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            a(adTemplate, b.zZ().ch(2).cy(str).cx(str2).cw(str3));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void c(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            a(adTemplate, b.zZ().ch(3).cy(str).cx(str2).cw(str3));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            a(adTemplate, true, b.zZ().ch(4).cy(str).cx(str2).cw(str3).setErrorCode(100008).setErrorMsg(str4));
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
        com.kwad.sdk.commercial.a.d(cl.i(d).a(c.aS(adTemplate)).L("ad_sdk_small_app_performance", "status").u(aVar));
    }
}
