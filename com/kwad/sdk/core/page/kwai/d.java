package com.kwad.sdk.core.page.kwai;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.kwai.i;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.be;
import java.io.File;
/* loaded from: classes3.dex */
public class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f58151b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f58152c;

    /* renamed from: d  reason: collision with root package name */
    public int f58153d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f58154e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f58155f;

    /* renamed from: g  reason: collision with root package name */
    public final a f58156g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public d(a aVar) {
        this.f58156g = aVar;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        com.kwad.sdk.core.d.a.a("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((g) this).a.f59455g);
        gVar.a(new f(this.f58151b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f58151b));
        gVar.a(new t(this.f58151b, bVar));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f58151b));
        gVar.a(new s());
        gVar.a(new p(t()));
        gVar.a(new k(this.f58151b));
        gVar.a(new o(u()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f58151b, bVar, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f58151b, bVar, (b.c) null));
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f58151b = aVar;
        aVar.a(((g) this).a.f59455g);
        com.kwad.sdk.core.webview.a aVar2 = this.f58151b;
        aVar2.a = ((g) this).a.f59454f;
        aVar2.f58538d = this.f58155f;
        aVar2.f58539e = this.f58152c;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String r() {
        String str;
        if (q() != null) {
            File i2 = com.kwad.sdk.core.config.b.i(q());
            if (i2.exists()) {
                str = Uri.fromFile(i2).toString();
            } else if (com.kwad.sdk.core.config.b.e() != null) {
                str = com.kwad.sdk.core.config.b.e().h5Url;
            }
            return str != null ? "" : str;
        }
        str = null;
        if (str != null) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void s() {
        v();
        be.b(this.f58152c);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f58152c);
        this.f58154e = gVar;
        a(gVar);
        this.f58152c.addJavascriptInterface(this.f58154e, "KwaiAd");
    }

    private p.b t() {
        return new p.b() { // from class: com.kwad.sdk.core.page.kwai.d.1
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                d.this.f58153d = aVar.a;
                if (d.this.f58156g != null) {
                    d.this.f58156g.a(aVar.a);
                }
                if (aVar.a == 1) {
                    d.this.f58155f.setVisibility(0);
                } else {
                    d.this.f58152c.setVisibility(8);
                }
            }
        };
    }

    private o.a u() {
        return new o.a() { // from class: com.kwad.sdk.core.page.kwai.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(i iVar) {
                AdWebViewActivityProxy.launch(d.this.f58152c.getContext(), new AdWebViewActivityProxy.a.C2090a().a(iVar.f58694b).b(iVar.a).a(((g) d.this).a.f59455g).a());
            }
        };
    }

    private void v() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f58154e;
        if (gVar != null) {
            gVar.a();
            this.f58154e = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        i();
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        v();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f58152c = (WebView) a(R.id.ksad_landing_page_webview);
        this.f58155f = (ViewGroup) a(R.id.ksad_web_card_container);
        this.f58152c.setBackgroundColor(0);
    }

    public void e() {
        s();
        if (!TextUtils.isEmpty(r())) {
            this.f58152c.loadUrl(r());
            return;
        }
        a aVar = this.f58156g;
        if (aVar != null) {
            aVar.a(this.f58153d);
        }
    }
}
