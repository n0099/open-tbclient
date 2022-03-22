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
/* loaded from: classes7.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f41023b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f41024c;

    /* renamed from: d  reason: collision with root package name */
    public s f41025d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f41026e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f41027f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f41028g;

    /* renamed from: h  reason: collision with root package name */
    public long f41029h;
    public KsAdWebView i;
    public com.kwad.sdk.core.webview.kwai.g j;
    public com.kwad.sdk.core.webview.a k;
    public boolean l;
    public boolean m;
    public KsAdWebView.d n = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            a.this.f41028g.removeCallbacksAndMessages(null);
            a.this.f41028g.postDelayed(a.this.t, a.this.f41029h);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i, String str, String str2) {
            a.this.f41028g.removeCallbacksAndMessages(null);
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
            ((g) a.this).a.f40742b.a();
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
                a.this.f41025d.e();
                a.this.i.setVisibility(4);
                a.this.f41025d.f();
            }
        };
        this.w = new p.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.2
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - a.this.r));
                a.this.f41028g.removeCallbacksAndMessages(null);
                if (aVar.a != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    a.this.s.run();
                    return;
                }
                a.this.i();
                a.this.i.setVisibility(0);
                a.this.f41025d.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        int min = Math.min(av.o(q()), av.n(q()));
        if (((g) this).a.f40746f == 1) {
            if (i <= i2) {
                b((int) ((i / (i2 * 1.0f)) * min));
            }
        } else if (i >= i2) {
            c((int) ((i2 / (i * 1.0f)) * min));
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.k, this.f41027f, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f41027f, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.k));
        gVar.a(new j(this.k, this.u));
        gVar.a(new p(this.w));
        gVar.a(this.f41025d);
        gVar.a(new t(this.k, this.f41027f));
        gVar.a(new i(this.v));
        gVar.a(new k(this.k));
    }

    private void b(int i) {
        this.f41023b.a(this.f41026e, this.f41027f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a(boolean z) {
                a.this.b(z);
            }
        }, i);
        this.f41023b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f41026e, z ? 1 : 153, ((g) this).a.j.getTouchCoords(), ((g) this).a.f40745e);
        ((g) this).a.f40742b.a();
    }

    private void c(int i) {
        this.f41024c.a(this.f41026e, this.f41027f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a(boolean z) {
                a.this.b(z);
            }
        }, i);
        this.f41024c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f41025d.b();
        this.i.setVisibility(8);
        this.i.setHttpErrorListener(null);
        u();
        Handler handler = this.f41028g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f41023b.setVisibility(8);
        this.f41024c.setVisibility(8);
    }

    private void r() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.k = aVar;
        aVar.a(((g) this).a.f40747g);
        com.kwad.sdk.core.webview.a aVar2 = this.k;
        com.kwad.sdk.reward.a aVar3 = ((g) this).a;
        aVar2.a = aVar3.f40746f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.j;
        aVar2.f39981b = adBaseFrameLayout;
        aVar2.f39983d = adBaseFrameLayout;
        aVar2.f39984e = this.i;
    }

    private void s() {
        t();
        this.r = System.currentTimeMillis();
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.e(this.f41026e))) {
            this.s.run();
            return;
        }
        this.f41025d.c();
        this.i.setVisibility(4);
        this.i.loadUrl(com.kwad.sdk.core.response.a.b.e(this.f41026e));
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
        AdTemplate adTemplate = aVar.f40747g;
        this.f41026e = adTemplate;
        this.f41027f = aVar.l;
        long f2 = com.kwad.sdk.core.response.a.b.f(adTemplate);
        if (f2 <= 0) {
            f2 = 1000;
        }
        this.f41029h = f2;
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
        KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.obfuscated_res_0x7f09100b);
        this.i = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.i.getBackground().setAlpha(0);
        this.f41023b = (ActionBarLandscapeVertical) a(R.id.obfuscated_res_0x7f09100c);
        this.f41024c = (ActionBarPortraitHorizontal) a(R.id.obfuscated_res_0x7f09100e);
        this.f41025d = new s();
        this.f41028g = new Handler(Looper.getMainLooper());
    }
}
