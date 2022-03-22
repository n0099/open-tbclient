package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
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

    public static void a(jb jbVar, byte b2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{jbVar, Byte.valueOf(b2), Integer.valueOf(i)}) != null) {
            return;
        }
        if (i <= 0) {
            throw new iv("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b2) {
            case 2:
                jbVar.m571a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m559a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m569a();
                return;
            case 8:
                jbVar.m560a();
                return;
            case 10:
                jbVar.m561a();
                return;
            case 11:
                jbVar.m568a();
                return;
            case 12:
                jbVar.m566a();
                while (true) {
                    byte b3 = jbVar.m562a().a;
                    if (b3 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b3, i - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m564a = jbVar.m564a();
                while (i2 < m564a.f795a) {
                    int i3 = i - 1;
                    a(jbVar, m564a.a, i3);
                    a(jbVar, m564a.f44519b, i3);
                    i2++;
                }
                jbVar.h();
                return;
            case 14:
                jf m565a = jbVar.m565a();
                while (i2 < m565a.f796a) {
                    a(jbVar, m565a.a, i - 1);
                    i2++;
                }
                jbVar.j();
                return;
            case 15:
                iz m563a = jbVar.m563a();
                while (i2 < m563a.f792a) {
                    a(jbVar, m563a.a, i - 1);
                    i2++;
                }
                jbVar.i();
                return;
        }
    }
}
