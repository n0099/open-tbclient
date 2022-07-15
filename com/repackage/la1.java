package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class la1 {
    public static /* synthetic */ Interceptable $ic;
    public static ja1 a;
    public static ka1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755535915, "Lcom/repackage/la1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755535915, "Lcom/repackage/la1;");
        }
    }

    public static ja1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (tk0.class) {
                    if (a == null) {
                        a = (ja1) ServiceManager.getService(ja1.a);
                    }
                    if (a == null) {
                        a = ja1.b;
                    }
                }
            }
            return a;
        }
        return (ja1) invokeV.objValue;
    }

    public static ka1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (tk0.class) {
                    if (b == null) {
                        b = (ka1) ServiceManager.getService(ka1.a);
                    }
                    if (b == null) {
                        b = ka1.b;
                    }
                }
            }
            return b;
        }
        return (ka1) invokeV.objValue;
    }
}
