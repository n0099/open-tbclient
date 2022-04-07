package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class oa1 {
    public static /* synthetic */ Interceptable $ic;
    public static ma1 a;
    public static na1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755446542, "Lcom/repackage/oa1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755446542, "Lcom/repackage/oa1;");
        }
    }

    public static ma1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (pl0.class) {
                    if (a == null) {
                        a = (ma1) ServiceManager.getService(ma1.a);
                    }
                    if (a == null) {
                        a = ma1.b;
                    }
                }
            }
            return a;
        }
        return (ma1) invokeV.objValue;
    }

    public static na1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (pl0.class) {
                    if (b == null) {
                        b = (na1) ServiceManager.getService(na1.a);
                    }
                    if (b == null) {
                        b = na1.b;
                    }
                }
            }
            return b;
        }
        return (na1) invokeV.objValue;
    }
}
