package d.a.h0.a.j1.m;

import android.util.Log;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42973a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42974b = h("swan_get_swan_id_cache");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f42975c = h("swan_update_async");

    /* renamed from: d  reason: collision with root package name */
    public static boolean f42976d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f42977e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f42978f;

    /* renamed from: g  reason: collision with root package name */
    public static int f42979g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f42980h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f42981i;
    public static boolean j;

    static {
        d.a.h0.a.w0.a.N().getSwitch("swan_update_async_merge_node", false);
        f42976d = false;
        f42977e = h("swan_pre_app_launch");
        f42978f = h("swan_prevent_series_launch");
        d.a.h0.a.w0.a.N().getSwitch("swan_prevent_series_launch_interval", 200);
        f42979g = 200;
        f42980h = h("swan_pre_class_loader");
        f42981i = d.a.h0.a.w0.a.N().p();
        j = h("swan_release_runtime_wait_master_finish");
    }

    public static int a() {
        return f42979g;
    }

    public static boolean b() {
        return f42974b;
    }

    public static boolean c() {
        return f42981i;
    }

    public static boolean d() {
        return f42977e;
    }

    public static boolean e() {
        return f42980h;
    }

    public static boolean f() {
        return f42978f;
    }

    public static boolean g() {
        return j;
    }

    public static boolean h(String str) {
        d.a.h0.a.w0.a.N().getSwitch(str, 0);
        if (f42973a) {
            Log.d("SwanApiCostOpt", str + " value : 0");
        }
        return false;
    }

    public static boolean i() {
        return f42975c;
    }

    public static boolean j() {
        return f42976d;
    }
}
