package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.z;
import com.kwad.sdk.utils.be;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class e {
    public final KsAdWebView a;

    /* renamed from: b  reason: collision with root package name */
    public long f58115b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f58116c;

    /* renamed from: d  reason: collision with root package name */
    public Context f58117d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f58118e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58119f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f58120g;

    /* renamed from: h  reason: collision with root package name */
    public s f58121h;

    /* renamed from: i  reason: collision with root package name */
    public int f58122i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public p.b f58123j;

    /* loaded from: classes3.dex */
    public static class a implements z.b {
        public final WeakReference<e> a;

        public a(e eVar) {
            this.a = new WeakReference<>(eVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.z.b
        public void a(int i2) {
            e eVar = this.a.get();
            if (eVar != null) {
                eVar.a(i2);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public e(KsAdWebView ksAdWebView) {
        this.a = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.widget.e.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    e.this.f58115b = SystemClock.elapsedRealtime();
                    return false;
                }
                return false;
            }
        });
        a(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (f() == null) {
            return;
        }
        long X = com.kwad.sdk.core.config.b.X();
        if (X <= 0 || SystemClock.elapsedRealtime() - this.f58115b <= X) {
            p.a aVar = new p.a();
            aVar.f56106b = i2;
            aVar.f56111g = this.f58116c.getTouchCoords();
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(this.f58117d).a(this.f58118e).a(this.f58119f).a(false).a(aVar).c(true));
        }
    }

    private void a(KsAdWebView ksAdWebView) {
        WebSettings a2 = be.a(ksAdWebView);
        a2.setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 17 && com.kwad.sdk.core.config.b.I()) {
            a2.setMediaPlaybackRequiresUserGesture(false);
        }
        ksAdWebView.setWebChromeClient(new WebChromeClient() { // from class: com.kwad.sdk.widget.e.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                com.kwad.sdk.core.d.a.a("PlayableViewHelper", "onConsoleMessage: " + consoleMessage.message());
                return super.onConsoleMessage(consoleMessage);
            }
        });
    }

    private void a(com.kwad.sdk.core.webview.a aVar, com.kwad.sdk.core.webview.kwai.g gVar, com.kwad.sdk.core.download.a.b bVar) {
        gVar.a(new z(aVar, bVar, new a(this)));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.p(new p.b() { // from class: com.kwad.sdk.widget.e.3
            @Override // com.kwad.sdk.core.webview.jshandler.p.b
            public void a(p.a aVar2) {
                e.this.f58122i = aVar2.a;
                if (aVar2.a == 1 && e.this.f58118e != null) {
                    com.kwad.sdk.core.report.a.o(e.this.f58118e);
                }
                if (e.this.f58123j != null) {
                    e.this.f58123j.a(aVar2);
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(aVar));
        s sVar = new s();
        this.f58121h = sVar;
        gVar.a(sVar);
    }

    private void g() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f58120g;
        if (gVar != null) {
            gVar.a();
            this.f58120g = null;
        }
    }

    public void a() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f58120g;
        if (gVar != null) {
            gVar.a();
            this.f58120g = null;
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, com.kwad.sdk.core.download.a.b bVar) {
        if (this.a == null) {
            com.kwad.sdk.core.d.a.d("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.f58117d = adBaseFrameLayout.getContext();
        this.f58116c = adBaseFrameLayout;
        this.f58118e = adTemplate;
        this.f58119f = bVar;
        this.f58122i = -1;
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        aVar.a(adTemplate);
        aVar.a = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.f58116c;
        aVar.f56372b = adBaseFrameLayout2;
        aVar.f56374d = adBaseFrameLayout2;
        aVar.f56375e = this.a;
        aVar.f56376f = bVar;
        g();
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.a);
        this.f58120g = gVar;
        a(aVar, gVar, bVar);
        this.a.addJavascriptInterface(this.f58120g, "KwaiAd");
    }

    public void a(@Nullable p.b bVar) {
        this.f58123j = bVar;
    }

    public void b() {
        AdTemplate adTemplate = this.f58118e;
        if (adTemplate == null || this.a == null) {
            return;
        }
        String ap = com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.j(adTemplate));
        if (!TextUtils.isEmpty(ap)) {
            this.a.loadUrl(ap);
        }
        com.kwad.sdk.core.report.a.p(this.f58118e);
    }

    public void c() {
        if (this.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("PlayableViewHelper", "showPlayable");
        s sVar = this.f58121h;
        if (sVar != null) {
            sVar.c();
        }
        this.a.setVisibility(0);
        s sVar2 = this.f58121h;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    public void d() {
        com.kwad.sdk.core.d.a.a("PlayableViewHelper", "showPlayable");
        if (this.a == null) {
            return;
        }
        s sVar = this.f58121h;
        if (sVar != null) {
            sVar.e();
        }
        this.a.setVisibility(8);
        s sVar2 = this.f58121h;
        if (sVar2 != null) {
            sVar2.f();
        }
    }

    public boolean e() {
        return this.a != null && this.f58122i == 1;
    }

    @Nullable
    public AdTemplate f() {
        return this.f58118e;
    }
}
