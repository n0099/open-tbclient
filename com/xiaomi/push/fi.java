package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;
/* loaded from: classes10.dex */
public class fi {
    public static final int a = ey.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    public static long f372a = 0;

    /* loaded from: classes10.dex */
    public static class a {
        public static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        if (f372a == 0 || SystemClock.elapsedRealtime() - f372a > 7200000) {
            f372a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i) {
        ez m477a = fg.m475a().m477a();
        m477a.a(ey.CHANNEL_STATS_COUNTER.a());
        m477a.c(i);
        fg.m475a().a(m477a);
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
        ez m477a = fg.m475a().m477a();
        m477a.a((byte) i);
        m477a.a(i2);
        m477a.b(i3);
        m477a.b(str);
        m477a.c(i4);
        fg.m475a().a(m477a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (fi.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                ez m477a = fg.m475a().m477a();
                m477a.a(i2);
                m477a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m477a.b(str);
                if (i3 > -1) {
                    m477a.c(i3);
                }
                fg.m475a().a(m477a);
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
        ez m477a = fg.m475a().m477a();
        if (fg.a() != null && fg.a().f364a != null) {
            m477a.c(bi.c(fg.a().f364a) ? 1 : 0);
        }
        if (i > 0) {
            m477a.a(ey.GSLB_REQUEST_SUCCESS.a());
            m477a.b(str);
            m477a.b(i);
            fg.m475a().a(m477a);
            return;
        }
        try {
            fe.a a2 = fe.a(exc);
            m477a.a(a2.a.a());
            m477a.c(a2.f361a);
            m477a.b(str);
            fg.m475a().a(m477a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            fe.a b = fe.b(exc);
            ez m477a = fg.m475a().m477a();
            m477a.a(b.a.a());
            m477a.c(b.f361a);
            m477a.b(str);
            if (fg.a() != null && fg.a().f364a != null) {
                m477a.c(bi.c(fg.a().f364a) ? 1 : 0);
            }
            fg.m475a().a(m477a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m481a() {
        fa m478a = fg.m475a().m478a();
        if (m478a != null) {
            return ir.a(m478a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            fe.a d = fe.d(exc);
            ez m477a = fg.m475a().m477a();
            m477a.a(d.a.a());
            m477a.c(d.f361a);
            m477a.b(str);
            if (fg.a() != null && fg.a().f364a != null) {
                m477a.c(bi.c(fg.a().f364a) ? 1 : 0);
            }
            fg.m475a().a(m477a);
        } catch (NullPointerException unused) {
        }
    }
}
