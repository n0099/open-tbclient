package com.kwad.sdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.aq;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f31839a;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f31841c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f31842d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f31843e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f31844f;

    /* renamed from: g  reason: collision with root package name */
    public int f31845g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f31846h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31847i;
    @Nullable
    public a.b j;
    public g k;
    public com.kwad.sdk.core.webview.a l;
    public m n;
    public int m = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31840b = false;
    public h.a o = new h.a() { // from class: com.kwad.sdk.c.c.2
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.e();
        }
    };
    public k.b p = new k.b() { // from class: com.kwad.sdk.c.c.3
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            c.this.m = i2;
            com.kwad.sdk.core.d.a.c("PlayEndWebCard", "updatePageStatus mPageState: " + i2);
        }
    };

    public c() {
    }

    public c(@Nullable JSONObject jSONObject) {
        this.f31844f = jSONObject;
    }

    private void a(g gVar) {
        gVar.a(new d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.l, this.f31847i, this.j));
        gVar.a(new e(this.l));
        gVar.a(new f(this.l));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.l));
        gVar.a(new k(this.p));
        m mVar = new m();
        this.n = mVar;
        gVar.a(mVar);
        gVar.a(new n(this.l, this.f31847i));
        gVar.a(new h(this.o));
        gVar.a(new j(this.l));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h() {
        this.f31842d.removeAllViews();
        this.f31842d.setVisibility(4);
        this.f31839a = an.a((ViewGroup) this.f31842d, b(), true);
        WebView webView = (WebView) this.f31842d.findViewById(R.id.ksad_web_card_webView);
        this.f31843e = webView;
        webView.setBackgroundColor(0);
        this.f31843e.getBackground().setAlpha(0);
        this.f31843e.setWebViewClient(new WebViewClient() { // from class: com.kwad.sdk.c.c.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                c.this.f31840b = true;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                c.this.f31840b = false;
            }
        });
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.l = aVar;
        aVar.f32796b = this.f31846h;
        aVar.f32795a = this.f31845g;
        aVar.f32797c = this.f31841c;
        aVar.f32799e = this.f31842d;
        aVar.f32800f = this.f31843e;
        aVar.f32798d = this.f31844f;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void j() {
        k();
        WebSettings a2 = aq.a(this.f31843e);
        a2.setAllowContentAccess(false);
        a2.setAllowFileAccess(true);
        g gVar = new g(this.f31843e);
        this.k = gVar;
        a(gVar);
        this.f31843e.addJavascriptInterface(this.k, "KwaiAd");
    }

    private void k() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.a();
            this.k = null;
        }
    }

    private void l() {
        int i2 = this.m;
        String str = i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    public String a(AdTemplate adTemplate) {
        String str = com.kwad.sdk.core.response.b.b.k(adTemplate).playEndInfo.adWebCardInfo.cardUrl;
        if (com.kwad.sdk.core.config.a.a(str)) {
            return str;
        }
        com.kwad.sdk.core.d.a.e("PlayEndWebCard", "url host is invalid: " + str);
        return null;
    }

    public void a(Activity activity) {
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i2) {
        this.f31847i = bVar;
        this.f31841c = adBaseFrameLayout;
        this.f31842d = frameLayout;
        this.f31845g = i2;
        this.f31846h = adTemplate;
        h();
        i();
    }

    public void a(a.b bVar) {
        this.j = bVar;
    }

    public boolean a() {
        return this.m == 1;
    }

    public int b() {
        return R.layout.ksad_ad_web_card_layout;
    }

    public void c() {
        this.f31842d.setVisibility(4);
        this.m = -1;
        String a2 = a(this.f31846h);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        j();
        this.f31843e.loadUrl(a2);
    }

    public boolean d() {
        if (!a()) {
            FrameLayout frameLayout = this.f31842d;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            l();
            return false;
        }
        m mVar = this.n;
        if (mVar != null) {
            mVar.c();
        }
        FrameLayout frameLayout2 = this.f31842d;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        m mVar2 = this.n;
        if (mVar2 != null) {
            mVar2.d();
            return true;
        }
        return true;
    }

    public void e() {
        if (an.a((View) this.f31843e, 50, false)) {
            m mVar = this.n;
            if (mVar != null) {
                mVar.e();
            }
            this.f31842d.setVisibility(4);
            m mVar2 = this.n;
            if (mVar2 != null) {
                mVar2.f();
            }
        }
    }

    public void f() {
        k();
    }

    public void g() {
        k();
    }
}
