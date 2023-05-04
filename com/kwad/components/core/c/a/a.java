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
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: com.kwad.components.core.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0596a {
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

        public C0596a(Context context) {
            this.context = context;
        }

        public final C0596a L(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0596a a(b bVar) {
            this.DU = bVar;
            return this;
        }

        public final C0596a a(u.b bVar) {
            this.Ea = bVar;
            return this;
        }

        public final C0596a ae(int i) {
            this.gH = i;
            return this;
        }

        public final C0596a af(int i) {
            this.Ee = i;
            return this;
        }

        public final C0596a ag(int i) {
            this.Ef = i;
            return this;
        }

        public final C0596a aj(boolean z) {
            this.DW = z;
            return this;
        }

        public final C0596a ak(boolean z) {
            this.DY = z;
            return this;
        }

        public final C0596a al(boolean z) {
            this.DZ = z;
            return this;
        }

        public final C0596a am(boolean z) {
            this.Ec = z;
            return this;
        }

        public final C0596a an(boolean z) {
            this.DT = z;
            return this;
        }

        public final C0596a ao(boolean z) {
            this.DS = z;
            return this;
        }

        public final C0596a ap(boolean z) {
            this.Ed = z;
            return this;
        }

        public final C0596a b(c cVar) {
            this.DV = cVar;
            return this;
        }

        public final C0596a c(JSONObject jSONObject) {
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

        public final C0596a l(long j) {
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

    /* loaded from: classes8.dex */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z, boolean z2) {
        adTemplate.converted = true;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        if (d.a(new C0596a(context).L(adTemplate), 1) == 1) {
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
            int m = cVar.m(new C0596a(context).aj(z).L(adTemplate).ak(z2).am(false));
            int i = bQ.status;
            if (i != 2 && i != 3) {
                bVar.onAdClicked();
            }
            return m;
        } else {
            return 0;
        }
    }

    public static int a(C0596a c0596a) {
        c0596a.getAdTemplate().converted = true;
        if (c0596a.mD()) {
            a(c0596a.getContext(), c0596a.getAdTemplate(), c0596a.mw(), c0596a.getApkDownloadHelper(), c0596a.DW, c0596a.mz());
            return 0;
        } else if (b(c0596a)) {
            return 0;
        } else {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0596a.getAdTemplate());
            com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (d.a(c0596a, 1) == 1) {
                if (com.kwad.sdk.core.response.a.a.bK(bQ)) {
                    com.kwad.sdk.core.report.a.o(c0596a.getAdTemplate(), (int) Math.ceil(((float) c0596a.my()) / 1000.0f));
                }
                e(c0596a);
                return 0;
            } else if (e.d(c0596a.getContext(), c0596a.getAdTemplate())) {
                e(c0596a);
                return 0;
            } else if (c0596a.mC() && (!com.kwad.sdk.core.response.a.a.am(bQ) || i(c0596a))) {
                e(c0596a);
                h(c0596a);
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
                if (c0596a.getAdTemplate().isWebViewDownload) {
                    return g(c0596a);
                }
                boolean e = com.kwad.sdk.utils.d.e(c0596a.getContext(), com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ));
                e(c0596a);
                if (e) {
                    com.kwad.sdk.core.report.a.m(c0596a.getAdTemplate(), 0);
                    return 0;
                }
                AdWebViewActivityProxy.launch(c0596a.getContext(), c0596a.getAdTemplate());
                return 0;
            } else {
                if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                    if (c0596a.mG() == 2 || c0596a.mG() == 1) {
                        c0596a.am(false);
                        e(c0596a);
                    } else {
                        e(c0596a);
                        if (!c(c0596a)) {
                            c0596a.am(true);
                        }
                    }
                    return g(c0596a);
                }
                return 0;
            }
        }
    }

    public static boolean b(C0596a c0596a) {
        return com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(c0596a.getAdTemplate())) ? !c0596a.mE() && c.s(c0596a) == 3 : d(c0596a) == 1;
    }

    public static boolean c(C0596a c0596a) {
        AdTemplate adTemplate = c0596a.getAdTemplate();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (!c0596a.mC() || !com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(bQ)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0596a.getApkDownloadHelper().mO()) {
            return false;
        }
        AdWebViewVideoActivityProxy.launch(c0596a.getContext(), adTemplate);
        return true;
    }

    public static int d(C0596a c0596a) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0596a.getAdTemplate());
        if (bQ.unDownloadConf.unDownloadRegionConf != null) {
            int cC = c0596a.cC();
            return cC != 2 ? cC != 3 ? bQ.unDownloadConf.unDownloadRegionConf.actionBarType : bQ.unDownloadConf.unDownloadRegionConf.materialJumpType : bQ.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    public static void e(C0596a c0596a) {
        f(c0596a);
        if (c0596a.mw() != null) {
            c0596a.mw().onAdClicked();
        }
    }

    public static void f(C0596a c0596a) {
        if (c0596a.mA()) {
            com.kwad.sdk.core.report.a.a(c0596a.adTemplate, c0596a.Ea, c0596a.gP());
        }
    }

    public static int g(C0596a c0596a) {
        c apkDownloadHelper = c0596a.getApkDownloadHelper();
        if (apkDownloadHelper == null) {
            apkDownloadHelper = new c(c0596a.adTemplate);
            c0596a.b(apkDownloadHelper);
        }
        return apkDownloadHelper.m(c0596a);
    }

    public static void h(C0596a c0596a) {
        AdTemplate adTemplate = c0596a.getAdTemplate();
        Context context = c0596a.getContext();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
            com.kwad.sdk.core.report.a.m(adTemplate, 0);
        } else if (i(c0596a)) {
            AdWebViewActivityProxy.launch(context, adTemplate, 4);
        } else if (!com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || adTemplate.mAdWebVideoPageShowing) {
            AdWebViewActivityProxy.launch(context, adTemplate, 0);
        } else {
            AdWebViewVideoActivityProxy.launch(context, adTemplate);
        }
    }

    public static boolean i(C0596a c0596a) {
        AdTemplate adTemplate = c0596a.getAdTemplate();
        return com.kwad.sdk.core.response.a.b.bg(adTemplate) && !adTemplate.interactLandingPageShowing;
    }
}
