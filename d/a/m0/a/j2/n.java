package d.a.m0.a.j2;

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
    public static final boolean f46958a = d.a.m0.a.k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46959b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f46960c = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.m0.a.j2.p.c f46961a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f46962b;

        /* renamed from: c  reason: collision with root package name */
        public final long f46963c;

        /* renamed from: d  reason: collision with root package name */
        public final String f46964d;

        public a(@NonNull d.a.m0.a.j2.p.c cVar, @NonNull String str) {
            this.f46961a = cVar;
            this.f46964d = str;
            this.f46963c = cVar.l();
            synchronized (n.f46960c) {
                if (n.f46959b) {
                    n.f46960c.add(this);
                }
            }
        }
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        if ("670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(d.a.m0.a.n1.l.a()));
            if (d.a.m0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f46960c) {
                if (f46958a) {
                    Log.d("SwanReqStatisticManager", "size=" + f46960c.size());
                }
                f46959b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f46960c) {
                    if (aVar.f46963c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f46964d);
                            if (aVar.f46961a != null) {
                                aVar.f46961a.o(jSONObject);
                            }
                            if (aVar.f46962b != null) {
                                Iterator<String> keys = aVar.f46962b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f46962b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f46958a) {
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
        synchronized (f46960c) {
            f46959b = true;
            f46960c.clear();
        }
    }
}
