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
/* loaded from: classes7.dex */
public class b extends Presenter {
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f39627b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f39628c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f39629d;

    /* renamed from: e  reason: collision with root package name */
    public p.b f39630e = new p.b() { // from class: com.kwad.sdk.core.page.kwai.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
        }
    };

    private void a(g gVar) {
        gVar.a(new f(this.f39627b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f39627b));
        gVar.a(new p(this.f39630e));
        gVar.a(new k(this.f39627b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        be.a(this.f39628c);
        g gVar = new g(this.f39628c);
        this.a = gVar;
        a(gVar);
        this.f39628c.addJavascriptInterface(this.a, "KwaiAd");
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
        this.f39627b = aVar;
        aVar.a(this.f39629d);
        com.kwad.sdk.core.webview.a aVar2 = this.f39627b;
        aVar2.a = 0;
        aVar2.f39984e = this.f39628c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f39629d = ((e) p()).f39663c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.obfuscated_res_0x7f091187);
        this.f39628c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f39629d);
        this.f39628c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f39628c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.f39629d)));
        this.f39628c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        f();
        NestedScrollWebView nestedScrollWebView = this.f39628c;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.c();
            this.f39628c = null;
        }
    }
}
