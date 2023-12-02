package com.kwad.components.ad.interstitial.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.g.a.a.b;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.s.j;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.g;
import com.kwad.components.core.webview.tachikoma.a.n;
import com.kwad.components.core.webview.tachikoma.a.q;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.io.File;
/* loaded from: classes10.dex */
public final class b extends a {
    public static long ld = 400;
    public d eg;
    public Vibrator eh;
    public aw fD;
    @Nullable
    public com.kwad.components.ad.g.a.a.b lb;
    public FrameLayout lc;
    public boolean lf;
    public e lg;
    public boolean le = false;
    public final c.a jP = new c.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.1
        @Override // com.kwad.components.ad.interstitial.e.c.a
        public final void b(long j, long j2) {
            com.kwad.components.ad.interstitial.report.a.dM().b(b.this.jK.mAdTemplate, j, j2);
            if (b.this.lg != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.ZP = b.this.jK.jM ? 1 : 0;
                b.this.lg.b(aVar);
            }
        }
    };
    public com.kwad.sdk.core.h.c df = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.e.a.b.9
        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aM() {
            if (b.this.fD != null && !b.this.le) {
                b.a(b.this, true);
                b.this.fD.sg();
                b.this.fD.sh();
            }
            if (b.this.fD != null) {
                b.this.fD.sk();
            }
            if (b.this.lb != null) {
                b.this.lb.eG();
            }
            if (!b.this.lf) {
                b.this.jK.io.getTimerHelper().startTiming();
            }
            if (!b.this.lf && !b.this.jK.jO && b.this.jK.ie != null) {
                b.this.jK.ie.onAdShow();
                com.kwad.components.ad.interstitial.report.c.dQ().a(b.this.jK.mAdTemplate, 3);
                b.b(b.this, true);
            }
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aN() {
            if (b.this.fD != null) {
                b.this.fD.sl();
            }
            if (b.this.lb != null) {
                b.this.lb.eF();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    private com.kwad.components.core.webview.tachikoma.c dB() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.e.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.ZR = com.kwad.components.ad.interstitial.d.a.cO();
                cVar.a(cVar2);
            }
        };
    }

    private e dC() {
        return new e() { // from class: com.kwad.components.ad.interstitial.e.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.ZP = b.this.jK.jM ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private g dD() {
        k kVar = new k();
        kVar.ZX = this.jK.jY;
        return new g(kVar);
    }

    private com.kwad.components.ad.g.a.a.a dE() {
        final com.kwad.components.ad.g.a.a.a aVar = new com.kwad.components.ad.g.a.a.a();
        this.jK.jU.add(new c.InterfaceC0601c() { // from class: com.kwad.components.ad.interstitial.e.a.b.16
            @Override // com.kwad.components.ad.interstitial.e.c.InterfaceC0601c
            public final void cZ() {
                aVar.eD();
            }
        });
        return aVar;
    }

    private bf dF() {
        bf bfVar = new bf(getContext(), this.jK.mAdTemplate);
        bfVar.a(new bf.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.bf.a
            public final boolean dK() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jK.mAdTemplate);
                b.this.jK.a(true, -1, null);
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.dt();
                    }
                }, 0L);
                return false;
            }
        });
        return bfVar;
    }

    @NonNull
    private n dG() {
        return new n() { // from class: com.kwad.components.ad.interstitial.e.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z;
                        com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                        if (!ag.isWifiConnected(b.this.getContext()) && !b.this.jK.dU.isDataFlowAutoStart() && !b.k(b.this.jK.mAdTemplate)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        dVar.ZS = z;
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    private ai dH() {
        return new ai(new ai.b() { // from class: com.kwad.components.ad.interstitial.e.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(final ai.a aVar) {
                if (b.this.jK.io != null) {
                    b.this.jK.jS.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean z = true;
                            if (aVar.type != 0 || b.this.jK.jM || b.this.jK.jN || !com.kwad.components.ad.interstitial.f.a.d(b.this.jK)) {
                                b.this.dJ();
                                c cVar = b.this.jK;
                                if (aVar.type != 3) {
                                    z = false;
                                }
                                cVar.a(z, aVar.WX, null);
                                b.this.dt();
                                return;
                            }
                            b.this.jK.jN = true;
                            com.kwad.components.ad.interstitial.c.b.I(b.this.getContext());
                        }
                    });
                }
            }
        });
    }

    private v dI() {
        return new v() { // from class: com.kwad.components.ad.interstitial.e.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                if (!b.this.jK.jO && b.this.jK.ie != null) {
                    b.this.jK.ie.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                if (!b.this.jK.jO && b.this.jK.ie != null) {
                    b.this.jK.ie.onVideoPlayEnd();
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                b.this.jK.mAdTemplate.setmCurPlayTime(xVar.nD);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ() {
        aw awVar = this.fD;
        if (awVar != null) {
            awVar.si();
            this.fD.sj();
        }
        com.kwad.components.ad.g.a.a.b bVar = this.lb;
        if (bVar != null) {
            bVar.eF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt() {
        c cVar = this.jK;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.io;
        if (dVar != null && a(dVar)) {
            this.jK.io.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jK.ie;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.b(th);
        }
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0655a().al(bVar.title).am(bVar.url).aB(true).l(b.this.jK.mAdResultData).pa());
            }
        };
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        com.kwad.components.ad.interstitial.report.c.dQ().s(this.jK.mAdTemplate);
        if (this.fD != null && this.jK.ib.dW()) {
            this.le = true;
            this.fD.sg();
            this.fD.sh();
        }
        this.jK.ib.a(this.df);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.lc;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ds(this.jK.mAdTemplate);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0914dc);
        this.lc = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.le = false;
        this.lf = false;
        bn.b(getContext(), this.eh);
        d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.jK.ib;
        if (bVar != null) {
            bVar.b(this.df);
        }
        this.jK.b(this.jP);
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.x a(com.kwad.sdk.core.webview.b bVar) {
        return new com.kwad.components.core.webview.jshandler.x(bVar, this.jK.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.dM().a(b.this.jK.mAdTemplate, aVar.aDI, aVar.kk);
                    b.this.jK.jM = true;
                    if (!b.this.jK.jO) {
                        b.this.jK.b(aVar.aDI, aVar.kk);
                    }
                    if (b.this.jK.io != null && com.kwad.components.ad.interstitial.b.b.cK()) {
                        b.this.jK.a(false, -1, b.this.jK.eN);
                        b.this.jK.io.dismiss();
                    }
                }
            }
        });
    }

    public static boolean k(@NonNull AdTemplate adTemplate) {
        File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
        if (bO != null && bO.exists()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.lf = true;
        return true;
    }

    public static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        if (ownerActivity != null && !ownerActivity.isFinishing()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.le = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        if (getContext() != null) {
            this.eh = (Vibrator) getContext().getSystemService("vibrator");
        }
        float cQ = com.kwad.sdk.core.response.b.b.cQ(this.jK.mAdTemplate);
        if (this.eg == null) {
            d dVar = new d(cQ);
            this.eg = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.e.a.b.7
                @Override // com.kwad.sdk.core.g.b
                public final void aV() {
                }

                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    if (bq.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d);
                    }
                    bn.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.a.b.7.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.eg.El();
                        }
                    }, null, 500L);
                }
            });
        }
        this.eg.e(cQ);
        this.eg.bi(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d) {
        this.jK.a(new c.b(getContext()).l(true).c(d).z(2).a(this.jK.jS.getTouchCoords()).A(Cea708Decoder.COMMAND_DF5));
        bn.vibrate(getContext(), this.eh, ld);
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.fD = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.lc.setVisibility(8);
        com.kwad.components.core.webview.tachikoma.e.e eVar = this.jK.jR;
        if (eVar != null) {
            getTkTemplateId();
            eVar.q(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.jK.ie;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z;
        c cVar = this.jK;
        if (webCloseStatus.closeType == 2) {
            z = true;
        } else {
            z = false;
        }
        cVar.a(z, -1, null);
        dt();
    }

    @Override // com.kwad.components.ad.interstitial.e.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        com.kwad.components.ad.g.a.a.b z = com.kwad.components.ad.g.a.a.b.z(this.jK.mAdTemplate);
        this.lb = z;
        if (z != null) {
            z.a(new b.InterfaceC0592b() { // from class: com.kwad.components.ad.interstitial.e.a.b.10
                @Override // com.kwad.components.ad.g.a.a.b.InterfaceC0592b
                public final void E(int i) {
                    if (i == com.kwad.components.ad.g.a.a.b.nt) {
                        b.this.jK.b(b.this.getContext(), b.this.jK.mAdTemplate);
                        b.this.jK.a(true, -1, null);
                    }
                    b.this.dt();
                }
            });
            pVar.c(this.lb);
            this.lb.eE();
        }
        pVar.c(dH());
        pVar.c(new ao(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.b.b.dl(com.kwad.sdk.core.response.b.e.dP(this.jK.mAdTemplate))) {
            pVar.c(new ay(new ay.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    b.this.bu();
                }
            }));
        }
        pVar.c(dG());
        pVar.c(dF());
        pVar.c(dD());
        pVar.c(a(bVar));
        pVar.c(dI());
        pVar.c(dE());
        pVar.c(new q() { // from class: com.kwad.components.ad.interstitial.e.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                j.e(b.this.getContext(), b.this.jK.mAdTemplate);
            }
        });
        this.lg = dC();
        this.jK.a(this.jP);
        pVar.c(this.lg);
        pVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.interstitial.e.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dL() {
                com.kwad.components.ad.interstitial.d.a.J(b.this.getContext());
            }
        }));
        pVar.c(dB());
    }
}
