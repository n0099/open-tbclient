package com.kwad.sdk.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public View a;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f57030c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f57031d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f57032e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f57033f;

    /* renamed from: g  reason: collision with root package name */
    public int f57034g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f57035h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57036i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public b.c f57037j;
    public g k;
    public com.kwad.sdk.core.webview.a l;
    public s n;
    public int m = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57029b = false;
    public i.b o = new i.b() { // from class: com.kwad.sdk.i.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i2) {
            b.this.e();
        }
    };
    public p.b p = new p.b() { // from class: com.kwad.sdk.i.b.3
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            b.this.m = aVar.a;
            com.kwad.sdk.core.d.a.c("PlayEndWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    public b() {
    }

    public b(@Nullable JSONObject jSONObject) {
        this.f57033f = jSONObject;
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.l, this.f57036i, this.f57037j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.l, this.f57036i, this.f57037j));
        gVar.a(new f(this.l));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.l));
        gVar.a(new d(this.l));
        gVar.a(new p(this.p));
        s sVar = new s();
        this.n = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.l, this.f57036i));
        gVar.a(new i(this.o));
        gVar.a(new k(this.l));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h() {
        this.f57031d.removeAllViews();
        this.f57031d.setVisibility(4);
        this.a = com.kwad.sdk.a.kwai.a.a((ViewGroup) this.f57031d, a(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f57031d.findViewById(R.id.ksad_web_card_webView);
        this.f57032e = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f57032e.getBackground().setAlpha(0);
        this.f57032e.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.i.b.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                b.this.f57029b = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                b.this.f57029b = true;
            }
        });
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.l = aVar;
        aVar.a(this.f57035h);
        com.kwad.sdk.core.webview.a aVar2 = this.l;
        aVar2.a = this.f57034g;
        aVar2.f56372b = this.f57030c;
        aVar2.f56374d = this.f57031d;
        aVar2.f56375e = this.f57032e;
        aVar2.f56373c = this.f57033f;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void j() {
        k();
        WebSettings a = be.a(this.f57032e);
        a.setAllowContentAccess(false);
        a.setAllowFileAccess(true);
        g gVar = new g(this.f57032e);
        this.k = gVar;
        a(gVar);
        this.f57032e.addJavascriptInterface(this.k, "KwaiAd");
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
        String str = "show webCard fail, reason: " + (i2 == -1 ? com.alipay.sdk.data.a.O : i2 != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
    }

    public int a() {
        return R.layout.ksad_ad_web_card_layout;
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.b.g(this.f57035h);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.a.b bVar, int i2) {
        this.f57036i = bVar;
        this.f57030c = adBaseFrameLayout;
        this.f57031d = frameLayout;
        this.f57034g = i2;
        this.f57035h = adTemplate;
        h();
        i();
    }

    public void a(b.c cVar) {
        this.f57037j = cVar;
    }

    public void b() {
        this.f57031d.setVisibility(4);
        this.m = -1;
        String a = a(this.f57035h);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        j();
        this.f57032e.loadUrl(a);
    }

    public boolean c() {
        return this.m == 1;
    }

    public boolean d() {
        if (!c()) {
            FrameLayout frameLayout = this.f57031d;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            l();
            return false;
        }
        s sVar = this.n;
        if (sVar != null) {
            sVar.c();
        }
        FrameLayout frameLayout2 = this.f57031d;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        s sVar2 = this.n;
        if (sVar2 != null) {
            sVar2.d();
            return true;
        }
        return true;
    }

    public void e() {
        if (bb.a(this.f57032e, 50, false)) {
            s sVar = this.n;
            if (sVar != null) {
                sVar.e();
            }
            this.f57031d.setVisibility(4);
            s sVar2 = this.n;
            if (sVar2 != null) {
                sVar2.f();
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
