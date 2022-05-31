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
import com.repackage.ea4;
import com.repackage.ga4;
import com.repackage.ja4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<y74> l = q64.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (y74 y74Var : l) {
                        if (y74Var.b) {
                            j2 = y74Var.c;
                        } else {
                            g84 b = lc4.b(y74Var.a, y74Var.d, y74Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", y74Var.a);
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
                    c74.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", q64.b().j(0));
            jSONObject.put("game_ext_vercode", q64.b().j(1));
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
            jSONObject.put("swan_vercode", q64.b().w(0));
            jSONObject.put("game_vercode", q64.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(ea4 ea4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ea4Var)) == null) {
            if (ea4Var != null && ea4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ea4.a aVar : ea4Var.f()) {
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

    public static JSONObject e(ga4 ga4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ga4Var)) == null) {
            if (ga4Var != null && ga4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ga4.a aVar : ga4Var.f()) {
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
                        if (aVar instanceof ja4.b) {
                            ja4.b bVar = (ja4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<ja4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (ja4.a aVar2 : j) {
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

    public static HashMap<String, String> f(la4 la4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, la4Var)) == null) {
            if (la4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(la4Var.b(), "-1")) {
                hashMap.put("from", la4Var.b());
            }
            if (!TextUtils.equals(la4Var.c(), "-1")) {
                hashMap.put("scene", la4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = q64.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = q64.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ha4 ha4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ha4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ha4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ha4Var.g());
            hashMap.put("category", String.valueOf(ha4Var.a()));
            if (ha4Var.m() == -1) {
                pMSAppInfo = c74.i().u(ha4Var.g());
                if (pMSAppInfo != null && c74.i().o(e84.class, ha4Var.g()) != null) {
                    ha4Var.u(pMSAppInfo.versionCode);
                } else {
                    ha4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ha4Var.m()));
            if (ha4Var.a() == 0 && ha4Var.m() != -1 && ha4Var.m() != 0) {
                hashMap.put("dep", a(ha4Var.g(), ha4Var.m(), false).toString());
            }
            if (ha4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = c74.i().u(ha4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ha4Var.o(pMSAppInfo.appSign);
                } else {
                    ha4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ha4Var.f()));
            if (ha4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ha4Var.i()));
            }
            String k = ha4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ha4Var.a());
                ha4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = q64.b().w(ha4Var.a());
            long j = q64.b().j(ha4Var.a());
            if (ha4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ha4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ha4Var.a());
                ha4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(ha4Var.l())) {
                hashMap.put("path", ha4Var.l());
            }
            if (!TextUtils.equals(ha4Var.b(), "-1")) {
                hashMap.put("from", ha4Var.b());
            }
            if (!TextUtils.equals(ha4Var.c(), "-1")) {
                hashMap.put("scene", ha4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ha4Var.n()));
            hashMap.put("host_env", String.valueOf(q64.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(ia4 ia4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ia4Var)) == null) {
            if (ia4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ia4Var.f());
            hashMap.put("category", String.valueOf(ia4Var.a()));
            if (TextUtils.isEmpty(ia4Var.h())) {
                ia4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", ia4Var.h());
            if (ia4Var.g() >= 0) {
                hashMap.put("plugin_vercode", ia4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(ka4 ka4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ka4Var)) == null) {
            if (ka4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ka4Var.f());
            hashMap.put("category", String.valueOf(ka4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(ka4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(ka4Var.j()));
            hashMap.put("sub_id", ka4Var.k());
            if (!TextUtils.equals(ka4Var.b(), "-1")) {
                hashMap.put("from", ka4Var.b());
            }
            if (TextUtils.isEmpty(ka4Var.i())) {
                ka4Var.m(h(ka4Var.a()));
            }
            if (!TextUtils.isEmpty(ka4Var.i())) {
                hashMap.put("framework_ver", ka4Var.i());
            }
            if (TextUtils.isEmpty(ka4Var.h())) {
                ka4Var.l(g(ka4Var.a()));
            }
            if (!TextUtils.isEmpty(ka4Var.h())) {
                hashMap.put("extension_ver", ka4Var.h());
            }
            long w = q64.b().w(ka4Var.a());
            long j = q64.b().j(ka4Var.a());
            if (ka4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (ka4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ka4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
