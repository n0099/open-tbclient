package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class ha {
    private static final int a = fb.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        fc m323a = gy.m321a().m323a();
        m323a.a(fb.CHANNEL_STATS_COUNTER.a());
        m323a.c(i);
        gy.m321a().a(m323a);
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
        fc m323a = gy.m321a().m323a();
        m323a.a((byte) i);
        m323a.a(i2);
        m323a.b(i3);
        m323a.b(str);
        m323a.c(i4);
        gy.m321a().a(m323a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (ha.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fc m323a = gy.m321a().m323a();
                m323a.a(i2);
                m323a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m323a.b(str);
                if (i3 > -1) {
                    m323a.c(i3);
                }
                gy.m321a().a(m323a);
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
        fc m323a = gy.m321a().m323a();
        if (i > 0) {
            m323a.a(fb.GSLB_REQUEST_SUCCESS.a());
            m323a.b(str);
            m323a.b(i);
            gy.m321a().a(m323a);
            return;
        }
        try {
            gw.a a2 = gw.a(exc);
            m323a.a(a2.a.a());
            m323a.c(a2.f435a);
            m323a.b(str);
            gy.m321a().a(m323a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gw.a b = gw.b(exc);
            fc m323a = gy.m321a().m323a();
            m323a.a(b.a.a());
            m323a.c(b.f435a);
            m323a.b(str);
            gy.m321a().a(m323a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m327a() {
        fd m324a = gy.m321a().m324a();
        if (m324a != null) {
            return iq.a(m324a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gw.a d = gw.d(exc);
            fc m323a = gy.m321a().m323a();
            m323a.a(d.a.a());
            m323a.c(d.f435a);
            m323a.b(str);
            gy.m321a().a(m323a);
        } catch (NullPointerException e) {
        }
    }
}
