package com.repackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class hm0 {
    public static /* synthetic */ Interceptable $ic;
    public static mm0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static km0 a(mm0 mm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mm0Var)) == null) {
            if (mm0Var instanceof km0) {
                return (km0) mm0Var;
            }
            return null;
        }
        return (km0) invokeL.objValue;
    }

    public static nm0 b(mm0 mm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mm0Var)) == null) {
            if (mm0Var instanceof nm0) {
                return (nm0) mm0Var;
            }
            return null;
        }
        return (nm0) invokeL.objValue;
    }

    public static void c(@NonNull mm0 mm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mm0Var) == null) {
            synchronized (mm0.class) {
                if (a != null) {
                    return;
                }
                a = mm0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            km0 a2 = a(a);
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
            km0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(lm0 lm0Var) {
        nm0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, lm0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(lm0Var);
    }

    public static void g(lm0 lm0Var) {
        nm0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, lm0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(lm0Var);
    }
}
