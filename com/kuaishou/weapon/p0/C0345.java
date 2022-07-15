package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʼﹳ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0345 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f141 = null;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final int f142 = 16;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f143 = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String f144 = "L3gvZi9n";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String f145 = "L2YvYS9w";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static String f146 = "L3Jlc3QvaW5mcmEvZ2RmcC9jL3MvbA==";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static String f147 = "L3Jlc3QvaW5mcmEvZ2RmcC9hL3E=";

    /* renamed from: ˉ  reason: contains not printable characters */
    public static String f148 = "L3IvdC9o";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(337179264, "Lcom/kuaishou/weapon/p0/ʼﹳ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(337179264, "Lcom/kuaishou/weapon/p0/ʼﹳ;");
                return;
            }
        }
        f141 = m300();
        f144 = C0446.m976(f144, 2);
        f145 = C0446.m976(f145, 2);
        f146 = C0446.m976(f146, 2);
        f147 = C0446.m976(f147, 2);
        f148 = C0446.m976(f148, 2);
    }

    public C0345() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m300() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return C0297.m147(m301() ? "Y1dRJlUS0ggA8rDIzmTuSb18fETpsUSliIb8eUc8Cs7Tg08T72W0GoR0htlL8mwiuorXs9F6RhwIlueUNq7egw==" : "Y1dRJlUS0ggA8rDIzmTuSdNPHbegnkXofklx4RRLaYJoK5uDjDZ2N7h9QqyTv9Qg");
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m301() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
