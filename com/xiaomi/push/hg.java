package com.xiaomi.push;

import com.xiaomi.push.hc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import java.util.Hashtable;
/* loaded from: classes6.dex */
public class hg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f14383a = fh.PING_RTT.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static Hashtable<Integer, Long> f14384a = new Hashtable<>();
    }

    public static void a() {
        a(0, f14383a);
    }

    public static void a(int i) {
        fi m355a = he.m353a().m355a();
        m355a.a(fh.CHANNEL_STATS_COUNTER.a());
        m355a.c(i);
        he.m353a().a(m355a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (hg.class) {
            if (i2 < 16777215) {
                a.f14384a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fi m355a = he.m353a().m355a();
        m355a.a((byte) i);
        m355a.a(i2);
        m355a.b(i3);
        m355a.b(str);
        m355a.c(i4);
        he.m353a().a(m355a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (hg.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f14384a.containsKey(Integer.valueOf(i4))) {
                fi m355a = he.m353a().m355a();
                m355a.a(i2);
                m355a.b((int) (currentTimeMillis - a.f14384a.get(Integer.valueOf(i4)).longValue()));
                m355a.b(str);
                if (i3 > -1) {
                    m355a.c(i3);
                }
                he.m353a().a(m355a);
                a.f14384a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, ap.b bVar) {
        new gz(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fi m355a = he.m353a().m355a();
        if (i > 0) {
            m355a.a(fh.GSLB_REQUEST_SUCCESS.a());
            m355a.b(str);
            m355a.b(i);
            he.m353a().a(m355a);
            return;
        }
        try {
            hc.a a2 = hc.a(exc);
            m355a.a(a2.f14377a.a());
            m355a.c(a2.f501a);
            m355a.b(str);
            he.m353a().a(m355a);
        } catch (NullPointerException e) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            hc.a b2 = hc.b(exc);
            fi m355a = he.m353a().m355a();
            m355a.a(b2.f14377a.a());
            m355a.c(b2.f501a);
            m355a.b(str);
            he.m353a().a(m355a);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m359a() {
        fj m356a = he.m353a().m356a();
        if (m356a != null) {
            return iw.a(m356a);
        }
        return null;
    }

    public static void b() {
        a(0, f14383a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            hc.a d = hc.d(exc);
            fi m355a = he.m353a().m355a();
            m355a.a(d.f14377a.a());
            m355a.c(d.f501a);
            m355a.b(str);
            he.m353a().a(m355a);
        } catch (NullPointerException e) {
        }
    }
}
