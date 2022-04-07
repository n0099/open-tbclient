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
/* loaded from: classes7.dex */
public class s21 {
    public static /* synthetic */ Interceptable $ic;
    public static v21 a;
    public static z21 b;
    public static h21 c;
    public static b31 d;
    public static a31 e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755372545, "Lcom/repackage/s21;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755372545, "Lcom/repackage/s21;");
        }
    }

    public s21() {
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

    public static v21 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (s21.class) {
                    if (a == null) {
                        a = (v21) ServiceManager.getService(v21.a);
                    }
                    if (a == null) {
                        a = v21.b;
                    }
                }
            }
            return a;
        }
        return (v21) invokeV.objValue;
    }

    public static h21 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (s21.class) {
                    if (c == null) {
                        c = (h21) ServiceManager.getService(h21.a);
                    }
                    if (c == null) {
                        c = h21.b;
                    }
                }
            }
            return c;
        }
        return (h21) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? hi0.b() : (Context) invokeV.objValue;
    }

    public static w21 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? w21.a : (w21) invokeV.objValue;
    }

    public static t21 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? t21.a : (t21) invokeV.objValue;
    }

    public static u21 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? u21.a : (u21) invokeV.objValue;
    }

    public static a31 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (e == null) {
                synchronized (s21.class) {
                    if (e == null) {
                        e = (a31) ServiceManager.getService(a31.a);
                    }
                    if (e == null) {
                        e = a31.b;
                    }
                }
            }
            return e;
        }
        return (a31) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? pl0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static z21 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (b == null) {
                synchronized (s21.class) {
                    if (b == null) {
                        b = (z21) ServiceManager.getService(z21.a);
                    }
                    if (b == null) {
                        b = z21.b;
                    }
                }
            }
            return b;
        }
        return (z21) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? pl0.b().a().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static b31 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (d == null) {
                synchronized (s21.class) {
                    if (d == null) {
                        d = (b31) ServiceManager.getService(b31.a);
                    }
                    if (d == null) {
                        d = b31.b;
                    }
                }
            }
            return d;
        }
        return (b31) invokeV.objValue;
    }
}
