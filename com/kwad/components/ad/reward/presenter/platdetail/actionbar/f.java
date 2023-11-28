package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.s.n;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b {
    @Nullable
    public KsAdWebView cL;
    public aj.a cM;
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public aw cQ;
    public ValueAnimator cV;
    public ValueAnimator cW;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public String mUrl;
    public RewardActionBarControl oL;
    public KsLogoView sq;
    public boolean uZ;
    public long va;
    public int cP = -1;
    public RewardActionBarControl.d uH = new RewardActionBarControl.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.uZ = fVar.f(aVar);
            return f.this.uZ;
        }
    };
    public g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            f.this.release();
        }
    };
    public com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.qn.oH.bJ();
        }
    };
    public aj.b cS = new aj.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            f.this.cM = aVar;
            f.this.cL.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    public ai.b cT = new ai.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            f.this.uZ = false;
            f.this.aE();
        }
    };
    public aq.b cU = new aq.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            f.this.cP = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.va;
            com.kwad.sdk.core.e.c.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.cP);
            if (f.this.cP == 1) {
                com.kwad.components.core.o.a.pX().h(f.this.qn.mAdTemplate, elapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.c.a(f.this.qn.mAdTemplate, f.this.qn.oX, "play_card", com.kwad.sdk.core.response.b.b.cj(f.this.qn.mAdTemplate), System.currentTimeMillis() - f.this.cL.getLoadTime(), 3);
            }
            if (!f.this.qn.fC()) {
                f.this.oL.id();
            }
        }
    };

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void aD() {
        O(this.qn.mAdTemplate);
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sg();
        }
        this.cL.setVisibility(0);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sh();
        }
    }

    private void aF() {
        if (this.cL.getVisibility() != 0) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.si();
        }
        this.cL.setVisibility(4);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sj();
        }
    }

    private void aG() {
        ValueAnimator valueAnimator = this.cV;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cV.cancel();
        }
        ValueAnimator valueAnimator2 = this.cW;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.cW.cancel();
        }
    }

    private void aH() {
        String str;
        int i = this.cP;
        if (i == -1) {
            str = "timeout";
        } else if (i != 1) {
            str = "h5error";
        } else {
            str = AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        }
        com.kwad.sdk.core.e.c.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.qn.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        com.kwad.components.ad.reward.g gVar = this.qn;
        bVar2.mScreenOrientation = gVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = gVar.mRootContainer;
        bVar2.aCG = adBaseFrameLayout;
        bVar2.Ov = adBaseFrameLayout;
        bVar2.NP = this.cL;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void ca() {
        if (this.cL != null && com.kwad.sdk.core.response.b.b.cl(this.qn.mAdTemplate)) {
            this.mApkDownloadHelper = this.qn.mApkDownloadHelper;
            ax();
            ay();
            this.qn.b(this.mPlayEndPageListener);
        }
    }

    private KsAdWebView.d ih() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.a(f.this.qn.oX, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.cL.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(f.this.qn.mAdTemplate, f.this.qn.oX, "play_card", com.kwad.sdk.core.response.b.b.cj(f.this.qn.mAdTemplate), System.currentTimeMillis() - f.this.cL.getLoadTime(), 2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.cP = -1;
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aA();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.monitor.c.a(this.qn.oX, "play_card");
        RewardActionBarControl rewardActionBarControl = this.qn.oL;
        this.oL = rewardActionBarControl;
        rewardActionBarControl.a(this.uH);
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cL = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913eb);
        this.sq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912f5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oL;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.d) null);
        }
        this.qn.c(this.mPlayEndPageListener);
        aG();
        release();
    }

    private void O(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (com.kwad.sdk.core.response.b.a.cD(com.kwad.sdk.core.response.b.e.dP(adTemplate)) && !com.kwad.sdk.utils.ai.isOrientationPortrait() && (ksLogoView = this.sq) != null) {
            ksLogoView.setVisibility(0);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, this.cR, (byte) 0));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new q(this.cO, this.mApkDownloadHelper, this.qn, -1L, this.cR, null));
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aj(this.cO, this.cS));
        aVar.a(new aq(this.cU, com.kwad.sdk.core.response.b.b.cj(this.qn.mAdTemplate)));
        aw awVar = new aw();
        this.cQ = awVar;
        aVar.a(awVar);
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new ai(this.cT));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
        aVar.a(new com.kwad.components.ad.reward.i.b(getContext(), this.qn.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        if (this.cL.getVisibility() != 0) {
            return;
        }
        if (this.cM == null) {
            aF();
            return;
        }
        aG();
        KsAdWebView ksAdWebView = this.cL;
        aj.a aVar = this.cM;
        ValueAnimator c = n.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.cW = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cW.setDuration(300L);
        this.cW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.cL.setVisibility(4);
                if (f.this.cQ != null) {
                    f.this.cQ.sj();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.cQ != null) {
                    f.this.cQ.si();
                }
            }
        });
        this.cW.start();
    }

    private void ay() {
        this.cP = -1;
        az();
        this.cL.setBackgroundColor(0);
        this.cL.getBackground().setAlpha(0);
        this.cL.setVisibility(4);
        this.cL.setClientConfig(this.cL.getClientConfig().eh(this.qn.mAdTemplate).b(ih()));
        this.va = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.b.b.cj(this.qn.mAdTemplate);
        com.kwad.sdk.core.e.c.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.g gVar = this.qn;
        com.kwad.components.ad.reward.monitor.c.a(gVar.mAdTemplate, gVar.oX, "play_card", this.mUrl);
        this.cL.loadUrl(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(a aVar) {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.cP == 1) {
            g(aVar);
            return true;
        }
        aH();
        return false;
    }

    private void g(final a aVar) {
        if (this.cM == null) {
            aD();
            return;
        }
        O(this.qn.mAdTemplate);
        aG();
        this.cL.setVisibility(0);
        KsAdWebView ksAdWebView = this.cL;
        aj.a aVar2 = this.cM;
        ValueAnimator c = n.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.cV = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cV.setDuration(500L);
        this.cV.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.cQ != null) {
                    f.this.cQ.sh();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.cL);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.cQ != null) {
                    f.this.cQ.sg();
                }
            }
        });
        this.cV.start();
    }
}
