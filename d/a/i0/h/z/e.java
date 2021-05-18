package d.a.i0.h.z;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47633b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.c f47634a;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(d.a.i0.a.l0.c cVar) {
        this.f47634a = cVar;
        a();
        b();
    }

    public final boolean a() {
        return c(this.f47634a.getInitBasePath(), "swan-game-open-data.js");
    }

    public final boolean b() {
        String A = d.a.i0.a.g1.f.V().A();
        String b2 = f.a().b();
        if (f47633b) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + A);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + b2);
        }
        return c(A, b2);
    }

    public final boolean c(String str, String str2) {
        if (!f.a().c() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.f47634a.e0().b(str, str2);
        return true;
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.f47634a.e0().a();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.f47634a.z().dispatchEvent(new JSEvent("postmessage", jsObject));
    }
}
