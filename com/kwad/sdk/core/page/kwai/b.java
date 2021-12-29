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
    public com.kwad.sdk.core.webview.a f58144b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f58145c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f58146d;

    /* renamed from: e  reason: collision with root package name */
    public p.b f58147e = new p.b() { // from class: com.kwad.sdk.core.page.kwai.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
        }
    };

    private void a(g gVar) {
        gVar.a(new f(this.f58144b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f58144b));
        gVar.a(new p(this.f58147e));
        gVar.a(new k(this.f58144b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        be.a(this.f58145c);
        g gVar = new g(this.f58145c);
        this.a = gVar;
        a(gVar);
        this.f58145c.addJavascriptInterface(this.a, "KwaiAd");
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
        this.f58144b = aVar;
        aVar.a(this.f58146d);
        com.kwad.sdk.core.webview.a aVar2 = this.f58144b;
        aVar2.a = 0;
        aVar2.f58539e = this.f58145c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f58146d = ((e) p()).f58185c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.ksad_video_webView);
        this.f58145c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f58146d);
        this.f58145c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f58145c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.f58146d)));
        this.f58145c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        f();
        NestedScrollWebView nestedScrollWebView = this.f58145c;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.c();
            this.f58145c = null;
        }
    }
}
