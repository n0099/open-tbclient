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
/* loaded from: classes4.dex */
public class y extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private long f14066a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f83a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14067b;
    private boolean c;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private af f84java;
    private Context qbB;
    private boolean qbE;
    public q qbS;
    private long qbX;
    private long qcD;
    private Handler qcJ;
    private boolean qce;
    private h qch;
    private final Runnable qdc;
    private cg qej;
    private k qek;

    public y(Context context, af afVar) {
        this(context, afVar, (byte) 0);
    }

    private y(Context context, af afVar, byte b2) {
        this(context, afVar, (char) 0);
    }

    public y(Context context, af afVar, char c) {
        super(context.getApplicationContext(), null, 0);
        this.qcJ = new Handler(Looper.getMainLooper());
        this.qbX = 1000L;
        this.qcD = 200L;
        this.qdc = new Runnable() { // from class: com.win.opensdk.y.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!y.this.f83a) {
                    y.this.eJL();
                    y.this.qcJ.postDelayed(this, y.this.qbX);
                }
            }
        };
        this.qej = new a();
        this.f84java = afVar;
        this.qbB = context;
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
        this.qch = new j(this);
        setWebViewClient(new n(this, this.qch));
        setWebChromeClient(new l(this, this.qch));
    }

    public q getAttachView() {
        return this.qbS;
    }

    public cg getDispatcher() {
        return this.qej;
    }

    public ag getMraidState() {
        return ag.STATE_DEFAULT;
    }

    public af getMraidMideaType() {
        return this.f84java;
    }

    public void setMraidListener(k kVar) {
        this.qek = kVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f14067b = true;
        return super.onTouchEvent(motionEvent);
    }

    public final boolean java() {
        return this.c && this.qbE;
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
            this.qbE = true;
            a();
        } else {
            this.qbE = false;
            b();
        }
        this.qch.b();
    }

    public Context getViewContext() {
        if (this.qbB == null) {
            this.qbB = getContext();
        }
        return this.qbB instanceof MutableContextWrapper ? ((MutableContextWrapper) this.qbB).getBaseContext() : this.qbB;
    }

    public final boolean eKj() {
        return this.f84java == af.INTERSTITIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m72a() {
        return this.f84java == af.Video;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.qce = z;
    }

    public void eJM() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.qbE) {
            this.f83a = false;
            this.qcJ.removeCallbacks(this.qdc);
            this.qcJ.post(this.qdc);
        }
    }

    private void b() {
        this.f83a = true;
        this.qcJ.removeCallbacks(this.qdc);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.qcJ != null) {
                this.qcJ.removeCallbacksAndMessages(null);
            }
            b();
            removeAllViews();
            stopLoading();
        } catch (Exception e) {
        }
        super.destroy();
    }

    /* renamed from: com.win.opensdk.y$case  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static class Ccase extends y {
        h qch;

        public Ccase(Context context, af afVar, h hVar) {
            this(context, afVar, hVar, (byte) 0);
        }

        private Ccase(Context context, af afVar, h hVar, byte b2) {
            this(context, afVar, hVar, (char) 0);
        }

        private Ccase(Context context, af afVar, h hVar, char c) {
            super(context, afVar, (char) 0);
            this.qch = hVar;
        }

        @Override // com.win.opensdk.y
        public final ag getMraidState() {
            return ag.STATE_EXPANDED;
        }

        @Override // com.win.opensdk.y
        public final void eJM() {
            super.eJM();
            this.qch.eJL();
        }
    }

    /* loaded from: classes4.dex */
    class a implements cg {
        a() {
        }

        @Override // com.win.opensdk.cg
        public final void eJL() {
            y.this.a();
            if (y.this.qek != null) {
                y.this.qek.eJM();
            }
        }

        @Override // com.win.opensdk.cg
        public final void eJM() {
            if (y.this.qek != null) {
                k unused = y.this.qek;
            }
        }

        @Override // com.win.opensdk.cg
        public final boolean abJ(String str) {
            if (y.this.qek != null) {
                return y.this.qek.abJ(str);
            }
            return false;
        }
    }

    public final void abK(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, "text/html", "utf-8", null);
    }

    public final void eJL() {
        boolean z = true;
        if (!(System.currentTimeMillis() - this.f14066a < this.qcD)) {
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
            int[] iZ = bi.iZ(getViewContext());
            if (width <= 0 || i >= iZ[0] || height <= 0 || i2 >= iZ[1]) {
                z = false;
            }
            this.c = z;
            if (this.qch != null) {
                this.qch.b();
                this.qch.S(i, i2, getWidth(), getHeight());
                int i3 = getViewContext().getResources().getConfiguration().orientation;
                if (this.java != i3) {
                    this.java = i3;
                    this.qch.eJM();
                    this.qch.a();
                }
            }
            this.f14066a = System.currentTimeMillis();
        }
    }
}
