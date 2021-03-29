package d.b.h.b.f;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f49488d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f49489e;

    /* renamed from: a  reason: collision with root package name */
    public Context f49490a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f49491b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49492c;

    public static a a() {
        a aVar = f49489e;
        if (aVar == null) {
            f49489e = new a();
        } else if (aVar.f49491b != null && (aVar.f49492c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f49488d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f49489e.f();
            f49489e.e();
        }
        return f49489e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f49490a = null;
        f49489e = null;
    }

    public final boolean c() {
        Log.d(f49488d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f49491b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f49488d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f49491b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f49491b != null || this.f49490a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f49492c = true;
        } else {
            this.f49492c = false;
            Log.d(f49488d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f49491b = new WebView(this.f49490a);
    }

    public final void f() {
        Log.w(f49488d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f49491b;
        if (webView != null) {
            webView.destroy();
            this.f49491b = null;
        }
    }
}
