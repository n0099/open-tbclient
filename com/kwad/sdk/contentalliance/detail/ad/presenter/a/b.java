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
    public FrameLayout f32063b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32064c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f32065d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f32066e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f32067f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32068g;

    /* renamed from: h  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f32069h;
    public com.kwad.sdk.core.download.b.b i;
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
            if (j2 >= com.kwad.sdk.core.response.b.b.g(b.this.f32067f)) {
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
        public void a(int i) {
            b.this.l = i;
            com.kwad.sdk.core.d.a.b("ActionBarWebCard", "position:" + ((com.kwad.sdk.contentalliance.detail.b) b.this).f32132a.i + " load time:" + (System.currentTimeMillis() - b.this.t));
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {

        /* renamed from: a  reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f32071a;

        public AnonymousClass2() {
        }

        private void a() {
            b.this.p = false;
            b.this.q = false;
            b.this.f32065d.setTranslationX(0.0f);
            b.this.f32063b.setTranslationX(-b.this.u);
            b.this.f32066e.removeCallbacks(b.this.y);
        }

        private void b() {
            this.f32071a = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.a.b.2.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    b.this.f32063b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.f32071a = null;
                    b.this.g();
                }
            };
            b.this.f32063b.getViewTreeObserver().addOnGlobalLayoutListener(this.f32071a);
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
            if (this.f32071a != null) {
                b.this.f32063b.getViewTreeObserver().removeOnGlobalLayoutListener(this.f32071a);
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
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.i, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
        gVar.a(new i(this.k, null));
        gVar.a(new k(this.w));
        n nVar = new n();
        this.m = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.k, this.i));
        gVar.a(new h(this.v));
        gVar.a(new j(this.k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (ao.a((View) this.f32066e, 50, false)) {
            this.q = z;
            t();
            this.f32066e.removeCallbacks(this.y);
            ValueAnimator a2 = am.a(this.f32063b, this.f32065d, this.u);
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
        aVar.f34285b = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j;
        aVar.f34284a = 0;
        aVar.f34286c = this.f32064c;
        aVar.f34288e = this.f32063b;
        aVar.f34289f = this.f32066e;
    }

    private void f() {
        this.f32063b.setVisibility(4);
        this.f32066e.setBackgroundColor(0);
        this.f32066e.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.u = this.f32063b.getWidth() + ao.a(this.f32063b.getContext(), 12.0f);
        com.kwad.sdk.core.d.a.a("ActionBarWebCard", "initWebCard mWebCardContainerWidth:" + this.u);
        this.f32063b.setTranslationX((float) (-this.u));
        this.f32063b.setVisibility(0);
        h();
        this.l = -1;
        this.t = System.currentTimeMillis();
        this.f32066e.loadUrl(this.f32069h.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f32066e);
        g gVar = new g(this.f32066e);
        this.j = gVar;
        a(gVar);
        this.f32066e.addJavascriptInterface(this.j, "KwaiAd");
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
        this.f32066e.postDelayed(this.y, com.kwad.sdk.core.response.b.b.m(this.f32067f));
    }

    private void s() {
        t();
        ValueAnimator a2 = am.a(this.f32065d, this.f32063b, this.u);
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
        int i = this.l;
        String str = i == -1 ? com.alipay.sdk.data.a.i : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("ActionBarWebCard", "show webCard fail, reason: " + str);
        com.kwad.sdk.core.report.b.n(this.f32067f);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j;
        this.f32067f = adTemplate;
        if (!com.kwad.sdk.core.response.b.b.o(adTemplate) || this.f32066e == null) {
            this.f32063b.setVisibility(8);
            return;
        }
        this.f32063b.setVisibility(0);
        this.f32069h = com.kwad.sdk.core.response.b.b.q(this.f32067f).playDetailInfo.detailWebCardInfo;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        this.f32068g = cVar.m;
        this.i = cVar.o;
        if (this.k == null) {
            this.k = new com.kwad.sdk.core.webview.a();
            f();
        }
        e();
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32068g;
        if (bVar != null) {
            bVar.a(this.r);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(this.s);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (!com.kwad.sdk.core.response.b.b.o(this.f32067f) || this.f32066e == null) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32068g;
        if (bVar != null) {
            bVar.b(this.r);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.remove(this.s);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32064c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32065d = (ViewGroup) b(R.id.ksad_bottom_content_container);
        this.f32063b = (FrameLayout) b(R.id.ksad_web_card_container);
        this.f32066e = (WebView) b(R.id.ksad_actionbar_web_card);
    }
}
