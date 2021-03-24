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
    public g f33905a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33906b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f33907c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33908d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f33909e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f33906b));
        gVar.a(new f(this.f33906b));
        gVar.a(new k(this.f33909e));
        gVar.a(new j(this.f33906b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.f33907c);
        g gVar = new g(this.f33907c);
        this.f33905a = gVar;
        a(gVar);
        this.f33907c.addJavascriptInterface(this.f33905a, "KwaiAd");
    }

    private void f() {
        g gVar = this.f33905a;
        if (gVar != null) {
            gVar.a();
            this.f33905a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33906b = aVar;
        aVar.f34285b = this.f33908d;
        aVar.f34284a = 0;
        aVar.f34289f = this.f33907c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33908d = ((com.kwad.sdk.core.page.recycle.e) n()).f33941c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.f33907c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f33908d);
        this.f33907c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f33907c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f33908d)));
        this.f33907c.d();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.f33907c.e();
    }
}
