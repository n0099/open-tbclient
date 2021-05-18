package d.a.i0.a.r1.l;

import android.util.Log;
/* loaded from: classes3.dex */
public class e implements d.a.i0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public static Integer f44353b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f44354c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f44355d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f44356e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f44357f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f44358g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f44359h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f44360i = -1;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;

    public static boolean a() {
        if (f44356e == null) {
            f44356e = Boolean.valueOf(h("swan_api_callback_opt"));
        }
        return f44356e.booleanValue();
    }

    public static int b(String str) {
        d.a.i0.a.c1.a.Z().getSwitch(str, 0);
        if (d.a.i0.a.f1.f.a.f41678a) {
            Log.d("SwanPerformance", "packing[" + str + " = 0]");
        }
        return 0;
    }

    public static int c() {
        if (f44354c == null) {
            f44354c = Integer.valueOf(e() % 10000);
        }
        return f44354c.intValue();
    }

    public static int d() {
        if (f44355d == null) {
            f44355d = Integer.valueOf(e() / 10000);
        }
        return f44355d.intValue();
    }

    public static int e() {
        if (f44353b == null) {
            f44353b = Integer.valueOf(b("swan_launch_api_trigger"));
        }
        return f44353b.intValue();
    }

    public static int f() {
        if (f44360i == -1) {
            f44360i = b("swan_idle_handler_opt");
        }
        return f44360i;
    }

    public static boolean g() {
        return f() > 0;
    }

    public static boolean h(String str) {
        return b(str) != 0;
    }

    public static int i() {
        if (f44357f == null) {
            f44357f = Integer.valueOf(b("swan_launch_thread_dispatch"));
        }
        return f44357f.intValue();
    }

    public static boolean j() {
        return i() > 0;
    }

    public static int k() {
        if (f44359h == -1) {
            f44359h = b("swan_optimize_launch_cpu");
        }
        return f44359h;
    }

    public static boolean l() {
        if (k == -1) {
            k = b("swan_http_thread_opt");
        }
        return k > 0;
    }

    public static boolean m() {
        if (f44358g == null) {
            f44358g = Boolean.valueOf(h("swan_js_thread_dispatch"));
        }
        return f44358g.booleanValue();
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
