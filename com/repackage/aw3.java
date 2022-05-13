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
/* loaded from: classes5.dex */
public class aw3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755842412, "Lcom/repackage/aw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755842412, "Lcom/repackage/aw3;");
                return;
            }
        }
        a = eh1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        bw3 bw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            u03 L = u03.L();
            bt1 bt1Var = null;
            if (jsObject == null || L == null || !b(L)) {
                bw3Var = null;
            } else {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                bt1 F = bt1.F(jsObject);
                String B = F.B("swanGameId");
                if (TextUtils.isEmpty(B)) {
                    bw3Var = null;
                } else {
                    c93 a2 = i93.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    bw3Var = new bw3();
                    bw3Var.duration = a2.getLong(B + "_Duration", 0L);
                }
                bt1Var = F;
            }
            f34.call(bt1Var, true, bw3Var);
        }
    }

    public static boolean b(u03 u03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, u03Var)) == null) {
            String string = i93.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (u03.f0().contains(jSONArray.optString(i))) {
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= j || u03.L() == null || TextUtils.isEmpty(u03.f0())) {
            return;
        }
        String f0 = u03.f0();
        c93 a2 = i93.a();
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
