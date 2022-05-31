package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final gz5 a(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (gz5) l0Var.d(gz5.class);
        }
        return (gz5) invokeL.objValue;
    }

    public static final dz5 b(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (dz5) l0Var.d(dz5.class);
        }
        return (dz5) invokeL.objValue;
    }

    public static final long c(l0 l0Var) {
        InterceptResult invokeL;
        ry5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            dz5 b = b(l0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final cz5 d(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (cz5) l0Var.d(cz5.class);
        }
        return (cz5) invokeL.objValue;
    }

    public static final ez5 e(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            return (ez5) l0Var.d(ez5.class);
        }
        return (ez5) invokeL.objValue;
    }

    public static final long f(l0 l0Var) {
        InterceptResult invokeL;
        ry5 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, l0Var)) == null) {
            Intrinsics.checkNotNullParameter(l0Var, "<this>");
            dz5 b = b(l0Var);
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
