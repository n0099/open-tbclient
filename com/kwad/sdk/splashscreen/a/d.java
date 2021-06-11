package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ar;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f37374a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f37375b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f37376c;

    /* renamed from: d  reason: collision with root package name */
    public g f37377d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f37376c, this.f37374a.f37418f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = d.this.f37374a.f37413a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (d.this.f37374a != null && d.this.f37374a.f37417e != null) {
                        jSONObject.put("duration", d.this.f37374a.f37417e.c());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                com.kwad.sdk.core.report.b.a(d.this.f37374a.f37415c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f37376c));
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f37376c = aVar;
        com.kwad.sdk.splashscreen.c cVar = this.f37374a;
        aVar.f34929b = cVar.f37415c;
        aVar.f34928a = 0;
        AdBaseFrameLayout adBaseFrameLayout = cVar.f37416d;
        aVar.f34930c = adBaseFrameLayout;
        aVar.f34932e = adBaseFrameLayout;
        aVar.f34933f = this.f37375b;
        aVar.f34931d = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f37375b).setAllowFileAccess(true);
        g gVar = new g(this.f37375b);
        this.f37377d = gVar;
        a(gVar);
        this.f37375b.addJavascriptInterface(this.f37377d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f37377d;
        if (gVar != null) {
            gVar.a();
            this.f37377d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f37374a = cVar;
        KsAdWebView ksAdWebView = (KsAdWebView) cVar.f37416d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f37375b = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f37375b.getBackground().setAlpha(0);
        this.f37375b.setVisibility(0);
        f();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        p();
    }

    public String e() {
        if (o() != null) {
            File d2 = com.kwad.sdk.core.config.c.d(o());
            if (d2.exists()) {
                return Uri.fromFile(d2).toString();
            }
            if (com.kwad.sdk.core.config.c.b() != null) {
                return com.kwad.sdk.core.config.c.b().h5Url;
            }
            return null;
        }
        return null;
    }

    public void f() {
        String e2 = e();
        if (TextUtils.isEmpty(e2)) {
            this.f37375b.setVisibility(8);
            return;
        }
        this.f37375b.setVisibility(0);
        g();
        h();
        this.f37375b.loadUrl(e2);
        this.f37375b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.d.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                d.this.f37375b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
