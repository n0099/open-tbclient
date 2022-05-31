package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class q84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull z94 z94Var, @Nullable List<f84> list, @Nullable List<g84> list2, @NonNull a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, z94Var, list, list2, a74Var) == null) {
            k94 b = s84.b(z94Var, a74Var);
            if (list != null && !list.isEmpty()) {
                s84.a(b, j94.h(list, a74Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                s84.a(b, j94.e(list2, a74Var));
            }
            b.e();
        }
    }

    public static void b(aa4 aa4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, aa4Var, a74Var) == null) {
            s84.c(aa4Var, a74Var);
        }
    }

    public static void c(ba4 ba4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ba4Var, a74Var) == null) {
            s84.d(ba4Var, a74Var);
        }
    }

    public static void d(ca4 ca4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ca4Var, a74Var) == null) {
            s84.e(ca4Var, a74Var);
        }
    }

    public static void e(xb4 xb4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xb4Var, a74Var) == null) {
            s84.f(xb4Var, a74Var);
        }
    }

    public static synchronized void f(List<g84> list, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, a74Var) == null) {
            synchronized (q84.class) {
                s84.g(list, a74Var);
            }
        }
    }
}
