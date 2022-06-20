package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final g06 a(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (g06) o0Var.d(g06.class);
        }
        return (g06) invokeL.objValue;
    }

    public static final d06 b(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (d06) o0Var.d(d06.class);
        }
        return (d06) invokeL.objValue;
    }

    public static final long c(o0 o0Var) {
        InterceptResult invokeL;
        rz5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            d06 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final c06 d(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (c06) o0Var.d(c06.class);
        }
        return (c06) invokeL.objValue;
    }

    public static final e06 e(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (e06) o0Var.d(e06.class);
        }
        return (e06) invokeL.objValue;
    }

    public static final long f(o0 o0Var) {
        InterceptResult invokeL;
        rz5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            d06 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(o0 o0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, o0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return j - f(o0Var) < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(o0 o0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, o0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return j - f(o0Var) > c(o0Var);
        }
        return invokeLJ.booleanValue;
    }
}
