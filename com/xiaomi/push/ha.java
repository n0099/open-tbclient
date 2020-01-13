package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
import java.util.Hashtable;
/* loaded from: classes6.dex */
public class ha {
    private static final int a = fb.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        fc m320a = gy.m318a().m320a();
        m320a.a(fb.CHANNEL_STATS_COUNTER.a());
        m320a.c(i);
        gy.m318a().a(m320a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (ha.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fc m320a = gy.m318a().m320a();
        m320a.a((byte) i);
        m320a.a(i2);
        m320a.b(i3);
        m320a.b(str);
        m320a.c(i4);
        gy.m318a().a(m320a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (ha.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fc m320a = gy.m318a().m320a();
                m320a.a(i2);
                m320a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m320a.b(str);
                if (i3 > -1) {
                    m320a.c(i3);
                }
                gy.m318a().a(m320a);
                a.a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, al.b bVar) {
        new gt(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fc m320a = gy.m318a().m320a();
        if (i > 0) {
            m320a.a(fb.GSLB_REQUEST_SUCCESS.a());
            m320a.b(str);
            m320a.b(i);
            gy.m318a().a(m320a);
            return;
        }
        try {
            gw.a a2 = gw.a(exc);
            m320a.a(a2.a.a());
            m320a.c(a2.f438a);
            m320a.b(str);
            gy.m318a().a(m320a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gw.a b = gw.b(exc);
            fc m320a = gy.m318a().m320a();
            m320a.a(b.a.a());
            m320a.c(b.f438a);
            m320a.b(str);
            gy.m318a().a(m320a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m324a() {
        fd m321a = gy.m318a().m321a();
        if (m321a != null) {
            return iq.a(m321a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gw.a d = gw.d(exc);
            fc m320a = gy.m318a().m320a();
            m320a.a(d.a.a());
            m320a.c(d.f438a);
            m320a.b(str);
            gy.m318a().a(m320a);
        } catch (NullPointerException e) {
        }
    }
}
