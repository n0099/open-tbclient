package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y29 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t29 a;
    public static q29 b;
    public static s29 c;
    public static r29 d;
    public static s19 e;
    public static w19 f;
    public transient /* synthetic */ FieldHolder $fh;

    public y29() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static q29 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            q29 q29Var = b;
            if (q29Var != null) {
                return q29Var;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                b = a.a();
            }
            return b;
        }
        return (q29) invokeV.objValue;
    }

    public static r29 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            r29 r29Var = d;
            if (r29Var != null) {
                return r29Var;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                d = a.e();
            }
            return d;
        }
        return (r29) invokeV.objValue;
    }

    public static s29 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            s29 s29Var = c;
            if (s29Var != null) {
                return s29Var;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                c = a.b();
            }
            return c;
        }
        return (s29) invokeV.objValue;
    }

    public static t29 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (y29.class) {
                if (a == null) {
                    a = x29.a();
                }
            }
            return a;
        }
        return (t29) invokeV.objValue;
    }

    public static s19 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            s19 s19Var = e;
            if (s19Var != null) {
                return s19Var;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                e = a.c();
            }
            return e;
        }
        return (s19) invokeV.objValue;
    }

    public static w19 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            w19 w19Var = f;
            if (w19Var != null) {
                return w19Var;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f = a.d();
            }
            return f;
        }
        return (w19) invokeV.objValue;
    }
}
