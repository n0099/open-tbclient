package d.a.l0.a.j2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46850a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46851b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f46852c = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.l0.a.j2.p.c f46853a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f46854b;

        /* renamed from: c  reason: collision with root package name */
        public final long f46855c;

        /* renamed from: d  reason: collision with root package name */
        public final String f46856d;

        public a(@NonNull d.a.l0.a.j2.p.c cVar, @NonNull String str) {
            this.f46853a = cVar;
            this.f46856d = str;
            this.f46855c = cVar.l();
            synchronized (n.f46852c) {
                if (n.f46851b) {
                    n.f46852c.add(this);
                }
            }
        }
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        if ("670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(d.a.l0.a.n1.l.a()));
            if (d.a.l0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f46852c) {
                if (f46850a) {
                    Log.d("SwanReqStatisticManager", "size=" + f46852c.size());
                }
                f46851b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f46852c) {
                    if (aVar.f46855c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f46856d);
                            if (aVar.f46853a != null) {
                                aVar.f46853a.o(jSONObject);
                            }
                            if (aVar.f46854b != null) {
                                Iterator<String> keys = aVar.f46854b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f46854b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f46850a) {
                                Log.e("SwanReqStatisticManager", "appendRequestRecord", e2);
                            }
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    hybridUbcFlow.A("requests", jSONArray.toString());
                }
            }
        }
    }

    public static void d() {
        synchronized (f46852c) {
            f46851b = true;
            f46852c.clear();
        }
    }
}
