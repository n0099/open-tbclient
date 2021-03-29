package d.b.g0.l.m.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import d.b.g0.l.f;
import d.b.g0.p.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f49020b;

    /* renamed from: a  reason: collision with root package name */
    public C1021b f49021a = new C1021b();

    /* renamed from: d.b.g0.l.m.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1021b extends i {
        public C1021b() {
            super("updatecore_node_ceres");
        }
    }

    public static b c() {
        if (f49020b == null) {
            synchronized (b.class) {
                if (f49020b == null) {
                    f49020b = new b();
                }
            }
        }
        return f49020b;
    }

    public String a() {
        return this.f49021a.getString("ceres_info", "0");
    }

    public String b() {
        return this.f49021a.getString("global_info", "0");
    }

    public d.b.g0.l.m.h.a d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (f.f48889a) {
            Log.d(Node.TAG, "ceres info " + jSONObject.toString());
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ceres_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("global_info");
        if (optJSONObject == null || optJSONObject2 == null) {
            return null;
        }
        String optString = optJSONObject.optString("version");
        JSONArray optJSONArray = optJSONObject.optJSONArray("data");
        if (TextUtils.isEmpty(optString) || optJSONArray == null) {
            return null;
        }
        String optString2 = optJSONObject2.optString("version");
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("data");
        if (TextUtils.isEmpty(optString) || optJSONObject3 == null) {
            return null;
        }
        this.f49021a.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new d.b.g0.l.m.h.a(optJSONArray, optJSONObject3);
    }
}
