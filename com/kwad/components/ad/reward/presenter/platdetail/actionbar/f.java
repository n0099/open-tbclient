package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.h.l;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.m.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
/* loaded from: classes8.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.b.d.b {
    public KsAdWebView bF;
    public r.a bG;
    public aa bI;
    public ValueAnimator bN;
    public ValueAnimator bO;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public String mUrl;
    public RewardActionBarControl ml;
    public KsLogoView pM;
    public boolean rS;
    public long rT;
    public int bH = -1;
    public RewardActionBarControl.f rz = new RewardActionBarControl.f() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.f
        public final boolean g(a aVar) {
            f fVar = f.this;
            fVar.rS = fVar.g(aVar);
            return f.this.rS;
        }
    };
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            f.this.release();
        }
    };
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            f.this.nM.mAdOpenInteractionListener.bB();
        }
    };
    public r.b bK = new r.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            f.this.bG = aVar;
            f.this.bF.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    public q.b bL = new q.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.q.b
        public final void a(q.a aVar) {
            f.this.rS = false;
            f.this.aJ();
        }
    };
    public x.b bM = new x.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
            f.this.bH = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.rT;
            com.kwad.sdk.core.e.b.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.bH);
            if (f.this.bH == 1) {
                com.kwad.components.core.j.a.og().d(f.this.nM.mAdTemplate, elapsedRealtime);
            }
            if (f.this.nM.fv()) {
                return;
            }
            f.this.ml.hw();
        }
    };

    private void A(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.a.a.bF(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) || ag.zL() || (ksLogoView = this.pM) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new i(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(new l(this.mJsBridgeContext, this.mApkDownloadHelper, this.nM, -1L, this.bJ));
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(new k(this.mJsBridgeContext));
        aVar.a(new r(this.mJsBridgeContext, this.bK));
        aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.b.aN(this.nM.mAdTemplate)));
        aa aaVar = new aa();
        this.bI = aaVar;
        aVar.a(aaVar);
        aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new q(this.bL));
        aVar.a(new s(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.ad.reward.f.b(getContext(), this.nM.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void aE() {
        this.bH = -1;
        aF();
        this.bF.setBackgroundColor(0);
        this.bF.getBackground().setAlpha(0);
        this.bF.setVisibility(4);
        this.bF.setClientConfig(this.bF.getClientConfig().R(this.nM.mAdTemplate).b(getWebListener()));
        this.rT = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.a.b.aN(this.nM.mAdTemplate);
        com.kwad.sdk.core.e.b.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "play_card", this.mUrl);
        this.bF.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
        this.mJsInterface = aVar;
        a(aVar);
        this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void aI() {
        A(this.nM.mAdTemplate);
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.py();
        }
        this.bF.setVisibility(0);
        aa aaVar2 = this.bI;
        if (aaVar2 != null) {
            aaVar2.pz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        if (this.bF.getVisibility() != 0) {
            return;
        }
        if (this.bG == null) {
            aK();
            return;
        }
        aL();
        KsAdWebView ksAdWebView = this.bF;
        r.a aVar = this.bG;
        ValueAnimator c = n.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.bO = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bO.setDuration(300L);
        this.bO.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.bF.setVisibility(4);
                if (f.this.bI != null) {
                    f.this.bI.pB();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.bI != null) {
                    f.this.bI.pA();
                }
            }
        });
        this.bO.start();
    }

    private void aK() {
        if (this.bF.getVisibility() != 0) {
            return;
        }
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.pA();
        }
        this.bF.setVisibility(4);
        aa aaVar2 = this.bI;
        if (aaVar2 != null) {
            aaVar2.pB();
        }
    }

    private void aL() {
        ValueAnimator valueAnimator = this.bN;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.bN.cancel();
        }
        ValueAnimator valueAnimator2 = this.bO;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.bO.cancel();
        }
    }

    private void aM() {
        int i = this.bH;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        com.kwad.sdk.core.e.b.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    private void bQ() {
        if (com.kwad.sdk.core.response.a.b.aP(this.nM.mAdTemplate)) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            this.mApkDownloadHelper = kVar.mApkDownloadHelper;
            RewardActionBarControl rewardActionBarControl = kVar.ml;
            this.ml = rewardActionBarControl;
            rewardActionBarControl.a(this.rz);
            inflateJsBridgeContext();
            aE();
            this.nM.a(this.mPlayEndPageListener);
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(a aVar) {
        KsAdWebView ksAdWebView = this.bF;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.bH == 1) {
            h(aVar);
            return true;
        }
        aM();
        return false;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                com.kwad.components.ad.reward.monitor.a.b(f.this.nM.mz, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.bF.getLoadTime());
            }
        };
    }

    private void h(final a aVar) {
        if (this.bG == null) {
            aI();
            return;
        }
        A(this.nM.mAdTemplate);
        aL();
        this.bF.setVisibility(0);
        KsAdWebView ksAdWebView = this.bF;
        r.a aVar2 = this.bG;
        ValueAnimator c = n.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.bN = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bN.setDuration(500L);
        this.bN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.bI != null) {
                    f.this.bI.pz();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.bF);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.bI != null) {
                    f.this.bI.py();
                }
            }
        });
        this.bN.start();
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.nM.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        com.kwad.components.ad.reward.k kVar = this.nM;
        bVar2.mScreenOrientation = kVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = kVar.mRootContainer;
        bVar2.agd = adBaseFrameLayout;
        bVar2.Gl = adBaseFrameLayout;
        bVar2.Fv = this.bF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.bH = -1;
        this.bF.setVisibility(8);
        clearJsInterfaceRegister();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "play_card");
        if (com.kwad.components.ad.reward.k.c(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09128b);
        this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0911bd);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.ml;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.f) null);
        }
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.b(this.mPlayEndPageListener);
        aL();
        release();
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-bottom-card-v2".equals(str)) {
            bQ();
        }
    }
}
