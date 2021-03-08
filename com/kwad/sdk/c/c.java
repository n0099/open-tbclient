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
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected View f5494a;
    private AdBaseFrameLayout b;
    private FrameLayout c;
    private WebView d;
    @Nullable
    private JSONObject e;
    private int f;
    private AdTemplate g;
    @Nullable
    private com.kwad.sdk.core.download.b.b h;
    @Nullable
    private a.b i;
    private g j;
    private com.kwad.sdk.core.webview.a k;
    private n m;
    private int l = -1;
    private h.a n = new h.a() { // from class: com.kwad.sdk.c.c.1
        @Override // com.kwad.sdk.core.webview.jshandler.h.a
        public void a() {
            c.this.h();
        }
    };
    private k.b o = new k.b() { // from class: com.kwad.sdk.c.c.2
        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i) {
            c.this.l = i;
            com.kwad.sdk.core.d.a.b("PlayEndWebCard", "updatePageStatus mPageState: " + i);
        }
    };

    public c() {
    }

    public c(@Nullable JSONObject jSONObject) {
        this.e = jSONObject;
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.k, this.h, this.i));
        gVar.a(new e(this.k));
        gVar.a(new f(this.k));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.c(this.k));
        gVar.a(new k(this.o));
        this.m = new n();
        gVar.a(this.m);
        gVar.a(new o(this.k, this.h));
        gVar.a(new h(this.n));
        gVar.a(new j(this.k));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void j() {
        this.c.removeAllViews();
        this.c.setVisibility(4);
        this.f5494a = ao.a((ViewGroup) this.c, a(), true);
        this.d = (WebView) this.c.findViewById(R.id.ksad_web_card_webView);
        this.d.setBackgroundColor(0);
        this.d.getBackground().setAlpha(0);
    }

    private void k() {
        this.k = new com.kwad.sdk.core.webview.a();
        this.k.b = this.g;
        this.k.f6320a = this.f;
        this.k.c = this.b;
        this.k.e = this.c;
        this.k.f = this.d;
        this.k.d = this.e;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void l() {
        m();
        WebSettings a2 = ar.a(this.d);
        a2.setAllowContentAccess(false);
        a2.setAllowFileAccess(true);
        this.j = new g(this.d);
        a(this.j);
        this.d.addJavascriptInterface(this.j, "KwaiAd");
    }

    private void m() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
    }

    private void n() {
        Log.w("PlayEndWebCard", "show webCard fail, reason: " + (this.l == -1 ? "timeout" : this.l != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS));
    }

    protected int a() {
        return R.layout.ksad_ad_web_card_layout;
    }

    protected String a(AdTemplate adTemplate) {
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
        this.h = bVar;
        this.b = adBaseFrameLayout;
        this.c = frameLayout;
        this.f = i;
        this.g = adTemplate;
        j();
        k();
    }

    public void a(a.b bVar) {
        this.i = bVar;
    }

    protected boolean b() {
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
        if (this.m != null) {
            this.m.c();
        }
        this.c.setVisibility(0);
        if (this.m != null) {
            this.m.d();
        }
        return true;
    }

    @Nullable
    public a.b e() {
        return this.i;
    }

    public WebView f() {
        return this.d;
    }

    public void g() {
        this.c.setVisibility(4);
        this.l = -1;
        String a2 = a(this.g);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        l();
        this.d.loadUrl(a2);
    }

    public void h() {
        if (ao.a((View) this.d, 50, false)) {
            if (this.m != null) {
                this.m.e();
            }
            this.c.setVisibility(4);
            if (this.m != null) {
                this.m.f();
            }
        }
    }

    public void i() {
        m();
    }
}
