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
    public g f33906a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33907b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f33908c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33909d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f33910e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f33907b));
        gVar.a(new f(this.f33907b));
        gVar.a(new k(this.f33910e));
        gVar.a(new j(this.f33907b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.f33908c);
        g gVar = new g(this.f33908c);
        this.f33906a = gVar;
        a(gVar);
        this.f33908c.addJavascriptInterface(this.f33906a, "KwaiAd");
    }

    private void f() {
        g gVar = this.f33906a;
        if (gVar != null) {
            gVar.a();
            this.f33906a = null;
        }
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33907b = aVar;
        aVar.f34286b = this.f33909d;
        aVar.f34285a = 0;
        aVar.f34290f = this.f33908c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33909d = ((com.kwad.sdk.core.page.recycle.e) n()).f33942c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.f33908c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f33909d);
        this.f33908c.setNestedScrollingEnabled(true);
        g();
        e();
        this.f33908c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.f33909d)));
        this.f33908c.d();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.f33908c.e();
    }
}
