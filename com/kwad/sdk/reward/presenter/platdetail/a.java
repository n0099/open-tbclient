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
/* loaded from: classes8.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f56077b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f56078c;

    /* renamed from: d  reason: collision with root package name */
    public s f56079d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56080e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56081f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56082g;

    /* renamed from: h  reason: collision with root package name */
    public long f56083h;

    /* renamed from: i  reason: collision with root package name */
    public KsAdWebView f56084i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f56085j;
    public com.kwad.sdk.core.webview.a k;
    public boolean l;
    public boolean m;
    public KsAdWebView.d n = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            a.this.f56082g.removeCallbacksAndMessages(null);
            a.this.f56082g.postDelayed(a.this.t, a.this.f56083h);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i2, String str, String str2) {
            a.this.f56082g.removeCallbacksAndMessages(null);
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
                a.this.f56084i.setVisibility(4);
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
            ((g) a.this).a.f55764b.a();
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
                a.this.f56084i.setVisibility(4);
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
            public void a(int i2) {
                a.this.f56079d.e();
                a.this.f56084i.setVisibility(4);
                a.this.f56079d.f();
            }
        };
        this.w = new p.b() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.2
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - a.this.r));
                a.this.f56082g.removeCallbacksAndMessages(null);
                if (aVar.a != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    a.this.s.run();
                    return;
                }
                a.this.i();
                a.this.f56084i.setVisibility(0);
                a.this.f56079d.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        int min = Math.min(av.o(q()), av.n(q()));
        if (((g) this).a.f55768f == 1) {
            if (i2 <= i3) {
                b((int) ((i2 / (i3 * 1.0f)) * min));
            }
        } else if (i2 >= i3) {
            c((int) ((i3 / (i2 * 1.0f)) * min));
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.k, this.f56081f, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f56081f, this.q));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.k));
        gVar.a(new j(this.k, this.u));
        gVar.a(new p(this.w));
        gVar.a(this.f56079d);
        gVar.a(new t(this.k, this.f56081f));
        gVar.a(new i(this.v));
        gVar.a(new k(this.k));
    }

    private void b(int i2) {
        this.f56077b.a(this.f56080e, this.f56081f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a(boolean z) {
                a.this.b(z);
            }
        }, i2);
        this.f56077b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.core.report.a.a(this.f56080e, z ? 1 : 153, ((g) this).a.f55772j.getTouchCoords(), ((g) this).a.f55767e);
        ((g) this).a.f55764b.a();
    }

    private void c(int i2) {
        this.f56078c.a(this.f56080e, this.f56081f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.presenter.platdetail.a.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a(boolean z) {
                a.this.b(z);
            }
        }, i2);
        this.f56078c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f56079d.b();
        this.f56084i.setVisibility(8);
        this.f56084i.setHttpErrorListener(null);
        u();
        Handler handler = this.f56082g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f56077b.setVisibility(8);
        this.f56078c.setVisibility(8);
    }

    private void r() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.k = aVar;
        aVar.a(((g) this).a.f55769g);
        com.kwad.sdk.core.webview.a aVar2 = this.k;
        com.kwad.sdk.reward.a aVar3 = ((g) this).a;
        aVar2.a = aVar3.f55768f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f55772j;
        aVar2.f54889b = adBaseFrameLayout;
        aVar2.f54891d = adBaseFrameLayout;
        aVar2.f54892e = this.f56084i;
    }

    private void s() {
        t();
        this.r = System.currentTimeMillis();
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.e(this.f56080e))) {
            this.s.run();
            return;
        }
        this.f56079d.c();
        this.f56084i.setVisibility(4);
        this.f56084i.loadUrl(com.kwad.sdk.core.response.a.b.e(this.f56080e));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void t() {
        u();
        be.a(this.f56084i);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f56084i);
        this.f56085j = gVar;
        a(gVar);
        this.f56084i.addJavascriptInterface(this.f56085j, "KwaiAd");
    }

    private void u() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f56085j;
        if (gVar != null) {
            gVar.a();
            this.f56085j = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f55769g;
        this.f56080e = adTemplate;
        this.f56081f = aVar.l;
        long f2 = com.kwad.sdk.core.response.a.b.f(adTemplate);
        if (f2 <= 0) {
            f2 = 1000;
        }
        this.f56083h = f2;
        this.f56084i.setHttpErrorListener(this.n);
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
        KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
        this.f56084i = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f56084i.getBackground().setAlpha(0);
        this.f56077b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
        this.f56078c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
        this.f56079d = new s();
        this.f56082g = new Handler(Looper.getMainLooper());
    }
}
