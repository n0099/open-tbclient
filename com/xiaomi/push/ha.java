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
        fc m328a = gy.m326a().m328a();
        m328a.a(fb.CHANNEL_STATS_COUNTER.a());
        m328a.c(i);
        gy.m326a().a(m328a);
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
        fc m328a = gy.m326a().m328a();
        m328a.a((byte) i);
        m328a.a(i2);
        m328a.b(i3);
        m328a.b(str);
        m328a.c(i4);
        gy.m326a().a(m328a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (ha.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fc m328a = gy.m326a().m328a();
                m328a.a(i2);
                m328a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m328a.b(str);
                if (i3 > -1) {
                    m328a.c(i3);
                }
                gy.m326a().a(m328a);
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
        fc m328a = gy.m326a().m328a();
        if (i > 0) {
            m328a.a(fb.GSLB_REQUEST_SUCCESS.a());
            m328a.b(str);
            m328a.b(i);
            gy.m326a().a(m328a);
            return;
        }
        try {
            gw.a a2 = gw.a(exc);
            m328a.a(a2.a.a());
            m328a.c(a2.f436a);
            m328a.b(str);
            gy.m326a().a(m328a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gw.a b = gw.b(exc);
            fc m328a = gy.m326a().m328a();
            m328a.a(b.a.a());
            m328a.c(b.f436a);
            m328a.b(str);
            gy.m326a().a(m328a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m332a() {
        fd m329a = gy.m326a().m329a();
        if (m329a != null) {
            return iq.a(m329a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gw.a d = gw.d(exc);
            fc m328a = gy.m326a().m328a();
            m328a.a(d.a.a());
            m328a.c(d.f436a);
            m328a.b(str);
            gy.m326a().a(m328a);
        } catch (NullPointerException e) {
        }
    }
}
