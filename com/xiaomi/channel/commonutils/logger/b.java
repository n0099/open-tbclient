package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f13772a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f85a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f87a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Integer, String> f13773b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f86a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f88a = new AtomicInteger(1);

    public static int a() {
        return f13772a;
    }

    public static Integer a(String str) {
        if (f13772a <= 1) {
            Integer valueOf = Integer.valueOf(f88a.incrementAndGet());
            f87a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f13773b.put(valueOf, str);
            f85a.log(str + " starts");
            return valueOf;
        }
        return f86a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f13772a = i;
    }

    public static void a(int i, String str) {
        if (i >= f13772a) {
            f85a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f13772a) {
            f85a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f13772a) {
            f85a.log("", th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f85a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f13772a > 1 || !f87a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f87a.remove(num).longValue();
        f85a.log(f13773b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m79a(String str) {
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
