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
public class nu3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755457051, "Lcom/repackage/nu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755457051, "Lcom/repackage/nu3;");
                return;
            }
        }
        a = rf1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        ou3 ou3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            hz2 L = hz2.L();
            or1 or1Var = null;
            if (jsObject == null || L == null || !b(L)) {
                ou3Var = null;
            } else {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                or1 F = or1.F(jsObject);
                String B = F.B("swanGameId");
                if (TextUtils.isEmpty(B)) {
                    ou3Var = null;
                } else {
                    p73 a2 = v73.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    ou3Var = new ou3();
                    ou3Var.duration = a2.getLong(B + "_Duration", 0L);
                }
                or1Var = F;
            }
            s14.call(or1Var, true, ou3Var);
        }
    }

    public static boolean b(hz2 hz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hz2Var)) == null) {
            String string = v73.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (hz2.f0().contains(jSONArray.optString(i))) {
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= j || hz2.L() == null || TextUtils.isEmpty(hz2.f0())) {
            return;
        }
        String f0 = hz2.f0();
        p73 a2 = v73.a();
        long j3 = a2.getLong(f0 + "_LastPause", 0L);
        long j4 = a2.getLong(f0 + "_Duration", 0L);
        if (c(Long.valueOf(j), Long.valueOf(j2))) {
            if (c(Long.valueOf(j3), Long.valueOf(j))) {
                a2.putLong(f0 + "_Duration", (j4 + j2) - j);
            } else {
                a2.putLong(f0 + "_Duration", j2 - j);
            }
        } else {
            a2.putLong(f0 + "_Duration", j2 % b);
        }
        a2.putLong(f0 + "_LastPause", System.currentTimeMillis());
    }
}
