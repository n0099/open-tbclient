package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class gz {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static Hashtable<Integer, Long> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1659784720, "Lcom/xiaomi/push/gz$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1659784720, "Lcom/xiaomi/push/gz$a;");
                    return;
                }
            }
            a = new Hashtable<>();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56373331, "Lcom/xiaomi/push/gz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56373331, "Lcom/xiaomi/push/gz;");
                return;
            }
        }
        a = ew.f44223c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            a(0, a);
        }
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            ex m407a = gx.m405a().m407a();
            m407a.a(ew.k.a());
            m407a.c(i);
            gx.m405a().a(m407a);
        }
    }

    public static synchronized void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) {
            synchronized (gz.class) {
                if (i2 < 16777215) {
                    a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
                }
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4)}) == null) {
            ex m407a = gx.m405a().m407a();
            m407a.a((byte) i);
            m407a.a(i2);
            m407a.b(i3);
            m407a.b(str);
            m407a.c(i4);
            gx.m405a().a(m407a);
        }
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            synchronized (gz.class) {
                long currentTimeMillis = System.currentTimeMillis();
                int i4 = (i << 24) | i2;
                if (a.a.containsKey(Integer.valueOf(i4))) {
                    ex m407a = gx.m405a().m407a();
                    m407a.a(i2);
                    m407a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                    m407a.b(str);
                    if (i3 > -1) {
                        m407a.c(i3);
                    }
                    gx.m405a().a(m407a);
                    a.a.remove(Integer.valueOf(i2));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
                }
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, xMPushService, bVar) == null) {
            new gs(xMPushService, bVar).a();
        }
    }

    public static void a(String str, int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i, exc) == null) {
            ex m407a = gx.m405a().m407a();
            if (i > 0) {
                m407a.a(ew.l.a());
                m407a.b(str);
                m407a.b(i);
                gx.m405a().a(m407a);
                return;
            }
            try {
                gv.a a2 = gv.a(exc);
                m407a.a(a2.a.a());
                m407a.c(a2.f436a);
                m407a.b(str);
                gx.m405a().a(m407a);
            } catch (NullPointerException unused) {
            }
        }
    }

    public static void a(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, exc) == null) {
            try {
                gv.a b2 = gv.b(exc);
                ex m407a = gx.m405a().m407a();
                m407a.a(b2.a.a());
                m407a.c(b2.f436a);
                m407a.b(str);
                gx.m405a().a(m407a);
            } catch (NullPointerException unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m411a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            ey m408a = gx.m405a().m408a();
            if (m408a != null) {
                return ip.a(m408a);
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            a(0, a, null, -1);
        }
    }

    public static void b(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, exc) == null) {
            try {
                gv.a d2 = gv.d(exc);
                ex m407a = gx.m405a().m407a();
                m407a.a(d2.a.a());
                m407a.c(d2.f436a);
                m407a.b(str);
                gx.m405a().a(m407a);
            } catch (NullPointerException unused) {
            }
        }
    }
}
