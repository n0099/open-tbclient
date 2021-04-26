package d.a.h0.a.g1.o.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.v1.c.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.a.g1.o.c.b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42600a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile ArrayMap<String, e> f42601b;

    /* renamed from: d.a.h0.a.g1.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0667a implements Runnable {
        public RunnableC0667a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(false);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f42602a;

        /* renamed from: d.a.h0.a.g1.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0668a implements d.a.h0.a.g1.o.b.a {
            public C0668a() {
            }

            @Override // d.a.h0.a.g1.o.b.a
            public void a() {
                if (a.f42600a) {
                    Log.d("SwanAppUpdateManager", "has scope set");
                }
                b.this.f42602a.onCallback(a.g(true));
            }
        }

        public b(d.a.h0.a.i2.u0.b bVar) {
            this.f42602a = bVar;
        }

        @Override // d.a.h0.a.g1.o.b.a
        public void a() {
            Map<String, e> g2 = a.g(true);
            if (g2.size() <= 0) {
                if (a.f42600a) {
                    Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                }
                d.a.h0.a.g1.o.a.h().B(new C0668a());
                return;
            }
            this.f42602a.onCallback(g2);
            if (a.f42600a) {
                Log.d("SwanAppUpdateManager", "callback scope set");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42604a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f42605b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42606c;

        public c(String str, d.a.h0.a.i2.u0.b bVar, String str2) {
            this.f42604a = str;
            this.f42605b = bVar;
            this.f42606c = str2;
        }

        @Override // d.a.h0.a.g1.o.b.a
        public void a() {
            a.j(this.f42604a, this.f42605b, this.f42606c);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.a.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f42608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42609c;

        public d(String str, d.a.h0.a.i2.u0.b bVar, String str2) {
            this.f42607a = str;
            this.f42608b = bVar;
            this.f42609c = str2;
        }

        @Override // d.a.h0.a.g1.o.b.a
        public void a() {
            d.a.h0.a.g1.o.d.b.f().d(this.f42607a);
            this.f42608b.onCallback(a.g(true).get(this.f42609c));
        }
    }

    public static void f() {
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "cleanAccreditListData");
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            d.a.h0.a.c0.c.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        d.a.h0.a.g1.o.a.h().x(new a());
        h2.R().A("node_data_accredit_list", "");
        l();
        d.a.h0.a.g1.o.a.h().A();
    }

    @NonNull
    public static Map<String, e> g(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = f42601b;
        if (arrayMap != null && z) {
            if (f42600a) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            d.a.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String p = h2.R().p("node_data_accredit_list", "");
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - from sp =" + p);
        if (TextUtils.isEmpty(p)) {
            d.a.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(p).optJSONObject("list");
            if (optJSONObject2 == null) {
                d.a.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.d(next, optJSONObject));
                }
            }
            f42601b = arrayMap2;
            if (f42600a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("getAccreditListData cost = ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append(" ; size = ");
                sb.append(f42601b == null ? 0 : f42601b.size());
                Log.d("SwanAppUpdateManager", sb.toString());
            }
            d.a.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e2) {
            d.a.h0.a.c0.c.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
            return arrayMap2;
        }
    }

    public static void h(@NonNull d.a.h0.a.i2.u0.b<Map<String, e>> bVar) {
        if (f42600a) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        d.a.h0.a.g1.o.a.h().z(new b(bVar));
    }

    public static void i(String str, @NonNull d.a.h0.a.i2.u0.b<e> bVar) {
        String b2 = d.a.h0.a.g1.o.d.b.f().b(str);
        boolean i2 = d.a.h0.a.j1.m.c.i();
        if (f42600a) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + i2);
        }
        if (i2) {
            j(str, bVar, b2);
        } else {
            d.a.h0.a.g1.o.a.h().z(new c(str, bVar, b2));
        }
    }

    public static void j(String str, @NonNull d.a.h0.a.i2.u0.b<e> bVar, String str2) {
        e eVar = g(true).get(str);
        if (eVar != null) {
            d.a.h0.a.g1.o.d.b.f().d(str2);
            bVar.onCallback(eVar);
            if (f42600a) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        if (f42600a) {
            Log.d("SwanAppUpdateManager", "has not scope node，required request from server");
        }
        d.a.h0.a.g1.o.a.h().B(new d(str2, bVar, str));
    }

    @Nullable
    public static e k(String str) {
        if (f42600a) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return g(true).get(str);
    }

    public static void l() {
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "resetCache");
        f42601b = null;
    }

    @Override // d.a.h0.a.g1.o.c.b
    @NonNull
    public String a() {
        return "accredit";
    }

    @Override // d.a.h0.a.g1.o.c.b
    public void b() {
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "onFail");
    }

    @Override // d.a.h0.a.g1.o.c.b
    public void c() {
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "onFiltered");
    }

    @Override // d.a.h0.a.g1.o.c.b
    public void d(JSONObject jSONObject, String str) {
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            d.a.h0.a.c0.c.h("SwanAppUpdateManager", "data is null");
            return;
        }
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            d.a.h0.a.c0.c.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        d.a.h0.a.c0.c.h("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        h2.R().A("node_data_accredit_list", jSONObject2);
        h2.R().A("cur_request_id", str);
        if (d.a.h0.a.j1.m.c.i()) {
            p.k(new RunnableC0667a(this), "updateInfoReload");
        } else {
            l();
        }
    }
}
