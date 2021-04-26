package com.kwad.sdk.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.v;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f32648a;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32650c;

    /* renamed from: d  reason: collision with root package name */
    public long f32651d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f32652e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f32653f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f32654g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32655h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32656i;
    public AdTemplate j;
    public InterfaceC0366a k;
    public FrameLayout m;
    @Nullable
    public a.b n;
    public b o;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32649b = true;
    public Handler l = new Handler(Looper.getMainLooper());
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;

    /* renamed from: com.kwad.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0366a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void d() {
        this.m.removeAllViews();
        this.m.setVisibility(4);
        this.f32648a = an.a((ViewGroup) this.m, b(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.m.findViewById(R.id.ksad_web_card_webView);
        this.f32654g = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        o.a aVar = new o.a();
        aVar.l = 1;
        this.f32654g.setClientParams(aVar);
        this.f32654g.setTemplateData(this.j);
        this.f32654g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.c.a.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                a.this.f32649b = true;
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }
        });
        this.f32654g.setDeepLinkEnabled(false);
        this.f32654g.setInsideDownloadEnable(false);
        this.f32654g.setDownloadListener(new DownloadListener() { // from class: com.kwad.sdk.c.a.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.this.q = true;
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }
        });
        this.f32654g.setDeepLinkListener(new KsAdWebView.b() { // from class: com.kwad.sdk.c.a.3
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
            public void a() {
                a.this.p = true;
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
            public void b() {
                a.this.p = true;
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }
        });
        ImageView imageView = (ImageView) this.f32648a.findViewById(R.id.ksad_end_close_btn);
        this.f32653f = imageView;
        imageView.setVisibility(8);
        this.f32653f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.c.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KsAdWebView ksAdWebView = this.f32654g;
        if (ksAdWebView != null) {
            ksAdWebView.b();
        }
        InterfaceC0366a interfaceC0366a = this.k;
        if (interfaceC0366a != null) {
            interfaceC0366a.a();
        }
        Activity activity = this.f32652e;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.r ? !this.f32649b : (this.f32649b || this.p || this.q) ? false : true;
    }

    private boolean g() {
        if (!f()) {
            FrameLayout frameLayout = this.m;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            return false;
        }
        FrameLayout frameLayout2 = this.m;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
            return true;
        }
        return true;
    }

    public a a(boolean z) {
        this.f32656i = z;
        return this;
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.g(adTemplate));
    }

    public void a() {
        this.m.setVisibility(4);
        String a2 = a(this.j);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.f32654g.loadUrl(a2);
    }

    public void a(Activity activity) {
        this.f32652e = activity;
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.m = frameLayout;
        this.f32650c = adBaseFrameLayout;
        this.j = adTemplate;
        d();
        this.f32649b = false;
    }

    public void a(InterfaceC0366a interfaceC0366a) {
        this.k = interfaceC0366a;
    }

    public void a(b bVar) {
        this.o = bVar;
    }

    public void a(a.b bVar) {
        this.n = bVar;
    }

    public int b() {
        return R.layout.ksad_ad_landingpage_layout;
    }

    public boolean c() {
        boolean g2 = g();
        this.r = true;
        if (g2 && this.f32652e != null) {
            this.f32654g.setDeepLinkEnabled(true);
            this.f32654g.setInsideDownloadEnable(true);
            v.d(this.f32652e);
            this.f32650c.setDispatchTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.c.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.f32653f.getX() && motionEvent.getX() - a.this.f32653f.getX() < a.this.f32653f.getWidth() && motionEvent.getY() > a.this.f32653f.getY() && motionEvent.getY() - a.this.f32653f.getY() < a.this.f32653f.getHeight()) {
                        com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.f32651d = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f32651d;
                        if (a.this.f32651d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.b.a(a.this.j, 72, a.this.f32650c.getTouchCoords());
                            if (!a.this.f32655h) {
                                a.this.f32655h = true;
                                if (a.this.n != null) {
                                    a.this.n.a(null);
                                }
                            }
                        }
                        a.this.f32651d = 0L;
                    }
                    return false;
                }
            });
            long p = com.kwad.sdk.core.config.c.p() * 1000;
            if (p == 0 || !this.f32656i) {
                this.f32653f.setVisibility(0);
            } else {
                this.l.postDelayed(new Runnable() { // from class: com.kwad.sdk.c.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f32652e == null || a.this.f32652e.isFinishing()) {
                            return;
                        }
                        a.this.f32653f.setVisibility(0);
                        a.this.f32653f.setAlpha(0.0f);
                        a.this.f32653f.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, p);
            }
            KsAdWebView ksAdWebView = this.f32654g;
            if (ksAdWebView != null) {
                ksAdWebView.a();
            }
        }
        return g2;
    }
}
