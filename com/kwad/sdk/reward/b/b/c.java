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
/* loaded from: classes7.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f37094b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f37095c;

    /* renamed from: d  reason: collision with root package name */
    public n f37096d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37097e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37098f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f37099g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f37100h;

    /* renamed from: i  reason: collision with root package name */
    public g f37101i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.f37099g.removeCallbacksAndMessages(null);
            c.this.f37099g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.l(c.this.f37097e) + 200);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i2, String str, String str2) {
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
                cVar.a(((d) cVar).f37201a.f36958i.i(), ((d) c.this).f37201a.f36958i.j());
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
            ((d) c.this).f37201a.f36951b.a();
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
                c.this.f37100h.setVisibility(4);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(((d) cVar).f37201a.f36958i.i(), ((d) c.this).f37201a.f36958i.j());
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
                c.this.f37096d.e();
                c.this.f37100h.setVisibility(4);
                c.this.f37096d.f();
            }
        };
        this.v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i2) {
                com.kwad.sdk.core.d.a.b("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
                c.this.f37099g.removeCallbacksAndMessages(null);
                if (i2 != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    c.this.r.run();
                    return;
                }
                c.this.g();
                c.this.f37100h.setVisibility(0);
                c.this.f37096d.d();
            }
        };
    }

    private void a(int i2) {
        this.f37094b.a(this.f37097e, this.f37098f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f37094b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        int min = Math.min(ah.h(o()), ah.g(o()));
        if (((d) this).f37201a.f36954e == 1) {
            if (i2 <= i3) {
                a((int) ((i2 / (i3 * 1.0f)) * min));
            }
        } else if (i2 >= i3) {
            c((int) ((i3 / (i2 * 1.0f)) * min));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f37098f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.f37096d);
        gVar.a(new o(this.j, this.f37098f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void c(int i2) {
        this.f37095c.a(this.f37097e, this.f37098f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f37095c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f37097e, 1, ((d) this).f37201a.f36957h.getTouchCoords(), ((d) this).f37201a.f36953d);
        ((d) this).f37201a.f36951b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f37096d.b();
        this.f37100h.setVisibility(8);
        this.f37100h.setHttpErrorListener(null);
        r();
        Handler handler = this.f37099g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f37094b.setVisibility(8);
        this.f37095c.setVisibility(8);
    }

    private void h() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f37201a;
        aVar.f34929b = aVar2.f36955f;
        aVar.f34928a = aVar2.f36954e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f36957h;
        aVar.f34930c = adBaseFrameLayout;
        aVar.f34932e = adBaseFrameLayout;
        aVar.f34933f = this.f37100h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String n = com.kwad.sdk.core.response.b.b.n(this.f37097e);
        if (TextUtils.isEmpty(n)) {
            this.r.run();
            return;
        }
        this.f37096d.c();
        this.f37100h.setVisibility(4);
        this.f37100h.loadUrl(n);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        ar.a(this.f37100h);
        g gVar = new g(this.f37100h);
        this.f37101i = gVar;
        a(gVar);
        this.f37100h.addJavascriptInterface(this.f37101i, "KwaiAd");
    }

    private void r() {
        g gVar = this.f37101i;
        if (gVar != null) {
            gVar.a();
            this.f37101i = null;
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        this.f37097e = aVar.f36955f;
        this.f37098f = aVar.j;
        this.f37100h.setHttpErrorListener(this.m);
        h();
        p();
        ((d) this).f37201a.n.add(this.o);
        ((d) this).f37201a.f36958i.a(this.n);
        ((d) this).f37201a.n.add(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37201a.n.remove(this.o);
        f();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        KsAdWebView ksAdWebView = (KsAdWebView) b(R.id.ksad_actionbar_black_style_h5);
        this.f37100h = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f37100h.getBackground().setAlpha(0);
        this.f37094b = (ActionBarLandscapeVertical) b(R.id.ksad_actionbar_landscape_vertical);
        this.f37095c = (ActionBarPortraitHorizontal) b(R.id.ksad_actionbar_portrait_horizontal);
        this.f37096d = new n();
        this.f37099g = new Handler(Looper.getMainLooper());
    }
}
