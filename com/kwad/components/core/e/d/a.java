package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static List<WeakReference<k.b>> Kp;

    /* loaded from: classes10.dex */
    public interface b {
        void onAdClicked();
    }

    /* renamed from: com.kwad.components.core.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0644a {
        public long KA;
        public boolean KB;
        public boolean KC;
        public y.b KD;
        public JSONObject KE;
        public boolean KF = false;
        public boolean KG;
        public int KH;
        public int KI;
        public int KJ;
        public int KK;
        public Callable<String> KL;
        public String KM;
        public boolean Kq;
        public boolean Kr;
        public boolean Ks;
        public boolean Kt;
        public boolean Ku;
        public boolean Kv;
        public b Kw;
        public c Kx;
        public boolean Ky;
        public boolean Kz;
        public AdTemplate adTemplate;
        public final Context context;
        public int ki;
        public int kk;

        public C0644a(Context context) {
            this.context = context;
        }

        public final C0644a a(b bVar) {
            this.Kw = bVar;
            return this;
        }

        public final C0644a af(String str) {
            this.KM = str;
            return this;
        }

        public final void ak(int i) {
            this.KI = i;
        }

        public final C0644a al(int i) {
            this.KK = i;
            return this;
        }

        public final C0644a am(int i) {
            this.kk = i;
            return this;
        }

        public final C0644a an(int i) {
            this.ki = i;
            return this;
        }

        public final C0644a ao(int i) {
            this.KH = i;
            return this;
        }

        public final C0644a ap(int i) {
            this.KJ = i;
            return this;
        }

        public final C0644a aq(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0644a ar(boolean z) {
            this.KF = z;
            return this;
        }

        public final C0644a as(boolean z) {
            this.Kr = z;
            return this;
        }

        public final C0644a at(boolean z) {
            this.Ks = true;
            return this;
        }

        public final C0644a au(boolean z) {
            this.Kq = z;
            return this;
        }

        public final C0644a av(boolean z) {
            this.KG = z;
            return this;
        }

        public final C0644a b(c cVar) {
            this.Kx = cVar;
            return this;
        }

        public final C0644a c(JSONObject jSONObject) {
            this.KE = jSONObject;
            return this;
        }

        public final C0644a v(long j) {
            this.KA = j;
            return this;
        }

        public final C0644a a(y.b bVar) {
            this.KD = bVar;
            return this;
        }

        public final void ak(boolean z) {
            this.Kz = true;
        }

        public final C0644a al(boolean z) {
            this.Ku = z;
            return this;
        }

        public final C0644a am(boolean z) {
            this.Kv = true;
            return this;
        }

        public final C0644a an(boolean z) {
            this.Kt = true;
            return this;
        }

        public final C0644a ao(boolean z) {
            this.Ky = z;
            return this;
        }

        public final C0644a ap(boolean z) {
            this.KB = z;
            return this;
        }

        public final C0644a aq(boolean z) {
            this.KC = z;
            return this;
        }

        public final C0644a a(@Nullable Callable<String> callable) {
            this.KL = callable;
            return this;
        }

        public final int cU() {
            return this.ki;
        }

        public final int cX() {
            return this.kk;
        }

        public final c gX() {
            return this.Kx;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final y.b getClientParams() {
            return this.KD;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject hl() {
            return this.KE;
        }

        public final long nA() {
            return this.KA;
        }

        public final boolean nB() {
            return this.KB;
        }

        public final boolean nC() {
            return this.KC;
        }

        public final boolean nD() {
            return this.KF;
        }

        public final boolean nE() {
            return this.Kr;
        }

        public final boolean nF() {
            return this.Ks;
        }

        public final boolean nG() {
            return this.Kq;
        }

        public final boolean nH() {
            return this.KG;
        }

        public final int nI() {
            return this.KH;
        }

        public final int nJ() {
            return this.KJ;
        }

        public final String nq() {
            return this.KM;
        }

        public final Callable<String> nr() {
            return this.KL;
        }

        public final boolean ns() {
            return this.Kz;
        }

        public final int nt() {
            return this.KI;
        }

        public final b nu() {
            return this.Kw;
        }

        public final boolean nv() {
            return this.Kt;
        }

        public final int nw() {
            return this.KK;
        }

        public final boolean nx() {
            return this.Ku;
        }

        public final boolean ny() {
            return this.Kv;
        }

        public final boolean nz() {
            return this.Ky;
        }
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.e.a.f(adTemplate, true);
        adTemplate.converted = true;
        boolean z5 = false;
        d.aw(false);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        C0644a ar = new C0644a(context).aq(adTemplate).a(bVar).b(cVar).ao(z).ap(z2).al(z4).ar(false);
        int an = com.kwad.sdk.core.response.b.a.an(dP);
        if (!((z3 || ar.nJ() == 2 || ar.nJ() == 1) ? true : true) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dP)) && !ar.nF()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(dP)) {
                    return k(ar);
                }
                return l(ar);
            } else if (an == 2) {
                int h = h(ar);
                if (h == 1) {
                    return 13;
                }
                if (h == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(dP)) {
                    return k(ar);
                }
                return l(ar);
            }
        }
        int h2 = h(ar);
        if (h2 == 1) {
            return 13;
        }
        if (h2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dP)) {
            if (j(ar)) {
                return 11;
            }
            return l(ar);
        }
        int m = m(ar);
        int i = dP.status;
        if (i != 2 && i != 3) {
            e(ar);
        }
        return m;
    }

    public static int a(C0644a c0644a) {
        boolean z;
        Context context = c0644a.getContext();
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        d.aw(false);
        if (c0644a.ny()) {
            return b(c0644a);
        }
        if (c0644a.nG()) {
            return a(context, adTemplate, c0644a.nu(), c0644a.gX(), c0644a.Ky, c0644a.nB(), false, c0644a.nx());
        }
        com.kwad.sdk.commercial.e.a.f(adTemplate, false);
        if (c(c0644a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        int an = com.kwad.sdk.core.response.b.a.an(dP);
        if (c0644a.nJ() != 2 && c0644a.nJ() != 1) {
            z = false;
        } else {
            z = true;
        }
        if (!z && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dP)) && !c0644a.nF()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(dP)) {
                    return k(c0644a);
                }
                return l(c0644a);
            } else if (an == 2) {
                int h = h(c0644a);
                if (h == 1) {
                    return 13;
                }
                if (h == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(dP)) {
                    return k(c0644a);
                }
                return l(c0644a);
            }
        }
        int h2 = h(c0644a);
        if (h2 == 1) {
            return 13;
        }
        if (h2 == 2) {
            return 16;
        }
        int i = i(c0644a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0644a.nE() && !com.kwad.sdk.core.response.b.a.aF(dP)) {
            return n(c0644a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(dP)) {
            if (adTemplate.isWebViewDownload) {
                return m(c0644a);
            }
            if (j(c0644a)) {
                return 11;
            }
            return l(c0644a);
        } else if (c0644a.nJ() != 2 && c0644a.nJ() != 1) {
            if (c0644a.nE() && com.kwad.sdk.core.response.b.a.b(dP, com.kwad.sdk.core.config.d.AJ()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(dP)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int r = c0644a.gX().r(c0644a);
                if (r == 0) {
                    return k(c0644a);
                }
                e(c0644a);
                d(adTemplate, r);
                return r;
            }
            e(c0644a);
            c0644a.ar(true);
            return m(c0644a);
        } else {
            c0644a.ar(false);
            e(c0644a);
            return m(c0644a);
        }
    }

    public static void a(k.b bVar) {
        if (Kp == null) {
            Kp = new CopyOnWriteArrayList();
        }
        Kp.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (Kp == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i < Kp.size()) {
                WeakReference<k.b> weakReference = Kp.get(i);
                if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i != -1) {
            Kp.remove(i);
        }
    }

    public static boolean c(C0644a c0644a) {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(c0644a.getAdTemplate()))) {
            if (c0644a.nH() || c.B(c0644a) != 3) {
                return false;
            }
            return true;
        } else if (d(c0644a) != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int d(C0644a c0644a) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(c0644a.getAdTemplate());
        if (dP.unDownloadConf.unDownloadRegionConf != null) {
            int cU = c0644a.cU();
            if (cU != 2) {
                if (cU != 3) {
                    return dP.unDownloadConf.unDownloadRegionConf.actionBarType;
                }
                return dP.unDownloadConf.unDownloadRegionConf.materialJumpType;
            }
            return dP.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        return 0;
    }

    public static void e(C0644a c0644a) {
        if (c0644a.ns()) {
            return;
        }
        g(c0644a);
        f(c0644a);
        if (c0644a.nu() != null) {
            c0644a.nu().onAdClicked();
        }
        com.kwad.sdk.commercial.e.a.bd(c0644a.getAdTemplate());
    }

    public static void f(C0644a c0644a) {
        if (c0644a.nC()) {
            com.kwad.sdk.core.report.a.a(c0644a.adTemplate, c0644a.KD, c0644a.hl());
        }
    }

    public static boolean j(C0644a c0644a) {
        AdTemplate adTemplate = c0644a.getAdTemplate();
        boolean h = com.kwad.sdk.utils.d.h(c0644a.getContext(), adTemplate);
        if (h) {
            e(c0644a);
            com.kwad.sdk.core.report.a.n(adTemplate, 0);
            d(adTemplate, 11);
        }
        return h;
    }

    public static int m(C0644a c0644a) {
        c gX = c0644a.gX();
        if (gX == null) {
            gX = new c(c0644a.adTemplate);
            c0644a.b(gX);
        }
        int s = gX.s(c0644a);
        d(c0644a.getAdTemplate(), s);
        return s;
    }

    public static int n(C0644a c0644a) {
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (j(c0644a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(dP, com.kwad.sdk.core.config.d.AJ()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0644a);
        }
        return l(c0644a);
    }

    public static int b(C0644a c0644a) {
        Context context = c0644a.getContext();
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        Activity m186do = l.m186do(context);
        if (m186do != null && com.kwad.sdk.core.response.b.a.V(dP) && !c0644a.ns() && !c0644a.nx()) {
            c0644a.ak(2);
            com.kwad.components.core.e.e.e.a(m186do, c0644a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0655a().am(com.kwad.sdk.core.response.b.b.cA(adTemplate)).as(adTemplate).aC(true).pa());
        d(adTemplate, 20);
        return 20;
    }

    public static int h(C0644a c0644a) {
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        int a = d.a(c0644a, 1);
        if (a == 1) {
            d.aw(true);
            e(c0644a);
            if (com.kwad.sdk.core.response.b.a.cI(dP) || com.kwad.sdk.core.response.b.a.cJ(dP)) {
                com.kwad.sdk.core.report.a.p(c0644a.getAdTemplate(), (int) Math.ceil(((float) c0644a.nA()) / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (a == 2) {
            e(c0644a);
            d(adTemplate, 16);
        }
        return a;
    }

    public static int i(C0644a c0644a) {
        Context context = c0644a.getContext();
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(c0644a.getAdTemplate());
        Activity m186do = l.m186do(c0644a.getContext());
        if (m186do != null && com.kwad.sdk.core.response.b.a.U(dP) && !c0644a.ns() && e.E(dP) && !c0644a.nx()) {
            c0644a.ak(1);
            com.kwad.components.core.e.e.e.a(m186do, c0644a);
            e(c0644a);
            d(adTemplate, 17);
            return 2;
        }
        int d = e.d(context, adTemplate);
        if (d == 1) {
            e(c0644a);
            d(adTemplate, 12);
        }
        return d;
    }

    public static int l(C0644a c0644a) {
        e(c0644a);
        Context context = c0644a.getContext();
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        Activity m186do = l.m186do(context);
        if (m186do != null && com.kwad.sdk.core.response.b.a.V(dP) && !c0644a.ns() && !c0644a.nx()) {
            c0644a.ak(2);
            com.kwad.components.core.e.e.e.a(m186do, c0644a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0655a().am(com.kwad.sdk.core.response.b.b.cA(adTemplate)).as(adTemplate).aD(c0644a.nv()).av(1).pa());
        d(adTemplate, 14);
        return 14;
    }

    public static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.e.a.bt(adTemplate);
                return;
            case 1:
                com.kwad.sdk.commercial.e.a.bi(adTemplate);
                return;
            case 2:
                com.kwad.sdk.commercial.e.a.bs(adTemplate);
                return;
            case 3:
                com.kwad.sdk.commercial.e.a.bk(adTemplate);
                return;
            case 4:
                com.kwad.sdk.commercial.e.a.bq(adTemplate);
                return;
            case 5:
                com.kwad.sdk.commercial.e.a.br(adTemplate);
                return;
            case 6:
                com.kwad.sdk.commercial.e.a.bl(adTemplate);
                return;
            case 7:
                com.kwad.sdk.commercial.e.a.bm(adTemplate);
                return;
            case 8:
                com.kwad.sdk.commercial.e.a.bn(adTemplate);
                return;
            case 9:
                com.kwad.sdk.commercial.e.a.bp(adTemplate);
                return;
            case 10:
                com.kwad.sdk.commercial.e.a.bo(adTemplate);
                return;
            case 11:
                com.kwad.sdk.commercial.e.a.bh(adTemplate);
                return;
            case 12:
                com.kwad.sdk.commercial.e.a.bg(adTemplate);
                return;
            case 13:
                com.kwad.sdk.commercial.e.a.bf(adTemplate);
                return;
            case 14:
                com.kwad.sdk.commercial.e.a.be(adTemplate);
                return;
            case 15:
                com.kwad.sdk.commercial.e.a.bj(adTemplate);
                return;
            case 16:
                com.kwad.sdk.commercial.e.a.bv(adTemplate);
                return;
            case 17:
                com.kwad.sdk.commercial.e.a.by(adTemplate);
                return;
            case 18:
                com.kwad.sdk.commercial.e.a.bu(adTemplate);
                return;
            case 19:
                com.kwad.sdk.commercial.e.a.bw(adTemplate);
                return;
            case 20:
                com.kwad.sdk.commercial.e.a.bx(adTemplate);
                return;
            default:
                return;
        }
    }

    public static void g(C0644a c0644a) {
        k.b bVar;
        List<WeakReference<k.b>> list = Kp;
        if (list != null && !list.isEmpty() && c0644a.adTemplate != null) {
            for (WeakReference<k.b> weakReference : Kp) {
                if (weakReference != null && (bVar = weakReference.get()) != null) {
                    bVar.H(com.kwad.sdk.core.response.b.e.dZ(c0644a.adTemplate));
                }
            }
        }
    }

    public static int k(C0644a c0644a) {
        e(c0644a);
        AdTemplate adTemplate = c0644a.getAdTemplate();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(c0644a.getAdTemplate());
        Activity m186do = l.m186do(c0644a.getContext());
        if (m186do != null && com.kwad.sdk.core.response.b.a.V(dP) && !c0644a.ns() && !c0644a.nx()) {
            c0644a.ak(2);
            com.kwad.components.core.e.e.e.a(m186do, c0644a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0644a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }
}
