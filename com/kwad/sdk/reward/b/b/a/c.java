package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.aq;
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public WebView f33569b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f33570c;

    /* renamed from: d  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f33571d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33572e;

    /* renamed from: f  reason: collision with root package name */
    public a f33573f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33574g;

    /* renamed from: h  reason: collision with root package name */
    public g f33575h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33576i;
    public m k;
    public boolean l;
    public long r;
    public ValueAnimator v;
    public ValueAnimator w;
    public int j = -1;
    public a.b m = new a.b() { // from class: com.kwad.sdk.reward.b.b.a.c.1
        @Override // com.kwad.sdk.reward.b.b.a.a.b
        public boolean a() {
            c cVar = c.this;
            cVar.l = cVar.q();
            return c.this.l;
        }
    };
    public f n = new f() { // from class: com.kwad.sdk.reward.b.b.a.c.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.e();
        }
    };
    public e o = new e() { // from class: com.kwad.sdk.reward.b.b.a.c.4
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.t();
        }

        @Override // com.kwad.sdk.reward.a.e
        public void b() {
            if (c.this.l) {
                c.this.r();
            }
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d p = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.b.a.c.5
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            c.this.f33574g = true;
        }
    };
    public a.b q = new a.b() { // from class: com.kwad.sdk.reward.b.b.a.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0374a c0374a) {
            ((d) c.this).f33768a.f33491b.a();
        }
    };
    public i.b s = new i.b() { // from class: com.kwad.sdk.reward.b.b.a.c.7
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f33570c = aVar;
            c.this.f33569b.setTranslationY(aVar.f32881a + aVar.f32884d);
        }
    };
    public h.a t = new h.a() { // from class: com.kwad.sdk.reward.b.b.a.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.l = false;
            c.this.t();
        }
    };
    public k.b u = new k.b() { // from class: com.kwad.sdk.reward.b.b.a.c.9
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            c.this.j = i2;
            long elapsedRealtime = SystemClock.elapsedRealtime() - c.this.r;
            com.kwad.sdk.core.d.a.c("RewardActionBarWeb", "load time:" + elapsedRealtime);
            if (c.this.j == 1) {
                com.kwad.sdk.core.report.e.b(((d) c.this).f33768a.f33495f, elapsedRealtime);
            }
            if (c.this.f33574g) {
                c.this.f33573f.b(((d) c.this).f33768a.f33498i.i(), ((d) c.this).f33768a.f33498i.j());
            }
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f33576i, this.f33572e, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f33576i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f33576i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f33576i));
        gVar.a(new i(this.f33576i, this.s));
        gVar.a(new k(this.u));
        m mVar = new m();
        this.k = mVar;
        gVar.a(mVar);
        gVar.a(new n(this.f33576i, this.f33572e));
        gVar.a(new h(this.t));
        gVar.a(new j(this.f33576i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.j = -1;
        this.f33569b.setVisibility(8);
        p();
    }

    private void m() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33576i = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f33768a;
        aVar.f32796b = aVar2.f33495f;
        aVar.f32795a = aVar2.f33494e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f33497h;
        aVar.f32797c = adBaseFrameLayout;
        aVar.f32799e = adBaseFrameLayout;
        aVar.f32800f = this.f33569b;
    }

    private void n() {
        this.j = -1;
        o();
        this.f33569b.setBackgroundColor(0);
        this.f33569b.getBackground().setAlpha(0);
        this.f33569b.setVisibility(4);
        this.r = SystemClock.elapsedRealtime();
        this.f33569b.loadUrl(this.f33571d.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        aq.a(this.f33569b);
        g gVar = new g(this.f33569b);
        this.f33575h = gVar;
        a(gVar);
        this.f33569b.addJavascriptInterface(this.f33575h, "KwaiAd");
    }

    private void p() {
        g gVar = this.f33575h;
        if (gVar != null) {
            gVar.a();
            this.f33575h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f33569b.getVisibility() == 0) {
            return true;
        }
        if (this.j == 1) {
            r();
            return true;
        }
        w();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f33570c == null) {
            s();
            return;
        }
        v();
        this.f33569b.setVisibility(0);
        WebView webView = this.f33569b;
        i.a aVar = this.f33570c;
        ValueAnimator b2 = am.b(webView, aVar.f32881a + aVar.f32884d, 0);
        this.v = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.v.setDuration(300L);
        this.v.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.c.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.k != null) {
                    c.this.k.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.k != null) {
                    c.this.k.c();
                }
            }
        });
        this.v.start();
    }

    private void s() {
        m mVar = this.k;
        if (mVar != null) {
            mVar.c();
        }
        this.f33569b.setVisibility(0);
        m mVar2 = this.k;
        if (mVar2 != null) {
            mVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f33569b.getVisibility() != 0) {
            return;
        }
        if (this.f33570c == null) {
            u();
            return;
        }
        v();
        WebView webView = this.f33569b;
        i.a aVar = this.f33570c;
        ValueAnimator b2 = am.b(webView, 0, aVar.f32881a + aVar.f32884d);
        this.w = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.w.setDuration(300L);
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f33569b.setVisibility(4);
                if (c.this.k != null) {
                    c.this.k.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.k != null) {
                    c.this.k.e();
                }
            }
        });
        this.w.start();
    }

    private void u() {
        if (this.f33569b.getVisibility() != 0) {
            return;
        }
        m mVar = this.k;
        if (mVar != null) {
            mVar.e();
        }
        this.f33569b.setVisibility(4);
        m mVar2 = this.k;
        if (mVar2 != null) {
            mVar2.f();
        }
    }

    private void v() {
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.v.cancel();
        }
        ValueAnimator valueAnimator2 = this.w;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.w.cancel();
        }
    }

    private void w() {
        int i2 = this.j;
        String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33571d = com.kwad.sdk.core.response.b.b.k(((d) this).f33768a.f33495f).playDetailInfo.detailWebCardInfo;
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        this.f33572e = aVar.j;
        a aVar2 = aVar.k;
        this.f33573f = aVar2;
        aVar2.a(this.m);
        m();
        n();
        ((d) this).f33768a.a(this.n);
        ((d) this).f33768a.f33498i.a(this.p);
        ((d) this).f33768a.o.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33569b = (WebView) a(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33573f.a((a.b) null);
        ((d) this).f33768a.b(this.n);
        ((d) this).f33768a.o.remove(this.o);
        ((d) this).f33768a.f33498i.b(this.p);
        v();
        e();
    }
}
