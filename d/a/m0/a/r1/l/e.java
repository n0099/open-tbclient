package d.a.m0.a.r1.l;

import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes3.dex */
public class e implements d.a.m0.a.f1.f.a {

    /* renamed from: b  reason: collision with root package name */
    public static Integer f48311b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f48312c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f48313d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f48314e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f48315f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f48316g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f48317h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f48318i = -1;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;

    public static boolean a() {
        if (f48314e == null) {
            f48314e = Boolean.valueOf(h("swan_api_callback_opt"));
        }
        return f48314e.booleanValue();
    }

    public static int b(String str) {
        d.a.m0.a.c1.a.Z().getSwitch(str, 0);
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.d("SwanPerformance", "packing[" + str + " = 0" + PreferencesUtil.RIGHT_MOUNT);
        }
        return 0;
    }

    public static int c() {
        if (f48312c == null) {
            f48312c = Integer.valueOf(e() % 10000);
        }
        return f48312c.intValue();
    }

    public static int d() {
        if (f48313d == null) {
            f48313d = Integer.valueOf(e() / 10000);
        }
        return f48313d.intValue();
    }

    public static int e() {
        if (f48311b == null) {
            f48311b = Integer.valueOf(b("swan_launch_api_trigger"));
        }
        return f48311b.intValue();
    }

    public static int f() {
        if (f48318i == -1) {
            f48318i = b("swan_idle_handler_opt");
        }
        return f48318i;
    }

    public static boolean g() {
        return f() > 0;
    }

    public static boolean h(String str) {
        return b(str) != 0;
    }

    public static int i() {
        if (f48315f == null) {
            f48315f = Integer.valueOf(b("swan_launch_thread_dispatch"));
        }
        return f48315f.intValue();
    }

    public static boolean j() {
        return i() > 0;
    }

    public static int k() {
        if (f48317h == -1) {
            f48317h = b("swan_optimize_launch_cpu");
        }
        return f48317h;
    }

    public static boolean l() {
        if (k == -1) {
            k = b("swan_http_thread_opt");
        }
        return k > 0;
    }

    public static boolean m() {
        if (f48316g == null) {
            f48316g = Boolean.valueOf(h("swan_js_thread_dispatch"));
        }
        return f48316g.booleanValue();
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
