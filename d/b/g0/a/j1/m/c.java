package d.b.g0.a.j1.m;

import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44927a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f44928b = h("swan_get_swan_id_cache");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f44929c = h("swan_update_async");

    /* renamed from: d  reason: collision with root package name */
    public static boolean f44930d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44931e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f44932f;

    /* renamed from: g  reason: collision with root package name */
    public static int f44933g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f44934h;
    public static boolean i;
    public static boolean j;

    static {
        d.b.g0.a.w0.a.N().getSwitch("swan_update_async_merge_node", false);
        f44930d = false;
        f44931e = h("swan_pre_app_launch");
        f44932f = h("swan_prevent_series_launch");
        d.b.g0.a.w0.a.N().getSwitch("swan_prevent_series_launch_interval", 200);
        f44933g = 200;
        f44934h = h("swan_pre_class_loader");
        i = d.b.g0.a.w0.a.N().A();
        j = h("swan_release_runtime_wait_master_finish");
    }

    public static int a() {
        return f44933g;
    }

    public static boolean b() {
        return f44928b;
    }

    public static boolean c() {
        return i;
    }

    public static boolean d() {
        return f44931e;
    }

    public static boolean e() {
        return f44934h;
    }

    public static boolean f() {
        return f44932f;
    }

    public static boolean g() {
        return j;
    }

    public static boolean h(String str) {
        d.b.g0.a.w0.a.N().getSwitch(str, 0);
        if (f44927a) {
            Log.d("SwanApiCostOpt", str + " value : 0");
        }
        return false;
    }

    public static boolean i() {
        return f44929c;
    }

    public static boolean j() {
        return f44930d;
    }
}
