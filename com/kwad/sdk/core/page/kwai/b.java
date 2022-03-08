package com.kwad.sdk.core.page.kwai;

import android.annotation.SuppressLint;
import com.baidu.tieba.R;
import com.kwad.sdk.core.page.recycle.NestedScrollWebView;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.be;
/* loaded from: classes8.dex */
public class b extends Presenter {
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f54508b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f54509c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f54510d;

    /* renamed from: e  reason: collision with root package name */
    public p.b f54511e = new p.b() { // from class: com.kwad.sdk.core.page.kwai.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
        }
    };

    private void a(g gVar) {
        gVar.a(new f(this.f54508b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f54508b));
        gVar.a(new p(this.f54511e));
        gVar.a(new k(this.f54508b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        be.a(this.f54509c);
        g gVar = new g(this.f54509c);
        this.a = gVar;
        a(gVar);
        this.f54509c.addJavascriptInterface(this.a, "KwaiAd");
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
        this.f54508b = aVar;
        aVar.a(this.f54510d);
        com.kwad.sdk.core.webview.a aVar2 = this.f54508b;
        aVar2.a = 0;
        aVar2.f54892e = this.f54509c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f54510d = ((e) p()).f54548c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.ksad_video_webView);
        this.f54509c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f54510d);
        this.f54509c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f54509c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.f54510d)));
        this.f54509c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        f();
        NestedScrollWebView nestedScrollWebView = this.f54509c;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.c();
            this.f54509c = null;
        }
    }
}
