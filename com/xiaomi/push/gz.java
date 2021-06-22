package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class gz {

    /* renamed from: a  reason: collision with root package name */
    public static final int f41485a = ew.PING_RTT.a();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Hashtable<Integer, Long> f41486a = new Hashtable<>();
    }

    public static void a() {
        a(0, f41485a);
    }

    public static void a(int i2) {
        ex m351a = gx.m349a().m351a();
        m351a.a(ew.CHANNEL_STATS_COUNTER.a());
        m351a.c(i2);
        gx.m349a().a(m351a);
    }

    public static synchronized void a(int i2, int i3) {
        synchronized (gz.class) {
            if (i3 < 16777215) {
                a.f41486a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        ex m351a = gx.m349a().m351a();
        m351a.a((byte) i2);
        m351a.a(i3);
        m351a.b(i4);
        m351a.b(str);
        m351a.c(i5);
        gx.m349a().a(m351a);
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        synchronized (gz.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = (i2 << 24) | i3;
            if (a.f41486a.containsKey(Integer.valueOf(i5))) {
                ex m351a = gx.m349a().m351a();
                m351a.a(i3);
                m351a.b((int) (currentTimeMillis - a.f41486a.get(Integer.valueOf(i5)).longValue()));
                m351a.b(str);
                if (i4 > -1) {
                    m351a.c(i4);
                }
                gx.m349a().a(m351a);
                a.f41486a.remove(Integer.valueOf(i3));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        new gs(xMPushService, bVar).a();
    }

    public static void a(String str, int i2, Exception exc) {
        ex m351a = gx.m349a().m351a();
        if (i2 > 0) {
            m351a.a(ew.GSLB_REQUEST_SUCCESS.a());
            m351a.b(str);
            m351a.b(i2);
            gx.m349a().a(m351a);
            return;
        }
        try {
            gv.a a2 = gv.a(exc);
            m351a.a(a2.f41475a.a());
            m351a.c(a2.f452a);
            m351a.b(str);
            gx.m349a().a(m351a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gv.a b2 = gv.b(exc);
            ex m351a = gx.m349a().m351a();
            m351a.a(b2.f41475a.a());
            m351a.c(b2.f452a);
            m351a.b(str);
            gx.m349a().a(m351a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m355a() {
        ey m352a = gx.m349a().m352a();
        if (m352a != null) {
            return ip.a(m352a);
        }
        return null;
    }

    public static void b() {
        a(0, f41485a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gv.a d2 = gv.d(exc);
            ex m351a = gx.m349a().m351a();
            m351a.a(d2.f41475a.a());
            m351a.c(d2.f452a);
            m351a.b(str);
            gx.m349a().a(m351a);
        } catch (NullPointerException unused) {
        }
    }
}
