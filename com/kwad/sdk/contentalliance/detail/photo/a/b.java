package com.kwad.sdk.contentalliance.detail.photo.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private AdBaseFrameLayout f8705a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8706b;
    private ViewGroup c;
    private FrameLayout d;
    private WebView e;
    private AdTemplate f;
    private com.kwad.sdk.core.download.b.b g;
    private String h;
    private com.kwad.sdk.core.webview.a i;
    private g j;
    private n k;
    private ViewTreeObserver.OnGlobalLayoutListener m;
    private int n;
    private ValueAnimator q;
    private ValueAnimator r;
    private int l = -1;
    private boolean o = false;
    private boolean p = false;
    private a.b s = new a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(b.this.f))) {
                b.this.e.post(b.this.t);
            } else {
                b.this.e.postDelayed(b.this.t, 100L);
            }
        }
    };
    private Runnable t = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.a(false);
        }
    };
    private h.a u = new h.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            b.this.a(true);
        }
    };
    private k.b v = new k.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            b.this.l = i;
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.i, this.g, this.s));
        gVar.a(new e(this.i));
        gVar.a(new f(this.i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.i));
        gVar.a(new i(this.i, null));
        gVar.a(new k(this.v));
        this.k = new n();
        gVar.a(this.k);
        gVar.a(new o(this.i, this.g));
        gVar.a(new h(this.u));
        gVar.a(new j(this.i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (ao.a((View) this.e, 50, false)) {
            this.p = z;
            if (this.p) {
                this.c.setVisibility(8);
            }
            j();
            this.r = am.a(this.d, this.f8706b, this.n);
            this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (b.this.k != null) {
                        b.this.k.f();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (b.this.k != null) {
                        b.this.k.e();
                    }
                }
            });
            this.r.start();
        }
    }

    private void d() {
        this.d.setVisibility(4);
        this.e.setBackgroundColor(0);
        this.e.getBackground().setAlpha(0);
    }

    private void e() {
        this.i = new com.kwad.sdk.core.webview.a();
        this.i.f9836b = this.f;
        this.i.f9835a = 0;
        this.i.c = this.f8705a;
        this.i.e = this.d;
        this.i.f = this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.n = this.d.getWidth() + ao.a(this.d.getContext(), 12.0f);
        com.kwad.sdk.core.d.a.a("PatchAdWebCard", "initWebCard mWebCardContainerWidth:" + this.n);
        this.d.setTranslationX(-this.n);
        this.d.setVisibility(0);
        g();
        this.l = -1;
        this.e.loadUrl(this.h);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void g() {
        h();
        ar.a(this.e);
        this.j = new g(this.e);
        a(this.j);
        this.e.addJavascriptInterface(this.j, "KwaiAd");
    }

    private void h() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
    }

    private void i() {
        j();
        this.q = am.a(this.f8706b, this.d, this.n);
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.k != null) {
                    b.this.k.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.k != null) {
                    b.this.k.c();
                }
            }
        });
        this.q.start();
    }

    private void j() {
        if (this.q != null) {
            this.q.removeAllListeners();
            this.q.cancel();
        }
        if (this.r != null) {
            this.r.removeAllListeners();
            this.r.cancel();
        }
    }

    private void k() {
        Log.w("PatchAdWebCard", "show webCard fail, reason: " + (this.l == -1 ? "timeout" : this.l != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS));
        com.kwad.sdk.core.report.b.n(this.f);
    }

    public void a() {
        this.m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                b.this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                b.this.m = null;
                b.this.f();
            }
        };
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
    }

    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, FrameLayout frameLayout, WebView webView, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar) {
        this.f8706b = viewGroup;
        this.c = viewGroup2;
        this.d = frameLayout;
        this.e = webView;
        this.f8705a = adBaseFrameLayout;
        this.f = adTemplate;
        this.g = bVar;
        this.h = com.kwad.sdk.core.response.b.b.a(adTemplate).strongStyleCardUrl;
        d();
        e();
    }

    public void b() {
        this.o = false;
        this.p = false;
        this.l = -1;
        h();
        j();
        if (this.m != null) {
            this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        }
        this.f8706b.setTranslationX(0.0f);
        this.d.setVisibility(8);
        this.e.removeCallbacks(this.t);
    }

    public void c() {
        if (this.o || this.p) {
            return;
        }
        this.o = true;
        com.kwad.sdk.core.d.a.a("PatchAdWebCard", "showWebActionBar");
        if (this.l == 1) {
            i();
        } else {
            k();
        }
    }
}
