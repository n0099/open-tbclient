package com.xiaomi.push;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class fj {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    public static long f369a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static Hashtable<Integer, Long> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1658384543, "Lcom/xiaomi/push/fj$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1658384543, "Lcom/xiaomi/push/fj$a;");
                    return;
                }
            }
            a = new Hashtable<>();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374788, "Lcom/xiaomi/push/fj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374788, "Lcom/xiaomi/push/fj;");
                return;
            }
        }
        a = ez.c.a();
        f369a = 0L;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (f369a == 0 || SystemClock.elapsedRealtime() - f369a > IMUserListModel.REQUEST_SPACE) {
                f369a = SystemClock.elapsedRealtime();
                a(0, a);
            }
        }
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            fa m331a = fh.m329a().m331a();
            m331a.a(ez.k.a());
            m331a.c(i);
            fh.m329a().a(m331a);
        }
    }

    public static synchronized void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) {
            synchronized (fj.class) {
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
            fa m331a = fh.m329a().m331a();
            m331a.a((byte) i);
            m331a.a(i2);
            m331a.b(i3);
            m331a.b(str);
            m331a.c(i4);
            fh.m329a().a(m331a);
        }
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            synchronized (fj.class) {
                long currentTimeMillis = System.currentTimeMillis();
                int i4 = (i << 24) | i2;
                if (a.a.containsKey(Integer.valueOf(i4))) {
                    fa m331a = fh.m329a().m331a();
                    m331a.a(i2);
                    m331a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                    m331a.b(str);
                    if (i3 > -1) {
                        m331a.c(i3);
                    }
                    fh.m329a().a(m331a);
                    a.a.remove(Integer.valueOf(i2));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
                }
            }
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, xMPushService, bVar) == null) {
            new fc(xMPushService, bVar).a();
        }
    }

    public static void a(String str, int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i, exc) == null) {
            fa m331a = fh.m329a().m331a();
            if (fh.a() != null && fh.a().f361a != null) {
                m331a.c(bj.c(fh.a().f361a) ? 1 : 0);
            }
            if (i > 0) {
                m331a.a(ez.l.a());
                m331a.b(str);
                m331a.b(i);
                fh.m329a().a(m331a);
                return;
            }
            try {
                ff.a a2 = ff.a(exc);
                m331a.a(a2.a.a());
                m331a.c(a2.f358a);
                m331a.b(str);
                fh.m329a().a(m331a);
            } catch (NullPointerException unused) {
            }
        }
    }

    public static void a(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, exc) == null) {
            try {
                ff.a b = ff.b(exc);
                fa m331a = fh.m329a().m331a();
                m331a.a(b.a.a());
                m331a.c(b.f358a);
                m331a.b(str);
                if (fh.a() != null && fh.a().f361a != null) {
                    m331a.c(bj.c(fh.a().f361a) ? 1 : 0);
                }
                fh.m329a().a(m331a);
            } catch (NullPointerException unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m335a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            fb m332a = fh.m329a().m332a();
            if (m332a != null) {
                return it.a(m332a);
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
                ff.a d = ff.d(exc);
                fa m331a = fh.m329a().m331a();
                m331a.a(d.a.a());
                m331a.c(d.f358a);
                m331a.b(str);
                if (fh.a() != null && fh.a().f361a != null) {
                    m331a.c(bj.c(fh.a().f361a) ? 1 : 0);
                }
                fh.m329a().a(m331a);
            } catch (NullPointerException unused) {
            }
        }
    }
}
