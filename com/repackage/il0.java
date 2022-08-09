package com.repackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class il0 {
    public static /* synthetic */ Interceptable $ic;
    public static nl0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ll0 a(nl0 nl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nl0Var)) == null) {
            if (nl0Var instanceof ll0) {
                return (ll0) nl0Var;
            }
            return null;
        }
        return (ll0) invokeL.objValue;
    }

    public static ol0 b(nl0 nl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nl0Var)) == null) {
            if (nl0Var instanceof ol0) {
                return (ol0) nl0Var;
            }
            return null;
        }
        return (ol0) invokeL.objValue;
    }

    public static void c(@NonNull nl0 nl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, nl0Var) == null) {
            synchronized (nl0.class) {
                if (a != null) {
                    return;
                }
                a = nl0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ll0 a2 = a(a);
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
            ll0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(ml0 ml0Var) {
        ol0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, ml0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(ml0Var);
    }

    public static void g(ml0 ml0Var) {
        ol0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, ml0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(ml0Var);
    }
}
