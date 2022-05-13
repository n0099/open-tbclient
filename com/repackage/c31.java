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
/* loaded from: classes5.dex */
public class c31 {
    public static /* synthetic */ Interceptable $ic;
    public static f31 a;
    public static j31 b;
    public static r21 c;
    public static l31 d;
    public static k31 e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755848240, "Lcom/repackage/c31;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755848240, "Lcom/repackage/c31;");
        }
    }

    public c31() {
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

    public static f31 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (c31.class) {
                    if (a == null) {
                        a = (f31) ServiceManager.getService(f31.a);
                    }
                    if (a == null) {
                        a = f31.b;
                    }
                }
            }
            return a;
        }
        return (f31) invokeV.objValue;
    }

    public static r21 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (c31.class) {
                    if (c == null) {
                        c = (r21) ServiceManager.getService(r21.a);
                    }
                    if (c == null) {
                        c = r21.b;
                    }
                }
            }
            return c;
        }
        return (r21) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ki0.b() : (Context) invokeV.objValue;
    }

    public static g31 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? g31.a : (g31) invokeV.objValue;
    }

    public static d31 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? d31.a : (d31) invokeV.objValue;
    }

    public static e31 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? e31.a : (e31) invokeV.objValue;
    }

    public static k31 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (e == null) {
                synchronized (c31.class) {
                    if (e == null) {
                        e = (k31) ServiceManager.getService(k31.a);
                    }
                    if (e == null) {
                        e = k31.b;
                    }
                }
            }
            return e;
        }
        return (k31) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? pl0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static j31 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (b == null) {
                synchronized (c31.class) {
                    if (b == null) {
                        b = (j31) ServiceManager.getService(j31.a);
                    }
                    if (b == null) {
                        b = j31.b;
                    }
                }
            }
            return b;
        }
        return (j31) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? pl0.b().a().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static l31 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (d == null) {
                synchronized (c31.class) {
                    if (d == null) {
                        d = (l31) ServiceManager.getService(l31.a);
                    }
                    if (d == null) {
                        d = l31.b;
                    }
                }
            }
            return d;
        }
        return (l31) invokeV.objValue;
    }
}
