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
/* loaded from: classes4.dex */
public class b extends Presenter {
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f56158b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f56159c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f56160d;

    /* renamed from: e  reason: collision with root package name */
    public p.b f56161e = new p.b() { // from class: com.kwad.sdk.core.page.kwai.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
        }
    };

    private void a(g gVar) {
        gVar.a(new f(this.f56158b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f56158b));
        gVar.a(new p(this.f56161e));
        gVar.a(new k(this.f56158b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        be.a(this.f56159c);
        g gVar = new g(this.f56159c);
        this.a = gVar;
        a(gVar);
        this.f56159c.addJavascriptInterface(this.a, "KwaiAd");
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
        this.f56158b = aVar;
        aVar.a(this.f56160d);
        com.kwad.sdk.core.webview.a aVar2 = this.f56158b;
        aVar2.a = 0;
        aVar2.f56542e = this.f56159c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f56160d = ((e) p()).f56198c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.ksad_video_webView);
        this.f56159c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f56160d);
        this.f56159c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f56159c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.f56160d)));
        this.f56159c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        f();
        NestedScrollWebView nestedScrollWebView = this.f56159c;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.c();
            this.f56159c = null;
        }
    }
}
