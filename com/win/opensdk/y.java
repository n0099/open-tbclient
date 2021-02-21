package com.win.opensdk;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public class y extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private long f13769a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f83a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13770b;
    private boolean c;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private af f84java;
    public q qjE;
    private long qjJ;
    private boolean qjQ;
    private h qjT;
    private Context qjn;
    private boolean qjq;
    private final Runnable qkO;
    private long qkp;
    private Handler qkv;
    private cg qlV;
    private k qlW;

    public y(Context context, af afVar) {
        this(context, afVar, (byte) 0);
    }

    private y(Context context, af afVar, byte b2) {
        this(context, afVar, (char) 0);
    }

    public y(Context context, af afVar, char c) {
        super(context.getApplicationContext(), null, 0);
        this.qkv = new Handler(Looper.getMainLooper());
        this.qjJ = 1000L;
        this.qkp = 200L;
        this.qkO = new Runnable() { // from class: com.win.opensdk.y.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!y.this.f83a) {
                    y.this.eIX();
                    y.this.qkv.postDelayed(this, y.this.qjJ);
                }
            }
        };
        this.qlV = new a();
        this.f84java = afVar;
        this.qjn = context;
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
        this.qjT = new j(this);
        setWebViewClient(new n(this, this.qjT));
        setWebChromeClient(new l(this, this.qjT));
    }

    public q getAttachView() {
        return this.qjE;
    }

    public cg getDispatcher() {
        return this.qlV;
    }

    public ag getMraidState() {
        return ag.STATE_DEFAULT;
    }

    public af getMraidMideaType() {
        return this.f84java;
    }

    public void setMraidListener(k kVar) {
        this.qlW = kVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f13770b = true;
        return super.onTouchEvent(motionEvent);
    }

    public final boolean java() {
        return this.c && this.qjq;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        eh(i, getVisibility());
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        eh(getWindowVisibility(), i);
    }

    private void eh(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.qjq = true;
            a();
        } else {
            this.qjq = false;
            b();
        }
        this.qjT.b();
    }

    public Context getViewContext() {
        if (this.qjn == null) {
            this.qjn = getContext();
        }
        return this.qjn instanceof MutableContextWrapper ? ((MutableContextWrapper) this.qjn).getBaseContext() : this.qjn;
    }

    public final boolean eJv() {
        return this.f84java == af.INTERSTITIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m78a() {
        return this.f84java == af.Video;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.qjQ = z;
    }

    public void eIY() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.qjq) {
            this.f83a = false;
            this.qkv.removeCallbacks(this.qkO);
            this.qkv.post(this.qkO);
        }
    }

    private void b() {
        this.f83a = true;
        this.qkv.removeCallbacks(this.qkO);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.qkv != null) {
                this.qkv.removeCallbacksAndMessages(null);
            }
            b();
            removeAllViews();
            stopLoading();
        } catch (Exception e) {
        }
        super.destroy();
    }

    /* renamed from: com.win.opensdk.y$case  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class Ccase extends y {
        h qjT;

        public Ccase(Context context, af afVar, h hVar) {
            this(context, afVar, hVar, (byte) 0);
        }

        private Ccase(Context context, af afVar, h hVar, byte b2) {
            this(context, afVar, hVar, (char) 0);
        }

        private Ccase(Context context, af afVar, h hVar, char c) {
            super(context, afVar, (char) 0);
            this.qjT = hVar;
        }

        @Override // com.win.opensdk.y
        public final ag getMraidState() {
            return ag.STATE_EXPANDED;
        }

        @Override // com.win.opensdk.y
        public final void eIY() {
            super.eIY();
            this.qjT.eIX();
        }
    }

    /* loaded from: classes3.dex */
    class a implements cg {
        a() {
        }

        @Override // com.win.opensdk.cg
        public final void eIX() {
            y.this.a();
            if (y.this.qlW != null) {
                y.this.qlW.eIY();
            }
        }

        @Override // com.win.opensdk.cg
        public final void eIY() {
            if (y.this.qlW != null) {
                k unused = y.this.qlW;
            }
        }

        @Override // com.win.opensdk.cg
        public final boolean abQ(String str) {
            if (y.this.qlW != null) {
                return y.this.qlW.abQ(str);
            }
            return false;
        }
    }

    public final void abR(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, "text/html", "utf-8", null);
    }

    public final void eIX() {
        boolean z = true;
        if (!(System.currentTimeMillis() - this.f13769a < this.qkp)) {
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
            int[] ja = bi.ja(getViewContext());
            if (width <= 0 || i >= ja[0] || height <= 0 || i2 >= ja[1]) {
                z = false;
            }
            this.c = z;
            if (this.qjT != null) {
                this.qjT.b();
                this.qjT.Q(i, i2, getWidth(), getHeight());
                int i3 = getViewContext().getResources().getConfiguration().orientation;
                if (this.java != i3) {
                    this.java = i3;
                    this.qjT.eIY();
                    this.qjT.a();
                }
            }
            this.f13769a = System.currentTimeMillis();
        }
    }
}
