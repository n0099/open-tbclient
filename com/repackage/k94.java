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
import com.repackage.fb4;
import com.repackage.hb4;
import com.repackage.kb4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<z84> l = r74.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (z84 z84Var : l) {
                        if (z84Var.b) {
                            j2 = z84Var.c;
                        } else {
                            h94 b = md4.b(z84Var.a, z84Var.d, z84Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", z84Var.a);
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
                    d84.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", r74.b().j(0));
            jSONObject.put("game_ext_vercode", r74.b().j(1));
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
            jSONObject.put("swan_vercode", r74.b().w(0));
            jSONObject.put("game_vercode", r74.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(fb4 fb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fb4Var)) == null) {
            if (fb4Var != null && fb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (fb4.a aVar : fb4Var.f()) {
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

    public static JSONObject e(hb4 hb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hb4Var)) == null) {
            if (hb4Var != null && hb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (hb4.a aVar : hb4Var.f()) {
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
                        if (aVar instanceof kb4.b) {
                            kb4.b bVar = (kb4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<kb4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (kb4.a aVar2 : j) {
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

    public static HashMap<String, String> f(mb4 mb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mb4Var)) == null) {
            if (mb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(mb4Var.b(), "-1")) {
                hashMap.put("from", mb4Var.b());
            }
            if (!TextUtils.equals(mb4Var.c(), "-1")) {
                hashMap.put("scene", mb4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = r74.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = r74.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ib4 ib4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ib4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ib4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ib4Var.g());
            hashMap.put("category", String.valueOf(ib4Var.a()));
            if (ib4Var.m() == -1) {
                pMSAppInfo = d84.i().u(ib4Var.g());
                if (pMSAppInfo != null && d84.i().o(f94.class, ib4Var.g()) != null) {
                    ib4Var.u(pMSAppInfo.versionCode);
                } else {
                    ib4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ib4Var.m()));
            if (ib4Var.a() == 0 && ib4Var.m() != -1 && ib4Var.m() != 0) {
                hashMap.put("dep", a(ib4Var.g(), ib4Var.m(), false).toString());
            }
            if (ib4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = d84.i().u(ib4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ib4Var.o(pMSAppInfo.appSign);
                } else {
                    ib4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ib4Var.f()));
            if (ib4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ib4Var.i()));
            }
            String k = ib4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ib4Var.a());
                ib4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = r74.b().w(ib4Var.a());
            long j = r74.b().j(ib4Var.a());
            if (ib4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ib4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ib4Var.a());
                ib4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(ib4Var.l())) {
                hashMap.put("path", ib4Var.l());
            }
            if (!TextUtils.equals(ib4Var.b(), "-1")) {
                hashMap.put("from", ib4Var.b());
            }
            if (!TextUtils.equals(ib4Var.c(), "-1")) {
                hashMap.put("scene", ib4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ib4Var.n()));
            hashMap.put("host_env", String.valueOf(r74.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(jb4 jb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jb4Var)) == null) {
            if (jb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jb4Var.f());
            hashMap.put("category", String.valueOf(jb4Var.a()));
            if (TextUtils.isEmpty(jb4Var.h())) {
                jb4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", jb4Var.h());
            if (jb4Var.g() >= 0) {
                hashMap.put("plugin_vercode", jb4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(lb4 lb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, lb4Var)) == null) {
            if (lb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", lb4Var.f());
            hashMap.put("category", String.valueOf(lb4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(lb4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(lb4Var.j()));
            hashMap.put("sub_id", lb4Var.k());
            if (!TextUtils.equals(lb4Var.b(), "-1")) {
                hashMap.put("from", lb4Var.b());
            }
            if (TextUtils.isEmpty(lb4Var.i())) {
                lb4Var.m(h(lb4Var.a()));
            }
            if (!TextUtils.isEmpty(lb4Var.i())) {
                hashMap.put("framework_ver", lb4Var.i());
            }
            if (TextUtils.isEmpty(lb4Var.h())) {
                lb4Var.l(g(lb4Var.a()));
            }
            if (!TextUtils.isEmpty(lb4Var.h())) {
                hashMap.put("extension_ver", lb4Var.h());
            }
            long w = r74.b().w(lb4Var.a());
            long j = r74.b().j(lb4Var.a());
            if (lb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (lb4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(lb4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
