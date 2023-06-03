package com.kwad.components.core.c.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bd;
/* loaded from: classes9.dex */
public final class d extends com.kwad.sdk.core.download.kwai.b {
    public static boolean Ep;
    public static final b Eq = new b() { // from class: com.kwad.components.core.c.a.d.2
        public long Es;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Es = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Es != 0) {
                com.kwad.sdk.core.report.a.g(getAdTemplate(), System.currentTimeMillis() - this.Es);
            }
            com.kwad.sdk.core.c.b.tp();
            com.kwad.sdk.core.c.b.b(d.Eq);
            setAdTemplate(null);
            this.Es = 0L;
        }
    };

    public static int a(a.C0630a c0630a, int i) {
        Context context = c0630a.getContext();
        AdTemplate adTemplate = c0630a.getAdTemplate();
        if (adTemplate == null || context == null) {
            return 0;
        }
        Eq.setAdTemplate(adTemplate);
        com.kwad.sdk.core.c.b.tp();
        com.kwad.sdk.core.c.b.a(Eq);
        int s = com.kwad.sdk.core.download.kwai.b.s(context, com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        if (s == 1) {
            com.kwad.sdk.core.report.a.a(adTemplate, 1, c0630a.getClientParams());
            c(adTemplate, 1);
        } else if (s == -1) {
            com.kwad.sdk.core.report.a.k(adTemplate, 1);
        }
        return s;
    }

    public static String a(String str, int i, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? g(str, str2) : str;
    }

    public static void aq(boolean z) {
        Ep = z;
    }

    public static void c(final AdTemplate adTemplate, final int i) {
        if (mY()) {
            return;
        }
        aq(true);
        int rU = com.kwad.sdk.core.config.d.rU();
        com.kwad.sdk.core.config.d.rV();
        int abs = Math.abs(rU);
        if (abs > 0) {
            bd.a(new Runnable() { // from class: com.kwad.components.core.c.a.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.aq(false);
                    com.kwad.sdk.core.c.b.tp();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.l(AdTemplate.this, i);
                }
            }, null, abs * 1000);
        } else {
            aq(false);
        }
    }

    public static String e(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        if (sceneImpl != null) {
            int i = 0;
            if (!ai.U(context, "com.smile.gifmaker") && ai.U(context, "com.kuaishou.nebula")) {
                i = 3;
            }
            String backUrl = sceneImpl.getBackUrl();
            return a(com.kwad.sdk.core.response.a.a.bM(adInfo), i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
        }
        return "";
    }

    public static String g(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    public static boolean mY() {
        return Ep;
    }
}
