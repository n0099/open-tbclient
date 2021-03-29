package d.c.c.b.d;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static String f65747a = "VNetLog";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65748b = Log.isLoggable("VNetLog", 2);

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f65749c = q.f65748b;

        /* renamed from: a  reason: collision with root package name */
        public final List<C1798a> f65750a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f65751b = false;

        /* renamed from: d.c.c.b.d.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C1798a {

            /* renamed from: a  reason: collision with root package name */
            public final String f65752a;

            /* renamed from: b  reason: collision with root package name */
            public final long f65753b;

            /* renamed from: c  reason: collision with root package name */
            public final long f65754c;

            public C1798a(String str, long j, long j2) {
                this.f65752a = str;
                this.f65753b = j;
                this.f65754c = j2;
            }
        }

        public final long a() {
            if (this.f65750a.size() == 0) {
                return 0L;
            }
            long j = this.f65750a.get(0).f65754c;
            List<C1798a> list = this.f65750a;
            return list.get(list.size() - 1).f65754c - j;
        }

        public synchronized void b(String str) {
            this.f65751b = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f65750a.get(0).f65754c;
            q.c("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C1798a c1798a : this.f65750a) {
                long j2 = c1798a.f65754c;
                q.c("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c1798a.f65753b), c1798a.f65752a);
                j = j2;
            }
        }

        public synchronized void c(String str, long j) {
            if (!this.f65751b) {
                this.f65750a.add(new C1798a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (this.f65751b) {
                return;
            }
            b("Request on the loose");
            q.d("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f65748b) {
            Log.v(f65747a, f(str, objArr));
        }
    }

    public static void b(Throwable th, String str, Object... objArr) {
        Log.e(f65747a, f(str, objArr), th);
    }

    public static void c(String str, Object... objArr) {
        Log.d(f65747a, f(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.e(f65747a, f(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.wtf(f65747a, f(str, objArr));
    }

    public static String f(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals("com.bytedance.sdk.adnet.VNetLog")) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
