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
    public com.kwad.sdk.splashscreen.c f33946a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f33947b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33948c;

    /* renamed from: d  reason: collision with root package name */
    public g f33949d;

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f33948c, this.f33946a.f33990f, new a.b() { // from class: com.kwad.sdk.splashscreen.a.e.2
            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0374a c0374a) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = e.this.f33946a.f33985a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (e.this.f33946a != null && e.this.f33946a.f33989e != null) {
                        jSONObject.put("duration", e.this.f33946a.f33989e.a());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                com.kwad.sdk.core.report.b.a(e.this.f33946a.f33987c, jSONObject, (String) null);
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f33948c));
    }

    private void n() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33948c = aVar;
        com.kwad.sdk.splashscreen.c cVar = this.f33946a;
        aVar.f32796b = cVar.f33987c;
        aVar.f32795a = 0;
        AdBaseFrameLayout adBaseFrameLayout = cVar.f33988d;
        aVar.f32797c = adBaseFrameLayout;
        aVar.f32799e = adBaseFrameLayout;
        aVar.f32800f = this.f33947b;
        aVar.f32798d = null;
        aVar.f32802h = com.kwad.sdk.core.config.c.E();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void o() {
        p();
        aq.a(this.f33947b).setAllowFileAccess(true);
        g gVar = new g(this.f33947b);
        this.f33949d = gVar;
        a(gVar);
        this.f33947b.addJavascriptInterface(this.f33949d, "KwaiAd");
    }

    private void p() {
        g gVar = this.f33949d;
        if (gVar != null) {
            gVar.a();
            this.f33949d = null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f33946a = cVar;
        KsAdWebView ksAdWebView = (KsAdWebView) cVar.f33988d.findViewById(R.id.ksad_splash_web_card_webView);
        this.f33947b = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f33947b.getBackground().setAlpha(0);
        this.f33947b.setVisibility(0);
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
            this.f33947b.setVisibility(8);
            return;
        }
        this.f33947b.setVisibility(0);
        n();
        o();
        this.f33947b.loadUrl(e2);
        this.f33947b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.e.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                e.this.f33947b.setVisibility(8);
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
