package com.kwad.sdk.reward.b.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical;
import com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aq;
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public ActionBarLandscapeVertical f34466b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f34467c;

    /* renamed from: d  reason: collision with root package name */
    public m f34468d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34469e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34470f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f34471g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f34472h;

    /* renamed from: i  reason: collision with root package name */
    public g f34473i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.f34471g.removeCallbacksAndMessages(null);
            c.this.f34471g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.g(c.this.f34469e) + 200);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i2, String str, String str2) {
            c.this.v.a(-1);
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void b() {
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d n = new e() { // from class: com.kwad.sdk.reward.b.b.c.3
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            if (c.this.l) {
                c.this.f34472h.setVisibility(4);
                c cVar = c.this;
                cVar.a(((d) cVar).f34594a.f34324i.i(), ((d) c.this).f34594a.f34324i.j());
            }
            c.this.k = true;
        }
    };
    public f o = new f() { // from class: com.kwad.sdk.reward.b.b.c.4
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.k = false;
            c.this.m();
            if (c.this.l) {
                c.this.n();
            }
        }
    };
    public a.b p = new a.b() { // from class: com.kwad.sdk.reward.b.b.c.7
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0386a c0386a) {
            com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
            ((d) c.this).f34594a.f34317b.a();
        }
    };
    public long q;
    public Runnable r;
    public ap s;
    public i.b t;
    public h.a u;
    public k.b v;

    public c() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.reward.b.b.c.8
            @Override // java.lang.Runnable
            public void run() {
                c.this.l = true;
                c.this.f34472h.setVisibility(4);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(((d) cVar).f34594a.f34324i.i(), ((d) c.this).f34594a.f34324i.j());
                }
            }
        };
        this.r = runnable;
        this.s = new ap(runnable);
        this.t = new i.b() { // from class: com.kwad.sdk.reward.b.b.c.9
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(i.a aVar) {
            }
        };
        this.u = new h.a() { // from class: com.kwad.sdk.reward.b.b.c.10
            @Override // com.kwad.sdk.core.webview.jshandler.h.a
            public void a() {
                c.this.f34468d.e();
                c.this.f34472h.setVisibility(4);
                c.this.f34468d.f();
            }
        };
        this.v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i2) {
                com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
                c.this.f34471g.removeCallbacksAndMessages(null);
                if (i2 != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    c.this.r.run();
                    return;
                }
                c.this.n();
                c.this.f34472h.setVisibility(0);
                c.this.f34468d.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        int min = Math.min(ai.j(l()), ai.i(l()));
        if (((d) this).f34594a.f34320e == 1) {
            if (i2 <= i3) {
                b((int) ((i2 / (i3 * 1.0f)) * min));
            }
        } else if (i2 >= i3) {
            c((int) ((i3 / (i2 * 1.0f)) * min));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f34470f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.f34468d);
        gVar.a(new n(this.j, this.f34470f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void b(int i2) {
        this.f34466b.a(this.f34469e, this.f34470f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f34466b.setVisibility(0);
    }

    private void c(int i2) {
        this.f34467c.a(this.f34469e, this.f34470f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f34467c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f34469e, 1, ((d) this).f34594a.f34323h.getTouchCoords(), ((d) this).f34594a.f34319d);
        ((d) this).f34594a.f34317b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f34468d.b();
        this.f34472h.setVisibility(8);
        this.f34472h.setHttpErrorListener(null);
        r();
        Handler handler = this.f34471g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f34466b.setVisibility(8);
        this.f34467c.setVisibility(8);
    }

    private void o() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f34594a;
        aVar.f33622b = aVar2.f34321f;
        aVar.f33621a = aVar2.f34320e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f34323h;
        aVar.f33623c = adBaseFrameLayout;
        aVar.f33625e = adBaseFrameLayout;
        aVar.f33626f = this.f34472h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String h2 = com.kwad.sdk.core.response.b.b.h(this.f34469e);
        if (TextUtils.isEmpty(h2)) {
            this.r.run();
            return;
        }
        this.f34468d.c();
        this.f34472h.setVisibility(4);
        this.f34472h.loadUrl(h2);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        aq.a(this.f34472h);
        g gVar = new g(this.f34472h);
        this.f34473i = gVar;
        a(gVar);
        this.f34472h.addJavascriptInterface(this.f34473i, "KwaiAd");
    }

    private void r() {
        g gVar = this.f34473i;
        if (gVar != null) {
            gVar.a();
            this.f34473i = null;
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        this.f34469e = aVar.f34321f;
        this.f34470f = aVar.j;
        this.f34472h.setHttpErrorListener(this.m);
        o();
        p();
        ((d) this).f34594a.a(this.o);
        ((d) this).f34594a.f34324i.a(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
        this.f34472h = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f34472h.getBackground().setAlpha(0);
        this.f34466b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
        this.f34467c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
        this.f34468d = new m();
        this.f34471g = new Handler(Looper.getMainLooper());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f34594a.b(this.o);
        m();
    }
}
