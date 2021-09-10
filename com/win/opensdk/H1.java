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
/* loaded from: classes10.dex */
public class H1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f76800a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639739002, "Lcom/win/opensdk/H1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639739002, "Lcom/win/opensdk/H1;");
                return;
            }
        }
        Executors.newFixedThreadPool(1);
        f76800a = new HashMap();
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (H1.class) {
                f76800a.remove(str);
            }
        }
    }

    public static synchronized void a(String str, G1 g1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, g1) == null) {
            synchronized (H1.class) {
                HashSet hashSet = (HashSet) f76800a.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    f76800a.put(str, hashSet);
                }
                hashSet.add(g1);
            }
        }
    }

    public static void a(String str, String str2, Object obj) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, obj) == null) || (hashSet = (HashSet) f76800a.get(str)) == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((G1) it.next()).a(str, str2, obj);
        }
    }
}
