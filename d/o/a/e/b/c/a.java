package d.o.a.e.b.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f67938a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static AbstractC1881a f67939b;

    /* renamed from: d.o.a.e.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC1881a {
        public abstract void a(String str, String str2);

        public abstract void b(String str, String str2, Throwable th);

        public abstract void c(String str, String str2);

        public abstract void d(String str, String str2);

        public abstract void e(String str, String str2);

        public abstract void f(String str, String str2);
    }

    public static void a(int i) {
        f67938a = i;
    }

    public static void b(String str) {
        g("DownloaderLogger", str);
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f67938a <= 2) {
            Log.v(str, str2);
        }
        AbstractC1881a abstractC1881a = f67939b;
        if (abstractC1881a != null) {
            abstractC1881a.a(f(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f67938a <= 6) {
            Log.e(f(str), str2, th);
        }
        AbstractC1881a abstractC1881a = f67939b;
        if (abstractC1881a != null) {
            abstractC1881a.b(f(str), str2, th);
        }
    }

    public static boolean e() {
        return f67938a <= 3;
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
        if (f67938a <= 3) {
            Log.d(f(str), str2);
        }
        AbstractC1881a abstractC1881a = f67939b;
        if (abstractC1881a != null) {
            abstractC1881a.c(f(str), str2);
        }
    }

    public static void h(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f67938a <= 4) {
            Log.i(f(str), str2);
        }
        AbstractC1881a abstractC1881a = f67939b;
        if (abstractC1881a != null) {
            abstractC1881a.d(f(str), str2);
        }
    }

    public static void i(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f67938a <= 5) {
            Log.w(f(str), str2);
        }
        AbstractC1881a abstractC1881a = f67939b;
        if (abstractC1881a != null) {
            abstractC1881a.f(f(str), str2);
        }
    }

    public static void j(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f67938a <= 6) {
            Log.e(f(str), str2);
        }
        AbstractC1881a abstractC1881a = f67939b;
        if (abstractC1881a != null) {
            abstractC1881a.e(f(str), str2);
        }
    }
}
