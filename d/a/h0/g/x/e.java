package d.a.h0.g.x;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46891b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.b f46892a;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(d.a.h0.g.i.b bVar) {
        this.f46892a = bVar;
        a();
        b();
    }

    public final boolean a() {
        return c(this.f46892a.getInitBasePath(), "swan-game-open-data.js");
    }

    public final boolean b() {
        String A = d.a.h0.a.z0.f.V().A();
        String b2 = f.a().b();
        if (f46891b) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + A);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + b2);
        }
        return c(A, b2);
    }

    public final boolean c(String str, String str2) {
        if (!f.a().c() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.f46892a.c0().b(str, str2);
        return true;
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.f46892a.c0().a();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.f46892a.x().dispatchEvent(new JSEvent("postmessage", jsObject));
    }
}
