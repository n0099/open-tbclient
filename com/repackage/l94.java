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
import com.repackage.gb4;
import com.repackage.ib4;
import com.repackage.lb4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<a94> l = s74.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (a94 a94Var : l) {
                        if (a94Var.b) {
                            j2 = a94Var.c;
                        } else {
                            i94 b = nd4.b(a94Var.a, a94Var.d, a94Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", a94Var.a);
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
                    e84.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", s74.b().j(0));
            jSONObject.put("game_ext_vercode", s74.b().j(1));
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
            jSONObject.put("swan_vercode", s74.b().w(0));
            jSONObject.put("game_vercode", s74.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(gb4 gb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gb4Var)) == null) {
            if (gb4Var != null && gb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (gb4.a aVar : gb4Var.f()) {
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

    public static JSONObject e(ib4 ib4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ib4Var)) == null) {
            if (ib4Var != null && ib4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ib4.a aVar : ib4Var.f()) {
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
                        if (aVar instanceof lb4.b) {
                            lb4.b bVar = (lb4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<lb4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (lb4.a aVar2 : j) {
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

    public static HashMap<String, String> f(nb4 nb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nb4Var)) == null) {
            if (nb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(nb4Var.b(), "-1")) {
                hashMap.put("from", nb4Var.b());
            }
            if (!TextUtils.equals(nb4Var.c(), "-1")) {
                hashMap.put("scene", nb4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = s74.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = s74.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(jb4 jb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jb4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (jb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jb4Var.g());
            hashMap.put("category", String.valueOf(jb4Var.a()));
            if (jb4Var.m() == -1) {
                pMSAppInfo = e84.i().u(jb4Var.g());
                if (pMSAppInfo != null && e84.i().o(g94.class, jb4Var.g()) != null) {
                    jb4Var.u(pMSAppInfo.versionCode);
                } else {
                    jb4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(jb4Var.m()));
            if (jb4Var.a() == 0 && jb4Var.m() != -1 && jb4Var.m() != 0) {
                hashMap.put("dep", a(jb4Var.g(), jb4Var.m(), false).toString());
            }
            if (jb4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = e84.i().u(jb4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    jb4Var.o(pMSAppInfo.appSign);
                } else {
                    jb4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(jb4Var.f()));
            if (jb4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(jb4Var.i()));
            }
            String k = jb4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(jb4Var.a());
                jb4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = s74.b().w(jb4Var.a());
            long j = s74.b().j(jb4Var.a());
            if (jb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = jb4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(jb4Var.a());
                jb4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(jb4Var.l())) {
                hashMap.put("path", jb4Var.l());
            }
            if (!TextUtils.equals(jb4Var.b(), "-1")) {
                hashMap.put("from", jb4Var.b());
            }
            if (!TextUtils.equals(jb4Var.c(), "-1")) {
                hashMap.put("scene", jb4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(jb4Var.n()));
            hashMap.put("host_env", String.valueOf(s74.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(kb4 kb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, kb4Var)) == null) {
            if (kb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", kb4Var.f());
            hashMap.put("category", String.valueOf(kb4Var.a()));
            if (TextUtils.isEmpty(kb4Var.h())) {
                kb4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", kb4Var.h());
            if (kb4Var.g() >= 0) {
                hashMap.put("plugin_vercode", kb4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(mb4 mb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mb4Var)) == null) {
            if (mb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", mb4Var.f());
            hashMap.put("category", String.valueOf(mb4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(mb4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(mb4Var.j()));
            hashMap.put("sub_id", mb4Var.k());
            if (!TextUtils.equals(mb4Var.b(), "-1")) {
                hashMap.put("from", mb4Var.b());
            }
            if (TextUtils.isEmpty(mb4Var.i())) {
                mb4Var.m(h(mb4Var.a()));
            }
            if (!TextUtils.isEmpty(mb4Var.i())) {
                hashMap.put("framework_ver", mb4Var.i());
            }
            if (TextUtils.isEmpty(mb4Var.h())) {
                mb4Var.l(g(mb4Var.a()));
            }
            if (!TextUtils.isEmpty(mb4Var.h())) {
                hashMap.put("extension_ver", mb4Var.h());
            }
            long w = s74.b().w(mb4Var.a());
            long j = s74.b().j(mb4Var.a());
            if (mb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (mb4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(mb4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
