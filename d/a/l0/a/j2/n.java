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
    public static final boolean f43174a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f43175b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f43176c = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.l0.a.j2.p.c f43177a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f43178b;

        /* renamed from: c  reason: collision with root package name */
        public final long f43179c;

        /* renamed from: d  reason: collision with root package name */
        public final String f43180d;

        public a(@NonNull d.a.l0.a.j2.p.c cVar, @NonNull String str) {
            this.f43177a = cVar;
            this.f43180d = str;
            this.f43179c = cVar.l();
            synchronized (n.f43176c) {
                if (n.f43175b) {
                    n.f43176c.add(this);
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
            synchronized (f43176c) {
                if (f43174a) {
                    Log.d("SwanReqStatisticManager", "size=" + f43176c.size());
                }
                f43175b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f43176c) {
                    if (aVar.f43179c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f43180d);
                            if (aVar.f43177a != null) {
                                aVar.f43177a.o(jSONObject);
                            }
                            if (aVar.f43178b != null) {
                                Iterator<String> keys = aVar.f43178b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f43178b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f43174a) {
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
        synchronized (f43176c) {
            f43175b = true;
            f43176c.clear();
        }
    }
}
