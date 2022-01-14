package com.kwad.sdk.core.page.kwai;

import android.annotation.SuppressLint;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.recycle.NestedScrollWebView;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.be;
/* loaded from: classes3.dex */
public class b extends Presenter {
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f55946b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f55947c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55948d;

    /* renamed from: e  reason: collision with root package name */
    public p.b f55949e = new p.b() { // from class: com.kwad.sdk.core.page.kwai.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
        }
    };

    private void a(g gVar) {
        gVar.a(new f(this.f55946b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f55946b));
        gVar.a(new p(this.f55949e));
        gVar.a(new k(this.f55946b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        be.a(this.f55947c);
        g gVar = new g(this.f55947c);
        this.a = gVar;
        a(gVar);
        this.f55947c.addJavascriptInterface(this.a, "KwaiAd");
    }

    private void f() {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a();
            this.a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f55946b = aVar;
        aVar.a(this.f55948d);
        com.kwad.sdk.core.webview.a aVar2 = this.f55946b;
        aVar2.a = 0;
        aVar2.f56330e = this.f55947c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55948d = ((e) p()).f55986c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.ksad_video_webView);
        this.f55947c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f55948d);
        this.f55947c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f55947c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.f55948d)));
        this.f55947c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        f();
        NestedScrollWebView nestedScrollWebView = this.f55947c;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.c();
            this.f55947c = null;
        }
    }
}
