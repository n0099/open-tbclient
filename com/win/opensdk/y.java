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
    private long f14067a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f84a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14068b;
    private boolean c;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private af f85java;
    public q qdA;
    private long qdF;
    private boolean qdM;
    private h qdP;
    private Context qdj;
    private boolean qdm;
    private final Runnable qeK;
    private long qel;
    private Handler qer;
    private cg qfR;
    private k qfS;

    public y(Context context, af afVar) {
        this(context, afVar, (byte) 0);
    }

    private y(Context context, af afVar, byte b2) {
        this(context, afVar, (char) 0);
    }

    public y(Context context, af afVar, char c) {
        super(context.getApplicationContext(), null, 0);
        this.qer = new Handler(Looper.getMainLooper());
        this.qdF = 1000L;
        this.qel = 200L;
        this.qeK = new Runnable() { // from class: com.win.opensdk.y.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!y.this.f84a) {
                    y.this.eKp();
                    y.this.qer.postDelayed(this, y.this.qdF);
                }
            }
        };
        this.qfR = new a();
        this.f85java = afVar;
        this.qdj = context;
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
        this.qdP = new j(this);
        setWebViewClient(new n(this, this.qdP));
        setWebChromeClient(new l(this, this.qdP));
    }

    public q getAttachView() {
        return this.qdA;
    }

    public cg getDispatcher() {
        return this.qfR;
    }

    public ag getMraidState() {
        return ag.STATE_DEFAULT;
    }

    public af getMraidMideaType() {
        return this.f85java;
    }

    public void setMraidListener(k kVar) {
        this.qfS = kVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f14068b = true;
        return super.onTouchEvent(motionEvent);
    }

    public final boolean java() {
        return this.c && this.qdm;
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
            this.qdm = true;
            a();
        } else {
            this.qdm = false;
            b();
        }
        this.qdP.b();
    }

    public Context getViewContext() {
        if (this.qdj == null) {
            this.qdj = getContext();
        }
        return this.qdj instanceof MutableContextWrapper ? ((MutableContextWrapper) this.qdj).getBaseContext() : this.qdj;
    }

    public final boolean eKN() {
        return this.f85java == af.INTERSTITIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m83a() {
        return this.f85java == af.Video;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.qdM = z;
    }

    public void eKq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.qdm) {
            this.f84a = false;
            this.qer.removeCallbacks(this.qeK);
            this.qer.post(this.qeK);
        }
    }

    private void b() {
        this.f84a = true;
        this.qer.removeCallbacks(this.qeK);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.qer != null) {
                this.qer.removeCallbacksAndMessages(null);
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
        h qdP;

        public Ccase(Context context, af afVar, h hVar) {
            this(context, afVar, hVar, (byte) 0);
        }

        private Ccase(Context context, af afVar, h hVar, byte b2) {
            this(context, afVar, hVar, (char) 0);
        }

        private Ccase(Context context, af afVar, h hVar, char c) {
            super(context, afVar, (char) 0);
            this.qdP = hVar;
        }

        @Override // com.win.opensdk.y
        public final ag getMraidState() {
            return ag.STATE_EXPANDED;
        }

        @Override // com.win.opensdk.y
        public final void eKq() {
            super.eKq();
            this.qdP.eKp();
        }
    }

    /* loaded from: classes4.dex */
    class a implements cg {
        a() {
        }

        @Override // com.win.opensdk.cg
        public final void eKp() {
            y.this.a();
            if (y.this.qfS != null) {
                y.this.qfS.eKq();
            }
        }

        @Override // com.win.opensdk.cg
        public final void eKq() {
            if (y.this.qfS != null) {
                k unused = y.this.qfS;
            }
        }

        @Override // com.win.opensdk.cg
        public final boolean abK(String str) {
            if (y.this.qfS != null) {
                return y.this.qfS.abK(str);
            }
            return false;
        }
    }

    public final void abL(String str) {
        loadDataWithBaseURL("http://mr.hiking.com", str, "text/html", "utf-8", null);
    }

    public final void eKp() {
        boolean z = true;
        if (!(System.currentTimeMillis() - this.f14067a < this.qel)) {
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
            if (this.qdP != null) {
                this.qdP.b();
                this.qdP.S(i, i2, getWidth(), getHeight());
                int i3 = getViewContext().getResources().getConfiguration().orientation;
                if (this.java != i3) {
                    this.java = i3;
                    this.qdP.eKq();
                    this.qdP.a();
                }
            }
            this.f14067a = System.currentTimeMillis();
        }
    }
}
