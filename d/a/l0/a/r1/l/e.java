package d.a.l0.a.r1.l;

import android.util.Log;
/* loaded from: classes3.dex */
public class e implements d.a.l0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public static Integer f44529b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f44530c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f44531d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f44532e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f44533f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f44534g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f44535h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f44536i = -1;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;

    public static boolean a() {
        if (f44532e == null) {
            f44532e = Boolean.valueOf(h("swan_api_callback_opt"));
        }
        return f44532e.booleanValue();
    }

    public static int b(String str) {
        d.a.l0.a.c1.a.Z().getSwitch(str, 0);
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.d("SwanPerformance", "packing[" + str + " = 0]");
        }
        return 0;
    }

    public static int c() {
        if (f44530c == null) {
            f44530c = Integer.valueOf(e() % 10000);
        }
        return f44530c.intValue();
    }

    public static int d() {
        if (f44531d == null) {
            f44531d = Integer.valueOf(e() / 10000);
        }
        return f44531d.intValue();
    }

    public static int e() {
        if (f44529b == null) {
            f44529b = Integer.valueOf(b("swan_launch_api_trigger"));
        }
        return f44529b.intValue();
    }

    public static int f() {
        if (f44536i == -1) {
            f44536i = b("swan_idle_handler_opt");
        }
        return f44536i;
    }

    public static boolean g() {
        return f() > 0;
    }

    public static boolean h(String str) {
        return b(str) != 0;
    }

    public static int i() {
        if (f44533f == null) {
            f44533f = Integer.valueOf(b("swan_launch_thread_dispatch"));
        }
        return f44533f.intValue();
    }

    public static boolean j() {
        return i() > 0;
    }

    public static int k() {
        if (f44535h == -1) {
            f44535h = b("swan_optimize_launch_cpu");
        }
        return f44535h;
    }

    public static boolean l() {
        if (k == -1) {
            k = b("swan_http_thread_opt");
        }
        return k > 0;
    }

    public static boolean m() {
        if (f44534g == null) {
            f44534g = Boolean.valueOf(h("swan_js_thread_dispatch"));
        }
        return f44534g.booleanValue();
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
