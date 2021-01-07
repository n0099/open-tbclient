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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f9994b;
    private WebView c;
    private i.a d;
    private AdStyleInfo.PlayDetailInfo.DetailWebCardInfo e;
    private com.kwad.sdk.core.download.b.b f;
    private g g;
    private com.kwad.sdk.core.webview.a h;
    private n j;
    private ValueAnimator q;
    private ValueAnimator r;
    private int i = -1;
    private e k = new f() { // from class: com.kwad.sdk.draw.b.b.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            c.this.e();
        }
    };
    private a.b l = new a.b() { // from class: com.kwad.sdk.draw.b.b.c.2
        @Override // com.kwad.sdk.draw.b.b.a.b
        public boolean a() {
            return c.this.q();
        }
    };
    private a.b m = new a.b() { // from class: com.kwad.sdk.draw.b.b.c.3
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (c.this.f9973a.f9974a != null) {
                c.this.f9973a.f9974a.onAdClicked();
            }
        }
    };
    private i.b n = new i.b() { // from class: com.kwad.sdk.draw.b.b.c.4
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.d = aVar;
            c.this.c.setTranslationY(aVar.f9885a + aVar.d);
        }
    };
    private h.a o = new h.a() { // from class: com.kwad.sdk.draw.b.b.c.5
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.t();
        }
    };
    private k.b p = new k.b() { // from class: com.kwad.sdk.draw.b.b.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            c.this.i = i;
            com.kwad.sdk.core.d.a.b("DrawPlayWebCard", "updatePageStatus mPageState: " + i);
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.h, this.f, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.h));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.h));
        gVar.a(new i(this.h, this.n));
        gVar.a(new k(this.p));
        this.j = new n();
        gVar.a(this.j);
        gVar.a(new o(this.h, this.f));
        gVar.a(new h(this.o));
        gVar.a(new j(this.h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.i = -1;
        this.c.setVisibility(8);
        p();
    }

    private void f() {
        this.h = new com.kwad.sdk.core.webview.a();
        this.h.f9837b = this.f9973a.c;
        this.h.f9836a = 0;
        this.h.c = this.f9973a.f9975b;
        this.h.e = this.f9973a.f9975b;
        this.h.f = this.c;
    }

    private void g() {
        this.i = -1;
        h();
        this.c.setBackgroundColor(0);
        this.c.getBackground().setAlpha(0);
        this.c.setVisibility(4);
        this.c.loadUrl(this.e.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.c);
        this.g = new g(this.c);
        a(this.g);
        this.c.addJavascriptInterface(this.g, "KwaiAd");
    }

    private void p() {
        if (this.g != null) {
            this.g.a();
            this.g = null;
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
        if (this.d == null) {
            s();
            return;
        }
        v();
        this.f9994b.setVisibility(8);
        this.c.setVisibility(0);
        this.q = am.b(this.c, this.d.f9885a + this.d.d, 0);
        this.q.setInterpolator(new DecelerateInterpolator(2.0f));
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
        if (this.j != null) {
            this.j.c();
        }
        this.f9994b.setVisibility(8);
        this.c.setVisibility(0);
        if (this.j != null) {
            this.j.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.c.getVisibility() != 0) {
            return;
        }
        if (this.d == null) {
            u();
            return;
        }
        v();
        this.r = am.b(this.c, 0, this.d.f9885a + this.d.d);
        this.r.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.b.b.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.c.setVisibility(4);
                c.this.f9994b.setVisibility(0);
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
        if (this.c.getVisibility() != 0) {
            return;
        }
        if (this.j != null) {
            this.j.e();
        }
        this.c.setVisibility(4);
        this.f9994b.setVisibility(0);
        if (this.j != null) {
            this.j.f();
        }
    }

    private void v() {
        if (this.q != null) {
            this.q.removeAllListeners();
            this.q.cancel();
        }
        if (this.r != null) {
            this.r.removeAllListeners();
            this.r.cancel();
        }
    }

    private void w() {
        Log.w("DrawPlayWebCard", "show webCard fail, reason: " + (this.i == -1 ? "timeout" : this.i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = com.kwad.sdk.core.response.b.b.q(this.f9973a.c).playDetailInfo.detailWebCardInfo;
        this.f9973a.f.a(this.l);
        this.f = this.f9973a.d;
        this.f9973a.e.a(this.k);
        f();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9973a.f.a((a.b) null);
        this.f9973a.e.b(this.k);
        v();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9994b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.c = (WebView) b(R.id.ksad_play_web_card_webView);
    }
}
