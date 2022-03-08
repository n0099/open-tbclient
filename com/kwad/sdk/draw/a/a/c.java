package com.kwad.sdk.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.draw.a.a.a;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.be;
/* loaded from: classes8.dex */
public class c extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55253b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f55254c;

    /* renamed from: d  reason: collision with root package name */
    public j.a f55255d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55256e;

    /* renamed from: f  reason: collision with root package name */
    public g f55257f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f55258g;

    /* renamed from: i  reason: collision with root package name */
    public s f55260i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f55261j;
    public ValueAnimator q;
    public ValueAnimator r;

    /* renamed from: h  reason: collision with root package name */
    public int f55259h = -1;
    public d k = new e() { // from class: com.kwad.sdk.draw.a.a.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            super.f();
            c.this.e();
        }
    };
    public a.b l = new a.b() { // from class: com.kwad.sdk.draw.a.a.c.2
        @Override // com.kwad.sdk.draw.a.a.a.b
        public boolean a() {
            return c.this.r();
        }
    };
    public b.c m = new b.c() { // from class: com.kwad.sdk.draw.a.a.c.3
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            if (((com.kwad.sdk.draw.kwai.a) c.this).a.a != null) {
                ((com.kwad.sdk.draw.kwai.a) c.this).a.a.onAdClicked();
            }
        }
    };
    public j.b n = new j.b() { // from class: com.kwad.sdk.draw.a.a.c.4
        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(j.a aVar) {
            c.this.f55255d = aVar;
            c.this.f55254c.setTranslationY(aVar.a + aVar.f54965d);
        }
    };
    public i.b o = new i.b() { // from class: com.kwad.sdk.draw.a.a.c.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i2) {
            c.this.u();
        }
    };
    public p.b p = new p.b() { // from class: com.kwad.sdk.draw.a.a.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            c.this.f55259h = aVar.a;
            com.kwad.sdk.core.d.a.c("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f55258g, this.f55256e, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f55258g, this.f55256e, this.m));
        gVar.a(new f(this.f55258g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f55258g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f55258g));
        gVar.a(new j(this.f55258g, this.n));
        gVar.a(new p(this.p));
        s sVar = new s();
        this.f55260i = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.f55258g, this.f55256e));
        gVar.a(new i(this.o));
        gVar.a(new k(this.f55258g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f55259h = -1;
        this.f55254c.setVisibility(8);
        i();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f55258g = aVar;
        aVar.a(((com.kwad.sdk.draw.kwai.a) this).a.f55301c);
        com.kwad.sdk.core.webview.a aVar2 = this.f55258g;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = ((com.kwad.sdk.draw.kwai.a) this).a.f55300b;
        aVar2.f54889b = adBaseFrameLayout;
        aVar2.f54891d = adBaseFrameLayout;
        aVar2.f54892e = this.f55254c;
    }

    private void g() {
        this.f55259h = -1;
        h();
        this.f55254c.setBackgroundColor(0);
        this.f55254c.getBackground().setAlpha(0);
        this.f55254c.setVisibility(4);
        this.f55254c.loadUrl(com.kwad.sdk.core.response.a.b.b(this.f55261j));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        i();
        be.a(this.f55254c);
        g gVar = new g(this.f55254c);
        this.f55257f = gVar;
        a(gVar);
        this.f55254c.addJavascriptInterface(this.f55257f, "KwaiAd");
    }

    private void i() {
        g gVar = this.f55257f;
        if (gVar != null) {
            gVar.a();
            this.f55257f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (this.f55259h == 1) {
            s();
            return true;
        }
        x();
        return false;
    }

    private void s() {
        if (this.f55255d == null) {
            t();
            return;
        }
        w();
        this.f55253b.setVisibility(8);
        this.f55254c.setVisibility(0);
        KsAdWebView ksAdWebView = this.f55254c;
        j.a aVar = this.f55255d;
        ValueAnimator b2 = az.b(ksAdWebView, aVar.a + aVar.f54965d, 0);
        this.q = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.q.setDuration(300L);
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.a.a.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.f55260i != null) {
                    c.this.f55260i.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.f55260i != null) {
                    c.this.f55260i.c();
                }
            }
        });
        this.q.start();
    }

    private void t() {
        s sVar = this.f55260i;
        if (sVar != null) {
            sVar.c();
        }
        this.f55253b.setVisibility(8);
        this.f55254c.setVisibility(0);
        s sVar2 = this.f55260i;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f55254c.getVisibility() != 0) {
            return;
        }
        if (this.f55255d == null) {
            v();
            return;
        }
        w();
        KsAdWebView ksAdWebView = this.f55254c;
        j.a aVar = this.f55255d;
        ValueAnimator b2 = az.b(ksAdWebView, 0, aVar.a + aVar.f54965d);
        this.r = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.a.a.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f55254c.setVisibility(4);
                c.this.f55253b.setVisibility(0);
                if (c.this.f55260i != null) {
                    c.this.f55260i.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.f55260i != null) {
                    c.this.f55260i.e();
                }
            }
        });
        this.r.start();
    }

    private void v() {
        if (this.f55254c.getVisibility() != 0) {
            return;
        }
        s sVar = this.f55260i;
        if (sVar != null) {
            sVar.e();
        }
        this.f55254c.setVisibility(4);
        this.f55253b.setVisibility(0);
        s sVar2 = this.f55260i;
        if (sVar2 != null) {
            sVar2.f();
        }
    }

    private void w() {
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

    private void x() {
        int i2 = this.f55259h;
        String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f55261j = bVar.f55301c;
        bVar.f55304f.a(this.l);
        com.kwad.sdk.draw.kwai.b bVar2 = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f55256e = bVar2.f55302d;
        bVar2.f55303e.a(this.k);
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f55304f.a((a.b) null);
        ((com.kwad.sdk.draw.kwai.a) this).a.f55303e.b(this.k);
        w();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55253b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f55254c = (KsAdWebView) a(R.id.ksad_play_web_card_webView);
    }
}
