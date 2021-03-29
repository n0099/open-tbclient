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
import com.kwad.sdk.core.view.AdBaseFrameLayout;
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
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public WebView f36288b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f36289c;

    /* renamed from: d  reason: collision with root package name */
    public AdStyleInfo.PlayDetailInfo.DetailWebCardInfo f36290d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36291e;

    /* renamed from: f  reason: collision with root package name */
    public a f36292f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36293g;

    /* renamed from: h  reason: collision with root package name */
    public g f36294h;
    public com.kwad.sdk.core.webview.a i;
    public n k;
    public boolean l;
    public long r;
    public ValueAnimator v;
    public ValueAnimator w;
    public int j = -1;
    public a.b m = new a.b() { // from class: com.kwad.sdk.reward.b.b.a.c.1
        @Override // com.kwad.sdk.reward.b.b.a.a.b
        public boolean a() {
            c cVar = c.this;
            cVar.l = cVar.q();
            return c.this.l;
        }
    };
    public e n = new e() { // from class: com.kwad.sdk.reward.b.b.a.c.3
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.e();
        }
    };
    public com.kwad.sdk.reward.a.d o = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.b.b.a.c.4
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
    public com.kwad.sdk.contentalliance.detail.video.e p = new f() { // from class: com.kwad.sdk.reward.b.b.a.c.5
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            c.this.f36293g = true;
        }
    };
    public a.b q = new a.b() { // from class: com.kwad.sdk.reward.b.b.a.c.6
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            ((d) c.this).f36458a.f36218b.a();
        }
    };
    public i.b s = new i.b() { // from class: com.kwad.sdk.reward.b.b.a.c.7
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            c.this.f36289c = aVar;
            c.this.f36288b.setTranslationY(aVar.f34362a + aVar.f34365d);
        }
    };
    public h.a t = new h.a() { // from class: com.kwad.sdk.reward.b.b.a.c.8
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.l = false;
            c.this.t();
        }
    };
    public k.b u = new k.b() { // from class: com.kwad.sdk.reward.b.b.a.c.9
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            c.this.j = i;
            com.kwad.sdk.core.d.a.b("RewardActionBarWeb", "load time:" + (System.currentTimeMillis() - c.this.r));
            if (c.this.f36293g) {
                c.this.f36292f.b(((d) c.this).f36458a.i.i(), ((d) c.this).f36458a.i.j());
            }
        }
    };

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.i, this.f36291e, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.i));
        gVar.a(new i(this.i, this.s));
        gVar.a(new k(this.u));
        n nVar = new n();
        this.k = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.i, this.f36291e));
        gVar.a(new h(this.t));
        gVar.a(new j(this.i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.j = -1;
        this.f36288b.setVisibility(8);
        p();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.i = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f36458a;
        aVar.f34286b = aVar2.f36222f;
        aVar.f34285a = aVar2.f36221e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f36224h;
        aVar.f34287c = adBaseFrameLayout;
        aVar.f34289e = adBaseFrameLayout;
        aVar.f34290f = this.f36288b;
    }

    private void g() {
        this.j = -1;
        h();
        this.f36288b.setBackgroundColor(0);
        this.f36288b.getBackground().setAlpha(0);
        this.f36288b.setVisibility(4);
        this.r = System.currentTimeMillis();
        this.f36288b.loadUrl(this.f36290d.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f36288b);
        g gVar = new g(this.f36288b);
        this.f36294h = gVar;
        a(gVar);
        this.f36288b.addJavascriptInterface(this.f36294h, "KwaiAd");
    }

    private void p() {
        g gVar = this.f36294h;
        if (gVar != null) {
            gVar.a();
            this.f36294h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f36288b.getVisibility() == 0) {
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
        if (this.f36289c == null) {
            s();
            return;
        }
        v();
        this.f36288b.setVisibility(0);
        WebView webView = this.f36288b;
        i.a aVar = this.f36289c;
        ValueAnimator b2 = am.b(webView, aVar.f34362a + aVar.f34365d, 0);
        this.v = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
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
        n nVar = this.k;
        if (nVar != null) {
            nVar.c();
        }
        this.f36288b.setVisibility(0);
        n nVar2 = this.k;
        if (nVar2 != null) {
            nVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f36288b.getVisibility() != 0) {
            return;
        }
        if (this.f36289c == null) {
            u();
            return;
        }
        v();
        WebView webView = this.f36288b;
        i.a aVar = this.f36289c;
        ValueAnimator b2 = am.b(webView, 0, aVar.f34362a + aVar.f34365d);
        this.w = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.w.setDuration(300L);
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.a.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.f36288b.setVisibility(4);
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
        if (this.f36288b.getVisibility() != 0) {
            return;
        }
        n nVar = this.k;
        if (nVar != null) {
            nVar.e();
        }
        this.f36288b.setVisibility(4);
        n nVar2 = this.k;
        if (nVar2 != null) {
            nVar2.f();
        }
    }

    private void v() {
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.v.cancel();
        }
        ValueAnimator valueAnimator2 = this.w;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.w.cancel();
        }
    }

    private void w() {
        int i = this.j;
        String str = i == -1 ? com.alipay.sdk.data.a.i : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36290d = com.kwad.sdk.core.response.b.b.q(((d) this).f36458a.f36222f).playDetailInfo.detailWebCardInfo;
        com.kwad.sdk.reward.a aVar = ((d) this).f36458a;
        this.f36291e = aVar.j;
        a aVar2 = aVar.k;
        this.f36292f = aVar2;
        aVar2.a(this.m);
        f();
        g();
        ((d) this).f36458a.n.add(this.n);
        ((d) this).f36458a.i.a(this.p);
        ((d) this).f36458a.o.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36292f.a((a.b) null);
        ((d) this).f36458a.n.remove(this.n);
        ((d) this).f36458a.o.remove(this.o);
        ((d) this).f36458a.i.b(this.p);
        v();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36288b = (WebView) b(R.id.ksad_play_web_card_webView);
    }
}
