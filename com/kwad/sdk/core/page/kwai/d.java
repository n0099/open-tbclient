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
/* loaded from: classes7.dex */
public class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f39634b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f39635c;

    /* renamed from: d  reason: collision with root package name */
    public int f39636d = -1;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f39637e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f39638f;

    /* renamed from: g  reason: collision with root package name */
    public final a f39639g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i);
    }

    public d(a aVar) {
        this.f39639g = aVar;
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        com.kwad.sdk.core.d.a.a("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((g) this).a.f40747g);
        gVar.a(new f(this.f39634b));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f39634b));
        gVar.a(new t(this.f39634b, bVar));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f39634b));
        gVar.a(new s());
        gVar.a(new p(t()));
        gVar.a(new k(this.f39634b));
        gVar.a(new o(u()));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f39634b, bVar, null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f39634b, bVar, (b.c) null));
    }

    private void i() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f39634b = aVar;
        aVar.a(((g) this).a.f40747g);
        com.kwad.sdk.core.webview.a aVar2 = this.f39634b;
        aVar2.a = ((g) this).a.f40746f;
        aVar2.f39983d = this.f39638f;
        aVar2.f39984e = this.f39635c;
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
        be.b(this.f39635c);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f39635c);
        this.f39637e = gVar;
        a(gVar);
        this.f39635c.addJavascriptInterface(this.f39637e, "KwaiAd");
    }

    private p.b t() {
        return new p.b() { // from class: com.kwad.sdk.core.page.kwai.d.1
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                d.this.f39636d = aVar.a;
                if (d.this.f39639g != null) {
                    d.this.f39639g.a(aVar.a);
                }
                if (aVar.a == 1) {
                    d.this.f39638f.setVisibility(0);
                } else {
                    d.this.f39635c.setVisibility(8);
                }
            }
        };
    }

    private o.a u() {
        return new o.a() { // from class: com.kwad.sdk.core.page.kwai.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(i iVar) {
                AdWebViewActivityProxy.launch(d.this.f39635c.getContext(), new AdWebViewActivityProxy.a.C1963a().a(iVar.f40130b).b(iVar.a).a(((g) d.this).a.f40747g).a());
            }
        };
    }

    private void v() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f39637e;
        if (gVar != null) {
            gVar.a();
            this.f39637e = null;
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
        this.f39635c = (WebView) a(R.id.obfuscated_res_0x7f0910b4);
        this.f39638f = (ViewGroup) a(R.id.obfuscated_res_0x7f091189);
        this.f39635c.setBackgroundColor(0);
    }

    public void e() {
        s();
        if (!TextUtils.isEmpty(r())) {
            this.f39635c.loadUrl(r());
            return;
        }
        a aVar = this.f39639g;
        if (aVar != null) {
            aVar.a(this.f39636d);
        }
    }
}
