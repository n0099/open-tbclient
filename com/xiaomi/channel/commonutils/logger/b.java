package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f14070a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f86a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f88a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Integer, String> f14071b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f87a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f89a = new AtomicInteger(1);

    public static int a() {
        return f14070a;
    }

    public static Integer a(String str) {
        if (f14070a <= 1) {
            Integer valueOf = Integer.valueOf(f89a.incrementAndGet());
            f88a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f14071b.put(valueOf, str);
            f86a.log(str + " starts");
            return valueOf;
        }
        return f87a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f14070a = i;
    }

    public static void a(int i, String str) {
        if (i >= f14070a) {
            f86a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f14070a) {
            f86a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f14070a) {
            f86a.log("", th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f86a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f14070a > 1 || !f88a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f88a.remove(num).longValue();
        f86a.log(f14071b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m84a(String str) {
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
