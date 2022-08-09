package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wl2;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && y03.K().k() == 1 && !d()) {
            eu2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = eu2.p("startup");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                long optLong = optJSONObject.optLong("timestamp");
                if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    ubcFlowEvent.h(optLong);
                    p.F(ubcFlowEvent);
                }
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            z03 M = z03.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            yd2 Q = w.Q();
            if (Q instanceof zw3) {
                return ((zw3) Q).f1();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            z03 M = z03.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            yd2 Q = w.Q();
            if (Q instanceof zw3) {
                return ((zw3) Q).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, wl2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c83 c83Var = new c83();
        c83Var.a = s73.n(aVar.G());
        c83Var.f = aVar.H();
        c83Var.c = aVar.T();
        c83Var.b = "launch";
        c83Var.e = "realcancel";
        c83Var.q = String.valueOf(currentTimeMillis - l);
        c83Var.a("reason", str);
        c83Var.a("errorList", p14.c().d());
        c83Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        s73.onEvent(c83Var);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(wl2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c83 c83Var = new c83();
        c83Var.a = s73.n(aVar.G());
        c83Var.f = aVar.H();
        c83Var.c = aVar.T();
        c83Var.b = "launch";
        c83Var.e = "realsuccess";
        c83Var.r = String.valueOf(currentTimeMillis - l);
        c83Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        s73.onEvent(c83Var);
        P.remove("page_display_flag_for_statistic");
    }
}
