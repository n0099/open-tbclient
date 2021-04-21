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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public AdBaseFrameLayout f32548a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32549b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32550c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f32551d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f32552e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32553f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32554g;

    /* renamed from: h  reason: collision with root package name */
    public String f32555h;
    public com.kwad.sdk.core.webview.a i;
    public g j;
    public n k;
    public ViewTreeObserver.OnGlobalLayoutListener m;
    public int n;
    public ValueAnimator q;
    public ValueAnimator r;
    public int l = -1;
    public boolean o = false;
    public boolean p = false;
    public a.b s = new a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(b.this.f32553f))) {
                b.this.f32552e.post(b.this.t);
            } else {
                b.this.f32552e.postDelayed(b.this.t, 100L);
            }
        }
    };
    public Runnable t = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.a(false);
        }
    };
    public h.a u = new h.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            b.this.a(true);
        }
    };
    public k.b v = new k.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            b.this.l = i;
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.i, this.f32554g, this.s));
        gVar.a(new e(this.i));
        gVar.a(new f(this.i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.i));
        gVar.a(new i(this.i, null));
        gVar.a(new k(this.v));
        n nVar = new n();
        this.k = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.i, this.f32554g));
        gVar.a(new h(this.u));
        gVar.a(new j(this.i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (ao.a((View) this.f32552e, 50, false)) {
            this.p = z;
            if (z) {
                this.f32550c.setVisibility(8);
            }
            j();
            ValueAnimator a2 = am.a(this.f32551d, this.f32549b, this.n);
            this.r = a2;
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.7
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
        this.f32551d.setVisibility(4);
        this.f32552e.setBackgroundColor(0);
        this.f32552e.getBackground().setAlpha(0);
    }

    private void e() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.i = aVar;
        aVar.f34670b = this.f32553f;
        aVar.f34669a = 0;
        aVar.f34671c = this.f32548a;
        aVar.f34673e = this.f32551d;
        aVar.f34674f = this.f32552e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.n = this.f32551d.getWidth() + ao.a(this.f32551d.getContext(), 12.0f);
        com.kwad.sdk.core.d.a.a("PatchAdWebCard", "initWebCard mWebCardContainerWidth:" + this.n);
        this.f32551d.setTranslationX((float) (-this.n));
        this.f32551d.setVisibility(0);
        g();
        this.l = -1;
        this.f32552e.loadUrl(this.f32555h);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void g() {
        h();
        ar.a(this.f32552e);
        g gVar = new g(this.f32552e);
        this.j = gVar;
        a(gVar);
        this.f32552e.addJavascriptInterface(this.j, "KwaiAd");
    }

    private void h() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.a();
            this.j = null;
        }
    }

    private void i() {
        j();
        ValueAnimator a2 = am.a(this.f32549b, this.f32551d, this.n);
        this.q = a2;
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.6
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

    private void k() {
        int i = this.l;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("PatchAdWebCard", "show webCard fail, reason: " + str);
        com.kwad.sdk.core.report.b.n(this.f32553f);
    }

    public void a() {
        this.m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.a.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                b.this.f32551d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                b.this.m = null;
                b.this.f();
            }
        };
        this.f32551d.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
    }

    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, FrameLayout frameLayout, WebView webView, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar) {
        this.f32549b = viewGroup;
        this.f32550c = viewGroup2;
        this.f32551d = frameLayout;
        this.f32552e = webView;
        this.f32548a = adBaseFrameLayout;
        this.f32553f = adTemplate;
        this.f32554g = bVar;
        this.f32555h = com.kwad.sdk.core.response.b.b.a(adTemplate).strongStyleCardUrl;
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
            this.f32551d.getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        }
        this.f32549b.setTranslationX(0.0f);
        this.f32551d.setVisibility(8);
        this.f32552e.removeCallbacks(this.t);
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
