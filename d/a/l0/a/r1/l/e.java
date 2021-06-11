package d.a.l0.a.r1.l;

import android.util.Log;
/* loaded from: classes3.dex */
public class e implements d.a.l0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public static Integer f48203b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f48204c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f48205d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f48206e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f48207f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f48208g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f48209h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f48210i = -1;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;

    public static boolean a() {
        if (f48206e == null) {
            f48206e = Boolean.valueOf(h("swan_api_callback_opt"));
        }
        return f48206e.booleanValue();
    }

    public static int b(String str) {
        d.a.l0.a.c1.a.Z().getSwitch(str, 0);
        if (d.a.l0.a.f1.f.a.f45528a) {
            Log.d("SwanPerformance", "packing[" + str + " = 0]");
        }
        return 0;
    }

    public static int c() {
        if (f48204c == null) {
            f48204c = Integer.valueOf(e() % 10000);
        }
        return f48204c.intValue();
    }

    public static int d() {
        if (f48205d == null) {
            f48205d = Integer.valueOf(e() / 10000);
        }
        return f48205d.intValue();
    }

    public static int e() {
        if (f48203b == null) {
            f48203b = Integer.valueOf(b("swan_launch_api_trigger"));
        }
        return f48203b.intValue();
    }

    public static int f() {
        if (f48210i == -1) {
            f48210i = b("swan_idle_handler_opt");
        }
        return f48210i;
    }

    public static boolean g() {
        return f() > 0;
    }

    public static boolean h(String str) {
        return b(str) != 0;
    }

    public static int i() {
        if (f48207f == null) {
            f48207f = Integer.valueOf(b("swan_launch_thread_dispatch"));
        }
        return f48207f.intValue();
    }

    public static boolean j() {
        return i() > 0;
    }

    public static int k() {
        if (f48209h == -1) {
            f48209h = b("swan_optimize_launch_cpu");
        }
        return f48209h;
    }

    public static boolean l() {
        if (k == -1) {
            k = b("swan_http_thread_opt");
        }
        return k > 0;
    }

    public static boolean m() {
        if (f48208g == null) {
            f48208g = Boolean.valueOf(h("swan_js_thread_dispatch"));
        }
        return f48208g.booleanValue();
    }

    public static boolean n() {
        if (l == -1) {
            l = b("swan_webview_ssl_opt");
        }
        return l > 0;
    }

    public static int o() {
        if (j == -1) {
            j = b("swan_mmap_loger_opt");
        }
        return j;
    }
}
