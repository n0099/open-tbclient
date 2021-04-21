package d.b.h0.a.m1.a;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.a.c0.d.b;
import d.b.h0.a.c0.d.d.e;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.k;
import d.b.h0.a.u0.d;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.y0.e.c;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45956a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.h0.a.a2.g.a f45957b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f45958c;

    static {
        HashSet hashSet = new HashSet();
        f45958c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        f45958c.add("aiapps_server_domains_debug_key");
        f45958c.add("aiapps_use_extension_debug_key");
        f45958c.add("aiapps_emit_live_debug_key");
        f45958c.add("aiapps_emit_https_debug_key");
        f45958c.add("aiapps_emit_wss_debug_key");
        f45958c.add("aiapps_load_cts_debug_key");
        f45958c.add("aiapps_env_data");
        f45958c.add("aiapps_js_native_switch_key");
        f45958c.add("aiapps_emit_game_core_debug_key");
        f45958c.add("aiapps_emit_game_launch_mode_key");
    }

    public static boolean A() {
        return q() || p() || m() || v() || !x() || i() || h() || o() || u();
    }

    public static boolean B(String str) {
        return !TextUtils.isEmpty(str) || e.d();
    }

    public static boolean C() {
        return b.e() || b.f();
    }

    public static Bundle D(c cVar) {
        if (z(cVar)) {
            b.a b2 = b();
            b2.q0(cVar.G());
            b2.D0(cVar.S());
            b2.J0(cVar.b0());
            b2.v0(cVar.j0());
            b2.t0(cVar.K());
            b2.y0(cVar.n0());
            b2.F0(cVar.V());
            b2.H0(cVar.Z());
            b2.Q0(cVar.f0());
            b2.x0(cVar.N());
            b2.R0(cVar.g0());
            b2.L0(cVar.d0());
            b2.z1("0");
            b2.p0(cVar.F());
            b2.I0(cVar.a0());
            if (B(cVar.d0()) || C()) {
                b2.s1(cVar.G());
            }
            return b2.A();
        }
        return null;
    }

    public static void E(String str, boolean z) {
        r().putBoolean(str, z);
    }

    public static void F(String str) {
        r().putString("aiapps_env_data", str);
    }

    public static void G(boolean z) {
        E("aiapps_emit_game_core_debug_key", z);
    }

    public static void H(boolean z) {
        d.b.h0.a.b2.b.o(z);
    }

    public static void I(boolean z) {
        E("aiapps_emit_https_debug_key", z);
    }

    public static void J(boolean z) {
        E("aiapps_js_native_switch_key", z);
    }

    public static void K(boolean z) {
        E("aiapps_emit_wss_debug_key", z);
    }

    public static void L(boolean z) {
        E("aiapps_emit_live_debug_key", z);
    }

    public static void M(boolean z) {
        E("aiapps_load_cts_debug_key", z);
    }

    public static void N(boolean z) {
        E("aiapps_server_domains_debug_key", z);
    }

    public static void O(boolean z) {
        E("aiapps_emit_game_launch_mode_key", z);
    }

    public static void P(boolean z) {
        E("aiapps_use_extension_debug_key", z);
    }

    public static void Q(boolean z) {
        E("aiapps_websafe_debug_key", z);
    }

    public static boolean R() {
        return r().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean S() {
        return r().getBoolean("swan_debug_force_ab", false);
    }

    public static void T() {
        d.b.h0.a.e0.l.c m;
        f W = d.b.h0.a.z0.f.V().W();
        if (W == null || (m = W.m()) == null) {
            return;
        }
        m.A2();
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        if (extensionCore == null) {
            return null;
        }
        extensionCore.extensionCoreVersionCode = 4294967297L;
        extensionCore.extensionCoreVersionName = com.baidu.fsg.face.base.b.b.f5577e;
        return extensionCore;
    }

    public static b.a b() {
        return ((b.a) ((b.a) ((b.a) new b.a().K0(new PMSAppInfo())).t1("小程序测试").q0("10985873").G0(Color.parseColor("#FF308EF0"))).D0("1230000000000000")).q1("小程序简介").w1("测试服务类目").x1("测试主体信息").s1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").z1("1.0").u1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
    }

    public static d.g c(d.b.h0.a.y0.e.b bVar, d.b.h0.a.i2.r0.b bVar2) {
        if (f45956a && bVar.j0()) {
            return d.b.a(bVar, bVar2);
        }
        if (B(bVar.d0())) {
            return d.f.a(bVar);
        }
        if (d.b.h0.a.c0.d.b.e()) {
            return d.b.h0.a.c0.d.c.a.a(bVar);
        }
        if (d.b.h0.a.c0.d.b.f()) {
            return d.b.h0.a.c0.d.e.b.a(bVar);
        }
        return null;
    }

    public static boolean d(String str, boolean z) {
        return r().getBoolean(str, z);
    }

    public static boolean e() {
        return d("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean f() {
        return d("aiapps_dashboard_enable_debug_key", false);
    }

    public static String g() {
        return r().getString("aiapps_env_data", "");
    }

    public static boolean h() {
        return d("aiapps_emit_game_core_debug_key", false);
    }

    public static boolean i() {
        return d.b.h0.a.b2.b.i();
    }

    public static String j(d.b.h0.a.y0.e.b bVar) {
        if (f45956a && bVar.j0()) {
            return d.b.e().getPath();
        }
        if (B(bVar.d0())) {
            return d.f.d().getPath();
        }
        if (d.b.h0.a.c0.d.b.e()) {
            return d.b.h0.a.c0.d.c.a.b().getPath();
        }
        return d.b.h0.a.c0.d.b.f() ? d.b.h0.a.c0.d.e.b.d().getPath() : "";
    }

    public static boolean k() {
        return d("aiapps_force_authorized_key", false);
    }

    public static boolean l() {
        return d("swan_game_fps_debug_key", false);
    }

    public static boolean m() {
        return d("aiapps_emit_https_debug_key", false);
    }

    public static boolean n() {
        return d("aiapps_js_native_switch_key", true);
    }

    public static boolean o() {
        return d("aiapps_emit_wss_debug_key", false);
    }

    public static boolean p() {
        return d("aiapps_emit_live_debug_key", false);
    }

    public static boolean q() {
        return d("aiapps_load_cts_debug_key", false);
    }

    public static d.b.h0.a.a2.g.a r() {
        if (f45957b == null) {
            synchronized (a.class) {
                if (f45957b == null) {
                    d.b.h0.a.a2.g.a aVar = new d.b.h0.a.a2.g.a("swan_app_debug");
                    f45957b = aVar;
                    aVar.f43958f.addAll(f45958c);
                }
            }
        }
        return f45957b;
    }

    public static boolean s() {
        return d("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean t() {
        return d("aiapps_server_domains_debug_key", true);
    }

    public static boolean u() {
        return d("aiapps_emit_game_launch_mode_key", false);
    }

    public static boolean v() {
        return d("aiapps_use_extension_debug_key", false);
    }

    public static boolean w() {
        return d("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean x() {
        return d("aiapps_websafe_debug_key", true);
    }

    public static boolean y(d.b.h0.a.y0.e.b bVar) {
        return (f45956a && bVar.j0()) || B(bVar.d0()) || d.b.h0.a.c0.d.b.e() || d.b.h0.a.c0.d.b.f() || (u() && bVar.Q());
    }

    public static boolean z(c cVar) {
        return (f45956a && cVar.j0()) || B(cVar.d0()) || d.b.h0.a.c0.d.b.e() || d.b.h0.a.c0.d.b.f() || (u() && cVar.Q());
    }
}
