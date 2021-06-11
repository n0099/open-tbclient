package d.b.c.b.d;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static String f69548a = "VNetLog";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f69549b = Log.isLoggable("VNetLog", 2);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f69550c = q.f69549b;

        /* renamed from: a  reason: collision with root package name */
        public final List<C1896a> f69551a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f69552b = false;

        /* renamed from: d.b.c.b.d.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C1896a {

            /* renamed from: a  reason: collision with root package name */
            public final String f69553a;

            /* renamed from: b  reason: collision with root package name */
            public final long f69554b;

            /* renamed from: c  reason: collision with root package name */
            public final long f69555c;

            public C1896a(String str, long j, long j2) {
                this.f69553a = str;
                this.f69554b = j;
                this.f69555c = j2;
            }
        }

        public final long a() {
            if (this.f69551a.size() == 0) {
                return 0L;
            }
            long j = this.f69551a.get(0).f69555c;
            List<C1896a> list = this.f69551a;
            return list.get(list.size() - 1).f69555c - j;
        }

        public synchronized void b(String str) {
            this.f69552b = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f69551a.get(0).f69555c;
            q.c("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C1896a c1896a : this.f69551a) {
                long j2 = c1896a.f69555c;
                q.c("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c1896a.f69554b), c1896a.f69553a);
                j = j2;
            }
        }

        public synchronized void c(String str, long j) {
            if (!this.f69552b) {
                this.f69551a.add(new C1896a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (this.f69552b) {
                return;
            }
            b("Request on the loose");
            q.d("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f69549b) {
            Log.v(f69548a, f(str, objArr));
        }
    }

    public static void b(Throwable th, String str, Object... objArr) {
        Log.e(f69548a, f(str, objArr), th);
    }

    public static void c(String str, Object... objArr) {
        Log.d(f69548a, f(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.e(f69548a, f(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.wtf(f69548a, f(str, objArr));
    }

    public static String f(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
