package d.b.g0.a.j1.m;

import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45320a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f45321b = h("swan_get_swan_id_cache");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f45322c = h("swan_update_async");

    /* renamed from: d  reason: collision with root package name */
    public static boolean f45323d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f45324e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f45325f;

    /* renamed from: g  reason: collision with root package name */
    public static int f45326g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f45327h;
    public static boolean i;
    public static boolean j;

    static {
        d.b.g0.a.w0.a.N().getSwitch("swan_update_async_merge_node", false);
        f45323d = false;
        f45324e = h("swan_pre_app_launch");
        f45325f = h("swan_prevent_series_launch");
        d.b.g0.a.w0.a.N().getSwitch("swan_prevent_series_launch_interval", 200);
        f45326g = 200;
        f45327h = h("swan_pre_class_loader");
        i = d.b.g0.a.w0.a.N().A();
        j = h("swan_release_runtime_wait_master_finish");
    }

    public static int a() {
        return f45326g;
    }

    public static boolean b() {
        return f45321b;
    }

    public static boolean c() {
        return i;
    }

    public static boolean d() {
        return f45324e;
    }

    public static boolean e() {
        return f45327h;
    }

    public static boolean f() {
        return f45325f;
    }

    public static boolean g() {
        return j;
    }

    public static boolean h(String str) {
        d.b.g0.a.w0.a.N().getSwitch(str, 0);
        if (f45320a) {
            Log.d("SwanApiCostOpt", str + " value : 0");
        }
        return false;
    }

    public static boolean i() {
        return f45322c;
    }

    public static boolean j() {
        return f45323d;
    }
}
