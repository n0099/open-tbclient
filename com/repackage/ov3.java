package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class ov3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755426299, "Lcom/repackage/ov3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755426299, "Lcom/repackage/ov3;");
                return;
            }
        }
        a = sg1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        pv3 pv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            i03 M = i03.M();
            ps1 ps1Var = null;
            if (jsObject == null || M == null || !b(M)) {
                pv3Var = null;
            } else {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                ps1 F = ps1.F(jsObject);
                String B = F.B("swanGameId");
                if (TextUtils.isEmpty(B)) {
                    pv3Var = null;
                } else {
                    q83 a2 = w83.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    pv3Var = new pv3();
                    pv3Var.duration = a2.getLong(B + "_Duration", 0L);
                }
                ps1Var = F;
            }
            t24.call(ps1Var, true, pv3Var);
        }
    }

    public static boolean b(i03 i03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i03Var)) == null) {
            String string = w83.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (i03.g0().contains(jSONArray.optString(i))) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, l, l2)) == null) ? l.longValue() / 86400000 == l2.longValue() / 86400000 : invokeLL.booleanValue;
    }

    public static void d(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= j || i03.M() == null || TextUtils.isEmpty(i03.g0())) {
            return;
        }
        String g0 = i03.g0();
        q83 a2 = w83.a();
        long j3 = a2.getLong(g0 + "_LastPause", 0L);
        long j4 = a2.getLong(g0 + "_Duration", 0L);
        if (c(Long.valueOf(j), Long.valueOf(j2))) {
            if (c(Long.valueOf(j3), Long.valueOf(j))) {
                a2.putLong(g0 + "_Duration", (j4 + j2) - j);
            } else {
                a2.putLong(g0 + "_Duration", j2 - j);
            }
        } else {
            a2.putLong(g0 + "_Duration", j2 % b);
        }
        a2.putLong(g0 + "_LastPause", System.currentTimeMillis());
    }
}
