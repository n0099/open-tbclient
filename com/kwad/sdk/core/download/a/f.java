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
/* loaded from: classes7.dex */
public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f34277b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f34278c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f34279d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34280e;

    /* renamed from: f  reason: collision with root package name */
    public g f34281f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34282g;

    /* renamed from: i  reason: collision with root package name */
    public n f34284i;
    public volatile int k;

    /* renamed from: h  reason: collision with root package name */
    public int f34283h = -1;
    public volatile boolean j = false;
    public a.b l = new a.b() { // from class: com.kwad.sdk.core.download.a.f.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            KsDrawAd.AdInteractionListener adInteractionListener = ((c) f.this).f34270a.f34273c;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    };
    public i.b m = new i.b() { // from class: com.kwad.sdk.core.download.a.f.5
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            f.this.f34278c = aVar;
            f.this.f34277b.setTranslationY((float) (aVar.f35105a + aVar.f35108d));
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
        public void a(int i2) {
            f.this.f34283h = i2;
            com.kwad.sdk.core.d.a.b("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + i2);
        }
    };

    private void a(g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f34282g, this.f34280e, this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f34282g));
        com.kwad.sdk.core.webview.jshandler.f fVar = new com.kwad.sdk.core.webview.jshandler.f(this.f34282g);
        fVar.a(new f.a() { // from class: com.kwad.sdk.core.download.a.f.4
            @Override // com.kwad.sdk.core.webview.jshandler.f.a
            public void a() {
                f.this.j = true;
            }
        });
        gVar.a(fVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f34282g));
        gVar.a(new i(this.f34282g, this.m));
        gVar.a(new k(this.o));
        n nVar = new n();
        this.f34284i = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.f34282g, this.f34280e));
        gVar.a(new h(this.n));
        gVar.a(new j(this.f34282g));
    }

    public static /* synthetic */ int d(f fVar) {
        int i2 = fVar.k;
        fVar.k = i2 + 1;
        return i2;
    }

    private void e() {
        this.f34283h = -1;
        this.f34277b.setVisibility(8);
        this.f34277b.f();
        r();
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34282g = aVar;
        d dVar = ((c) this).f34270a;
        aVar.f35027b = dVar.f34275e;
        aVar.f35026a = dVar.f34271a;
        AdBaseFrameLayout adBaseFrameLayout = dVar.f34274d;
        aVar.f35028c = adBaseFrameLayout;
        aVar.f35030e = adBaseFrameLayout;
        aVar.f35031f = this.f34277b;
    }

    private void g() {
        this.f34283h = -1;
        h();
        this.f34277b.setBackgroundColor(0);
        this.f34277b.getBackground().setAlpha(0);
        this.f34277b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f34279d.windowPopUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        r();
        ar.b(this.f34277b);
        this.f34277b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.a.f.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
                f.this.j = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                if (f.this.j) {
                    return;
                }
                if (f.this.k >= 2) {
                    f.this.f34277b.setVisibility(8);
                    return;
                }
                f.this.f34277b.reload();
                f.d(f.this);
            }
        });
        g gVar = new g(this.f34277b);
        this.f34281f = gVar;
        a(gVar);
        this.f34277b.a(this.f34281f, "KwaiAd", new ValueCallback<String>() { // from class: com.kwad.sdk.core.download.a.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                ak.a(new Runnable() { // from class: com.kwad.sdk.core.download.a.f.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "mWebView.loadUrl() url=" + f.this.f34279d.windowPopUrl);
                        f.this.f34277b.loadUrl(f.this.p());
                        f.d(f.this);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        String q = q();
        return TextUtils.isEmpty(q) ? this.f34279d.windowPopUrl : q;
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
        g gVar = this.f34281f;
        if (gVar != null) {
            gVar.a();
            this.f34281f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation");
        if (this.f34277b.getVisibility() != 0) {
            return;
        }
        n nVar = this.f34284i;
        if (nVar != null) {
            nVar.e();
        }
        this.f34277b.setVisibility(4);
        n nVar2 = this.f34284i;
        if (nVar2 != null) {
            nVar2.f();
        }
        e eVar = ((c) this).f34270a.f34272b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34279d = com.kwad.sdk.core.response.b.a.Z(com.kwad.sdk.core.response.b.c.j(((c) this).f34270a.f34275e));
        this.f34280e = ((c) this).f34270a.f34276f;
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
        this.f34277b = (KsAdWebView) b(R.id.ksad_download_tips_web_card_webView);
    }
}
