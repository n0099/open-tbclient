package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class je {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = Integer.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56371099, "Lcom/xiaomi/push/je;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56371099, "Lcom/xiaomi/push/je;");
        }
    }

    public static void a(jb jbVar, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jbVar, Byte.valueOf(b2)}) == null) {
            a(jbVar, b2, a);
        }
    }

    public static void a(jb jbVar, byte b2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{jbVar, Byte.valueOf(b2), Integer.valueOf(i2)}) != null) {
            return;
        }
        if (i2 <= 0) {
            throw new iv("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b2) {
            case 2:
                jbVar.m581a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m569a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m579a();
                return;
            case 8:
                jbVar.m570a();
                return;
            case 10:
                jbVar.m571a();
                return;
            case 11:
                jbVar.m578a();
                return;
            case 12:
                jbVar.m576a();
                while (true) {
                    byte b3 = jbVar.m572a().a;
                    if (b3 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b3, i2 - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m574a = jbVar.m574a();
                while (i3 < m574a.f819a) {
                    int i4 = i2 - 1;
                    a(jbVar, m574a.a, i4);
                    a(jbVar, m574a.f63794b, i4);
                    i3++;
                }
                jbVar.h();
                return;
            case 14:
                jf m575a = jbVar.m575a();
                while (i3 < m575a.f820a) {
                    a(jbVar, m575a.a, i2 - 1);
                    i3++;
                }
                jbVar.j();
                return;
            case 15:
                iz m573a = jbVar.m573a();
                while (i3 < m573a.f816a) {
                    a(jbVar, m573a.a, i2 - 1);
                    i3++;
                }
                jbVar.i();
                return;
        }
    }
}
