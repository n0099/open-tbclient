package d.a.h.b.d;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f39989d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f39990e;

    /* renamed from: a  reason: collision with root package name */
    public Context f39991a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f39992b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39993c;

    public static a a() {
        a aVar = f39990e;
        if (aVar == null) {
            f39990e = new a();
        } else if (aVar.f39992b != null && (aVar.f39993c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f39989d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f39990e.f();
            f39990e.e();
        }
        return f39990e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f39991a = null;
        f39990e = null;
    }

    public final boolean c() {
        Log.d(f39989d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f39992b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f39989d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f39992b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f39992b != null || this.f39991a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f39993c = true;
        } else {
            this.f39993c = false;
            Log.d(f39989d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f39992b = new WebView(this.f39991a);
    }

    public final void f() {
        Log.w(f39989d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f39992b;
        if (webView != null) {
            webView.destroy();
            this.f39992b = null;
        }
    }
}
