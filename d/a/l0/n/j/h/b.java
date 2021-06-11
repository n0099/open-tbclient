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
    public static volatile b f51801b;

    /* renamed from: a  reason: collision with root package name */
    public a f51802a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("updatecore_node_ceres");
        }
    }

    public static b c() {
        if (f51801b == null) {
            synchronized (b.class) {
                if (f51801b == null) {
                    f51801b = new b();
                }
            }
        }
        return f51801b;
    }

    public String a() {
        return this.f51802a.getString("ceres_info", "0");
    }

    public String b() {
        return this.f51802a.getString("global_info", "0");
    }

    public d.a.l0.n.j.h.a d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (d.a.l0.n.c.f51658a) {
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
        this.f51802a.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new d.a.l0.n.j.h.a(optJSONArray, optJSONObject3);
    }
}
