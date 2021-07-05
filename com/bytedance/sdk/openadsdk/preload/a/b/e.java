package com.bytedance.sdk.openadsdk.preload.a.b;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f31854a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639650764, "Lcom/bytedance/sdk/openadsdk/preload/a/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639650764, "Lcom/bytedance/sdk/openadsdk/preload/a/b/e;");
                return;
            }
        }
        f31854a = c();
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int b2 = b(str);
            if (b2 == -1) {
                b2 = c(str);
            }
            if (b2 == -1) {
                return 6;
            }
            return b2;
        }
        return invokeL.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                String[] split = str.split("[._]");
                int parseInt = Integer.parseInt(split[0]);
                return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a(System.getProperty("java.version")) : invokeV.intValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f31854a : invokeV.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb.append(charAt);
                }
                return Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f31854a >= 9 : invokeV.booleanValue;
    }
}
