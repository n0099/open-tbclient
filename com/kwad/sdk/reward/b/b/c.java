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
    public ActionBarLandscapeVertical f33640b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarPortraitHorizontal f33641c;

    /* renamed from: d  reason: collision with root package name */
    public m f33642d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33643e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33644f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f33645g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdWebView f33646h;

    /* renamed from: i  reason: collision with root package name */
    public g f33647i;
    public com.kwad.sdk.core.webview.a j;
    public boolean k;
    public boolean l;
    public KsAdWebView.d m = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.b.b.c.1
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
            c.this.f33645g.removeCallbacksAndMessages(null);
            c.this.f33645g.postDelayed(c.this.s, com.kwad.sdk.core.response.b.b.g(c.this.f33643e) + 200);
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
                c.this.f33646h.setVisibility(4);
                c cVar = c.this;
                cVar.a(((d) cVar).f33768a.f33498i.i(), ((d) c.this).f33768a.f33498i.j());
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
        public void a(a.C0374a c0374a) {
            com.kwad.sdk.core.d.a.a("NewStylePresenter", "onAdClicked");
            ((d) c.this).f33768a.f33491b.a();
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
                c.this.f33646h.setVisibility(4);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(((d) cVar).f33768a.f33498i.i(), ((d) c.this).f33768a.f33498i.j());
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
                c.this.f33642d.e();
                c.this.f33646h.setVisibility(4);
                c.this.f33642d.f();
            }
        };
        this.v = new k.b() { // from class: com.kwad.sdk.reward.b.b.c.2
            @Override // com.kwad.sdk.core.webview.jshandler.k.b
            public void a(int i2) {
                com.kwad.sdk.core.d.a.c("NewStylePresenter", "load time:" + (System.currentTimeMillis() - c.this.q));
                c.this.f33645g.removeCallbacksAndMessages(null);
                if (i2 != 1) {
                    com.kwad.sdk.core.d.a.a("NewStylePresenter", "show webCard fail, reason: timeout");
                    c.this.r.run();
                    return;
                }
                c.this.n();
                c.this.f33646h.setVisibility(0);
                c.this.f33642d.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        int min = Math.min(ai.j(l()), ai.i(l()));
        if (((d) this).f33768a.f33494e == 1) {
            if (i2 <= i3) {
                b((int) ((i2 / (i3 * 1.0f)) * min));
            }
        } else if (i2 >= i3) {
            c((int) ((i3 / (i2 * 1.0f)) * min));
        }
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.j, this.f33644f, this.p));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.j));
        gVar.a(new i(this.j, this.t));
        gVar.a(new k(this.v));
        gVar.a(this.f33642d);
        gVar.a(new n(this.j, this.f33644f));
        gVar.a(new h(this.u));
        gVar.a(new j(this.j));
    }

    private void b(int i2) {
        this.f33640b.a(this.f33643e, this.f33644f, new ActionBarLandscapeVertical.a() { // from class: com.kwad.sdk.reward.b.b.c.5
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f33640b.setVisibility(0);
    }

    private void c(int i2) {
        this.f33641c.a(this.f33643e, this.f33644f, new ActionBarPortraitHorizontal.a() { // from class: com.kwad.sdk.reward.b.b.c.6
            @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.a
            public void a() {
                c.this.e();
            }
        }, i2);
        this.f33641c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f33643e, 1, ((d) this).f33768a.f33497h.getTouchCoords(), ((d) this).f33768a.f33493d);
        ((d) this).f33768a.f33491b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f33642d.b();
        this.f33646h.setVisibility(8);
        this.f33646h.setHttpErrorListener(null);
        r();
        Handler handler = this.f33645g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f33640b.setVisibility(8);
        this.f33641c.setVisibility(8);
    }

    private void o() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.j = aVar;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f33768a;
        aVar.f32796b = aVar2.f33495f;
        aVar.f32795a = aVar2.f33494e;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f33497h;
        aVar.f32797c = adBaseFrameLayout;
        aVar.f32799e = adBaseFrameLayout;
        aVar.f32800f = this.f33646h;
    }

    private void p() {
        q();
        this.q = System.currentTimeMillis();
        String h2 = com.kwad.sdk.core.response.b.b.h(this.f33643e);
        if (TextUtils.isEmpty(h2)) {
            this.r.run();
            return;
        }
        this.f33642d.c();
        this.f33646h.setVisibility(4);
        this.f33646h.loadUrl(h2);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void q() {
        r();
        aq.a(this.f33646h);
        g gVar = new g(this.f33646h);
        this.f33647i = gVar;
        a(gVar);
        this.f33646h.addJavascriptInterface(this.f33647i, "KwaiAd");
    }

    private void r() {
        g gVar = this.f33647i;
        if (gVar != null) {
            gVar.a();
            this.f33647i = null;
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        this.f33643e = aVar.f33495f;
        this.f33644f = aVar.j;
        this.f33646h.setHttpErrorListener(this.m);
        o();
        p();
        ((d) this).f33768a.a(this.o);
        ((d) this).f33768a.f33498i.a(this.n);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        KsAdWebView ksAdWebView = (KsAdWebView) a(R.id.ksad_actionbar_black_style_h5);
        this.f33646h = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f33646h.getBackground().setAlpha(0);
        this.f33640b = (ActionBarLandscapeVertical) a(R.id.ksad_actionbar_landscape_vertical);
        this.f33641c = (ActionBarPortraitHorizontal) a(R.id.ksad_actionbar_portrait_horizontal);
        this.f33642d = new m();
        this.f33645g = new Handler(Looper.getMainLooper());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33768a.b(this.o);
        m();
    }
}
