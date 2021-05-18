package d.a.i0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    public static volatile n f47982b;

    /* renamed from: a  reason: collision with root package name */
    public String f47983a;

    public static n b() {
        if (f47982b == null) {
            synchronized (n.class) {
                if (f47982b == null) {
                    f47982b = new n();
                }
            }
        }
        return f47982b;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f47983a)) {
            this.f47983a = d.a.i0.n.c.b().j().getString("extract_js_url", null);
        }
        return this.f47983a;
    }

    public String c() {
        return d.a.i0.n.c.b().j().getString("tts_node_version", "0");
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (d.a.i0.n.c.f47808a) {
            Log.d("TTSConfigManager", WebGLImageLoader.DATA_URL + jSONObject);
        }
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || !optJSONObject.has("extract_js_url")) {
            return;
        }
        String optString2 = optJSONObject.optString("extract_js_url");
        d.a.i0.n.c.b().j().putString("tts_node_version", optString);
        d.a.i0.n.c.b().j().putString("extract_js_url", optString2);
    }
}
