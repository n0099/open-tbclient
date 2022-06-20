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
import com.kwad.v8.NodeJS;
import com.repackage.pk2;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && rz2.K().l() == 1 && !d()) {
            xs2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = xs2.p(NodeJS.STARTUP_SCRIPT_NAME);
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
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            sz2 M = sz2.M();
            if (M == null || (x = M.x()) == null) {
                return 0L;
            }
            rc2 Q = x.Q();
            if (Q instanceof sv3) {
                return ((sv3) Q).f1();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            sz2 M = sz2.M();
            if (M == null || (x = M.x()) == null) {
                return false;
            }
            rc2 Q = x.Q();
            if (Q instanceof sv3) {
                return ((sv3) Q).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, pk2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        v63 v63Var = new v63();
        v63Var.a = l63.n(aVar.G());
        v63Var.f = aVar.H();
        v63Var.c = aVar.T();
        v63Var.b = "launch";
        v63Var.e = "realcancel";
        v63Var.q = String.valueOf(currentTimeMillis - l);
        v63Var.a("reason", str);
        v63Var.a("errorList", i04.c().d());
        v63Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        l63.onEvent(v63Var);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(pk2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        v63 v63Var = new v63();
        v63Var.a = l63.n(aVar.G());
        v63Var.f = aVar.H();
        v63Var.c = aVar.T();
        v63Var.b = "launch";
        v63Var.e = "realsuccess";
        v63Var.r = String.valueOf(currentTimeMillis - l);
        v63Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        l63.onEvent(v63Var);
        P.remove("page_display_flag_for_statistic");
    }
}
