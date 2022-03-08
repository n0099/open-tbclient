package com.kwad.sdk.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class b {
    public View a;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f55547c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f55548d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f55549e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f55550f;

    /* renamed from: g  reason: collision with root package name */
    public int f55551g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f55552h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55553i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public b.c f55554j;
    public g k;
    public com.kwad.sdk.core.webview.a l;
    public s n;
    public int m = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55546b = false;
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
        this.f55550f = jSONObject;
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.l, this.f55553i, this.f55554j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.l, this.f55553i, this.f55554j));
        gVar.a(new f(this.l));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.l));
        gVar.a(new d(this.l));
        gVar.a(new p(this.p));
        s sVar = new s();
        this.n = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.l, this.f55553i));
        gVar.a(new i(this.o));
        gVar.a(new k(this.l));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h() {
        this.f55548d.removeAllViews();
        this.f55548d.setVisibility(4);
        this.a = com.kwad.sdk.a.kwai.a.a((ViewGroup) this.f55548d, a(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f55548d.findViewById(R.id.ksad_web_card_webView);
        this.f55549e = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.f55549e.getBackground().setAlpha(0);
        this.f55549e.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.i.b.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                b.this.f55546b = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                b.this.f55546b = true;
            }
        });
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.l = aVar;
        aVar.a(this.f55552h);
        com.kwad.sdk.core.webview.a aVar2 = this.l;
        aVar2.a = this.f55551g;
        aVar2.f54889b = this.f55547c;
        aVar2.f54891d = this.f55548d;
        aVar2.f54892e = this.f55549e;
        aVar2.f54890c = this.f55550f;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void j() {
        k();
        WebSettings a = be.a(this.f55549e);
        a.setAllowContentAccess(false);
        a.setAllowFileAccess(true);
        g gVar = new g(this.f55549e);
        this.k = gVar;
        a(gVar);
        this.f55549e.addJavascriptInterface(this.k, "KwaiAd");
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
        return com.kwad.sdk.core.response.a.b.g(this.f55552h);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.a.b bVar, int i2) {
        this.f55553i = bVar;
        this.f55547c = adBaseFrameLayout;
        this.f55548d = frameLayout;
        this.f55551g = i2;
        this.f55552h = adTemplate;
        h();
        i();
    }

    public void a(b.c cVar) {
        this.f55554j = cVar;
    }

    public void b() {
        this.f55548d.setVisibility(4);
        this.m = -1;
        String a = a(this.f55552h);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        j();
        this.f55549e.loadUrl(a);
    }

    public boolean c() {
        return this.m == 1;
    }

    public boolean d() {
        if (!c()) {
            FrameLayout frameLayout = this.f55548d;
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
        FrameLayout frameLayout2 = this.f55548d;
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
        if (bb.a(this.f55549e, 50, false)) {
            s sVar = this.n;
            if (sVar != null) {
                sVar.e();
            }
            this.f55548d.setVisibility(4);
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
