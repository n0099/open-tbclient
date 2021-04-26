package d.a.h.b.f;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f41065d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f41066e;

    /* renamed from: a  reason: collision with root package name */
    public Context f41067a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f41068b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41069c;

    public static a a() {
        a aVar = f41066e;
        if (aVar == null) {
            f41066e = new a();
        } else if (aVar.f41068b != null && (aVar.f41069c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f41065d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f41066e.f();
            f41066e.e();
        }
        return f41066e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f41067a = null;
        f41066e = null;
    }

    public final boolean c() {
        Log.d(f41065d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f41068b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f41065d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f41068b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f41068b != null || this.f41067a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f41069c = true;
        } else {
            this.f41069c = false;
            Log.d(f41065d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f41068b = new WebView(this.f41067a);
    }

    public final void f() {
        Log.w(f41065d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f41068b;
        if (webView != null) {
            webView.destroy();
            this.f41068b = null;
        }
    }
}
