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
/* loaded from: classes4.dex */
public class b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public g f34535a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34536b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f34537c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34538d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f34539e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f34536b));
        gVar.a(new f(this.f34536b));
        gVar.a(new k(this.f34539e));
        gVar.a(new j(this.f34536b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.f34537c);
        g gVar = new g(this.f34537c);
        this.f34535a = gVar;
        a(gVar);
        this.f34537c.addJavascriptInterface(this.f34535a, "KwaiAd");
    }

    private void f() {
        g gVar = this.f34535a;
        if (gVar != null) {
            gVar.a();
            this.f34535a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34536b = aVar;
        aVar.f34929b = this.f34538d;
        aVar.f34928a = 0;
        aVar.f34933f = this.f34537c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34538d = ((com.kwad.sdk.core.page.recycle.e) n()).f34573c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.f34537c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f34538d);
        this.f34537c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f34537c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f34538d)));
        this.f34537c.d();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.f34537c.e();
    }
}
