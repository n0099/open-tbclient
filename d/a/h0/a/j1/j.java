package d.a.h0.a.j1;

import android.text.TextUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.y0.e.b;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class j {
    public static void a(String str) {
        b.a L;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || (L = h2.L()) == null) {
            return;
        }
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.y("appid", L.G());
        p.y("launchid", L.U());
        p.z("from", "swan");
        p.y("web_widget_state", "0");
        p.w();
    }

    public static void b(String str) {
        d.a.h0.a.f1.e.j(true);
        d.a.h0.a.s0.k.f.b.c();
        i.r(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("na_first_receive_action"));
        p.y("sub_state", "0");
    }

    public static void c(int i2, String str) {
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        if (i2 != 6 && i2 != 4 && i2 != 1) {
            p.D(HybridUbcFlow.SubmitStrategy.ROUTE);
        } else {
            p.D(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        }
        p.z("type", Integer.valueOf(i2));
    }

    public static void d(String str) {
        if (TextUtils.equals(i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).g("sub_state"), "1")) {
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void e(b.c cVar, String str) {
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (cVar == null) {
            return;
        }
        d.a.h0.a.p.d.b bVar = cVar.f42331a;
        if (bVar != null) {
            bVar.v(str);
        }
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
        ubcFlowEvent.h(cVar.f42334d);
        p.A(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
        ubcFlowEvent2.h(cVar.f42335e);
        p.A(ubcFlowEvent2);
    }

    public static void f(String str) {
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        p.A(new UbcFlowEvent("web_widget_first_screen_finish"));
        p.y("web_widget_state", "1");
        p.O();
    }
}
