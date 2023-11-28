package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.t;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public static C0697a aod;

    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0697a extends com.kwad.sdk.core.response.a.a {
        public List<String> aoe;
    }

    public static C0697a Aa() {
        String yG = ((h) ServiceProvider.get(h.class)).yG();
        if (!TextUtils.isEmpty(yG)) {
            aod = (C0697a) t.b(yG, new c<C0697a>() { // from class: com.kwad.sdk.commercial.j.a.1
                public static C0697a Ab() {
                    return new C0697a();
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.b' to match base method */
                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ C0697a Ac() {
                    return Ab();
                }
            });
        }
        return aod;
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            a(adTemplate, b.Ad().ci(2).cj(i).cA(str).ck(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            a(adTemplate, true, b.Ad().ci(3).cj(i).cA(str).cB(str2).setErrorCode(i2).setErrorMsg(str3).ck(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    public static void a(AdTemplate adTemplate, boolean z, b bVar) {
        String str;
        double d;
        if (cz(bVar.aof)) {
            return;
        }
        com.kwad.sdk.commercial.b zP = com.kwad.sdk.commercial.b.zP();
        if (z) {
            str = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b cl = zP.cl(str);
        if (z) {
            d = 0.01d;
        } else {
            d = 0.001d;
        }
        com.kwad.sdk.commercial.a.d(cl.i(d).a(com.kwad.sdk.commercial.c.aS(adTemplate)).L("ad_sdk_track_performance", "status").u(bVar));
    }

    public static boolean cz(String str) {
        List<String> list;
        C0697a Aa = Aa();
        if (Aa == null || (list = Aa.aoe) == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void o(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.Ad().ci(4).cj(i).cA(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }

    public static void p(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.Ad().ci(1).cj(i).cA(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.b(th);
        }
    }
}
