package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h21 {
    public static /* synthetic */ Interceptable $ic;
    public static k21 a;
    public static o21 b;
    public static w11 c;
    public static q21 d;
    public static p21 e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755700246, "Lcom/repackage/h21;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755700246, "Lcom/repackage/h21;");
        }
    }

    public h21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static k21 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (h21.class) {
                    if (a == null) {
                        a = (k21) ServiceManager.getService(k21.a);
                    }
                    if (a == null) {
                        a = k21.b;
                    }
                }
            }
            return a;
        }
        return (k21) invokeV.objValue;
    }

    public static w11 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (h21.class) {
                    if (c == null) {
                        c = (w11) ServiceManager.getService(w11.a);
                    }
                    if (c == null) {
                        c = w11.b;
                    }
                }
            }
            return c;
        }
        return (w11) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? hh0.b() : (Context) invokeV.objValue;
    }

    public static l21 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? l21.a : (l21) invokeV.objValue;
    }

    public static i21 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? i21.a : (i21) invokeV.objValue;
    }

    public static j21 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? j21.a : (j21) invokeV.objValue;
    }

    public static p21 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (e == null) {
                synchronized (h21.class) {
                    if (e == null) {
                        e = (p21) ServiceManager.getService(p21.a);
                    }
                    if (e == null) {
                        e = p21.b;
                    }
                }
            }
            return e;
        }
        return (p21) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? tk0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static o21 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (b == null) {
                synchronized (h21.class) {
                    if (b == null) {
                        b = (o21) ServiceManager.getService(o21.a);
                    }
                    if (b == null) {
                        b = o21.b;
                    }
                }
            }
            return b;
        }
        return (o21) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? tk0.b().a().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static q21 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (d == null) {
                synchronized (h21.class) {
                    if (d == null) {
                        d = (q21) ServiceManager.getService(q21.a);
                    }
                    if (d == null) {
                        d = q21.b;
                    }
                }
            }
            return d;
        }
        return (q21) invokeV.objValue;
    }
}
