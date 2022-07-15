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
import com.repackage.el2;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && g03.K().k() == 1 && !d()) {
            mt2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = mt2.p("startup");
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
            h03 M = h03.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            gd2 Q = w.Q();
            if (Q instanceof hw3) {
                return ((hw3) Q).f1();
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
            h03 M = h03.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            gd2 Q = w.Q();
            if (Q instanceof hw3) {
                return ((hw3) Q).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, el2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        k73 k73Var = new k73();
        k73Var.a = a73.n(aVar.G());
        k73Var.f = aVar.H();
        k73Var.c = aVar.T();
        k73Var.b = "launch";
        k73Var.e = "realcancel";
        k73Var.q = String.valueOf(currentTimeMillis - l);
        k73Var.a("reason", str);
        k73Var.a("errorList", x04.c().d());
        k73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        a73.onEvent(k73Var);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(el2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        k73 k73Var = new k73();
        k73Var.a = a73.n(aVar.G());
        k73Var.f = aVar.H();
        k73Var.c = aVar.T();
        k73Var.b = "launch";
        k73Var.e = "realsuccess";
        k73Var.r = String.valueOf(currentTimeMillis - l);
        k73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        a73.onEvent(k73Var);
        P.remove("page_display_flag_for_statistic");
    }
}
