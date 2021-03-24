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
/* loaded from: classes6.dex */
public class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f36620a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f36621b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f36622c;

    /* renamed from: d  reason: collision with root package name */
    public g f36623d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f36622c, this.f36620a.f36662f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = d.this.f36620a.f36657a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (d.this.f36620a != null && d.this.f36620a.f36661e != null) {
                        jSONObject.put("duration", d.this.f36620a.f36661e.c());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                com.kwad.sdk.core.report.b.a(d.this.f36620a.f36659c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f36622c));
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f36622c = aVar;
        com.kwad.sdk.splashscreen.c cVar = this.f36620a;
        aVar.f34285b = cVar.f36659c;
        aVar.f34284a = 0;
        AdBaseFrameLayout adBaseFrameLayout = cVar.f36660d;
        aVar.f34286c = adBaseFrameLayout;
        aVar.f34288e = adBaseFrameLayout;
        aVar.f34289f = this.f36621b;
        aVar.f34287d = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f36621b).setAllowFileAccess(true);
        g gVar = new g(this.f36621b);
        this.f36623d = gVar;
        a(gVar);
        this.f36621b.addJavascriptInterface(this.f36623d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f36623d;
        if (gVar != null) {
            gVar.a();
            this.f36623d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f36620a = cVar;
        KsAdWebView ksAdWebView = (KsAdWebView) cVar.f36660d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f36621b = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f36621b.getBackground().setAlpha(0);
        this.f36621b.setVisibility(0);
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
            this.f36621b.setVisibility(8);
            return;
        }
        this.f36621b.setVisibility(0);
        g();
        h();
        this.f36621b.loadUrl(e2);
        this.f36621b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.d.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
                d.this.f36621b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
