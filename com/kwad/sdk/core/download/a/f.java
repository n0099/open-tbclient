package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.utils.aq;
import java.io.File;
/* loaded from: classes6.dex */
public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f32212b;

    /* renamed from: c  reason: collision with root package name */
    public i.a f32213c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo.DownloadSafeInfo f32214d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32215e;

    /* renamed from: f  reason: collision with root package name */
    public g f32216f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f32217g;

    /* renamed from: h  reason: collision with root package name */
    public m f32218h;

    /* renamed from: i  reason: collision with root package name */
    public a.b f32219i = new a.b() { // from class: com.kwad.sdk.core.download.a.f.1
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a(a.C0373a c0373a) {
            KsDrawAd.AdInteractionListener adInteractionListener = ((c) f.this).f32205a.f32208c;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    };
    public i.b j = new i.b() { // from class: com.kwad.sdk.core.download.a.f.3
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(i.a aVar) {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            f.this.f32213c = aVar;
            f.this.f32212b.setTranslationY((float) (aVar.f32952a + aVar.f32955d));
        }
    };
    public h.a k = new h.a() { // from class: com.kwad.sdk.core.download.a.f.4
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            f.this.s();
        }
    };
    public k.b l = new k.b() { // from class: com.kwad.sdk.core.download.a.f.5
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            com.kwad.sdk.core.d.a.c("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + i2);
        }
    };

    private void a(g gVar) {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "registerWebCardHandler");
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f32217g, this.f32215e, this.f32219i));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f32217g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f32217g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.f32217g));
        gVar.a(new i(this.f32217g, this.j));
        gVar.a(new k(this.l));
        m mVar = new m();
        this.f32218h = mVar;
        gVar.a(mVar);
        gVar.a(new n(this.f32217g, this.f32215e));
        gVar.a(new h(this.k));
        gVar.a(new j(this.f32217g));
    }

    private void e() {
        this.f32212b.setVisibility(8);
        this.f32212b.c();
        r();
    }

    private void m() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f32217g = aVar;
        d dVar = ((c) this).f32205a;
        aVar.f32867b = dVar.f32210e;
        aVar.f32866a = dVar.f32206a;
        AdBaseFrameLayout adBaseFrameLayout = dVar.f32209d;
        aVar.f32868c = adBaseFrameLayout;
        aVar.f32870e = adBaseFrameLayout;
        aVar.f32871f = this.f32212b;
    }

    private void n() {
        o();
        this.f32212b.setBackgroundColor(0);
        this.f32212b.getBackground().setAlpha(0);
        this.f32212b.setVisibility(0);
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "downloadPanelUrl=" + this.f32214d.windowPopUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        r();
        aq.b(this.f32212b);
        this.f32212b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.download.a.f.2
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
        g gVar = new g(this.f32212b);
        this.f32216f = gVar;
        a(gVar);
        this.f32212b.addJavascriptInterface(this.f32216f, "KwaiAd");
        this.f32212b.loadUrl(p());
    }

    private String p() {
        String q = q();
        return TextUtils.isEmpty(q) ? this.f32214d.windowPopUrl : q;
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
        if (l() != null) {
            File b2 = com.kwad.sdk.core.config.c.b(l());
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
        g gVar = this.f32216f;
        if (gVar != null) {
            gVar.a();
            this.f32216f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.kwad.sdk.core.d.a.a("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation");
        if (this.f32212b.getVisibility() != 0) {
            return;
        }
        m mVar = this.f32218h;
        if (mVar != null) {
            mVar.e();
        }
        this.f32212b.setVisibility(4);
        m mVar2 = this.f32218h;
        if (mVar2 != null) {
            mVar2.f();
        }
        e eVar = ((c) this).f32205a.f32207b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32214d = com.kwad.sdk.core.response.b.a.S(com.kwad.sdk.core.response.b.c.g(((c) this).f32205a.f32210e));
        this.f32215e = ((c) this).f32205a.f32211f;
        m();
        n();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f32212b = (KsAdWebView) a(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        e();
    }
}
