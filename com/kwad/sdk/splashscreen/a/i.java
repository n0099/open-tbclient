package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class i extends Presenter implements com.kwad.sdk.splashscreen.f {
    public static String a = "SplashWebViewPresenter";

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f57842b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f57843c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57844d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f57845e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c.a f57846f;

    /* renamed from: g  reason: collision with root package name */
    public ViewStub f57847g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f57848h = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f57846f != null) {
                i.this.f57846f.a();
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f57849i;

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new t(this.f57844d, this.f57842b.f57923g));
        gVar.a(t());
        gVar.a(s());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f57844d));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new p(new p.b() { // from class: com.kwad.sdk.splashscreen.a.i.3
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                String str = i.a;
                com.kwad.sdk.core.d.a.a(str, "updatePageStatus: " + aVar);
                if (aVar.a != 1) {
                    i.this.f57846f.a();
                    return;
                }
                ax.b(i.this.f57848h);
                com.kwad.sdk.core.report.a.c(i.this.f57842b.f57920d, 123, null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, @Nullable p.a aVar) {
        int i3;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f57842b.a;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        boolean z2 = aVar != null;
        boolean z3 = i2 == 1;
        com.kwad.sdk.core.download.a.a.a(new a.C2106a(this.f57842b.f57921e.getContext()).a(this.f57842b.f57920d).a(this.f57842b.f57923g).a(z3).a(i2).a(aVar).c(z2).a(new a.b() { // from class: com.kwad.sdk.splashscreen.a.i.6
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d2;
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(i.this.f57842b.f57920d)) || (d2 = i.this.f57842b.d()) == null) {
                    return;
                }
                i.this.f57842b.f57918b = true;
                i.this.f57842b.f57920d.mMiniWindowId = d2;
            }
        }));
        if (z2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f57842b != null) {
                if (this.f57842b.f57922f != null) {
                    jSONObject.put("duration", this.f57842b.f57922f.c());
                }
                if (z) {
                    i3 = 153;
                } else {
                    i3 = z3 ? 132 : 0;
                }
                com.kwad.sdk.core.report.a.a(this.f57842b.f57920d, i3, (z.a) null, jSONObject);
            }
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    private void h() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f57844d = aVar;
        aVar.a(this.f57842b.f57920d);
        com.kwad.sdk.core.webview.a aVar2 = this.f57844d;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f57842b.f57921e;
        aVar2.f56372b = adBaseFrameLayout;
        aVar2.f56374d = adBaseFrameLayout;
        aVar2.f56375e = this.f57843c;
        aVar2.f56373c = null;
        aVar2.f56378h = false;
        aVar2.f56379i = a(this.f57849i);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        r();
        be.a(this.f57843c).setAllowFileAccess(true);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57843c);
        this.f57845e = gVar;
        a(gVar);
        this.f57843c.addJavascriptInterface(this.f57845e, "KwaiAd");
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f57845e;
        if (gVar != null) {
            gVar.a();
            this.f57845e = null;
        }
    }

    private com.kwad.sdk.core.webview.jshandler.a s() {
        return new com.kwad.sdk.core.webview.jshandler.a(this.f57844d, this.f57842b.f57923g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.4
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (bb.a()) {
                    return;
                }
                if (aVar.a() || i.a(i.this.f57849i)) {
                    p.a aVar2 = new p.a();
                    aVar2.f56112h = aVar.f56406d.a;
                    i.this.a(false, aVar.f56405c, aVar2);
                }
            }
        });
    }

    private com.kwad.sdk.core.webview.jshandler.b t() {
        return new com.kwad.sdk.core.webview.jshandler.b(this.f57844d, this.f57842b.f57923g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.5
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (aVar.f56404b || !i.a(i.this.f57849i)) {
                    i.this.a(false, aVar.f56404b ? 1 : 3, null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.f57842b = gVar;
        this.f57843c = (KsAdWebView) gVar.f57921e.findViewById(R.id.ksad_splash_web_card_webView);
        this.f57847g = (ViewStub) this.f57842b.f57921e.findViewById(R.id.ksad_splash_actionbar_native_stub);
        this.f57849i = com.kwad.sdk.core.response.a.d.j(this.f57842b.f57920d);
        com.kwad.sdk.splashscreen.c.a aVar = new com.kwad.sdk.splashscreen.c.a(this.f57847g, this.f57843c, com.kwad.sdk.core.response.a.c.g(this.f57842b.f57920d), this.f57842b.f57923g);
        this.f57846f = aVar;
        aVar.a(this.f57842b.f57920d);
        this.f57846f.a(this);
        this.f57843c.setBackgroundColor(0);
        this.f57843c.getBackground().setAlpha(0);
        this.f57843c.setVisibility(0);
        f();
        ax.a(this.f57848h, null, 1000L);
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
        com.kwad.sdk.splashscreen.c.a aVar = this.f57846f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public String e() {
        if (q() != null) {
            File e2 = com.kwad.sdk.core.config.b.e(q());
            if (e2.exists()) {
                return Uri.fromFile(e2).toString();
            }
            if (com.kwad.sdk.core.config.b.a() != null) {
                return com.kwad.sdk.core.config.b.a().h5Url;
            }
            return null;
        }
        return null;
    }

    public void f() {
        String e2 = e();
        String str = a;
        com.kwad.sdk.core.d.a.a(str, "startPreloadWebView url: " + e2);
        if (at.a(e2)) {
            this.f57846f.a();
            return;
        }
        this.f57843c.setVisibility(0);
        h();
        i();
        this.f57843c.loadUrl(e2);
        this.f57843c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.i.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str2, String str3) {
                i.this.f57846f.a();
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
