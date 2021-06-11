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
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ar;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35221b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f35222c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f35223d;

    /* renamed from: e  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f35224e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35225f;

    /* renamed from: g  reason: collision with root package name */
    public g f35226g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f35227h;
    public n j;
    public ValueAnimator q;
    public ValueAnimator r;

    /* renamed from: i  reason: collision with root package name */
    public int f35228i = -1;
    public e k = new f() { // from class: com.kwad.sdk.draw.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
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
        public void a() {
            if (((com.kwad.sdk.draw.a.a) c.this).f35173a.f35174a != null) {
                ((com.kwad.sdk.draw.a.a) c.this).f35173a.f35174a.onAdClicked();
            }
        }
    };
    public i.b n = new i.b() { // from class: com.kwad.sdk.draw.b.b.c.4
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f35223d = aVar;
            c.this.f35222c.setTranslationY(aVar.f35007a + aVar.f35010d);
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
            c.this.f35228i = i2;
            com.kwad.sdk.core.d.a.b("DrawPlayWebCard", "updatePageStatus mPageState: " + i2);
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f35227h, this.f35225f, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f35227h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f35227h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f35227h));
        gVar.a(new i(this.f35227h, this.n));
        gVar.a(new k(this.p));
        n nVar = new n();
        this.j = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.f35227h, this.f35225f));
        gVar.a(new h(this.o));
        gVar.a(new j(this.f35227h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f35228i = -1;
        this.f35222c.setVisibility(8);
        p();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f35227h = aVar;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f35173a;
        aVar.f34929b = bVar.f35176c;
        aVar.f34928a = 0;
        AdBaseFrameLayout adBaseFrameLayout = bVar.f35175b;
        aVar.f34930c = adBaseFrameLayout;
        aVar.f34932e = adBaseFrameLayout;
        aVar.f34933f = this.f35222c;
    }

    private void g() {
        this.f35228i = -1;
        h();
        this.f35222c.setBackgroundColor(0);
        this.f35222c.getBackground().setAlpha(0);
        this.f35222c.setVisibility(4);
        this.f35222c.loadUrl(this.f35224e.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f35222c);
        g gVar = new g(this.f35222c);
        this.f35226g = gVar;
        a(gVar);
        this.f35222c.addJavascriptInterface(this.f35226g, "KwaiAd");
    }

    private void p() {
        g gVar = this.f35226g;
        if (gVar != null) {
            gVar.a();
            this.f35226g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f35228i == 1) {
            r();
            return true;
        }
        w();
        return false;
    }

    private void r() {
        if (this.f35223d == null) {
            s();
            return;
        }
        v();
        this.f35221b.setVisibility(8);
        this.f35222c.setVisibility(0);
        WebView webView = this.f35222c;
        i.a aVar = this.f35223d;
        ValueAnimator b2 = am.b(webView, aVar.f35007a + aVar.f35010d, 0);
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
        n nVar = this.j;
        if (nVar != null) {
            nVar.c();
        }
        this.f35221b.setVisibility(8);
        this.f35222c.setVisibility(0);
        n nVar2 = this.j;
        if (nVar2 != null) {
            nVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f35222c.getVisibility() != 0) {
            return;
        }
        if (this.f35223d == null) {
            u();
            return;
        }
        v();
        WebView webView = this.f35222c;
        i.a aVar = this.f35223d;
        ValueAnimator b2 = am.b(webView, 0, aVar.f35007a + aVar.f35010d);
        this.r = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.b.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f35222c.setVisibility(4);
                c.this.f35221b.setVisibility(0);
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
        if (this.f35222c.getVisibility() != 0) {
            return;
        }
        n nVar = this.j;
        if (nVar != null) {
            nVar.e();
        }
        this.f35222c.setVisibility(4);
        this.f35221b.setVisibility(0);
        n nVar2 = this.j;
        if (nVar2 != null) {
            nVar2.f();
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
        int i2 = this.f35228i;
        String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f35224e = com.kwad.sdk.core.response.b.b.q(((com.kwad.sdk.draw.a.a) this).f35173a.f35176c).playDetailInfo.detailWebCardInfo;
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35179f.a(this.l);
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f35173a;
        this.f35225f = bVar.f35177d;
        bVar.f35178e.a(this.k);
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35179f.a((a.b) null);
        ((com.kwad.sdk.draw.a.a) this).f35173a.f35178e.b(this.k);
        v();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35221b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f35222c = (WebView) b(R.id.ksad_play_web_card_webView);
    }
}
