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
public class gw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755663697, "Lcom/repackage/gw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755663697, "Lcom/repackage/gw2;");
                return;
            }
        }
        a = sg1.a;
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
        aw2.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
    }

    public static String b(Map<String, String> map, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            i03 M = i03.M();
            String e = M != null ? M.U().e(str, null) : null;
            if (!TextUtils.isEmpty(e)) {
                map.put(str, e);
                return e;
            }
            SwanAppConfigData Q = M != null ? M.Q() : null;
            if (i == 3) {
                pv2.m(Q, false);
                e = i(str, null);
            } else if (i == 4) {
                e = l(Q);
            } else if (i == 6) {
                nv2.a(Q);
                e = i(str, null);
            }
            map.put(str, e);
            return e;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        i03 M;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || (M = i03.M()) == null) {
            return;
        }
        M.U().j(str, str2);
    }

    public static String d(List<ew2> list) {
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
            SwanAppConfigData b = u03.b(str);
            if (b == null) {
                aw2.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                aw2.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                aw2.b("getDownloadKey, sub pkg map is null");
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
            h94 g = g(str);
            if ((g == null || TextUtils.isEmpty(g.r)) ? false : true) {
                return g.r;
            }
            aw2.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static h94 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return pv2.p(str, com.kuaishou.weapon.p0.q1.e, 0L);
        }
        return (h94) invokeL.objValue;
    }

    public static h94 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData Q;
        List<h94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!zx1.d() && !hw2.H() && !hw2.D()) {
                return g(str);
            }
            i03 M = i03.M();
            if (M != null && (Q = M.Q()) != null && (list = Q.l) != null) {
                for (h94 h94Var : list) {
                    if (TextUtils.equals(str, h94Var.g)) {
                        return h94Var;
                    }
                }
            }
            return null;
        }
        return (h94) invokeL.objValue;
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            i03 M = i03.M();
            if (M == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return M.U().e(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void j() {
        rz1 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (V = vl2.U().V()) != null && (V.m() instanceof sz1)) {
            vl2.U().getActivity().onBackPressed();
        }
    }

    public static List<h94> k(String str, boolean z) {
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
                            h94 h94Var = new h94();
                            h94Var.g = optString;
                            h94Var.i = optJSONObject.optLong("version_code", 0L);
                            h94Var.j = optJSONObject.optString("version_name", com.kuaishou.weapon.p0.q1.e);
                            h94Var.p = optJSONObject.optString("token");
                            h94Var.q = optJSONObject.optString("domains");
                            h94Var.h = 4;
                            h94Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            h94Var.s = optJSONObject.optString("app_name");
                            h94Var.l = "";
                            h94Var.m = "";
                            h94Var.n = "";
                            arrayList.add(h94Var);
                            if (z) {
                                d84.i().m(h94Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                aw2.b(Log.getStackTraceString(e));
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
                aw2.b("parse app.json is null");
                return null;
            }
            List<ew2> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (ew2 ew2Var : i) {
                    if (ew2Var != null && ew2Var.a()) {
                        id3.f(jSONObject, ew2Var.a, ew2Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            aw2.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
