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
/* loaded from: classes5.dex */
public class b extends Presenter {
    public g a;
    public com.kwad.sdk.core.webview.a b;
    public NestedScrollWebView c;
    public AdTemplate d;
    public p.b e = new p.b() { // from class: com.kwad.sdk.core.page.kwai.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
        }
    };

    private void a(g gVar) {
        gVar.a(new f(this.b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.b));
        gVar.a(new p(this.e));
        gVar.a(new k(this.b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        be.a(this.c);
        g gVar = new g(this.c);
        this.a = gVar;
        a(gVar);
        this.c.addJavascriptInterface(this.a, "KwaiAd");
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
        this.b = aVar;
        aVar.a(this.d);
        com.kwad.sdk.core.webview.a aVar2 = this.b;
        aVar2.a = 0;
        aVar2.e = this.c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = ((e) p()).c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) m().findViewById(R.id.obfuscated_res_0x7f091181);
        this.c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.d);
        this.c.setNestedScrollingEnabled(true);
        g();
        e();
        this.c.loadUrl(com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.j(this.d)));
        this.c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        f();
        NestedScrollWebView nestedScrollWebView = this.c;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.c();
            this.c = null;
        }
    }
}
