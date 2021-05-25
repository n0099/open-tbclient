package d.a.l0.a.r1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.h0.t.a;
import d.a.l0.a.v2.m;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class i {
    public static void a(String str, @Nullable d.a.l0.a.l1.b bVar) {
        b.a N;
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || (N = i2.N()) == null) {
            return;
        }
        HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.A("appid", N.H());
        q.A("swan", d.a.l0.a.m2.b.i(N.i0(), N.G()));
        q.A("net", SwanAppNetworkUtils.f().type);
        q.A("appversion", N.u1());
        q.A("thirdversion", N.v1());
        q.A("mobile", m.c());
        q.A("scheme", N.W());
        q.A("launchid", N.V());
        q.B("from", "swan");
        q.A("web_widget_state", "0");
        q.x();
        if (bVar != null) {
            q.B("na_multi_jump_dst_path", bVar.b());
        }
    }

    public static void b(String str) {
        d.a.l0.a.m1.f.j(true);
        h.s(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("na_first_receive_action"));
        q.A("sub_state", "0");
    }

    public static void c(int i2, String str) {
        d.a.l0.a.y0.k.f.b.c(i2);
        HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        if (i2 != 6 && i2 != 4 && i2 != 1) {
            q.F(HybridUbcFlow.SubmitStrategy.ROUTE);
        } else {
            q.F(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        }
        q.B("type", Integer.valueOf(i2));
        d.a.l0.a.h0.g.f J = d.a.l0.a.g1.f.V().J();
        q.B("na_multi_jump_src_path", J != null ? J.Z2().b() : "");
    }

    public static void d(String str) {
        if (TextUtils.equals(h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).g("sub_state"), "1")) {
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void e(a.d dVar, String str) {
        h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (dVar == null) {
            return;
        }
        d.a.l0.a.p.e.b bVar = dVar.f42580a;
        if (bVar != null) {
            bVar.x(str);
        }
        HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
        ubcFlowEvent.h(dVar.f42583d);
        q.C(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
        ubcFlowEvent2.h(dVar.f42584e);
        q.C(ubcFlowEvent2);
    }

    public static void f(String str) {
        HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.C(new UbcFlowEvent("web_widget_first_screen_finish"));
        q.A("web_widget_state", "1");
        q.Q();
    }
}
