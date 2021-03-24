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
    public ActionBarLandscapeVertical f36354b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f36355c;

    /* renamed from: d  reason: collision with root package name */
    public n f36356d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36357e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36358f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f36359g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f36360h;
    public g i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.f36359g.removeCallbacksAndMessages(null);
            c.this.f36359g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.l(c.this.f36357e) + 200);
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
                cVar.a(((d) cVar).f36457a.i.i(), ((d) c.this).f36457a.i.j());
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
            ((d) c.this).f36457a.f36217b.a();
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
                c.this.f36360h.setVisibility(4);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(((d) cVar).f36457a.i.i(), ((d) c.this).f36457a.i.j());
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
                c.this.f36356d.e();
                c.this.f36360h.setVisibility(4);
                c.this.f36356d.f();
            }
        };
        this.v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i) {
                com.kwad.sdk.core.d.a.b("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
                c.this.f36359g.removeCallbacksAndMessages(null);
                if (i != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    c.this.r.run();
                    return;
                }
                c.this.g();
                c.this.f36360h.setVisibility(0);
                c.this.f36356d.d();
            }
        };
    }

    private void a(int i) {
        this.f36354b.a(this.f36357e, this.f36358f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i);
        this.f36354b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int min = Math.min(ah.h(o()), ah.g(o()));
        if (((d) this).f36457a.f36220e == 1) {
            if (i <= i2) {
                a((int) ((i / (i2 * 1.0f)) * min));
            }
        } else if (i >= i2) {
            c((int) ((i2 / (i * 1.0f)) * min));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f36358f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.f36356d);
        gVar.a(new o(this.j, this.f36358f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void c(int i) {
        this.f36355c.a(this.f36357e, this.f36358f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i);
        this.f36355c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36357e, 1, ((d) this).f36457a.f36223h.getTouchCoords(), ((d) this).f36457a.f36219d);
        ((d) this).f36457a.f36217b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f36356d.b();
        this.f36360h.setVisibility(8);
        this.f36360h.setHttpErrorListener(null);
        r();
        Handler handler = this.f36359g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f36354b.setVisibility(8);
        this.f36355c.setVisibility(8);
    }

    private void h() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f36457a;
        aVar.f34285b = aVar2.f36221f;
        aVar.f34284a = aVar2.f36220e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f36223h;
        aVar.f34286c = adBaseFrameLayout;
        aVar.f34288e = adBaseFrameLayout;
        aVar.f34289f = this.f36360h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String n = com.kwad.sdk.core.response.b.b.n(this.f36357e);
        if (TextUtils.isEmpty(n)) {
            this.r.run();
            return;
        }
        this.f36356d.c();
        this.f36360h.setVisibility(4);
        this.f36360h.loadUrl(n);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        ar.a(this.f36360h);
        g gVar = new g(this.f36360h);
        this.i = gVar;
        a(gVar);
        this.f36360h.addJavascriptInterface(this.i, "KwaiAd");
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
        com.kwad.sdk.reward.a aVar = ((d) this).f36457a;
        this.f36357e = aVar.f36221f;
        this.f36358f = aVar.j;
        this.f36360h.setHttpErrorListener(this.m);
        h();
        p();
        ((d) this).f36457a.n.add(this.o);
        ((d) this).f36457a.i.a(this.n);
        ((d) this).f36457a.n.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36457a.n.remove(this.o);
        f();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        KsAdWebView ksAdWebView = (KsAdWebView) b(R.id.ksad_actionbar_black_style_h5);
        this.f36360h = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f36360h.getBackground().setAlpha(0);
        this.f36354b = (ActionBarLandscapeVertical) b(R.id.ksad_actionbar_landscape_vertical);
        this.f36355c = (ActionBarPortraitHorizontal) b(R.id.ksad_actionbar_portrait_horizontal);
        this.f36356d = new n();
        this.f36359g = new Handler(Looper.getMainLooper());
    }
}
