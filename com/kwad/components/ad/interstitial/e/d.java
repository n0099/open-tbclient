package com.kwad.components.ad.interstitial.e;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends b {
    public static float kr = 0.749f;
    public static float ks = 0.8f;
    public static float kt = 1.0f;
    public com.kwad.components.core.widget.a.b bQ;
    public com.kwad.sdk.core.video.videoview.a eN;
    public KsAutoCloseView jH;
    public c jK;
    public c.a jP;
    public boolean kp;
    public KSFrameLayout kq;
    public com.kwad.sdk.core.h.d ku = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.e.d.5
        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aM() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.jK.jO && d.this.jK.ie != null) {
                d.this.jK.ie.onAdShow();
                d.this.jK.io.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.dQ().a(d.this.jK.mAdTemplate, 1);
            }
            j cM = new j().cM(d.this.jK.jY);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.dQ().u(d.this.mAdTemplate);
            }
            com.kwad.components.core.s.b.qL().a(d.this.mAdTemplate, null, cM);
            d.this.jH.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void aN() {
            d.this.jH.setCountDownPaused(true);
        }
    };
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public static float b(boolean z, boolean z2) {
        return (z && z2) ? 1.7777778f : 0.749f;
    }

    private c.a db() {
        c.a aVar = new c.a() { // from class: com.kwad.components.ad.interstitial.e.d.4
            @Override // com.kwad.components.ad.interstitial.e.c.a
            public final void b(long j, long j2) {
                com.kwad.components.ad.interstitial.report.a.dM().b(d.this.mAdTemplate, j, j2);
            }
        };
        this.jP = aVar;
        return aVar;
    }

    private void dd() {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            i = Math.min(i, com.kwad.sdk.core.response.b.a.L(this.mAdInfo));
            this.jK.jL.ed();
            this.jK.jL.ee();
        }
        this.jH.U(i);
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.obfuscated_res_0x7f091383);
        this.jH = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.e.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void de() {
                d.this.n(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void df() {
                d.this.n(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jK.b(this.jP);
        this.bQ.b(this.ku);
        this.bQ.tn();
    }

    public static ViewGroup.LayoutParams B(int i) {
        int i2 = (int) (i * kr);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    public static ViewGroup.LayoutParams a(int i, boolean z) {
        float f;
        float f2;
        if (z) {
            f = ks;
        } else {
            f = kt;
        }
        if (z) {
            f2 = 1.7777778f;
        } else {
            f2 = 0.749f;
        }
        int i2 = (int) (i * f);
        return new ViewGroup.LayoutParams(i2, (int) (i2 * f2));
    }

    public static boolean c(AdInfo adInfo) {
        if (adInfo.adInsertScreenInfo.autoCloseTime <= 0 || com.kwad.sdk.core.response.b.a.bH(adInfo)) {
            return false;
        }
        return true;
    }

    private void dc() {
        final com.kwad.components.ad.interstitial.g.d dVar = this.jK.jL;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.c(true, true);
            dVar.t(false);
        } else {
            dVar.t(true);
            String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
            if (!TextUtils.isEmpty(url)) {
                dVar.c(url, this.mAdTemplate);
                dVar.c(true, false);
            } else {
                dVar.c(false, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
            this.eN = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            }
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).height / com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).width, this.eN);
            }
            dVar.u(this.jK.dU.isVideoSoundEnable());
            final int L = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
            this.jK.a(new a.c() { // from class: com.kwad.components.ad.interstitial.e.d.6
                @Override // com.kwad.components.core.video.a.c
                public final void bl() {
                    dVar.c(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void bm() {
                    d.this.eN.setVisibility(8);
                    if (!d.this.jK.K(d.this.getContext())) {
                        dVar.ef();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.t(true);
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void e(long j) {
                    int i = L - ((int) (j / 1000));
                    if (i >= 0) {
                        dVar.w(String.valueOf(i));
                    } else {
                        dVar.ed();
                    }
                }
            });
            dVar.a(this.mAdTemplate, this.mAdInfo);
            dVar.t(true);
            this.jK.jU.add(new c.InterfaceC0601c() { // from class: com.kwad.components.ad.interstitial.e.d.7
                @Override // com.kwad.components.ad.interstitial.e.c.InterfaceC0601c
                public final void cZ() {
                    dVar.eg();
                    d.this.eN.setVisibility(0);
                }
            });
        }
        this.jK.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar.getBlurBgView());
        String O = com.kwad.sdk.core.response.b.a.O(this.mAdInfo);
        if (TextUtils.isEmpty(O)) {
            O = com.kwad.sdk.core.response.b.a.X(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar.getTailFrameView(), O, this.mAdTemplate);
        if (c(this.mAdInfo)) {
            this.jH.aX(true);
            dd();
            return;
        }
        this.jH.aX(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2) {
        this.jK.a(new c.b(getContext()).k(this.kp).a(this.kq.getTouchCoords()).z(i).A(i2));
        if (com.kwad.components.ad.interstitial.b.b.cK()) {
            c cVar = this.jK;
            if (cVar.io != null) {
                cVar.a(false, -1, cVar.eN);
                this.jK.io.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        c cVar = this.jK;
        if (!cVar.jO && !z && !cVar.jM && !cVar.jN && com.kwad.components.ad.interstitial.f.a.d(cVar)) {
            this.jK.jN = true;
            com.kwad.components.ad.interstitial.c.b.I(getContext());
            return;
        }
        this.jK.a(z, -1, this.eN);
        this.jK.io.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            aVar.release();
        }
        c cVar2 = this.jK;
        if (!cVar2.jO && (adInteractionListener = cVar2.ie) != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) HU();
        this.jK = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.dQ().t(this.jK.mAdTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.jK.mAdTemplate);
        this.jK.jS.setBackgroundColor(Color.parseColor("#99000000"));
        this.jK.jL.setVisibility(0);
        this.jK.jL.y(this.mAdTemplate);
        this.jK.a(db());
        dc();
        this.jK.jL.setViewListener(new com.kwad.components.ad.interstitial.g.e() { // from class: com.kwad.components.ad.interstitial.e.d.2
            @Override // com.kwad.components.ad.interstitial.g.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.kq = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void o(boolean z) {
                if (d.this.eN != null) {
                    d.this.eN.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void p(boolean z) {
                d.this.kp = z;
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void df() {
                d.this.n(false);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dg() {
                int i;
                if (d.this.jK.jL.eh()) {
                    i = 53;
                } else {
                    i = 85;
                }
                d.this.g(3, i);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dh() {
                d.this.g(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void di() {
                d.this.g(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dj() {
                d.this.g(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dk() {
                d.this.g(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dl() {
                d.this.g(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dm() {
                d.this.g(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dn() {
                d.this.g(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            /* renamed from: do  reason: not valid java name */
            public final void mo179do() {
                d.this.g(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dp() {
                d.this.g(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dq() {
                d.this.g(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void dr() {
                d.this.g(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.g.e
            public final void ds() {
                d.this.g(2, 35);
            }
        });
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this.jK.jL, 100);
        this.bQ = bVar;
        bVar.a(this.ku);
        this.bQ.tm();
        final boolean aW = com.kwad.sdk.core.response.b.a.aW(this.mAdInfo);
        getContext();
        final boolean Kx = ai.Kx();
        this.jK.jL.setRatio(b(Kx, aW));
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091392);
        viewGroup.setVisibility(0);
        viewGroup.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.d.3
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams B;
                if (!Kx) {
                    B = d.B(d.this.getRootView().getHeight());
                } else {
                    B = d.a(d.this.getRootView().getWidth(), aW);
                }
                ViewParent parent = d.this.jK.jL.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.jK.jL);
                }
                viewGroup.addView(d.this.jK.jL);
                d.this.jK.jL.h(B.width, B.height);
                viewGroup.requestLayout();
                viewGroup.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.d.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (d.this.eN != null) {
                            d.this.eN.requestLayout();
                        }
                    }
                });
            }
        });
    }
}
