package com.kwad.sdk.reward.b.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ar;
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f36644b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f36645c;

    /* renamed from: d  reason: collision with root package name */
    public n f36646d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36647e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36648f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f36649g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f36650h;
    public g i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.f36649g.removeCallbacksAndMessages(null);
            c.this.f36649g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.l(c.this.f36647e) + 200);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i, String str, String str2) {
            c.this.v.a(-1);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void b() {
        }
    };
    public e n = new f() { // from class: com.kwad.sdk.reward.b.b.c.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            if (c.this.l) {
                c cVar = c.this;
                cVar.a(((d) cVar).f36747a.i.i(), ((d) c.this).f36747a.i.j());
            }
            c.this.k = true;
        }
    };
    public com.kwad.sdk.reward.a.e o = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.b.c.4
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.k = false;
            c.this.f();
            if (c.this.l) {
                c.this.g();
            }
        }
    };
    public a.b p = new a.b() { // from class: com.kwad.sdk.reward.b.b.c.7
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
            ((d) c.this).f36747a.f36507b.a();
        }
    };
    public long q;
    public Runnable r;
    public aq s;
    public i.b t;
    public h.a u;
    public k.b v;

    public c() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.reward.b.b.c.8
            @Override // java.lang.Runnable
            public void run() {
                c.this.l = true;
                c.this.f36650h.setVisibility(4);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(((d) cVar).f36747a.i.i(), ((d) c.this).f36747a.i.j());
                }
            }
        };
        this.r = runnable;
        this.s = new aq(runnable);
        this.t = new i.b() { // from class: com.kwad.sdk.reward.b.b.c.9
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
            }
        };
        this.u = new h.a() { // from class: com.kwad.sdk.reward.b.b.c.10
            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                c.this.f36646d.e();
                c.this.f36650h.setVisibility(4);
                c.this.f36646d.f();
            }
        };
        this.v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i) {
                com.kwad.sdk.core.d.a.b("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
                c.this.f36649g.removeCallbacksAndMessages(null);
                if (i != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    c.this.r.run();
                    return;
                }
                c.this.g();
                c.this.f36650h.setVisibility(0);
                c.this.f36646d.d();
            }
        };
    }

    private void a(int i) {
        this.f36644b.a(this.f36647e, this.f36648f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i);
        this.f36644b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int min = Math.min(ah.h(o()), ah.g(o()));
        if (((d) this).f36747a.f36510e == 1) {
            if (i <= i2) {
                a((int) ((i / (i2 * 1.0f)) * min));
            }
        } else if (i >= i2) {
            c((int) ((i2 / (i * 1.0f)) * min));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f36648f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.f36646d);
        gVar.a(new o(this.j, this.f36648f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void c(int i) {
        this.f36645c.a(this.f36647e, this.f36648f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i);
        this.f36645c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36647e, 1, ((d) this).f36747a.f36513h.getTouchCoords(), ((d) this).f36747a.f36509d);
        ((d) this).f36747a.f36507b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f36646d.b();
        this.f36650h.setVisibility(8);
        this.f36650h.setHttpErrorListener(null);
        r();
        Handler handler = this.f36649g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f36644b.setVisibility(8);
        this.f36645c.setVisibility(8);
    }

    private void h() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f36747a;
        aVar.f34575b = aVar2.f36511f;
        aVar.f34574a = aVar2.f36510e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f36513h;
        aVar.f34576c = adBaseFrameLayout;
        aVar.f34578e = adBaseFrameLayout;
        aVar.f34579f = this.f36650h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String n = com.kwad.sdk.core.response.b.b.n(this.f36647e);
        if (TextUtils.isEmpty(n)) {
            this.r.run();
            return;
        }
        this.f36646d.c();
        this.f36650h.setVisibility(4);
        this.f36650h.loadUrl(n);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        ar.a(this.f36650h);
        g gVar = new g(this.f36650h);
        this.i = gVar;
        a(gVar);
        this.f36650h.addJavascriptInterface(this.i, "KwaiAd");
    }

    private void r() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.a();
            this.i = null;
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36747a;
        this.f36647e = aVar.f36511f;
        this.f36648f = aVar.j;
        this.f36650h.setHttpErrorListener(this.m);
        h();
        p();
        ((d) this).f36747a.n.add(this.o);
        ((d) this).f36747a.i.a(this.n);
        ((d) this).f36747a.n.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36747a.n.remove(this.o);
        f();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        KsAdWebView ksAdWebView = (KsAdWebView) b(R.id.ksad_actionbar_black_style_h5);
        this.f36650h = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f36650h.getBackground().setAlpha(0);
        this.f36644b = (ActionBarLandscapeVertical) b(R.id.ksad_actionbar_landscape_vertical);
        this.f36645c = (ActionBarPortraitHorizontal) b(R.id.ksad_actionbar_portrait_horizontal);
        this.f36646d = new n();
        this.f36649g = new Handler(Looper.getMainLooper());
    }
}
