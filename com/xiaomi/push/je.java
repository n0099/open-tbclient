package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
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

    public static void a(jb jbVar, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jbVar, Byte.valueOf(b)}) == null) {
            a(jbVar, b, a);
        }
    }

    public static void a(jb jbVar, byte b, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{jbVar, Byte.valueOf(b), Integer.valueOf(i)}) != null) {
            return;
        }
        if (i <= 0) {
            throw new iv("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                jbVar.m567a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m555a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m565a();
                return;
            case 8:
                jbVar.m556a();
                return;
            case 10:
                jbVar.m557a();
                return;
            case 11:
                jbVar.m564a();
                return;
            case 12:
                jbVar.m562a();
                while (true) {
                    byte b2 = jbVar.m558a().a;
                    if (b2 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b2, i - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m560a = jbVar.m560a();
                while (i2 < m560a.f795a) {
                    int i3 = i - 1;
                    a(jbVar, m560a.a, i3);
                    a(jbVar, m560a.b, i3);
                    i2++;
                }
                jbVar.h();
                return;
            case 14:
                jf m561a = jbVar.m561a();
                while (i2 < m561a.f796a) {
                    a(jbVar, m561a.a, i - 1);
                    i2++;
                }
                jbVar.j();
                return;
            case 15:
                iz m559a = jbVar.m559a();
                while (i2 < m559a.f792a) {
                    a(jbVar, m559a.a, i - 1);
                    i2++;
                }
                jbVar.i();
                return;
        }
    }
}
