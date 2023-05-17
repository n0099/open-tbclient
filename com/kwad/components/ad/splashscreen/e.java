package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class e {
    public static int xX;
    public String title;
    public String xY;
    public int xZ = 2;

    private void W(int i) {
        this.xZ = i;
    }

    private void W(String str) {
        this.xY = str;
    }

    public static e a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.c.a.c cVar, int i) {
        String str;
        e eVar = new e();
        xX = i;
        if (adInfo != null && cVar != null) {
            if (i == 1) {
                eVar.setTitle(com.kwad.sdk.core.response.a.b.bV(adInfo));
            } else if (i != 4) {
                if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
                    int mI = cVar.mI();
                    str = "或点击" + a(adTemplate, adInfo, mI);
                } else {
                    String jR = com.kwad.components.ad.splashscreen.a.b.jR();
                    if (TextUtils.isEmpty(jR)) {
                        jR = "点击跳转详情页或第三方应用";
                    }
                    str = "或" + jR;
                }
                eVar.W(str);
            }
            str = a(adInfo, cVar);
            eVar.W(str);
        }
        eVar.W(com.kwad.sdk.core.response.a.b.ca(adInfo));
        return eVar;
    }

    public static String a(AdInfo adInfo, int i) {
        AdMatrixInfo.DownloadTexts b = b(adInfo, xX);
        return i != 8 ? i != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
    }

    public static String a(AdInfo adInfo, com.kwad.components.core.c.a.c cVar) {
        if (!com.kwad.sdk.core.response.a.a.am(adInfo)) {
            String d = d(adInfo, xX);
            return TextUtils.isEmpty(d) ? "点击跳转详情页或第三方应用" : d;
        }
        int mI = cVar.mI();
        AdMatrixInfo.DownloadTexts b = b(adInfo, xX);
        return mI != 8 ? mI != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i) {
        return i != 8 ? i != 12 ? com.kwad.sdk.core.response.a.a.al(adInfo) : com.kwad.sdk.core.response.a.a.P(adInfo) : com.kwad.sdk.core.response.a.a.aJ(adTemplate);
    }

    public static AdMatrixInfo.DownloadTexts b(AdInfo adInfo, int i) {
        if (i == 1) {
            return com.kwad.sdk.core.response.a.b.bT(adInfo) != null ? com.kwad.sdk.core.response.a.b.bT(adInfo) : new AdMatrixInfo.DownloadTexts();
        }
        if (i == 4 && com.kwad.sdk.core.response.a.b.bX(adInfo) != null) {
            return com.kwad.sdk.core.response.a.b.bX(adInfo);
        }
        return new AdMatrixInfo.DownloadTexts();
    }

    public static String c(AdInfo adInfo, int i) {
        AdMatrixInfo.DownloadTexts bU = com.kwad.sdk.core.response.a.b.bU(adInfo) != null ? com.kwad.sdk.core.response.a.b.bU(adInfo) : new AdMatrixInfo.DownloadTexts();
        return i != 8 ? i != 12 ? bU.adActionDescription : bU.openAppLabel : bU.installAppLabel;
    }

    public static String d(AdInfo adInfo, int i) {
        return i == 1 ? com.kwad.sdk.core.response.a.b.bW(adInfo) != null ? com.kwad.sdk.core.response.a.b.bW(adInfo) : "" : (i != 4 || com.kwad.sdk.core.response.a.b.bY(adInfo) == null) ? "" : com.kwad.sdk.core.response.a.b.bY(adInfo);
    }

    private void setTitle(String str) {
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String jw() {
        return this.xY;
    }

    public final int jx() {
        return this.xZ;
    }
}
