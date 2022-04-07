package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class t94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull cb4 cb4Var, @Nullable List<i94> list, @Nullable List<j94> list2, @NonNull d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, cb4Var, list, list2, d84Var) == null) {
            na4 b = v94.b(cb4Var, d84Var);
            if (list != null && !list.isEmpty()) {
                v94.a(b, ma4.h(list, d84Var));
            }
            if (list2 != null && !list2.isEmpty()) {
                v94.a(b, ma4.e(list2, d84Var));
            }
            b.e();
        }
    }

    public static void b(db4 db4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, db4Var, d84Var) == null) {
            v94.c(db4Var, d84Var);
        }
    }

    public static void c(eb4 eb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, eb4Var, d84Var) == null) {
            v94.d(eb4Var, d84Var);
        }
    }

    public static void d(fb4 fb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fb4Var, d84Var) == null) {
            v94.e(fb4Var, d84Var);
        }
    }

    public static void e(ad4 ad4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ad4Var, d84Var) == null) {
            v94.f(ad4Var, d84Var);
        }
    }

    public static synchronized void f(List<j94> list, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, d84Var) == null) {
            synchronized (t94.class) {
                v94.g(list, d84Var);
            }
        }
    }
}
