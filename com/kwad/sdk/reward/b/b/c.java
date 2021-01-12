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
/* loaded from: classes4.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    private ActionBarLandscapeVertical f10592b;
    private ActionBarPortraitHorizontal c;
    private n d;
    private AdTemplate e;
    private com.kwad.sdk.core.download.b.b f;
    private Handler g;
    private KsAdWebView h;
    private g i;
    private com.kwad.sdk.core.webview.a j;
    private boolean k;
    private boolean l;
    private long q;
    private KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.g.removeCallbacksAndMessages(null);
            c.this.g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.l(c.this.e) + 200);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i, String str, String str2) {
            c.this.v.a(-1);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void b() {
        }
    };
    private e n = new f() { // from class: com.kwad.sdk.reward.b.b.c.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            if (c.this.l) {
                c.this.a(c.this.f10650a.i.i(), c.this.f10650a.i.j());
            }
            c.this.k = true;
        }
    };
    private com.kwad.sdk.reward.a.e o = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.b.c.4
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            c.this.k = false;
            c.this.f();
            if (c.this.l) {
                c.this.g();
            }
        }
    };
    private a.b p = new a.b() { // from class: com.kwad.sdk.reward.b.b.c.7
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
            c.this.f10650a.f10525b.a();
        }
    };
    private Runnable r = new Runnable() { // from class: com.kwad.sdk.reward.b.b.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.l = true;
            c.this.h.setVisibility(4);
            if (c.this.k) {
                c.this.a(c.this.f10650a.i.i(), c.this.f10650a.i.j());
            }
        }
    };
    private aq s = new aq(this.r);
    private i.b t = new i.b() { // from class: com.kwad.sdk.reward.b.b.c.9
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
        }
    };
    private h.a u = new h.a() { // from class: com.kwad.sdk.reward.b.b.c.10
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.d.e();
            c.this.h.setVisibility(4);
            c.this.d.f();
        }
    };
    private k.b v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            com.kwad.sdk.core.d.a.b("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
            c.this.g.removeCallbacksAndMessages(null);
            if (i != 1) {
                com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                c.this.r.run();
                return;
            }
            c.this.g();
            c.this.h.setVisibility(0);
            c.this.d.d();
        }
    };

    private void a(int i) {
        this.f10592b.a(this.e, this.f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i);
        this.f10592b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int min = Math.min(ah.h(o()), ah.g(o()));
        if (this.f10650a.e == 1) {
            if (i <= i2) {
                a((int) (min * (i / (i2 * 1.0f))));
            }
        } else if (i >= i2) {
            c((int) (min * (i2 / (i * 1.0f))));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.d);
        gVar.a(new o(this.j, this.f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void c(int i) {
        this.c.a(this.e, this.f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i);
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.e, 1, this.f10650a.h.getTouchCoords(), this.f10650a.d);
        this.f10650a.f10525b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d.b();
        this.h.setVisibility(8);
        this.h.setHttpErrorListener(null);
        r();
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f10592b.setVisibility(8);
        this.c.setVisibility(8);
    }

    private void h() {
        this.j = new com.kwad.sdk.core.webview.a();
        this.j.f9537b = this.f10650a.f;
        this.j.f9536a = this.f10650a.e;
        this.j.c = this.f10650a.h;
        this.j.e = this.f10650a.h;
        this.j.f = this.h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String n = com.kwad.sdk.core.response.b.b.n(this.e);
        if (TextUtils.isEmpty(n)) {
            this.r.run();
            return;
        }
        this.d.c();
        this.h.setVisibility(4);
        this.h.loadUrl(n);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        ar.a(this.h);
        this.i = new g(this.h);
        a(this.i);
        this.h.addJavascriptInterface(this.i, "KwaiAd");
    }

    private void r() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f10650a.f;
        this.f = this.f10650a.j;
        this.h.setHttpErrorListener(this.m);
        h();
        p();
        this.f10650a.n.add(this.o);
        this.f10650a.i.a(this.n);
        this.f10650a.n.add(this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10650a.n.remove(this.o);
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.h = (KsAdWebView) b(R.id.ksad_actionbar_black_style_h5);
        this.h.setBackgroundColor(0);
        this.h.getBackground().setAlpha(0);
        this.f10592b = (ActionBarLandscapeVertical) b(R.id.ksad_actionbar_landscape_vertical);
        this.c = (ActionBarPortraitHorizontal) b(R.id.ksad_actionbar_portrait_horizontal);
        this.d = new n();
        this.g = new Handler(Looper.getMainLooper());
    }
}
