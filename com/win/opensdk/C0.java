package com.win.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
/* loaded from: classes14.dex */
public class C0 extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public Context f8093a;
    public boolean c;
    public boolean e;
    public Handler f;
    public long g;
    public long h;
    public boolean i;
    public final Runnable j;
    public long k;
    public boolean l;
    public int m;
    public t qkq;
    public K0 qkr;
    public o qks;
    public ag qkt;
    public be qku;

    public C0(Context context, AttributeSet attributeSet, int i, K0 k0) {
        super(context.getApplicationContext(), attributeSet, i);
        this.f = new Handler(Looper.getMainLooper());
        this.g = 1000L;
        this.h = 200L;
        this.j = new fd(this);
        this.qks = new e(this);
        this.qkr = k0;
        this.f8093a = context;
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setBackgroundColor(0);
        setScrollBarStyle(0);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setSupportZoom(false);
        getSettings().setUseWideViewPort(false);
        getSettings().setLightTouchEnabled(false);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 11) {
            getSettings().setAllowContentAccess(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            if (Build.VERSION.SDK_INT >= 21) {
                cookieManager.setAcceptThirdPartyCookies(this, true);
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.qkq = new ad(this);
        setWebViewClient(new ap(this, this.qkq));
        setWebChromeClient(new am(this, this.qkq));
    }

    public void a() {
        boolean g;
        boolean z = true;
        if (!(System.currentTimeMillis() - this.k < this.h)) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            int i = iArr[0];
            int width = iArr[0] + getWidth();
            int i2 = iArr[1];
            int height = iArr[1] + getHeight();
            rect.height();
            rect.width();
            getHeight();
            getWidth();
            int[] iL = v.iL(getViewContext());
            if (width <= 0 || i >= iL[0] || height <= 0 || i2 >= iL[1]) {
                z = false;
            }
            this.l = z;
            t tVar = this.qkq;
            if (tVar != null) {
                ad adVar = (ad) tVar;
                C0 c0 = adVar.qkf;
                if (c0 != null && adVar.d != (g = c0.g())) {
                    adVar.a(g);
                }
                t tVar2 = this.qkq;
                int width2 = getWidth();
                int height2 = getHeight();
                ad adVar2 = (ad) tVar2;
                if (adVar2.qkf != null) {
                    try {
                        int[] iArr2 = new int[4];
                        if (iArr2[0] != i || iArr2[1] != i2 || iArr2[2] != width2 || iArr2[3] != height2) {
                            iArr2[0] = i;
                            iArr2[1] = i2;
                            iArr2[2] = width2;
                            iArr2[3] = height2;
                            int[] iArr3 = {i, i2 - (adVar2.qkf.getViewContext() instanceof Activity ? ((Activity) adVar2.qkf.getViewContext()).getWindow().findViewById(16908290).getTop() : 0), width2, height2};
                            v.b(adVar2.qkf.getViewContext(), iArr3);
                            int i3 = iArr3[0];
                            int i4 = iArr3[1];
                            int i5 = iArr3[2];
                            int i6 = iArr3[3];
                            v.a(adVar2.qkf, "javascript:window.mraidbridge.setCurrentPosition(" + i3 + "," + i4 + "," + i5 + "," + i6 + ")");
                            v.a(adVar2.qkf, "javascript:window.mraidbridge.notifySizeChangeEvent(" + i5 + "," + i6 + ")");
                        }
                    } catch (Exception e) {
                    }
                }
                int i7 = getViewContext().getResources().getConfiguration().orientation;
                if (this.m != i7) {
                    this.m = i7;
                    ((ad) this.qkq).b();
                    ((ad) this.qkq).c();
                }
            }
            this.k = System.currentTimeMillis();
        }
    }

    public void a(int i, int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        if (i2 == -1) {
        }
        if (i2 != -1) {
            i2 = (int) ((i2 * displayMetrics.density) + 0.5d);
        }
        if (i != -1) {
            i = (int) ((displayMetrics.density * i) + 0.5d);
        }
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void a(be beVar) {
        this.qku = beVar;
    }

    public void a(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, "text/html", "utf-8", null);
    }

    public void b() {
    }

    public void b(String str) {
        loadUrl(str);
    }

    public void c() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    public void c(int i, int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        float f = displayMetrics.density;
        layoutParams.height = (int) ((i2 * f) + 0.5d);
        layoutParams.width = (int) ((f * i) + 0.5d);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.qkr == K0.INTERSTITIAL;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f != null) {
                this.f.removeCallbacksAndMessages(null);
            }
            this.e = true;
            this.f.removeCallbacks(this.j);
            removeAllViews();
            stopLoading();
        } catch (Exception e) {
        }
        super.destroy();
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.qkr == K0.Video;
    }

    public boolean g() {
        return this.l && this.c;
    }

    public be getAttachView() {
        return this.qku;
    }

    public o getDispatcher() {
        return this.qks;
    }

    public K0 getMraidMideaType() {
        return this.qkr;
    }

    public L0 getMraidState() {
        return L0.STATE_DEFAULT;
    }

    public Context getViewContext() {
        if (this.f8093a == null) {
            this.f8093a = getContext();
        }
        Context context = this.f8093a;
        return context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
    }

    public final void h() {
        if (this.c) {
            this.e = false;
            this.f.removeCallbacks(this.j);
            this.f.post(this.j);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.i = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        b(getWindowVisibility(), i);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b(i, getVisibility());
    }

    public void setMRAIDUseCustomClose(boolean z) {
        ((e) this.qks).a(z);
    }

    public void setMraidListener(ag agVar) {
        this.qkt = agVar;
    }

    public final void b(int i, int i2) {
        boolean g;
        if (i == 0 && i2 == 0) {
            this.c = true;
            h();
        } else {
            this.c = false;
            this.e = true;
            this.f.removeCallbacks(this.j);
        }
        ad adVar = (ad) this.qkq;
        C0 c0 = adVar.qkf;
        if (c0 == null || adVar.d == (g = c0.g())) {
            return;
        }
        adVar.a(g);
    }
}
