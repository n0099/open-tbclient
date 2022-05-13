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
import com.repackage.rb4;
import com.repackage.tb4;
import com.repackage.wb4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class w94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<l94> l = d84.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (l94 l94Var : l) {
                        if (l94Var.b) {
                            j2 = l94Var.c;
                        } else {
                            t94 b = yd4.b(l94Var.a, l94Var.d, l94Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", l94Var.a);
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
                    p84.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", d84.b().j(0));
            jSONObject.put("game_ext_vercode", d84.b().j(1));
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
            jSONObject.put("swan_vercode", d84.b().w(0));
            jSONObject.put("game_vercode", d84.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(rb4 rb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rb4Var)) == null) {
            if (rb4Var != null && rb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (rb4.a aVar : rb4Var.f()) {
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

    public static JSONObject e(tb4 tb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tb4Var)) == null) {
            if (tb4Var != null && tb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (tb4.a aVar : tb4Var.f()) {
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
                        if (aVar instanceof wb4.b) {
                            wb4.b bVar = (wb4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<wb4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (wb4.a aVar2 : j) {
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

    public static HashMap<String, String> f(yb4 yb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, yb4Var)) == null) {
            if (yb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(yb4Var.b(), "-1")) {
                hashMap.put("from", yb4Var.b());
            }
            if (!TextUtils.equals(yb4Var.c(), "-1")) {
                hashMap.put("scene", yb4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = d84.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = d84.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ub4 ub4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ub4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ub4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ub4Var.g());
            hashMap.put("category", String.valueOf(ub4Var.a()));
            if (ub4Var.m() == -1) {
                pMSAppInfo = p84.i().u(ub4Var.g());
                if (pMSAppInfo != null && p84.i().o(r94.class, ub4Var.g()) != null) {
                    ub4Var.u(pMSAppInfo.versionCode);
                } else {
                    ub4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ub4Var.m()));
            if (ub4Var.a() == 0 && ub4Var.m() != -1 && ub4Var.m() != 0) {
                hashMap.put("dep", a(ub4Var.g(), ub4Var.m(), false).toString());
            }
            if (ub4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = p84.i().u(ub4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ub4Var.o(pMSAppInfo.appSign);
                } else {
                    ub4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ub4Var.f()));
            if (ub4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ub4Var.i()));
            }
            String k = ub4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ub4Var.a());
                ub4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = d84.b().w(ub4Var.a());
            long j = d84.b().j(ub4Var.a());
            if (ub4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ub4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ub4Var.a());
                ub4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(ub4Var.l())) {
                hashMap.put("path", ub4Var.l());
            }
            if (!TextUtils.equals(ub4Var.b(), "-1")) {
                hashMap.put("from", ub4Var.b());
            }
            if (!TextUtils.equals(ub4Var.c(), "-1")) {
                hashMap.put("scene", ub4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ub4Var.n()));
            hashMap.put("host_env", String.valueOf(d84.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(vb4 vb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, vb4Var)) == null) {
            if (vb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", vb4Var.f());
            hashMap.put("category", String.valueOf(vb4Var.a()));
            if (TextUtils.isEmpty(vb4Var.h())) {
                vb4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", vb4Var.h());
            if (vb4Var.g() >= 0) {
                hashMap.put("plugin_vercode", vb4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, xb4Var)) == null) {
            if (xb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", xb4Var.f());
            hashMap.put("category", String.valueOf(xb4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(xb4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(xb4Var.j()));
            hashMap.put("sub_id", xb4Var.k());
            if (!TextUtils.equals(xb4Var.b(), "-1")) {
                hashMap.put("from", xb4Var.b());
            }
            if (TextUtils.isEmpty(xb4Var.i())) {
                xb4Var.m(h(xb4Var.a()));
            }
            if (!TextUtils.isEmpty(xb4Var.i())) {
                hashMap.put("framework_ver", xb4Var.i());
            }
            if (TextUtils.isEmpty(xb4Var.h())) {
                xb4Var.l(g(xb4Var.a()));
            }
            if (!TextUtils.isEmpty(xb4Var.h())) {
                hashMap.put("extension_ver", xb4Var.h());
            }
            long w = d84.b().w(xb4Var.a());
            long j = d84.b().j(xb4Var.a());
            if (xb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (xb4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(xb4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
