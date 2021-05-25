package com.xiaomi.push;

import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class gz {

    /* renamed from: a  reason: collision with root package name */
    public static final int f37703a = ew.PING_RTT.a();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Hashtable<Integer, Long> f37704a = new Hashtable<>();
    }

    public static void a() {
        a(0, f37703a);
    }

    public static void a(int i2) {
        ex m352a = gx.m350a().m352a();
        m352a.a(ew.CHANNEL_STATS_COUNTER.a());
        m352a.c(i2);
        gx.m350a().a(m352a);
    }

    public static synchronized void a(int i2, int i3) {
        synchronized (gz.class) {
            if (i3 < 16777215) {
                a.f37704a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        ex m352a = gx.m350a().m352a();
        m352a.a((byte) i2);
        m352a.a(i3);
        m352a.b(i4);
        m352a.b(str);
        m352a.c(i5);
        gx.m350a().a(m352a);
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        synchronized (gz.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = (i2 << 24) | i3;
            if (a.f37704a.containsKey(Integer.valueOf(i5))) {
                ex m352a = gx.m350a().m352a();
                m352a.a(i3);
                m352a.b((int) (currentTimeMillis - a.f37704a.get(Integer.valueOf(i5)).longValue()));
                m352a.b(str);
                if (i4 > -1) {
                    m352a.c(i4);
                }
                gx.m350a().a(m352a);
                a.f37704a.remove(Integer.valueOf(i3));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        new gs(xMPushService, bVar).a();
    }

    public static void a(String str, int i2, Exception exc) {
        ex m352a = gx.m350a().m352a();
        if (i2 > 0) {
            m352a.a(ew.GSLB_REQUEST_SUCCESS.a());
            m352a.b(str);
            m352a.b(i2);
            gx.m350a().a(m352a);
            return;
        }
        try {
            gv.a a2 = gv.a(exc);
            m352a.a(a2.f37693a.a());
            m352a.c(a2.f452a);
            m352a.b(str);
            gx.m350a().a(m352a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gv.a b2 = gv.b(exc);
            ex m352a = gx.m350a().m352a();
            m352a.a(b2.f37693a.a());
            m352a.c(b2.f452a);
            m352a.b(str);
            gx.m350a().a(m352a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m356a() {
        ey m353a = gx.m350a().m353a();
        if (m353a != null) {
            return ip.a(m353a);
        }
        return null;
    }

    public static void b() {
        a(0, f37703a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gv.a d2 = gv.d(exc);
            ex m352a = gx.m350a().m352a();
            m352a.a(d2.f37693a.a());
            m352a.c(d2.f452a);
            m352a.b(str);
            gx.m350a().a(m352a);
        } catch (NullPointerException unused) {
        }
    }
}
