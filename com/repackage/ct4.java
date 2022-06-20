package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ct4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static bt4 a = null;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755785682, "Lcom/repackage/ct4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755785682, "Lcom/repackage/ct4;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            bt4 bt4Var = a;
            if (bt4Var == null) {
                return -1;
            }
            return bt4Var.c();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            bt4 bt4Var = a;
            if (bt4Var == null) {
                return null;
            }
            return bt4Var.g();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            bt4 bt4Var = a;
            if (bt4Var == null) {
                return null;
            }
            return bt4Var.i();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || (bt4Var = a) == null) {
            return;
        }
        bt4Var.d(context);
    }

    public static void e(Context context, int i) {
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, context, i) == null) || (bt4Var = a) == null) {
            return;
        }
        bt4Var.e(context, i);
    }

    public static void f(Context context, int i, boolean z) {
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (bt4Var = a) == null) {
            return;
        }
        bt4Var.f(context, i, z);
    }

    public static void g(Context context, int i, boolean z) {
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (bt4Var = a) == null) {
            return;
        }
        bt4Var.h(context, i, z);
    }

    public static void h(bt4 bt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bt4Var) == null) {
            a = bt4Var;
        }
    }
}
