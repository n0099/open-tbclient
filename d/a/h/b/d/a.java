package d.a.h.b.d;

import android.content.Context;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f43670d = BdSailor.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static a f43671e;

    /* renamed from: a  reason: collision with root package name */
    public Context f43672a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f43673b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43674c;

    public static a a() {
        a aVar = f43671e;
        if (aVar == null) {
            f43671e = new a();
        } else if (aVar.f43673b != null && (aVar.f43674c ^ BdZeusUtil.isWebkitLoaded())) {
            Log.d(f43670d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
            f43671e.f();
            f43671e.e();
        }
        return f43671e;
    }

    public static void b() {
        a a2 = a();
        a2.f();
        a2.f43672a = null;
        f43671e = null;
    }

    public final boolean c() {
        Log.d(f43670d, "BdWebViewSingleton pauseTimer");
        try {
            e();
            this.f43673b.pauseTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final boolean d() {
        Log.d(f43670d, "BdWebViewSingleton resumeTimer");
        try {
            e();
            this.f43673b.resumeTimers();
            return true;
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public final void e() {
        if (this.f43673b != null || this.f43672a == null) {
            return;
        }
        if (BdZeusUtil.isWebkitLoaded()) {
            this.f43674c = true;
        } else {
            this.f43674c = false;
            Log.d(f43670d, "BdWebViewSingleton init system webview,zeus was not load complete");
        }
        this.f43673b = new WebView(this.f43672a);
    }

    public final void f() {
        Log.w(f43670d, "BdWebViewSingleton, old instance has been destroyed");
        WebView webView = this.f43673b;
        if (webView != null) {
            webView.destroy();
            this.f43673b = null;
        }
    }
}
