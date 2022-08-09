package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class q36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends o26> T a(p26 p26Var, Class<T> type, o0 entity, h26 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, p26Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            n0 f = p26Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(p26 p26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p26Var)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            return d(p26Var).a();
        }
        return invokeL.longValue;
    }

    public static final h46 c(p26 p26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p26Var)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            return p26Var.i().d();
        }
        return (h46) invokeL.objValue;
    }

    public static final k46 d(p26 p26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p26Var)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            return p26Var.i().f();
        }
        return (k46) invokeL.objValue;
    }

    public static final boolean e(p26 p26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p26Var)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            n0 f = p26Var.f();
            n26 n26Var = f instanceof n26 ? (n26) f : null;
            if (n26Var == null) {
                return true;
            }
            return n26Var.x();
        }
        return invokeL.booleanValue;
    }
}
