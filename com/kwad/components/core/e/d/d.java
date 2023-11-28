package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bn;
import java.util.concurrent.Callable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d {
    public static boolean KV;
    public static final b KW = new b() { // from class: com.kwad.components.core.e.d.d.3
        public long Lc;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Lc = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Lc != 0) {
                com.kwad.sdk.core.report.a.l(getAdTemplate(), System.currentTimeMillis() - this.Lc);
            }
            com.kwad.sdk.core.c.b.Ct();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) d.KW);
            setAdTemplate(null);
            this.Lc = 0L;
        }
    };

    public static boolean oc() {
        return KV;
    }

    public static int a(final a.C0644a c0644a, int i) {
        Context context = c0644a.getContext();
        final AdTemplate adTemplate = c0644a.getAdTemplate();
        String a = a(c0644a, adTemplate);
        if (TextUtils.isEmpty(a)) {
            return 0;
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        Activity m186do = l.m186do(context);
        if (m186do != null && com.kwad.sdk.core.response.b.a.U(dP) && !c0644a.ns()) {
            c0644a.ak(1);
            com.kwad.components.core.e.e.e.a(m186do, c0644a);
            return 2;
        }
        final String a2 = a(a, c0644a, dP);
        return com.kwad.sdk.core.download.a.b.a(context, a2, new b.a() { // from class: com.kwad.components.core.e.d.d.1
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void oe() {
                com.kwad.sdk.commercial.g.a.g(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.g.a.f(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                d.KW.setAdTemplate(AdTemplate.this);
                com.kwad.sdk.core.c.b.Ct();
                com.kwad.sdk.core.c.b.a(d.KW);
                com.kwad.sdk.core.report.a.avf = d.ag(a2);
                com.kwad.sdk.commercial.g.a.h(AdTemplate.this, a2);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.commercial.g.a.i(AdTemplate.this, a2);
                com.kwad.sdk.core.report.a.a(AdTemplate.this, "", r3, c0644a.getClientParams());
                d.a(AdTemplate.this, a2, r3);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.core.report.a.b(AdTemplate.this, "", r3, null);
                com.kwad.sdk.commercial.g.a.d(AdTemplate.this, a2, bn.s(th));
            }
        });
    }

    public static String j(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    public static String a(a.C0644a c0644a, AdInfo adInfo, String str) {
        String str2;
        if (!com.kwad.sdk.core.response.b.a.bi(adInfo)) {
            return str;
        }
        String str3 = null;
        Callable<String> nr = c0644a.nr();
        if (nr != null) {
            try {
                str3 = nr.call();
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = c0644a.nq();
        }
        if (TextUtils.isEmpty(str3)) {
            if (!str.contains("__itemId__") && !str.contains("__simpleItemId__")) {
                return str;
            }
            return com.kwad.sdk.core.response.b.a.cK(adInfo);
        }
        try {
            str2 = String.valueOf(com.kwad.components.core.e.b.a.ac(str3));
        } catch (Throwable unused2) {
            str2 = str3;
        }
        return str.replaceAll("__itemId__", str3).replaceAll("__simpleItemId__", str2);
    }

    public static String a(a.C0644a c0644a, AdTemplate adTemplate) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : dP.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0644a.cX()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0644a.nw()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + dP.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.b.a.cK(dP);
    }

    public static String a(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (i == 0 || i == 3) {
            return j(str, str2);
        }
        return str;
    }

    public static String b(a.C0644a c0644a, AdInfo adInfo, String str) {
        long j = c0644a.getAdTemplate().getmCurPlayTime();
        if (j > 0) {
            j = Math.max(j - com.kwad.sdk.core.response.b.a.bk(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j)).toString();
    }

    public static String a(String str, Context context, SceneImpl sceneImpl) {
        String str2 = "";
        if (sceneImpl == null) {
            return "";
        }
        int i = 0;
        if (!ak.an(context, "com.smile.gifmaker") && ak.an(context, "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        if (!TextUtils.isEmpty(backUrl)) {
            str2 = backUrl;
        }
        return a(str, i, str2);
    }

    public static String a(String str, a.C0644a c0644a, AdInfo adInfo) {
        AdTemplate adTemplate = c0644a.getAdTemplate();
        if (com.kwad.sdk.core.response.b.a.bj(adInfo)) {
            str = b(c0644a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.b.a.cJ(adInfo)) {
            str = a(c0644a, adInfo, str);
        }
        if ((com.kwad.sdk.core.response.b.a.cB(adInfo) || com.kwad.sdk.core.response.b.a.cH(adInfo)) && adTemplate.mAdScene != null) {
            return a(str, c0644a.getContext(), adTemplate.mAdScene);
        }
        return str;
    }

    public static void a(final AdTemplate adTemplate, final String str, final int i) {
        if (oc()) {
            return;
        }
        ax(true);
        int AK = com.kwad.sdk.core.config.d.AK();
        com.kwad.sdk.core.config.d.AL();
        int abs = Math.abs(AK);
        if (abs > 0) {
            bn.a(new Runnable() { // from class: com.kwad.components.core.e.d.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.ax(false);
                    com.kwad.sdk.core.c.b.Ct();
                    if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        com.kwad.sdk.core.report.a.c(AdTemplate.this, "", i);
                        com.kwad.sdk.commercial.g.a.j(AdTemplate.this, str);
                    }
                }
            }, null, abs * 1000);
        } else {
            ax(false);
        }
    }

    public static JSONObject ag(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void aw(boolean z) {
        com.kwad.sdk.core.report.a.avg = z;
    }

    public static void ax(boolean z) {
        KV = z;
    }
}
