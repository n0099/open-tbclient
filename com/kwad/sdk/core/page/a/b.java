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
/* loaded from: classes5.dex */
public class b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private g f9646a;

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.core.webview.a f9647b;
    private NestedScrollWebView c;
    private AdTemplate d;
    private k.b e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f9647b));
        gVar.a(new f(this.f9647b));
        gVar.a(new k(this.e));
        gVar.a(new j(this.f9647b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.c);
        this.f9646a = new g(this.c);
        a(this.f9646a);
        this.c.addJavascriptInterface(this.f9646a, "KwaiAd");
    }

    private void f() {
        if (this.f9646a != null) {
            this.f9646a.a();
            this.f9646a = null;
        }
    }

    private void g() {
        this.f9647b = new com.kwad.sdk.core.webview.a();
        this.f9647b.f9837b = this.d;
        this.f9647b.f9836a = 0;
        this.f9647b.f = this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = ((com.kwad.sdk.core.page.recycle.e) n()).c;
        this.c = (NestedScrollWebView) l().findViewById(R.id.ksad_video_webView);
        this.c.setTemplateData(this.d);
        this.c.setNestedScrollingEnabled(true);
        g();
        e();
        this.c.loadUrl(com.kwad.sdk.core.response.b.a.B(c.j(this.d)));
        this.c.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
        this.c.e();
    }
}
