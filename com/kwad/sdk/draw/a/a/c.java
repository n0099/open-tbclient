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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.draw.kwai.a {
    public ViewGroup b;
    public KsAdWebView c;
    public j.a d;
    public com.kwad.sdk.core.download.a.b e;
    public g f;
    public com.kwad.sdk.core.webview.a g;
    public s i;
    public AdTemplate j;
    public ValueAnimator q;
    public ValueAnimator r;
    public int h = -1;
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
            c.this.d = aVar;
            c.this.c.setTranslationY(aVar.a + aVar.d);
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
            c.this.h = aVar.a;
            com.kwad.sdk.core.d.a.c("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.g, this.e, this.m));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.g, this.e, this.m));
        gVar.a(new f(this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.g));
        gVar.a(new j(this.g, this.n));
        gVar.a(new p(this.p));
        s sVar = new s();
        this.i = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.g, this.e));
        gVar.a(new i(this.o));
        gVar.a(new k(this.g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.h = -1;
        this.c.setVisibility(8);
        i();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.g = aVar;
        aVar.a(((com.kwad.sdk.draw.kwai.a) this).a.c);
        com.kwad.sdk.core.webview.a aVar2 = this.g;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = ((com.kwad.sdk.draw.kwai.a) this).a.b;
        aVar2.b = adBaseFrameLayout;
        aVar2.d = adBaseFrameLayout;
        aVar2.e = this.c;
    }

    private void g() {
        this.h = -1;
        h();
        this.c.setBackgroundColor(0);
        this.c.getBackground().setAlpha(0);
        this.c.setVisibility(4);
        this.c.loadUrl(com.kwad.sdk.core.response.a.b.b(this.j));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        i();
        be.a(this.c);
        g gVar = new g(this.c);
        this.f = gVar;
        a(gVar);
        this.c.addJavascriptInterface(this.f, "KwaiAd");
    }

    private void i() {
        g gVar = this.f;
        if (gVar != null) {
            gVar.a();
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (this.h == 1) {
            s();
            return true;
        }
        x();
        return false;
    }

    private void s() {
        if (this.d == null) {
            t();
            return;
        }
        w();
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        KsAdWebView ksAdWebView = this.c;
        j.a aVar = this.d;
        ValueAnimator b = az.b(ksAdWebView, aVar.a + aVar.d, 0);
        this.q = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
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
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        s sVar2 = this.i;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.c.getVisibility() != 0) {
            return;
        }
        if (this.d == null) {
            v();
            return;
        }
        w();
        KsAdWebView ksAdWebView = this.c;
        j.a aVar = this.d;
        ValueAnimator b = az.b(ksAdWebView, 0, aVar.a + aVar.d);
        this.r = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.r.setDuration(300L);
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.draw.a.a.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.c.setVisibility(4);
                c.this.b.setVisibility(0);
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
        if (this.c.getVisibility() != 0) {
            return;
        }
        s sVar = this.i;
        if (sVar != null) {
            sVar.e();
        }
        this.c.setVisibility(4);
        this.b.setVisibility(0);
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
        int i = this.h;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("DrawPlayWebCard", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.draw.kwai.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.j = bVar.c;
        bVar.f.a(this.l);
        com.kwad.sdk.draw.kwai.b bVar2 = ((com.kwad.sdk.draw.kwai.a) this).a;
        this.e = bVar2.d;
        bVar2.e.a(this.k);
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.draw.kwai.a) this).a.f.a((a.b) null);
        ((com.kwad.sdk.draw.kwai.a) this).a.e.b(this.k);
        w();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f09101d);
        this.c = (KsAdWebView) a(R.id.obfuscated_res_0x7f0910bc);
    }
}
