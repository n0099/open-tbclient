package com.kwad.components.ad.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.core.m.n;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes9.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a {
    public KsAdWebView bF;
    public r.a bG;
    public aa bI;
    public ValueAnimator bN;
    public ValueAnimator bO;
    public ViewGroup bh;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public int bH = -1;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.draw.a.a.c.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            c.this.release();
        }
    };
    public a.b bA = new a.b() { // from class: com.kwad.components.ad.draw.a.a.c.2
        @Override // com.kwad.components.ad.draw.a.a.a.b
        public final boolean ay() {
            return c.this.aG();
        }
    };
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.draw.a.a.c.3
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            if (c.this.aK.aJ != null) {
                c.this.aK.aJ.onAdClicked();
            }
        }
    };
    public r.b bK = new r.b() { // from class: com.kwad.components.ad.draw.a.a.c.4
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            c.this.bG = aVar;
            c.this.bF.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    public q.b bL = new q.b() { // from class: com.kwad.components.ad.draw.a.a.c.5
        @Override // com.kwad.components.core.webview.jshandler.q.b
        public final void a(q.a aVar) {
            c.this.aJ();
        }
    };
    public x.b bM = new x.b() { // from class: com.kwad.components.ad.draw.a.a.c.6
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
            c.this.bH = aVar.status;
            com.kwad.sdk.core.e.b.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new i(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
        aVar.a(new f(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(new k(this.mJsBridgeContext));
        aVar.a(new r(this.mJsBridgeContext, this.bK));
        aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate)));
        aa aaVar = new aa();
        this.bI = aaVar;
        aVar.a(aaVar);
        aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new q(this.bL));
        aVar.a(new s(this.mJsBridgeContext));
    }

    private void aE() {
        this.bH = -1;
        aF();
        this.bF.setBackgroundColor(0);
        this.bF.getBackground().setAlpha(0);
        this.bF.setVisibility(4);
        this.bF.loadUrl(com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
        this.mJsInterface = aVar;
        a(aVar);
        this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aG() {
        if (this.bH == 1) {
            aH();
            return true;
        }
        aM();
        return false;
    }

    private void aH() {
        if (this.bG == null) {
            aI();
            return;
        }
        aL();
        this.bh.setVisibility(8);
        this.bF.setVisibility(0);
        KsAdWebView ksAdWebView = this.bF;
        r.a aVar = this.bG;
        ValueAnimator c = n.c(ksAdWebView, aVar.height + aVar.bottomMargin, 0);
        this.bN = c;
        c.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bN.setDuration(300L);
        this.bN.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.a.a.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.bI != null) {
                    c.this.bI.pz();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.bI != null) {
                    c.this.bI.py();
                }
            }
        });
        this.bN.start();
    }

    private void aI() {
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.py();
        }
        this.bh.setVisibility(8);
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
        this.bO.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.a.a.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.bF.setVisibility(4);
                c.this.bh.setVisibility(0);
                if (c.this.bI != null) {
                    c.this.bI.pB();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.bI != null) {
                    c.this.bI.pA();
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
        this.bh.setVisibility(0);
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
        com.kwad.sdk.core.e.b.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.aK.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.aK.mRootContainer;
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

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.draw.kwai.b bVar = this.aK;
        this.mAdTemplate = bVar.mAdTemplate;
        bVar.ba.a(this.bA);
        com.kwad.components.ad.draw.kwai.b bVar2 = this.aK;
        this.mApkDownloadHelper = bVar2.mApkDownloadHelper;
        bVar2.aL.a(this.mVideoPlayStateListener);
        inflateJsBridgeContext();
        aE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bh = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09123a);
        this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091305);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aK.ba.a((a.b) null);
        this.aK.aL.b(this.mVideoPlayStateListener);
        aL();
        release();
    }
}
