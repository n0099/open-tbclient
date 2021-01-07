package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes6.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f14384a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f14385a = new Hashtable<>();
    }

    public static void a() {
        a(0, f14384a);
    }

    public static void a(int i) {
        fi m366a = he.m364a().m366a();
        m366a.a(fh.CHANNEL_STATS_COUNTER.a());
        m366a.c(i);
        he.m364a().a(m366a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f14385a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m366a = he.m364a().m366a();
        m366a.a((byte) i);
        m366a.a(i2);
        m366a.b(i3);
        m366a.b(str);
        m366a.c(i4);
        he.m364a().a(m366a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f14385a.containsKey(Integer.valueOf(i4))) {
                fi m366a = he.m364a().m366a();
                m366a.a(i2);
                m366a.b((int) (currentTimeMillis - a.f14385a.get(Integer.valueOf(i4)).longValue()));
                m366a.b(str);
                if (i3 > -1) {
                    m366a.c(i3);
                }
                he.m364a().a(m366a);
                a.f14385a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m366a = he.m364a().m366a();
        if (i > 0) {
            m366a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m366a.b(str);
            m366a.b(i);
            he.m364a().a(m366a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m366a.a(a2.f14378a.a());
            m366a.c(a2.f502a);
            m366a.b(str);
            he.m364a().a(m366a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b2 = hc.b(exc);
            fi m366a = he.m364a().m366a();
            m366a.a(b2.f14378a.a());
            m366a.c(b2.f502a);
            m366a.b(str);
            he.m364a().a(m366a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m370a() {
        fj m367a = he.m364a().m367a();
        if (m367a != null) {
            return iw.a(m367a);
        }
        return null;
    }

    public static void b() {
        a(0, f14384a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m366a = he.m364a().m366a();
            m366a.a(d.f14378a.a());
            m366a.c(d.f502a);
            m366a.b(str);
            he.m364a().a(m366a);
        } catch (NullPointerException e) {
        }
    }
}
