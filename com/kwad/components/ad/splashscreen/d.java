package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class d {
    public static int Ch;
    public String Ci;
    public int Cj = 2;

    public final String ks() {
        return this.Ci;
    }

    public final int kt() {
        return this.Cj;
    }

    private void S(String str) {
        this.Ci = str;
    }

    private void V(int i) {
        this.Cj = i;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i) {
        d dVar = new d();
        Ch = i;
        if (adInfo != null && cVar != null) {
            if (i != 1 && i != 4) {
                if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                    int nM = cVar.nM();
                    dVar.S("或点击" + a(adTemplate, adInfo, nM, 0));
                } else {
                    String a = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CN);
                    if (TextUtils.isEmpty(a)) {
                        a = "点击跳转详情页或第三方应用";
                    }
                    dVar.S("或" + a);
                }
            } else {
                dVar.S(a(adTemplate, adInfo, cVar));
            }
        }
        dVar.V(com.kwad.sdk.core.response.b.b.dp(adInfo));
        return dVar;
    }

    public static String a(AdInfo adInfo, int i) {
        if (i == 1) {
            if (com.kwad.sdk.core.response.b.b.dj(adInfo) == null) {
                return "";
            }
            return com.kwad.sdk.core.response.b.b.dj(adInfo);
        } else if (i != 4 || com.kwad.sdk.core.response.b.b.dk(adInfo) == null) {
            return "";
        } else {
            return com.kwad.sdk.core.response.b.b.dk(adInfo);
        }
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i, int i2) {
        String aE = com.kwad.sdk.core.response.b.a.aE(adInfo);
        if (i != 2) {
            if (i != 4) {
                if (i != 8) {
                    if (i == 12) {
                        return com.kwad.sdk.core.response.b.a.ac(adInfo);
                    }
                    return aE;
                }
                return com.kwad.sdk.core.response.b.a.bX(adTemplate);
            }
            return "继续下载";
        }
        return i2 + "%";
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return a(adTemplate, adInfo, cVar.nM(), 0);
        }
        String a = a(adInfo, Ch);
        if (TextUtils.isEmpty(a)) {
            return "点击跳转详情页或第三方应用";
        }
        return a;
    }
}
