package d.b.h0.a.j1.m;

import android.util.Log;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45649a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f45650b = h("swan_get_swan_id_cache");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f45651c = h("swan_update_async");

    /* renamed from: d  reason: collision with root package name */
    public static boolean f45652d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f45653e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f45654f;

    /* renamed from: g  reason: collision with root package name */
    public static int f45655g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f45656h;
    public static boolean i;
    public static boolean j;

    static {
        d.b.h0.a.w0.a.N().getSwitch("swan_update_async_merge_node", false);
        f45652d = false;
        f45653e = h("swan_pre_app_launch");
        f45654f = h("swan_prevent_series_launch");
        d.b.h0.a.w0.a.N().getSwitch("swan_prevent_series_launch_interval", 200);
        f45655g = 200;
        f45656h = h("swan_pre_class_loader");
        i = d.b.h0.a.w0.a.N().A();
        j = h("swan_release_runtime_wait_master_finish");
    }

    public static int a() {
        return f45655g;
    }

    public static boolean b() {
        return f45650b;
    }

    public static boolean c() {
        return i;
    }

    public static boolean d() {
        return f45653e;
    }

    public static boolean e() {
        return f45656h;
    }

    public static boolean f() {
        return f45654f;
    }

    public static boolean g() {
        return j;
    }

    public static boolean h(String str) {
        d.b.h0.a.w0.a.N().getSwitch(str, 0);
        if (f45649a) {
            Log.d("SwanApiCostOpt", str + " value : 0");
        }
        return false;
    }

    public static boolean i() {
        return f45651c;
    }

    public static boolean j() {
        return f45652d;
    }
}
