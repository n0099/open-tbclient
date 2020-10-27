package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes12.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4947a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f4948a = new Hashtable<>();
    }

    public static void a() {
        a(0, f4947a);
    }

    public static void a(int i) {
        fi m336a = he.m334a().m336a();
        m336a.a(fh.CHANNEL_STATS_COUNTER.a());
        m336a.c(i);
        he.m334a().a(m336a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f4948a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m336a = he.m334a().m336a();
        m336a.a((byte) i);
        m336a.a(i2);
        m336a.b(i3);
        m336a.b(str);
        m336a.c(i4);
        he.m334a().a(m336a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f4948a.containsKey(Integer.valueOf(i4))) {
                fi m336a = he.m334a().m336a();
                m336a.a(i2);
                m336a.b((int) (currentTimeMillis - a.f4948a.get(Integer.valueOf(i4)).longValue()));
                m336a.b(str);
                if (i3 > -1) {
                    m336a.c(i3);
                }
                he.m334a().a(m336a);
                a.f4948a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m336a = he.m334a().m336a();
        if (i > 0) {
            m336a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m336a.b(str);
            m336a.b(i);
            he.m334a().a(m336a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m336a.a(a2.f4942a.a());
            m336a.c(a2.f420a);
            m336a.b(str);
            he.m334a().a(m336a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b = hc.b(exc);
            fi m336a = he.m334a().m336a();
            m336a.a(b.f4942a.a());
            m336a.c(b.f420a);
            m336a.b(str);
            he.m334a().a(m336a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m340a() {
        fj m337a = he.m334a().m337a();
        if (m337a != null) {
            return iw.a(m337a);
        }
        return null;
    }

    public static void b() {
        a(0, f4947a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m336a = he.m334a().m336a();
            m336a.a(d.f4942a.a());
            m336a.c(d.f420a);
            m336a.b(str);
            he.m334a().a(m336a);
        } catch (NullPointerException e) {
        }
    }
}
