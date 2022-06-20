package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x91 {
    public static /* synthetic */ Interceptable $ic;
    public static v91 a;
    public static w91 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755216863, "Lcom/repackage/x91;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755216863, "Lcom/repackage/x91;");
        }
    }

    public static v91 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (gk0.class) {
                    if (a == null) {
                        a = (v91) ServiceManager.getService(v91.a);
                    }
                    if (a == null) {
                        a = v91.b;
                    }
                }
            }
            return a;
        }
        return (v91) invokeV.objValue;
    }

    public static w91 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (gk0.class) {
                    if (b == null) {
                        b = (w91) ServiceManager.getService(w91.a);
                    }
                    if (b == null) {
                        b = w91.b;
                    }
                }
            }
            return b;
        }
        return (w91) invokeV.objValue;
    }
}
