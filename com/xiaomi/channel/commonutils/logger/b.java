package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public abstract class b {
    private static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f11a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f13a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f12a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f14a = new AtomicInteger(1);

    public static int a() {
        return a;
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f14a.incrementAndGet());
            f13a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            f11a.log(str + " starts");
            return valueOf;
        }
        return f12a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f11a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f11a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f11a.log("", th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f11a = loggerInterface;
    }

    public static void a(Integer num) {
        if (a > 1 || !f13a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f13a.remove(num).longValue();
        f11a.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m48a(String str) {
        a(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void a(String str, Throwable th) {
        a(4, str, th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    public static void b(String str) {
        a(0, str);
    }

    public static void c(String str) {
        a(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void d(String str) {
        a(4, str);
    }
}
