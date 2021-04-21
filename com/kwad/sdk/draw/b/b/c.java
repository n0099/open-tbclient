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
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34953b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f34954c;

    /* renamed from: d  reason: collision with root package name */
    public i.a f34955d;

    /* renamed from: e  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f34956e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34957f;

    /* renamed from: g  reason: collision with root package name */
    public g f34958g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34959h;
    public n j;
    public ValueAnimator q;
    public ValueAnimator r;
    public int i = -1;
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
            if (((com.kwad.sdk.draw.a.a) c.this).f34906a.f34907a != null) {
                ((com.kwad.sdk.draw.a.a) c.this).f34906a.f34907a.onAdClicked();
            }
        }
    };
    public i.b n = new i.b() { // from class: com.kwad.sdk.draw.b.b.c.4
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f34955d = aVar;
            c.this.f34954c.setTranslationY(aVar.f34746a + aVar.f34749d);
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
        public void a(int i) {
            c.this.i = i;
            com.kwad.sdk.core.d.a.b("DrawPlayWebCard", "updatePageStatus mPageState: " + i);
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f34959h, this.f34957f, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f34959h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f34959h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f34959h));
        gVar.a(new i(this.f34959h, this.n));
        gVar.a(new k(this.p));
        n nVar = new n();
        this.j = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.f34959h, this.f34957f));
        gVar.a(new h(this.o));
        gVar.a(new j(this.f34959h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = -1;
        this.f34954c.setVisibility(8);
        p();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34959h = aVar;
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34906a;
        aVar.f34670b = bVar.f34909c;
        aVar.f34669a = 0;
        AdBaseFrameLayout adBaseFrameLayout = bVar.f34908b;
        aVar.f34671c = adBaseFrameLayout;
        aVar.f34673e = adBaseFrameLayout;
        aVar.f34674f = this.f34954c;
    }

    private void g() {
        this.i = -1;
        h();
        this.f34954c.setBackgroundColor(0);
        this.f34954c.getBackground().setAlpha(0);
        this.f34954c.setVisibility(4);
        this.f34954c.loadUrl(this.f34956e.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f34954c);
        g gVar = new g(this.f34954c);
        this.f34958g = gVar;
        a(gVar);
        this.f34954c.addJavascriptInterface(this.f34958g, "KwaiAd");
    }

    private void p() {
        g gVar = this.f34958g;
        if (gVar != null) {
            gVar.a();
            this.f34958g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.i == 1) {
            r();
            return true;
        }
        w();
        return false;
    }

    private void r() {
        if (this.f34955d == null) {
            s();
            return;
        }
        v();
        this.f34953b.setVisibility(8);
        this.f34954c.setVisibility(0);
        WebView webView = this.f34954c;
        i.a aVar = this.f34955d;
        ValueAnimator b2 = am.b(webView, aVar.f34746a + aVar.f34749d, 0);
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
        this.f34953b.setVisibility(8);
        this.f34954c.setVisibility(0);
        n nVar2 = this.j;
        if (nVar2 != null) {
            nVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f34954c.getVisibility() != 0) {
            return;
        }
        if (this.f34955d == null) {
            u();
            return;
        }
        v();
        WebView webView = this.f34954c;
        i.a aVar = this.f34955d;
        ValueAnimator b2 = am.b(webView, 0, aVar.f34746a + aVar.f34749d);
        this.r = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.b.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f34954c.setVisibility(4);
                c.this.f34953b.setVisibility(0);
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
        if (this.f34954c.getVisibility() != 0) {
            return;
        }
        n nVar = this.j;
        if (nVar != null) {
            nVar.e();
        }
        this.f34954c.setVisibility(4);
        this.f34953b.setVisibility(0);
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
        int i = this.i;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34956e = com.kwad.sdk.core.response.b.b.q(((com.kwad.sdk.draw.a.a) this).f34906a.f34909c).playDetailInfo.detailWebCardInfo;
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34912f.a(this.l);
        com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f34906a;
        this.f34957f = bVar.f34910d;
        bVar.f34911e.a(this.k);
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34912f.a((a.b) null);
        ((com.kwad.sdk.draw.a.a) this).f34906a.f34911e.b(this.k);
        v();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34953b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f34954c = (WebView) b(R.id.ksad_play_web_card_webView);
    }
}
