package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class da4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull mb4 mb4Var, @Nullable List<s94> list, @Nullable List<t94> list2, @NonNull n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, mb4Var, list, list2, n84Var) == null) {
            xa4 b = fa4.b(mb4Var, n84Var);
            if (list != null && !list.isEmpty()) {
                fa4.a(b, wa4.h(list, n84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                fa4.a(b, wa4.e(list2, n84Var));
            }
            b.e();
        }
    }

    public static void b(nb4 nb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, nb4Var, n84Var) == null) {
            fa4.c(nb4Var, n84Var);
        }
    }

    public static void c(ob4 ob4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ob4Var, n84Var) == null) {
            fa4.d(ob4Var, n84Var);
        }
    }

    public static void d(pb4 pb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pb4Var, n84Var) == null) {
            fa4.e(pb4Var, n84Var);
        }
    }

    public static void e(kd4 kd4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, kd4Var, n84Var) == null) {
            fa4.f(kd4Var, n84Var);
        }
    }

    public static synchronized void f(List<t94> list, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, n84Var) == null) {
            synchronized (da4.class) {
                fa4.g(list, n84Var);
            }
        }
    }
}
