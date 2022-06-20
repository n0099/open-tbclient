package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends yz5> T a(zz5 zz5Var, Class<T> type, o0 entity, rz5 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, zz5Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(zz5Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            n0 f = zz5Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(zz5 zz5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zz5Var)) == null) {
            Intrinsics.checkNotNullParameter(zz5Var, "<this>");
            return d(zz5Var).a();
        }
        return invokeL.longValue;
    }

    public static final r16 c(zz5 zz5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zz5Var)) == null) {
            Intrinsics.checkNotNullParameter(zz5Var, "<this>");
            return zz5Var.i().d();
        }
        return (r16) invokeL.objValue;
    }

    public static final u16 d(zz5 zz5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zz5Var)) == null) {
            Intrinsics.checkNotNullParameter(zz5Var, "<this>");
            return zz5Var.i().f();
        }
        return (u16) invokeL.objValue;
    }

    public static final boolean e(zz5 zz5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zz5Var)) == null) {
            Intrinsics.checkNotNullParameter(zz5Var, "<this>");
            n0 f = zz5Var.f();
            xz5 xz5Var = f instanceof xz5 ? (xz5) f : null;
            if (xz5Var == null) {
                return true;
            }
            return xz5Var.x();
        }
        return invokeL.booleanValue;
    }
}
