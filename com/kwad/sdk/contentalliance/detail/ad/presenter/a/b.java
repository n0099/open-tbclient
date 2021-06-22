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
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f32718b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32719c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f32720d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f32721e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32722f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32723g;

    /* renamed from: h  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f32724h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32725i;
    public g j;
    public com.kwad.sdk.core.webview.a k;
    public n m;
    public ValueAnimator n;
    public ValueAnimator o;
    public long t;
    public int u;
    public Runnable x;
    public Runnable y;
    public int l = -1;
    public boolean p = false;
    public boolean q = false;
    public e r = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            b.this.p = false;
            b.this.a(false);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.response.b.b.g(b.this.f32722f)) {
                b.this.q();
            }
        }
    };
    public com.kwad.sdk.contentalliance.a.a s = new AnonymousClass2();
    public h.a v = new h.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.3
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            b.this.a(true);
        }
    };
    public k.b w = new k.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            b.this.l = i2;
            com.kwad.sdk.core.d.a.b("ActionBarWebCard", "position:" + ((com.kwad.sdk.contentalliance.detail.b) b.this).f32790a.f32819i + " load time:" + (System.currentTimeMillis() - b.this.t));
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {

        /* renamed from: a  reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f32727a;

        public AnonymousClass2() {
        }

        private void a() {
            b.this.p = false;
            b.this.q = false;
            b.this.f32720d.setTranslationX(0.0f);
            b.this.f32718b.setTranslationX(-b.this.u);
            b.this.f32721e.removeCallbacks(b.this.y);
        }

        private void b() {
            this.f32727a = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.2.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    b.this.f32718b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.f32727a = null;
                    b.this.g();
                }
            };
            b.this.f32718b.getViewTreeObserver().addOnGlobalLayoutListener(this.f32727a);
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
            if (this.f32727a != null) {
                b.this.f32718b.getViewTreeObserver().removeOnGlobalLayoutListener(this.f32727a);
            }
        }
    }

    public b() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(false);
            }
        };
        this.x = runnable;
        this.y = new aq(runnable);
    }

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f32725i, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
        gVar.a(new i(this.k, null));
        gVar.a(new k(this.w));
        n nVar = new n();
        this.m = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.k, this.f32725i));
        gVar.a(new h(this.v));
        gVar.a(new j(this.k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (ao.a((View) this.f32721e, 50, false)) {
            this.q = z;
            t();
            this.f32721e.removeCallbacks(this.y);
            ValueAnimator a2 = am.a(this.f32718b, this.f32720d, this.u);
            this.o = a2;
            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.7
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
        com.kwad.sdk.core.webview.a aVar = this.k;
        aVar.f35027b = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j;
        aVar.f35026a = 0;
        aVar.f35028c = this.f32719c;
        aVar.f35030e = this.f32718b;
        aVar.f35031f = this.f32721e;
    }

    private void f() {
        this.f32718b.setVisibility(4);
        this.f32721e.setBackgroundColor(0);
        this.f32721e.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.u = this.f32718b.getWidth() + ao.a(this.f32718b.getContext(), 12.0f);
        com.kwad.sdk.core.d.a.a("ActionBarWebCard", "initWebCard mWebCardContainerWidth:" + this.u);
        this.f32718b.setTranslationX((float) (-this.u));
        this.f32718b.setVisibility(0);
        h();
        this.l = -1;
        this.t = System.currentTimeMillis();
        this.f32721e.loadUrl(this.f32724h.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f32721e);
        g gVar = new g(this.f32721e);
        this.j = gVar;
        a(gVar);
        this.f32721e.addJavascriptInterface(this.j, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.a();
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
        this.f32721e.postDelayed(this.y, com.kwad.sdk.core.response.b.b.m(this.f32722f));
    }

    private void s() {
        t();
        ValueAnimator a2 = am.a(this.f32720d, this.f32718b, this.u);
        this.n = a2;
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.6
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
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.n.cancel();
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.o.cancel();
        }
    }

    private void u() {
        int i2 = this.l;
        String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("ActionBarWebCard", "show webCard fail, reason: " + str);
        com.kwad.sdk.core.report.b.n(this.f32722f);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j;
        this.f32722f = adTemplate;
        if (!com.kwad.sdk.core.response.b.b.o(adTemplate) || this.f32721e == null) {
            this.f32718b.setVisibility(8);
            return;
        }
        this.f32718b.setVisibility(0);
        this.f32724h = com.kwad.sdk.core.response.b.b.q(this.f32722f).playDetailInfo.detailWebCardInfo;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        this.f32723g = cVar.m;
        this.f32725i = cVar.o;
        if (this.k == null) {
            this.k = new com.kwad.sdk.core.webview.a();
            f();
        }
        e();
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32723g;
        if (bVar != null) {
            bVar.a(this.r);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.add(this.s);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (!com.kwad.sdk.core.response.b.b.o(this.f32722f) || this.f32721e == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32723g;
        if (bVar != null) {
            bVar.b(this.r);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32812b.remove(this.s);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32719c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32720d = (ViewGroup) b(R.id.ksad_bottom_content_container);
        this.f32718b = (FrameLayout) b(R.id.ksad_web_card_container);
        this.f32721e = (WebView) b(R.id.ksad_actionbar_web_card);
    }
}
