package d.a.m0.n.j.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import d.a.m0.t.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f51909b;

    /* renamed from: a  reason: collision with root package name */
    public a f51910a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("updatecore_node_ceres");
        }
    }

    public static b c() {
        if (f51909b == null) {
            synchronized (b.class) {
                if (f51909b == null) {
                    f51909b = new b();
                }
            }
        }
        return f51909b;
    }

    public String a() {
        return this.f51910a.getString("ceres_info", "0");
    }

    public String b() {
        return this.f51910a.getString("global_info", "0");
    }

    public d.a.m0.n.j.h.a d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (d.a.m0.n.c.f51766a) {
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
        this.f51910a.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new d.a.m0.n.j.h.a(optJSONArray, optJSONObject3);
    }
}
