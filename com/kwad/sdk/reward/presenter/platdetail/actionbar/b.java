package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.be;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f57589b;

    /* renamed from: c  reason: collision with root package name */
    public j.a f57590c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57591d;

    /* renamed from: e  reason: collision with root package name */
    public RewardActionBarControl f57592e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57593f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f57594g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57595h;

    /* renamed from: j  reason: collision with root package name */
    public s f57597j;
    public boolean k;
    public long p;
    public ValueAnimator t;
    public ValueAnimator u;

    /* renamed from: i  reason: collision with root package name */
    public int f57596i = -1;
    public RewardActionBarControl.d l = new RewardActionBarControl.d() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public boolean a() {
            b bVar = b.this;
            bVar.k = bVar.u();
            return b.this.k;
        }
    };
    public f m = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            b.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d n = new e() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.3
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            b.this.f57593f = true;
        }
    };
    public b.c o = new b.c() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) b.this).a.f57247b.a();
        }
    };
    public j.b q = new j.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(j.a aVar) {
            b.this.f57590c = aVar;
            b.this.f57589b.setTranslationY(aVar.a + aVar.f56448d);
        }
    };
    public i.b r = new i.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.6
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i2) {
            b.this.k = false;
            b.this.x();
        }
    };
    public p.b s = new p.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.7
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            b.this.f57596i = aVar.a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - b.this.p;
            com.kwad.sdk.core.d.a.c("RewardActionBarWeb", "load time:" + elapsedRealtime);
            if (b.this.f57596i == 1) {
                com.kwad.sdk.core.report.d.b(((g) b.this).a.f57252g, elapsedRealtime);
            }
            if (b.this.f57593f) {
                b.this.f57592e.b(((g) b.this).a.k.f(), ((g) b.this).a.k.g());
            }
        }
    };

    private void A() {
        int i2 = this.f57596i;
        String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f57595h, this.f57591d, this.o));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57595h, this.f57591d, this.o));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f57595h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57595h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57595h));
        gVar.a(new j(this.f57595h, this.q));
        gVar.a(new p(this.s));
        s sVar = new s();
        this.f57597j = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.f57595h, this.f57591d));
        gVar.a(new i(this.r));
        gVar.a(new k(this.f57595h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f57596i = -1;
        this.f57589b.setVisibility(8);
        t();
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f57595h = aVar;
        aVar.a(((g) this).a.f57252g);
        com.kwad.sdk.core.webview.a aVar2 = this.f57595h;
        com.kwad.sdk.reward.a aVar3 = ((g) this).a;
        aVar2.a = aVar3.f57251f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f57255j;
        aVar2.f56372b = adBaseFrameLayout;
        aVar2.f56374d = adBaseFrameLayout;
        aVar2.f56375e = this.f57589b;
    }

    private void r() {
        this.f57596i = -1;
        s();
        this.f57589b.setBackgroundColor(0);
        this.f57589b.getBackground().setAlpha(0);
        this.f57589b.setVisibility(4);
        this.p = SystemClock.elapsedRealtime();
        this.f57589b.loadUrl(com.kwad.sdk.core.response.a.b.b(((g) this).a.f57252g));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void s() {
        t();
        be.a(this.f57589b);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57589b);
        this.f57594g = gVar;
        a(gVar);
        this.f57589b.addJavascriptInterface(this.f57594g, "KwaiAd");
    }

    private void t() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f57594g;
        if (gVar != null) {
            gVar.a();
            this.f57594g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        KsAdWebView ksAdWebView = this.f57589b;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.f57596i == 1) {
            v();
            return true;
        }
        A();
        return false;
    }

    private void v() {
        if (this.f57590c == null) {
            w();
            return;
        }
        z();
        this.f57589b.setVisibility(0);
        KsAdWebView ksAdWebView = this.f57589b;
        j.a aVar = this.f57590c;
        ValueAnimator b2 = az.b(ksAdWebView, aVar.a + aVar.f56448d, 0);
        this.t = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.t.setDuration(300L);
        this.t.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.f57597j != null) {
                    b.this.f57597j.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.f57597j != null) {
                    b.this.f57597j.c();
                }
            }
        });
        this.t.start();
    }

    private void w() {
        s sVar = this.f57597j;
        if (sVar != null) {
            sVar.c();
        }
        this.f57589b.setVisibility(0);
        s sVar2 = this.f57597j;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f57589b.getVisibility() != 0) {
            return;
        }
        if (this.f57590c == null) {
            y();
            return;
        }
        z();
        KsAdWebView ksAdWebView = this.f57589b;
        j.a aVar = this.f57590c;
        ValueAnimator b2 = az.b(ksAdWebView, 0, aVar.a + aVar.f56448d);
        this.u = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.u.setDuration(300L);
        this.u.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.f57589b.setVisibility(4);
                if (b.this.f57597j != null) {
                    b.this.f57597j.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.f57597j != null) {
                    b.this.f57597j.e();
                }
            }
        });
        this.u.start();
    }

    private void y() {
        if (this.f57589b.getVisibility() != 0) {
            return;
        }
        s sVar = this.f57597j;
        if (sVar != null) {
            sVar.e();
        }
        this.f57589b.setVisibility(4);
        s sVar2 = this.f57597j;
        if (sVar2 != null) {
            sVar2.f();
        }
    }

    private void z() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.t.cancel();
        }
        ValueAnimator valueAnimator2 = this.u;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.u.cancel();
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57591d = aVar.l;
        RewardActionBarControl rewardActionBarControl = aVar.n;
        this.f57592e = rewardActionBarControl;
        rewardActionBarControl.a(this.l);
        i();
        r();
        ((g) this).a.a(this.m);
        ((g) this).a.k.a(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57592e.a((RewardActionBarControl.d) null);
        ((g) this).a.b(this.m);
        ((g) this).a.k.b(this.n);
        z();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57589b = (KsAdWebView) a(R.id.ksad_play_web_card_webView);
    }
}
