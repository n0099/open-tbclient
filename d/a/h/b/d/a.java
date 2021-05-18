package d.a.h.b.d;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f40305d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f40306e;

    /* renamed from: a  reason: collision with root package name */
    public Context f40307a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f40308b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40309c;

    public static a a() {
        a aVar = f40306e;
        if (aVar == null) {
            f40306e = new a();
        } else if (aVar.f40308b != null && (aVar.f40309c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f40305d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f40306e.f();
            f40306e.e();
        }
        return f40306e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f40307a = null;
        f40306e = null;
    }

    public final boolean c() {
        Log.d(f40305d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f40308b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f40305d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f40308b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f40308b != null || this.f40307a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f40309c = true;
        } else {
            this.f40309c = false;
            Log.d(f40305d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f40308b = new WebView(this.f40307a);
    }

    public final void f() {
        Log.w(f40305d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f40308b;
        if (webView != null) {
            webView.destroy();
            this.f40308b = null;
        }
    }
}
