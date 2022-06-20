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
import com.repackage.pa4;
import com.repackage.ra4;
import com.repackage.ua4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<j84> l = b74.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (j84 j84Var : l) {
                        if (j84Var.b) {
                            j2 = j84Var.c;
                        } else {
                            r84 b = wc4.b(j84Var.a, j84Var.d, j84Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", j84Var.a);
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
                    n74.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", b74.b().j(0));
            jSONObject.put("game_ext_vercode", b74.b().j(1));
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
            jSONObject.put("swan_vercode", b74.b().w(0));
            jSONObject.put("game_vercode", b74.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(pa4 pa4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pa4Var)) == null) {
            if (pa4Var != null && pa4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (pa4.a aVar : pa4Var.f()) {
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

    public static JSONObject e(ra4 ra4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ra4Var)) == null) {
            if (ra4Var != null && ra4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ra4.a aVar : ra4Var.f()) {
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
                        if (aVar instanceof ua4.b) {
                            ua4.b bVar = (ua4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<ua4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (ua4.a aVar2 : j) {
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

    public static HashMap<String, String> f(wa4 wa4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, wa4Var)) == null) {
            if (wa4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(wa4Var.b(), "-1")) {
                hashMap.put("from", wa4Var.b());
            }
            if (!TextUtils.equals(wa4Var.c(), "-1")) {
                hashMap.put("scene", wa4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = b74.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = b74.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(sa4 sa4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sa4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (sa4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", sa4Var.g());
            hashMap.put("category", String.valueOf(sa4Var.a()));
            if (sa4Var.m() == -1) {
                pMSAppInfo = n74.i().u(sa4Var.g());
                if (pMSAppInfo != null && n74.i().o(p84.class, sa4Var.g()) != null) {
                    sa4Var.u(pMSAppInfo.versionCode);
                } else {
                    sa4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(sa4Var.m()));
            if (sa4Var.a() == 0 && sa4Var.m() != -1 && sa4Var.m() != 0) {
                hashMap.put("dep", a(sa4Var.g(), sa4Var.m(), false).toString());
            }
            if (sa4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = n74.i().u(sa4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    sa4Var.o(pMSAppInfo.appSign);
                } else {
                    sa4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(sa4Var.f()));
            if (sa4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(sa4Var.i()));
            }
            String k = sa4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(sa4Var.a());
                sa4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = b74.b().w(sa4Var.a());
            long j = b74.b().j(sa4Var.a());
            if (sa4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = sa4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(sa4Var.a());
                sa4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(sa4Var.l())) {
                hashMap.put("path", sa4Var.l());
            }
            if (!TextUtils.equals(sa4Var.b(), "-1")) {
                hashMap.put("from", sa4Var.b());
            }
            if (!TextUtils.equals(sa4Var.c(), "-1")) {
                hashMap.put("scene", sa4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(sa4Var.n()));
            hashMap.put("host_env", String.valueOf(b74.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(ta4 ta4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ta4Var)) == null) {
            if (ta4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ta4Var.f());
            hashMap.put("category", String.valueOf(ta4Var.a()));
            if (TextUtils.isEmpty(ta4Var.h())) {
                ta4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", ta4Var.h());
            if (ta4Var.g() >= 0) {
                hashMap.put("plugin_vercode", ta4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(va4 va4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, va4Var)) == null) {
            if (va4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", va4Var.f());
            hashMap.put("category", String.valueOf(va4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(va4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(va4Var.j()));
            hashMap.put("sub_id", va4Var.k());
            if (!TextUtils.equals(va4Var.b(), "-1")) {
                hashMap.put("from", va4Var.b());
            }
            if (TextUtils.isEmpty(va4Var.i())) {
                va4Var.m(h(va4Var.a()));
            }
            if (!TextUtils.isEmpty(va4Var.i())) {
                hashMap.put("framework_ver", va4Var.i());
            }
            if (TextUtils.isEmpty(va4Var.h())) {
                va4Var.l(g(va4Var.a()));
            }
            if (!TextUtils.isEmpty(va4Var.h())) {
                hashMap.put("extension_ver", va4Var.h());
            }
            long w = b74.b().w(va4Var.a());
            long j = b74.b().j(va4Var.a());
            if (va4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (va4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(va4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
