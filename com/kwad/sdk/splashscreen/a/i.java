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
/* loaded from: classes8.dex */
public class i extends Presenter implements com.kwad.sdk.splashscreen.f {
    public static String a = "SplashWebViewPresenter";

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f56359b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f56360c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f56361d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f56362e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c.a f56363f;

    /* renamed from: g  reason: collision with root package name */
    public ViewStub f56364g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f56365h = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f56363f != null) {
                i.this.f56363f.a();
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f56366i;

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new t(this.f56361d, this.f56359b.f56440g));
        gVar.a(t());
        gVar.a(s());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f56361d));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new p(new p.b() { // from class: com.kwad.sdk.splashscreen.a.i.3
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                String str = i.a;
                com.kwad.sdk.core.d.a.a(str, "updatePageStatus: " + aVar);
                if (aVar.a != 1) {
                    i.this.f56363f.a();
                    return;
                }
                ax.b(i.this.f56365h);
                com.kwad.sdk.core.report.a.c(i.this.f56359b.f56437d, 123, null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, @Nullable p.a aVar) {
        int i3;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f56359b.a;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        boolean z2 = aVar != null;
        boolean z3 = i2 == 1;
        com.kwad.sdk.core.download.a.a.a(new a.C2095a(this.f56359b.f56438e.getContext()).a(this.f56359b.f56437d).a(this.f56359b.f56440g).a(z3).a(i2).a(aVar).c(z2).a(new a.b() { // from class: com.kwad.sdk.splashscreen.a.i.6
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d2;
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(i.this.f56359b.f56437d)) || (d2 = i.this.f56359b.d()) == null) {
                    return;
                }
                i.this.f56359b.f56435b = true;
                i.this.f56359b.f56437d.mMiniWindowId = d2;
            }
        }));
        if (z2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f56359b != null) {
                if (this.f56359b.f56439f != null) {
                    jSONObject.put("duration", this.f56359b.f56439f.c());
                }
                if (z) {
                    i3 = 153;
                } else {
                    i3 = z3 ? 132 : 0;
                }
                com.kwad.sdk.core.report.a.a(this.f56359b.f56437d, i3, (z.a) null, jSONObject);
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
        this.f56361d = aVar;
        aVar.a(this.f56359b.f56437d);
        com.kwad.sdk.core.webview.a aVar2 = this.f56361d;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f56359b.f56438e;
        aVar2.f54889b = adBaseFrameLayout;
        aVar2.f54891d = adBaseFrameLayout;
        aVar2.f54892e = this.f56360c;
        aVar2.f54890c = null;
        aVar2.f54895h = false;
        aVar2.f54896i = a(this.f56366i);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        r();
        be.a(this.f56360c).setAllowFileAccess(true);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f56360c);
        this.f56362e = gVar;
        a(gVar);
        this.f56360c.addJavascriptInterface(this.f56362e, "KwaiAd");
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f56362e;
        if (gVar != null) {
            gVar.a();
            this.f56362e = null;
        }
    }

    private com.kwad.sdk.core.webview.jshandler.a s() {
        return new com.kwad.sdk.core.webview.jshandler.a(this.f56361d, this.f56359b.f56440g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.4
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (bb.a()) {
                    return;
                }
                if (aVar.a() || i.a(i.this.f56366i)) {
                    p.a aVar2 = new p.a();
                    aVar2.f54629h = aVar.f54923d.a;
                    i.this.a(false, aVar.f54922c, aVar2);
                }
            }
        });
    }

    private com.kwad.sdk.core.webview.jshandler.b t() {
        return new com.kwad.sdk.core.webview.jshandler.b(this.f56361d, this.f56359b.f56440g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.5
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (aVar.f54921b || !i.a(i.this.f56366i)) {
                    i.this.a(false, aVar.f54921b ? 1 : 3, null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.f56359b = gVar;
        this.f56360c = (KsAdWebView) gVar.f56438e.findViewById(R.id.ksad_splash_web_card_webView);
        this.f56364g = (ViewStub) this.f56359b.f56438e.findViewById(R.id.ksad_splash_actionbar_native_stub);
        this.f56366i = com.kwad.sdk.core.response.a.d.j(this.f56359b.f56437d);
        com.kwad.sdk.splashscreen.c.a aVar = new com.kwad.sdk.splashscreen.c.a(this.f56364g, this.f56360c, com.kwad.sdk.core.response.a.c.g(this.f56359b.f56437d), this.f56359b.f56440g);
        this.f56363f = aVar;
        aVar.a(this.f56359b.f56437d);
        this.f56363f.a(this);
        this.f56360c.setBackgroundColor(0);
        this.f56360c.getBackground().setAlpha(0);
        this.f56360c.setVisibility(0);
        f();
        ax.a(this.f56365h, null, 1000L);
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
        com.kwad.sdk.splashscreen.c.a aVar = this.f56363f;
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
            this.f56363f.a();
            return;
        }
        this.f56360c.setVisibility(0);
        h();
        i();
        this.f56360c.loadUrl(e2);
        this.f56360c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.i.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str2, String str3) {
                i.this.f56363f.a();
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
