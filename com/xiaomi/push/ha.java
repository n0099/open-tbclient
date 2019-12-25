package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
import java.util.Hashtable;
/* loaded from: classes5.dex */
public class ha {
    private static final int a = fb.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        fc m311a = gy.m309a().m311a();
        m311a.a(fb.CHANNEL_STATS_COUNTER.a());
        m311a.c(i);
        gy.m309a().a(m311a);
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
        fc m311a = gy.m309a().m311a();
        m311a.a((byte) i);
        m311a.a(i2);
        m311a.b(i3);
        m311a.b(str);
        m311a.c(i4);
        gy.m309a().a(m311a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (ha.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fc m311a = gy.m309a().m311a();
                m311a.a(i2);
                m311a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m311a.b(str);
                if (i3 > -1) {
                    m311a.c(i3);
                }
                gy.m309a().a(m311a);
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
        fc m311a = gy.m309a().m311a();
        if (i > 0) {
            m311a.a(fb.GSLB_REQUEST_SUCCESS.a());
            m311a.b(str);
            m311a.b(i);
            gy.m309a().a(m311a);
            return;
        }
        try {
            gw.a a2 = gw.a(exc);
            m311a.a(a2.a.a());
            m311a.c(a2.f440a);
            m311a.b(str);
            gy.m309a().a(m311a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gw.a b = gw.b(exc);
            fc m311a = gy.m309a().m311a();
            m311a.a(b.a.a());
            m311a.c(b.f440a);
            m311a.b(str);
            gy.m309a().a(m311a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m315a() {
        fd m312a = gy.m309a().m312a();
        if (m312a != null) {
            return iq.a(m312a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gw.a d = gw.d(exc);
            fc m311a = gy.m309a().m311a();
            m311a.a(d.a.a());
            m311a.c(d.f440a);
            m311a.b(str);
            gy.m309a().a(m311a);
        } catch (NullPointerException e) {
        }
    }
}
