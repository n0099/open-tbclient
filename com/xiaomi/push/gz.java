package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class gz {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40909a = ew.PING_RTT.a();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Hashtable<Integer, Long> f40910a = new Hashtable<>();
    }

    public static void a() {
        a(0, f40909a);
    }

    public static void a(int i) {
        ex m350a = gx.m348a().m350a();
        m350a.a(ew.CHANNEL_STATS_COUNTER.a());
        m350a.c(i);
        gx.m348a().a(m350a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (gz.class) {
            if (i2 < 16777215) {
                a.f40910a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ex m350a = gx.m348a().m350a();
        m350a.a((byte) i);
        m350a.a(i2);
        m350a.b(i3);
        m350a.b(str);
        m350a.c(i4);
        gx.m348a().a(m350a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (gz.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f40910a.containsKey(Integer.valueOf(i4))) {
                ex m350a = gx.m348a().m350a();
                m350a.a(i2);
                m350a.b((int) (currentTimeMillis - a.f40910a.get(Integer.valueOf(i4)).longValue()));
                m350a.b(str);
                if (i3 > -1) {
                    m350a.c(i3);
                }
                gx.m348a().a(m350a);
                a.f40910a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        new gs(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        ex m350a = gx.m348a().m350a();
        if (i > 0) {
            m350a.a(ew.GSLB_REQUEST_SUCCESS.a());
            m350a.b(str);
            m350a.b(i);
            gx.m348a().a(m350a);
            return;
        }
        try {
            gv.a a2 = gv.a(exc);
            m350a.a(a2.f40899a.a());
            m350a.c(a2.f452a);
            m350a.b(str);
            gx.m348a().a(m350a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gv.a b2 = gv.b(exc);
            ex m350a = gx.m348a().m350a();
            m350a.a(b2.f40899a.a());
            m350a.c(b2.f452a);
            m350a.b(str);
            gx.m348a().a(m350a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m354a() {
        ey m351a = gx.m348a().m351a();
        if (m351a != null) {
            return ip.a(m351a);
        }
        return null;
    }

    public static void b() {
        a(0, f40909a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gv.a d2 = gv.d(exc);
            ex m350a = gx.m348a().m350a();
            m350a.a(d2.f40899a.a());
            m350a.c(d2.f452a);
            m350a.b(str);
            gx.m348a().a(m350a);
        } catch (NullPointerException unused) {
        }
    }
}
