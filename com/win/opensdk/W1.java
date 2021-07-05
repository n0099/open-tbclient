package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class W1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static W1 f42496b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f42497a;

    public W1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42497a = new ConcurrentHashMap();
    }

    public static W1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f42496b == null) {
                synchronized (W1.class) {
                    if (f42496b == null) {
                        f42496b = new W1();
                    }
                }
            }
            return f42496b;
        }
        return (W1) invokeV.objValue;
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

    public U1 a(String str) {
        InterceptResult invokeL;
        U1 u1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (W1.class) {
                u1 = (U1) this.f42497a.remove(str);
            }
            return u1;
        }
        return (U1) invokeL.objValue;
    }

    public void a(String str, U1 u1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, u1) == null) {
            synchronized (W1.class) {
                this.f42497a.put(str, u1);
            }
        }
    }
}
