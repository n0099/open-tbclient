package d.b.h.b.f;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f43807d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f43808e;

    /* renamed from: a  reason: collision with root package name */
    public Context f43809a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f43810b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43811c;

    public static a a() {
        a aVar = f43808e;
        if (aVar == null) {
            f43808e = new a();
        } else if (aVar.f43810b != null && (aVar.f43811c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f43807d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f43808e.f();
            f43808e.e();
        }
        return f43808e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f43809a = null;
        f43808e = null;
    }

    public final boolean c() {
        Log.d(f43807d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f43810b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f43807d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f43810b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f43810b != null || this.f43809a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f43811c = true;
        } else {
            this.f43811c = false;
            Log.d(f43807d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f43810b = new WebView(this.f43809a);
    }

    public final void f() {
        Log.w(f43807d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f43810b;
        if (webView != null) {
            webView.destroy();
            this.f43810b = null;
        }
    }
}
