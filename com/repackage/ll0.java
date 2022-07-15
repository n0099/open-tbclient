package com.repackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class ll0 {
    public static /* synthetic */ Interceptable $ic;
    public static ql0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ol0 a(ql0 ql0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ql0Var)) == null) {
            if (ql0Var instanceof ol0) {
                return (ol0) ql0Var;
            }
            return null;
        }
        return (ol0) invokeL.objValue;
    }

    public static rl0 b(ql0 ql0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ql0Var)) == null) {
            if (ql0Var instanceof rl0) {
                return (rl0) ql0Var;
            }
            return null;
        }
        return (rl0) invokeL.objValue;
    }

    public static void c(@NonNull ql0 ql0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ql0Var) == null) {
            synchronized (ql0.class) {
                if (a != null) {
                    return;
                }
                a = ql0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ol0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ol0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(pl0 pl0Var) {
        rl0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, pl0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(pl0Var);
    }

    public static void g(pl0 pl0Var) {
        rl0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, pl0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(pl0Var);
    }
}
