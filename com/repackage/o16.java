package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class o16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends m06> T a(n06 n06Var, Class<T> type, l0 entity, f06 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, n06Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(n06Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            k0 f = n06Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(n06 n06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n06Var)) == null) {
            Intrinsics.checkNotNullParameter(n06Var, "<this>");
            return d(n06Var).a();
        }
        return invokeL.longValue;
    }

    public static final f26 c(n06 n06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, n06Var)) == null) {
            Intrinsics.checkNotNullParameter(n06Var, "<this>");
            return n06Var.i().d();
        }
        return (f26) invokeL.objValue;
    }

    public static final i26 d(n06 n06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, n06Var)) == null) {
            Intrinsics.checkNotNullParameter(n06Var, "<this>");
            return n06Var.i().f();
        }
        return (i26) invokeL.objValue;
    }

    public static final boolean e(n06 n06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, n06Var)) == null) {
            Intrinsics.checkNotNullParameter(n06Var, "<this>");
            k0 f = n06Var.f();
            l06 l06Var = f instanceof l06 ? (l06) f : null;
            if (l06Var == null) {
                return true;
            }
            return l06Var.x();
        }
        return invokeL.booleanValue;
    }
}
