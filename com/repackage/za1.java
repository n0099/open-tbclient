package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class za1 {
    public static /* synthetic */ Interceptable $ic;
    public static xa1 a;
    public static ya1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755118841, "Lcom/repackage/za1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755118841, "Lcom/repackage/za1;");
        }
    }

    public static xa1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (pl0.class) {
                    if (a == null) {
                        a = (xa1) ServiceManager.getService(xa1.a);
                    }
                    if (a == null) {
                        a = xa1.b;
                    }
                }
            }
            return a;
        }
        return (xa1) invokeV.objValue;
    }

    public static ya1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (pl0.class) {
                    if (b == null) {
                        b = (ya1) ServiceManager.getService(ya1.a);
                    }
                    if (b == null) {
                        b = ya1.b;
                    }
                }
            }
            return b;
        }
        return (ya1) invokeV.objValue;
    }
}
