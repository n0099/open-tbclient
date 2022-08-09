package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cb1 {
    public static /* synthetic */ Interceptable $ic;
    public static ab1 a;
    public static bb1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755803073, "Lcom/repackage/cb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755803073, "Lcom/repackage/cb1;");
        }
    }

    public static ab1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qk0.class) {
                    if (a == null) {
                        a = (ab1) ServiceManager.getService(ab1.a);
                    }
                    if (a == null) {
                        a = ab1.b;
                    }
                }
            }
            return a;
        }
        return (ab1) invokeV.objValue;
    }

    public static bb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qk0.class) {
                    if (b == null) {
                        b = (bb1) ServiceManager.getService(bb1.a);
                    }
                    if (b == null) {
                        b = bb1.b;
                    }
                }
            }
            return b;
        }
        return (bb1) invokeV.objValue;
    }
}
