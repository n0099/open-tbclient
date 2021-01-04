package com.qq.e.comm.plugin.ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
class d extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.ab.b.b f12047a = new com.qq.e.comm.plugin.ab.b.b("webviewLayout", null);

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.b.a f12048b;
    private List<com.qq.e.comm.plugin.ab.a.b> c;
    private final c d;
    private Map<String, Object> e;
    private boolean f;
    private com.qq.e.comm.plugin.a.d.a g;
    private boolean h;
    private boolean i;
    private boolean j;
    private h.a k;
    private int l;

    public d(Context context, c cVar) {
        super(context);
        this.c = new ArrayList();
        this.e = new HashMap();
        this.h = false;
        this.i = false;
        this.j = false;
        this.l = -1;
        setWebViewClient(new f());
        k();
        this.d = cVar;
        j();
        h();
        b();
        l();
        m();
        if (cVar != null && cVar.c() == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            i();
        }
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " GDTMobSDK/" + SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
        resumeTimers();
    }

    private void h() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        getSettings().setSavePassword(false);
    }

    private void i() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.qq.e.comm.plugin.ab.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qq.e.comm.plugin.ab.d.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
    }

    private void j() {
        this.g = new com.qq.e.comm.plugin.a.d.a() { // from class: com.qq.e.comm.plugin.ab.d.3
            @Override // com.qq.e.comm.plugin.a.d.a
            public void a(String str, int i, int i2, long j) {
                HashMap hashMap = new HashMap();
                hashMap.put(PushClientConstants.TAG_PKG_NAME, str);
                hashMap.put("status", Integer.valueOf(i));
                hashMap.put("progress", Integer.valueOf(i2));
                hashMap.put("totalSize", Long.valueOf(j));
                d.this.a().a(new com.qq.e.comm.plugin.ab.b.b("apkStatusChange", new JSONObject(hashMap)));
            }
        };
    }

    private void k() {
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void l() {
        getSettings().setJavaScriptEnabled(true);
    }

    @SuppressLint({"NewApi"})
    private void m() {
        if (Build.VERSION.SDK_INT >= 19) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    private void n() {
        if (this.h) {
            return;
        }
        this.h = true;
        com.qq.e.comm.plugin.a.l.a().a(this.g);
    }

    private void o() {
        this.h = false;
        com.qq.e.comm.plugin.a.l.a().b(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View] */
    public int a(boolean z) {
        while (this != null && (z || (this.getParent() != null && (this.getParent() instanceof View)))) {
            if (this.getVisibility() != 0) {
                return this.getVisibility();
            }
            this = (this.getParent() == null || !(this.getParent() instanceof View)) ? null : (View) this.getParent();
        }
        return 0;
    }

    public com.qq.e.comm.plugin.ab.b.a a() {
        return this.f12048b;
    }

    public void a(com.qq.e.comm.plugin.ab.a.a aVar) {
        if (this.c != null) {
            for (com.qq.e.comm.plugin.ab.a.b bVar : this.c) {
                bVar.a(aVar);
            }
        }
    }

    public void a(com.qq.e.comm.plugin.ab.a.b bVar) {
        this.c.add(bVar);
    }

    public void a(com.qq.e.comm.plugin.ab.b.a aVar) {
        this.f12048b = aVar;
    }

    public void a(h.a aVar) {
        this.k = aVar;
    }

    public void a(Collection<com.qq.e.comm.plugin.ab.c.e> collection) {
        if (collection != null) {
            for (com.qq.e.comm.plugin.ab.c.e eVar : collection) {
                this.f12048b.a(eVar.b(), eVar);
            }
        }
    }

    public void b() {
        WebSettings settings = getSettings();
        String absolutePath = ah.a(getContext()).getAbsolutePath();
        GDTLogger.d("AppCache Path=" + absolutePath);
        settings.setAllowFileAccess(true);
        settings.setAppCachePath(absolutePath);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAppCacheEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
    }

    public List<com.qq.e.comm.plugin.ab.a.b> c() {
        return this.c;
    }

    public c d() {
        return this.d;
    }

    public void e() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) getParent()).removeView(this);
    }

    public void f() {
        if (this.j) {
            return;
        }
        try {
            loadUrl("about:blank");
            e();
            removeAllViews();
            destroy();
            this.j = true;
        } catch (Exception e) {
            GDTLogger.w("ExceptionWhileDestroyWebview", e);
        }
    }

    public boolean g() {
        return this.j;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        GDTLogger.d("OnWebViewAttachedToWindow");
        super.onAttachedToWindow();
        this.f = true;
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GDTLogger.d("OnWebViewDetachedFromWindow");
        super.onDetachedFromWindow();
        this.f = false;
        o();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        GDTLogger.d("GDTAdWebView getContentHeight() is " + getContentHeight() + ", lastHeight is " + this.l + ", view is " + hashCode());
        if (getContentHeight() != this.l) {
            this.l = getContentHeight();
        }
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        GDTLogger.d("InWebView OnLayout Method" + getVisibility() + ":" + getWindowVisibility() + ":" + getWidth() + "/" + getHeight());
        super.onLayout(z, i, i2, i3, i4);
        if (!this.i) {
            this.i = true;
            this.f12048b.a(f12047a);
        }
        if (this.k != null) {
            this.k.j();
        }
    }
}
