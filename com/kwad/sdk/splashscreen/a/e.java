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
    public com.kwad.sdk.splashscreen.c f34017a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f34018b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34019c;

    /* renamed from: d  reason: collision with root package name */
    public g f34020d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f34019c, this.f34017a.f34061f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.e.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0373a c0373a) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f34017a.f34056a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (e.this.f34017a != null && e.this.f34017a.f34060e != null) {
                        jSONObject.put("duration", e.this.f34017a.f34060e.a());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                com.kwad.sdk.core.report.b.a(e.this.f34017a.f34058c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f34019c));
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34019c = aVar;
        com.kwad.sdk.splashscreen.c cVar = this.f34017a;
        aVar.f32867b = cVar.f34058c;
        aVar.f32866a = 0;
        AdBaseFrameLayout adBaseFrameLayout = cVar.f34059d;
        aVar.f32868c = adBaseFrameLayout;
        aVar.f32870e = adBaseFrameLayout;
        aVar.f32871f = this.f34018b;
        aVar.f32869d = null;
        aVar.f32873h = com.kwad.sdk.core.config.c.E();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        aq.a(this.f34018b).setAllowFileAccess(true);
        g gVar = new g(this.f34018b);
        this.f34020d = gVar;
        a(gVar);
        this.f34018b.addJavascriptInterface(this.f34020d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f34020d;
        if (gVar != null) {
            gVar.a();
            this.f34020d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f34017a = cVar;
        KsAdWebView ksAdWebView = (KsAdWebView) cVar.f34059d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f34018b = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f34018b.getBackground().setAlpha(0);
        this.f34018b.setVisibility(0);
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
            this.f34018b.setVisibility(8);
            return;
        }
        this.f34018b.setVisibility(0);
        n();
        o();
        this.f34018b.loadUrl(e2);
        this.f34018b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.e.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                e.this.f34018b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
