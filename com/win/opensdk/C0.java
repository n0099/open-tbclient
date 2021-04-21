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
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes7.dex */
public class C0 extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public Context f40027a;

    /* renamed from: b  reason: collision with root package name */
    public F0 f40028b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40029c;

    /* renamed from: d  reason: collision with root package name */
    public K0 f40030d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40031e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f40032f;

    /* renamed from: g  reason: collision with root package name */
    public long f40033g;

    /* renamed from: h  reason: collision with root package name */
    public long f40034h;
    public boolean i;
    public final Runnable j;
    public long k;
    public boolean l;
    public int m;
    public D0 n;
    public J0 o;
    public R0 p;

    public C0(Context context, AttributeSet attributeSet, int i, K0 k0) {
        super(context.getApplicationContext(), attributeSet, i);
        this.f40032f = new Handler(Looper.getMainLooper());
        this.f40033g = 1000L;
        this.f40034h = 200L;
        this.j = new z0(this);
        this.n = new A0(this);
        this.f40030d = k0;
        this.f40027a = context;
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
        this.f40028b = new I0(this);
        setWebViewClient(new N0(this, this.f40028b));
        setWebChromeClient(new M0(this, this.f40028b));
    }

    public void a() {
        boolean g2;
        if (System.currentTimeMillis() - this.k < this.f40034h) {
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        int i = iArr[0];
        int width = getWidth() + iArr[0];
        int i2 = iArr[1];
        int height = getHeight() + iArr[1];
        rect.height();
        rect.width();
        getHeight();
        getWidth();
        int[] d2 = G.d(getViewContext());
        this.l = width > 0 && i < d2[0] && height > 0 && i2 < d2[1];
        F0 f0 = this.f40028b;
        if (f0 != null) {
            I0 i0 = (I0) f0;
            C0 c0 = i0.f40063a;
            if (c0 != null && i0.f40066d != (g2 = c0.g())) {
                i0.a(g2);
            }
            F0 f02 = this.f40028b;
            int width2 = getWidth();
            int height2 = getHeight();
            I0 i02 = (I0) f02;
            if (i02.f40063a != null) {
                try {
                    int[] iArr2 = new int[4];
                    if (iArr2[0] != i || iArr2[1] != i2 || iArr2[2] != width2 || iArr2[3] != height2) {
                        iArr2[0] = i;
                        iArr2[1] = i2;
                        iArr2[2] = width2;
                        iArr2[3] = height2;
                        int[] iArr3 = {i, i2 - (i02.f40063a.getViewContext() instanceof Activity ? ((Activity) i02.f40063a.getViewContext()).getWindow().findViewById(16908290).getTop() : 0), width2, height2};
                        G.a(i02.f40063a.getViewContext(), iArr3);
                        int i3 = iArr3[0];
                        int i4 = iArr3[1];
                        int i5 = iArr3[2];
                        int i6 = iArr3[3];
                        C0 c02 = i02.f40063a;
                        G.a(c02, "javascript:window.mraidbridge.setCurrentPosition(" + i3 + "," + i4 + "," + i5 + "," + i6 + SmallTailInfo.EMOTION_SUFFIX);
                        C0 c03 = i02.f40063a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("javascript:window.mraidbridge.notifySizeChangeEvent(");
                        sb.append(i5);
                        sb.append(",");
                        sb.append(i6);
                        sb.append(SmallTailInfo.EMOTION_SUFFIX);
                        G.a(c03, sb.toString());
                    }
                } catch (Exception unused) {
                }
            }
            int i7 = getViewContext().getResources().getConfiguration().orientation;
            if (this.m != i7) {
                this.m = i7;
                ((I0) this.f40028b).b();
                ((I0) this.f40028b).c();
            }
        }
        this.k = System.currentTimeMillis();
    }

    public void a(int i, int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        if (i2 != -1) {
            i2 = (int) ((i2 * displayMetrics.density) + 0.5d);
        }
        if (i != -1) {
            i = (int) ((i * displayMetrics.density) + 0.5d);
        }
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void a(R0 r0) {
        this.p = r0;
    }

    public void a(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, SapiWebView.K, "utf-8", null);
    }

    public void b() {
    }

    public final void b(int i, int i2) {
        boolean g2;
        if (i == 0 && i2 == 0) {
            this.f40029c = true;
            h();
        } else {
            this.f40029c = false;
            this.f40031e = true;
            this.f40032f.removeCallbacks(this.j);
        }
        I0 i0 = (I0) this.f40028b;
        C0 c0 = i0.f40063a;
        if (c0 == null || i0.f40066d == (g2 = c0.g())) {
            return;
        }
        i0.a(g2);
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
        float f2 = displayMetrics.density;
        layoutParams.height = (int) ((i2 * f2) + 0.5d);
        layoutParams.width = (int) ((i * f2) + 0.5d);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f40030d == K0.INTERSTITIAL;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f40032f != null) {
                this.f40032f.removeCallbacksAndMessages(null);
            }
            this.f40031e = true;
            this.f40032f.removeCallbacks(this.j);
            removeAllViews();
            stopLoading();
        } catch (Exception unused) {
        }
        super.destroy();
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.f40030d == K0.Video;
    }

    public boolean g() {
        return this.l && this.f40029c;
    }

    public R0 getAttachView() {
        return this.p;
    }

    public D0 getDispatcher() {
        return this.n;
    }

    public K0 getMraidMideaType() {
        return this.f40030d;
    }

    public L0 getMraidState() {
        return L0.STATE_DEFAULT;
    }

    public Context getViewContext() {
        if (this.f40027a == null) {
            this.f40027a = getContext();
        }
        Context context = this.f40027a;
        return context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
    }

    public final void h() {
        if (this.f40029c) {
            this.f40031e = false;
            this.f40032f.removeCallbacks(this.j);
            this.f40032f.post(this.j);
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
        ((A0) this.n).a(z);
    }

    public void setMraidListener(J0 j0) {
        this.o = j0;
    }
}
