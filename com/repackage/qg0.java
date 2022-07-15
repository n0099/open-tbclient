package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes7.dex */
public class qg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final pg0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755381225, "Lcom/repackage/qg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755381225, "Lcom/repackage/qg0;");
                return;
            }
        }
        a = new pg0();
    }

    public static boolean a(@NonNull Context context, @NonNull vg0 vg0Var, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, vg0Var, map, zg0Var)) == null) ? a.a(context, vg0Var, map, zg0Var) : invokeLLLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? c(str, null) : invokeL.booleanValue;
    }

    public static boolean c(String str, @Nullable Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, context)) == null) ? d(str, context, null) : invokeLL.booleanValue;
    }

    public static boolean d(String str, @Nullable Context context, @Nullable Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, map)) == null) ? e(str, context, map, null) : invokeLLL.booleanValue;
    }

    public static boolean e(String str, @Nullable Context context, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        d01 d01Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, str, context, map, zg0Var)) == null) {
            if (a01.a && (d01Var = (d01) zz0.a().a(d01.class)) != null) {
                d01Var.a(str);
            }
            if (!eh0.o(str)) {
                eh0.d(zg0Var, str, 201, false);
                return false;
            }
            if (context == null) {
                context = hh0.b();
            }
            return a(context, new vg0(str), map, zg0Var);
        }
        return invokeLLLL.booleanValue;
    }
}
