package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class gx {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, fx> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964038860, "Lcom/repackage/gx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964038860, "Lcom/repackage/gx;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized fx a(String str) {
        InterceptResult invokeL;
        fx b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (gx.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (fx) invokeL.objValue;
    }

    public static synchronized fx b(String str, int i) {
        InterceptResult invokeLI;
        fx fxVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (gx.class) {
                if (!a.containsKey(str) || (fxVar = a.get(str)) == null) {
                    fx fxVar2 = new fx(str, i);
                    try {
                        fxVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, fxVar2);
                    return fxVar2;
                }
                return fxVar;
            }
        }
        return (fx) invokeLI.objValue;
    }

    public static synchronized void c(fx fxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fxVar) == null) {
            synchronized (gx.class) {
                if (fxVar != null) {
                    fxVar.a();
                    a.values().remove(fxVar);
                }
            }
        }
    }
}
