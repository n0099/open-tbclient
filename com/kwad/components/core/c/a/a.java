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
    public static class C0610a {
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

        public C0610a(Context context) {
            this.context = context;
        }

        public final C0610a L(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0610a a(b bVar) {
            this.DU = bVar;
            return this;
        }

        public final C0610a a(u.b bVar) {
            this.Ea = bVar;
            return this;
        }

        public final C0610a ae(int i) {
            this.gH = i;
            return this;
        }

        public final C0610a af(int i) {
            this.Ee = i;
            return this;
        }

        public final C0610a ag(int i) {
            this.Ef = i;
            return this;
        }

        public final C0610a aj(boolean z) {
            this.DW = z;
            return this;
        }

        public final C0610a ak(boolean z) {
            this.DY = z;
            return this;
        }

        public final C0610a al(boolean z) {
            this.DZ = z;
            return this;
        }

        public final C0610a am(boolean z) {
            this.Ec = z;
            return this;
        }

        public final C0610a an(boolean z) {
            this.DT = z;
            return this;
        }

        public final C0610a ao(boolean z) {
            this.DS = z;
            return this;
        }

        public final C0610a ap(boolean z) {
            this.Ed = z;
            return this;
        }

        public final C0610a b(c cVar) {
            this.DV = cVar;
            return this;
        }

        public final C0610a c(JSONObject jSONObject) {
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

        public final C0610a l(long j) {
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
        if (d.a(new C0610a(context).L(adTemplate), 1) == 1) {
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
            int m = cVar.m(new C0610a(context).aj(z).L(adTemplate).ak(z2).am(false));
            int i = bQ.status;
            if (i != 2 && i != 3) {
                bVar.onAdClicked();
            }
            return m;
        } else {
            return 0;
        }
    }

    public static int a(C0610a c0610a) {
        c0610a.getAdTemplate().converted = true;
        if (c0610a.mD()) {
            a(c0610a.getContext(), c0610a.getAdTemplate(), c0610a.mw(), c0610a.getApkDownloadHelper(), c0610a.DW, c0610a.mz());
            return 0;
        } else if (b(c0610a)) {
            return 0;
        } else {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0610a.getAdTemplate());
            com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (d.a(c0610a, 1) == 1) {
                if (com.kwad.sdk.core.response.a.a.bK(bQ)) {
                    com.kwad.sdk.core.report.a.o(c0610a.getAdTemplate(), (int) Math.ceil(((float) c0610a.my()) / 1000.0f));
                }
                e(c0610a);
                return 0;
            } else if (e.d(c0610a.getContext(), c0610a.getAdTemplate())) {
                e(c0610a);
                return 0;
            } else if (c0610a.mC() && (!com.kwad.sdk.core.response.a.a.am(bQ) || i(c0610a))) {
                e(c0610a);
                h(c0610a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
                if (c0610a.getAdTemplate().isWebViewDownload) {
                    return g(c0610a);
                }
                boolean e = com.kwad.sdk.utils.d.e(c0610a.getContext(), com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ));
                e(c0610a);
                if (e) {
                    com.kwad.sdk.core.report.a.m(c0610a.getAdTemplate(), 0);
                    return 0;
                }
                AdWebViewActivityProxy.launch(c0610a.getContext(), c0610a.getAdTemplate());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                    if (c0610a.mG() == 2 || c0610a.mG() == 1) {
                        c0610a.am(false);
                        e(c0610a);
                    } else {
                        e(c0610a);
                        if (!c(c0610a)) {
                            c0610a.am(true);
                        }
                    }
                    return g(c0610a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C0610a c0610a) {
        return com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(c0610a.getAdTemplate())) ? !c0610a.mE() && c.s(c0610a) == 3 : d(c0610a) == 1;
    }

    public static boolean c(C0610a c0610a) {
        AdTemplate adTemplate = c0610a.getAdTemplate();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (!c0610a.mC() || !com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(bQ)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0610a.getApkDownloadHelper().mO()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c0610a.getContext(), adTemplate);
        return true;
    }

    public static int d(C0610a c0610a) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0610a.getAdTemplate());
        if (bQ.unDownloadConf.unDownloadRegionConf != null) {
            int cC = c0610a.cC();
            return cC != 2 ? cC != 3 ? bQ.unDownloadConf.unDownloadRegionConf.actionBarType : bQ.unDownloadConf.unDownloadRegionConf.materialJumpType : bQ.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    public static void e(C0610a c0610a) {
        f(c0610a);
        if (c0610a.mw() != null) {
            c0610a.mw().onAdClicked();
        }
    }

    public static void f(C0610a c0610a) {
        if (c0610a.mA()) {
            com.kwad.sdk.core.report.a.a(c0610a.adTemplate, c0610a.Ea, c0610a.gP());
        }
    }

    public static int g(C0610a c0610a) {
        c apkDownloadHelper = c0610a.getApkDownloadHelper();
        if (apkDownloadHelper == null) {
            apkDownloadHelper = new c(c0610a.adTemplate);
            c0610a.b(apkDownloadHelper);
        }
        return apkDownloadHelper.m(c0610a);
    }

    public static void h(C0610a c0610a) {
        AdTemplate adTemplate = c0610a.getAdTemplate();
        Context context = c0610a.getContext();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
            com.kwad.sdk.core.report.a.m(adTemplate, 0);
        } else if (i(c0610a)) {
            AdWebViewActivityProxy.launch(context, adTemplate, 4);
        } else if (!com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || adTemplate.mAdWebVideoPageShowing) {
            AdWebViewActivityProxy.launch(context, adTemplate, 0);
        } else {
            AdWebViewVideoActivityProxy.launch(context, adTemplate);
        }
    }

    public static boolean i(C0610a c0610a) {
        AdTemplate adTemplate = c0610a.getAdTemplate();
        return com.kwad.sdk.core.response.a.b.bg(adTemplate) && !adTemplate.interactLandingPageShowing;
    }
}
