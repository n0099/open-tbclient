package com.kwad.components.ad.interstitial.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class f extends b {
    public com.kwad.components.core.widget.kwai.b aM;
    public com.kwad.sdk.core.video.videoview.a dp;
    public KsAutoCloseView ge;
    public c gh;
    public boolean hm;
    public KSFrameLayout hn;
    public com.kwad.sdk.core.h.c ho = new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.b.f.4
        @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
        public final void aR() {
            if (!f.this.mAdTemplate.mPvReported && !f.this.gh.gn && f.this.gh.fo != null) {
                f.this.gh.fo.onAdShow();
                com.kwad.components.ad.interstitial.monitor.b.cr().a(f.this.gh.mAdTemplate, 1);
            }
            com.kwad.components.core.m.c.ox().a(f.this.mAdTemplate, null, new com.kwad.sdk.core.report.f().aU(ag.cB(f.this.getContext()) ? 2 : 1).aS(f.this.gh.gx));
        }
    };
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public static boolean d(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.aY(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de() {
        final com.kwad.components.ad.interstitial.widget.f fVar = this.gh.gj;
        fVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.aC(this.mAdInfo)) {
            fVar.a(com.kwad.sdk.core.response.a.a.at(this.mAdInfo).materialUrl, this.mAdTemplate);
            fVar.b(true, true);
            fVar.t(false);
        } else {
            fVar.t(true);
            String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                fVar.b(false, false);
            } else {
                fVar.a(url, this.mAdTemplate);
                fVar.b(true, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
            this.dp = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.dp.getParent()).removeView(this.dp);
            }
            if (com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
                fVar.a(com.kwad.sdk.core.response.a.a.au(this.mAdInfo).height / com.kwad.sdk.core.response.a.a.au(this.mAdInfo).width, this.dp);
            }
            fVar.u(this.gh.cN.isVideoSoundEnable());
            final int B = com.kwad.sdk.core.response.a.a.B(this.mAdInfo);
            this.gh.a(new a.b() { // from class: com.kwad.components.ad.interstitial.b.f.5
                @Override // com.kwad.components.core.video.a.b
                public final void bm() {
                    f.this.dp.setVisibility(8);
                    if (f.this.gh.K(f.this.getContext())) {
                        return;
                    }
                    fVar.eb();
                }

                @Override // com.kwad.components.core.video.a.b
                @SuppressLint({"SetTextI18n"})
                public final void d(long j) {
                    int i = B - ((int) (j / 1000));
                    com.kwad.components.ad.interstitial.widget.f fVar2 = fVar;
                    if (i >= 0) {
                        fVar2.B(String.valueOf(i));
                    } else {
                        fVar2.dZ();
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlayStart() {
                    fVar.t(true);
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlaying() {
                    fVar.b(false, false);
                }
            });
            fVar.a(this.mAdTemplate, this.mAdInfo);
            fVar.t(true);
            this.gh.gs.add(new c.InterfaceC0611c() { // from class: com.kwad.components.ad.interstitial.b.f.6
                @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0611c
                public final void cH() {
                    fVar.ec();
                    f.this.dp.setVisibility(0);
                }
            });
        }
        this.gh.a(getContext(), this.mAdInfo, this.mAdTemplate, fVar.getBlurBgView());
        String D = com.kwad.sdk.core.response.a.a.D(this.mAdInfo);
        if (TextUtils.isEmpty(D)) {
            D = com.kwad.sdk.core.response.a.a.K(this.mAdInfo);
        }
        ImageLoaderProxy.INSTANCE.load(fVar.getTailFrameView(), D);
        if (!d(this.mAdInfo)) {
            this.ge.aG(false);
            return;
        }
        this.ge.aG(true);
        df();
    }

    private void df() {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            i = Math.min(i, com.kwad.sdk.core.response.a.a.B(this.mAdInfo));
            this.gh.gj.dZ();
            this.gh.gj.ea();
        }
        this.ge.U(i);
        com.kwad.sdk.core.report.a.c(this.mAdTemplate, 165, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, int i2) {
        Dialog dialog;
        this.gh.a(new c.b(getContext()).l(this.hm).a(this.hn.getTouchCoords()).y(i).z(i2));
        if (!com.kwad.components.ad.interstitial.kwai.b.co() || (dialog = this.gh.gi) == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        c cVar = this.gh;
        if (!cVar.gn && !z && !cVar.gl && !cVar.gm && com.kwad.components.ad.interstitial.c.a.c(cVar)) {
            this.gh.gm = true;
            com.kwad.components.ad.interstitial.a.b.J(getContext());
            return;
        }
        this.gh.a(z, -1, this.dp);
        this.gh.gi.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.dp;
        if (aVar != null) {
            aVar.release();
        }
        c cVar2 = this.gh;
        if (cVar2.gn || (adInteractionListener = cVar2.fo) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        c cVar = (c) xR();
        this.gh = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.gh.gj.i(this.mAdTemplate);
        this.gh.a(new c.e() { // from class: com.kwad.components.ad.interstitial.b.f.2
            @Override // com.kwad.components.ad.interstitial.b.c.e
            public final void onError() {
                f.this.de();
            }
        });
        this.gh.gj.setViewListener(new com.kwad.components.ad.interstitial.widget.i() { // from class: com.kwad.components.ad.interstitial.b.f.3
            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void a(KSFrameLayout kSFrameLayout) {
                f.this.hn = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dh() {
                f.this.n(false);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void di() {
                f.this.e(3, f.this.gh.gj.ed() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dj() {
                f.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dk() {
                f.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dl() {
                f.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dm() {
                f.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dn() {
                f.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            /* renamed from: do  reason: not valid java name */
            public final void mo170do() {
                f.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dp() {
                f.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dq() {
                f.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dr() {
                f.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void ds() {
                f.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void dt() {
                f.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void du() {
                f.this.e(2, 35);
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void o(boolean z) {
                if (f.this.dp != null) {
                    f.this.dp.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.widget.i
            public final void p(boolean z) {
                f.this.hm = z;
            }
        });
        com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this.gh.gj, 100);
        this.aM = bVar;
        bVar.a(this.ho);
        this.aM.qi();
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cv() {
        super.cv();
        this.ge.setCountDownPaused(false);
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cw() {
        super.cw();
        this.ge.setCountDownPaused(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.obfuscated_res_0x7f0912d3);
        this.ge = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.b.f.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dg() {
                f.this.n(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dh() {
                f.this.n(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aM.b(this.ho);
        this.aM.qj();
    }
}
