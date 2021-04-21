package d.b.h0.a.t.c.n;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.tbadk.core.util.TbEnum;
import d.b.h0.a.i2.p;
import d.b.h0.a.j1.i;
import d.b.h0.a.j1.k;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.k.g;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f46927f;

        public a(JSONObject jSONObject, d.b.h0.a.r1.e eVar) {
            this.f46926e = jSONObject;
            this.f46927f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-UbcFlowJar", "handlePerformMsg in thread pool");
            }
            f.r(this.f46926e, this.f46927f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f46929f;

        public b(String str, HybridUbcFlow hybridUbcFlow) {
            this.f46928e = str;
            this.f46929f = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.f46928e, "1")) {
                this.f46929f.N();
            } else {
                this.f46929f.x();
            }
        }
    }

    public f(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static List<UbcFlowEvent> A(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent z = z(jSONArray.optJSONObject(i));
            if (z != null) {
                z.e("FE");
                arrayList.add(z);
            }
        }
        return arrayList;
    }

    public static void r(JSONObject jSONObject, d.b.h0.a.r1.e eVar) {
        int i;
        String str;
        d.b.h0.a.e0.o.a N = d.b.h0.a.e0.w.d.L().N();
        if (N instanceof d.b.h0.a.e0.o.e) {
            i = ((d.b.h0.a.e0.o.e) N).k();
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        } else {
            i = 0;
        }
        d.b.h0.a.z1.e.z(true);
        d.b.h0.a.z1.e.o();
        HybridUbcFlow o = i.o("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str2 = "0";
        if (optJSONObject != null) {
            str2 = optJSONObject.optString("hasWebView", "0");
            str = optJSONObject.optString("hasRelaunch");
        } else {
            str = "";
        }
        if (TextUtils.equals(str2, "1")) {
            HybridUbcFlow.SubmitStrategy h2 = o.h();
            if (h2 == HybridUbcFlow.SubmitStrategy.HYBRID) {
                o.D(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (h2 == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                o.D(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str, "none")) {
            if (TextUtils.equals(str2, "1")) {
                o.N();
            } else {
                o.x();
            }
        }
        t(o, eVar, str2);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        o.y("codecache", String.valueOf(i));
        o.B(A(optJSONArray));
        o.k();
    }

    public static void s(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-UbcFlowJar", "SearchFlowEvent from FE, data: " + jSONArray);
        }
        try {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString2 = optJSONObject.optString("errorType");
                String optString3 = optJSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                SearchFlowEvent searchFlowEvent = new SearchFlowEvent(optString);
                searchFlowEvent.f12321b = Long.valueOf(optString3).longValue();
                searchFlowEvent.f12322c = optString2;
                searchFlowEvent.f12324e = SearchFlowEvent.EventType.END;
                d.b.h0.a.z1.l.b.a(searchFlowEvent);
            }
        } catch (NumberFormatException e2) {
            if (d.b.h0.a.t.b.d.f46650c) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t(HybridUbcFlow hybridUbcFlow, d.b.h0.a.r1.e eVar, String str) {
        long j;
        if (hybridUbcFlow == null || eVar == null) {
            return;
        }
        if (!d.b.h0.a.e0.w.d.L().c0()) {
            if (TextUtils.equals(str, "1")) {
                hybridUbcFlow.N();
                return;
            } else {
                hybridUbcFlow.x();
                return;
            }
        }
        long N = d.b.h0.a.w0.a.N().N();
        if (N <= 0) {
            return;
        }
        b.a L = eVar.L();
        boolean z = false;
        if (L != null) {
            long currentTimeMillis = System.currentTimeMillis() - L.M();
            if (currentTimeMillis < N) {
                j = N - currentTimeMillis;
                if (z) {
                    if (j <= 0) {
                        return;
                    }
                    p.c(new b(str, hybridUbcFlow), "waitFcp", j, TimeUnit.MILLISECONDS);
                    return;
                } else if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.N();
                    return;
                } else {
                    hybridUbcFlow.x();
                    return;
                }
            }
            z = true;
        }
        j = 0;
        if (z) {
        }
    }

    public static void u(JSONObject jSONObject, d.b.h0.a.r1.e eVar) {
        ExecutorUtilsExt.postOnElastic(new a(jSONObject, eVar), "handlePerformMsg", 2);
    }

    public static void v(JSONObject jSONObject) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-UbcFlowJar", "upload swan app render log");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() >= 1) {
            k.e().c(optJSONArray.optJSONObject(0));
        } else if (d.b.h0.a.t.b.d.f46650c) {
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
        HybridUbcFlow p = i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            p.D(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        p.B(A(jSONObject.optJSONArray("data")));
        p.k();
    }

    public static void x(@Nullable JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowJarAction-671: ");
        sb.append(jSONArray == null ? StringUtil.NULL_STRING : jSONArray);
        d.b.h0.a.c0.c.h("Api-UbcFlowJar", sb.toString());
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                    d.b.h0.a.y1.a.d().h(jSONObject);
                } else {
                    d.b.h0.a.y1.a.d().k(jSONObject);
                }
            } catch (JSONException e2) {
                if (d.b.h0.a.t.b.d.f46650c) {
                    Log.w("Api-UbcFlowJar", "FlowJarAction-671: " + Log.getStackTraceString(e2));
                }
            }
        }
    }

    public static void y(JSONArray jSONArray) {
        d.b.h0.a.e0.l.e A = d.b.h0.a.z0.f.V().A();
        if (A == null) {
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
                A.n3(new g(string, j));
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

    public d.b.h0.a.t.e.b B(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            return new d.b.h0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-UbcFlowJar", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-UbcFlowJar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.h0.a.t.e.b(201, "empty flowId");
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
                    c2 = 3;
                    break;
                }
                break;
            case 54610:
                if (optString.equals("772")) {
                    c2 = 1;
                    break;
                }
                break;
            case 55357:
                if (optString.equals("805")) {
                    c2 = 2;
                    break;
                }
                break;
            case 56506:
                if (optString.equals("967")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1529139648:
                if (optString.equals("renderMonitorLog")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            u(jSONObject, y);
        } else if (c2 == 1) {
            s(jSONObject.optJSONArray("data"));
        } else if (c2 == 2) {
            y(jSONObject.optJSONArray("data"));
        } else if (c2 == 3) {
            x(jSONObject.optJSONArray("data"));
        } else if (c2 == 4) {
            w(jSONObject);
        } else if (c2 != 5) {
            return new d.b.h0.a.t.e.b(201, "unknown flowId");
        } else {
            v(jSONObject);
        }
        return new d.b.h0.a.t.e.b(0);
    }
}
