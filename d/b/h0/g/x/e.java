package d.b.h0.g.x;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49393b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.b f49394a;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(d.b.h0.g.i.b bVar) {
        this.f49394a = bVar;
        a();
        b();
    }

    public final boolean a() {
        return c(this.f49394a.getInitBasePath(), "swan-game-open-data.js");
    }

    public final boolean b() {
        String h2 = d.b.h0.a.z0.f.V().h();
        String b2 = f.a().b();
        if (f49393b) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + h2);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + b2);
        }
        return c(h2, b2);
    }

    public final boolean c(String str, String str2) {
        if (!f.a().c() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.f49394a.W().b(str, str2);
        return true;
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.f49394a.W().a();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.f49394a.Z().dispatchEvent(new JSEvent("postmessage", jsObject));
    }
}
