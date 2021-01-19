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
    private long f13767a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f83a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13768b;
    private boolean c;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private af f84java;
    private Context pYJ;
    private boolean pYM;
    private long pZL;
    private Handler pZR;
    public q pZa;
    private long pZf;
    private boolean pZm;
    private h pZp;
    private final Runnable qak;
    private cg qbr;
    private k qbs;

    public y(Context context, af afVar) {
        this(context, afVar, (byte) 0);
    }

    private y(Context context, af afVar, byte b2) {
        this(context, afVar, (char) 0);
    }

    public y(Context context, af afVar, char c) {
        super(context.getApplicationContext(), null, 0);
        this.pZR = new Handler(Looper.getMainLooper());
        this.pZf = 1000L;
        this.pZL = 200L;
        this.qak = new Runnable() { // from class: com.win.opensdk.y.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!y.this.f83a) {
                    y.this.eGz();
                    y.this.pZR.postDelayed(this, y.this.pZf);
                }
            }
        };
        this.qbr = new a();
        this.f84java = afVar;
        this.pYJ = context;
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
        this.pZp = new j(this);
        setWebViewClient(new n(this, this.pZp));
        setWebChromeClient(new l(this, this.pZp));
    }

    public q getAttachView() {
        return this.pZa;
    }

    public cg getDispatcher() {
        return this.qbr;
    }

    public ag getMraidState() {
        return ag.STATE_DEFAULT;
    }

    public af getMraidMideaType() {
        return this.f84java;
    }

    public void setMraidListener(k kVar) {
        this.qbs = kVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f13768b = true;
        return super.onTouchEvent(motionEvent);
    }

    public final boolean java() {
        return this.c && this.pYM;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ej(i, getVisibility());
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ej(getWindowVisibility(), i);
    }

    private void ej(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.pYM = true;
            a();
        } else {
            this.pYM = false;
            b();
        }
        this.pZp.b();
    }

    public Context getViewContext() {
        if (this.pYJ == null) {
            this.pYJ = getContext();
        }
        return this.pYJ instanceof MutableContextWrapper ? ((MutableContextWrapper) this.pYJ).getBaseContext() : this.pYJ;
    }

    public final boolean eGX() {
        return this.f84java == af.INTERSTITIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m79a() {
        return this.f84java == af.Video;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.pZm = z;
    }

    public void eGA() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.pYM) {
            this.f83a = false;
            this.pZR.removeCallbacks(this.qak);
            this.pZR.post(this.qak);
        }
    }

    private void b() {
        this.f83a = true;
        this.pZR.removeCallbacks(this.qak);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.pZR != null) {
                this.pZR.removeCallbacksAndMessages(null);
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
        h pZp;

        public Ccase(Context context, af afVar, h hVar) {
            this(context, afVar, hVar, (byte) 0);
        }

        private Ccase(Context context, af afVar, h hVar, byte b2) {
            this(context, afVar, hVar, (char) 0);
        }

        private Ccase(Context context, af afVar, h hVar, char c) {
            super(context, afVar, (char) 0);
            this.pZp = hVar;
        }

        @Override // com.win.opensdk.y
        public final ag getMraidState() {
            return ag.STATE_EXPANDED;
        }

        @Override // com.win.opensdk.y
        public final void eGA() {
            super.eGA();
            this.pZp.eGz();
        }
    }

    /* loaded from: classes3.dex */
    class a implements cg {
        a() {
        }

        @Override // com.win.opensdk.cg
        public final void eGz() {
            y.this.a();
            if (y.this.qbs != null) {
                y.this.qbs.eGA();
            }
        }

        @Override // com.win.opensdk.cg
        public final void eGA() {
            if (y.this.qbs != null) {
                k unused = y.this.qbs;
            }
        }

        @Override // com.win.opensdk.cg
        public final boolean aaD(String str) {
            if (y.this.qbs != null) {
                return y.this.qbs.aaD(str);
            }
            return false;
        }
    }

    public final void aaE(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, "text/html", "utf-8", null);
    }

    public final void eGz() {
        boolean z = true;
        if (!(System.currentTimeMillis() - this.f13767a < this.pZL)) {
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
            int[] iX = bi.iX(getViewContext());
            if (width <= 0 || i >= iX[0] || height <= 0 || i2 >= iX[1]) {
                z = false;
            }
            this.c = z;
            if (this.pZp != null) {
                this.pZp.b();
                this.pZp.S(i, i2, getWidth(), getHeight());
                int i3 = getViewContext().getResources().getConfiguration().orientation;
                if (this.java != i3) {
                    this.java = i3;
                    this.pZp.eGA();
                    this.pZp.a();
                }
            }
            this.f13767a = System.currentTimeMillis();
        }
    }
}
