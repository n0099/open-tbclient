package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class z16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e16 a(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (e16) o0Var.d(e16.class);
        }
        return (e16) invokeL.objValue;
    }

    public static final b16 b(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (b16) o0Var.d(b16.class);
        }
        return (b16) invokeL.objValue;
    }

    public static final long c(o0 o0Var) {
        InterceptResult invokeL;
        p06 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            b16 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final a16 d(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (a16) o0Var.d(a16.class);
        }
        return (a16) invokeL.objValue;
    }

    public static final c16 e(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (c16) o0Var.d(c16.class);
        }
        return (c16) invokeL.objValue;
    }

    public static final long f(o0 o0Var) {
        InterceptResult invokeL;
        p06 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            b16 b = b(o0Var);
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
