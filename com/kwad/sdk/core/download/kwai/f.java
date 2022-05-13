package com.kwad.sdk.core.download.kwai;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class f extends c {
    public KsAdWebView b;
    public j.a c;
    public AdInfo.DownloadSafeInfo d;
    public com.kwad.sdk.core.download.a.b e;
    public com.kwad.sdk.core.webview.kwai.g f;
    public com.kwad.sdk.core.webview.a g;
    public s h;
    public String i;
    public Runnable j;
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
            f.this.c = aVar;
            f.this.b.setTranslationY((float) (aVar.a + aVar.d));
        }
    };
    public i.b n = new i.b() { // from class: com.kwad.sdk.core.download.kwai.f.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i) {
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
        this.i = str;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.g, this.e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.g, this.e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.g));
        gVar.a(new j(this.g, this.m));
        gVar.a(new p(this.o));
        s sVar = new s();
        this.h = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.g, this.e));
        gVar.a(new i(this.n));
        gVar.a(new k(this.g));
    }

    private void e() {
        this.b.setVisibility(8);
        this.b.a();
        t();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.g = aVar;
        aVar.a(((c) this).a.d);
        com.kwad.sdk.core.webview.a aVar2 = this.g;
        d dVar = ((c) this).a;
        aVar2.a = dVar.a;
        AdBaseFrameLayout adBaseFrameLayout = dVar.c;
        aVar2.b = adBaseFrameLayout;
        aVar2.d = adBaseFrameLayout;
        aVar2.e = this.b;
    }

    private void g() {
        i();
        this.b.postDelayed(h(), 1500L);
        this.b.setBackgroundColor(0);
        this.b.getBackground().setAlpha(0);
        this.b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.d.windowPopUrl);
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
        this.j = runnable;
        return runnable;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        t();
        be.b(this.b);
        this.b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.kwai.f.3
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.b);
        this.f = gVar;
        a(gVar);
        this.b.addJavascriptInterface(this.f, "KwaiAd");
        String r = r();
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getUrl: " + r);
        this.b.loadUrl(r);
    }

    private String r() {
        if (TextUtils.isEmpty(this.i)) {
            String s = s();
            return TextUtils.isEmpty(s) ? this.d.windowPopUrl : s;
        }
        return this.i;
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
            File c = com.kwad.sdk.core.config.b.c(q());
            if (c.exists()) {
                str = Uri.fromFile(c).toString();
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
        com.kwad.sdk.core.webview.kwai.g gVar = this.f;
        if (gVar != null) {
            gVar.a();
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.b.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.k);
        if (this.b.getVisibility() != 0) {
            return;
        }
        s sVar = this.h;
        if (sVar != null) {
            sVar.e();
        }
        this.b.setVisibility(4);
        s sVar2 = this.h;
        if (sVar2 != null) {
            sVar2.f();
        }
        e eVar = ((c) this).a.b;
        if (eVar != null) {
            eVar.a(this.k);
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = com.kwad.sdk.core.response.a.a.ac(com.kwad.sdk.core.response.a.d.j(((c) this).a.d));
        this.e = ((c) this).a.e;
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
        this.b = (KsAdWebView) a(R.id.obfuscated_res_0x7f091080);
    }
}
