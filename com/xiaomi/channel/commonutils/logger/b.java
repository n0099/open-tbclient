package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public abstract class b {
    public static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f11a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f17a;

    /* renamed from: b  reason: collision with other field name */
    public static boolean f18b;

    /* renamed from: a  reason: collision with other field name */
    public static String f14a = "XMPush-" + Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f12a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f15a = new HashMap<>();
    public static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f13a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f16a = new AtomicInteger(1);

    /* loaded from: classes8.dex */
    public static class a implements LoggerInterface {
        public String a = b.f14a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }
    }

    public static int a() {
        return a;
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f16a.incrementAndGet());
            f15a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            LoggerInterface loggerInterface = f12a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f13a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m100a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return PreferencesUtil.LEFT_MOUNT + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f12a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f12a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f12a.log("", th);
        }
    }

    public static void a(Context context) {
        f11a = context;
        if (j.m632a(context)) {
            f17a = true;
        }
        if (j.m631a()) {
            f18b = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f12a = loggerInterface;
    }

    public static void a(Integer num) {
        if (a > 1 || !f15a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f15a.remove(num).longValue();
        LoggerInterface loggerInterface = f12a;
        loggerInterface.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m101a(String str) {
        a(2, m100a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m102a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m100a(str), th);
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
        a(0, m100a(str));
    }

    public static void c(String str) {
        a(1, m100a(str));
    }

    public static void d(String str) {
        a(4, m100a(str));
    }

    public static void e(String str) {
        if (!f17a) {
            Log.w(f14a, m100a(str));
            if (f18b) {
                return;
            }
        }
        m101a(str);
    }
}
