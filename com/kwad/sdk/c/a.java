package com.kwad.sdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f32494b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32495c;

    /* renamed from: d  reason: collision with root package name */
    public long f32496d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f32497e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f32498f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f32499g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32500h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32501i;
    public AdTemplate j;
    public InterfaceC0361a k;
    public Handler l;

    /* renamed from: com.kwad.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0361a {
        void a();
    }

    public a(@Nullable JSONObject jSONObject) {
        super(jSONObject);
        this.f32494b = false;
        this.l = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        InterfaceC0361a interfaceC0361a = this.k;
        if (interfaceC0361a != null) {
            interfaceC0361a.a();
        }
        Activity activity = this.f32497e;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.kwad.sdk.c.c
    public int a() {
        return R.layout.ksad_ad_landingpage_layout;
    }

    public a a(boolean z) {
        this.f32501i = z;
        return this;
    }

    @Override // com.kwad.sdk.c.c
    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.B(com.kwad.sdk.core.response.b.c.j(adTemplate));
    }

    @Override // com.kwad.sdk.c.c
    public void a(Activity activity) {
        this.f32497e = activity;
    }

    @Override // com.kwad.sdk.c.c
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i2) {
        super.a(frameLayout, adBaseFrameLayout, adTemplate, bVar, i2);
        this.j = adTemplate;
        this.f32495c = adBaseFrameLayout;
        ImageView imageView = (ImageView) this.f32508a.findViewById(R.id.ksad_end_close_btn);
        this.f32498f = imageView;
        imageView.setVisibility(8);
        f().setBackgroundColor(-1);
        if (f() instanceof KsAdWebView) {
            o.a aVar = new o.a();
            aVar.l = 1;
            ((KsAdWebView) f()).setClientParams(aVar);
        }
        WebView f2 = f();
        if (f2 instanceof KsAdWebView) {
            KsAdWebView ksAdWebView = (KsAdWebView) f2;
            this.f32499g = ksAdWebView;
            ksAdWebView.setTemplateData(adTemplate);
            this.f32499g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.c.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i3, String str, String str2) {
                    a.this.f32494b = true;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
        } else {
            f2.setWebViewClient(new com.kwad.sdk.core.page.widget.webview.c() { // from class: com.kwad.sdk.c.a.2
                @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i3, String str, String str2) {
                    super.onReceivedError(webView, i3, str, str2);
                    a.this.f32494b = true;
                }
            });
        }
        this.f32498f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.j();
            }
        });
    }

    public void a(InterfaceC0361a interfaceC0361a) {
        this.k = interfaceC0361a;
    }

    @Override // com.kwad.sdk.c.c
    public boolean b() {
        return !this.f32494b;
    }

    @Override // com.kwad.sdk.c.c
    public void c() {
        super.c();
        this.l.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.c.c
    public boolean d() {
        Activity activity;
        boolean d2 = super.d();
        if (d2 && (activity = this.f32497e) != null) {
            x.d(activity);
            this.f32495c.setDispatchTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.c.a.4
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.f32498f.getX() && motionEvent.getX() - a.this.f32498f.getX() < a.this.f32498f.getWidth() && motionEvent.getY() > a.this.f32498f.getY() && motionEvent.getY() - a.this.f32498f.getY() < a.this.f32498f.getHeight()) {
                        com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.f32496d = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f32496d;
                        if (a.this.f32496d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.b.a(a.this.j, 72, a.this.f32495c.getTouchCoords());
                            if (!a.this.f32500h) {
                                a.this.f32500h = true;
                                if (a.this.e() != null) {
                                    a.this.e().a();
                                }
                            }
                        }
                        a.this.f32496d = 0L;
                    }
                    return false;
                }
            });
            long P = com.kwad.sdk.core.config.c.P() * 1000;
            if (P == 0 || !this.f32501i) {
                this.f32498f.setVisibility(0);
            } else {
                this.l.postDelayed(new Runnable() { // from class: com.kwad.sdk.c.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f32497e == null || a.this.f32497e.isFinishing()) {
                            return;
                        }
                        a.this.f32498f.setVisibility(0);
                        a.this.f32498f.setAlpha(0.0f);
                        a.this.f32498f.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, P);
            }
            KsAdWebView ksAdWebView = this.f32499g;
            if (ksAdWebView != null) {
                ksAdWebView.d();
            }
        }
        return d2;
    }
}
