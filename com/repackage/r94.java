package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class r94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ab4 ab4Var, @Nullable List<g94> list, @Nullable List<h94> list2, @NonNull b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ab4Var, list, list2, b84Var) == null) {
            la4 b = t94.b(ab4Var, b84Var);
            if (list != null && !list.isEmpty()) {
                t94.a(b, ka4.h(list, b84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                t94.a(b, ka4.e(list2, b84Var));
            }
            b.e();
        }
    }

    public static void b(bb4 bb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bb4Var, b84Var) == null) {
            t94.c(bb4Var, b84Var);
        }
    }

    public static void c(cb4 cb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cb4Var, b84Var) == null) {
            t94.d(cb4Var, b84Var);
        }
    }

    public static void d(db4 db4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, db4Var, b84Var) == null) {
            t94.e(db4Var, b84Var);
        }
    }

    public static void e(yc4 yc4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yc4Var, b84Var) == null) {
            t94.f(yc4Var, b84Var);
        }
    }

    public static synchronized void f(List<h94> list, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, b84Var) == null) {
            synchronized (r94.class) {
                t94.g(list, b84Var);
            }
        }
    }
}
