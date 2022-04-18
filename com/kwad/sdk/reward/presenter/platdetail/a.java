package com.kwad.sdk.reward.presenter.platdetail;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.be;
/* loaded from: classes5.dex */
public class a extends g {
    public ActionBarLandscapeVertical b;
    public ActionBarPortraitHorizontal c;
    public s d;
    public AdTemplate e;
    public com.kwad.sdk.core.download.a.b f;
    public Handler g;
    public long h;
    public KsAdWebView i;
    public com.kwad.sdk.core.webview.kwai.g j;
    public com.kwad.sdk.core.webview.a k;
    public boolean l;
    public boolean m;
    public KsAdWebView.d n = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            a.this.g.removeCallbacksAndMessages(null);
            a.this.g.postDelayed(a.this.t, a.this.h);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i, String str, String str2) {
            a.this.g.removeCallbacksAndMessages(null);
            a.this.s.run();
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void b() {
        }
    };
    public d o = new e() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.3
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            if (a.this.m) {
                a.this.i.setVisibility(4);
                a aVar = a.this;
                aVar.a(((g) aVar).a.k.f(), ((g) a.this).a.k.g());
            }
            a.this.l = true;
        }
    };
    public f p = new f() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.4
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            a.this.l = false;
            a.this.e();
            if (a.this.m) {
                a.this.i();
            }
        }
    };
    public b.c q = new b.c() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.7
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
            ((g) a.this).a.b.a();
        }
    };
    public long r;
    public Runnable s;
    public bd t;
    public j.b u;
    public i.b v;
    public p.b w;

    public a() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.m = true;
                a.this.i.setVisibility(4);
                if (a.this.l) {
                    a aVar = a.this;
                    aVar.a(((g) aVar).a.k.f(), ((g) a.this).a.k.g());
                }
            }
        };
        this.s = runnable;
        this.t = new bd(runnable);
        this.u = new j.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.9
            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
            }
        };
        this.v = new i.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.10
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(int i) {
                a.this.d.e();
                a.this.i.setVisibility(4);
                a.this.d.f();
            }
        };
        this.w = new p.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.2
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - a.this.r));
                a.this.g.removeCallbacksAndMessages(null);
                if (aVar.a != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    a.this.s.run();
                    return;
                }
                a.this.i();
                a.this.i.setVisibility(0);
                a.this.d.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int min = Math.min(av.o(q()), av.n(q()));
        if (((g) this).a.f == 1) {
            if (i <= i2) {
                b((int) ((i / (i2 * 1.0f)) * min));
            }
        } else if (i >= i2) {
            c((int) ((i2 / (i * 1.0f)) * min));
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.k, this.f, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.k));
        gVar.a(new j(this.k, this.u));
        gVar.a(new p(this.w));
        gVar.a(this.d);
        gVar.a(new t(this.k, this.f));
        gVar.a(new i(this.v));
        gVar.a(new k(this.k));
    }

    private void b(int i) {
        this.b.a(this.e, this.f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a(boolean z) {
                a.this.b(z);
            }
        }, i);
        this.b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.e, z ? 1 : 153, ((g) this).a.j.getTouchCoords(), ((g) this).a.e);
        ((g) this).a.b.a();
    }

    private void c(int i) {
        this.c.a(this.e, this.f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a(boolean z) {
                a.this.b(z);
            }
        }, i);
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.d.b();
        this.i.setVisibility(8);
        this.i.setHttpErrorListener(null);
        u();
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    private void r() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.k = aVar;
        aVar.a(((g) this).a.g);
        com.kwad.sdk.core.webview.a aVar2 = this.k;
        com.kwad.sdk.reward.a aVar3 = ((g) this).a;
        aVar2.a = aVar3.f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.j;
        aVar2.b = adBaseFrameLayout;
        aVar2.d = adBaseFrameLayout;
        aVar2.e = this.i;
    }

    private void s() {
        t();
        this.r = System.currentTimeMillis();
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.e(this.e))) {
            this.s.run();
            return;
        }
        this.d.c();
        this.i.setVisibility(4);
        this.i.loadUrl(com.kwad.sdk.core.response.a.b.e(this.e));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void t() {
        u();
        be.a(this.i);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.i);
        this.j = gVar;
        a(gVar);
        this.i.addJavascriptInterface(this.j, "KwaiAd");
    }

    private void u() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.j;
        if (gVar != null) {
            gVar.a();
            this.j = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.g;
        this.e = adTemplate;
        this.f = aVar.l;
        long f = com.kwad.sdk.core.response.a.b.f(adTemplate);
        if (f <= 0) {
            f = 1000;
        }
        this.h = f;
        this.i.setHttpErrorListener(this.n);
        r();
        s();
        ((g) this).a.a(this.p);
        ((g) this).a.k.a(this.o);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.p);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.obfuscated_res_0x7f091005);
        this.i = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.i.getBackground().setAlpha(0);
        this.b = (ActionBarLandscapeVertical) a(R.id.obfuscated_res_0x7f091006);
        this.c = (ActionBarPortraitHorizontal) a(R.id.obfuscated_res_0x7f091008);
        this.d = new s();
        this.g = new Handler(Looper.getMainLooper());
    }
}
