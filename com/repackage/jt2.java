package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755577207, "Lcom/repackage/jt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755577207, "Lcom/repackage/jt2;");
                return;
            }
        }
        a = rf1.a;
        b = c("swan_perf_stat_rectify", 0);
        c = c("swan_perf_stat_overlay_rectify", 0);
        if (a) {
            Log.d("SwanRectifyAbSwitcher", "670 data rectify on - " + b);
            Log.d("SwanRectifyAbSwitcher", "670 data overlay rectify on - " + c);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : invokeV.booleanValue;
    }

    public static boolean c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            oi2.g0().getSwitch(str, i);
            if (a) {
                Log.d("SwanRectifyAbSwitcher", str + " - " + i);
            }
            return i == 1;
        }
        return invokeLI.booleanValue;
    }
}
