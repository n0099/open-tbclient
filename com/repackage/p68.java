package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class p68 {
    public static /* synthetic */ Interceptable $ic;
    public static p68 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, q68> a;

    public p68() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }

    public static p68 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (p68.class) {
                    if (b == null) {
                        b = new p68();
                    }
                }
            }
            return b;
        }
        return (p68) invokeV.objValue;
    }

    public ConcurrentHashMap<String, q68> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ConcurrentHashMap) invokeV.objValue;
    }

    public q68 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ConcurrentHashMap<String, q68> concurrentHashMap = this.a;
            if (concurrentHashMap == null) {
                return null;
            }
            return concurrentHashMap.get(str);
        }
        return (q68) invokeL.objValue;
    }

    public void d(String str) {
        ConcurrentHashMap<String, q68> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            q68 q68Var = this.a.get(it.next());
            if (q68Var != null && str.equals(q68Var.b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, q68> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (concurrentHashMap = this.a) == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            q68 q68Var = this.a.get(str);
            if (q68Var != null) {
                q68Var.e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, q68> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            q68 q68Var = this.a.get(str2);
            if (q68Var != null && str.equals(q68Var.b)) {
                q68Var.e = z;
            }
        }
    }

    public void g(HashMap<String, q68> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.a.clear();
            if (hashMap == null) {
                return;
            }
            this.a.putAll(hashMap);
        }
    }

    public void h(String str, HashMap<String, q68> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) {
            if (this.a == null) {
                this.a = new ConcurrentHashMap<>();
            }
            d(str);
            this.a.putAll(hashMap);
        }
    }
}
