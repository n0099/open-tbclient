package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ar;
import java.io.File;
/* loaded from: classes3.dex */
public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    private KsAdWebView f9102b;
    private i.a c;
    private AdInfo.DownloadSafeInfo d;
    private com.kwad.sdk.core.download.b.b e;
    private g f;
    private com.kwad.sdk.core.webview.a g;
    private n i;
    private volatile int k;
    private int h = -1;
    private volatile boolean j = false;
    private a.b l = new a.b() { // from class: com.kwad.sdk.core.download.a.f.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            if (f.this.f9099a.c != null) {
                f.this.f9099a.c.onAdClicked();
            }
        }
    };
    private i.b m = new i.b() { // from class: com.kwad.sdk.core.download.a.f.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            f.this.c = aVar;
            f.this.f9102b.setTranslationY(aVar.f9587a + aVar.d);
        }
    };
    private h.a n = new h.a() { // from class: com.kwad.sdk.core.download.a.f.6
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            f.this.s();
        }
    };
    private k.b o = new k.b() { // from class: com.kwad.sdk.core.download.a.f.7
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            f.this.h = i;
            com.kwad.sdk.core.d.a.b("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + i);
        }
    };

    private void a(g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.g, this.e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.g));
        com.kwad.sdk.core.webview.jshandler.f fVar = new com.kwad.sdk.core.webview.jshandler.f(this.g);
        fVar.a(new f.a() { // from class: com.kwad.sdk.core.download.a.f.4
            @Override // com.kwad.sdk.core.webview.jshandler.f.a
            public void a() {
                f.this.j = true;
            }
        });
        gVar.a(fVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.g));
        gVar.a(new i(this.g, this.m));
        gVar.a(new k(this.o));
        this.i = new n();
        gVar.a(this.i);
        gVar.a(new o(this.g, this.e));
        gVar.a(new h(this.n));
        gVar.a(new j(this.g));
    }

    static /* synthetic */ int d(f fVar) {
        int i = fVar.k;
        fVar.k = i + 1;
        return i;
    }

    private void e() {
        this.h = -1;
        this.f9102b.setVisibility(8);
        this.f9102b.f();
        r();
    }

    private void f() {
        this.g = new com.kwad.sdk.core.webview.a();
        this.g.f9539b = this.f9099a.e;
        this.g.f9538a = this.f9099a.f9100a;
        this.g.c = this.f9099a.d;
        this.g.e = this.f9099a.d;
        this.g.f = this.f9102b;
    }

    private void g() {
        this.h = -1;
        h();
        this.f9102b.setBackgroundColor(0);
        this.f9102b.getBackground().setAlpha(0);
        this.f9102b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.d.windowPopUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        r();
        ar.b(this.f9102b);
        this.f9102b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.a.f.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                f.this.j = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                if (f.this.j) {
                    return;
                }
                if (f.this.k >= 2) {
                    f.this.f9102b.setVisibility(8);
                    return;
                }
                f.this.f9102b.reload();
                f.d(f.this);
            }
        });
        this.f = new g(this.f9102b);
        a(this.f);
        this.f9102b.a(this.f, "KwaiAd", new ValueCallback<String>() { // from class: com.kwad.sdk.core.download.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.f.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "mWebView.loadUrl() url=" + f.this.d.windowPopUrl);
                        f.this.f9102b.loadUrl(f.this.p());
                        f.d(f.this);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        String q = q();
        return TextUtils.isEmpty(q) ? this.d.windowPopUrl : q;
    }

    @NonNull
    private String q() {
        String str = null;
        if (o() != null) {
            File b2 = com.kwad.sdk.core.config.c.b(o());
            if (b2.exists()) {
                str = Uri.fromFile(b2).toString();
                com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getPreloadUrl preloadUrl " + str);
            } else if (com.kwad.sdk.core.config.c.d() != null) {
                str = com.kwad.sdk.core.config.c.d().h5Url;
                com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "getPreloadUrl getDownloadPopWindowConfig " + str);
            }
        }
        return str == null ? "" : str;
    }

    private void r() {
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation");
        if (this.f9102b.getVisibility() != 0) {
            return;
        }
        if (this.i != null) {
            this.i.e();
        }
        this.f9102b.setVisibility(4);
        if (this.i != null) {
            this.i.f();
        }
        if (this.f9099a.f9101b != null) {
            this.f9099a.f9101b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = com.kwad.sdk.core.response.b.a.Z(com.kwad.sdk.core.response.b.c.j(this.f9099a.e));
        this.e = this.f9099a.f;
        f();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9102b = (KsAdWebView) b(R.id.ksad_download_tips_web_card_webView);
    }
}
