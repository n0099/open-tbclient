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
/* loaded from: classes5.dex */
public class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f11028a;

    /* renamed from: b  reason: collision with root package name */
    private KsAdWebView f11029b;
    private com.kwad.sdk.core.webview.a c;
    private g d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.c, this.f11028a.f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                if (d.this.f11028a.f11046a != null) {
                    d.this.f11028a.f11046a.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (d.this.f11028a != null && d.this.f11028a.e != null) {
                        jSONObject.put("duration", d.this.f11028a.e.c());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.a.a(e);
                }
                com.kwad.sdk.core.report.b.a(d.this.f11028a.c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.c));
    }

    private void g() {
        this.c = new com.kwad.sdk.core.webview.a();
        this.c.f9836b = this.f11028a.c;
        this.c.f9835a = 0;
        this.c.c = this.f11028a.d;
        this.c.e = this.f11028a.d;
        this.c.f = this.f11029b;
        this.c.d = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f11029b).setAllowFileAccess(true);
        this.d = new g(this.f11029b);
        a(this.d);
        this.f11029b.addJavascriptInterface(this.d, "KwaiAd");
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
        this.f11028a = (com.kwad.sdk.splashscreen.c) n();
        this.f11029b = (KsAdWebView) this.f11028a.d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f11029b.setBackgroundColor(0);
        this.f11029b.getBackground().setAlpha(0);
        this.f11029b.setVisibility(0);
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
            this.f11029b.setVisibility(8);
            return;
        }
        this.f11029b.setVisibility(0);
        g();
        h();
        this.f11029b.loadUrl(e);
        this.f11029b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.d.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
                d.this.f11029b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
