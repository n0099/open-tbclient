package d.o.a.e.b.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f70956a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static AbstractC1948a f70957b;

    /* renamed from: d.o.a.e.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC1948a {
        public abstract void a(String str, String str2);

        public abstract void b(String str, String str2, Throwable th);

        public abstract void c(String str, String str2);

        public abstract void d(String str, String str2);

        public abstract void e(String str, String str2);

        public abstract void f(String str, String str2);
    }

    public static void a(int i2) {
        f70956a = i2;
    }

    public static void b(String str) {
        g("DownloaderLogger", str);
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f70956a <= 2) {
            Log.v(str, str2);
        }
        AbstractC1948a abstractC1948a = f70957b;
        if (abstractC1948a != null) {
            abstractC1948a.a(f(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f70956a <= 6) {
            Log.e(f(str), str2, th);
        }
        AbstractC1948a abstractC1948a = f70957b;
        if (abstractC1948a != null) {
            abstractC1948a.b(f(str), str2, th);
        }
    }

    public static boolean e() {
        return f70956a <= 3;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void g(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f70956a <= 3) {
            Log.d(f(str), str2);
        }
        AbstractC1948a abstractC1948a = f70957b;
        if (abstractC1948a != null) {
            abstractC1948a.c(f(str), str2);
        }
    }

    public static void h(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f70956a <= 4) {
            Log.i(f(str), str2);
        }
        AbstractC1948a abstractC1948a = f70957b;
        if (abstractC1948a != null) {
            abstractC1948a.d(f(str), str2);
        }
    }

    public static void i(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f70956a <= 5) {
            Log.w(f(str), str2);
        }
        AbstractC1948a abstractC1948a = f70957b;
        if (abstractC1948a != null) {
            abstractC1948a.f(f(str), str2);
        }
    }

    public static void j(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f70956a <= 6) {
            Log.e(f(str), str2);
        }
        AbstractC1948a abstractC1948a = f70957b;
        if (abstractC1948a != null) {
            abstractC1948a.e(f(str), str2);
        }
    }
}
