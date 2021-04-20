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
    public com.kwad.sdk.splashscreen.c f36910a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f36911b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f36912c;

    /* renamed from: d  reason: collision with root package name */
    public g f36913d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f36912c, this.f36910a.f36952f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a() {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = d.this.f36910a.f36947a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (d.this.f36910a != null && d.this.f36910a.f36951e != null) {
                        jSONObject.put("duration", d.this.f36910a.f36951e.c());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                com.kwad.sdk.core.report.b.a(d.this.f36910a.f36949c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f36912c));
    }

    private void g() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f36912c = aVar;
        com.kwad.sdk.splashscreen.c cVar = this.f36910a;
        aVar.f34575b = cVar.f36949c;
        aVar.f34574a = 0;
        AdBaseFrameLayout adBaseFrameLayout = cVar.f36950d;
        aVar.f34576c = adBaseFrameLayout;
        aVar.f34578e = adBaseFrameLayout;
        aVar.f34579f = this.f36911b;
        aVar.f34577d = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        p();
        ar.a(this.f36911b).setAllowFileAccess(true);
        g gVar = new g(this.f36911b);
        this.f36913d = gVar;
        a(gVar);
        this.f36911b.addJavascriptInterface(this.f36913d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f36913d;
        if (gVar != null) {
            gVar.a();
            this.f36913d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f36910a = cVar;
        KsAdWebView ksAdWebView = (KsAdWebView) cVar.f36950d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f36911b = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f36911b.getBackground().setAlpha(0);
        this.f36911b.setVisibility(0);
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
            this.f36911b.setVisibility(8);
            return;
        }
        this.f36911b.setVisibility(0);
        g();
        h();
        this.f36911b.loadUrl(e2);
        this.f36911b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.d.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
                d.this.f36911b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
