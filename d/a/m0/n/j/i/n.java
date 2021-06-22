package d.a.m0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    public static volatile n f51940b;

    /* renamed from: a  reason: collision with root package name */
    public String f51941a;

    public static n b() {
        if (f51940b == null) {
            synchronized (n.class) {
                if (f51940b == null) {
                    f51940b = new n();
                }
            }
        }
        return f51940b;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f51941a)) {
            this.f51941a = d.a.m0.n.c.b().j().getString("extract_js_url", null);
        }
        return this.f51941a;
    }

    public String c() {
        return d.a.m0.n.c.b().j().getString("tts_node_version", "0");
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (d.a.m0.n.c.f51766a) {
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
        d.a.m0.n.c.b().j().putString("tts_node_version", optString);
        d.a.m0.n.c.b().j().putString("extract_js_url", optString2);
    }
}
