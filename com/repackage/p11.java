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
public class p11 {
    public static /* synthetic */ Interceptable $ic;
    public static s11 a;
    public static w11 b;
    public static e11 c;
    public static y11 d;
    public static x11 e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755462879, "Lcom/repackage/p11;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755462879, "Lcom/repackage/p11;");
        }
    }

    public p11() {
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

    public static s11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (p11.class) {
                    if (a == null) {
                        a = (s11) ServiceManager.getService(s11.a);
                    }
                    if (a == null) {
                        a = s11.b;
                    }
                }
            }
            return a;
        }
        return (s11) invokeV.objValue;
    }

    public static e11 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (p11.class) {
                    if (c == null) {
                        c = (e11) ServiceManager.getService(e11.a);
                    }
                    if (c == null) {
                        c = e11.b;
                    }
                }
            }
            return c;
        }
        return (e11) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? xg0.b() : (Context) invokeV.objValue;
    }

    public static t11 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? t11.a : (t11) invokeV.objValue;
    }

    public static q11 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? q11.a : (q11) invokeV.objValue;
    }

    public static r11 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? r11.a : (r11) invokeV.objValue;
    }

    public static x11 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (e == null) {
                synchronized (p11.class) {
                    if (e == null) {
                        e = (x11) ServiceManager.getService(x11.a);
                    }
                    if (e == null) {
                        e = x11.b;
                    }
                }
            }
            return e;
        }
        return (x11) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? ck0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static w11 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (b == null) {
                synchronized (p11.class) {
                    if (b == null) {
                        b = (w11) ServiceManager.getService(w11.a);
                    }
                    if (b == null) {
                        b = w11.b;
                    }
                }
            }
            return b;
        }
        return (w11) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? ck0.b().a().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static y11 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (d == null) {
                synchronized (p11.class) {
                    if (d == null) {
                        d = (y11) ServiceManager.getService(y11.a);
                    }
                    if (d == null) {
                        d = y11.b;
                    }
                }
            }
            return d;
        }
        return (y11) invokeV.objValue;
    }
}
