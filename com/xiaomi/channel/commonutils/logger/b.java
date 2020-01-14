package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class b {
    private static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f8a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f10a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f9a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f11a = new AtomicInteger(1);

    public static int a() {
        return a;
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f11a.incrementAndGet());
            f10a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            f8a.log(str + " starts");
            return valueOf;
        }
        return f9a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f8a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f8a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f8a.log("", th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f8a = loggerInterface;
    }

    public static void a(Integer num) {
        if (a > 1 || !f10a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f10a.remove(num).longValue();
        f8a.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m42a(String str) {
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
