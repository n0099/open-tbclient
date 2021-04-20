package d.b.h.b.f;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f49880d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f49881e;

    /* renamed from: a  reason: collision with root package name */
    public Context f49882a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f49883b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49884c;

    public static a a() {
        a aVar = f49881e;
        if (aVar == null) {
            f49881e = new a();
        } else if (aVar.f49883b != null && (aVar.f49884c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f49880d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f49881e.f();
            f49881e.e();
        }
        return f49881e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f49882a = null;
        f49881e = null;
    }

    public final boolean c() {
        Log.d(f49880d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f49883b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f49880d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f49883b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f49883b != null || this.f49882a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f49884c = true;
        } else {
            this.f49884c = false;
            Log.d(f49880d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f49883b = new WebView(this.f49882a);
    }

    public final void f() {
        Log.w(f49880d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f49883b;
        if (webView != null) {
            webView.destroy();
            this.f49883b = null;
        }
    }
}
