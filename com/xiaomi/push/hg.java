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
        fi m334a = he.m332a().m334a();
        m334a.a(fh.CHANNEL_STATS_COUNTER.a());
        m334a.c(i);
        he.m332a().a(m334a);
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
        fi m334a = he.m332a().m334a();
        m334a.a((byte) i);
        m334a.a(i2);
        m334a.b(i3);
        m334a.b(str);
        m334a.c(i4);
        he.m332a().a(m334a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fi m334a = he.m332a().m334a();
                m334a.a(i2);
                m334a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m334a.b(str);
                if (i3 > -1) {
                    m334a.c(i3);
                }
                he.m332a().a(m334a);
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
        fi m334a = he.m332a().m334a();
        if (i > 0) {
            m334a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m334a.b(str);
            m334a.b(i);
            he.m332a().a(m334a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m334a.a(a2.a.a());
            m334a.c(a2.f421a);
            m334a.b(str);
            he.m332a().a(m334a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m334a = he.m332a().m334a();
            m334a.a(b.a.a());
            m334a.c(b.f421a);
            m334a.b(str);
            he.m332a().a(m334a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m338a() {
        fj m335a = he.m332a().m335a();
        if (m335a != null) {
            return iw.a(m335a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m334a = he.m332a().m334a();
            m334a.a(d.a.a());
            m334a.c(d.f421a);
            m334a.b(str);
            he.m332a().a(m334a);
        } catch (NullPointerException e) {
        }
    }
}
