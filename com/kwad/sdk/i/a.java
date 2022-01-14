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
    public AdBaseFrameLayout f56976c;

    /* renamed from: d  reason: collision with root package name */
    public long f56977d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f56978e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56979f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdWebView f56980g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56981h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56982i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f56983j;
    public InterfaceC2129a k;
    public FrameLayout m;
    @Nullable
    public b.c n;
    public b o;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56975b = true;
    public Handler l = new Handler(Looper.getMainLooper());
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;

    /* renamed from: com.kwad.sdk.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2129a {
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
        this.f56980g = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        p.a aVar = new p.a();
        aVar.n = 1;
        this.f56980g.setClientParams(aVar);
        this.f56980g.setTemplateData(this.f56983j);
        this.f56980g.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.i.a.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str, String str2) {
                a.this.f56975b = true;
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
        this.f56980g.setDeepLinkEnabled(false);
        this.f56980g.setInsideDownloadEnable(false);
        this.f56980g.setDownloadListener(new DownloadListener() { // from class: com.kwad.sdk.i.a.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                a.this.q = true;
                if (a.this.o != null) {
                    a.this.o.a(a.this.f());
                }
            }
        });
        this.f56980g.setDeepLinkListener(new KsAdWebView.b() { // from class: com.kwad.sdk.i.a.3
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
        this.f56979f = imageView;
        imageView.setVisibility(8);
        this.f56979f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.i.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        KsAdWebView ksAdWebView = this.f56980g;
        if (ksAdWebView != null) {
            ksAdWebView.c();
        }
        InterfaceC2129a interfaceC2129a = this.k;
        if (interfaceC2129a != null) {
            interfaceC2129a.a();
        }
        Activity activity = this.f56978e;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.r ? !this.f56975b : (this.f56975b || this.p || this.q) ? false : true;
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
        this.f56982i = z;
        return this;
    }

    public String a(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.G(d.j(adTemplate));
    }

    public void a() {
        this.m.setVisibility(4);
        String a = a(this.f56983j);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.f56980g.loadUrl(a);
    }

    public void a(Activity activity) {
        this.f56978e = activity;
    }

    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.m = frameLayout;
        this.f56976c = adBaseFrameLayout;
        this.f56983j = adTemplate;
        d();
        this.f56975b = false;
    }

    public void a(b.c cVar) {
        this.n = cVar;
    }

    public void a(InterfaceC2129a interfaceC2129a) {
        this.k = interfaceC2129a;
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
        if (g2 && this.f56978e != null) {
            this.f56980g.setDeepLinkEnabled(true);
            this.f56980g.setInsideDownloadEnable(true);
            this.f56976c.setDispatchTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.i.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.f56979f.getX() && motionEvent.getX() - a.this.f56979f.getX() < a.this.f56979f.getWidth() && motionEvent.getY() > a.this.f56979f.getY() && motionEvent.getY() - a.this.f56979f.getY() < a.this.f56979f.getHeight()) {
                        com.kwad.sdk.core.d.a.a("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.f56977d = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f56977d;
                        if (a.this.f56977d > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.a.a(a.this.f56983j, (int) com.baidu.apollon.a.f32337e, a.this.f56976c.getTouchCoords());
                            if (!a.this.f56981h) {
                                a.this.f56981h = true;
                                if (a.this.n != null) {
                                    b.a aVar = new b.a();
                                    aVar.f56360c = 3;
                                    a.this.n.a(aVar);
                                }
                            }
                        }
                        a.this.f56977d = 0L;
                    }
                    return false;
                }
            });
            long t = com.kwad.sdk.core.config.b.t() * 1000;
            if (t == 0 || !this.f56982i) {
                this.f56979f.setVisibility(0);
            } else {
                this.l.postDelayed(new Runnable() { // from class: com.kwad.sdk.i.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f56978e == null || a.this.f56978e.isFinishing()) {
                            return;
                        }
                        a.this.f56979f.setVisibility(0);
                        a.this.f56979f.setAlpha(0.0f);
                        a.this.f56979f.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, t);
            }
            KsAdWebView ksAdWebView = this.f56980g;
            if (ksAdWebView != null) {
                ksAdWebView.b();
            }
        }
        return g2;
    }
}
