package d.b.g0.a.j1.m;

import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44928a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f44929b = h("swan_get_swan_id_cache");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f44930c = h("swan_update_async");

    /* renamed from: d  reason: collision with root package name */
    public static boolean f44931d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44932e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f44933f;

    /* renamed from: g  reason: collision with root package name */
    public static int f44934g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f44935h;
    public static boolean i;
    public static boolean j;

    static {
        d.b.g0.a.w0.a.N().getSwitch("swan_update_async_merge_node", false);
        f44931d = false;
        f44932e = h("swan_pre_app_launch");
        f44933f = h("swan_prevent_series_launch");
        d.b.g0.a.w0.a.N().getSwitch("swan_prevent_series_launch_interval", 200);
        f44934g = 200;
        f44935h = h("swan_pre_class_loader");
        i = d.b.g0.a.w0.a.N().A();
        j = h("swan_release_runtime_wait_master_finish");
    }

    public static int a() {
        return f44934g;
    }

    public static boolean b() {
        return f44929b;
    }

    public static boolean c() {
        return i;
    }

    public static boolean d() {
        return f44932e;
    }

    public static boolean e() {
        return f44935h;
    }

    public static boolean f() {
        return f44933f;
    }

    public static boolean g() {
        return j;
    }

    public static boolean h(String str) {
        d.b.g0.a.w0.a.N().getSwitch(str, 0);
        if (f44928a) {
            Log.d("SwanApiCostOpt", str + " value : 0");
        }
        return false;
    }

    public static boolean i() {
        return f44930c;
    }

    public static boolean j() {
        return f44931d;
    }
}
