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
    private Context qiN;
    private boolean qiQ;
    private long qjP;
    private Handler qjV;
    public q qje;
    private long qjj;
    private boolean qjq;
    private h qjt;
    private final Runnable qko;
    private cg qlv;
    private k qlw;

    public y(Context context, af afVar) {
        this(context, afVar, (byte) 0);
    }

    private y(Context context, af afVar, byte b2) {
        this(context, afVar, (char) 0);
    }

    public y(Context context, af afVar, char c) {
        super(context.getApplicationContext(), null, 0);
        this.qjV = new Handler(Looper.getMainLooper());
        this.qjj = 1000L;
        this.qjP = 200L;
        this.qko = new Runnable() { // from class: com.win.opensdk.y.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!y.this.f83a) {
                    y.this.eIP();
                    y.this.qjV.postDelayed(this, y.this.qjj);
                }
            }
        };
        this.qlv = new a();
        this.f84java = afVar;
        this.qiN = context;
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
        this.qjt = new j(this);
        setWebViewClient(new n(this, this.qjt));
        setWebChromeClient(new l(this, this.qjt));
    }

    public q getAttachView() {
        return this.qje;
    }

    public cg getDispatcher() {
        return this.qlv;
    }

    public ag getMraidState() {
        return ag.STATE_DEFAULT;
    }

    public af getMraidMideaType() {
        return this.f84java;
    }

    public void setMraidListener(k kVar) {
        this.qlw = kVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f13770b = true;
        return super.onTouchEvent(motionEvent);
    }

    public final boolean java() {
        return this.c && this.qiQ;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        eg(i, getVisibility());
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        eg(getWindowVisibility(), i);
    }

    private void eg(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.qiQ = true;
            a();
        } else {
            this.qiQ = false;
            b();
        }
        this.qjt.b();
    }

    public Context getViewContext() {
        if (this.qiN == null) {
            this.qiN = getContext();
        }
        return this.qiN instanceof MutableContextWrapper ? ((MutableContextWrapper) this.qiN).getBaseContext() : this.qiN;
    }

    public final boolean eJn() {
        return this.f84java == af.INTERSTITIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m79a() {
        return this.f84java == af.Video;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.qjq = z;
    }

    public void eIQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.qiQ) {
            this.f83a = false;
            this.qjV.removeCallbacks(this.qko);
            this.qjV.post(this.qko);
        }
    }

    private void b() {
        this.f83a = true;
        this.qjV.removeCallbacks(this.qko);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.qjV != null) {
                this.qjV.removeCallbacksAndMessages(null);
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
        h qjt;

        public Ccase(Context context, af afVar, h hVar) {
            this(context, afVar, hVar, (byte) 0);
        }

        private Ccase(Context context, af afVar, h hVar, byte b2) {
            this(context, afVar, hVar, (char) 0);
        }

        private Ccase(Context context, af afVar, h hVar, char c) {
            super(context, afVar, (char) 0);
            this.qjt = hVar;
        }

        @Override // com.win.opensdk.y
        public final ag getMraidState() {
            return ag.STATE_EXPANDED;
        }

        @Override // com.win.opensdk.y
        public final void eIQ() {
            super.eIQ();
            this.qjt.eIP();
        }
    }

    /* loaded from: classes3.dex */
    class a implements cg {
        a() {
        }

        @Override // com.win.opensdk.cg
        public final void eIP() {
            y.this.a();
            if (y.this.qlw != null) {
                y.this.qlw.eIQ();
            }
        }

        @Override // com.win.opensdk.cg
        public final void eIQ() {
            if (y.this.qlw != null) {
                k unused = y.this.qlw;
            }
        }

        @Override // com.win.opensdk.cg
        public final boolean abE(String str) {
            if (y.this.qlw != null) {
                return y.this.qlw.abE(str);
            }
            return false;
        }
    }

    public final void abF(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, "text/html", "utf-8", null);
    }

    public final void eIP() {
        boolean z = true;
        if (!(System.currentTimeMillis() - this.f13769a < this.qjP)) {
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
            if (this.qjt != null) {
                this.qjt.b();
                this.qjt.Q(i, i2, getWidth(), getHeight());
                int i3 = getViewContext().getResources().getConfiguration().orientation;
                if (this.java != i3) {
                    this.java = i3;
                    this.qjt.eIQ();
                    this.qjt.a();
                }
            }
            this.f13769a = System.currentTimeMillis();
        }
    }
}
