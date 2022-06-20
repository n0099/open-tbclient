package com.repackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class yk0 {
    public static /* synthetic */ Interceptable $ic;
    public static dl0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static bl0 a(dl0 dl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dl0Var)) == null) {
            if (dl0Var instanceof bl0) {
                return (bl0) dl0Var;
            }
            return null;
        }
        return (bl0) invokeL.objValue;
    }

    public static el0 b(dl0 dl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dl0Var)) == null) {
            if (dl0Var instanceof el0) {
                return (el0) dl0Var;
            }
            return null;
        }
        return (el0) invokeL.objValue;
    }

    public static void c(@NonNull dl0 dl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dl0Var) == null) {
            synchronized (dl0.class) {
                if (a != null) {
                    return;
                }
                a = dl0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            bl0 a2 = a(a);
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
            bl0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(cl0 cl0Var) {
        el0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, cl0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(cl0Var);
    }

    public static void g(cl0 cl0Var) {
        el0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, cl0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(cl0Var);
    }
}
