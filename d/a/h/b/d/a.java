package d.a.h.b.d;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f43735d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f43736e;

    /* renamed from: a  reason: collision with root package name */
    public Context f43737a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f43738b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43739c;

    public static a a() {
        a aVar = f43736e;
        if (aVar == null) {
            f43736e = new a();
        } else if (aVar.f43738b != null && (aVar.f43739c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f43735d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f43736e.f();
            f43736e.e();
        }
        return f43736e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f43737a = null;
        f43736e = null;
    }

    public final boolean c() {
        Log.d(f43735d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f43738b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f43735d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f43738b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f43738b != null || this.f43737a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f43739c = true;
        } else {
            this.f43739c = false;
            Log.d(f43735d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f43738b = new WebView(this.f43737a);
    }

    public final void f() {
        Log.w(f43735d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f43738b;
        if (webView != null) {
            webView.destroy();
            this.f43738b = null;
        }
    }
}
