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
/* loaded from: classes6.dex */
public class f1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f39577a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639710172, "Lcom/win/opensdk/f1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639710172, "Lcom/win/opensdk/f1;");
                return;
            }
        }
        Executors.newFixedThreadPool(1);
        f39577a = new HashMap();
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (f1.class) {
                f39577a.remove(str);
            }
        }
    }

    public static synchronized void a(String str, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, e1Var) == null) {
            synchronized (f1.class) {
                HashSet hashSet = (HashSet) f39577a.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    f39577a.put(str, hashSet);
                }
                hashSet.add(e1Var);
            }
        }
    }

    public static void a(String str, String str2, Object obj) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, obj) == null) || (hashSet = (HashSet) f39577a.get(str)) == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((e1) it.next()).a(str, str2, obj);
        }
    }
}
