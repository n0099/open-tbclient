package com.repackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class uk0 {
    public static /* synthetic */ Interceptable $ic;
    public static zk0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static xk0 a(zk0 zk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zk0Var)) == null) {
            if (zk0Var instanceof xk0) {
                return (xk0) zk0Var;
            }
            return null;
        }
        return (xk0) invokeL.objValue;
    }

    public static al0 b(zk0 zk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zk0Var)) == null) {
            if (zk0Var instanceof al0) {
                return (al0) zk0Var;
            }
            return null;
        }
        return (al0) invokeL.objValue;
    }

    public static void c(@NonNull zk0 zk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zk0Var) == null) {
            synchronized (zk0.class) {
                if (a != null) {
                    return;
                }
                a = zk0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            xk0 a2 = a(a);
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
            xk0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(yk0 yk0Var) {
        al0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, yk0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(yk0Var);
    }

    public static void g(yk0 yk0Var) {
        al0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, yk0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(yk0Var);
    }
}
