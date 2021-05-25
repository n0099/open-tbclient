package d.a.l0.n.j.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import d.a.l0.t.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f48127b;

    /* renamed from: a  reason: collision with root package name */
    public a f48128a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("updatecore_node_ceres");
        }
    }

    public static b c() {
        if (f48127b == null) {
            synchronized (b.class) {
                if (f48127b == null) {
                    f48127b = new b();
                }
            }
        }
        return f48127b;
    }

    public String a() {
        return this.f48128a.getString("ceres_info", "0");
    }

    public String b() {
        return this.f48128a.getString("global_info", "0");
    }

    public d.a.l0.n.j.h.a d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (d.a.l0.n.c.f47984a) {
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
        this.f48128a.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new d.a.l0.n.j.h.a(optJSONArray, optJSONObject3);
    }
}
