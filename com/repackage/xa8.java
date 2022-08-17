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
/* loaded from: classes7.dex */
public class xa8 {
    public static /* synthetic */ Interceptable $ic;
    public static xa8 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, ya8> a;

    public xa8() {
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

    public static xa8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (xa8.class) {
                    if (b == null) {
                        b = new xa8();
                    }
                }
            }
            return b;
        }
        return (xa8) invokeV.objValue;
    }

    public ConcurrentHashMap<String, ya8> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ConcurrentHashMap) invokeV.objValue;
    }

    public ya8 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ConcurrentHashMap<String, ya8> concurrentHashMap = this.a;
            if (concurrentHashMap == null) {
                return null;
            }
            return concurrentHashMap.get(str);
        }
        return (ya8) invokeL.objValue;
    }

    public void d(String str) {
        ConcurrentHashMap<String, ya8> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            ya8 ya8Var = this.a.get(it.next());
            if (ya8Var != null && str.equals(ya8Var.b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, ya8> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (concurrentHashMap = this.a) == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            ya8 ya8Var = this.a.get(str);
            if (ya8Var != null) {
                ya8Var.e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, ya8> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            ya8 ya8Var = this.a.get(str2);
            if (ya8Var != null && str.equals(ya8Var.b)) {
                ya8Var.e = z;
            }
        }
    }

    public void g(HashMap<String, ya8> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.a.clear();
            if (hashMap == null) {
                return;
            }
            this.a.putAll(hashMap);
        }
    }

    public void h(String str, HashMap<String, ya8> hashMap) {
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
