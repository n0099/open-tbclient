package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ji {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = Integer.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56370975, "Lcom/xiaomi/push/ji;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56370975, "Lcom/xiaomi/push/ji;");
        }
    }

    public static void a(jf jfVar, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jfVar, Byte.valueOf(b)}) == null) {
            a(jfVar, b, a);
        }
    }

    public static void a(jf jfVar, byte b, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{jfVar, Byte.valueOf(b), Integer.valueOf(i)}) != null) {
            return;
        }
        if (i <= 0) {
            throw new iz("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                jfVar.m564a();
                return;
            case 3:
                jfVar.a();
                return;
            case 4:
                jfVar.m552a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jfVar.m562a();
                return;
            case 8:
                jfVar.m553a();
                return;
            case 10:
                jfVar.m554a();
                return;
            case 11:
                jfVar.m561a();
                return;
            case 12:
                jfVar.m559a();
                while (true) {
                    byte b2 = jfVar.m555a().a;
                    if (b2 == 0) {
                        jfVar.f();
                        return;
                    } else {
                        a(jfVar, b2, i - 1);
                        jfVar.g();
                    }
                }
            case 13:
                je m557a = jfVar.m557a();
                while (i2 < m557a.f835a) {
                    int i3 = i - 1;
                    a(jfVar, m557a.a, i3);
                    a(jfVar, m557a.b, i3);
                    i2++;
                }
                jfVar.h();
                return;
            case 14:
                jj m558a = jfVar.m558a();
                while (i2 < m558a.f836a) {
                    a(jfVar, m558a.a, i - 1);
                    i2++;
                }
                jfVar.j();
                return;
            case 15:
                jd m556a = jfVar.m556a();
                while (i2 < m556a.f834a) {
                    a(jfVar, m556a.a, i - 1);
                    i2++;
                }
                jfVar.i();
                return;
        }
    }
}
