package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class F2 {
    public static /* synthetic */ Interceptable $ic;
    public static F2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap a;

    public F2() {
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
        this.a = new ConcurrentHashMap();
    }

    public static F2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (F2.class) {
                    if (b == null) {
                        b = new F2();
                    }
                }
            }
            return b;
        }
        return (F2) invokeV.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (str.length() > 16) {
                str = str.substring(0, 16);
            }
            return str + str2 + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public D2 a(String str) {
        InterceptResult invokeL;
        D2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (F2.class) {
                d2 = (D2) this.a.remove(str);
            }
            return d2;
        }
        return (D2) invokeL.objValue;
    }

    public void a(String str, D2 d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, d2) == null) {
            synchronized (F2.class) {
                this.a.put(str, d2);
            }
        }
    }
}
