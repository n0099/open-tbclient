package d.a.m0.a.u1.a;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a1.e;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.f1.e.c;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.d;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49029a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.m0.a.k2.g.a f49030b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f49031c;

    static {
        HashSet hashSet = new HashSet();
        f49031c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        f49031c.add("aiapps_server_domains_debug_key");
        f49031c.add("aiapps_use_extension_debug_key");
        f49031c.add("aiapps_emit_live_debug_key");
        f49031c.add("aiapps_emit_https_debug_key");
        f49031c.add("aiapps_emit_wss_debug_key");
        f49031c.add("aiapps_load_cts_debug_key");
        f49031c.add("aiapps_env_data");
        f49031c.add("aiapps_js_native_switch_key");
        f49031c.add("aiapps_emit_game_core_debug_key");
        f49031c.add("aiapps_emit_game_launch_mode_key");
    }

    public static boolean A(b bVar) {
        return (f49029a && bVar.m0()) || E(bVar.g0()) || d.a.m0.a.e0.f.b.e() || d.a.m0.a.e0.f.b.f() || bVar.o0() || (w() && bVar.R());
    }

    public static boolean B(c cVar) {
        return (f49029a && cVar.m0()) || E(cVar.g0()) || d.a.m0.a.e0.f.b.e() || d.a.m0.a.e0.f.b.f() || cVar.o0() || (w() && cVar.R());
    }

    public static boolean C() {
        e Q = e.Q();
        if (Q != null) {
            return Q.L().o0();
        }
        return false;
    }

    public static boolean D() {
        return s() || r() || o() || x() || !z() || k() || h() || q() || w();
    }

    public static boolean E(String str) {
        return !TextUtils.isEmpty(str) || d.a.m0.a.e0.f.e.e.d();
    }

    public static Boolean F() {
        return Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false));
    }

    public static boolean G() {
        return d.a.m0.a.e0.f.b.e() || d.a.m0.a.e0.f.b.f();
    }

    public static Bundle H(c cVar) {
        if (B(cVar)) {
            b.a b2 = b();
            b2.u0(cVar.H());
            b2.H0(cVar.T());
            b2.Q0(cVar.e0());
            b2.z0(cVar.m0());
            b2.K0(cVar.o0());
            b2.x0(cVar.L());
            b2.C0(cVar.r0());
            b2.J0(cVar.W());
            b2.O0(cVar.c0());
            b2.X0(cVar.i0());
            b2.B0(cVar.O());
            b2.Y0(cVar.j0());
            b2.S0(cVar.g0());
            b2.G1("0");
            b2.t0(cVar.G());
            b2.P0(cVar.d0());
            if (E(cVar.g0()) || G() || cVar.o0()) {
                b2.z1(cVar.H());
            }
            return b2.C();
        }
        return null;
    }

    public static void I(String str, boolean z) {
        t().putBoolean(str, z);
    }

    public static void J(String str) {
        t().putString("aiapps_env_data", str);
    }

    public static void K(boolean z) {
        I("aiapps_emit_game_core_debug_key", z);
    }

    public static void L(boolean z) {
        d.a.m0.a.m2.b.q(z);
    }

    public static void M(boolean z) {
        I("aiapps_emit_https_debug_key", z);
    }

    public static void N(boolean z) {
        I("aiapps_js_native_switch_key", z);
    }

    public static void O(boolean z) {
        I("aiapps_emit_wss_debug_key", z);
    }

    public static void P(boolean z) {
        I("aiapps_emit_live_debug_key", z);
    }

    public static void Q(boolean z) {
        I("aiapps_load_cts_debug_key", z);
    }

    public static void R(boolean z) {
        I("aiapps_server_domains_debug_key", z);
    }

    public static void S(boolean z) {
        I("aiapps_emit_game_launch_mode_key", z);
    }

    public static void T(boolean z) {
        I("aiapps_use_extension_debug_key", z);
    }

    public static void U(boolean z) {
        I("aiapps_websafe_debug_key", z);
    }

    public static boolean V() {
        return t().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean W() {
        return t().getBoolean("swan_debug_force_ab", false);
    }

    public static void X() {
        d m;
        g W = f.V().W();
        if (W == null || (m = W.m()) == null) {
            return;
        }
        m.G2();
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        if (extensionCore == null) {
            return null;
        }
        extensionCore.extensionCoreVersionCode = 4294967297L;
        extensionCore.extensionCoreVersionName = com.baidu.fsg.face.base.b.b.f5524e;
        return extensionCore;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static b.a b() {
        return ((b.a) ((b.a) ((b.a) new b.a().R0(new PMSAppInfo())).A1("小程序测试").u0("10985873").N0(Color.parseColor("#FF308EF0"))).H0("1230000000000000")).x1("小程序简介").D1("测试服务类目").E1("测试主体信息").z1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").G1("1.0").B1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
    }

    public static e.g c(b bVar, d.a.m0.a.v2.a1.b bVar2) {
        if (f49029a && bVar.m0()) {
            return e.b.a(bVar, bVar2);
        }
        if (E(bVar.g0())) {
            return e.f.a(bVar);
        }
        if (d.a.m0.a.e0.f.b.e()) {
            return d.a.m0.a.e0.f.c.a.a(bVar);
        }
        if (d.a.m0.a.e0.f.b.f()) {
            return d.a.m0.a.e0.f.f.b.a(bVar);
        }
        if (bVar.o0()) {
            return d.a.m0.a.e0.f.d.b.a(bVar);
        }
        return null;
    }

    public static boolean d(String str, boolean z) {
        return t().getBoolean(str, z);
    }

    public static boolean e() {
        return d("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean f() {
        return d("aiapps_dashboard_enable_debug_key", false);
    }

    public static String g() {
        return t().getString("aiapps_env_data", "");
    }

    public static boolean h() {
        return d("aiapps_emit_game_core_debug_key", false);
    }

    public static String i() {
        return t().getString("swan_debug_so_url_key", "");
    }

    public static int j() {
        return t().getInt("swan_debug_open_so_key", -1);
    }

    public static boolean k() {
        return d.a.m0.a.m2.b.j();
    }

    public static String l(b bVar) {
        if (f49029a && bVar.m0()) {
            return e.b.g().getPath();
        }
        if (E(bVar.g0())) {
            return e.f.e().getPath();
        }
        if (d.a.m0.a.e0.f.b.e()) {
            return d.a.m0.a.e0.f.c.a.b().getPath();
        }
        if (d.a.m0.a.e0.f.b.f()) {
            return d.a.m0.a.e0.f.f.b.e().getPath();
        }
        return bVar.o0() ? d.a.m0.a.e0.f.d.b.d().getPath() : "";
    }

    public static boolean m() {
        return d("aiapps_force_authorized_key", false);
    }

    public static boolean n() {
        return d("swan_game_fps_debug_key", false);
    }

    public static boolean o() {
        return d("aiapps_emit_https_debug_key", false);
    }

    public static boolean p() {
        return d("aiapps_js_native_switch_key", true);
    }

    public static boolean q() {
        return d("aiapps_emit_wss_debug_key", false);
    }

    public static boolean r() {
        return d("aiapps_emit_live_debug_key", false);
    }

    public static boolean s() {
        return d("aiapps_load_cts_debug_key", false);
    }

    public static d.a.m0.a.k2.g.a t() {
        if (f49030b == null) {
            synchronized (a.class) {
                if (f49030b == null) {
                    d.a.m0.a.k2.g.a aVar = new d.a.m0.a.k2.g.a("swan_app_debug");
                    f49030b = aVar;
                    aVar.f47026f.addAll(f49031c);
                }
            }
        }
        return f49030b;
    }

    public static boolean u() {
        return d("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean v() {
        return d("aiapps_server_domains_debug_key", true);
    }

    public static boolean w() {
        return d("aiapps_emit_game_launch_mode_key", false);
    }

    public static boolean x() {
        return d("aiapps_use_extension_debug_key", false);
    }

    public static boolean y() {
        return d("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean z() {
        return d("aiapps_websafe_debug_key", true);
    }
}
