package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f {
    public static long sf;

    public static boolean E(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
    }

    public static boolean F(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.F(adTemplate);
    }

    public static boolean M(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.ak(com.kwad.sdk.core.response.b.e.dP(adTemplate));
    }

    public static void n(final com.kwad.components.ad.reward.g gVar) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.reward.g.this.fM();
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.oH.onVideoSkipToEnd(gVar2.pu);
                com.kwad.components.ad.reward.g.this.release();
                com.kwad.components.ad.reward.g.this.hn();
            }
        });
    }

    public static void o(com.kwad.components.ad.reward.g gVar) {
        int i;
        long j = gVar.pt;
        int i2 = 0;
        if (j != 0) {
            i = (int) (j / 1000);
        } else {
            i = 0;
        }
        long j2 = gVar.pu;
        if (j2 != 0) {
            i2 = (int) (j2 / 1000);
        }
        com.kwad.sdk.core.report.a.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.report.j().cC(69).cF(i).cG(i2));
    }

    public static void p(final com.kwad.components.ad.reward.g gVar) {
        gVar.pc = true;
        gVar.fM();
        if (i.x(gVar)) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.q(com.kwad.components.ad.reward.g.this);
                }
            }, 200L);
        } else {
            q(gVar);
        }
    }

    public static void q(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.oQ, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: c */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.iJ();
            }
        });
        com.kwad.components.ad.reward.m.e eVar = gVar.oI;
        if (eVar != null) {
            eVar.skipToEnd();
        }
    }

    public static void r(com.kwad.components.ad.reward.g gVar) {
        v(gVar);
        gVar.hn();
    }

    public static void u(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void F(boolean z) {
                com.kwad.components.ad.reward.g.this.D(false);
                if (!z) {
                    com.kwad.sdk.core.report.a.s(adTemplate, Cea708Decoder.COMMAND_SWA);
                }
                f.v(com.kwad.components.ad.reward.g.this);
                com.kwad.components.ad.reward.g.this.hn();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fP() {
                com.kwad.components.ad.reward.g.this.D(true);
                com.kwad.sdk.core.report.a.b(adTemplate, 149, com.kwad.components.ad.reward.g.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fY() {
                com.kwad.components.ad.reward.g.this.D(false);
                com.kwad.sdk.core.report.a.s(adTemplate, 150);
            }
        });
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        gVar.oH.h(false);
    }

    public static void w(com.kwad.components.ad.reward.g gVar) {
        gVar.oH.onRewardVerify();
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, @NonNull final h.b bVar) {
        String str;
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long ad = com.kwad.sdk.core.response.b.a.ad(dP);
        if (ad > 0 && com.kwad.sdk.core.response.b.a.L(dP) > ad) {
            str = "观看视频" + ad + "s即可获取奖励";
        } else {
            str = "观看完整视频即可获取奖励";
        }
        final h.c a = com.kwad.components.ad.reward.h.a(gVar, str);
        com.kwad.components.ad.reward.g.a(gVar, a, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void F(boolean z) {
                com.kwad.components.ad.reward.g.this.D(false);
                if (!z) {
                    com.kwad.sdk.core.report.a.s(adTemplate, Cea708Decoder.COMMAND_SWA);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.F(z);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fP() {
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.oI;
                if (eVar != null) {
                    eVar.pause();
                }
                com.kwad.components.ad.reward.g.this.D(true);
                if (a.getStyle() == 0) {
                    com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void fW() {
                super.fW();
                com.kwad.sdk.core.report.a.s(adTemplate, 150);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, Cea708Decoder.COMMAND_DS4, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fX() {
                super.fX();
                com.kwad.components.ad.reward.g.this.D(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fY() {
                com.kwad.components.ad.reward.g.this.D(false);
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.oI;
                if (eVar != null) {
                    eVar.resume();
                }
                if (a.getStyle() != 1 && a.getStyle() != 2 && a.getStyle() != 5 && a.getStyle() != 8) {
                    com.kwad.sdk.core.report.a.l(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.s(adTemplate, 150);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void i(int i, int i2) {
                super.i(i, i2);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, i, i2);
            }
        });
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z) {
        boolean z2;
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (!gVar.oX) {
            m(gVar);
            return;
        }
        o(gVar);
        if (!gVar.fL() && M(gVar.mAdTemplate)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!E(adTemplate) && !F(adTemplate) && gVar.pu >= com.kwad.sdk.core.response.b.a.ag(dP)) {
            if (gVar.po) {
                gVar.hn();
            } else if (!gVar.pv && gVar.pu < com.kwad.sdk.core.response.b.a.ag(dP)) {
                if (z) {
                    gVar.hn();
                }
            } else {
                if (gVar.pv) {
                    gVar.L(2);
                } else {
                    gVar.L(1);
                }
                w(gVar);
                if (com.kwad.sdk.core.response.b.a.bS(dP)) {
                    n(gVar);
                    return;
                }
                p(gVar);
                com.kwad.components.ad.reward.k.h(gVar);
            }
        } else if (z2) {
            a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                public final void F(boolean z3) {
                    super.F(z3);
                    if (com.kwad.components.ad.reward.a.b.k(AdInfo.this)) {
                        gVar.hn();
                    } else if (com.kwad.sdk.core.response.b.a.bS(AdInfo.this)) {
                        f.n(gVar);
                    } else {
                        f.p(gVar);
                        com.kwad.components.ad.reward.k.h(gVar);
                    }
                }
            });
        } else if (com.kwad.sdk.core.response.b.a.bS(dP)) {
            n(gVar);
        } else {
            p(gVar);
            com.kwad.components.ad.reward.k.h(gVar);
        }
    }

    public static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.gz()) {
            com.kwad.sdk.core.e.c.e(str, "isEnable false");
            return true;
        } else if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cN(adInfo))) {
            return true;
        } else {
            int gy = com.kwad.components.ad.reward.a.b.gy();
            com.kwad.sdk.core.e.c.d(str, "JumpDirectMaxCount " + gy);
            if (gy <= 0 || com.kwad.components.ad.reward.h.a.cM() >= gy) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bH(adInfo)) {
            com.kwad.sdk.core.e.c.i(str, "is playable return");
            return true;
        } else if (!com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            com.kwad.sdk.core.e.c.i(str, "is not Download type");
            return true;
        } else if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.e.c.i(str, "isRewardLaunchAppTask");
            return true;
        } else if (com.kwad.components.ad.reward.g.g(adInfo)) {
            com.kwad.sdk.core.e.c.i(str, "is Aggregation return");
            return true;
        } else {
            return false;
        }
    }

    public static void m(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.bR(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate))) {
            n(gVar);
        } else if (gVar.oZ) {
            p(gVar);
        } else {
            gVar.pc = true;
            com.kwad.components.ad.reward.g.a(gVar.oQ, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: c */
                public void accept(com.kwad.components.ad.reward.k.a aVar) {
                    aVar.iJ();
                }
            });
            gVar.oH.onVideoSkipToEnd(0L);
            com.kwad.sdk.core.report.a.j(gVar.mAdTemplate, gVar.mReportExtData);
            com.kwad.components.ad.reward.m.e eVar = gVar.oI;
            if (eVar != null) {
                eVar.release();
            }
            gVar.fA();
            s(gVar);
        }
    }

    public static void s(com.kwad.components.ad.reward.g gVar) {
        boolean z;
        com.kwad.sdk.core.e.c.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - sf < 300) {
            com.kwad.sdk.core.e.c.d("openAppMarket", "连续点击");
            return;
        }
        sf = elapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (a(dP, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, dP)) {
            return;
        }
        com.kwad.sdk.core.report.j cM = new com.kwad.sdk.core.report.j().cA(182).cM(8);
        if (com.kwad.sdk.core.download.a.b.D(context, com.kwad.sdk.core.response.b.a.cK(dP)) == 1) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.core.e.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z);
        if (z) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cM, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.H(context);
            return;
        }
        String cN = com.kwad.sdk.core.response.b.a.cN(dP);
        com.kwad.sdk.core.e.c.i("openAppMarket", "tryOpenMiAppStore url：" + cN);
        if (com.kwad.sdk.utils.d.a(context, cN, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cM, (JSONObject) null);
            com.kwad.sdk.core.report.a.d(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.H(context);
        } else if (com.kwad.sdk.utils.d.h(context, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cM, (JSONObject) null);
            com.kwad.sdk.core.report.a.d(adTemplate, 0, 8);
            com.kwad.components.ad.reward.h.a.H(context);
        } else {
            com.kwad.sdk.core.e.c.i("openAppMarket", "tryOpenMiAppStore failed");
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (!gVar.oX) {
            v(gVar);
            gVar.hn();
            return;
        }
        boolean z = true;
        if (!E(adTemplate) && !F(adTemplate)) {
            long ag = com.kwad.sdk.core.response.b.a.ag(dP);
            if (!gVar.pv && gVar.pu < ag) {
                z = false;
            }
            if (z) {
                w(gVar);
            }
            v(gVar);
            gVar.hn();
            return;
        }
        o(gVar);
        if ((gVar.fL() || !M(gVar.mAdTemplate) || gVar.pc) ? false : false) {
            u(gVar);
            return;
        }
        v(gVar);
        gVar.hn();
    }
}
