package com.qq.e.comm.plugin.ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class l extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.ab.b.b f12123a = new com.qq.e.comm.plugin.ab.b.b("webviewLayout", null);

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.b.a f12124b;
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
    private final String[] m;

    public l(Context context, c cVar) {
        super(context);
        this.c = new ArrayList();
        this.e = new HashMap();
        this.h = false;
        this.i = false;
        this.j = false;
        this.l = -1;
        this.m = new String[]{"searchBoxJavaBridge_", "accessibility", "accessibilityTraversal"};
        setWillNotDraw(false);
        this.d = cVar;
        setWebViewClient(new m());
        j();
        k();
        l();
        b();
        m();
        n();
        if (cVar != null && cVar.c() == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            i();
        }
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " GDTMobSDK/" + SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
        resumeTimers();
    }

    private void i() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.qq.e.comm.plugin.ab.l.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qq.e.comm.plugin.ab.l.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        IX5WebViewExtension x5WebViewExtension = getX5WebViewExtension();
        if (x5WebViewExtension != null) {
            x5WebViewExtension.setScrollBarFadingEnabled(false);
        }
    }

    private void j() {
    }

    private void k() {
        this.g = new com.qq.e.comm.plugin.a.d.a() { // from class: com.qq.e.comm.plugin.ab.l.3
            @Override // com.qq.e.comm.plugin.a.d.a
            public void a(String str, int i, int i2, long j) {
                HashMap hashMap = new HashMap();
                hashMap.put(PushClientConstants.TAG_PKG_NAME, str);
                hashMap.put("status", Integer.valueOf(i));
                hashMap.put("progress", Integer.valueOf(i2));
                hashMap.put("totalSize", Long.valueOf(j));
                l.this.c().a(new com.qq.e.comm.plugin.ab.b.b("apkStatusChange", new JSONObject(hashMap)));
            }
        };
    }

    private void l() {
        try {
            for (String str : this.m) {
                removeJavascriptInterface(str);
            }
        } catch (Throwable th) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m() {
        getSettings().setJavaScriptEnabled(true);
    }

    @SuppressLint({"NewApi"})
    private void n() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void o() {
        if (this.h) {
            return;
        }
        this.h = true;
        com.qq.e.comm.plugin.a.l.a().a(this.g);
    }

    private void p() {
        this.h = false;
        com.qq.e.comm.plugin.a.l.a().b(this.g);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0000 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0000 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.qq.e.comm.plugin.ab.l] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int a(boolean z) {
        while (this != 0 && (z || (this.getParent() != null && (this.getParent() instanceof View)))) {
            if (this.getVisibility() != 0) {
                return this.getVisibility();
            }
            this = (this.getParent() == null || !(this.getParent() instanceof View)) ? 0 : (View) this.getParent();
        }
        return 0;
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
        this.f12124b = aVar;
    }

    public void a(h.a aVar) {
        this.k = aVar;
    }

    public void a(Collection<com.qq.e.comm.plugin.ab.c.e> collection) {
        if (collection != null) {
            for (com.qq.e.comm.plugin.ab.c.e eVar : collection) {
                this.f12124b.a(eVar.b(), eVar);
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

    public com.qq.e.comm.plugin.ab.b.a c() {
        return this.f12124b;
    }

    public List<com.qq.e.comm.plugin.ab.a.b> d() {
        return this.c;
    }

    public c e() {
        return this.d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.qq.e.comm.plugin.ab.l */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) getParent()).removeView(this);
    }

    public void g() {
        if (this.j) {
            return;
        }
        try {
            loadUrl("about:blank");
            f();
            removeAllViews();
            destroy();
            this.j = true;
        } catch (Exception e) {
            GDTLogger.w("X5 ExceptionWhileDestroyWebview", e);
        }
    }

    public boolean h() {
        return this.j;
    }

    protected void onAttachedToWindow() {
        GDTLogger.d("X5 OnWebViewAttachedToWindow");
        super.onAttachedToWindow();
        this.f = true;
        o();
    }

    protected void onDetachedFromWindow() {
        GDTLogger.d("X5 OnWebViewDetachedFromWindow");
        super.onDetachedFromWindow();
        this.f = false;
        p();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        GDTLogger.d("X5AdWebView onDraw getContentHeight() is " + getContentHeight() + ", lastHeight is " + this.l + ", view is " + hashCode());
        if (getContentHeight() != this.l) {
            this.l = getContentHeight();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        GDTLogger.d("X5-InWebView OnLayout Method" + getVisibility() + ":" + getWindowVisibility() + ":" + getWidth() + "/" + getHeight());
        super.onLayout(z, i, i2, i3, i4);
        if (!this.i) {
            this.i = true;
            this.f12124b.a(f12123a);
        }
        if (this.k != null) {
            this.k.j();
        }
    }
}
