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
    public WebView f33811b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.g f33812c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f33813d;

    /* renamed from: e  reason: collision with root package name */
    public m f33814e;

    /* renamed from: f  reason: collision with root package name */
    public b f33815f;

    /* renamed from: g  reason: collision with root package name */
    public a f33816g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f33817h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.b.f.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (f.this.f33815f != null && f.this.f33815f.a()) {
                f.this.m();
            } else {
                f.this.n();
            }
        }
    };

    /* loaded from: classes6.dex */
    public static class a implements p.b {

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f33820a;

        public a(AdTemplate adTemplate) {
            this.f33820a = adTemplate;
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(int i2) {
            com.kwad.sdk.core.report.b.a(this.f33820a, i2, (q.a) null);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements k.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33821a = -1;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f33822b;

        public b(f fVar) {
            this.f33822b = new WeakReference<>(fVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.k.b
        public void a(int i2) {
            this.f33821a = i2;
            com.kwad.sdk.core.d.a.c("RewardPlayablePresenter", "updatePageStatus mPageState: " + i2);
            WeakReference<f> weakReference = this.f33822b;
            if (weakReference != null) {
                AdTemplate r = weakReference.get().r();
                if (this.f33821a != 1 || r == null) {
                    return;
                }
                com.kwad.sdk.core.report.b.n(r);
            }
        }

        public boolean a() {
            return this.f33821a == 1;
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
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        com.kwad.sdk.core.download.b.b bVar = aVar.j;
        a aVar2 = new a(aVar.f33566f);
        this.f33816g = aVar2;
        gVar.a(new p(this.f33813d, bVar, aVar2));
        gVar.a(new k(this.f33815f));
        gVar.a(new j(this.f33813d));
        m mVar = new m();
        this.f33814e = mVar;
        gVar.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f33811b == null) {
            return;
        }
        m mVar = this.f33814e;
        if (mVar != null) {
            mVar.c();
        }
        this.f33811b.setVisibility(0);
        m mVar2 = this.f33814e;
        if (mVar2 != null) {
            mVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        m mVar = this.f33814e;
        if (mVar != null) {
            mVar.e();
        }
        this.f33811b.setVisibility(8);
        m mVar2 = this.f33814e;
        if (mVar2 != null) {
            mVar2.f();
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void o() {
        q();
        this.f33812c = new com.kwad.sdk.core.webview.a.g(this.f33811b);
        com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "mJsInterface is : " + this.f33812c);
        a(this.f33812c);
        this.f33811b.addJavascriptInterface(this.f33812c, "KwaiAd");
    }

    private void p() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f33813d = aVar;
        com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f33839a;
        aVar.f32867b = aVar2.f33566f;
        aVar.f32866a = 0;
        AdBaseFrameLayout adBaseFrameLayout = aVar2.f33568h;
        aVar.f32868c = adBaseFrameLayout;
        aVar.f32870e = adBaseFrameLayout;
        aVar.f32871f = this.f33811b;
    }

    private void q() {
        com.kwad.sdk.core.webview.a.g gVar = this.f33812c;
        if (gVar != null) {
            gVar.a();
            this.f33812c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdTemplate r() {
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f33839a;
        if (aVar != null) {
            return aVar.f33566f;
        }
        return null;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.d) this).f33839a.a(this.f33817h);
        p();
        WebSettings a2 = a(this.f33811b);
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
        this.f33811b = webView;
        webView.setVisibility(4);
        this.f33811b.setWebChromeClient(new WebChromeClient() { // from class: com.kwad.sdk.reward.b.f.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                super.onProgressChanged(webView2, i2);
                com.kwad.sdk.core.d.a.a("RewardPlayablePresenter", "newProgress: " + i2);
            }
        });
        this.f33815f = new b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        q();
        n();
        ((com.kwad.sdk.reward.d) this).f33839a.b(this.f33817h);
    }

    public void e() {
        o();
        AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f33839a.f33566f;
        String aa = com.kwad.sdk.core.response.b.a.aa(com.kwad.sdk.core.response.b.c.g(adTemplate));
        if (!TextUtils.isEmpty(aa)) {
            this.f33811b.loadUrl(aa);
        }
        com.kwad.sdk.core.report.b.o(adTemplate);
    }
}
