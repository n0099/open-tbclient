package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes18.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4719a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f4720a = new Hashtable<>();
    }

    public static void a() {
        a(0, f4719a);
    }

    public static void a(int i) {
        fi m329a = he.m327a().m329a();
        m329a.a(fh.CHANNEL_STATS_COUNTER.a());
        m329a.c(i);
        he.m327a().a(m329a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f4720a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m329a = he.m327a().m329a();
        m329a.a((byte) i);
        m329a.a(i2);
        m329a.b(i3);
        m329a.b(str);
        m329a.c(i4);
        he.m327a().a(m329a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f4720a.containsKey(Integer.valueOf(i4))) {
                fi m329a = he.m327a().m329a();
                m329a.a(i2);
                m329a.b((int) (currentTimeMillis - a.f4720a.get(Integer.valueOf(i4)).longValue()));
                m329a.b(str);
                if (i3 > -1) {
                    m329a.c(i3);
                }
                he.m327a().a(m329a);
                a.f4720a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m329a = he.m327a().m329a();
        if (i > 0) {
            m329a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m329a.b(str);
            m329a.b(i);
            he.m327a().a(m329a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m329a.a(a2.f4714a.a());
            m329a.c(a2.f423a);
            m329a.b(str);
            he.m327a().a(m329a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m329a = he.m327a().m329a();
            m329a.a(b.f4714a.a());
            m329a.c(b.f423a);
            m329a.b(str);
            he.m327a().a(m329a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m333a() {
        fj m330a = he.m327a().m330a();
        if (m330a != null) {
            return iw.a(m330a);
        }
        return null;
    }

    public static void b() {
        a(0, f4719a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m329a = he.m327a().m329a();
            m329a.a(d.f4714a.a());
            m329a.c(d.f423a);
            m329a.b(str);
            he.m327a().a(m329a);
        } catch (NullPointerException e) {
        }
    }
}
