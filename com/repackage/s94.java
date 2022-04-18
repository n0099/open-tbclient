package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class s94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull bb4 bb4Var, @Nullable List<h94> list, @Nullable List<i94> list2, @NonNull c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, bb4Var, list, list2, c84Var) == null) {
            ma4 b = u94.b(bb4Var, c84Var);
            if (list != null && !list.isEmpty()) {
                u94.a(b, la4.h(list, c84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                u94.a(b, la4.e(list2, c84Var));
            }
            b.e();
        }
    }

    public static void b(cb4 cb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cb4Var, c84Var) == null) {
            u94.c(cb4Var, c84Var);
        }
    }

    public static void c(db4 db4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, db4Var, c84Var) == null) {
            u94.d(db4Var, c84Var);
        }
    }

    public static void d(eb4 eb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, eb4Var, c84Var) == null) {
            u94.e(eb4Var, c84Var);
        }
    }

    public static void e(zc4 zc4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zc4Var, c84Var) == null) {
            u94.f(zc4Var, c84Var);
        }
    }

    public static synchronized void f(List<i94> list, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, c84Var) == null) {
            synchronized (s94.class) {
                u94.g(list, c84Var);
            }
        }
    }
}
