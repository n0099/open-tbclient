package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class q94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull za4 za4Var, @Nullable List<f94> list, @Nullable List<g94> list2, @NonNull a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, za4Var, list, list2, a84Var) == null) {
            ka4 b = s94.b(za4Var, a84Var);
            if (list != null && !list.isEmpty()) {
                s94.a(b, ja4.h(list, a84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                s94.a(b, ja4.e(list2, a84Var));
            }
            b.e();
        }
    }

    public static void b(ab4 ab4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ab4Var, a84Var) == null) {
            s94.c(ab4Var, a84Var);
        }
    }

    public static void c(bb4 bb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bb4Var, a84Var) == null) {
            s94.d(bb4Var, a84Var);
        }
    }

    public static void d(cb4 cb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cb4Var, a84Var) == null) {
            s94.e(cb4Var, a84Var);
        }
    }

    public static void e(xc4 xc4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xc4Var, a84Var) == null) {
            s94.f(xc4Var, a84Var);
        }
    }

    public static synchronized void f(List<g94> list, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, a84Var) == null) {
            synchronized (q94.class) {
                s94.g(list, a84Var);
            }
        }
    }
}
