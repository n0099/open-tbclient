package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class y16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends w06> T a(x06 x06Var, Class<T> type, o0 entity, p06 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, x06Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(x06Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            n0 f = x06Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(x06 x06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x06Var)) == null) {
            Intrinsics.checkNotNullParameter(x06Var, "<this>");
            return d(x06Var).a();
        }
        return invokeL.longValue;
    }

    public static final p26 c(x06 x06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x06Var)) == null) {
            Intrinsics.checkNotNullParameter(x06Var, "<this>");
            return x06Var.i().d();
        }
        return (p26) invokeL.objValue;
    }

    public static final s26 d(x06 x06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x06Var)) == null) {
            Intrinsics.checkNotNullParameter(x06Var, "<this>");
            return x06Var.i().f();
        }
        return (s26) invokeL.objValue;
    }

    public static final boolean e(x06 x06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x06Var)) == null) {
            Intrinsics.checkNotNullParameter(x06Var, "<this>");
            n0 f = x06Var.f();
            v06 v06Var = f instanceof v06 ? (v06) f : null;
            if (v06Var == null) {
                return true;
            }
            return v06Var.x();
        }
        return invokeL.booleanValue;
    }
}
