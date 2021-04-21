package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
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
/* loaded from: classes6.dex */
public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f33940b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f33941c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f33942d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33943e;

    /* renamed from: f  reason: collision with root package name */
    public g f33944f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33945g;
    public n i;
    public volatile int k;

    /* renamed from: h  reason: collision with root package name */
    public int f33946h = -1;
    public volatile boolean j = false;
    public a.b l = new a.b() { // from class: com.kwad.sdk.core.download.a.f.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            KsDrawAd.AdInteractionListener adInteractionListener = ((c) f.this).f33933a.f33936c;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    };
    public i.b m = new i.b() { // from class: com.kwad.sdk.core.download.a.f.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            f.this.f33941c = aVar;
            f.this.f33940b.setTranslationY((float) (aVar.f34746a + aVar.f34749d));
        }
    };
    public h.a n = new h.a() { // from class: com.kwad.sdk.core.download.a.f.6
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            f.this.s();
        }
    };
    public k.b o = new k.b() { // from class: com.kwad.sdk.core.download.a.f.7
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            f.this.f33946h = i;
            com.kwad.sdk.core.d.a.b("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + i);
        }
    };

    private void a(g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f33945g, this.f33943e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f33945g));
        com.kwad.sdk.core.webview.jshandler.f fVar = new com.kwad.sdk.core.webview.jshandler.f(this.f33945g);
        fVar.a(new f.a() { // from class: com.kwad.sdk.core.download.a.f.4
            @Override // com.kwad.sdk.core.webview.jshandler.f.a
            public void a() {
                f.this.j = true;
            }
        });
        gVar.a(fVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f33945g));
        gVar.a(new i(this.f33945g, this.m));
        gVar.a(new k(this.o));
        n nVar = new n();
        this.i = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.f33945g, this.f33943e));
        gVar.a(new h(this.n));
        gVar.a(new j(this.f33945g));
    }

    public static /* synthetic */ int d(f fVar) {
        int i = fVar.k;
        fVar.k = i + 1;
        return i;
    }

    private void e() {
        this.f33946h = -1;
        this.f33940b.setVisibility(8);
        this.f33940b.f();
        r();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33945g = aVar;
        d dVar = ((c) this).f33933a;
        aVar.f34670b = dVar.f33938e;
        aVar.f34669a = dVar.f33934a;
        AdBaseFrameLayout adBaseFrameLayout = dVar.f33937d;
        aVar.f34671c = adBaseFrameLayout;
        aVar.f34673e = adBaseFrameLayout;
        aVar.f34674f = this.f33940b;
    }

    private void g() {
        this.f33946h = -1;
        h();
        this.f33940b.setBackgroundColor(0);
        this.f33940b.getBackground().setAlpha(0);
        this.f33940b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f33942d.windowPopUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        r();
        ar.b(this.f33940b);
        this.f33940b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.a.f.2
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
                    f.this.f33940b.setVisibility(8);
                    return;
                }
                f.this.f33940b.reload();
                f.d(f.this);
            }
        });
        g gVar = new g(this.f33940b);
        this.f33944f = gVar;
        a(gVar);
        this.f33940b.a(this.f33944f, "KwaiAd", new ValueCallback<String>() { // from class: com.kwad.sdk.core.download.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.f.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "mWebView.loadUrl() url=" + f.this.f33942d.windowPopUrl);
                        f.this.f33940b.loadUrl(f.this.p());
                        f.d(f.this);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        String q = q();
        return TextUtils.isEmpty(q) ? this.f33942d.windowPopUrl : q;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String q() {
        String str;
        StringBuilder sb;
        String str2;
        if (o() != null) {
            File b2 = com.kwad.sdk.core.config.c.b(o());
            if (b2.exists()) {
                str = Uri.fromFile(b2).toString();
                sb = new StringBuilder();
                str2 = "getPreloadUrl preloadUrl ";
            } else if (com.kwad.sdk.core.config.c.d() != null) {
                str = com.kwad.sdk.core.config.c.d().h5Url;
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

    private void r() {
        g gVar = this.f33944f;
        if (gVar != null) {
            gVar.a();
            this.f33944f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation");
        if (this.f33940b.getVisibility() != 0) {
            return;
        }
        n nVar = this.i;
        if (nVar != null) {
            nVar.e();
        }
        this.f33940b.setVisibility(4);
        n nVar2 = this.i;
        if (nVar2 != null) {
            nVar2.f();
        }
        e eVar = ((c) this).f33933a.f33935b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33942d = com.kwad.sdk.core.response.b.a.Z(com.kwad.sdk.core.response.b.c.j(((c) this).f33933a.f33938e));
        this.f33943e = ((c) this).f33933a.f33939f;
        f();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33940b = (KsAdWebView) b(R.id.ksad_download_tips_web_card_webView);
    }
}
