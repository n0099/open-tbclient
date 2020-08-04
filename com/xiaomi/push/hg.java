package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes9.dex */
public class hg {
    private static final int a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        fi m331a = he.m329a().m331a();
        m331a.a(fh.CHANNEL_STATS_COUNTER.a());
        m331a.c(i);
        he.m329a().a(m331a);
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
        fi m331a = he.m329a().m331a();
        m331a.a((byte) i);
        m331a.a(i2);
        m331a.b(i3);
        m331a.b(str);
        m331a.c(i4);
        he.m329a().a(m331a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fi m331a = he.m329a().m331a();
                m331a.a(i2);
                m331a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m331a.b(str);
                if (i3 > -1) {
                    m331a.c(i3);
                }
                he.m329a().a(m331a);
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
        fi m331a = he.m329a().m331a();
        if (i > 0) {
            m331a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m331a.b(str);
            m331a.b(i);
            he.m329a().a(m331a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m331a.a(a2.a.a());
            m331a.c(a2.f427a);
            m331a.b(str);
            he.m329a().a(m331a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m331a = he.m329a().m331a();
            m331a.a(b.a.a());
            m331a.c(b.f427a);
            m331a.b(str);
            he.m329a().a(m331a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m335a() {
        fj m332a = he.m329a().m332a();
        if (m332a != null) {
            return iw.a(m332a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m331a = he.m329a().m331a();
            m331a.a(d.a.a());
            m331a.c(d.f427a);
            m331a.b(str);
            he.m329a().a(m331a);
        } catch (NullPointerException e) {
        }
    }
}
