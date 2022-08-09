package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class r36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final w26 a(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (w26) o0Var.d(w26.class);
        }
        return (w26) invokeL.objValue;
    }

    public static final t26 b(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (t26) o0Var.d(t26.class);
        }
        return (t26) invokeL.objValue;
    }

    public static final long c(o0 o0Var) {
        InterceptResult invokeL;
        h26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            t26 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final s26 d(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (s26) o0Var.d(s26.class);
        }
        return (s26) invokeL.objValue;
    }

    public static final u26 e(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (u26) o0Var.d(u26.class);
        }
        return (u26) invokeL.objValue;
    }

    public static final long f(o0 o0Var) {
        InterceptResult invokeL;
        h26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            t26 b = b(o0Var);
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
