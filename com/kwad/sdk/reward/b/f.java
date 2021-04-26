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
    public WebView f34566b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f34567c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f34568d;

    /* renamed from: e  reason: collision with root package name */
    public m f34569e;

    /* renamed from: f  reason: collision with root package name */
    public b f34570f;

    /* renamed from: g  reason: collision with root package name */
    public a f34571g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f34572h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.b.f.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (f.this.f34570f != null && f.this.f34570f.a()) {
                f.this.m();
            } else {
                f.this.n();
            }
        }
    };

    /* loaded from: classes6.dex */
    public static class a implements p.b {

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f34575a;

        public a(AdTemplate adTemplate) {
            this.f34575a = adTemplate;
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(int i2) {
            com.kwad.sdk.core.report.b.a(this.f34575a, i2, (q.a) null);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements k.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34576a = -1;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f34577b;

        public b(f fVar) {
            this.f34577b = new WeakReference<>(fVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            this.f34576a = i2;
            com.kwad.sdk.core.d.a.c("RewardPlayablePresenter", "updatePageStatus mPageState: " + i2);
            WeakReference<f> weakReference = this.f34577b;
            if (weakReference != null) {
                AdTemplate r = weakReference.get().r();
                if (this.f34576a != 1 || r == null) {
                    return;
                }
                com.kwad.sdk.core.report.b.n(r);
            }
        }

        public boolean a() {
            return this.f34576a == 1;
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
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        com.kwad.sdk.core.download.b.b bVar = aVar.j;
        a aVar2 = new a(aVar.f34321f);
        this.f34571g = aVar2;
        gVar.a(new p(this.f34568d, bVar, aVar2));
        gVar.a(new k(this.f34570f));
        gVar.a(new j(this.f34568d));
        m mVar = new m();
        this.f34569e = mVar;
        gVar.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f34566b == null) {
            return;
        }
        m mVar = this.f34569e;
        if (mVar != null) {
            mVar.c();
        }
        this.f34566b.setVisibility(0);
        m mVar2 = this.f34569e;
        if (mVar2 != null) {
            mVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        m mVar = this.f34569e;
        if (mVar != null) {
            mVar.e();
        }
        this.f34566b.setVisibility(8);
        m mVar2 = this.f34569e;
        if (mVar2 != null) {
            mVar2.f();
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void o() {
        q();
        this.f34567c = new com.kwad.sdk.core.webview.a.g(this.f34566b);
        com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "mJsInterface is : " + this.f34567c);
        a(this.f34567c);
        this.f34566b.addJavascriptInterface(this.f34567c, "KwaiAd");
    }

    private void p() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f34568d = aVar;
        com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f34594a;
        aVar.f33622b = aVar2.f34321f;
        aVar.f33621a = 0;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f34323h;
        aVar.f33623c = adBaseFrameLayout;
        aVar.f33625e = adBaseFrameLayout;
        aVar.f33626f = this.f34566b;
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar = this.f34567c;
        if (gVar != null) {
            gVar.a();
            this.f34567c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdTemplate r() {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f34594a;
        if (aVar != null) {
            return aVar.f34321f;
        }
        return null;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.d) this).f34594a.a(this.f34572h);
        p();
        WebSettings a2 = a(this.f34566b);
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
        this.f34566b = webView;
        webView.setVisibility(4);
        this.f34566b.setWebChromeClient(new WebChromeClient() { // from class: com.kwad.sdk.reward.b.f.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                super.onProgressChanged(webView2, i2);
                com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "newProgress: " + i2);
            }
        });
        this.f34570f = new b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        q();
        n();
        ((com.kwad.sdk.reward.d) this).f34594a.b(this.f34572h);
    }

    public void e() {
        o();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f34594a.f34321f;
        String aa = com.kwad.sdk.core.response.b.a.aa(com.kwad.sdk.core.response.b.c.g(adTemplate));
        if (!TextUtils.isEmpty(aa)) {
            this.f34566b.loadUrl(aa);
        }
        com.kwad.sdk.core.report.b.o(adTemplate);
    }
}
