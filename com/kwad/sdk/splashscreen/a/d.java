package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ar;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f10729a;

    /* renamed from: b  reason: collision with root package name */
    private KsAdWebView f10730b;
    private com.kwad.sdk.core.webview.a c;
    private g d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.c, this.f10729a.f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                if (d.this.f10729a.f10747a != null) {
                    d.this.f10729a.f10747a.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (d.this.f10729a != null && d.this.f10729a.e != null) {
                        jSONObject.put("duration", d.this.f10729a.e.c());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.a.a(e);
                }
                com.kwad.sdk.core.report.b.a(d.this.f10729a.c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.c));
    }

    private void g() {
        this.c = new com.kwad.sdk.core.webview.a();
        this.c.f9537b = this.f10729a.c;
        this.c.f9536a = 0;
        this.c.c = this.f10729a.d;
        this.c.e = this.f10729a.d;
        this.c.f = this.f10730b;
        this.c.d = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f10730b).setAllowFileAccess(true);
        this.d = new g(this.f10730b);
        a(this.d);
        this.f10730b.addJavascriptInterface(this.d, "KwaiAd");
    }

    private void p() {
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10729a = (com.kwad.sdk.splashscreen.c) n();
        this.f10730b = (KsAdWebView) this.f10729a.d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f10730b.setBackgroundColor(0);
        this.f10730b.getBackground().setAlpha(0);
        this.f10730b.setVisibility(0);
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        p();
    }

    protected String e() {
        if (o() != null) {
            File d = com.kwad.sdk.core.config.c.d(o());
            if (d.exists()) {
                return Uri.fromFile(d).toString();
            }
            if (com.kwad.sdk.core.config.c.b() != null) {
                return com.kwad.sdk.core.config.c.b().h5Url;
            }
        }
        return null;
    }

    public void f() {
        String e = e();
        if (TextUtils.isEmpty(e)) {
            this.f10730b.setVisibility(8);
            return;
        }
        this.f10730b.setVisibility(0);
        g();
        h();
        this.f10730b.loadUrl(e);
        this.f10730b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.d.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
                d.this.f10730b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
