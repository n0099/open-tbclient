package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes18.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4949a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f4950a = new Hashtable<>();
    }

    public static void a() {
        a(0, f4949a);
    }

    public static void a(int i) {
        fi m339a = he.m337a().m339a();
        m339a.a(fh.CHANNEL_STATS_COUNTER.a());
        m339a.c(i);
        he.m337a().a(m339a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f4950a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m339a = he.m337a().m339a();
        m339a.a((byte) i);
        m339a.a(i2);
        m339a.b(i3);
        m339a.b(str);
        m339a.c(i4);
        he.m337a().a(m339a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f4950a.containsKey(Integer.valueOf(i4))) {
                fi m339a = he.m337a().m339a();
                m339a.a(i2);
                m339a.b((int) (currentTimeMillis - a.f4950a.get(Integer.valueOf(i4)).longValue()));
                m339a.b(str);
                if (i3 > -1) {
                    m339a.c(i3);
                }
                he.m337a().a(m339a);
                a.f4950a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m339a = he.m337a().m339a();
        if (i > 0) {
            m339a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m339a.b(str);
            m339a.b(i);
            he.m337a().a(m339a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m339a.a(a2.f4944a.a());
            m339a.c(a2.f425a);
            m339a.b(str);
            he.m337a().a(m339a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m339a = he.m337a().m339a();
            m339a.a(b.f4944a.a());
            m339a.c(b.f425a);
            m339a.b(str);
            he.m337a().a(m339a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m343a() {
        fj m340a = he.m337a().m340a();
        if (m340a != null) {
            return iw.a(m340a);
        }
        return null;
    }

    public static void b() {
        a(0, f4949a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m339a = he.m337a().m339a();
            m339a.a(d.f4944a.a());
            m339a.c(d.f425a);
            m339a.b(str);
            he.m337a().a(m339a);
        } catch (NullPointerException e) {
        }
    }
}
