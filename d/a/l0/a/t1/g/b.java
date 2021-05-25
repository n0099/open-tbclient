package d.a.l0.a.t1.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.a2.n.d;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import d.a.l0.n.h.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44797a = k.f43199a;

    public static void a(Map<String, String> map, String str) {
        if (map == null) {
            return;
        }
        String b2 = b(map, "dynamicLibPath", 3);
        String b3 = b(map, "dynamicLibConfig", 3);
        String b4 = b(map, "pluginPath", 4);
        if (TextUtils.isEmpty(str) || !f44797a) {
            return;
        }
        d.a.l0.a.t1.d.a.a(str + ", dynamicLibPath = " + b2 + "; dynamicLibConfig = " + b3 + "; pluginPath = " + b4);
    }

    public static String b(Map<String, String> map, String str, int i2) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e i3 = e.i();
        String e2 = i3 != null ? i3.J().e(str, null) : null;
        if (!TextUtils.isEmpty(e2)) {
            map.put(str, e2);
            return e2;
        }
        SwanAppConfigData F = i3 != null ? i3.F() : null;
        if (i2 == 3) {
            d.a.l0.a.t1.b.a.f(F, false);
            e2 = i(str, null);
        } else if (i2 == 4) {
            e2 = l(F);
        }
        map.put(str, e2);
        return e2;
    }

    public static void c(String str, String str2) {
        e i2;
        if (TextUtils.isEmpty(str) || (i2 = e.i()) == null) {
            return;
        }
        i2.J().j(str, str2);
    }

    public static String d(List<d.a.l0.a.t1.f.a> list) {
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from (SELECT * from ");
        sb.append("swan_plugin");
        sb.append(" ORDER BY update_time) group by bundle_id having bundle_id in ");
        sb.append("(");
        for (int i2 = 0; i2 < size; i2++) {
            sb.append("'");
            sb.append(list.get(i2).f44794h);
            sb.append("'");
            if (i2 == size - 1) {
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            } else {
                sb.append(",");
            }
        }
        sb.append(";");
        return sb.toString();
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData b2 = d.b(str);
        if (b2 == null) {
            d.a.l0.a.t1.d.a.a("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.k kVar = b2.f11248d;
        if (kVar == null) {
            d.a.l0.a.t1.d.a.a("getDownloadKey, sub pkg obj is null");
            return null;
        }
        Map<String, String> map = kVar.f11286a;
        if (map == null) {
            d.a.l0.a.t1.d.a.a("getDownloadKey, sub pkg map is null");
            return null;
        }
        return map.get(str2);
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h g2 = g(str);
        if ((g2 == null || TextUtils.isEmpty(g2.r)) ? false : true) {
            return g2.r;
        }
        d.a.l0.a.t1.d.a.a("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static h g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.a.l0.a.t1.b.a.i(str, "0.0.0", 0L);
    }

    public static h h(String str) {
        SwanAppConfigData F;
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!d.a.l0.a.e0.f.e.e.d() && !d.a.l0.a.u1.a.a.G() && !d.a.l0.a.u1.a.a.C()) {
            return g(str);
        }
        e i2 = e.i();
        if (i2 != null && (F = i2.F()) != null && (list = F.k) != null) {
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.f48012g)) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public static String i(String str, String str2) {
        e i2 = e.i();
        if (i2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return i2.J().e(str, str2);
    }

    public static void j() {
        g W = f.V().W();
        if (W != null && (W.m() instanceof d.a.l0.a.h0.g.h)) {
            f.V().getActivity().onBackPressed();
        }
    }

    public static List<h> k(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("plugin_id");
                    if (!TextUtils.isEmpty(optString)) {
                        h hVar = new h();
                        hVar.f48012g = optString;
                        hVar.f48014i = optJSONObject.optLong("version_code", 0L);
                        hVar.j = optJSONObject.optString("version_name", "0.0.0");
                        hVar.p = optJSONObject.optString("token");
                        hVar.q = optJSONObject.optString("domains");
                        hVar.f48013h = 4;
                        hVar.r = optJSONObject.optString("app_key");
                        hVar.s = optJSONObject.optString("app_name");
                        hVar.l = "";
                        hVar.m = "";
                        hVar.n = "";
                        arrayList.add(hVar);
                        if (z) {
                            d.a.l0.n.g.a.h().l(hVar);
                        }
                    }
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
            return null;
        }
    }

    public static String l(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            d.a.l0.a.t1.d.a.a("parse app.json is null");
            return null;
        }
        List<d.a.l0.a.t1.f.a> h2 = swanAppConfigData.h(4);
        if (h2 != null && !h2.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (d.a.l0.a.t1.f.a aVar : h2) {
                if (aVar != null && aVar.b()) {
                    w.f(jSONObject, aVar.f44794h, aVar.j);
                }
            }
            String jSONObject2 = jSONObject.toString();
            c("pluginPath", jSONObject2);
            return jSONObject2;
        }
        c("pluginPath", null);
        d.a.l0.a.t1.d.a.a("this swan app not apply on someone plugin");
        return null;
    }
}
