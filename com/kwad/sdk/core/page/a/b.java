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
/* loaded from: classes7.dex */
public class b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public g f34633a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34634b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f34635c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34636d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f34637e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f34634b));
        gVar.a(new f(this.f34634b));
        gVar.a(new k(this.f34637e));
        gVar.a(new j(this.f34634b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.f34635c);
        g gVar = new g(this.f34635c);
        this.f34633a = gVar;
        a(gVar);
        this.f34635c.addJavascriptInterface(this.f34633a, "KwaiAd");
    }

    private void f() {
        g gVar = this.f34633a;
        if (gVar != null) {
            gVar.a();
            this.f34633a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34634b = aVar;
        aVar.f35027b = this.f34636d;
        aVar.f35026a = 0;
        aVar.f35031f = this.f34635c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f34636d = ((com.kwad.sdk.core.page.recycle.e) n()).f34671c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.f34635c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f34636d);
        this.f34635c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f34635c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f34636d)));
        this.f34635c.d();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.f34635c.e();
    }
}
