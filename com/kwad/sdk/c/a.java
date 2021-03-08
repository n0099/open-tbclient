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
/* loaded from: classes3.dex */
public class a extends c {
    private boolean b;
    private AdBaseFrameLayout c;
    private long d;
    private Activity e;
    private ImageView f;
    private KsAdWebView g;
    private boolean h;
    private boolean i;
    private AdTemplate j;
    private InterfaceC1090a k;
    private Handler l;

    /* renamed from: com.kwad.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1090a {
        void a();
    }

    public a(@Nullable JSONObject jSONObject) {
        super(jSONObject);
        this.b = false;
        this.l = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.k != null) {
            this.k.a();
        }
        if (this.e != null) {
            this.e.finish();
        }
    }

    @Override // com.kwad.sdk.c.c
    protected int a() {
        return R.layout.ksad_ad_landingpage_layout;
    }

    public a a(boolean z) {
        this.i = z;
        return this;
    }

    @Override // com.kwad.sdk.c.c
    protected String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.B(com.kwad.sdk.core.response.b.c.j(adTemplate));
    }

    @Override // com.kwad.sdk.c.c
    public void a(Activity activity) {
        this.e = activity;
    }

    @Override // com.kwad.sdk.c.c
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.sdk.core.download.b.b bVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, adTemplate, bVar, i);
        this.j = adTemplate;
        this.c = adBaseFrameLayout;
        this.f = (ImageView) this.f5494a.findViewById(R.id.ksad_end_close_btn);
        this.f.setVisibility(8);
        f().setBackgroundColor(-1);
        if (f() instanceof KsAdWebView) {
            o.a aVar = new o.a();
            aVar.l = 1;
            ((KsAdWebView) f()).setClientParams(aVar);
        }
        WebView f = f();
        if (f instanceof KsAdWebView) {
            this.g = (KsAdWebView) f;
            this.g.setTemplateData(adTemplate);
            this.g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.c.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str, String str2) {
                    a.this.b = true;
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
        } else {
            f.setWebViewClient(new com.kwad.sdk.core.page.widget.webview.c() { // from class: com.kwad.sdk.c.a.2
                @Override // com.kwad.sdk.core.page.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    super.onReceivedError(webView, i2, str, str2);
                    a.this.b = true;
                }
            });
        }
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.j();
            }
        });
    }

    public void a(InterfaceC1090a interfaceC1090a) {
        this.k = interfaceC1090a;
    }

    @Override // com.kwad.sdk.c.c
    protected boolean b() {
        return !this.b;
    }

    @Override // com.kwad.sdk.c.c
    public void c() {
        super.c();
        this.l.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.c.c
    public boolean d() {
        boolean d = super.d();
        if (d && this.e != null) {
            x.d(this.e);
            this.c.setDispatchTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.c.a.4
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.f.getX() && motionEvent.getX() - a.this.f.getX() < a.this.f.getWidth() && motionEvent.getY() > a.this.f.getY() && motionEvent.getY() - a.this.f.getY() < a.this.f.getHeight()) {
                        com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                    } else if (motionEvent.getAction() == 0) {
                        a.this.d = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.d;
                        if (a.this.d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.b.a(a.this.j, 72, a.this.c.getTouchCoords());
                            if (!a.this.h) {
                                a.this.h = true;
                                if (a.this.e() != null) {
                                    a.this.e().a();
                                }
                            }
                        }
                        a.this.d = 0L;
                    }
                    return false;
                }
            });
            long P = com.kwad.sdk.core.config.c.P() * 1000;
            if (P == 0 || !this.i) {
                this.f.setVisibility(0);
            } else {
                this.l.postDelayed(new Runnable() { // from class: com.kwad.sdk.c.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.e == null || a.this.e.isFinishing()) {
                            return;
                        }
                        a.this.f.setVisibility(0);
                        a.this.f.setAlpha(0.0f);
                        a.this.f.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, P);
            }
            if (this.g != null) {
                this.g.d();
            }
        }
        return d;
    }
}
