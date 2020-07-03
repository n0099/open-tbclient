package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class hg {
    private static final int a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        fi m330a = he.m328a().m330a();
        m330a.a(fh.CHANNEL_STATS_COUNTER.a());
        m330a.c(i);
        he.m328a().a(m330a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m330a = he.m328a().m330a();
        m330a.a((byte) i);
        m330a.a(i2);
        m330a.b(i3);
        m330a.b(str);
        m330a.c(i4);
        he.m328a().a(m330a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fi m330a = he.m328a().m330a();
                m330a.a(i2);
                m330a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m330a.b(str);
                if (i3 > -1) {
                    m330a.c(i3);
                }
                he.m328a().a(m330a);
                a.a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m330a = he.m328a().m330a();
        if (i > 0) {
            m330a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m330a.b(str);
            m330a.b(i);
            he.m328a().a(m330a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m330a.a(a2.a.a());
            m330a.c(a2.f427a);
            m330a.b(str);
            he.m328a().a(m330a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m330a = he.m328a().m330a();
            m330a.a(b.a.a());
            m330a.c(b.f427a);
            m330a.b(str);
            he.m328a().a(m330a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m334a() {
        fj m331a = he.m328a().m331a();
        if (m331a != null) {
            return iw.a(m331a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m330a = he.m328a().m330a();
            m330a.a(d.a.a());
            m330a.c(d.f427a);
            m330a.b(str);
            he.m328a().a(m330a);
        } catch (NullPointerException e) {
        }
    }
}
