package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class M1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639734197, "Lcom/win/opensdk/M1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639734197, "Lcom/win/opensdk/M1;");
                return;
            }
        }
        Executors.newFixedThreadPool(1);
        a = new HashMap();
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (M1.class) {
                a.remove(str);
            }
        }
    }

    public static synchronized void a(String str, L1 l1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, l1) == null) {
            synchronized (M1.class) {
                HashSet hashSet = (HashSet) a.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    a.put(str, hashSet);
                }
                hashSet.add(l1);
            }
        }
    }

    public static void a(String str, String str2, Object obj) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, obj) == null) || (hashSet = (HashSet) a.get(str)) == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((L1) it.next()).a(str, str2, obj);
        }
    }
}
