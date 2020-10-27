package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f4717a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f4a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f6a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f5a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f7a = new AtomicInteger(1);

    public static int a() {
        return f4717a;
    }

    public static Integer a(String str) {
        if (f4717a <= 1) {
            Integer valueOf = Integer.valueOf(f7a.incrementAndGet());
            f6a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            f4a.log(str + " starts");
            return valueOf;
        }
        return f5a;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f4717a = i;
    }

    public static void a(int i, String str) {
        if (i >= f4717a) {
            f4a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f4717a) {
            f4a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f4717a) {
            f4a.log("", th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f4a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f4717a > 1 || !f6a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f6a.remove(num).longValue();
        f4a.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m54a(String str) {
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
