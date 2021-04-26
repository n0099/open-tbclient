package com.kwad.sdk.draw.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.aq;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33923b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f33924c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f33925d;

    /* renamed from: e  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f33926e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33927f;

    /* renamed from: g  reason: collision with root package name */
    public g f33928g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33929h;
    public m j;
    public ValueAnimator q;
    public ValueAnimator r;

    /* renamed from: i  reason: collision with root package name */
    public int f33930i = -1;
    public d k = new e() { // from class: com.kwad.sdk.draw.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            c.this.e();
        }
    };
    public a.b l = new a.b() { // from class: com.kwad.sdk.draw.b.b.c.2
        @Override // com.kwad.sdk.draw.b.b.a.b
        public boolean a() {
            return c.this.q();
        }
    };
    public a.b m = new a.b() { // from class: com.kwad.sdk.draw.b.b.c.3
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0386a c0386a) {
            if (((com.kwad.sdk.draw.a.a) c.this).f33875a.f33876a != null) {
                ((com.kwad.sdk.draw.a.a) c.this).f33875a.f33876a.onAdClicked();
            }
        }
    };
    public i.b n = new i.b() { // from class: com.kwad.sdk.draw.b.b.c.4
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f33925d = aVar;
            c.this.f33924c.setTranslationY(aVar.f33707a + aVar.f33710d);
        }
    };
    public h.a o = new h.a() { // from class: com.kwad.sdk.draw.b.b.c.5
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.t();
        }
    };
    public k.b p = new k.b() { // from class: com.kwad.sdk.draw.b.b.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            c.this.f33930i = i2;
            com.kwad.sdk.core.d.a.c("DrawPlayWebCard", "updatePageStatus mPageState: " + i2);
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f33929h, this.f33927f, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f33929h));
        gVar.a(new f(this.f33929h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f33929h));
        gVar.a(new i(this.f33929h, this.n));
        gVar.a(new k(this.p));
        m mVar = new m();
        this.j = mVar;
        gVar.a(mVar);
        gVar.a(new n(this.f33929h, this.f33927f));
        gVar.a(new h(this.o));
        gVar.a(new j(this.f33929h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33930i = -1;
        this.f33924c.setVisibility(8);
        p();
    }

    private void m() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33929h = aVar;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33875a;
        aVar.f33622b = bVar.f33878c;
        aVar.f33621a = 0;
        AdBaseFrameLayout adBaseFrameLayout = bVar.f33877b;
        aVar.f33623c = adBaseFrameLayout;
        aVar.f33625e = adBaseFrameLayout;
        aVar.f33626f = this.f33924c;
    }

    private void n() {
        this.f33930i = -1;
        o();
        this.f33924c.setBackgroundColor(0);
        this.f33924c.getBackground().setAlpha(0);
        this.f33924c.setVisibility(4);
        this.f33924c.loadUrl(this.f33926e.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        aq.a(this.f33924c);
        g gVar = new g(this.f33924c);
        this.f33928g = gVar;
        a(gVar);
        this.f33924c.addJavascriptInterface(this.f33928g, "KwaiAd");
    }

    private void p() {
        g gVar = this.f33928g;
        if (gVar != null) {
            gVar.a();
            this.f33928g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f33930i == 1) {
            r();
            return true;
        }
        w();
        return false;
    }

    private void r() {
        if (this.f33925d == null) {
            s();
            return;
        }
        v();
        this.f33923b.setVisibility(8);
        this.f33924c.setVisibility(0);
        WebView webView = this.f33924c;
        i.a aVar = this.f33925d;
        ValueAnimator b2 = am.b(webView, aVar.f33707a + aVar.f33710d, 0);
        this.q = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.q.setDuration(300L);
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.b.b.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.j != null) {
                    c.this.j.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.j != null) {
                    c.this.j.c();
                }
            }
        });
        this.q.start();
    }

    private void s() {
        m mVar = this.j;
        if (mVar != null) {
            mVar.c();
        }
        this.f33923b.setVisibility(8);
        this.f33924c.setVisibility(0);
        m mVar2 = this.j;
        if (mVar2 != null) {
            mVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f33924c.getVisibility() != 0) {
            return;
        }
        if (this.f33925d == null) {
            u();
            return;
        }
        v();
        WebView webView = this.f33924c;
        i.a aVar = this.f33925d;
        ValueAnimator b2 = am.b(webView, 0, aVar.f33707a + aVar.f33710d);
        this.r = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.b.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f33924c.setVisibility(4);
                c.this.f33923b.setVisibility(0);
                if (c.this.j != null) {
                    c.this.j.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.j != null) {
                    c.this.j.e();
                }
            }
        });
        this.r.start();
    }

    private void u() {
        if (this.f33924c.getVisibility() != 0) {
            return;
        }
        m mVar = this.j;
        if (mVar != null) {
            mVar.e();
        }
        this.f33924c.setVisibility(4);
        this.f33923b.setVisibility(0);
        m mVar2 = this.j;
        if (mVar2 != null) {
            mVar2.f();
        }
    }

    private void v() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.q.cancel();
        }
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.r.cancel();
        }
    }

    private void w() {
        int i2 = this.f33930i;
        String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33926e = com.kwad.sdk.core.response.b.b.k(((com.kwad.sdk.draw.a.a) this).f33875a.f33878c).playDetailInfo.detailWebCardInfo;
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33881f.a(this.l);
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f33875a;
        this.f33927f = bVar.f33879d;
        bVar.f33880e.a(this.k);
        m();
        n();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33923b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f33924c = (WebView) a(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33881f.a((a.b) null);
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33880e.b(this.k);
        v();
        e();
    }
}
