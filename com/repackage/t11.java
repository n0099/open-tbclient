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
public class t11 {
    public static /* synthetic */ Interceptable $ic;
    public static w11 a;
    public static a21 b;
    public static i11 c;
    public static c21 d;
    public static b21 e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755343715, "Lcom/repackage/t11;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755343715, "Lcom/repackage/t11;");
        }
    }

    public t11() {
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

    public static w11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (t11.class) {
                    if (a == null) {
                        a = (w11) ServiceManager.getService(w11.a);
                    }
                    if (a == null) {
                        a = w11.b;
                    }
                }
            }
            return a;
        }
        return (w11) invokeV.objValue;
    }

    public static i11 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (t11.class) {
                    if (c == null) {
                        c = (i11) ServiceManager.getService(i11.a);
                    }
                    if (c == null) {
                        c = i11.b;
                    }
                }
            }
            return c;
        }
        return (i11) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? bh0.b() : (Context) invokeV.objValue;
    }

    public static x11 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? x11.a : (x11) invokeV.objValue;
    }

    public static u11 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? u11.a : (u11) invokeV.objValue;
    }

    public static v11 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? v11.a : (v11) invokeV.objValue;
    }

    public static b21 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (e == null) {
                synchronized (t11.class) {
                    if (e == null) {
                        e = (b21) ServiceManager.getService(b21.a);
                    }
                    if (e == null) {
                        e = b21.b;
                    }
                }
            }
            return e;
        }
        return (b21) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? gk0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static a21 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (b == null) {
                synchronized (t11.class) {
                    if (b == null) {
                        b = (a21) ServiceManager.getService(a21.a);
                    }
                    if (b == null) {
                        b = a21.b;
                    }
                }
            }
            return b;
        }
        return (a21) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? gk0.b().a().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static c21 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (d == null) {
                synchronized (t11.class) {
                    if (d == null) {
                        d = (c21) ServiceManager.getService(c21.a);
                    }
                    if (d == null) {
                        d = c21.b;
                    }
                }
            }
            return d;
        }
        return (c21) invokeV.objValue;
    }
}
