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

    public static final <T extends n06> T a(o06 o06Var, Class<T> type, l0 entity, g06 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, o06Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(o06Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            k0 f = o06Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o06Var)) == null) {
            Intrinsics.checkNotNullParameter(o06Var, "<this>");
            return d(o06Var).a();
        }
        return invokeL.longValue;
    }

    public static final g26 c(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o06Var)) == null) {
            Intrinsics.checkNotNullParameter(o06Var, "<this>");
            return o06Var.i().d();
        }
        return (g26) invokeL.objValue;
    }

    public static final j26 d(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o06Var)) == null) {
            Intrinsics.checkNotNullParameter(o06Var, "<this>");
            return o06Var.i().f();
        }
        return (j26) invokeL.objValue;
    }

    public static final boolean e(o06 o06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o06Var)) == null) {
            Intrinsics.checkNotNullParameter(o06Var, "<this>");
            k0 f = o06Var.f();
            m06 m06Var = f instanceof m06 ? (m06) f : null;
            if (m06Var == null) {
                return true;
            }
            return m06Var.x();
        }
        return invokeL.booleanValue;
    }
}
