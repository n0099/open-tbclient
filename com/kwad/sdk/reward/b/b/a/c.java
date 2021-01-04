package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ar;
/* loaded from: classes5.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    private WebView f10855b;
    private i.a c;
    private AdStyleInfo.PlayDetailInfo.DetailWebCardInfo d;
    private com.kwad.sdk.core.download.b.b e;
    private a f;
    private boolean g;
    private g h;
    private com.kwad.sdk.core.webview.a i;
    private n k;
    private boolean l;
    private long r;
    private ValueAnimator v;
    private ValueAnimator w;
    private int j = -1;
    private a.b m = new a.b() { // from class: com.kwad.sdk.reward.b.b.a.c.1
        @Override // com.kwad.sdk.reward.b.b.a.a.b
        public boolean a() {
            c.this.l = c.this.q();
            return c.this.l;
        }
    };
    private e n = new e() { // from class: com.kwad.sdk.reward.b.b.a.c.3
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.e();
        }
    };
    private com.kwad.sdk.reward.a.d o = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.b.b.a.c.4
        @Override // com.kwad.sdk.reward.a.d
        public void a() {
            c.this.t();
        }

        @Override // com.kwad.sdk.reward.a.d
        public void b() {
            if (c.this.l) {
                c.this.r();
            }
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e p = new f() { // from class: com.kwad.sdk.reward.b.b.a.c.5
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            c.this.g = true;
        }
    };
    private a.b q = new a.b() { // from class: com.kwad.sdk.reward.b.b.a.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            c.this.f10949a.f10824b.a();
        }
    };
    private i.b s = new i.b() { // from class: com.kwad.sdk.reward.b.b.a.c.7
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.c = aVar;
            c.this.f10855b.setTranslationY(aVar.f9884a + aVar.d);
        }
    };
    private h.a t = new h.a() { // from class: com.kwad.sdk.reward.b.b.a.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.l = false;
            c.this.t();
        }
    };
    private k.b u = new k.b() { // from class: com.kwad.sdk.reward.b.b.a.c.9
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            c.this.j = i;
            com.kwad.sdk.core.d.a.b("RewardActionBarWeb", "load time:" + (System.currentTimeMillis() - c.this.r));
            if (c.this.g) {
                c.this.f.b(c.this.f10949a.i.i(), c.this.f10949a.i.j());
            }
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.i, this.e, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.i));
        gVar.a(new i(this.i, this.s));
        gVar.a(new k(this.u));
        this.k = new n();
        gVar.a(this.k);
        gVar.a(new o(this.i, this.e));
        gVar.a(new h(this.t));
        gVar.a(new j(this.i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.j = -1;
        this.f10855b.setVisibility(8);
        p();
    }

    private void f() {
        this.i = new com.kwad.sdk.core.webview.a();
        this.i.f9836b = this.f10949a.f;
        this.i.f9835a = this.f10949a.e;
        this.i.c = this.f10949a.h;
        this.i.e = this.f10949a.h;
        this.i.f = this.f10855b;
    }

    private void g() {
        this.j = -1;
        h();
        this.f10855b.setBackgroundColor(0);
        this.f10855b.getBackground().setAlpha(0);
        this.f10855b.setVisibility(4);
        this.r = System.currentTimeMillis();
        this.f10855b.loadUrl(this.d.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f10855b);
        this.h = new g(this.f10855b);
        a(this.h);
        this.f10855b.addJavascriptInterface(this.h, "KwaiAd");
    }

    private void p() {
        if (this.h != null) {
            this.h.a();
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f10855b.getVisibility() == 0) {
            return true;
        }
        if (this.j == 1) {
            r();
            return true;
        }
        w();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.c == null) {
            s();
            return;
        }
        v();
        this.f10855b.setVisibility(0);
        this.v = am.b(this.f10855b, this.c.f9884a + this.c.d, 0);
        this.v.setInterpolator(new DecelerateInterpolator(2.0f));
        this.v.setDuration(300L);
        this.v.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.c.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.k != null) {
                    c.this.k.d();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.k != null) {
                    c.this.k.c();
                }
            }
        });
        this.v.start();
    }

    private void s() {
        if (this.k != null) {
            this.k.c();
        }
        this.f10855b.setVisibility(0);
        if (this.k != null) {
            this.k.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f10855b.getVisibility() != 0) {
            return;
        }
        if (this.c == null) {
            u();
            return;
        }
        v();
        this.w = am.b(this.f10855b, 0, this.c.f9884a + this.c.d);
        this.w.setInterpolator(new DecelerateInterpolator(2.0f));
        this.w.setDuration(300L);
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f10855b.setVisibility(4);
                if (c.this.k != null) {
                    c.this.k.f();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.k != null) {
                    c.this.k.e();
                }
            }
        });
        this.w.start();
    }

    private void u() {
        if (this.f10855b.getVisibility() != 0) {
            return;
        }
        if (this.k != null) {
            this.k.e();
        }
        this.f10855b.setVisibility(4);
        if (this.k != null) {
            this.k.f();
        }
    }

    private void v() {
        if (this.v != null) {
            this.v.removeAllListeners();
            this.v.cancel();
        }
        if (this.w != null) {
            this.w.removeAllListeners();
            this.w.cancel();
        }
    }

    private void w() {
        Log.w("RewardActionBarWeb", "show webCard fail, reason: " + (this.j == -1 ? "timeout" : this.j != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = com.kwad.sdk.core.response.b.b.q(this.f10949a.f).playDetailInfo.detailWebCardInfo;
        this.e = this.f10949a.j;
        this.f = this.f10949a.k;
        this.f.a(this.m);
        f();
        g();
        this.f10949a.n.add(this.n);
        this.f10949a.i.a(this.p);
        this.f10949a.o.add(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f.a((a.b) null);
        this.f10949a.n.remove(this.n);
        this.f10949a.o.remove(this.o);
        this.f10949a.i.b(this.p);
        v();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10855b = (WebView) b(R.id.ksad_play_web_card_webView);
    }
}
