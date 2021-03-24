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
    public static int f40120a = 2;

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
    public static final HashMap<Integer, String> f40121b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f22a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f25a = new AtomicInteger(1);

    /* loaded from: classes7.dex */
    public static class a implements LoggerInterface {

        /* renamed from: a  reason: collision with root package name */
        public String f40122a = b.f23a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f40122a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f40122a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f40122a = str;
        }
    }

    public static int a() {
        return f40120a;
    }

    public static Integer a(String str) {
        if (f40120a <= 1) {
            Integer valueOf = Integer.valueOf(f25a.incrementAndGet());
            f24a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f40121b.put(valueOf, str);
            LoggerInterface loggerInterface = f21a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f22a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m50a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f40120a = i;
    }

    public static void a(int i, String str) {
        if (i >= f40120a) {
            f21a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f40120a) {
            f21a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f40120a) {
            f21a.log("", th);
        }
    }

    public static void a(Context context) {
        f20a = context;
        if (l.m517a(context)) {
            f26a = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f21a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f40120a > 1 || !f24a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f24a.remove(num).longValue();
        LoggerInterface loggerInterface = f21a;
        loggerInterface.log(f40121b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m51a(String str) {
        a(2, m50a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m52a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m50a(str), th);
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
        a(0, m50a(str));
    }

    public static void c(String str) {
        a(1, m50a(str));
    }

    public static void d(String str) {
        a(4, m50a(str));
    }

    public static void e(String str) {
        if (f26a) {
            m51a(str);
        } else {
            Log.i(f23a, m50a(str));
        }
    }
}
