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
    public g f34195a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34196b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f34197c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34198d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f34199e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f34196b));
        gVar.a(new f(this.f34196b));
        gVar.a(new k(this.f34199e));
        gVar.a(new j(this.f34196b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.f34197c);
        g gVar = new g(this.f34197c);
        this.f34195a = gVar;
        a(gVar);
        this.f34197c.addJavascriptInterface(this.f34195a, "KwaiAd");
    }

    private void f() {
        g gVar = this.f34195a;
        if (gVar != null) {
            gVar.a();
            this.f34195a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34196b = aVar;
        aVar.f34575b = this.f34198d;
        aVar.f34574a = 0;
        aVar.f34579f = this.f34197c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34198d = ((com.kwad.sdk.core.page.recycle.e) n()).f34231c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.f34197c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f34198d);
        this.f34197c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f34197c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f34198d)));
        this.f34197c.d();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.f34197c.e();
    }
}
