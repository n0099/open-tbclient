package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ty0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Runnable runnable, @NonNull String str, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{runnable, str, Integer.valueOf(i), Long.valueOf(j)}) == null) || runnable == null) {
            return;
        }
        bz0.b().a().a(runnable, str, (i == 0 || i == 1 || i == 2 || i == 3) ? i : 3, j);
    }

    public static void b(Runnable runnable, @NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{runnable, str, Long.valueOf(j)}) == null) || runnable == null) {
            return;
        }
        bz0.b().a().b(runnable, str, j);
    }

    public static void c(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, runnable, str, i) == null) {
            a(runnable, str, i, 0L);
        }
    }

    public static void d(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, runnable, str) == null) {
            b(runnable, str, 0L);
        }
    }
}
