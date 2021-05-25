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
    public g f32443a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f32444b;

    /* renamed from: c  reason: collision with root package name */
    public NestedScrollWebView f32445c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32446d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f32447e = new k.b() { // from class: com.kwad.sdk.core.page.a.b.1
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
        }
    };

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new e(this.f32444b));
        gVar.a(new f(this.f32444b));
        gVar.a(new k(this.f32447e));
        gVar.a(new j(this.f32444b));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void e() {
        m();
        aq.a(this.f32445c);
        g gVar = new g(this.f32445c);
        this.f32443a = gVar;
        a(gVar);
        this.f32445c.addJavascriptInterface(this.f32443a, "KwaiAd");
    }

    private void m() {
        g gVar = this.f32443a;
        if (gVar != null) {
            gVar.a();
            this.f32443a = null;
        }
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f32444b = aVar;
        aVar.f32796b = this.f32446d;
        aVar.f32795a = 0;
        aVar.f32800f = this.f32445c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32446d = ((com.kwad.sdk.core.page.recycle.e) k()).f32481c;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) i().findViewById(R.id.ksad_video_webView);
        this.f32445c = nestedScrollWebView;
        nestedScrollWebView.setTemplateData(this.f32446d);
        this.f32445c.setNestedScrollingEnabled(true);
        n();
        e();
        this.f32445c.loadUrl(com.kwad.sdk.core.response.b.a.y(c.g(this.f32446d)));
        this.f32445c.a();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        m();
        this.f32445c.b();
    }
}
