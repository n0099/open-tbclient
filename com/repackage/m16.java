package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class m16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends k06> T a(l06 l06Var, Class<T> type, l0 entity, d06 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, l06Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(l06Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            k0 f = l06Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(l06 l06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l06Var)) == null) {
            Intrinsics.checkNotNullParameter(l06Var, "<this>");
            return d(l06Var).a();
        }
        return invokeL.longValue;
    }

    public static final d26 c(l06 l06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, l06Var)) == null) {
            Intrinsics.checkNotNullParameter(l06Var, "<this>");
            return l06Var.i().d();
        }
        return (d26) invokeL.objValue;
    }

    public static final g26 d(l06 l06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l06Var)) == null) {
            Intrinsics.checkNotNullParameter(l06Var, "<this>");
            return l06Var.i().f();
        }
        return (g26) invokeL.objValue;
    }

    public static final boolean e(l06 l06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l06Var)) == null) {
            Intrinsics.checkNotNullParameter(l06Var, "<this>");
            k0 f = l06Var.f();
            j06 j06Var = f instanceof j06 ? (j06) f : null;
            if (j06Var == null) {
                return true;
            }
            return j06Var.x();
        }
        return invokeL.booleanValue;
    }
}
