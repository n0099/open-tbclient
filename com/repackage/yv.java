package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class yv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, xv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964021624, "Lcom/repackage/yv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964021624, "Lcom/repackage/yv;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized xv a(String str) {
        InterceptResult invokeL;
        xv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (yv.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (xv) invokeL.objValue;
    }

    public static synchronized xv b(String str, int i) {
        InterceptResult invokeLI;
        xv xvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (yv.class) {
                if (!a.containsKey(str) || (xvVar = a.get(str)) == null) {
                    xv xvVar2 = new xv(str, i);
                    try {
                        xvVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, xvVar2);
                    return xvVar2;
                }
                return xvVar;
            }
        }
        return (xv) invokeLI.objValue;
    }

    public static synchronized void c(xv xvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xvVar) == null) {
            synchronized (yv.class) {
                if (xvVar != null) {
                    xvVar.a();
                    a.values().remove(xvVar);
                }
            }
        }
    }
}
