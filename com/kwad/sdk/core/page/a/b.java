package com.kwad.sdk.core.page.a;

import android.annotation.SuppressLint;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.recycle.NestedScrollWebView;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ar;
/* loaded from: classes6.dex */
public class b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public g f34290a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34291b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f34292c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34293d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f34294e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f34291b));
        gVar.a(new f(this.f34291b));
        gVar.a(new k(this.f34294e));
        gVar.a(new j(this.f34291b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.f34292c);
        g gVar = new g(this.f34292c);
        this.f34290a = gVar;
        a(gVar);
        this.f34292c.addJavascriptInterface(this.f34290a, "KwaiAd");
    }

    private void f() {
        g gVar = this.f34290a;
        if (gVar != null) {
            gVar.a();
            this.f34290a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34291b = aVar;
        aVar.f34670b = this.f34293d;
        aVar.f34669a = 0;
        aVar.f34674f = this.f34292c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34293d = ((com.kwad.sdk.core.page.recycle.e) n()).f34326c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.f34292c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f34293d);
        this.f34292c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f34292c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f34293d)));
        this.f34292c.d();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.f34292c.e();
    }
}
