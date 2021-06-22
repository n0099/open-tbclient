package d.a.m0.a.r1.l;

import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.n.j.i.l;
import d.a.m0.n.j.i.m;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int f48302c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f48303d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48304e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48305f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f48306g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f48307h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f48308i;
    public static final int j;
    public static final boolean k;
    public static final int l;
    public static final boolean o;
    public static final int p;
    public static final int q;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48300a = k.f46983a;
    public static int m = -1;
    public static int n = -1;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f48301b = p("swan_get_swan_id_cache");

    static {
        p("swan_pms_use_outback");
        p("swan_package_download_use_outback");
        p("swan_outback_use_independent_pool");
        p("swan_outback_support_quic");
        d.a.m0.a.c1.a.Z().getSwitch("swan_preload_game_strategy", 0);
        f48302c = 0;
        boolean p2 = p("swan_mbd_request_use_http2");
        f48303d = p2;
        l.f51936a = p2;
        f48304e = p("swan_memorywarning_alert_switch");
        f48305f = p("swan_memorywarning_not_show_dialog");
        d.a.m0.a.c1.a.Z().getSwitch("swan_memorywarning_memory_ratio", 80);
        f48306g = 80;
        d.a.m0.a.c1.a.Z().getSwitch("swan_memorywarning_interval", 30);
        f48307h = 30;
        d.a.m0.a.c1.a.Z().getSwitch("swan_memorywarning_alert_interval", 300);
        f48308i = 300;
        d.a.m0.a.c1.a.Z().getSwitch("swan_memorywarning_release_interval", 5);
        j = 5;
        k = p("swan_watchdog_switch");
        d.a.m0.a.c1.a.Z().getSwitch("swan_watchdog_interval", 5);
        l = 5;
        d.a.m0.a.c1.a.Z().getSwitch("swan_launch_loading_hidden_interval", 0);
        q = 0;
        d.a.m0.a.c1.a.Z().getSwitch("swan_launch_page_loading_type", 0);
        p = 0;
        o = p("swan_670_append_request_info");
        d.a.m0.a.c1.a.Z().getSwitch("swan_description_online_control", 0);
        m.f51939a = 0;
    }

    public static int a() {
        if (m == -1) {
            d.a.m0.a.c1.a.Z().getSwitch("swan_upgrade_js_thread_priority", 0);
            m = 0;
        }
        return m;
    }

    public static int b() {
        return l;
    }

    public static int c() {
        return q;
    }

    public static int d() {
        return p;
    }

    public static int e() {
        return f48308i;
    }

    public static int f() {
        return f48307h;
    }

    public static int g() {
        return f48306g;
    }

    public static int h() {
        return f48302c;
    }

    public static int i() {
        return j;
    }

    public static boolean j() {
        return f48301b;
    }

    public static boolean k() {
        if (n == -1) {
            d.a.m0.a.c1.a.Z().getSwitch("swan_ipc_use_aidl", -1);
            n = -1;
        }
        return n == 1;
    }

    public static boolean l() {
        return k;
    }

    public static boolean m() {
        return f48303d;
    }

    public static boolean n() {
        return f48305f;
    }

    public static boolean o() {
        return f48304e;
    }

    public static boolean p(String str) {
        d.a.m0.a.c1.a.Z().getSwitch(str, 0);
        if (f48300a) {
            Log.d("SwanApiCostOpt", str + " value : 0");
        }
        return false;
    }
}
