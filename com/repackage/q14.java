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
import com.repackage.rl2;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && t03.J().l() == 1 && !d()) {
            zt2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
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
            u03 L = u03.L();
            if (L == null || (x = L.x()) == null) {
                return 0L;
            }
            td2 frame = x.getFrame();
            if (frame instanceof uw3) {
                return ((uw3) frame).f1();
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
            u03 L = u03.L();
            if (L == null || (x = L.x()) == null) {
                return false;
            }
            td2 frame = x.getFrame();
            if (frame instanceof uw3) {
                return ((uw3) frame).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, rl2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        x73 x73Var = new x73();
        x73Var.a = n73.n(aVar.G());
        x73Var.f = aVar.H();
        x73Var.c = aVar.T();
        x73Var.b = "launch";
        x73Var.e = "realcancel";
        x73Var.q = String.valueOf(currentTimeMillis - l);
        x73Var.a("reason", str);
        x73Var.a("errorList", k14.c().d());
        x73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        n73.onEvent(x73Var);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(rl2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        x73 x73Var = new x73();
        x73Var.a = n73.n(aVar.G());
        x73Var.f = aVar.H();
        x73Var.c = aVar.T();
        x73Var.b = "launch";
        x73Var.e = "realsuccess";
        x73Var.r = String.valueOf(currentTimeMillis - l);
        x73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        n73.onEvent(x73Var);
        P.remove("page_display_flag_for_statistic");
    }
}
