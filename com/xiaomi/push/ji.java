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
                jfVar.m1492a();
                return;
            case 3:
                jfVar.a();
                return;
            case 4:
                jfVar.m1480a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jfVar.m1490a();
                return;
            case 8:
                jfVar.m1481a();
                return;
            case 10:
                jfVar.m1482a();
                return;
            case 11:
                jfVar.m1489a();
                return;
            case 12:
                jfVar.m1487a();
                while (true) {
                    byte b2 = jfVar.m1483a().a;
                    if (b2 == 0) {
                        jfVar.f();
                        return;
                    } else {
                        a(jfVar, b2, i - 1);
                        jfVar.g();
                    }
                }
            case 13:
                je m1485a = jfVar.m1485a();
                while (i2 < m1485a.f1531a) {
                    int i3 = i - 1;
                    a(jfVar, m1485a.a, i3);
                    a(jfVar, m1485a.b, i3);
                    i2++;
                }
                jfVar.h();
                return;
            case 14:
                jj m1486a = jfVar.m1486a();
                while (i2 < m1486a.f1532a) {
                    a(jfVar, m1486a.a, i - 1);
                    i2++;
                }
                jfVar.j();
                return;
            case 15:
                jd m1484a = jfVar.m1484a();
                while (i2 < m1484a.f1530a) {
                    a(jfVar, m1484a.a, i - 1);
                    i2++;
                }
                jfVar.i();
                return;
        }
    }
}
