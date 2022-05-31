package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.z;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i extends Presenter implements com.kwad.sdk.splashscreen.f {
    public static String a = "SplashWebViewPresenter";
    public com.kwad.sdk.splashscreen.g b;
    public KsAdWebView c;
    public com.kwad.sdk.core.webview.a d;
    public com.kwad.sdk.core.webview.kwai.g e;
    public com.kwad.sdk.splashscreen.c.a f;
    public ViewStub g;
    public Runnable h = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f != null) {
                i.this.f.a();
            }
        }
    };
    public AdInfo i;

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new t(this.d, this.b.g));
        gVar.a(t());
        gVar.a(s());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.d));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new p(new p.b() { // from class: com.kwad.sdk.splashscreen.a.i.3
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                String str = i.a;
                com.kwad.sdk.core.d.a.a(str, "updatePageStatus: " + aVar);
                if (aVar.a != 1) {
                    i.this.f.a();
                    return;
                }
                ax.b(i.this.h);
                com.kwad.sdk.core.report.a.c(i.this.b.d, 123, null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, @Nullable p.a aVar) {
        int i2;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.b.a;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        boolean z2 = aVar != null;
        boolean z3 = i == 1;
        com.kwad.sdk.core.download.a.a.a(new a.C0296a(this.b.e.getContext()).a(this.b.d).a(this.b.g).a(z3).a(i).a(aVar).c(z2).a(new a.b() { // from class: com.kwad.sdk.splashscreen.a.i.6
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d;
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(i.this.b.d)) || (d = i.this.b.d()) == null) {
                    return;
                }
                i.this.b.b = true;
                i.this.b.d.mMiniWindowId = d;
            }
        }));
        if (z2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.b != null) {
                if (this.b.f != null) {
                    jSONObject.put("duration", this.b.f.c());
                }
                if (z) {
                    i2 = 153;
                } else {
                    i2 = z3 ? 132 : 0;
                }
                com.kwad.sdk.core.report.a.a(this.b.d, i2, (z.a) null, jSONObject);
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    private void h() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.d = aVar;
        aVar.a(this.b.d);
        com.kwad.sdk.core.webview.a aVar2 = this.d;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.b.e;
        aVar2.b = adBaseFrameLayout;
        aVar2.d = adBaseFrameLayout;
        aVar2.e = this.c;
        aVar2.c = null;
        aVar2.h = false;
        aVar2.i = a(this.i);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        r();
        be.a(this.c).setAllowFileAccess(true);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.c);
        this.e = gVar;
        a(gVar);
        this.c.addJavascriptInterface(this.e, "KwaiAd");
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.e;
        if (gVar != null) {
            gVar.a();
            this.e = null;
        }
    }

    private com.kwad.sdk.core.webview.jshandler.a s() {
        return new com.kwad.sdk.core.webview.jshandler.a(this.d, this.b.g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.4
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (bb.a()) {
                    return;
                }
                if (aVar.a() || i.a(i.this.i)) {
                    p.a aVar2 = new p.a();
                    aVar2.h = aVar.d.a;
                    i.this.a(false, aVar.c, aVar2);
                }
            }
        });
    }

    private com.kwad.sdk.core.webview.jshandler.b t() {
        return new com.kwad.sdk.core.webview.jshandler.b(this.d, this.b.g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.5
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (aVar.b || !i.a(i.this.i)) {
                    i.this.a(false, aVar.b ? 1 : 3, null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.b = gVar;
        this.c = (KsAdWebView) gVar.e.findViewById(R.id.obfuscated_res_0x7f091118);
        this.g = (ViewStub) this.b.e.findViewById(R.id.obfuscated_res_0x7f09110a);
        this.i = com.kwad.sdk.core.response.a.d.j(this.b.d);
        com.kwad.sdk.splashscreen.c.a aVar = new com.kwad.sdk.splashscreen.c.a(this.g, this.c, com.kwad.sdk.core.response.a.c.g(this.b.d), this.b.g);
        this.f = aVar;
        aVar.a(this.b.d);
        this.f.a(this);
        this.c.setBackgroundColor(0);
        this.c.getBackground().setAlpha(0);
        this.c.setVisibility(0);
        f();
        ax.a(this.h, null, 1000L);
    }

    @Override // com.kwad.sdk.splashscreen.f
    public void a(boolean z, boolean z2) {
        String str = a;
        com.kwad.sdk.core.d.a.a(str, "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        r();
        com.kwad.sdk.splashscreen.c.a aVar = this.f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public String e() {
        if (q() != null) {
            File e = com.kwad.sdk.core.config.b.e(q());
            if (e.exists()) {
                return Uri.fromFile(e).toString();
            }
            if (com.kwad.sdk.core.config.b.a() != null) {
                return com.kwad.sdk.core.config.b.a().h5Url;
            }
            return null;
        }
        return null;
    }

    public void f() {
        String e = e();
        String str = a;
        com.kwad.sdk.core.d.a.a(str, "startPreloadWebView url: " + e);
        if (at.a(e)) {
            this.f.a();
            return;
        }
        this.c.setVisibility(0);
        h();
        i();
        this.c.loadUrl(e);
        this.c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.i.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str2, String str3) {
                i.this.f.a();
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
