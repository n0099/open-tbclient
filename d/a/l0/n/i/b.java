package d.a.l0.n.i;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.internal.ETAG;
import d.a.l0.n.i.m.b;
import d.a.l0.n.i.m.e;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static JSONObject a(d.a.l0.n.i.m.b bVar) {
        if (bVar != null && bVar.f() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("swan_core_ver", d(0));
                jSONObject2.put("swan_game_ver", d(1));
                jSONObject2.put("swan_vercode", d.a.l0.n.c.b().w(0));
                jSONObject2.put("game_vercode", d.a.l0.n.c.b().w(1));
                jSONObject.put("framework", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("swan_ext_ver", c(0));
                jSONObject3.put("game_ext_ver", c(1));
                jSONObject3.put("swan_ext_vercode", d.a.l0.n.c.b().k(0));
                jSONObject3.put("game_ext_vercode", d.a.l0.n.c.b().k(1));
                jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
                JSONArray jSONArray = new JSONArray();
                for (b.a aVar : bVar.f()) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("bundle_id", aVar.b());
                    if (aVar.c() != -1) {
                        jSONObject4.put("category", aVar.c());
                    }
                    jSONObject4.put("pkg_ver", aVar.d());
                    jSONObject4.put("app_sign", aVar.a());
                    if (aVar instanceof e.b) {
                        e.b bVar2 = (e.b) aVar;
                        String[] h2 = bVar2.h();
                        if (h2 != null && h2.length > 0) {
                            jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(h2)));
                        }
                        JSONObject jSONObject5 = new JSONObject();
                        List<e.a> i2 = bVar2.i();
                        if (i2 != null && !i2.isEmpty()) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (e.a aVar2 : i2) {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("id", aVar2.a());
                                jSONObject6.put("type", aVar2.b());
                                jSONArray2.put(jSONObject6);
                            }
                            jSONObject5.put("list", jSONArray2);
                            jSONObject5.put("ver", i2.get(0).c());
                        }
                        jSONObject4.put("sub_info", jSONObject5);
                    }
                    jSONArray.put(jSONObject4);
                }
                jSONObject.put("list", jSONArray);
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static HashMap<String, String> b(d.a.l0.n.i.m.b bVar) {
        if (bVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.equals(bVar.b(), "-1")) {
            hashMap.put("from", bVar.b());
        }
        if (!TextUtils.equals(bVar.c(), "-1")) {
            hashMap.put("scene", bVar.c());
        }
        return hashMap;
    }

    public static String c(int i2) {
        String u = d.a.l0.n.c.b().u(i2);
        return TextUtils.isEmpty(u) ? "0" : u;
    }

    public static String d(int i2) {
        String F = d.a.l0.n.c.b().F(i2);
        return TextUtils.isEmpty(F) ? "0" : F;
    }

    public static HashMap<String, String> e(d.a.l0.n.i.m.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.g());
        hashMap.put("category", String.valueOf(cVar.a()));
        if (cVar.l() == -1) {
            pMSAppInfo = d.a.l0.n.g.a.h().s(cVar.g());
            if (pMSAppInfo != null && d.a.l0.n.g.a.h().o(d.a.l0.n.h.f.class, cVar.g()) != null) {
                cVar.s(pMSAppInfo.versionCode);
            } else {
                cVar.s(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.l()));
        if (cVar.f() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = d.a.l0.n.g.a.h().s(cVar.g());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.a()) {
                cVar.n(pMSAppInfo.appSign);
            } else {
                cVar.n(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.f()));
        if (cVar.h() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.h()));
        }
        String j = cVar.j();
        if (TextUtils.isEmpty(j)) {
            j = d(cVar.a());
            cVar.q(j);
        }
        if (TextUtils.isEmpty(j)) {
            j = "0";
        }
        hashMap.put("framework_ver", j);
        long w = d.a.l0.n.c.b().w(cVar.a());
        long k = d.a.l0.n.c.b().k(cVar.a());
        if (cVar.a() == 1) {
            hashMap.put("game_vercode", w + "");
            hashMap.put("game_ext_vercode", k + "");
        } else {
            hashMap.put("swan_vercode", w + "");
            hashMap.put("swan_ext_vercode", k + "");
        }
        String i2 = cVar.i();
        if (TextUtils.isEmpty(i2)) {
            i2 = c(cVar.a());
            cVar.p(i2);
        }
        hashMap.put("extension_ver", TextUtils.isEmpty(i2) ? "0" : i2);
        if (!TextUtils.isEmpty(cVar.k())) {
            hashMap.put("path", cVar.k());
        }
        if (!TextUtils.equals(cVar.b(), "-1")) {
            hashMap.put("from", cVar.b());
        }
        if (!TextUtils.equals(cVar.c(), "-1")) {
            hashMap.put("scene", cVar.c());
        }
        hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(cVar.m()));
        return hashMap;
    }

    public static HashMap<String, String> f(d.a.l0.n.i.m.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.f());
        hashMap.put("category", String.valueOf(dVar.a()));
        if (TextUtils.isEmpty(dVar.h())) {
            dVar.i(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.h());
        if (dVar.g() >= 0) {
            hashMap.put("plugin_vercode", dVar.g() + "");
        }
        return hashMap;
    }

    public static HashMap<String, String> g(d.a.l0.n.i.m.f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", fVar.f());
        hashMap.put("category", String.valueOf(fVar.a()));
        hashMap.put("pkg_ver", String.valueOf(fVar.j()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.j()));
        hashMap.put("sub_id", fVar.k());
        if (!TextUtils.equals(fVar.b(), "-1")) {
            hashMap.put("from", fVar.b());
        }
        if (TextUtils.isEmpty(fVar.i())) {
            fVar.m(d(fVar.a()));
        }
        if (!TextUtils.isEmpty(fVar.i())) {
            hashMap.put("framework_ver", fVar.i());
        }
        if (TextUtils.isEmpty(fVar.h())) {
            fVar.l(c(fVar.a()));
        }
        if (!TextUtils.isEmpty(fVar.h())) {
            hashMap.put("extension_ver", fVar.h());
        }
        long w = d.a.l0.n.c.b().w(fVar.a());
        long k = d.a.l0.n.c.b().k(fVar.a());
        if (fVar.a() == 1) {
            hashMap.put("game_vercode", w + "");
            hashMap.put("game_ext_vercode", k + "");
        } else {
            hashMap.put("swan_vercode", w + "");
            hashMap.put("swan_ext_vercode", k + "");
        }
        if (fVar.g() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.g()));
        }
        return hashMap;
    }
}
