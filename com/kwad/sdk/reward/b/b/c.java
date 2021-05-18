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
    public ActionBarLandscapeVertical f33711b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f33712c;

    /* renamed from: d  reason: collision with root package name */
    public m f33713d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33714e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33715f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f33716g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f33717h;

    /* renamed from: i  reason: collision with root package name */
    public g f33718i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.f33716g.removeCallbacksAndMessages(null);
            c.this.f33716g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.g(c.this.f33714e) + 200);
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
                c.this.f33717h.setVisibility(4);
                c cVar = c.this;
                cVar.a(((d) cVar).f33839a.f33569i.i(), ((d) c.this).f33839a.f33569i.j());
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
        public void a(a.C0373a c0373a) {
            com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
            ((d) c.this).f33839a.f33562b.a();
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
                c.this.f33717h.setVisibility(4);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(((d) cVar).f33839a.f33569i.i(), ((d) c.this).f33839a.f33569i.j());
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
                c.this.f33713d.e();
                c.this.f33717h.setVisibility(4);
                c.this.f33713d.f();
            }
        };
        this.v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i2) {
                com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
                c.this.f33716g.removeCallbacksAndMessages(null);
                if (i2 != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    c.this.r.run();
                    return;
                }
                c.this.n();
                c.this.f33717h.setVisibility(0);
                c.this.f33713d.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        int min = Math.min(ai.j(l()), ai.i(l()));
        if (((d) this).f33839a.f33565e == 1) {
            if (i2 <= i3) {
                b((int) ((i2 / (i3 * 1.0f)) * min));
            }
        } else if (i2 >= i3) {
            c((int) ((i3 / (i2 * 1.0f)) * min));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f33715f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.f33713d);
        gVar.a(new n(this.j, this.f33715f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void b(int i2) {
        this.f33711b.a(this.f33714e, this.f33715f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f33711b.setVisibility(0);
    }

    private void c(int i2) {
        this.f33712c.a(this.f33714e, this.f33715f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f33712c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f33714e, 1, ((d) this).f33839a.f33568h.getTouchCoords(), ((d) this).f33839a.f33564d);
        ((d) this).f33839a.f33562b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f33713d.b();
        this.f33717h.setVisibility(8);
        this.f33717h.setHttpErrorListener(null);
        r();
        Handler handler = this.f33716g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f33711b.setVisibility(8);
        this.f33712c.setVisibility(8);
    }

    private void o() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f33839a;
        aVar.f32867b = aVar2.f33566f;
        aVar.f32866a = aVar2.f33565e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f33568h;
        aVar.f32868c = adBaseFrameLayout;
        aVar.f32870e = adBaseFrameLayout;
        aVar.f32871f = this.f33717h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String h2 = com.kwad.sdk.core.response.b.b.h(this.f33714e);
        if (TextUtils.isEmpty(h2)) {
            this.r.run();
            return;
        }
        this.f33713d.c();
        this.f33717h.setVisibility(4);
        this.f33717h.loadUrl(h2);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        aq.a(this.f33717h);
        g gVar = new g(this.f33717h);
        this.f33718i = gVar;
        a(gVar);
        this.f33717h.addJavascriptInterface(this.f33718i, "KwaiAd");
    }

    private void r() {
        g gVar = this.f33718i;
        if (gVar != null) {
            gVar.a();
            this.f33718i = null;
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33839a;
        this.f33714e = aVar.f33566f;
        this.f33715f = aVar.j;
        this.f33717h.setHttpErrorListener(this.m);
        o();
        p();
        ((d) this).f33839a.a(this.o);
        ((d) this).f33839a.f33569i.a(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
        this.f33717h = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f33717h.getBackground().setAlpha(0);
        this.f33711b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
        this.f33712c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
        this.f33713d = new m();
        this.f33716g = new Handler(Looper.getMainLooper());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33839a.b(this.o);
        m();
    }
}
