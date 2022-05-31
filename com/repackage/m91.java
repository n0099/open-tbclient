package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m91 {
    public static /* synthetic */ Interceptable $ic;
    public static k91 a;
    public static l91 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755544564, "Lcom/repackage/m91;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755544564, "Lcom/repackage/m91;");
        }
    }

    public static k91 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ck0.class) {
                    if (a == null) {
                        a = (k91) ServiceManager.getService(k91.a);
                    }
                    if (a == null) {
                        a = k91.b;
                    }
                }
            }
            return a;
        }
        return (k91) invokeV.objValue;
    }

    public static l91 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ck0.class) {
                    if (b == null) {
                        b = (l91) ServiceManager.getService(l91.a);
                    }
                    if (b == null) {
                        b = l91.b;
                    }
                }
            }
            return b;
        }
        return (l91) invokeV.objValue;
    }
}
