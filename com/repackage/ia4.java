package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ia4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull rb4 rb4Var, @Nullable List<x94> list, @Nullable List<y94> list2, @NonNull s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, rb4Var, list, list2, s84Var) == null) {
            cb4 b = ka4.b(rb4Var, s84Var);
            if (list != null && !list.isEmpty()) {
                ka4.a(b, bb4.h(list, s84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                ka4.a(b, bb4.e(list2, s84Var));
            }
            b.e();
        }
    }

    public static void b(sb4 sb4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, sb4Var, s84Var) == null) {
            ka4.c(sb4Var, s84Var);
        }
    }

    public static void c(tb4 tb4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, tb4Var, s84Var) == null) {
            ka4.d(tb4Var, s84Var);
        }
    }

    public static void d(ub4 ub4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ub4Var, s84Var) == null) {
            ka4.e(ub4Var, s84Var);
        }
    }

    public static void e(pd4 pd4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pd4Var, s84Var) == null) {
            ka4.f(pd4Var, s84Var);
        }
    }

    public static synchronized void f(List<y94> list, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, s84Var) == null) {
            synchronized (ia4.class) {
                ka4.g(list, s84Var);
            }
        }
    }
}
