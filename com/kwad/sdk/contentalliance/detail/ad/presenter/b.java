package com.kwad.sdk.contentalliance.detail.ad.presenter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private AdBaseFrameLayout f8360b;
    private WebView c;
    private AdTemplate d;
    private com.kwad.sdk.contentalliance.detail.video.b e;
    private AdStyleInfo.PlayEndInfo.AdWebCardInfo f;
    private com.kwad.sdk.core.download.b.b g;
    private g i;
    private com.kwad.sdk.core.webview.a j;
    private n l;
    private boolean m;
    private long p;
    private int h = 0;
    private int k = -1;
    private e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.a(b.this);
            int h = com.kwad.sdk.core.response.b.b.h(b.this.d);
            if (h <= 0) {
                h = 1;
            }
            if (b.this.f8393a.b()) {
                if (b.this.e != null) {
                    b.this.e.h();
                }
            } else if (b.this.h == 1 || (b.this.h - 1) % h == 0) {
                b.this.q();
            } else if (b.this.e != null) {
                b.this.e.h();
            }
        }
    };
    private com.kwad.sdk.contentalliance.a.a o = new AnonymousClass2();
    private q.a q = new q.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.3
        @Override // com.kwad.sdk.core.webview.jshandler.q.a
        public void a() {
            if (b.this.e != null) {
                b.this.e.h();
            }
            b.this.r();
        }
    };
    private h.a r = new h.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            b.this.r();
        }
    };
    private k.b s = new k.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            b.this.k = i;
            com.kwad.sdk.core.d.a.b("AdPlayEndWebPresenter", "position:" + b.this.f8393a.i + " load time:" + (System.currentTimeMillis() - b.this.p));
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.b$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {

        /* renamed from: a  reason: collision with root package name */
        ViewTreeObserver.OnGlobalLayoutListener f8362a;

        AnonymousClass2() {
        }

        private void a() {
            b.this.h = 0;
            b.this.c.setVisibility(4);
        }

        private void b() {
            this.f8362a = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.2.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    b.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass2.this.f8362a = null;
                    b.this.g();
                }
            };
            b.this.c.getViewTreeObserver().addOnGlobalLayoutListener(this.f8362a);
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
            if (this.f8362a != null) {
                b.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this.f8362a);
            }
        }
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.h;
        bVar.h = i + 1;
        return i;
    }

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.g, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new c(this.j));
        gVar.a(new k(this.s));
        this.l = new n();
        gVar.a(this.l);
        gVar.a(new o(this.j, this.g));
        gVar.a(new h(this.r));
        gVar.a(new j(this.j));
        gVar.a(new q(this.q));
    }

    private void e() {
        this.j.f9537b = this.f8393a.j;
        this.j.f9536a = 0;
        this.j.c = this.f8360b;
        this.j.e = this.f8360b;
        this.j.f = this.c;
    }

    private void f() {
        this.c.setVisibility(4);
        this.c.setBackgroundColor(0);
        this.c.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.c.setVisibility(4);
        h();
        this.k = -1;
        this.p = System.currentTimeMillis();
        this.c.loadUrl(this.f.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.c);
        this.i = new g(this.c);
        a(this.i);
        this.c.addJavascriptInterface(this.i, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.k != 1) {
            s();
            return;
        }
        if (this.l != null) {
            this.l.c();
        }
        this.c.setVisibility(0);
        if (this.l != null) {
            this.l.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (ao.a((View) this.c, 50, false)) {
            if (this.l != null) {
                this.l.e();
            }
            this.c.setVisibility(4);
            if (this.l != null) {
                this.l.f();
            }
        }
    }

    private void s() {
        Log.w("AdPlayEndWebPresenter", "show webCard fail, reason: " + (this.k == -1 ? "timeout" : this.k != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.f8393a.j;
        this.m = !com.kwad.sdk.core.response.b.b.p(this.d);
        this.c.setVisibility(8);
        if (this.m) {
            return;
        }
        this.f = com.kwad.sdk.core.response.b.b.q(this.d).playEndInfo.adWebCardInfo;
        this.e = this.f8393a.m;
        this.g = this.f8393a.o;
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.webview.a();
            f();
        }
        e();
        if (this.e != null) {
            this.e.a(this.n);
        }
        this.f8393a.f8403b.add(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.m) {
            return;
        }
        if (this.e != null) {
            this.e.b(this.n);
        }
        this.f8393a.f8403b.remove(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8360b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.c = (WebView) b(R.id.ksad_play_end_web_card);
    }
}
