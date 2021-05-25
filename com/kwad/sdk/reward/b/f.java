package com.kwad.sdk.reward.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.utils.q;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.reward.d {

    /* renamed from: b  reason: collision with root package name */
    public WebView f33740b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f33741c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33742d;

    /* renamed from: e  reason: collision with root package name */
    public m f33743e;

    /* renamed from: f  reason: collision with root package name */
    public b f33744f;

    /* renamed from: g  reason: collision with root package name */
    public a f33745g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f33746h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.b.f.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (f.this.f33744f != null && f.this.f33744f.a()) {
                f.this.m();
            } else {
                f.this.n();
            }
        }
    };

    /* loaded from: classes6.dex */
    public static class a implements p.b {

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f33749a;

        public a(AdTemplate adTemplate) {
            this.f33749a = adTemplate;
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(int i2) {
            com.kwad.sdk.core.report.b.a(this.f33749a, i2, (q.a) null);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements k.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33750a = -1;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f33751b;

        public b(f fVar) {
            this.f33751b = new WeakReference<>(fVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            this.f33750a = i2;
            com.kwad.sdk.core.d.a.c("RewardPlayablePresenter", "updatePageStatus mPageState: " + i2);
            WeakReference<f> weakReference = this.f33751b;
            if (weakReference != null) {
                AdTemplate r = weakReference.get().r();
                if (this.f33750a != 1 || r == null) {
                    return;
                }
                com.kwad.sdk.core.report.b.n(r);
            }
        }

        public boolean a() {
            return this.f33750a == 1;
        }
    }

    @MainThread
    public static WebSettings a(WebView webView) {
        if (webView == null) {
            return null;
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 19) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        webView.setSaveEnabled(false);
        return settings;
    }

    private void a(com.kwad.sdk.core.webview.a.g gVar) {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33768a;
        com.kwad.sdk.core.download.b.b bVar = aVar.j;
        a aVar2 = new a(aVar.f33495f);
        this.f33745g = aVar2;
        gVar.a(new p(this.f33742d, bVar, aVar2));
        gVar.a(new k(this.f33744f));
        gVar.a(new j(this.f33742d));
        m mVar = new m();
        this.f33743e = mVar;
        gVar.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f33740b == null) {
            return;
        }
        m mVar = this.f33743e;
        if (mVar != null) {
            mVar.c();
        }
        this.f33740b.setVisibility(0);
        m mVar2 = this.f33743e;
        if (mVar2 != null) {
            mVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        m mVar = this.f33743e;
        if (mVar != null) {
            mVar.e();
        }
        this.f33740b.setVisibility(8);
        m mVar2 = this.f33743e;
        if (mVar2 != null) {
            mVar2.f();
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void o() {
        q();
        this.f33741c = new com.kwad.sdk.core.webview.a.g(this.f33740b);
        com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "mJsInterface is : " + this.f33741c);
        a(this.f33741c);
        this.f33740b.addJavascriptInterface(this.f33741c, "KwaiAd");
    }

    private void p() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33742d = aVar;
        com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f33768a;
        aVar.f32796b = aVar2.f33495f;
        aVar.f32795a = 0;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f33497h;
        aVar.f32797c = adBaseFrameLayout;
        aVar.f32799e = adBaseFrameLayout;
        aVar.f32800f = this.f33740b;
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar = this.f33741c;
        if (gVar != null) {
            gVar.a();
            this.f33741c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdTemplate r() {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33768a;
        if (aVar != null) {
            return aVar.f33495f;
        }
        return null;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.d) this).f33768a.a(this.f33746h);
        p();
        WebSettings a2 = a(this.f33740b);
        a2.setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 17 && com.kwad.sdk.core.config.c.C()) {
            a2.setMediaPlaybackRequiresUserGesture(false);
        }
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        WebView webView = (WebView) a(R.id.ksad_playable_webview);
        this.f33740b = webView;
        webView.setVisibility(4);
        this.f33740b.setWebChromeClient(new WebChromeClient() { // from class: com.kwad.sdk.reward.b.f.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                super.onProgressChanged(webView2, i2);
                com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "newProgress: " + i2);
            }
        });
        this.f33744f = new b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        q();
        n();
        ((com.kwad.sdk.reward.d) this).f33768a.b(this.f33746h);
    }

    public void e() {
        o();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f33768a.f33495f;
        String aa = com.kwad.sdk.core.response.b.a.aa(com.kwad.sdk.core.response.b.c.g(adTemplate));
        if (!TextUtils.isEmpty(aa)) {
            this.f33740b.loadUrl(aa);
        }
        com.kwad.sdk.core.report.b.o(adTemplate);
    }
}
