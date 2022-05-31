package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class tv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, sv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964026429, "Lcom/repackage/tv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964026429, "Lcom/repackage/tv;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized sv a(String str) {
        InterceptResult invokeL;
        sv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (tv.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (sv) invokeL.objValue;
    }

    public static synchronized sv b(String str, int i) {
        InterceptResult invokeLI;
        sv svVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (tv.class) {
                if (!a.containsKey(str) || (svVar = a.get(str)) == null) {
                    sv svVar2 = new sv(str, i);
                    try {
                        svVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, svVar2);
                    return svVar2;
                }
                return svVar;
            }
        }
        return (sv) invokeLI.objValue;
    }

    public static synchronized void c(sv svVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, svVar) == null) {
            synchronized (tv.class) {
                if (svVar != null) {
                    svVar.a();
                    a.values().remove(svVar);
                }
            }
        }
    }
}
