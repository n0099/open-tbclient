package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class gz {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40620a = ew.PING_RTT.a();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Hashtable<Integer, Long> f40621a = new Hashtable<>();
    }

    public static void a() {
        a(0, f40620a);
    }

    public static void a(int i) {
        ex m346a = gx.m344a().m346a();
        m346a.a(ew.CHANNEL_STATS_COUNTER.a());
        m346a.c(i);
        gx.m344a().a(m346a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (gz.class) {
            if (i2 < 16777215) {
                a.f40621a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ex m346a = gx.m344a().m346a();
        m346a.a((byte) i);
        m346a.a(i2);
        m346a.b(i3);
        m346a.b(str);
        m346a.c(i4);
        gx.m344a().a(m346a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (gz.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f40621a.containsKey(Integer.valueOf(i4))) {
                ex m346a = gx.m344a().m346a();
                m346a.a(i2);
                m346a.b((int) (currentTimeMillis - a.f40621a.get(Integer.valueOf(i4)).longValue()));
                m346a.b(str);
                if (i3 > -1) {
                    m346a.c(i3);
                }
                gx.m344a().a(m346a);
                a.f40621a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        new gs(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        ex m346a = gx.m344a().m346a();
        if (i > 0) {
            m346a.a(ew.GSLB_REQUEST_SUCCESS.a());
            m346a.b(str);
            m346a.b(i);
            gx.m344a().a(m346a);
            return;
        }
        try {
            gv.a a2 = gv.a(exc);
            m346a.a(a2.f40610a.a());
            m346a.c(a2.f452a);
            m346a.b(str);
            gx.m344a().a(m346a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gv.a b2 = gv.b(exc);
            ex m346a = gx.m344a().m346a();
            m346a.a(b2.f40610a.a());
            m346a.c(b2.f452a);
            m346a.b(str);
            gx.m344a().a(m346a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m350a() {
        ey m347a = gx.m344a().m347a();
        if (m347a != null) {
            return ip.a(m347a);
        }
        return null;
    }

    public static void b() {
        a(0, f40620a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gv.a d2 = gv.d(exc);
            ex m346a = gx.m344a().m346a();
            m346a.a(d2.f40610a.a());
            m346a.c(d2.f452a);
            m346a.b(str);
            gx.m344a().a(m346a);
        } catch (NullPointerException unused) {
        }
    }
}
