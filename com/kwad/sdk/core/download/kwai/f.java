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
/* loaded from: classes4.dex */
public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f56018b;

    /* renamed from: c  reason: collision with root package name */
    public j.a f56019c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f56020d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56021e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f56022f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f56023g;

    /* renamed from: h  reason: collision with root package name */
    public s f56024h;

    /* renamed from: i  reason: collision with root package name */
    public String f56025i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f56026j;
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
            f.this.f56019c = aVar;
            f.this.f56018b.setTranslationY((float) (aVar.a + aVar.f56615d));
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
        this.f56025i = str;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f56023g, this.f56021e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f56023g, this.f56021e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f56023g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f56023g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f56023g));
        gVar.a(new j(this.f56023g, this.m));
        gVar.a(new p(this.o));
        s sVar = new s();
        this.f56024h = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.f56023g, this.f56021e));
        gVar.a(new i(this.n));
        gVar.a(new k(this.f56023g));
    }

    private void e() {
        this.f56018b.setVisibility(8);
        this.f56018b.a();
        t();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f56023g = aVar;
        aVar.a(((c) this).a.f56016d);
        com.kwad.sdk.core.webview.a aVar2 = this.f56023g;
        d dVar = ((c) this).a;
        aVar2.a = dVar.a;
        AdBaseFrameLayout adBaseFrameLayout = dVar.f56015c;
        aVar2.f56539b = adBaseFrameLayout;
        aVar2.f56541d = adBaseFrameLayout;
        aVar2.f56542e = this.f56018b;
    }

    private void g() {
        i();
        this.f56018b.postDelayed(h(), 1500L);
        this.f56018b.setBackgroundColor(0);
        this.f56018b.getBackground().setAlpha(0);
        this.f56018b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f56020d.windowPopUrl);
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
        this.f56026j = runnable;
        return runnable;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        t();
        be.b(this.f56018b);
        this.f56018b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.kwai.f.3
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
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f56018b);
        this.f56022f = gVar;
        a(gVar);
        this.f56018b.addJavascriptInterface(this.f56022f, "KwaiAd");
        String r = r();
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getUrl: " + r);
        this.f56018b.loadUrl(r);
    }

    private String r() {
        if (TextUtils.isEmpty(this.f56025i)) {
            String s = s();
            return TextUtils.isEmpty(s) ? this.f56020d.windowPopUrl : s;
        }
        return this.f56025i;
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
        com.kwad.sdk.core.webview.kwai.g gVar = this.f56022f;
        if (gVar != null) {
            gVar.a();
            this.f56022f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Runnable runnable = this.f56026j;
        if (runnable != null) {
            this.f56018b.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.k);
        if (this.f56018b.getVisibility() != 0) {
            return;
        }
        s sVar = this.f56024h;
        if (sVar != null) {
            sVar.e();
        }
        this.f56018b.setVisibility(4);
        s sVar2 = this.f56024h;
        if (sVar2 != null) {
            sVar2.f();
        }
        e eVar = ((c) this).a.f56014b;
        if (eVar != null) {
            eVar.a(this.k);
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f56020d = com.kwad.sdk.core.response.a.a.ac(com.kwad.sdk.core.response.a.d.j(((c) this).a.f56016d));
        this.f56021e = ((c) this).a.f56017e;
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
        this.f56018b = (KsAdWebView) a(R.id.ksad_download_tips_web_card_webView);
    }
}
