package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f8182a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f6a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f8a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f7a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f9a = new AtomicInteger(1);

    public static int a() {
        return f8182a;
    }

    public static Integer a(String str) {
        if (f8182a <= 1) {
            Integer valueOf = Integer.valueOf(f9a.incrementAndGet());
            f8a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            f6a.log(str + " starts");
            return valueOf;
        }
        return f7a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f8182a = i;
    }

    public static void a(int i, String str) {
        if (i >= f8182a) {
            f6a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f8182a) {
            f6a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f8182a) {
            f6a.log("", th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f6a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f8182a > 1 || !f8a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f8a.remove(num).longValue();
        f6a.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m58a(String str) {
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
