package d.b.c.b.d;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static String f65774a = "VNetLog";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65775b = Log.isLoggable("VNetLog", 2);

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f65776c = q.f65775b;

        /* renamed from: a  reason: collision with root package name */
        public final List<C1833a> f65777a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f65778b = false;

        /* renamed from: d.b.c.b.d.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C1833a {

            /* renamed from: a  reason: collision with root package name */
            public final String f65779a;

            /* renamed from: b  reason: collision with root package name */
            public final long f65780b;

            /* renamed from: c  reason: collision with root package name */
            public final long f65781c;

            public C1833a(String str, long j, long j2) {
                this.f65779a = str;
                this.f65780b = j;
                this.f65781c = j2;
            }
        }

        public final long a() {
            if (this.f65777a.size() == 0) {
                return 0L;
            }
            long j = this.f65777a.get(0).f65781c;
            List<C1833a> list = this.f65777a;
            return list.get(list.size() - 1).f65781c - j;
        }

        public synchronized void b(String str) {
            this.f65778b = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f65777a.get(0).f65781c;
            q.c("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C1833a c1833a : this.f65777a) {
                long j2 = c1833a.f65781c;
                q.c("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c1833a.f65780b), c1833a.f65779a);
                j = j2;
            }
        }

        public synchronized void c(String str, long j) {
            if (!this.f65778b) {
                this.f65777a.add(new C1833a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (this.f65778b) {
                return;
            }
            b("Request on the loose");
            q.d("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f65775b) {
            Log.v(f65774a, f(str, objArr));
        }
    }

    public static void b(Throwable th, String str, Object... objArr) {
        Log.e(f65774a, f(str, objArr), th);
    }

    public static void c(String str, Object... objArr) {
        Log.d(f65774a, f(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        Log.e(f65774a, f(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.wtf(f65774a, f(str, objArr));
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
