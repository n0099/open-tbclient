package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class je {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f78045a = Integer.MAX_VALUE;
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
            a(jbVar, b2, f78045a);
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
                jbVar.m532a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m520a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m530a();
                return;
            case 8:
                jbVar.m521a();
                return;
            case 10:
                jbVar.m522a();
                return;
            case 11:
                jbVar.m529a();
                return;
            case 12:
                jbVar.m527a();
                while (true) {
                    byte b3 = jbVar.m523a().f78036a;
                    if (b3 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b3, i2 - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m525a = jbVar.m525a();
                while (i3 < m525a.f818a) {
                    int i4 = i2 - 1;
                    a(jbVar, m525a.f78041a, i4);
                    a(jbVar, m525a.f78042b, i4);
                    i3++;
                }
                jbVar.h();
                return;
            case 14:
                jf m526a = jbVar.m526a();
                while (i3 < m526a.f819a) {
                    a(jbVar, m526a.f78046a, i2 - 1);
                    i3++;
                }
                jbVar.j();
                return;
            case 15:
                iz m524a = jbVar.m524a();
                while (i3 < m524a.f815a) {
                    a(jbVar, m524a.f78037a, i2 - 1);
                    i3++;
                }
                jbVar.i();
                return;
        }
    }
}
