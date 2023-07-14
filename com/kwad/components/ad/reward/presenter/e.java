package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.reward.l;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e {
    public static long pD;

    /* loaded from: classes10.dex */
    public interface a {
        boolean bJ();
    }

    /* loaded from: classes10.dex */
    public interface b extends a {
        void bI();
    }

    public static boolean U(String str) {
        if (!com.kwad.components.ad.reward.kwai.b.gh()) {
            com.kwad.sdk.core.e.b.e(str, "isEnable false");
            return true;
        }
        int gg = com.kwad.components.ad.reward.kwai.b.gg();
        com.kwad.sdk.core.e.b.d(str, "JumpDirectMaxCount " + gg);
        return gg <= 0 || com.kwad.components.ad.reward.e.a.cp() >= gg;
    }

    public static void a(final com.kwad.components.ad.reward.k kVar, @NonNull final l.b bVar) {
        String str;
        final com.kwad.components.ad.reward.j.a aVar = kVar.eF;
        final AdTemplate adTemplate = kVar.mAdTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        final JSONObject jSONObject = kVar.mReportExtData;
        long Q = com.kwad.sdk.core.response.a.a.Q(bQ);
        if (Q <= 0 || com.kwad.sdk.core.response.a.a.B(bQ) <= Q) {
            str = "观看完整视频即可获取奖励";
        } else {
            str = "观看视频" + Q + "s即可获取奖励";
        }
        final l.c a2 = com.kwad.components.ad.reward.l.a(kVar, str);
        com.kwad.components.ad.reward.k.a(kVar, a2, new l.b() { // from class: com.kwad.components.ad.reward.presenter.e.4
            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
            public final void G(boolean z) {
                com.kwad.components.ad.reward.k.this.mx = false;
                if (!z) {
                    com.kwad.sdk.core.report.a.r(adTemplate, Cea708Decoder.COMMAND_SWA);
                }
                l.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.G(z);
                }
            }

            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
            public final void fH() {
                com.kwad.components.ad.reward.k.this.mx = true;
                aVar.pause();
                if (a2.getStyle() == 0) {
                    com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.c(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
            public final void fI() {
                aVar.resume();
                if (a2.getStyle() == 1 || a2.getStyle() == 2 || a2.getStyle() == 5 || a2.getStyle() == 8) {
                    com.kwad.sdk.core.report.a.r(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.report.a.l(adTemplate, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.a
            public final void fJ() {
                super.fJ();
                com.kwad.sdk.core.report.a.r(adTemplate, 150);
                com.kwad.components.ad.reward.k kVar2 = com.kwad.components.ad.reward.k.this;
                kVar2.a(kVar2.mContext, Cea708Decoder.COMMAND_DS4, 1);
            }

            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.a
            public final void g(int i, int i2) {
                super.g(i, i2);
                com.kwad.components.ad.reward.k kVar2 = com.kwad.components.ad.reward.k.this;
                kVar2.a(kVar2.mContext, i, i2);
            }
        });
    }

    public static void a(com.kwad.components.ad.reward.k kVar, b bVar) {
        boolean t = com.kwad.components.ad.reward.p.t(kVar.mAdTemplate);
        m(kVar);
        if (t && bVar != null && bVar.bJ()) {
            return;
        }
        a(kVar.EG);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
        r12 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(final com.kwad.components.ad.reward.k kVar, boolean z, @Nullable a aVar) {
        AdTemplate adTemplate = kVar.mAdTemplate;
        final AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        final IActivityProxy iActivityProxy = kVar.EG;
        if (!kVar.mz) {
            kVar.mAdOpenInteractionListener.onSkippedVideo();
            if (com.kwad.sdk.core.response.a.a.bf(bQ)) {
                kVar.release();
                a(iActivityProxy);
                return;
            } else if (kVar.mA) {
                i(kVar);
                return;
            } else {
                com.kwad.sdk.core.report.a.j(adTemplate, kVar.mReportExtData);
                kVar.eF.release();
                kVar.fr();
                k(kVar);
                return;
            }
        }
        h(kVar);
        boolean z2 = false;
        boolean z3 = !kVar.mRewardVerifyCalled && z(kVar.mAdTemplate);
        if (o(adTemplate) || p(adTemplate) || kVar.mP < com.kwad.sdk.core.response.a.a.T(bQ)) {
            boolean z4 = kVar.fD() ? false : false;
            if (!z3) {
                if (com.kwad.sdk.core.response.a.a.bg(bQ)) {
                    kVar.release();
                    a(iActivityProxy);
                    return;
                }
                i(kVar);
                com.kwad.components.ad.reward.n.g(kVar);
                return;
            }
            if (z4 && aVar != null && aVar.bJ()) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            a(kVar, new l.b() { // from class: com.kwad.components.ad.reward.presenter.e.1
                @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
                public final void G(boolean z5) {
                    super.G(z5);
                    if (com.kwad.components.ad.reward.kwai.b.j(AdInfo.this)) {
                        e.a(iActivityProxy);
                    } else if (com.kwad.sdk.core.response.a.a.bg(AdInfo.this)) {
                        kVar.release();
                        e.a(iActivityProxy);
                    } else {
                        e.i(kVar);
                        com.kwad.components.ad.reward.n.g(kVar);
                    }
                }
            });
        } else if (kVar.mJ) {
            a(iActivityProxy);
        } else if (!kVar.mQ && kVar.mP < com.kwad.sdk.core.response.a.a.T(bQ)) {
            if (z) {
                a(iActivityProxy);
            }
        } else {
            if (kVar.mQ) {
                kVar.L(2);
            } else {
                kVar.L(1);
            }
            n(kVar);
            if (com.kwad.sdk.core.response.a.a.bg(bQ)) {
                kVar.release();
                a(iActivityProxy);
                return;
            }
            i(kVar);
            com.kwad.components.ad.reward.n.g(kVar);
        }
    }

    public static void a(IActivityProxy iActivityProxy) {
        if (iActivityProxy == null) {
            return;
        }
        iActivityProxy.finish();
    }

    public static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        String str2;
        if (com.kwad.sdk.core.response.a.a.aY(adInfo)) {
            str2 = "is playable return";
        } else if (!com.kwad.sdk.core.response.a.a.am(adInfo)) {
            str2 = "is not Download type";
        } else if (adTemplate.mPlayAgain != null) {
            str2 = "is playAgain return";
        } else if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(adInfo))) {
            str2 = "isRewardLaunchAppTask";
        } else if (!com.kwad.sdk.core.response.a.b.cg(adInfo)) {
            return false;
        } else {
            str2 = "is Aggregation return";
        }
        com.kwad.sdk.core.e.b.i(str, str2);
        return true;
    }

    public static void b(com.kwad.components.ad.reward.k kVar, b bVar) {
        AdTemplate adTemplate = kVar.mAdTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        boolean t = com.kwad.components.ad.reward.p.t(adTemplate);
        if (kVar.mz) {
            int ft = kVar.ft();
            boolean z = true;
            if (!o(adTemplate) && !p(adTemplate)) {
                if (com.kwad.sdk.core.response.a.b.bx(kVar.mAdTemplate) && kVar.mAdTemplate.mPlayAgain != null && !kVar.fx() && kVar.mRewardVerifyCalled && ft == 2) {
                    if (bVar != null) {
                        bVar.bI();
                        return;
                    }
                    return;
                }
                if (kVar.mQ || kVar.mP >= com.kwad.sdk.core.response.a.a.T(bQ)) {
                    n(kVar);
                }
                m(kVar);
                if ((t && bVar != null && bVar.bJ()) ? false : false) {
                    return;
                }
                a(kVar.EG);
                return;
            }
            h(kVar);
            if ((kVar.mRewardVerifyCalled || !z(kVar.mAdTemplate) || kVar.mC) ? false : false) {
                l(kVar);
                return;
            }
        }
        m(kVar);
        a(kVar.EG);
    }

    public static void h(com.kwad.components.ad.reward.k kVar) {
        long j = kVar.mO;
        int i = j != 0 ? (int) (j / 1000) : 0;
        long j2 = kVar.mP;
        int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
        u.b bVar = new u.b();
        bVar.abE = 69;
        bVar.abP = i;
        bVar.abQ = i2;
        com.kwad.sdk.core.report.a.b(kVar.mAdTemplate, 141, bVar, kVar.mReportExtData);
    }

    public static void i(final com.kwad.components.ad.reward.k kVar) {
        long j = kVar.mP;
        int i = j != 0 ? (int) (j / 1000) : 0;
        kVar.mC = true;
        AdTemplate adTemplate = kVar.mAdTemplate;
        com.kwad.sdk.core.report.a.d(adTemplate, com.kwad.sdk.core.response.a.a.R(com.kwad.sdk.core.response.a.d.bQ(adTemplate)), i);
        if (g.r(kVar)) {
            bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.j(com.kwad.components.ad.reward.k.this);
                }
            }, 200L);
        } else {
            j(kVar);
        }
    }

    public static void j(com.kwad.components.ad.reward.k kVar) {
        kVar.eF.skipToEnd();
    }

    public static void k(com.kwad.components.ad.reward.k kVar) {
        com.kwad.sdk.core.e.b.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - pD < 300) {
            com.kwad.sdk.core.e.b.d("openAppMarket", "连续点击");
            return;
        }
        pD = elapsedRealtime;
        if (U("openAppMarket")) {
            return;
        }
        AdTemplate adTemplate = kVar.mAdTemplate;
        Context context = kVar.mContext;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (a("openAppMarket", adTemplate, bQ)) {
            return;
        }
        String bO = com.kwad.sdk.core.response.a.a.bO(bQ);
        com.kwad.sdk.core.e.b.i("openAppMarket", "tryOpenMiAppStore url：" + bO);
        if (com.kwad.sdk.utils.d.a(context, bO, adTemplate)) {
            com.kwad.sdk.core.report.a.g(adTemplate, 2);
            com.kwad.sdk.core.report.a.c(adTemplate, 1, 8);
            com.kwad.components.ad.reward.e.a.I(context);
        } else if (!com.kwad.sdk.utils.d.e(context, bO, com.kwad.sdk.core.response.a.a.ag(bQ))) {
            com.kwad.sdk.core.e.b.i("openAppMarket", "tryOpenMiAppStore failed");
        } else {
            com.kwad.sdk.core.report.a.g(adTemplate, 2);
            com.kwad.sdk.core.report.a.c(adTemplate, 0, 8);
            com.kwad.components.ad.reward.e.a.I(context);
        }
    }

    public static void l(final com.kwad.components.ad.reward.k kVar) {
        final AdTemplate adTemplate = kVar.mAdTemplate;
        com.kwad.components.ad.reward.k.a(kVar, com.kwad.components.ad.reward.l.a(kVar, (String) null), new l.b() { // from class: com.kwad.components.ad.reward.presenter.e.3
            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
            public final void G(boolean z) {
                com.kwad.components.ad.reward.k.this.mx = false;
                if (!z) {
                    com.kwad.sdk.core.report.a.r(adTemplate, Cea708Decoder.COMMAND_SWA);
                }
                e.m(com.kwad.components.ad.reward.k.this);
                e.a(com.kwad.components.ad.reward.k.this.EG);
            }

            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
            public final void fH() {
                com.kwad.components.ad.reward.k kVar2 = com.kwad.components.ad.reward.k.this;
                kVar2.mx = true;
                com.kwad.sdk.core.report.a.c(adTemplate, 149, kVar2.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.core.webview.b.d.c
            public final void fI() {
                com.kwad.sdk.core.report.a.r(adTemplate, 150);
            }
        });
    }

    public static void m(com.kwad.components.ad.reward.k kVar) {
        kVar.mAdOpenInteractionListener.j(false);
    }

    public static void n(com.kwad.components.ad.reward.k kVar) {
        kVar.mAdOpenInteractionListener.onRewardVerify();
    }

    public static boolean o(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
    }

    public static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.p(adTemplate);
    }

    public static boolean z(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.V(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
    }
}
