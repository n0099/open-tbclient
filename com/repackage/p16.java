package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final u06 a(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (u06) l0Var.d(u06.class);
        }
        return (u06) invokeL.objValue;
    }

    public static final r06 b(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (r06) l0Var.d(r06.class);
        }
        return (r06) invokeL.objValue;
    }

    public static final long c(l0 l0Var) {
        InterceptResult invokeL;
        f06 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            r06 b = b(l0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final q06 d(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (q06) l0Var.d(q06.class);
        }
        return (q06) invokeL.objValue;
    }

    public static final s06 e(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (s06) l0Var.d(s06.class);
        }
        return (s06) invokeL.objValue;
    }

    public static final long f(l0 l0Var) {
        InterceptResult invokeL;
        f06 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            r06 b = b(l0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(l0 l0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, l0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return j - f(l0Var) < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(l0 l0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, l0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return j - f(l0Var) > c(l0Var);
        }
        return invokeLJ.booleanValue;
    }
}
