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
/* loaded from: classes4.dex */
public class gz {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
        a = ew.f63438c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            a(0, a);
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            ex m417a = gx.m415a().m417a();
            m417a.a(ew.f63446k.a());
            m417a.c(i2);
            gx.m415a().a(m417a);
        }
    }

    public static synchronized void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i2, i3) == null) {
            synchronized (gz.class) {
                if (i3 < 16777215) {
                    a.a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
                }
            }
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5)}) == null) {
            ex m417a = gx.m415a().m417a();
            m417a.a((byte) i2);
            m417a.a(i3);
            m417a.b(i4);
            m417a.b(str);
            m417a.c(i5);
            gx.m415a().a(m417a);
        }
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4)}) == null) {
            synchronized (gz.class) {
                long currentTimeMillis = System.currentTimeMillis();
                int i5 = (i2 << 24) | i3;
                if (a.a.containsKey(Integer.valueOf(i5))) {
                    ex m417a = gx.m415a().m417a();
                    m417a.a(i3);
                    m417a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i5)).longValue()));
                    m417a.b(str);
                    if (i4 > -1) {
                        m417a.c(i4);
                    }
                    gx.m415a().a(m417a);
                    a.a.remove(Integer.valueOf(i3));
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

    public static void a(String str, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i2, exc) == null) {
            ex m417a = gx.m415a().m417a();
            if (i2 > 0) {
                m417a.a(ew.l.a());
                m417a.b(str);
                m417a.b(i2);
                gx.m415a().a(m417a);
                return;
            }
            try {
                gv.a a2 = gv.a(exc);
                m417a.a(a2.a.a());
                m417a.c(a2.f460a);
                m417a.b(str);
                gx.m415a().a(m417a);
            } catch (NullPointerException unused) {
            }
        }
    }

    public static void a(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, exc) == null) {
            try {
                gv.a b2 = gv.b(exc);
                ex m417a = gx.m415a().m417a();
                m417a.a(b2.a.a());
                m417a.c(b2.f460a);
                m417a.b(str);
                gx.m415a().a(m417a);
            } catch (NullPointerException unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m421a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            ey m418a = gx.m415a().m418a();
            if (m418a != null) {
                return ip.a(m418a);
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
                ex m417a = gx.m415a().m417a();
                m417a.a(d2.a.a());
                m417a.c(d2.f460a);
                m417a.b(str);
                gx.m415a().a(m417a);
            } catch (NullPointerException unused) {
            }
        }
    }
}
