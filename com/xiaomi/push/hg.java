package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes5.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8412a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f8413a = new Hashtable<>();
    }

    public static void a() {
        a(0, f8412a);
    }

    public static void a(int i) {
        fi m340a = he.m338a().m340a();
        m340a.a(fh.CHANNEL_STATS_COUNTER.a());
        m340a.c(i);
        he.m338a().a(m340a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f8413a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m340a = he.m338a().m340a();
        m340a.a((byte) i);
        m340a.a(i2);
        m340a.b(i3);
        m340a.b(str);
        m340a.c(i4);
        he.m338a().a(m340a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f8413a.containsKey(Integer.valueOf(i4))) {
                fi m340a = he.m338a().m340a();
                m340a.a(i2);
                m340a.b((int) (currentTimeMillis - a.f8413a.get(Integer.valueOf(i4)).longValue()));
                m340a.b(str);
                if (i3 > -1) {
                    m340a.c(i3);
                }
                he.m338a().a(m340a);
                a.f8413a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m340a = he.m338a().m340a();
        if (i > 0) {
            m340a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m340a.b(str);
            m340a.b(i);
            he.m338a().a(m340a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m340a.a(a2.f8407a.a());
            m340a.c(a2.f422a);
            m340a.b(str);
            he.m338a().a(m340a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m340a = he.m338a().m340a();
            m340a.a(b.f8407a.a());
            m340a.c(b.f422a);
            m340a.b(str);
            he.m338a().a(m340a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m344a() {
        fj m341a = he.m338a().m341a();
        if (m341a != null) {
            return iw.a(m341a);
        }
        return null;
    }

    public static void b() {
        a(0, f8412a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m340a = he.m338a().m340a();
            m340a.a(d.f8407a.a());
            m340a.c(d.f422a);
            m340a.b(str);
            he.m338a().a(m340a);
        } catch (NullPointerException e) {
        }
    }
}
