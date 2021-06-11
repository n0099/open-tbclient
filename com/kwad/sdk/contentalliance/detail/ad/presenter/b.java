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
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f32637b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f32638c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32639d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32640e;

    /* renamed from: f  reason: collision with root package name */
    public AdStyleInfo.PlayEndInfo.AdWebCardInfo f32641f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32642g;

    /* renamed from: i  reason: collision with root package name */
    public g f32644i;
    public com.kwad.sdk.core.webview.a j;
    public n l;
    public boolean m;
    public long p;

    /* renamed from: h  reason: collision with root package name */
    public int f32643h = 0;
    public int k = -1;
    public e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            b.a(b.this);
            int h2 = com.kwad.sdk.core.response.b.b.h(b.this.f32639d);
            if (h2 <= 0) {
                h2 = 1;
            }
            if (((com.kwad.sdk.contentalliance.detail.b) b.this).f32692a.b()) {
                if (b.this.f32640e == null) {
                    return;
                }
            } else if (b.this.f32643h == 1 || (b.this.f32643h - 1) % h2 == 0) {
                b.this.q();
                return;
            } else if (b.this.f32640e == null) {
                return;
            }
            b.this.f32640e.h();
        }
    };
    public com.kwad.sdk.contentalliance.a.a o = new AnonymousClass2();
    public q.a q = new q.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.3
        @Override // com.kwad.sdk.core.webview.jshandler.q.a
        public void a() {
            if (b.this.f32640e != null) {
                b.this.f32640e.h();
            }
            b.this.r();
        }
    };
    public h.a r = new h.a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.4
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            b.this.r();
        }
    };
    public k.b s = new k.b() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.5
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            b.this.k = i2;
            com.kwad.sdk.core.d.a.b("AdPlayEndWebPresenter", "position:" + ((com.kwad.sdk.contentalliance.detail.b) b.this).f32692a.f32721i + " load time:" + (System.currentTimeMillis() - b.this.p));
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.detail.ad.presenter.b$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 extends com.kwad.sdk.contentalliance.a.b {

        /* renamed from: a  reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f32646a;

        public AnonymousClass2() {
        }

        private void a() {
            b.this.f32643h = 0;
            b.this.f32638c.setVisibility(4);
        }

        private void b() {
            this.f32646a = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.b.2.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    b.this.f32638c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.f32646a = null;
                    b.this.g();
                }
            };
            b.this.f32638c.getViewTreeObserver().addOnGlobalLayoutListener(this.f32646a);
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
            if (this.f32646a != null) {
                b.this.f32638c.getViewTreeObserver().removeOnGlobalLayoutListener(this.f32646a);
            }
        }
    }

    public static /* synthetic */ int a(b bVar) {
        int i2 = bVar.f32643h;
        bVar.f32643h = i2 + 1;
        return i2;
    }

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f32642g, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new c(this.j));
        gVar.a(new k(this.s));
        n nVar = new n();
        this.l = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.j, this.f32642g));
        gVar.a(new h(this.r));
        gVar.a(new j(this.j));
        gVar.a(new q(this.q));
    }

    private void e() {
        com.kwad.sdk.core.webview.a aVar = this.j;
        aVar.f34929b = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
        aVar.f34928a = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f32637b;
        aVar.f34930c = adBaseFrameLayout;
        aVar.f34932e = adBaseFrameLayout;
        aVar.f34933f = this.f32638c;
    }

    private void f() {
        this.f32638c.setVisibility(4);
        this.f32638c.setBackgroundColor(0);
        this.f32638c.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f32638c.setVisibility(4);
        h();
        this.k = -1;
        this.p = System.currentTimeMillis();
        this.f32638c.loadUrl(this.f32641f.cardUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f32638c);
        g gVar = new g(this.f32638c);
        this.f32644i = gVar;
        a(gVar);
        this.f32638c.addJavascriptInterface(this.f32644i, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        g gVar = this.f32644i;
        if (gVar != null) {
            gVar.a();
            this.f32644i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.k != 1) {
            s();
            return;
        }
        n nVar = this.l;
        if (nVar != null) {
            nVar.c();
        }
        this.f32638c.setVisibility(0);
        n nVar2 = this.l;
        if (nVar2 != null) {
            nVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (ao.a((View) this.f32638c, 50, false)) {
            n nVar = this.l;
            if (nVar != null) {
                nVar.e();
            }
            this.f32638c.setVisibility(4);
            n nVar2 = this.l;
            if (nVar2 != null) {
                nVar2.f();
            }
        }
    }

    private void s() {
        int i2 = this.k;
        String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("AdPlayEndWebPresenter", "show webCard fail, reason: " + str);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
        this.f32639d = adTemplate;
        this.m = !com.kwad.sdk.core.response.b.b.p(adTemplate);
        this.f32638c.setVisibility(8);
        if (this.m) {
            return;
        }
        this.f32641f = com.kwad.sdk.core.response.b.b.q(this.f32639d).playEndInfo.adWebCardInfo;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        this.f32640e = cVar.m;
        this.f32642g = cVar.o;
        if (this.j == null) {
            this.j = new com.kwad.sdk.core.webview.a();
            f();
        }
        e();
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32640e;
        if (bVar != null) {
            bVar.a(this.n);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.m) {
            return;
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32640e;
        if (bVar != null) {
            bVar.b(this.n);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32637b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32638c = (WebView) b(R.id.ksad_play_end_web_card);
    }
}
