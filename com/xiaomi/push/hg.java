package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes12.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4949a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f4950a = new Hashtable<>();
    }

    public static void a() {
        a(0, f4949a);
    }

    public static void a(int i) {
        fi m337a = he.m335a().m337a();
        m337a.a(fh.CHANNEL_STATS_COUNTER.a());
        m337a.c(i);
        he.m335a().a(m337a);
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
        fi m337a = he.m335a().m337a();
        m337a.a((byte) i);
        m337a.a(i2);
        m337a.b(i3);
        m337a.b(str);
        m337a.c(i4);
        he.m335a().a(m337a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f4950a.containsKey(Integer.valueOf(i4))) {
                fi m337a = he.m335a().m337a();
                m337a.a(i2);
                m337a.b((int) (currentTimeMillis - a.f4950a.get(Integer.valueOf(i4)).longValue()));
                m337a.b(str);
                if (i3 > -1) {
                    m337a.c(i3);
                }
                he.m335a().a(m337a);
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
        fi m337a = he.m335a().m337a();
        if (i > 0) {
            m337a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m337a.b(str);
            m337a.b(i);
            he.m335a().a(m337a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m337a.a(a2.f4944a.a());
            m337a.c(a2.f423a);
            m337a.b(str);
            he.m335a().a(m337a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m337a = he.m335a().m337a();
            m337a.a(b.f4944a.a());
            m337a.c(b.f423a);
            m337a.b(str);
            he.m335a().a(m337a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m341a() {
        fj m338a = he.m335a().m338a();
        if (m338a != null) {
            return iw.a(m338a);
        }
        return null;
    }

    public static void b() {
        a(0, f4949a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m337a = he.m335a().m337a();
            m337a.a(d.f4944a.a());
            m337a.c(d.f423a);
            m337a.b(str);
            he.m335a().a(m337a);
        } catch (NullPointerException e) {
        }
    }
}
