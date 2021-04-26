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
import com.kwad.sdk.utils.aq;
/* loaded from: classes6.dex */
public class b extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public g f33269a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33270b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f33271c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33272d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f33273e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f33270b));
        gVar.a(new f(this.f33270b));
        gVar.a(new k(this.f33273e));
        gVar.a(new j(this.f33270b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        m();
        aq.a(this.f33271c);
        g gVar = new g(this.f33271c);
        this.f33269a = gVar;
        a(gVar);
        this.f33271c.addJavascriptInterface(this.f33269a, "KwaiAd");
    }

    private void m() {
        g gVar = this.f33269a;
        if (gVar != null) {
            gVar.a();
            this.f33269a = null;
        }
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33270b = aVar;
        aVar.f33622b = this.f33272d;
        aVar.f33621a = 0;
        aVar.f33626f = this.f33271c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33272d = ((com.kwad.sdk.core.page.recycle.e) k()).f33307c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) i().findViewById(R.id.ksad_video_webView);
        this.f33271c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f33272d);
        this.f33271c.setNestedScrollingEnabled(true);
        n();
        e();
        this.f33271c.loadUrl(com.kwad.sdk.core.response.b.a.y(c.g(this.f33272d)));
        this.f33271c.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        m();
        this.f33271c.b();
    }
}
