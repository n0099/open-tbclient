package d.a.m0.h.f0;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.k;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public static void a(String str) {
        if (d.a.m0.a.a2.d.g().l() != 1 || d()) {
            return;
        }
        d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent(str));
    }

    public static void b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                long optLong = optJSONObject.optLong("timestamp");
                if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    ubcFlowEvent.h(optLong);
                    p.C(ubcFlowEvent);
                }
            }
        }
    }

    public static long c() {
        SwanAppActivity x;
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || (x = i2.x()) == null) {
            return 0L;
        }
        d.a.m0.a.t0.c frame = x.getFrame();
        if (frame instanceof d.a.m0.h.o.d) {
            return ((d.a.m0.h.o.d) frame).W0();
        }
        return 0L;
    }

    public static boolean d() {
        SwanAppActivity x;
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || (x = i2.x()) == null) {
            return false;
        }
        d.a.m0.a.t0.c frame = x.getFrame();
        if (frame instanceof d.a.m0.h.o.d) {
            return ((d.a.m0.h.o.d) frame).a1();
        }
        return false;
    }

    public static void e(String str, b.a aVar) {
        Bundle P;
        if (aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = k.m(aVar.G());
        fVar.f46974f = aVar.H();
        fVar.f46971c = aVar.T();
        fVar.f46970b = "launch";
        fVar.f46973e = "realcancel";
        fVar.q = String.valueOf(currentTimeMillis - l);
        fVar.a("reason", str);
        fVar.a("errorList", b.c().d());
        fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        k.onEvent(fVar);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(b.a aVar) {
        Bundle P;
        if (aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = k.m(aVar.G());
        fVar.f46974f = aVar.H();
        fVar.f46971c = aVar.T();
        fVar.f46970b = "launch";
        fVar.f46973e = "realsuccess";
        fVar.r = String.valueOf(currentTimeMillis - l);
        fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        k.onEvent(fVar);
        P.remove("page_display_flag_for_statistic");
    }
}
