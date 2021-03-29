package com.kwad.sdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.a.g;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.e;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ar;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f31864a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f31865b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f31866c;

    /* renamed from: d  reason: collision with root package name */
    public WebView f31867d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f31868e;

    /* renamed from: f  reason: collision with root package name */
    public int f31869f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f31870g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31871h;
    @Nullable
    public a.b i;
    public g j;
    public com.kwad.sdk.core.webview.a k;
    public n m;
    public int l = -1;
    public h.a n = new h.a() { // from class: com.kwad.sdk.c.c.1
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.h();
        }
    };
    public k.b o = new k.b() { // from class: com.kwad.sdk.c.c.2
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            c.this.l = i;
            com.kwad.sdk.core.d.a.b("PlayEndWebCard", "updatePageStatus mPageState: " + i);
        }
    };

    public c() {
    }

    public c(@Nullable JSONObject jSONObject) {
        this.f31868e = jSONObject;
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.f31871h, this.i));
        gVar.a(new e(this.k));
        gVar.a(new f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
        gVar.a(new k(this.o));
        n nVar = new n();
        this.m = nVar;
        gVar.a(nVar);
        gVar.a(new o(this.k, this.f31871h));
        gVar.a(new h(this.n));
        gVar.a(new j(this.k));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void j() {
        this.f31866c.removeAllViews();
        this.f31866c.setVisibility(4);
        this.f31864a = ao.a((ViewGroup) this.f31866c, a(), true);
        WebView webView = (WebView) this.f31866c.findViewById(R.id.ksad_web_card_webView);
        this.f31867d = webView;
        webView.setBackgroundColor(0);
        this.f31867d.getBackground().setAlpha(0);
    }

    private void k() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.k = aVar;
        aVar.f34286b = this.f31870g;
        aVar.f34285a = this.f31869f;
        aVar.f34287c = this.f31865b;
        aVar.f34289e = this.f31866c;
        aVar.f34290f = this.f31867d;
        aVar.f34288d = this.f31868e;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void l() {
        m();
        WebSettings a2 = ar.a(this.f31867d);
        a2.setAllowContentAccess(false);
        a2.setAllowFileAccess(true);
        g gVar = new g(this.f31867d);
        this.j = gVar;
        a(gVar);
        this.f31867d.addJavascriptInterface(this.j, "KwaiAd");
    }

    private void m() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.a();
            this.j = null;
        }
    }

    private void n() {
        int i = this.l;
        String str = i == -1 ? com.alipay.sdk.data.a.i : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    public int a() {
        return R.layout.ksad_ad_web_card_layout;
    }

    public String a(AdTemplate adTemplate) {
        String str = com.kwad.sdk.core.response.b.b.q(adTemplate).playEndInfo.adWebCardInfo.cardUrl;
        if (com.kwad.sdk.core.config.a.a(str)) {
            return str;
        }
        com.kwad.sdk.core.d.a.d("PlayEndWebCard", "url host is invalid: " + str);
        return null;
    }

    public void a(Activity activity) {
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.b.b bVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i) {
        this.f31871h = bVar;
        this.f31865b = adBaseFrameLayout;
        this.f31866c = frameLayout;
        this.f31869f = i;
        this.f31870g = adTemplate;
        j();
        k();
    }

    public void a(a.b bVar) {
        this.i = bVar;
    }

    public boolean b() {
        return this.l == 1;
    }

    public void c() {
        m();
    }

    public boolean d() {
        if (!b()) {
            n();
            return false;
        }
        n nVar = this.m;
        if (nVar != null) {
            nVar.c();
        }
        this.f31866c.setVisibility(0);
        n nVar2 = this.m;
        if (nVar2 != null) {
            nVar2.d();
            return true;
        }
        return true;
    }

    @Nullable
    public a.b e() {
        return this.i;
    }

    public WebView f() {
        return this.f31867d;
    }

    public void g() {
        this.f31866c.setVisibility(4);
        this.l = -1;
        String a2 = a(this.f31870g);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        l();
        this.f31867d.loadUrl(a2);
    }

    public void h() {
        if (ao.a((View) this.f31867d, 50, false)) {
            n nVar = this.m;
            if (nVar != null) {
                nVar.e();
            }
            this.f31866c.setVisibility(4);
            n nVar2 = this.m;
            if (nVar2 != null) {
                nVar2.f();
            }
        }
    }

    public void i() {
        m();
    }
}
