package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class b94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ka4 ka4Var, @Nullable List<q84> list, @Nullable List<r84> list2, @NonNull l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, ka4Var, list, list2, l74Var) == null) {
            v94 b = d94.b(ka4Var, l74Var);
            if (list != null && !list.isEmpty()) {
                d94.a(b, u94.h(list, l74Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                d94.a(b, u94.e(list2, l74Var));
            }
            b.e();
        }
    }

    public static void b(la4 la4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, la4Var, l74Var) == null) {
            d94.c(la4Var, l74Var);
        }
    }

    public static void c(ma4 ma4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ma4Var, l74Var) == null) {
            d94.d(ma4Var, l74Var);
        }
    }

    public static void d(na4 na4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, na4Var, l74Var) == null) {
            d94.e(na4Var, l74Var);
        }
    }

    public static void e(ic4 ic4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ic4Var, l74Var) == null) {
            d94.f(ic4Var, l74Var);
        }
    }

    public static synchronized void f(List<r84> list, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, l74Var) == null) {
            synchronized (b94.class) {
                d94.g(list, l74Var);
            }
        }
    }
}
