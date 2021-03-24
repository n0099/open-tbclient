package d.b.h.b.f;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f49487d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f49488e;

    /* renamed from: a  reason: collision with root package name */
    public Context f49489a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f49490b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49491c;

    public static a a() {
        a aVar = f49488e;
        if (aVar == null) {
            f49488e = new a();
        } else if (aVar.f49490b != null && (aVar.f49491c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f49487d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f49488e.f();
            f49488e.e();
        }
        return f49488e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f49489a = null;
        f49488e = null;
    }

    public final boolean c() {
        Log.d(f49487d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f49490b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f49487d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f49490b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f49490b != null || this.f49489a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f49491c = true;
        } else {
            this.f49491c = false;
            Log.d(f49487d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f49490b = new WebView(this.f49489a);
    }

    public final void f() {
        Log.w(f49487d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f49490b;
        if (webView != null) {
            webView.destroy();
            this.f49490b = null;
        }
    }
}
