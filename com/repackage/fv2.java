package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755694449, "Lcom/repackage/fv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755694449, "Lcom/repackage/fv2;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, map, str) == null) || map == null) {
            return;
        }
        String b = b(map, "dynamicLibPath", 3);
        String b2 = b(map, "dynamicLibConfig", 3);
        String b3 = b(map, "pluginPath", 4);
        String b4 = b(map, "dependenciesPath", 6);
        String b5 = b(map, "dependenciesConfig", 6);
        if (TextUtils.isEmpty(str) || !a) {
            return;
        }
        zu2.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
    }

    public static String b(Map<String, String> map, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            hz2 L = hz2.L();
            String e = L != null ? L.T().e(str, null) : null;
            if (!TextUtils.isEmpty(e)) {
                map.put(str, e);
                return e;
            }
            SwanAppConfigData P = L != null ? L.P() : null;
            if (i == 3) {
                ou2.m(P, false);
                e = i(str, null);
            } else if (i == 4) {
                e = l(P);
            } else if (i == 6) {
                mu2.a(P);
                e = i(str, null);
            }
            map.put(str, e);
            return e;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        hz2 L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || (L = hz2.L()) == null) {
            return;
        }
        L.T().j(str, str2);
    }

    public static String d(List<dv2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from (SELECT * from ");
            sb.append("swan_plugin");
            sb.append(" ORDER BY update_time) group by bundle_id having bundle_id in ");
            sb.append("(");
            for (int i = 0; i < size; i++) {
                sb.append("'");
                sb.append(list.get(i).a);
                sb.append("'");
                if (i == size - 1) {
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    sb.append(",");
                }
            }
            sb.append(ParamableElem.DIVIDE_PARAM);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b = tz2.b(str);
            if (b == null) {
                zu2.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                zu2.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                zu2.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            g84 g = g(str);
            if ((g == null || TextUtils.isEmpty(g.r)) ? false : true) {
                return g.r;
            }
            zu2.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static g84 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return ou2.p(str, com.kuaishou.weapon.un.d.S, 0L);
        }
        return (g84) invokeL.objValue;
    }

    public static g84 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData P;
        List<g84> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!yw1.d() && !gv2.H() && !gv2.D()) {
                return g(str);
            }
            hz2 L = hz2.L();
            if (L != null && (P = L.P()) != null && (list = P.l) != null) {
                for (g84 g84Var : list) {
                    if (TextUtils.equals(str, g84Var.g)) {
                        return g84Var;
                    }
                }
            }
            return null;
        }
        return (g84) invokeL.objValue;
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            hz2 L = hz2.L();
            if (L == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return L.T().e(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void j() {
        qy1 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (V = uk2.U().V()) != null && (V.m() instanceof ry1)) {
            uk2.U().getActivity().onBackPressed();
        }
    }

    public static List<g84> k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                if (length == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("plugin_id");
                        if (!TextUtils.isEmpty(optString)) {
                            g84 g84Var = new g84();
                            g84Var.g = optString;
                            g84Var.i = optJSONObject.optLong("version_code", 0L);
                            g84Var.j = optJSONObject.optString("version_name", com.kuaishou.weapon.un.d.S);
                            g84Var.p = optJSONObject.optString("token");
                            g84Var.q = optJSONObject.optString("domains");
                            g84Var.h = 4;
                            g84Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            g84Var.s = optJSONObject.optString("app_name");
                            g84Var.l = "";
                            g84Var.m = "";
                            g84Var.n = "";
                            arrayList.add(g84Var);
                            if (z) {
                                c74.i().m(g84Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                zu2.b(Log.getStackTraceString(e));
                return null;
            }
        }
        return (List) invokeLZ.objValue;
    }

    public static String l(SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                zu2.b("parse app.json is null");
                return null;
            }
            List<dv2> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (dv2 dv2Var : i) {
                    if (dv2Var != null && dv2Var.a()) {
                        hc3.f(jSONObject, dv2Var.a, dv2Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            zu2.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
