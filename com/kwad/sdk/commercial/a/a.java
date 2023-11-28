package com.kwad.sdk.commercial.a;

import com.baidu.sapi2.share.ShareLoginModel;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class a {
    public static void a(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            a(adTemplate, true, b.zQ().bV(5).bW(i).cn(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            a(adTemplate, true, b.zQ().bV(4).bW(i).cn(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void c(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            a(adTemplate, true, b.zQ().bV(3).bW(i).cn(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void h(AdTemplate adTemplate, int i) {
        try {
            a(adTemplate, b.zQ().bV(1).bW(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void i(AdTemplate adTemplate, int i) {
        try {
            a(adTemplate, b.zQ().bV(2).bW(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        double d;
        com.kwad.sdk.commercial.b zP = com.kwad.sdk.commercial.b.zP();
        if (z) {
            str = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b cl = zP.cl(str);
        double d2 = 0.01d;
        if (z) {
            d = 0.01d;
        } else {
            d = 1.0E-4d;
        }
        com.kwad.sdk.commercial.b i = cl.i(d);
        if (z) {
            d2 = 1.0d;
        }
        com.kwad.sdk.commercial.a.d(i.j(d2).a(c.aS(adTemplate)).L("ad_sdk_adlog_performance", "status").u(aVar));
    }

    public static void h(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, false, b.zQ().bV(5).bW(i).cn(str).setErrorCode(ShareLoginModel.REQUEST_CODE_SHARE_V4).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
