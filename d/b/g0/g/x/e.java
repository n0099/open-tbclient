package d.b.g0.g.x;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48672b = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f48673a;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(d.b.g0.g.i.b bVar) {
        this.f48673a = bVar;
        a();
        b();
    }

    public final boolean a() {
        return c(this.f48673a.getInitBasePath(), "swan-game-open-data.js");
    }

    public final boolean b() {
        String h2 = d.b.g0.a.z0.f.V().h();
        String b2 = f.a().b();
        if (f48672b) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + h2);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + b2);
        }
        return c(h2, b2);
    }

    public final boolean c(String str, String str2) {
        if (!f.a().c() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.f48673a.V().b(str, str2);
        return true;
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.f48673a.V().a();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.f48673a.Z().dispatchEvent(new JSEvent("postmessage", jsObject));
    }
}
