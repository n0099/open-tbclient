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
import com.repackage.hb4;
import com.repackage.jb4;
import com.repackage.mb4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<b94> l = t74.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (b94 b94Var : l) {
                        if (b94Var.b) {
                            j2 = b94Var.c;
                        } else {
                            j94 b = od4.b(b94Var.a, b94Var.d, b94Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", b94Var.a);
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
                    f84.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", t74.b().j(0));
            jSONObject.put("game_ext_vercode", t74.b().j(1));
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
            jSONObject.put("swan_vercode", t74.b().w(0));
            jSONObject.put("game_vercode", t74.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(hb4 hb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hb4Var)) == null) {
            if (hb4Var != null && hb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (hb4.a aVar : hb4Var.f()) {
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

    public static JSONObject e(jb4 jb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jb4Var)) == null) {
            if (jb4Var != null && jb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (jb4.a aVar : jb4Var.f()) {
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
                        if (aVar instanceof mb4.b) {
                            mb4.b bVar = (mb4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<mb4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (mb4.a aVar2 : j) {
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

    public static HashMap<String, String> f(ob4 ob4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ob4Var)) == null) {
            if (ob4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(ob4Var.b(), "-1")) {
                hashMap.put("from", ob4Var.b());
            }
            if (!TextUtils.equals(ob4Var.c(), "-1")) {
                hashMap.put("scene", ob4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = t74.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = t74.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(kb4 kb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, kb4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (kb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", kb4Var.g());
            hashMap.put("category", String.valueOf(kb4Var.a()));
            if (kb4Var.m() == -1) {
                pMSAppInfo = f84.i().u(kb4Var.g());
                if (pMSAppInfo != null && f84.i().o(h94.class, kb4Var.g()) != null) {
                    kb4Var.u(pMSAppInfo.versionCode);
                } else {
                    kb4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(kb4Var.m()));
            if (kb4Var.a() == 0 && kb4Var.m() != -1 && kb4Var.m() != 0) {
                hashMap.put("dep", a(kb4Var.g(), kb4Var.m(), false).toString());
            }
            if (kb4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = f84.i().u(kb4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    kb4Var.o(pMSAppInfo.appSign);
                } else {
                    kb4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(kb4Var.f()));
            if (kb4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(kb4Var.i()));
            }
            String k = kb4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(kb4Var.a());
                kb4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = t74.b().w(kb4Var.a());
            long j = t74.b().j(kb4Var.a());
            if (kb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = kb4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(kb4Var.a());
                kb4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(kb4Var.l())) {
                hashMap.put("path", kb4Var.l());
            }
            if (!TextUtils.equals(kb4Var.b(), "-1")) {
                hashMap.put("from", kb4Var.b());
            }
            if (!TextUtils.equals(kb4Var.c(), "-1")) {
                hashMap.put("scene", kb4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(kb4Var.n()));
            hashMap.put("host_env", String.valueOf(t74.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(lb4 lb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, lb4Var)) == null) {
            if (lb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", lb4Var.f());
            hashMap.put("category", String.valueOf(lb4Var.a()));
            if (TextUtils.isEmpty(lb4Var.h())) {
                lb4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", lb4Var.h());
            if (lb4Var.g() >= 0) {
                hashMap.put("plugin_vercode", lb4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(nb4 nb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, nb4Var)) == null) {
            if (nb4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", nb4Var.f());
            hashMap.put("category", String.valueOf(nb4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(nb4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(nb4Var.j()));
            hashMap.put("sub_id", nb4Var.k());
            if (!TextUtils.equals(nb4Var.b(), "-1")) {
                hashMap.put("from", nb4Var.b());
            }
            if (TextUtils.isEmpty(nb4Var.i())) {
                nb4Var.m(h(nb4Var.a()));
            }
            if (!TextUtils.isEmpty(nb4Var.i())) {
                hashMap.put("framework_ver", nb4Var.i());
            }
            if (TextUtils.isEmpty(nb4Var.h())) {
                nb4Var.l(g(nb4Var.a()));
            }
            if (!TextUtils.isEmpty(nb4Var.h())) {
                hashMap.put("extension_ver", nb4Var.h());
            }
            long w = t74.b().w(nb4Var.a());
            long j = t74.b().j(nb4Var.a());
            if (nb4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (nb4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(nb4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
