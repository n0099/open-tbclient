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
        fi m333a = he.m331a().m333a();
        m333a.a(fh.CHANNEL_STATS_COUNTER.a());
        m333a.c(i);
        he.m331a().a(m333a);
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
        fi m333a = he.m331a().m333a();
        m333a.a((byte) i);
        m333a.a(i2);
        m333a.b(i3);
        m333a.b(str);
        m333a.c(i4);
        he.m331a().a(m333a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fi m333a = he.m331a().m333a();
                m333a.a(i2);
                m333a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m333a.b(str);
                if (i3 > -1) {
                    m333a.c(i3);
                }
                he.m331a().a(m333a);
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
        fi m333a = he.m331a().m333a();
        if (i > 0) {
            m333a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m333a.b(str);
            m333a.b(i);
            he.m331a().a(m333a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m333a.a(a2.a.a());
            m333a.c(a2.f421a);
            m333a.b(str);
            he.m331a().a(m333a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m333a = he.m331a().m333a();
            m333a.a(b.a.a());
            m333a.c(b.f421a);
            m333a.b(str);
            he.m331a().a(m333a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m337a() {
        fj m334a = he.m331a().m334a();
        if (m334a != null) {
            return iw.a(m334a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m333a = he.m331a().m333a();
            m333a.a(d.a.a());
            m333a.c(d.f421a);
            m333a.b(str);
            he.m331a().a(m333a);
        } catch (NullPointerException e) {
        }
    }
}
