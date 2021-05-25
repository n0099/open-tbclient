package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.l;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f37194a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f20a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f26a = false;

    /* renamed from: a  reason: collision with other field name */
    public static String f23a = "XMPush-" + Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f21a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f24a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<Integer, String> f37195b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f22a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f25a = new AtomicInteger(1);

    /* loaded from: classes7.dex */
    public static class a implements LoggerInterface {

        /* renamed from: a  reason: collision with root package name */
        public String f37196a = b.f23a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f37196a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f37196a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f37196a = str;
        }
    }

    public static int a() {
        return f37194a;
    }

    public static Integer a(String str) {
        if (f37194a <= 1) {
            Integer valueOf = Integer.valueOf(f25a.incrementAndGet());
            f24a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f37195b.put(valueOf, str);
            LoggerInterface loggerInterface = f21a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f22a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m56a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i2) {
        if (i2 < 0 || i2 > 5) {
            a(2, "set log level as " + i2);
        }
        f37194a = i2;
    }

    public static void a(int i2, String str) {
        if (i2 >= f37194a) {
            f21a.log(str);
        }
    }

    public static void a(int i2, String str, Throwable th) {
        if (i2 >= f37194a) {
            f21a.log(str, th);
        }
    }

    public static void a(int i2, Throwable th) {
        if (i2 >= f37194a) {
            f21a.log("", th);
        }
    }

    public static void a(Context context) {
        f20a = context;
        if (l.m523a(context)) {
            f26a = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f21a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f37194a > 1 || !f24a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f24a.remove(num).longValue();
        LoggerInterface loggerInterface = f21a;
        loggerInterface.log(f37195b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m57a(String str) {
        a(2, m56a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m58a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m56a(str), th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    public static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    public static void b(String str) {
        a(0, m56a(str));
    }

    public static void c(String str) {
        a(1, m56a(str));
    }

    public static void d(String str) {
        a(4, m56a(str));
    }

    public static void e(String str) {
        if (f26a) {
            m57a(str);
        } else {
            Log.i(f23a, m56a(str));
        }
    }
}
