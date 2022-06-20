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
/* loaded from: classes5.dex */
public class e {
    public final KsAdWebView a;
    public long b;
    public AdBaseFrameLayout c;
    public Context d;
    @Nullable
    public AdTemplate e;
    public com.kwad.sdk.core.download.a.b f;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.g g;
    public s h;
    public int i;
    @Nullable
    public p.b j;

    /* loaded from: classes5.dex */
    public static class a implements z.b {
        public final WeakReference<e> a;

        public a(e eVar) {
            this.a = new WeakReference<>(eVar);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.z.b
        public void a(int i) {
            e eVar = this.a.get();
            if (eVar != null) {
                eVar.a(i);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public e(KsAdWebView ksAdWebView) {
        this.a = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.widget.e.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    e.this.b = SystemClock.elapsedRealtime();
                    return false;
                }
                return false;
            }
        });
        a(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (f() == null) {
            return;
        }
        long X = com.kwad.sdk.core.config.b.X();
        if (X <= 0 || SystemClock.elapsedRealtime() - this.b <= X) {
            p.a aVar = new p.a();
            aVar.b = i;
            aVar.g = this.c.getTouchCoords();
            com.kwad.sdk.core.download.a.a.a(new a.C0304a(this.d).a(this.e).a(this.f).a(false).a(aVar).c(true));
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
                e.this.i = aVar2.a;
                if (aVar2.a == 1 && e.this.e != null) {
                    com.kwad.sdk.core.report.a.o(e.this.e);
                }
                if (e.this.j != null) {
                    e.this.j.a(aVar2);
                }
            }
        }));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(aVar));
        s sVar = new s();
        this.h = sVar;
        gVar.a(sVar);
    }

    private void g() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.g;
        if (gVar != null) {
            gVar.a();
            this.g = null;
        }
    }

    public void a() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.g;
        if (gVar != null) {
            gVar.a();
            this.g = null;
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, com.kwad.sdk.core.download.a.b bVar) {
        if (this.a == null) {
            com.kwad.sdk.core.d.a.d("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.d = adBaseFrameLayout.getContext();
        this.c = adBaseFrameLayout;
        this.e = adTemplate;
        this.f = bVar;
        this.i = -1;
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        aVar.a(adTemplate);
        aVar.a = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.c;
        aVar.b = adBaseFrameLayout2;
        aVar.d = adBaseFrameLayout2;
        aVar.e = this.a;
        aVar.f = bVar;
        g();
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.a);
        this.g = gVar;
        a(aVar, gVar, bVar);
        this.a.addJavascriptInterface(this.g, "KwaiAd");
    }

    public void a(@Nullable p.b bVar) {
        this.j = bVar;
    }

    public void b() {
        AdTemplate adTemplate = this.e;
        if (adTemplate == null || this.a == null) {
            return;
        }
        String ap = com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.j(adTemplate));
        if (!TextUtils.isEmpty(ap)) {
            this.a.loadUrl(ap);
        }
        com.kwad.sdk.core.report.a.p(this.e);
    }

    public void c() {
        if (this.a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("PlayableViewHelper", "showPlayable");
        s sVar = this.h;
        if (sVar != null) {
            sVar.c();
        }
        this.a.setVisibility(0);
        s sVar2 = this.h;
        if (sVar2 != null) {
            sVar2.d();
        }
    }

    public void d() {
        com.kwad.sdk.core.d.a.a("PlayableViewHelper", "showPlayable");
        if (this.a == null) {
            return;
        }
        s sVar = this.h;
        if (sVar != null) {
            sVar.e();
        }
        this.a.setVisibility(8);
        s sVar2 = this.h;
        if (sVar2 != null) {
            sVar2.f();
        }
    }

    public boolean e() {
        return this.a != null && this.i == 1;
    }

    @Nullable
    public AdTemplate f() {
        return this.e;
    }
}
