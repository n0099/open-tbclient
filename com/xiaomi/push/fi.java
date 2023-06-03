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
    public static long f371a = 0;

    /* loaded from: classes10.dex */
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
        ez m472a = fg.m470a().m472a();
        m472a.a(ey.CHANNEL_STATS_COUNTER.a());
        m472a.c(i);
        fg.m470a().a(m472a);
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
        ez m472a = fg.m470a().m472a();
        m472a.a((byte) i);
        m472a.a(i2);
        m472a.b(i3);
        m472a.b(str);
        m472a.c(i4);
        fg.m470a().a(m472a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (fi.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                ez m472a = fg.m470a().m472a();
                m472a.a(i2);
                m472a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m472a.b(str);
                if (i3 > -1) {
                    m472a.c(i3);
                }
                fg.m470a().a(m472a);
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
        ez m472a = fg.m470a().m472a();
        if (fg.a() != null && fg.a().f363a != null) {
            m472a.c(bi.c(fg.a().f363a) ? 1 : 0);
        }
        if (i > 0) {
            m472a.a(ey.GSLB_REQUEST_SUCCESS.a());
            m472a.b(str);
            m472a.b(i);
            fg.m470a().a(m472a);
            return;
        }
        try {
            fe.a a2 = fe.a(exc);
            m472a.a(a2.a.a());
            m472a.c(a2.f360a);
            m472a.b(str);
            fg.m470a().a(m472a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            fe.a b = fe.b(exc);
            ez m472a = fg.m470a().m472a();
            m472a.a(b.a.a());
            m472a.c(b.f360a);
            m472a.b(str);
            if (fg.a() != null && fg.a().f363a != null) {
                m472a.c(bi.c(fg.a().f363a) ? 1 : 0);
            }
            fg.m470a().a(m472a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m476a() {
        fa m473a = fg.m470a().m473a();
        if (m473a != null) {
            return ir.a(m473a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            fe.a d = fe.d(exc);
            ez m472a = fg.m470a().m472a();
            m472a.a(d.a.a());
            m472a.c(d.f360a);
            m472a.b(str);
            if (fg.a() != null && fg.a().f363a != null) {
                m472a.c(bi.c(fg.a().f363a) ? 1 : 0);
            }
            fg.m470a().a(m472a);
        } catch (NullPointerException unused) {
        }
    }
}
