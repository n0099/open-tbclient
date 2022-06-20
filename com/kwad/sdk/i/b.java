package com.kwad.sdk.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes5.dex */
public class b {
    public View a;
    public AdBaseFrameLayout c;
    public FrameLayout d;
    public KsAdWebView e;
    @Nullable
    public JSONObject f;
    public int g;
    public AdTemplate h;
    @Nullable
    public com.kwad.sdk.core.download.a.b i;
    @Nullable
    public b.c j;
    public g k;
    public com.kwad.sdk.core.webview.a l;
    public s n;
    public int m = -1;
    public boolean b = false;
    public i.b o = new i.b() { // from class: com.kwad.sdk.i.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.i.b
        public void a(int i) {
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
        this.f = jSONObject;
    }

    private void a(g gVar) {
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.l, this.i, this.j));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.l, this.i, this.j));
        gVar.a(new f(this.l));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.l));
        gVar.a(new d(this.l));
        gVar.a(new p(this.p));
        s sVar = new s();
        this.n = sVar;
        gVar.a(sVar);
        gVar.a(new t(this.l, this.i));
        gVar.a(new i(this.o));
        gVar.a(new k(this.l));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h() {
        this.d.removeAllViews();
        this.d.setVisibility(4);
        this.a = com.kwad.sdk.a.kwai.a.a((ViewGroup) this.d, a(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.d.findViewById(R.id.obfuscated_res_0x7f091146);
        this.e = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.e.getBackground().setAlpha(0);
        this.e.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.i.b.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str, String str2) {
                b.this.b = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                b.this.b = true;
            }
        });
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.l = aVar;
        aVar.a(this.h);
        com.kwad.sdk.core.webview.a aVar2 = this.l;
        aVar2.a = this.g;
        aVar2.b = this.c;
        aVar2.d = this.d;
        aVar2.e = this.e;
        aVar2.c = this.f;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void j() {
        k();
        WebSettings a = be.a(this.e);
        a.setAllowContentAccess(false);
        a.setAllowFileAccess(true);
        g gVar = new g(this.e);
        this.k = gVar;
        a(gVar);
        this.e.addJavascriptInterface(this.k, "KwaiAd");
    }

    private void k() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.a();
            this.k = null;
        }
    }

    private void l() {
        int i = this.m;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        Log.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    public int a() {
        return R.layout.obfuscated_res_0x7f0d0401;
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.b.g(this.h);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.download.a.b bVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.a.b bVar, int i) {
        this.i = bVar;
        this.c = adBaseFrameLayout;
        this.d = frameLayout;
        this.g = i;
        this.h = adTemplate;
        h();
        i();
    }

    public void a(b.c cVar) {
        this.j = cVar;
    }

    public void b() {
        this.d.setVisibility(4);
        this.m = -1;
        String a = a(this.h);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        j();
        this.e.loadUrl(a);
    }

    public boolean c() {
        return this.m == 1;
    }

    public boolean d() {
        if (!c()) {
            FrameLayout frameLayout = this.d;
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
        FrameLayout frameLayout2 = this.d;
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
        if (bb.a(this.e, 50, false)) {
            s sVar = this.n;
            if (sVar != null) {
                sVar.e();
            }
            this.d.setVisibility(4);
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
