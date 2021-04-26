package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class gz {

    /* renamed from: a  reason: collision with root package name */
    public static final int f38529a = ew.PING_RTT.a();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Hashtable<Integer, Long> f38530a = new Hashtable<>();
    }

    public static void a() {
        a(0, f38529a);
    }

    public static void a(int i2) {
        ex m353a = gx.m351a().m353a();
        m353a.a(ew.CHANNEL_STATS_COUNTER.a());
        m353a.c(i2);
        gx.m351a().a(m353a);
    }

    public static synchronized void a(int i2, int i3) {
        synchronized (gz.class) {
            if (i3 < 16777215) {
                a.f38530a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        ex m353a = gx.m351a().m353a();
        m353a.a((byte) i2);
        m353a.a(i3);
        m353a.b(i4);
        m353a.b(str);
        m353a.c(i5);
        gx.m351a().a(m353a);
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        synchronized (gz.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = (i2 << 24) | i3;
            if (a.f38530a.containsKey(Integer.valueOf(i5))) {
                ex m353a = gx.m351a().m353a();
                m353a.a(i3);
                m353a.b((int) (currentTimeMillis - a.f38530a.get(Integer.valueOf(i5)).longValue()));
                m353a.b(str);
                if (i4 > -1) {
                    m353a.c(i4);
                }
                gx.m351a().a(m353a);
                a.f38530a.remove(Integer.valueOf(i3));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        new gs(xMPushService, bVar).a();
    }

    public static void a(String str, int i2, Exception exc) {
        ex m353a = gx.m351a().m353a();
        if (i2 > 0) {
            m353a.a(ew.GSLB_REQUEST_SUCCESS.a());
            m353a.b(str);
            m353a.b(i2);
            gx.m351a().a(m353a);
            return;
        }
        try {
            gv.a a2 = gv.a(exc);
            m353a.a(a2.f38519a.a());
            m353a.c(a2.f452a);
            m353a.b(str);
            gx.m351a().a(m353a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gv.a b2 = gv.b(exc);
            ex m353a = gx.m351a().m353a();
            m353a.a(b2.f38519a.a());
            m353a.c(b2.f452a);
            m353a.b(str);
            gx.m351a().a(m353a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m357a() {
        ey m354a = gx.m351a().m354a();
        if (m354a != null) {
            return ip.a(m354a);
        }
        return null;
    }

    public static void b() {
        a(0, f38529a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gv.a d2 = gv.d(exc);
            ex m353a = gx.m351a().m353a();
            m353a.a(d2.f38519a.a());
            m353a.c(d2.f452a);
            m353a.b(str);
            gx.m351a().a(m353a);
        } catch (NullPointerException unused) {
        }
    }
}
