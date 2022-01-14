package com.kwad.sdk.core.download.kwai;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import java.io.File;
/* loaded from: classes3.dex */
public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f55806b;

    /* renamed from: c  reason: collision with root package name */
    public j.a f55807c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f55808d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55809e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f55810f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f55811g;

    /* renamed from: h  reason: collision with root package name */
    public s f55812h;

    /* renamed from: i  reason: collision with root package name */
    public String f55813i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f55814j;
    public boolean k = false;
    public b.c l = new b.c() { // from class: com.kwad.sdk.core.download.kwai.f.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + f.this.k);
            f.this.k = true;
        }
    };
    public j.b m = new j.b() { // from class: com.kwad.sdk.core.download.kwai.f.4
        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(j.a aVar) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            f.this.f55807c = aVar;
            f.this.f55806b.setTranslationY((float) (aVar.a + aVar.f56403d));
        }
    };
    public i.b n = new i.b() { // from class: com.kwad.sdk.core.download.kwai.f.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i2) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            f.this.v();
        }
    };
    public p.b o = new p.b() { // from class: com.kwad.sdk.core.download.kwai.f.6
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            com.kwad.sdk.core.d.a.c("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.a == 1) {
                f.this.u();
                return;
            }
            f.this.v();
            if (f.this.q() != null) {
                u.a(f.this.q(), v.a(f.this.q()));
            }
        }
    };

    public f(String str) {
        this.f55813i = str;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f55811g, this.f55809e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f55811g, this.f55809e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f55811g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f55811g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f55811g));
        gVar.a(new j(this.f55811g, this.m));
        gVar.a(new p(this.o));
        s sVar = new s();
        this.f55812h = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.f55811g, this.f55809e));
        gVar.a(new i(this.n));
        gVar.a(new k(this.f55811g));
    }

    private void e() {
        this.f55806b.setVisibility(8);
        this.f55806b.a();
        t();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f55811g = aVar;
        aVar.a(((c) this).a.f55804d);
        com.kwad.sdk.core.webview.a aVar2 = this.f55811g;
        d dVar = ((c) this).a;
        aVar2.a = dVar.a;
        AdBaseFrameLayout adBaseFrameLayout = dVar.f55803c;
        aVar2.f56327b = adBaseFrameLayout;
        aVar2.f56329d = adBaseFrameLayout;
        aVar2.f56330e = this.f55806b;
    }

    private void g() {
        i();
        this.f55806b.postDelayed(h(), 1500L);
        this.f55806b.setBackgroundColor(0);
        this.f55806b.getBackground().setAlpha(0);
        this.f55806b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f55808d.windowPopUrl);
    }

    private Runnable h() {
        Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.download.kwai.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.v();
                if (f.this.q() != null) {
                    u.a(f.this.q(), v.a(f.this.q()));
                }
            }
        };
        this.f55814j = runnable;
        return runnable;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        t();
        be.b(this.f55806b);
        this.f55806b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.kwai.f.3
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f55806b);
        this.f55810f = gVar;
        a(gVar);
        this.f55806b.addJavascriptInterface(this.f55810f, "KwaiAd");
        String r = r();
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getUrl: " + r);
        this.f55806b.loadUrl(r);
    }

    private String r() {
        if (TextUtils.isEmpty(this.f55813i)) {
            String s = s();
            return TextUtils.isEmpty(s) ? this.f55808d.windowPopUrl : s;
        }
        return this.f55813i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String s() {
        String str;
        StringBuilder sb;
        String str2;
        if (q() != null) {
            File c2 = com.kwad.sdk.core.config.b.c(q());
            if (c2.exists()) {
                str = Uri.fromFile(c2).toString();
                sb = new StringBuilder();
                str2 = "getPreloadUrl preloadUrl ";
            } else if (com.kwad.sdk.core.config.b.c() != null) {
                str = com.kwad.sdk.core.config.b.c().h5Url;
                sb = new StringBuilder();
                str2 = "getPreloadUrl getDownloadPopWindowConfig ";
            }
            sb.append(str2);
            sb.append(str);
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", sb.toString());
            return str != null ? "" : str;
        }
        str = null;
        if (str != null) {
        }
    }

    private void t() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f55810f;
        if (gVar != null) {
            gVar.a();
            this.f55810f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Runnable runnable = this.f55814j;
        if (runnable != null) {
            this.f55806b.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.k);
        if (this.f55806b.getVisibility() != 0) {
            return;
        }
        s sVar = this.f55812h;
        if (sVar != null) {
            sVar.e();
        }
        this.f55806b.setVisibility(4);
        s sVar2 = this.f55812h;
        if (sVar2 != null) {
            sVar2.f();
        }
        e eVar = ((c) this).a.f55802b;
        if (eVar != null) {
            eVar.a(this.k);
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55808d = com.kwad.sdk.core.response.a.a.ac(com.kwad.sdk.core.response.a.d.j(((c) this).a.f55804d));
        this.f55809e = ((c) this).a.f55805e;
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
        u();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55806b = (KsAdWebView) a(R.id.ksad_download_tips_web_card_webView);
    }
}
