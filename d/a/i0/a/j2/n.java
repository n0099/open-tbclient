package d.a.i0.a.j2;

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
    public static final boolean f43000a = d.a.i0.a.k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f43001b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f43002c = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.i0.a.j2.p.c f43003a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f43004b;

        /* renamed from: c  reason: collision with root package name */
        public final long f43005c;

        /* renamed from: d  reason: collision with root package name */
        public final String f43006d;

        public a(@NonNull d.a.i0.a.j2.p.c cVar, @NonNull String str) {
            this.f43003a = cVar;
            this.f43006d = str;
            this.f43005c = cVar.l();
            synchronized (n.f43002c) {
                if (n.f43001b) {
                    n.f43002c.add(this);
                }
            }
        }
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        if ("670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(d.a.i0.a.n1.l.a()));
            if (d.a.i0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f43002c) {
                if (f43000a) {
                    Log.d("SwanReqStatisticManager", "size=" + f43002c.size());
                }
                f43001b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f43002c) {
                    if (aVar.f43005c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f43006d);
                            if (aVar.f43003a != null) {
                                aVar.f43003a.o(jSONObject);
                            }
                            if (aVar.f43004b != null) {
                                Iterator<String> keys = aVar.f43004b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f43004b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f43000a) {
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
        synchronized (f43002c) {
            f43001b = true;
            f43002c.clear();
        }
    }
}
