package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import com.repackage.eb4;
import com.repackage.gb4;
import com.repackage.jb4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<y84> l = q74.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (y84 y84Var : l) {
                        if (y84Var.b) {
                            j2 = y84Var.c;
                        } else {
                            g94 b = ld4.b(y84Var.a, y84Var.d, y84Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", y84Var.a);
                            jSONObject.put("pkg_ver", j2);
                            if (z) {
                                jSONObject.put("category", 6);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException unused) {
                }
                if (!arrayList.isEmpty()) {
                    c84.i().g(arrayList);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeCommon.objValue;
    }

    @NonNull
    public static JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_ext_ver", g(0));
            jSONObject.put("game_ext_ver", g(1));
            jSONObject.put("swan_ext_vercode", q74.b().j(0));
            jSONObject.put("game_ext_vercode", q74.b().j(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static JSONObject c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_core_ver", h(0));
            jSONObject.put("swan_game_ver", h(1));
            jSONObject.put("swan_vercode", q74.b().w(0));
            jSONObject.put("game_vercode", q74.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(eb4 eb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eb4Var)) == null) {
            if (eb4Var != null && eb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (eb4.a aVar : eb4Var.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.a());
                        jSONObject2.put("category", aVar.b());
                        jSONObject2.put("pkg_ver", aVar.e());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("min_version", aVar.d());
                        jSONObject3.put("max_version", aVar.c());
                        jSONObject2.put("version_range", jSONObject3);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject e(gb4 gb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gb4Var)) == null) {
            if (gb4Var != null && gb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (gb4.a aVar : gb4Var.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.b());
                        if (aVar.c() != -1) {
                            jSONObject2.put("category", aVar.c());
                        }
                        jSONObject2.put("pkg_ver", aVar.d());
                        jSONObject2.put("app_sign", aVar.a());
                        if (aVar.c() == 0 && aVar.d() != -1 && aVar.d() != 0) {
                            jSONObject2.put("dep", a(aVar.b(), aVar.d(), true));
                        }
                        if (aVar instanceof jb4.b) {
                            jb4.b bVar = (jb4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<jb4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (jb4.a aVar2 : j) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("id", aVar2.a());
                                    jSONObject4.put("type", aVar2.getType());
                                    jSONArray2.put(jSONObject4);
                                }
                                jSONObject3.put("list", jSONArray2);
                                jSONObject3.put("ver", j.get(0).b());
                            }
                            jSONObject2.put("sub_info", jSONObject3);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static HashMap<String, String> f(lb4 lb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, lb4Var)) == null) {
            if (lb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(lb4Var.b(), "-1")) {
                hashMap.put("from", lb4Var.b());
            }
            if (!TextUtils.equals(lb4Var.c(), "-1")) {
                hashMap.put("scene", lb4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = q74.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = q74.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(hb4 hb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, hb4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (hb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", hb4Var.g());
            hashMap.put("category", String.valueOf(hb4Var.a()));
            if (hb4Var.m() == -1) {
                pMSAppInfo = c84.i().u(hb4Var.g());
                if (pMSAppInfo != null && c84.i().o(e94.class, hb4Var.g()) != null) {
                    hb4Var.u(pMSAppInfo.versionCode);
                } else {
                    hb4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(hb4Var.m()));
            if (hb4Var.a() == 0 && hb4Var.m() != -1 && hb4Var.m() != 0) {
                hashMap.put("dep", a(hb4Var.g(), hb4Var.m(), false).toString());
            }
            if (hb4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = c84.i().u(hb4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    hb4Var.o(pMSAppInfo.appSign);
                } else {
                    hb4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(hb4Var.f()));
            if (hb4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(hb4Var.i()));
            }
            String k = hb4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(hb4Var.a());
                hb4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = q74.b().w(hb4Var.a());
            long j = q74.b().j(hb4Var.a());
            if (hb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = hb4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(hb4Var.a());
                hb4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(hb4Var.l())) {
                hashMap.put("path", hb4Var.l());
            }
            if (!TextUtils.equals(hb4Var.b(), "-1")) {
                hashMap.put("from", hb4Var.b());
            }
            if (!TextUtils.equals(hb4Var.c(), "-1")) {
                hashMap.put("scene", hb4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(hb4Var.n()));
            hashMap.put("host_env", String.valueOf(q74.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(ib4 ib4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ib4Var)) == null) {
            if (ib4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ib4Var.f());
            hashMap.put("category", String.valueOf(ib4Var.a()));
            if (TextUtils.isEmpty(ib4Var.h())) {
                ib4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", ib4Var.h());
            if (ib4Var.g() >= 0) {
                hashMap.put("plugin_vercode", ib4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(kb4 kb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, kb4Var)) == null) {
            if (kb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", kb4Var.f());
            hashMap.put("category", String.valueOf(kb4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(kb4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(kb4Var.j()));
            hashMap.put("sub_id", kb4Var.k());
            if (!TextUtils.equals(kb4Var.b(), "-1")) {
                hashMap.put("from", kb4Var.b());
            }
            if (TextUtils.isEmpty(kb4Var.i())) {
                kb4Var.m(h(kb4Var.a()));
            }
            if (!TextUtils.isEmpty(kb4Var.i())) {
                hashMap.put("framework_ver", kb4Var.i());
            }
            if (TextUtils.isEmpty(kb4Var.h())) {
                kb4Var.l(g(kb4Var.a()));
            }
            if (!TextUtils.isEmpty(kb4Var.h())) {
                hashMap.put("extension_ver", kb4Var.h());
            }
            long w = q74.b().w(kb4Var.a());
            long j = q74.b().j(kb4Var.a());
            if (kb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (kb4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(kb4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
