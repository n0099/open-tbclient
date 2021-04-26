package d.a.h0.g.c0;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.j1.i;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
import d.a.h0.a.z1.k.f;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static void a(String str) {
        if (d.a.h0.a.r1.d.e().j() != 1 || d()) {
            return;
        }
        i.o("startup").A(new UbcFlowEvent(str));
    }

    public static void b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow o = i.o("startup");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                long optLong = optJSONObject.optLong("timestamp");
                if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    ubcFlowEvent.h(optLong);
                    o.A(ubcFlowEvent);
                }
            }
        }
    }

    public static long c() {
        SwanAppActivity v;
        e h2 = e.h();
        if (h2 == null || (v = h2.v()) == null) {
            return 0L;
        }
        d.a.h0.a.o0.c frame = v.getFrame();
        if (frame instanceof d.a.h0.g.m.b) {
            return ((d.a.h0.g.m.b) frame).T0();
        }
        return 0L;
    }

    public static boolean d() {
        SwanAppActivity v;
        e h2 = e.h();
        if (h2 == null || (v = h2.v()) == null) {
            return false;
        }
        d.a.h0.a.o0.c frame = v.getFrame();
        if (frame instanceof d.a.h0.g.m.b) {
            return ((d.a.h0.g.m.b) frame).X0();
        }
        return false;
    }

    public static void e(String str, b.a aVar) {
        Bundle O;
        if (aVar == null || d() || (O = aVar.O()) == null || O.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long k = aVar.k("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = new f();
        fVar.f45411a = h.n(aVar.F());
        fVar.f45415e = aVar.G();
        fVar.f45413c = aVar.S();
        fVar.f45412b = "launch";
        fVar.f45414d = "realcancel";
        fVar.r = String.valueOf(currentTimeMillis - k);
        fVar.a("reason", str);
        fVar.a("errorList", b.c().d());
        fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        h.onEvent(fVar);
        O.remove("page_display_flag_for_statistic");
    }

    public static void f(b.a aVar) {
        Bundle O;
        if (aVar == null || !d() || (O = aVar.O()) == null || O.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long k = aVar.k("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = new f();
        fVar.f45411a = h.n(aVar.F());
        fVar.f45415e = aVar.G();
        fVar.f45413c = aVar.S();
        fVar.f45412b = "launch";
        fVar.f45414d = "realsuccess";
        fVar.s = String.valueOf(currentTimeMillis - k);
        fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        h.onEvent(fVar);
        O.remove("page_display_flag_for_statistic");
    }
}
