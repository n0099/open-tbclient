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
/* loaded from: classes3.dex */
public class b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private g f6205a;
    private com.kwad.sdk.core.webview.a b;
    private NestedScrollWebView c;
    private AdTemplate d;
    private k.b e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.b));
        gVar.a(new f(this.b));
        gVar.a(new k(this.e));
        gVar.a(new j(this.b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        f();
        ar.a(this.c);
        this.f6205a = new g(this.c);
        a(this.f6205a);
        this.c.addJavascriptInterface(this.f6205a, "KwaiAd");
    }

    private void f() {
        if (this.f6205a != null) {
            this.f6205a.a();
            this.f6205a = null;
        }
    }

    private void g() {
        this.b = new com.kwad.sdk.core.webview.a();
        this.b.b = this.d;
        this.b.f6320a = 0;
        this.b.f = this.c;
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
