package d.b.h0.l.l;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.internal.ETAG;
import d.b.h0.l.l.k.b;
import d.b.h0.l.l.k.e;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static JSONObject a(d.b.h0.l.l.k.b bVar) {
        if (bVar != null && bVar.f() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("swan_core_ver", d(0));
                jSONObject2.put("swan_game_ver", d(1));
                jSONObject.put("framework", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("swan_ext_ver", c(0));
                jSONObject3.put("game_ext_ver", c(1));
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
                        List<e.a> i = bVar2.i();
                        if (i != null && !i.isEmpty()) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (e.a aVar2 : i) {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("id", aVar2.a());
                                jSONObject6.put("type", aVar2.b());
                                jSONArray2.put(jSONObject6);
                            }
                            jSONObject5.put("list", jSONArray2);
                            jSONObject5.put("ver", i.get(0).c());
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

    public static HashMap<String, String> b(d.b.h0.l.l.k.b bVar) {
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

    public static String c(int i) {
        String C;
        if (i == 1) {
            C = d.b.h0.l.f.b().t();
        } else {
            C = i == 0 ? d.b.h0.l.f.b().C() : null;
        }
        return TextUtils.isEmpty(C) ? "0" : C;
    }

    public static String d(int i) {
        String l;
        if (i == 1) {
            l = d.b.h0.l.f.b().m();
        } else {
            l = i == 0 ? d.b.h0.l.f.b().l() : null;
        }
        return TextUtils.isEmpty(l) ? "0" : l;
    }

    public static HashMap<String, String> e(d.b.h0.l.l.k.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.g());
        hashMap.put("category", String.valueOf(cVar.a()));
        if (cVar.l() == -1) {
            pMSAppInfo = d.b.h0.l.i.a.h().r(cVar.g());
            if (pMSAppInfo != null && d.b.h0.l.i.a.h().n(d.b.h0.l.k.f.class, cVar.g()) != null) {
                cVar.r(pMSAppInfo.versionCode);
            } else {
                cVar.r(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.l()));
        if (cVar.f() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = d.b.h0.l.i.a.h().r(cVar.g());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= d.b.h0.l.e.a()) {
                cVar.m(pMSAppInfo.appSign);
            } else {
                cVar.m(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.f()));
        if (cVar.h() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.h()));
        }
        String j = cVar.j();
        if (TextUtils.isEmpty(j)) {
            j = d(cVar.a());
            cVar.p(j);
        }
        if (TextUtils.isEmpty(j)) {
            j = "0";
        }
        hashMap.put("framework_ver", j);
        String i = cVar.i();
        if (TextUtils.isEmpty(i)) {
            i = c(cVar.a());
            cVar.o(i);
        }
        hashMap.put("extension_ver", TextUtils.isEmpty(i) ? "0" : i);
        if (!TextUtils.isEmpty(cVar.k())) {
            hashMap.put("path", cVar.k());
        }
        if (!TextUtils.equals(cVar.b(), "-1")) {
            hashMap.put("from", cVar.b());
        }
        if (!TextUtils.equals(cVar.c(), "-1")) {
            hashMap.put("scene", cVar.c());
        }
        return hashMap;
    }

    public static HashMap<String, String> f(d.b.h0.l.l.k.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.f());
        hashMap.put("category", String.valueOf(dVar.a()));
        if (TextUtils.isEmpty(dVar.g())) {
            dVar.h(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.g());
        return hashMap;
    }

    public static HashMap<String, String> g(d.b.h0.l.l.k.f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", fVar.f());
        hashMap.put("category", String.valueOf(fVar.a()));
        hashMap.put("pkg_ver", String.valueOf(fVar.j()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.j()));
        hashMap.put("sub_id", fVar.k());
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
        if (fVar.g() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.g()));
        }
        return hashMap;
    }
}
