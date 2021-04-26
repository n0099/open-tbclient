package d.b.c.b.d;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static String f65088a = "VNetLog";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65089b = Log.isLoggable("VNetLog", 2);

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f65090c = q.f65089b;

        /* renamed from: a  reason: collision with root package name */
        public final List<C1769a> f65091a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f65092b = false;

        /* renamed from: d.b.c.b.d.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C1769a {

            /* renamed from: a  reason: collision with root package name */
            public final String f65093a;

            /* renamed from: b  reason: collision with root package name */
            public final long f65094b;

            /* renamed from: c  reason: collision with root package name */
            public final long f65095c;

            public C1769a(String str, long j, long j2) {
                this.f65093a = str;
                this.f65094b = j;
                this.f65095c = j2;
            }
        }

        public final long a() {
            if (this.f65091a.size() == 0) {
                return 0L;
            }
            long j = this.f65091a.get(0).f65095c;
            List<C1769a> list = this.f65091a;
            return list.get(list.size() - 1).f65095c - j;
        }

        public synchronized void b(String str) {
            this.f65092b = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f65091a.get(0).f65095c;
            q.c("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C1769a c1769a : this.f65091a) {
                long j2 = c1769a.f65095c;
                q.c("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c1769a.f65094b), c1769a.f65093a);
                j = j2;
            }
        }

        public synchronized void c(String str, long j) {
            if (!this.f65092b) {
                this.f65091a.add(new C1769a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (this.f65092b) {
                return;
            }
            b("Request on the loose");
            q.d("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f65089b) {
            Log.v(f65088a, f(str, objArr));
        }
    }

    public static void b(Throwable th, String str, Object... objArr) {
        Log.e(f65088a, f(str, objArr), th);
    }

    public static void c(String str, Object... objArr) {
        Log.d(f65088a, f(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.e(f65088a, f(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.wtf(f65088a, f(str, objArr));
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
