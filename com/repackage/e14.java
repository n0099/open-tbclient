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
import com.repackage.fl2;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && h03.K().k() == 1 && !d()) {
            nt2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = nt2.p("startup");
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
            i03 M = i03.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            hd2 Q = w.Q();
            if (Q instanceof iw3) {
                return ((iw3) Q).f1();
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
            i03 M = i03.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            hd2 Q = w.Q();
            if (Q instanceof iw3) {
                return ((iw3) Q).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, fl2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        l73 l73Var = new l73();
        l73Var.a = b73.n(aVar.G());
        l73Var.f = aVar.H();
        l73Var.c = aVar.T();
        l73Var.b = "launch";
        l73Var.e = "realcancel";
        l73Var.q = String.valueOf(currentTimeMillis - l);
        l73Var.a("reason", str);
        l73Var.a("errorList", y04.c().d());
        l73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        b73.onEvent(l73Var);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(fl2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        l73 l73Var = new l73();
        l73Var.a = b73.n(aVar.G());
        l73Var.f = aVar.H();
        l73Var.c = aVar.T();
        l73Var.b = "launch";
        l73Var.e = "realsuccess";
        l73Var.r = String.valueOf(currentTimeMillis - l);
        l73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        b73.onEvent(l73Var);
        P.remove("page_display_flag_for_statistic");
    }
}
