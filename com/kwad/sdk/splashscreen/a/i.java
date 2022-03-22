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
/* loaded from: classes7.dex */
public class i extends Presenter implements com.kwad.sdk.splashscreen.f {
    public static String a = "SplashWebViewPresenter";

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f41263b;

    /* renamed from: c  reason: collision with root package name */
    public KsAdWebView f41264c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f41265d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f41266e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c.a f41267f;

    /* renamed from: g  reason: collision with root package name */
    public ViewStub f41268g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f41269h = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f41267f != null) {
                i.this.f41267f.a();
            }
        }
    };
    public AdInfo i;

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(new t(this.f41265d, this.f41263b.f41333g));
        gVar.a(t());
        gVar.a(s());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f41265d));
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(new p(new p.b() { // from class: com.kwad.sdk.splashscreen.a.i.3
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar) {
                String str = i.a;
                com.kwad.sdk.core.d.a.a(str, "updatePageStatus: " + aVar);
                if (aVar.a != 1) {
                    i.this.f41267f.a();
                    return;
                }
                ax.b(i.this.f41269h);
                com.kwad.sdk.core.report.a.c(i.this.f41263b.f41330d, 123, null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, @Nullable p.a aVar) {
        int i2;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f41263b.a;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        boolean z2 = aVar != null;
        boolean z3 = i == 1;
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(this.f41263b.f41331e.getContext()).a(this.f41263b.f41330d).a(this.f41263b.f41333g).a(z3).a(i).a(aVar).c(z2).a(new a.b() { // from class: com.kwad.sdk.splashscreen.a.i.6
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                String d2;
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(i.this.f41263b.f41330d)) || (d2 = i.this.f41263b.d()) == null) {
                    return;
                }
                i.this.f41263b.f41328b = true;
                i.this.f41263b.f41330d.mMiniWindowId = d2;
            }
        }));
        if (z2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f41263b != null) {
                if (this.f41263b.f41332f != null) {
                    jSONObject.put("duration", this.f41263b.f41332f.c());
                }
                if (z) {
                    i2 = 153;
                } else {
                    i2 = z3 ? 132 : 0;
                }
                com.kwad.sdk.core.report.a.a(this.f41263b.f41330d, i2, (z.a) null, jSONObject);
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
        this.f41265d = aVar;
        aVar.a(this.f41263b.f41330d);
        com.kwad.sdk.core.webview.a aVar2 = this.f41265d;
        aVar2.a = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f41263b.f41331e;
        aVar2.f39981b = adBaseFrameLayout;
        aVar2.f39983d = adBaseFrameLayout;
        aVar2.f39984e = this.f41264c;
        aVar2.f39982c = null;
        aVar2.f39987h = false;
        aVar2.i = a(this.i);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void i() {
        r();
        be.a(this.f41264c).setAllowFileAccess(true);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f41264c);
        this.f41266e = gVar;
        a(gVar);
        this.f41264c.addJavascriptInterface(this.f41266e, "KwaiAd");
    }

    private void r() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f41266e;
        if (gVar != null) {
            gVar.a();
            this.f41266e = null;
        }
    }

    private com.kwad.sdk.core.webview.jshandler.a s() {
        return new com.kwad.sdk.core.webview.jshandler.a(this.f41265d, this.f41263b.f41333g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.4
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (bb.a()) {
                    return;
                }
                if (aVar.a() || i.a(i.this.i)) {
                    p.a aVar2 = new p.a();
                    aVar2.f39738h = aVar.f40013d.a;
                    i.this.a(false, aVar.f40012c, aVar2);
                }
            }
        });
    }

    private com.kwad.sdk.core.webview.jshandler.b t() {
        return new com.kwad.sdk.core.webview.jshandler.b(this.f41265d, this.f41263b.f41333g, new b.c() { // from class: com.kwad.sdk.splashscreen.a.i.5
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (aVar.f40011b || !i.a(i.this.i)) {
                    i.this.a(false, aVar.f40011b ? 1 : 3, null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.f41263b = gVar;
        this.f41264c = (KsAdWebView) gVar.f41331e.findViewById(R.id.obfuscated_res_0x7f09114d);
        this.f41268g = (ViewStub) this.f41263b.f41331e.findViewById(R.id.obfuscated_res_0x7f09113f);
        this.i = com.kwad.sdk.core.response.a.d.j(this.f41263b.f41330d);
        com.kwad.sdk.splashscreen.c.a aVar = new com.kwad.sdk.splashscreen.c.a(this.f41268g, this.f41264c, com.kwad.sdk.core.response.a.c.g(this.f41263b.f41330d), this.f41263b.f41333g);
        this.f41267f = aVar;
        aVar.a(this.f41263b.f41330d);
        this.f41267f.a(this);
        this.f41264c.setBackgroundColor(0);
        this.f41264c.getBackground().setAlpha(0);
        this.f41264c.setVisibility(0);
        f();
        ax.a(this.f41269h, null, 1000L);
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
        com.kwad.sdk.splashscreen.c.a aVar = this.f41267f;
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
            this.f41267f.a();
            return;
        }
        this.f41264c.setVisibility(0);
        h();
        i();
        this.f41264c.loadUrl(e2);
        this.f41264c.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.splashscreen.a.i.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str2, String str3) {
                i.this.f41267f.a();
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
    }
}
