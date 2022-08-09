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
import com.repackage.bc4;
import com.repackage.wb4;
import com.repackage.yb4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ba4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<q94> l = i84.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (q94 q94Var : l) {
                        if (q94Var.b) {
                            j2 = q94Var.c;
                        } else {
                            y94 b = de4.b(q94Var.a, q94Var.d, q94Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", q94Var.a);
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
                    u84.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", i84.b().j(0));
            jSONObject.put("game_ext_vercode", i84.b().j(1));
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
            jSONObject.put("swan_vercode", i84.b().w(0));
            jSONObject.put("game_vercode", i84.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(wb4 wb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, wb4Var)) == null) {
            if (wb4Var != null && wb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (wb4.a aVar : wb4Var.f()) {
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

    public static JSONObject e(yb4 yb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yb4Var)) == null) {
            if (yb4Var != null && yb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (yb4.a aVar : yb4Var.f()) {
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
                        if (aVar instanceof bc4.b) {
                            bc4.b bVar = (bc4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<bc4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (bc4.a aVar2 : j) {
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

    public static HashMap<String, String> f(dc4 dc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dc4Var)) == null) {
            if (dc4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(dc4Var.b(), "-1")) {
                hashMap.put("from", dc4Var.b());
            }
            if (!TextUtils.equals(dc4Var.c(), "-1")) {
                hashMap.put("scene", dc4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = i84.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = i84.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(zb4 zb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, zb4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (zb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", zb4Var.g());
            hashMap.put("category", String.valueOf(zb4Var.a()));
            if (zb4Var.m() == -1) {
                pMSAppInfo = u84.i().u(zb4Var.g());
                if (pMSAppInfo != null && u84.i().o(w94.class, zb4Var.g()) != null) {
                    zb4Var.u(pMSAppInfo.versionCode);
                } else {
                    zb4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(zb4Var.m()));
            if (zb4Var.a() == 0 && zb4Var.m() != -1 && zb4Var.m() != 0) {
                hashMap.put("dep", a(zb4Var.g(), zb4Var.m(), false).toString());
            }
            if (zb4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = u84.i().u(zb4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    zb4Var.o(pMSAppInfo.appSign);
                } else {
                    zb4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(zb4Var.f()));
            if (zb4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(zb4Var.i()));
            }
            String k = zb4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(zb4Var.a());
                zb4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = i84.b().w(zb4Var.a());
            long j = i84.b().j(zb4Var.a());
            if (zb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = zb4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(zb4Var.a());
                zb4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(zb4Var.l())) {
                hashMap.put("path", zb4Var.l());
            }
            if (!TextUtils.equals(zb4Var.b(), "-1")) {
                hashMap.put("from", zb4Var.b());
            }
            if (!TextUtils.equals(zb4Var.c(), "-1")) {
                hashMap.put("scene", zb4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(zb4Var.n()));
            hashMap.put("host_env", String.valueOf(i84.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(ac4 ac4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ac4Var)) == null) {
            if (ac4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ac4Var.f());
            hashMap.put("category", String.valueOf(ac4Var.a()));
            if (TextUtils.isEmpty(ac4Var.h())) {
                ac4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", ac4Var.h());
            if (ac4Var.g() >= 0) {
                hashMap.put("plugin_vercode", ac4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(cc4 cc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cc4Var)) == null) {
            if (cc4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", cc4Var.f());
            hashMap.put("category", String.valueOf(cc4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(cc4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(cc4Var.j()));
            hashMap.put("sub_id", cc4Var.k());
            if (!TextUtils.equals(cc4Var.b(), "-1")) {
                hashMap.put("from", cc4Var.b());
            }
            if (TextUtils.isEmpty(cc4Var.i())) {
                cc4Var.m(h(cc4Var.a()));
            }
            if (!TextUtils.isEmpty(cc4Var.i())) {
                hashMap.put("framework_ver", cc4Var.i());
            }
            if (TextUtils.isEmpty(cc4Var.h())) {
                cc4Var.l(g(cc4Var.a()));
            }
            if (!TextUtils.isEmpty(cc4Var.h())) {
                hashMap.put("extension_ver", cc4Var.h());
            }
            long w = i84.b().w(cc4Var.a());
            long j = i84.b().j(cc4Var.a());
            if (cc4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (cc4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(cc4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
