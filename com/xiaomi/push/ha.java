package com.xiaomi.push;

import com.xiaomi.push.gw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class ha {
    private static final int a = fb.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        fc m308a = gy.m306a().m308a();
        m308a.a(fb.CHANNEL_STATS_COUNTER.a());
        m308a.c(i);
        gy.m306a().a(m308a);
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
        fc m308a = gy.m306a().m308a();
        m308a.a((byte) i);
        m308a.a(i2);
        m308a.b(i3);
        m308a.b(str);
        m308a.c(i4);
        gy.m306a().a(m308a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (ha.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fc m308a = gy.m306a().m308a();
                m308a.a(i2);
                m308a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m308a.b(str);
                if (i3 > -1) {
                    m308a.c(i3);
                }
                gy.m306a().a(m308a);
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
        fc m308a = gy.m306a().m308a();
        if (i > 0) {
            m308a.a(fb.GSLB_REQUEST_SUCCESS.a());
            m308a.b(str);
            m308a.b(i);
            gy.m306a().a(m308a);
            return;
        }
        try {
            gw.a a2 = gw.a(exc);
            m308a.a(a2.a.a());
            m308a.c(a2.f435a);
            m308a.b(str);
            gy.m306a().a(m308a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gw.a b = gw.b(exc);
            fc m308a = gy.m306a().m308a();
            m308a.a(b.a.a());
            m308a.c(b.f435a);
            m308a.b(str);
            gy.m306a().a(m308a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m312a() {
        fd m309a = gy.m306a().m309a();
        if (m309a != null) {
            return iq.a(m309a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gw.a d = gw.d(exc);
            fc m308a = gy.m306a().m308a();
            m308a.a(d.a.a());
            m308a.c(d.f435a);
            m308a.b(str);
            gy.m306a().a(m308a);
        } catch (NullPointerException e) {
        }
    }
}
