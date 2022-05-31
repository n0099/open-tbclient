package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends yy5> T a(zy5 zy5Var, Class<T> type, l0 entity, ry5 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, zy5Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(zy5Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            k0 f = zy5Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(zy5 zy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zy5Var)) == null) {
            Intrinsics.checkNotNullParameter(zy5Var, "<this>");
            return d(zy5Var).a();
        }
        return invokeL.longValue;
    }

    public static final r06 c(zy5 zy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zy5Var)) == null) {
            Intrinsics.checkNotNullParameter(zy5Var, "<this>");
            return zy5Var.i().d();
        }
        return (r06) invokeL.objValue;
    }

    public static final u06 d(zy5 zy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zy5Var)) == null) {
            Intrinsics.checkNotNullParameter(zy5Var, "<this>");
            return zy5Var.i().f();
        }
        return (u06) invokeL.objValue;
    }

    public static final boolean e(zy5 zy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zy5Var)) == null) {
            Intrinsics.checkNotNullParameter(zy5Var, "<this>");
            k0 f = zy5Var.f();
            xy5 xy5Var = f instanceof xy5 ? (xy5) f : null;
            if (xy5Var == null) {
                return true;
            }
            return xy5Var.x();
        }
        return invokeL.booleanValue;
    }
}
