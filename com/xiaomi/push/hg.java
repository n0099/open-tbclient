package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes6.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f14086a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f14087a = new Hashtable<>();
    }

    public static void a() {
        a(0, f14086a);
    }

    public static void a(int i) {
        fi m361a = he.m359a().m361a();
        m361a.a(fh.CHANNEL_STATS_COUNTER.a());
        m361a.c(i);
        he.m359a().a(m361a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f14087a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m361a = he.m359a().m361a();
        m361a.a((byte) i);
        m361a.a(i2);
        m361a.b(i3);
        m361a.b(str);
        m361a.c(i4);
        he.m359a().a(m361a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f14087a.containsKey(Integer.valueOf(i4))) {
                fi m361a = he.m359a().m361a();
                m361a.a(i2);
                m361a.b((int) (currentTimeMillis - a.f14087a.get(Integer.valueOf(i4)).longValue()));
                m361a.b(str);
                if (i3 > -1) {
                    m361a.c(i3);
                }
                he.m359a().a(m361a);
                a.f14087a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m361a = he.m359a().m361a();
        if (i > 0) {
            m361a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m361a.b(str);
            m361a.b(i);
            he.m359a().a(m361a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m361a.a(a2.f14080a.a());
            m361a.c(a2.f501a);
            m361a.b(str);
            he.m359a().a(m361a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b2 = hc.b(exc);
            fi m361a = he.m359a().m361a();
            m361a.a(b2.f14080a.a());
            m361a.c(b2.f501a);
            m361a.b(str);
            he.m359a().a(m361a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m365a() {
        fj m362a = he.m359a().m362a();
        if (m362a != null) {
            return iw.a(m362a);
        }
        return null;
    }

    public static void b() {
        a(0, f14086a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m361a = he.m359a().m361a();
            m361a.a(d.f14080a.a());
            m361a.c(d.f501a);
            m361a.b(str);
            he.m359a().a(m361a);
        } catch (NullPointerException e) {
        }
    }
}
