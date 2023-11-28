package com.kwad.sdk.commercial.b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class a {
    public static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.d.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void j(AdTemplate adTemplate, long j) {
        a(adTemplate, b.zR().bX(2).Y(j).setAdTemplate(adTemplate));
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
        if (z) {
            d = 1.0d;
        } else {
            d = 0.1d;
        }
        com.kwad.sdk.commercial.a.d(cl.i(d).a(c.aS(adTemplate)).L("ad_sdk_download_performance", "status").u(aVar));
    }

    public static void aV(AdTemplate adTemplate) {
        a(adTemplate, b.zR().bX(3).setAdTemplate(adTemplate));
    }

    public static void aW(AdTemplate adTemplate) {
        a(adTemplate, b.zR().bX(4).setAdTemplate(adTemplate));
    }

    public static void aX(AdTemplate adTemplate) {
        a(adTemplate, b.zR().bX(5).setAdTemplate(adTemplate));
    }

    public static void aY(AdTemplate adTemplate) {
        i(adTemplate, 100002, "");
    }

    public static void aZ(AdTemplate adTemplate) {
        int i;
        b bX = b.zR().bX(7);
        if (adTemplate.mInstallApkFormUser) {
            i = 1;
        } else {
            i = 2;
        }
        a(adTemplate, bX.bY(i).setAdTemplate(adTemplate));
    }

    public static void ba(AdTemplate adTemplate) {
        int i;
        b bX = b.zR().bX(8);
        int i2 = 1;
        if (adTemplate.mInstallApkFormUser) {
            i = 1;
        } else {
            i = 2;
        }
        b bY = bX.bY(i);
        if (!adTemplate.mInstallApkFromSDK) {
            if (adTemplate.mClickOpenAppStore) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        }
        a(adTemplate, bY.bZ(i2).setAdTemplate(adTemplate));
    }

    public static void bb(AdTemplate adTemplate) {
        int i;
        b bX = b.zR().bX(10);
        if (adTemplate.mInstallApkFromSDK) {
            i = 1;
        } else if (adTemplate.mClickOpenAppStore) {
            i = 2;
        } else {
            i = 0;
        }
        a(adTemplate, bX.bZ(i).setAdTemplate(adTemplate));
    }

    public static void o(AdTemplate adTemplate) {
        a(adTemplate, b.zR().bX(1).setAdTemplate(adTemplate));
    }

    public static void i(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.zR().bX(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    public static void j(AdTemplate adTemplate, int i, String str) {
        int i2;
        b bX = b.zR().bX(9);
        if (adTemplate.mInstallApkFormUser) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        a(adTemplate, true, bX.bY(i2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }
}
