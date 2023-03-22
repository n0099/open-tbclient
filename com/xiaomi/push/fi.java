package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class fi {
    public static final int a = ey.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    public static long f371a = 0;

    /* loaded from: classes8.dex */
    public static class a {
        public static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        if (f371a == 0 || SystemClock.elapsedRealtime() - f371a > 7200000) {
            f371a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i) {
        ez m396a = fg.m394a().m396a();
        m396a.a(ey.CHANNEL_STATS_COUNTER.a());
        m396a.c(i);
        fg.m394a().a(m396a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (fi.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ez m396a = fg.m394a().m396a();
        m396a.a((byte) i);
        m396a.a(i2);
        m396a.b(i3);
        m396a.b(str);
        m396a.c(i4);
        fg.m394a().a(m396a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (fi.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                ez m396a = fg.m394a().m396a();
                m396a.a(i2);
                m396a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m396a.b(str);
                if (i3 > -1) {
                    m396a.c(i3);
                }
                fg.m394a().a(m396a);
                a.a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        new fb(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        ez m396a = fg.m394a().m396a();
        if (fg.a() != null && fg.a().f363a != null) {
            m396a.c(bi.c(fg.a().f363a) ? 1 : 0);
        }
        if (i > 0) {
            m396a.a(ey.GSLB_REQUEST_SUCCESS.a());
            m396a.b(str);
            m396a.b(i);
            fg.m394a().a(m396a);
            return;
        }
        try {
            fe.a a2 = fe.a(exc);
            m396a.a(a2.a.a());
            m396a.c(a2.f360a);
            m396a.b(str);
            fg.m394a().a(m396a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            fe.a b = fe.b(exc);
            ez m396a = fg.m394a().m396a();
            m396a.a(b.a.a());
            m396a.c(b.f360a);
            m396a.b(str);
            if (fg.a() != null && fg.a().f363a != null) {
                m396a.c(bi.c(fg.a().f363a) ? 1 : 0);
            }
            fg.m394a().a(m396a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m400a() {
        fa m397a = fg.m394a().m397a();
        if (m397a != null) {
            return ir.a(m397a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            fe.a d = fe.d(exc);
            ez m396a = fg.m394a().m396a();
            m396a.a(d.a.a());
            m396a.c(d.f360a);
            m396a.b(str);
            if (fg.a() != null && fg.a().f363a != null) {
                m396a.c(bi.c(fg.a().f363a) ? 1 : 0);
            }
            fg.m394a().a(m396a);
        } catch (NullPointerException unused) {
        }
    }
}
