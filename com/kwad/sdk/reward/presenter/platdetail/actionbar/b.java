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
    public KsAdWebView f59806b;

    /* renamed from: c  reason: collision with root package name */
    public j.a f59807c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59808d;

    /* renamed from: e  reason: collision with root package name */
    public RewardActionBarControl f59809e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59810f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f59811g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59812h;

    /* renamed from: j  reason: collision with root package name */
    public s f59814j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59815k;
    public long p;
    public ValueAnimator t;
    public ValueAnimator u;

    /* renamed from: i  reason: collision with root package name */
    public int f59813i = -1;
    public RewardActionBarControl.d l = new RewardActionBarControl.d() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public boolean a() {
            b bVar = b.this;
            bVar.f59815k = bVar.u();
            return b.this.f59815k;
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
            b.this.f59810f = true;
        }
    };
    public b.c o = new b.c() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) b.this).a.f59450b.a();
        }
    };
    public j.b q = new j.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(j.a aVar) {
            b.this.f59807c = aVar;
            b.this.f59806b.setTranslationY(aVar.a + aVar.f58614d);
        }
    };
    public i.b r = new i.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.6
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i2) {
            b.this.f59815k = false;
            b.this.x();
        }
    };
    public p.b s = new p.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.7
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            b.this.f59813i = aVar.a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - b.this.p;
            com.kwad.sdk.core.d.a.c("RewardActionBarWeb", "load time:" + elapsedRealtime);
            if (b.this.f59813i == 1) {
                com.kwad.sdk.core.report.d.b(((g) b.this).a.f59455g, elapsedRealtime);
            }
            if (b.this.f59810f) {
                b.this.f59809e.b(((g) b.this).a.f59459k.f(), ((g) b.this).a.f59459k.g());
            }
        }
    };

    private void A() {
        int i2 = this.f59813i;
        String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f59812h, this.f59808d, this.o));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59812h, this.f59808d, this.o));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59812h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59812h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59812h));
        gVar.a(new j(this.f59812h, this.q));
        gVar.a(new p(this.s));
        s sVar = new s();
        this.f59814j = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.f59812h, this.f59808d));
        gVar.a(new i(this.r));
        gVar.a(new k(this.f59812h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f59813i = -1;
        this.f59806b.setVisibility(8);
        t();
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f59812h = aVar;
        aVar.a(((g) this).a.f59455g);
        com.kwad.sdk.core.webview.a aVar2 = this.f59812h;
        com.kwad.sdk.reward.a aVar3 = ((g) this).a;
        aVar2.a = aVar3.f59454f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f59458j;
        aVar2.f58536b = adBaseFrameLayout;
        aVar2.f58538d = adBaseFrameLayout;
        aVar2.f58539e = this.f59806b;
    }

    private void r() {
        this.f59813i = -1;
        s();
        this.f59806b.setBackgroundColor(0);
        this.f59806b.getBackground().setAlpha(0);
        this.f59806b.setVisibility(4);
        this.p = SystemClock.elapsedRealtime();
        this.f59806b.loadUrl(com.kwad.sdk.core.response.a.b.b(((g) this).a.f59455g));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void s() {
        t();
        be.a(this.f59806b);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59806b);
        this.f59811g = gVar;
        a(gVar);
        this.f59806b.addJavascriptInterface(this.f59811g, "KwaiAd");
    }

    private void t() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f59811g;
        if (gVar != null) {
            gVar.a();
            this.f59811g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        KsAdWebView ksAdWebView = this.f59806b;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.f59813i == 1) {
            v();
            return true;
        }
        A();
        return false;
    }

    private void v() {
        if (this.f59807c == null) {
            w();
            return;
        }
        z();
        this.f59806b.setVisibility(0);
        KsAdWebView ksAdWebView = this.f59806b;
        j.a aVar = this.f59807c;
        ValueAnimator b2 = az.b(ksAdWebView, aVar.a + aVar.f58614d, 0);
        this.t = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.t.setDuration(300L);
        this.t.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.f59814j != null) {
                    b.this.f59814j.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.f59814j != null) {
                    b.this.f59814j.c();
                }
            }
        });
        this.t.start();
    }

    private void w() {
        s sVar = this.f59814j;
        if (sVar != null) {
            sVar.c();
        }
        this.f59806b.setVisibility(0);
        s sVar2 = this.f59814j;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f59806b.getVisibility() != 0) {
            return;
        }
        if (this.f59807c == null) {
            y();
            return;
        }
        z();
        KsAdWebView ksAdWebView = this.f59806b;
        j.a aVar = this.f59807c;
        ValueAnimator b2 = az.b(ksAdWebView, 0, aVar.a + aVar.f58614d);
        this.u = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.u.setDuration(300L);
        this.u.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.f59806b.setVisibility(4);
                if (b.this.f59814j != null) {
                    b.this.f59814j.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.f59814j != null) {
                    b.this.f59814j.e();
                }
            }
        });
        this.u.start();
    }

    private void y() {
        if (this.f59806b.getVisibility() != 0) {
            return;
        }
        s sVar = this.f59814j;
        if (sVar != null) {
            sVar.e();
        }
        this.f59806b.setVisibility(4);
        s sVar2 = this.f59814j;
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
        this.f59808d = aVar.l;
        RewardActionBarControl rewardActionBarControl = aVar.n;
        this.f59809e = rewardActionBarControl;
        rewardActionBarControl.a(this.l);
        i();
        r();
        ((g) this).a.a(this.m);
        ((g) this).a.f59459k.a(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f59809e.a((RewardActionBarControl.d) null);
        ((g) this).a.b(this.m);
        ((g) this).a.f59459k.b(this.n);
        z();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59806b = (KsAdWebView) a(R.id.ksad_play_web_card_webView);
    }
}
