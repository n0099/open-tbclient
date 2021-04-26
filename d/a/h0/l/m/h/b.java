package d.a.h0.l.m.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.node.Node;
import d.a.h0.l.f;
import d.a.h0.p.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f47255b;

    /* renamed from: a  reason: collision with root package name */
    public C0992b f47256a = new C0992b();

    /* renamed from: d.a.h0.l.m.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0992b extends i {
        public C0992b() {
            super("updatecore_node_ceres");
        }
    }

    public static b c() {
        if (f47255b == null) {
            synchronized (b.class) {
                if (f47255b == null) {
                    f47255b = new b();
                }
            }
        }
        return f47255b;
    }

    public String a() {
        return this.f47256a.getString("ceres_info", "0");
    }

    public String b() {
        return this.f47256a.getString("global_info", "0");
    }

    public d.a.h0.l.m.h.a d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (f.f47117a) {
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
        this.f47256a.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new d.a.h0.l.m.h.a(optJSONArray, optJSONObject3);
    }
}
