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
import com.kwad.sdk.utils.aq;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f34772a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f34773b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34774c;

    /* renamed from: d  reason: collision with root package name */
    public g f34775d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f34774c, this.f34772a.f34816f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.e.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0386a c0386a) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f34772a.f34811a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (e.this.f34772a != null && e.this.f34772a.f34815e != null) {
                        jSONObject.put("duration", e.this.f34772a.f34815e.a());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                com.kwad.sdk.core.report.b.a(e.this.f34772a.f34813c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f34774c));
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34774c = aVar;
        com.kwad.sdk.splashscreen.c cVar = this.f34772a;
        aVar.f33622b = cVar.f34813c;
        aVar.f33621a = 0;
        AdBaseFrameLayout adBaseFrameLayout = cVar.f34814d;
        aVar.f33623c = adBaseFrameLayout;
        aVar.f33625e = adBaseFrameLayout;
        aVar.f33626f = this.f34773b;
        aVar.f33624d = null;
        aVar.f33628h = com.kwad.sdk.core.config.c.E();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        aq.a(this.f34773b).setAllowFileAccess(true);
        g gVar = new g(this.f34773b);
        this.f34775d = gVar;
        a(gVar);
        this.f34773b.addJavascriptInterface(this.f34775d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f34775d;
        if (gVar != null) {
            gVar.a();
            this.f34775d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f34772a = cVar;
        KsAdWebView ksAdWebView = (KsAdWebView) cVar.f34814d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f34773b = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f34773b.getBackground().setAlpha(0);
        this.f34773b.setVisibility(0);
        m();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        p();
    }

    public String e() {
        if (l() != null) {
            File d2 = com.kwad.sdk.core.config.c.d(l());
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

    public void m() {
        String e2 = e();
        if (TextUtils.isEmpty(e2)) {
            this.f34773b.setVisibility(8);
            return;
        }
        this.f34773b.setVisibility(0);
        n();
        o();
        this.f34773b.loadUrl(e2);
        this.f34773b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.e.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                e.this.f34773b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
