package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class v2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static final int b = 16;
    public static final String c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    public static String d = "L3gvZi9n";
    public static String e = "L2YvYS9w";
    public static String f = "L3Jlc3QvaW5mcmEvZ2RmcC9jL3MvbA==";
    public static String g = "L3Jlc3QvaW5mcmEvZ2RmcC9hL3E=";
    public static String h = "L3IvdC9o";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334602203, "Lcom/kuaishou/weapon/p0/v2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334602203, "Lcom/kuaishou/weapon/p0/v2;");
                return;
            }
        }
        a = a();
        d = d.b(d, 2);
        e = d.b(e, 2);
        f = d.b(f, 2);
        g = d.b(g, 2);
        h = d.b(h, 2);
    }

    public v2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return n1.c(b() ? "Y1dRJlUS0ggA8rDIzmTuSb18fETpsUSliIb8eUc8Cs7Tg08T72W0GoR0htlL8mwiuorXs9F6RhwIlueUNq7egw==" : "Y1dRJlUS0ggA8rDIzmTuSdNPHbegnkXofklx4RRLaYJoK5uDjDZ2N7h9QqyTv9Qg");
        }
        return (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
