package com.kwad.sdk.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
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
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40316b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f40317c;

    /* renamed from: d  reason: collision with root package name */
    public j.a f40318d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40319e;

    /* renamed from: f  reason: collision with root package name */
    public g f40320f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f40321g;
    public s i;
    public AdTemplate j;
    public ValueAnimator q;
    public ValueAnimator r;

    /* renamed from: h  reason: collision with root package name */
    public int f40322h = -1;
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
            c.this.f40318d = aVar;
            c.this.f40317c.setTranslationY(aVar.a + aVar.f40051d);
        }
    };
    public i.b o = new i.b() { // from class: com.kwad.sdk.draw.a.a.c.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i) {
            c.this.u();
        }
    };
    public p.b p = new p.b() { // from class: com.kwad.sdk.draw.a.a.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            c.this.f40322h = aVar.a;
            com.kwad.sdk.core.d.a.c("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f40321g, this.f40319e, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f40321g, this.f40319e, this.m));
        gVar.a(new f(this.f40321g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f40321g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f40321g));
        gVar.a(new j(this.f40321g, this.n));
        gVar.a(new p(this.p));
        s sVar = new s();
        this.i = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.f40321g, this.f40319e));
        gVar.a(new i(this.o));
        gVar.a(new k(this.f40321g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f40322h = -1;
        this.f40317c.setVisibility(8);
        i();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f40321g = aVar;
        aVar.a(((com.kwad.sdk.draw.kwai.a) this).a.f40360c);
        com.kwad.sdk.core.webview.a aVar2 = this.f40321g;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = ((com.kwad.sdk.draw.kwai.a) this).a.f40359b;
        aVar2.f39981b = adBaseFrameLayout;
        aVar2.f39983d = adBaseFrameLayout;
        aVar2.f39984e = this.f40317c;
    }

    private void g() {
        this.f40322h = -1;
        h();
        this.f40317c.setBackgroundColor(0);
        this.f40317c.getBackground().setAlpha(0);
        this.f40317c.setVisibility(4);
        this.f40317c.loadUrl(com.kwad.sdk.core.response.a.b.b(this.j));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        i();
        be.a(this.f40317c);
        g gVar = new g(this.f40317c);
        this.f40320f = gVar;
        a(gVar);
        this.f40317c.addJavascriptInterface(this.f40320f, "KwaiAd");
    }

    private void i() {
        g gVar = this.f40320f;
        if (gVar != null) {
            gVar.a();
            this.f40320f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (this.f40322h == 1) {
            s();
            return true;
        }
        x();
        return false;
    }

    private void s() {
        if (this.f40318d == null) {
            t();
            return;
        }
        w();
        this.f40316b.setVisibility(8);
        this.f40317c.setVisibility(0);
        KsAdWebView ksAdWebView = this.f40317c;
        j.a aVar = this.f40318d;
        ValueAnimator b2 = az.b(ksAdWebView, aVar.a + aVar.f40051d, 0);
        this.q = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.q.setDuration(300L);
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.a.a.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.i != null) {
                    c.this.i.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.i != null) {
                    c.this.i.c();
                }
            }
        });
        this.q.start();
    }

    private void t() {
        s sVar = this.i;
        if (sVar != null) {
            sVar.c();
        }
        this.f40316b.setVisibility(8);
        this.f40317c.setVisibility(0);
        s sVar2 = this.i;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f40317c.getVisibility() != 0) {
            return;
        }
        if (this.f40318d == null) {
            v();
            return;
        }
        w();
        KsAdWebView ksAdWebView = this.f40317c;
        j.a aVar = this.f40318d;
        ValueAnimator b2 = az.b(ksAdWebView, 0, aVar.a + aVar.f40051d);
        this.r = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.a.a.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f40317c.setVisibility(4);
                c.this.f40316b.setVisibility(0);
                if (c.this.i != null) {
                    c.this.i.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.i != null) {
                    c.this.i.e();
                }
            }
        });
        this.r.start();
    }

    private void v() {
        if (this.f40317c.getVisibility() != 0) {
            return;
        }
        s sVar = this.i;
        if (sVar != null) {
            sVar.e();
        }
        this.f40317c.setVisibility(4);
        this.f40316b.setVisibility(0);
        s sVar2 = this.i;
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
        int i = this.f40322h;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.j = bVar.f40360c;
        bVar.f40363f.a(this.l);
        com.kwad.sdk.draw.kwai.b bVar2 = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.f40319e = bVar2.f40361d;
        bVar2.f40362e.a(this.k);
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f40363f.a((a.b) null);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40362e.b(this.k);
        w();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40316b = (ViewGroup) a(R.id.obfuscated_res_0x7f091023);
        this.f40317c = (KsAdWebView) a(R.id.obfuscated_res_0x7f0910c2);
    }
}
