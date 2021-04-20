package d.b.g0.a.l1.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.l.g;
import d.b.g0.a.j1.m.c;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.l.k.h;
import d.b.g0.p.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45619a = k.f45443a;

    public static void a(Map<String, String> map, String str) {
        if (map == null) {
            return;
        }
        String b2 = b(map, "dynamicLibPath", 3);
        String b3 = b(map, "dynamicLibConfig", 3);
        String b4 = b(map, "pluginPath", 4);
        if (TextUtils.isEmpty(str) || !f45619a) {
            return;
        }
        d.b.g0.a.l1.d.a.a(str + ", dynamicLibPath = " + b2 + "; dynamicLibConfig = " + b3 + "; pluginPath = " + b4);
    }

    public static String b(Map<String, String> map, String str, int i) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e y = e.y();
        String e2 = y != null ? y.H().e(str, null) : null;
        if (!TextUtils.isEmpty(e2)) {
            map.put(str, e2);
            return e2;
        }
        SwanAppConfigData D = y != null ? y.D() : null;
        if (i == 3) {
            if (c.d()) {
                d.b.g0.a.l1.b.a.f(D, false);
            } else {
                d.b.g0.a.l1.b.a.e(D, false);
            }
            e2 = h(str, null);
        } else if (i == 4) {
            if (c.d()) {
                e2 = l(D);
            } else {
                e2 = k(D);
            }
        }
        map.put(str, e2);
        return e2;
    }

    public static void c(String str, String str2) {
        e y;
        if (TextUtils.isEmpty(str) || (y = e.y()) == null) {
            return;
        }
        y.H().j(str, str2);
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SwanAppConfigData c2 = SwanAppConfigData.c(d.r(new File(str, "app.json")), new File(str));
        if (c2 == null) {
            d.b.g0.a.l1.d.a.a("getDownloadKey, app.json is null");
            return null;
        }
        SwanAppConfigData.i iVar = c2.f12276c;
        if (iVar == null) {
            d.b.g0.a.l1.d.a.a("getDownloadKey, sub pkg obj is null");
            return null;
        }
        HashMap<String, String> hashMap = iVar.f12298a;
        if (hashMap == null) {
            d.b.g0.a.l1.d.a.a("getDownloadKey, sub pkg map is null");
            return null;
        }
        return hashMap.get(str2);
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h f2 = f(str);
        if ((f2 == null || TextUtils.isEmpty(f2.r)) ? false : true) {
            return f2.r;
        }
        d.b.g0.a.l1.d.a.a("get plugin appKey form db, but empty, plugin appId = " + str);
        return null;
    }

    public static h f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.b.g0.l.i.a.h().p(str, "0.0.0");
    }

    public static h g(String str) {
        SwanAppConfigData D;
        List<h> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!d.b.g0.a.c0.d.d.e.d() && !d.b.g0.a.m1.a.a.C()) {
            return f(str);
        }
        e y = e.y();
        if (y != null && (D = y.D()) != null && (list = D.k) != null) {
            for (h hVar : list) {
                if (TextUtils.equals(str, hVar.f49315g)) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public static String h(String str, String str2) {
        e y = e.y();
        if (y == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return y.H().e(str, str2);
    }

    public static void i() {
        f W = d.b.g0.a.z0.f.V().W();
        if (W != null && (W.m() instanceof g)) {
            d.b.g0.a.z0.f.V().getActivity().onBackPressed();
        }
    }

    public static List<h> j(String str, boolean z) {
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
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("plugin_id");
                    if (!TextUtils.isEmpty(optString)) {
                        h hVar = new h();
                        hVar.f49315g = optString;
                        hVar.i = optJSONObject.optInt("version_code");
                        hVar.j = optJSONObject.optString("version_name", "0.0.0");
                        hVar.p = optJSONObject.optString("token");
                        hVar.q = optJSONObject.optString("domains");
                        hVar.f49316h = 4;
                        hVar.r = optJSONObject.optString(com.alipay.sdk.cons.b.f1883h);
                        hVar.s = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                        hVar.l = "";
                        hVar.m = "";
                        hVar.n = "";
                        arrayList.add(hVar);
                        if (z) {
                            d.b.g0.l.i.a.h().l(hVar);
                        }
                    }
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
            return null;
        }
    }

    public static String k(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            d.b.g0.a.l1.d.a.a("parse app.json is null");
            return null;
        }
        List<d.b.g0.a.l1.f.a> h2 = swanAppConfigData.h(4);
        if (h2 != null && !h2.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (d.b.g0.a.l1.f.a aVar : h2) {
                if (aVar != null && aVar.b()) {
                    jSONArray.put(aVar.i);
                }
            }
            String jSONArray2 = jSONArray.toString();
            c("pluginPath", jSONArray2);
            return jSONArray2;
        }
        c("pluginPath", null);
        d.b.g0.a.l1.d.a.a("this swan app not apply on someone plugin");
        return null;
    }

    public static String l(SwanAppConfigData swanAppConfigData) {
        if (swanAppConfigData == null) {
            d.b.g0.a.l1.d.a.a("parse app.json is null");
            return null;
        }
        List<d.b.g0.a.l1.f.a> h2 = swanAppConfigData.h(4);
        if (h2 != null && !h2.isEmpty()) {
            String h3 = h("pluginPath", null);
            if (TextUtils.isEmpty(h3)) {
                JSONArray jSONArray = new JSONArray();
                for (d.b.g0.a.l1.f.a aVar : h2) {
                    if (aVar != null && aVar.b()) {
                        jSONArray.put(aVar.i);
                    }
                }
                String jSONArray2 = jSONArray.toString();
                c("pluginPath", jSONArray2);
                return jSONArray2;
            }
            return h3;
        }
        d.b.g0.a.l1.d.a.a("this swan app not apply on someone plugin");
        return null;
    }
}
