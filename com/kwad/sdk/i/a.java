package com.kwad.sdk.i;

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
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
/* loaded from: classes3.dex */
public class a {
    public View a;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f59205c;

    /* renamed from: d  reason: collision with root package name */
    public long f59206d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f59207e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59208f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f59209g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59210h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59211i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f59212j;

    /* renamed from: k  reason: collision with root package name */
    public InterfaceC2112a f59213k;
    public FrameLayout m;
    @Nullable
    public b.c n;
    public b o;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59204b = true;
    public Handler l = new Handler(Looper.getMainLooper());
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;

    /* renamed from: com.kwad.sdk.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2112a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void d() {
        this.m.removeAllViews();
        this.m.setVisibility(4);
        this.a = com.kwad.sdk.a.kwai.a.a((ViewGroup) this.m, b(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.m.findViewById(R.id.ksad_web_card_webView);
        this.f59209g = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        p.a aVar = new p.a();
        aVar.n = 1;
        this.f59209g.setClientParams(aVar);
        this.f59209g.setTemplateData(this.f59212j);
        this.f59209g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.i.a.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                a.this.f59204b = true;
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
        this.f59209g.setDeepLinkEnabled(false);
        this.f59209g.setInsideDownloadEnable(false);
        this.f59209g.setDownloadListener(new DownloadListener() { // from class: com.kwad.sdk.i.a.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                a.this.q = true;
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }
        });
        this.f59209g.setDeepLinkListener(new KsAdWebView.b() { // from class: com.kwad.sdk.i.a.3
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
        ImageView imageView = (ImageView) this.a.findViewById(R.id.ksad_end_close_btn);
        this.f59208f = imageView;
        imageView.setVisibility(8);
        this.f59208f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.i.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KsAdWebView ksAdWebView = this.f59209g;
        if (ksAdWebView != null) {
            ksAdWebView.c();
        }
        InterfaceC2112a interfaceC2112a = this.f59213k;
        if (interfaceC2112a != null) {
            interfaceC2112a.a();
        }
        Activity activity = this.f59207e;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.r ? !this.f59204b : (this.f59204b || this.p || this.q) ? false : true;
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
        this.f59211i = z;
        return this;
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.G(d.j(adTemplate));
    }

    public void a() {
        this.m.setVisibility(4);
        String a = a(this.f59212j);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.f59209g.loadUrl(a);
    }

    public void a(Activity activity) {
        this.f59207e = activity;
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.m = frameLayout;
        this.f59205c = adBaseFrameLayout;
        this.f59212j = adTemplate;
        d();
        this.f59204b = false;
    }

    public void a(b.c cVar) {
        this.n = cVar;
    }

    public void a(InterfaceC2112a interfaceC2112a) {
        this.f59213k = interfaceC2112a;
    }

    public void a(b bVar) {
        this.o = bVar;
    }

    public int b() {
        return R.layout.ksad_ad_landingpage_layout;
    }

    public boolean c() {
        boolean g2 = g();
        this.r = true;
        if (g2 && this.f59207e != null) {
            this.f59209g.setDeepLinkEnabled(true);
            this.f59209g.setInsideDownloadEnable(true);
            this.f59205c.setDispatchTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.i.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.f59208f.getX() && motionEvent.getX() - a.this.f59208f.getX() < a.this.f59208f.getWidth() && motionEvent.getY() > a.this.f59208f.getY() && motionEvent.getY() - a.this.f59208f.getY() < a.this.f59208f.getHeight()) {
                        com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.f59206d = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f59206d;
                        if (a.this.f59206d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.a.a(a.this.f59212j, (int) com.baidu.apollon.a.f33398e, a.this.f59205c.getTouchCoords());
                            if (!a.this.f59210h) {
                                a.this.f59210h = true;
                                if (a.this.n != null) {
                                    b.a aVar = new b.a();
                                    aVar.f58569c = 3;
                                    a.this.n.a(aVar);
                                }
                            }
                        }
                        a.this.f59206d = 0L;
                    }
                    return false;
                }
            });
            long t = com.kwad.sdk.core.config.b.t() * 1000;
            if (t == 0 || !this.f59211i) {
                this.f59208f.setVisibility(0);
            } else {
                this.l.postDelayed(new Runnable() { // from class: com.kwad.sdk.i.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f59207e == null || a.this.f59207e.isFinishing()) {
                            return;
                        }
                        a.this.f59208f.setVisibility(0);
                        a.this.f59208f.setAlpha(0.0f);
                        a.this.f59208f.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, t);
            }
            KsAdWebView ksAdWebView = this.f59209g;
            if (ksAdWebView != null) {
                ksAdWebView.b();
            }
        }
        return g2;
    }
}
