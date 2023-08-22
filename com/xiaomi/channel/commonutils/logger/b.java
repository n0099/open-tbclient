package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class b {
    public static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f12a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f18a;

    /* renamed from: b  reason: collision with other field name */
    public static boolean f19b;

    /* renamed from: a  reason: collision with other field name */
    public static String f15a = "XMPush-" + Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f13a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f16a = new HashMap<>();
    public static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f14a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f17a = new AtomicInteger(1);

    /* loaded from: classes10.dex */
    public static class a implements LoggerInterface {
        public String a = b.f15a;

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
            Integer valueOf = Integer.valueOf(f17a.incrementAndGet());
            f16a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            LoggerInterface loggerInterface = f13a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f14a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m179a(String str) {
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
            f13a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f13a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f13a.log("", th);
        }
    }

    public static void a(Context context) {
        f12a = context;
        if (j.m711a(context)) {
            f18a = true;
        }
        if (j.m710a()) {
            f19b = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f13a = loggerInterface;
    }

    public static void a(Integer num) {
        if (a > 1 || !f16a.containsKey(num)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f16a.remove(num).longValue();
        LoggerInterface loggerInterface = f13a;
        loggerInterface.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m180a(String str) {
        a(2, m179a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m181a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m179a(str), th);
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
        a(0, m179a(str));
    }

    public static void c(String str) {
        a(1, m179a(str));
    }

    public static void d(String str) {
        a(4, m179a(str));
    }

    public static void e(String str) {
        if (!f18a) {
            Log.w(f15a, m179a(str));
            if (f19b) {
                return;
            }
        }
        m180a(str);
    }
}
