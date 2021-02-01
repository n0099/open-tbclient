package com.kwad.sdk.contentalliance.detail.ad.presenter.a;

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
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ar;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f8352b;
    private AdBaseFrameLayout c;
    private ViewGroup d;
    private WebView e;
    private AdTemplate f;
    private com.kwad.sdk.contentalliance.detail.video.b g;
    private AdStyleInfo.PlayDetailInfo.DetailWebCardInfo h;
    private com.kwad.sdk.core.download.b.b i;
    private g j;
    private com.kwad.sdk.core.webview.a k;
    private n m;
    private ValueAnimator n;
    private ValueAnimator o;
    private long t;
    private int u;
    private int l = -1;
    private boolean p = false;
    private boolean q = false;
    private e r = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            b.this.p = false;
            b.this.a(false);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.response.b.b.g(b.this.f)) {
                b.this.q();
            }
        }
    };
    private com.kwad.sdk.contentalliance.a.a s = new AnonymousClass2();
    private h.a v = new h.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.3
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            b.this.a(true);
        }
    };
    private k.b w = new k.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            b.this.l = i;
            com.kwad.sdk.core.d.a.b("ActionBarWebCard", "position:" + b.this.f8395a.i + " load time:" + (System.currentTimeMillis() - b.this.t));
        }
    };
    private Runnable x = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.a(false);
        }
    };
    private Runnable y = new aq(this.x);

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {

        /* renamed from: a  reason: collision with root package name */
        ViewTreeObserver.OnGlobalLayoutListener f8354a;

        AnonymousClass2() {
        }

        private void a() {
            b.this.p = false;
            b.this.q = false;
            b.this.d.setTranslationX(0.0f);
            b.this.f8352b.setTranslationX(-b.this.u);
            b.this.e.removeCallbacks(b.this.y);
        }

        private void b() {
            this.f8354a = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.2.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    b.this.f8352b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass2.this.f8354a = null;
                    b.this.g();
                }
            };
            b.this.f8352b.getViewTreeObserver().addOnGlobalLayoutListener(this.f8354a);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            a();
            b();
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a();
            b.this.p();
            b.this.t();
            if (this.f8354a != null) {
                b.this.f8352b.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8354a);
            }
        }
    }

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.i, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
        gVar.a(new i(this.k, null));
        gVar.a(new k(this.w));
        this.m = new n();
        gVar.a(this.m);
        gVar.a(new o(this.k, this.i));
        gVar.a(new h(this.v));
        gVar.a(new j(this.k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (ao.a((View) this.e, 50, false)) {
            this.q = z;
            t();
            this.e.removeCallbacks(this.y);
            this.o = am.a(this.f8352b, this.d, this.u);
            this.o.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (b.this.m != null) {
                        b.this.m.f();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (b.this.m != null) {
                        b.this.m.e();
                    }
                }
            });
            this.o.start();
        }
    }

    private void e() {
        this.k.f9539b = this.f8395a.j;
        this.k.f9538a = 0;
        this.k.c = this.c;
        this.k.e = this.f8352b;
        this.k.f = this.e;
    }

    private void f() {
        this.f8352b.setVisibility(4);
        this.e.setBackgroundColor(0);
        this.e.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.u = this.f8352b.getWidth() + ao.a(this.f8352b.getContext(), 12.0f);
        com.kwad.sdk.core.d.a.a("ActionBarWebCard", "initWebCard mWebCardContainerWidth:" + this.u);
        this.f8352b.setTranslationX(-this.u);
        this.f8352b.setVisibility(0);
        h();
        this.l = -1;
        this.t = System.currentTimeMillis();
        this.e.loadUrl(this.h.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.e);
        this.j = new g(this.e);
        a(this.j);
        this.e.addJavascriptInterface(this.j, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.p || this.q) {
            return;
        }
        this.p = true;
        com.kwad.sdk.core.d.a.a("ActionBarWebCard", "showWebActionBar");
        if (this.l != 1) {
            u();
            return;
        }
        s();
        r();
    }

    private void r() {
        this.e.postDelayed(this.y, com.kwad.sdk.core.response.b.b.m(this.f));
    }

    private void s() {
        t();
        this.n = am.a(this.d, this.f8352b, this.u);
        this.n.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.m != null) {
                    b.this.m.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (b.this.m != null) {
                    b.this.m.c();
                }
            }
        });
        this.n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.n != null) {
            this.n.removeAllListeners();
            this.n.cancel();
        }
        if (this.o != null) {
            this.o.removeAllListeners();
            this.o.cancel();
        }
    }

    private void u() {
        Log.w("ActionBarWebCard", "show webCard fail, reason: " + (this.l == -1 ? "timeout" : this.l != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS));
        com.kwad.sdk.core.report.b.n(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f8395a.j;
        if (!com.kwad.sdk.core.response.b.b.o(this.f) || this.e == null) {
            this.f8352b.setVisibility(8);
            return;
        }
        this.f8352b.setVisibility(0);
        this.h = com.kwad.sdk.core.response.b.b.q(this.f).playDetailInfo.detailWebCardInfo;
        this.g = this.f8395a.m;
        this.i = this.f8395a.o;
        if (this.k == null) {
            this.k = new com.kwad.sdk.core.webview.a();
            f();
        }
        e();
        if (this.g != null) {
            this.g.a(this.r);
        }
        this.f8395a.f8405b.add(this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (!com.kwad.sdk.core.response.b.b.o(this.f) || this.e == null) {
            return;
        }
        if (this.g != null) {
            this.g.b(this.r);
        }
        this.f8395a.f8405b.remove(this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.d = (ViewGroup) b(R.id.ksad_bottom_content_container);
        this.f8352b = (FrameLayout) b(R.id.ksad_web_card_container);
        this.e = (WebView) b(R.id.ksad_actionbar_web_card);
    }
}
