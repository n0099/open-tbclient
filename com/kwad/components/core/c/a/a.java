package com.kwad.components.core.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: com.kwad.components.core.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0630a {
        public boolean DS;
        public boolean DT;
        public b DU;
        public c DV;
        public boolean DW;
        public long DX;
        public boolean DY;
        public boolean DZ;
        public u.b Ea;
        public JSONObject Eb;
        public boolean Ec = false;
        public boolean Ed;
        public int Ee;
        public int Ef;
        public AdTemplate adTemplate;
        public final Context context;
        public int gH;

        public C0630a(Context context) {
            this.context = context;
        }

        public final C0630a L(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0630a a(b bVar) {
            this.DU = bVar;
            return this;
        }

        public final C0630a a(u.b bVar) {
            this.Ea = bVar;
            return this;
        }

        public final C0630a ae(int i) {
            this.gH = i;
            return this;
        }

        public final C0630a af(int i) {
            this.Ee = i;
            return this;
        }

        public final C0630a ag(int i) {
            this.Ef = i;
            return this;
        }

        public final C0630a aj(boolean z) {
            this.DW = z;
            return this;
        }

        public final C0630a ak(boolean z) {
            this.DY = z;
            return this;
        }

        public final C0630a al(boolean z) {
            this.DZ = z;
            return this;
        }

        public final C0630a am(boolean z) {
            this.Ec = z;
            return this;
        }

        public final C0630a an(boolean z) {
            this.DT = z;
            return this;
        }

        public final C0630a ao(boolean z) {
            this.DS = z;
            return this;
        }

        public final C0630a ap(boolean z) {
            this.Ed = z;
            return this;
        }

        public final C0630a b(c cVar) {
            this.DV = cVar;
            return this;
        }

        public final C0630a c(JSONObject jSONObject) {
            this.Eb = jSONObject;
            return this;
        }

        public final int cC() {
            return this.gH;
        }

        public final JSONObject gP() {
            return this.Eb;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final c getApkDownloadHelper() {
            return this.DV;
        }

        public final u.b getClientParams() {
            return this.Ea;
        }

        public final Context getContext() {
            return this.context;
        }

        public final C0630a l(long j) {
            this.DX = j;
            return this;
        }

        public final boolean mA() {
            return this.DZ;
        }

        public final boolean mB() {
            return this.Ec;
        }

        public final boolean mC() {
            return this.DT;
        }

        public final boolean mD() {
            return this.DS;
        }

        public final boolean mE() {
            return this.Ed;
        }

        public final int mF() {
            return this.Ee;
        }

        public final int mG() {
            return this.Ef;
        }

        public final b mw() {
            return this.DU;
        }

        public final boolean mx() {
            return this.DW;
        }

        public final long my() {
            return this.DX;
        }

        public final boolean mz() {
            return this.DY;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z, boolean z2) {
        adTemplate.converted = true;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        if (d.a(new C0630a(context).L(adTemplate), 1) == 1) {
            bVar.onAdClicked();
            return 0;
        } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
            bVar.onAdClicked();
            if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
                com.kwad.sdk.core.report.a.m(adTemplate, 0);
            } else {
                AdWebViewActivityProxy.launch(context, adTemplate);
            }
            return 0;
        } else if (cVar != null) {
            int m = cVar.m(new C0630a(context).aj(z).L(adTemplate).ak(z2).am(false));
            int i = bQ.status;
            if (i != 2 && i != 3) {
                bVar.onAdClicked();
            }
            return m;
        } else {
            return 0;
        }
    }

    public static int a(C0630a c0630a) {
        c0630a.getAdTemplate().converted = true;
        if (c0630a.mD()) {
            a(c0630a.getContext(), c0630a.getAdTemplate(), c0630a.mw(), c0630a.getApkDownloadHelper(), c0630a.DW, c0630a.mz());
            return 0;
        } else if (b(c0630a)) {
            return 0;
        } else {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0630a.getAdTemplate());
            com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (d.a(c0630a, 1) == 1) {
                if (com.kwad.sdk.core.response.a.a.bK(bQ)) {
                    com.kwad.sdk.core.report.a.o(c0630a.getAdTemplate(), (int) Math.ceil(((float) c0630a.my()) / 1000.0f));
                }
                e(c0630a);
                return 0;
            } else if (e.d(c0630a.getContext(), c0630a.getAdTemplate())) {
                e(c0630a);
                return 0;
            } else if (c0630a.mC() && (!com.kwad.sdk.core.response.a.a.am(bQ) || i(c0630a))) {
                e(c0630a);
                h(c0630a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
                if (c0630a.getAdTemplate().isWebViewDownload) {
                    return g(c0630a);
                }
                boolean e = com.kwad.sdk.utils.d.e(c0630a.getContext(), com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ));
                e(c0630a);
                if (e) {
                    com.kwad.sdk.core.report.a.m(c0630a.getAdTemplate(), 0);
                    return 0;
                }
                AdWebViewActivityProxy.launch(c0630a.getContext(), c0630a.getAdTemplate());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                    if (c0630a.mG() == 2 || c0630a.mG() == 1) {
                        c0630a.am(false);
                        e(c0630a);
                    } else {
                        e(c0630a);
                        if (!c(c0630a)) {
                            c0630a.am(true);
                        }
                    }
                    return g(c0630a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C0630a c0630a) {
        return com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(c0630a.getAdTemplate())) ? !c0630a.mE() && c.s(c0630a) == 3 : d(c0630a) == 1;
    }

    public static boolean c(C0630a c0630a) {
        AdTemplate adTemplate = c0630a.getAdTemplate();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (!c0630a.mC() || !com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(bQ)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0630a.getApkDownloadHelper().mO()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c0630a.getContext(), adTemplate);
        return true;
    }

    public static int d(C0630a c0630a) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0630a.getAdTemplate());
        if (bQ.unDownloadConf.unDownloadRegionConf != null) {
            int cC = c0630a.cC();
            return cC != 2 ? cC != 3 ? bQ.unDownloadConf.unDownloadRegionConf.actionBarType : bQ.unDownloadConf.unDownloadRegionConf.materialJumpType : bQ.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    public static void e(C0630a c0630a) {
        f(c0630a);
        if (c0630a.mw() != null) {
            c0630a.mw().onAdClicked();
        }
    }

    public static void f(C0630a c0630a) {
        if (c0630a.mA()) {
            com.kwad.sdk.core.report.a.a(c0630a.adTemplate, c0630a.Ea, c0630a.gP());
        }
    }

    public static int g(C0630a c0630a) {
        c apkDownloadHelper = c0630a.getApkDownloadHelper();
        if (apkDownloadHelper == null) {
            apkDownloadHelper = new c(c0630a.adTemplate);
            c0630a.b(apkDownloadHelper);
        }
        return apkDownloadHelper.m(c0630a);
    }

    public static void h(C0630a c0630a) {
        AdTemplate adTemplate = c0630a.getAdTemplate();
        Context context = c0630a.getContext();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
            com.kwad.sdk.core.report.a.m(adTemplate, 0);
        } else if (i(c0630a)) {
            AdWebViewActivityProxy.launch(context, adTemplate, 4);
        } else if (!com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || adTemplate.mAdWebVideoPageShowing) {
            AdWebViewActivityProxy.launch(context, adTemplate, 0);
        } else {
            AdWebViewVideoActivityProxy.launch(context, adTemplate);
        }
    }

    public static boolean i(C0630a c0630a) {
        AdTemplate adTemplate = c0630a.getAdTemplate();
        return com.kwad.sdk.core.response.a.b.bg(adTemplate) && !adTemplate.interactLandingPageShowing;
    }
}
