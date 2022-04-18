package com.kwad.sdk.core.page.kwai;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class d extends g {
    public com.kwad.sdk.core.webview.a b;
    public WebView c;
    public int d = -1;
    public com.kwad.sdk.core.webview.kwai.g e;
    public ViewGroup f;
    public final a g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public d(a aVar) {
        this.g = aVar;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        com.kwad.sdk.core.d.a.a("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((g) this).a.g);
        gVar.a(new f(this.b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.b));
        gVar.a(new t(this.b, bVar));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.b));
        gVar.a(new s());
        gVar.a(new p(t()));
        gVar.a(new k(this.b));
        gVar.a(new o(u()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.b, bVar, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.b, bVar, (b.c) null));
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.b = aVar;
        aVar.a(((g) this).a.g);
        com.kwad.sdk.core.webview.a aVar2 = this.b;
        aVar2.a = ((g) this).a.f;
        aVar2.d = this.f;
        aVar2.e = this.c;
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
            File i = com.kwad.sdk.core.config.b.i(q());
            if (i.exists()) {
                str = Uri.fromFile(i).toString();
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
        be.b(this.c);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.c);
        this.e = gVar;
        a(gVar);
        this.c.addJavascriptInterface(this.e, "KwaiAd");
    }

    private p.b t() {
        return new p.b() { // from class: com.kwad.sdk.core.page.kwai.d.1
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                d.this.d = aVar.a;
                if (d.this.g != null) {
                    d.this.g.a(aVar.a);
                }
                if (aVar.a == 1) {
                    d.this.f.setVisibility(0);
                } else {
                    d.this.c.setVisibility(8);
                }
            }
        };
    }

    private o.a u() {
        return new o.a() { // from class: com.kwad.sdk.core.page.kwai.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(i iVar) {
                AdWebViewActivityProxy.launch(d.this.c.getContext(), new AdWebViewActivityProxy.a.C0303a().a(iVar.b).b(iVar.a).a(((g) d.this).a.g).a());
            }
        };
    }

    private void v() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.e;
        if (gVar != null) {
            gVar.a();
            this.e = null;
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
        this.c = (WebView) a(R.id.obfuscated_res_0x7f0910ae);
        this.f = (ViewGroup) a(R.id.obfuscated_res_0x7f091183);
        this.c.setBackgroundColor(0);
    }

    public void e() {
        s();
        if (!TextUtils.isEmpty(r())) {
            this.c.loadUrl(r());
            return;
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this.d);
        }
    }
}
