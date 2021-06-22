package d.a.m0.a.u.e.p;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.TbEnum;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.r1.j;
import d.a.m0.a.v2.q;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48989e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f48990f;

        public a(JSONObject jSONObject, d.a.m0.a.a2.e eVar) {
            this.f48989e = jSONObject;
            this.f48990f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-UbcFlowJar", "handlePerformMsg in thread pool");
            }
            h.s(this.f48989e, this.f48990f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f48992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.p.e.b f48993g;

        public b(String str, HybridUbcFlow hybridUbcFlow, d.a.m0.a.p.e.b bVar) {
            this.f48991e = str;
            this.f48992f = hybridUbcFlow;
            this.f48993g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.f48991e, "1")) {
                this.f48992f.P();
            } else {
                this.f48992f.z(this.f48993g);
            }
        }
    }

    public h(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public static List<UbcFlowEvent> A(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            UbcFlowEvent z = z(jSONArray.optJSONObject(i2));
            if (z != null) {
                z.e("FE");
                arrayList.add(z);
            }
        }
        return arrayList;
    }

    public static void s(JSONObject jSONObject, d.a.m0.a.a2.e eVar) {
        int i2;
        String str;
        d.a.m0.a.h0.l.a P = d.a.m0.a.h0.u.g.N().P();
        if (P instanceof d.a.m0.a.h0.l.e) {
            i2 = ((d.a.m0.a.h0.l.e) P).k();
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i2);
            }
        } else {
            i2 = 0;
        }
        d.a.m0.a.j2.e.C(true);
        d.a.m0.a.j2.e.r();
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        d.a.m0.a.p.e.b bVar = null;
        String str2 = "0";
        if (optJSONObject != null) {
            str2 = optJSONObject.optString("hasWebView", "0");
            str = optJSONObject.optString("hasRelaunch");
            d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(optJSONObject.optString("slaveId"));
            if (B instanceof d.a.m0.a.p.e.b) {
                bVar = (d.a.m0.a.p.e.b) B;
            }
        } else {
            str = "";
        }
        if (TextUtils.equals(str2, "1")) {
            HybridUbcFlow.SubmitStrategy h2 = p.h();
            if (h2 == HybridUbcFlow.SubmitStrategy.HYBRID) {
                p.F(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (h2 == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str, "none")) {
            if (TextUtils.equals(str2, "1")) {
                p.P();
            } else {
                p.z(bVar);
            }
        }
        t(p, eVar, str2, bVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        p.A("codecache", String.valueOf(i2));
        p.D(A(optJSONArray));
        p.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t(HybridUbcFlow hybridUbcFlow, d.a.m0.a.a2.e eVar, String str, @Nullable d.a.m0.a.p.e.b bVar) {
        long j;
        if (hybridUbcFlow == null || eVar == null) {
            return;
        }
        if (!d.a.m0.a.h0.u.g.N().f0()) {
            if (TextUtils.equals(str, "1")) {
                hybridUbcFlow.P();
                return;
            } else {
                hybridUbcFlow.z(bVar);
                return;
            }
        }
        long K = d.a.m0.a.c1.a.Z().K();
        if (K <= 0) {
            return;
        }
        b.a N = eVar.N();
        boolean z = false;
        if (N != null) {
            long currentTimeMillis = System.currentTimeMillis() - N.N();
            if (currentTimeMillis < K) {
                j = K - currentTimeMillis;
                if (z) {
                    if (j <= 0) {
                        return;
                    }
                    q.c(new b(str, hybridUbcFlow, bVar), "waitFcp", j, TimeUnit.MILLISECONDS);
                    return;
                } else if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.P();
                    return;
                } else {
                    hybridUbcFlow.z(bVar);
                    return;
                }
            }
            z = true;
        }
        j = 0;
        if (z) {
        }
    }

    public static void u(JSONObject jSONObject, d.a.m0.a.a2.e eVar) {
        ExecutorUtilsExt.postOnElastic(new a(jSONObject, eVar), "handlePerformMsg", 2);
    }

    public static void v(JSONObject jSONObject) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-UbcFlowJar", "upload swan app render log");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() >= 1) {
            j.e().c(optJSONArray.optJSONObject(0));
        } else if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-UbcFlowJar", "Render monitor log is null");
        }
    }

    public static void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ext")) == null) {
            return;
        }
        String optString = optJSONObject.optString("routeId");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        HybridUbcFlow q = d.a.m0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.F(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.D(A(jSONObject.optJSONArray("data")));
        q.l();
        d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(optJSONObject.optString("slaveId"));
        if (B instanceof SwanAppSlaveManager) {
            ((SwanAppSlaveManager) B).h1();
        }
    }

    public static void x(@Nullable JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowJarAction-671: ");
        sb.append(jSONArray == null ? StringUtil.NULL_STRING : jSONArray);
        d.a.m0.a.e0.d.h("Api-UbcFlowJar", sb.toString());
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                    d.a.m0.a.i2.a.d().h(jSONObject);
                } else {
                    d.a.m0.a.i2.a.d().k(jSONObject);
                }
            } catch (JSONException e2) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    Log.w("Api-UbcFlowJar", "FlowJarAction-671: " + Log.getStackTraceString(e2));
                }
            }
        }
    }

    public static void y(JSONArray jSONArray) {
        d.a.m0.a.h0.g.f J = d.a.m0.a.g1.f.V().J();
        if (J == null) {
            return;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString = jSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                long j = 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        j = Long.valueOf(optString).longValue();
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                J.y3(new d.a.m0.a.j2.p.g(string, j));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static UbcFlowEvent z(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
        ubcFlowEvent.h(optLong);
        return ubcFlowEvent;
    }

    public d.a.m0.a.u.h.b B(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return new d.a.m0.a.u.h.b(1001, "swan app is null");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-UbcFlowJar", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-UbcFlowJar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.m0.a.u.h.b(201, "empty flowId");
        }
        char c2 = 65535;
        switch (optString.hashCode()) {
            case 53647:
                if (optString.equals("670")) {
                    c2 = 0;
                    break;
                }
                break;
            case 53648:
                if (optString.equals("671")) {
                    c2 = 2;
                    break;
                }
                break;
            case 55357:
                if (optString.equals("805")) {
                    c2 = 1;
                    break;
                }
                break;
            case 56506:
                if (optString.equals("967")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1529139648:
                if (optString.equals("renderMonitorLog")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            u(jSONObject, i2);
        } else if (c2 == 1) {
            y(jSONObject.optJSONArray("data"));
        } else if (c2 == 2) {
            x(jSONObject.optJSONArray("data"));
        } else if (c2 == 3) {
            w(jSONObject);
        } else if (c2 != 4) {
            return new d.a.m0.a.u.h.b(201, "unknown flowId");
        } else {
            v(jSONObject);
        }
        return new d.a.m0.a.u.h.b(0);
    }
}
