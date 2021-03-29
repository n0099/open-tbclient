package d.b.g0.a.g1.o.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.v1.c.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.g0.a.g1.o.c.b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44565a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile ArrayMap<String, e> f44566b;

    /* renamed from: d.b.g0.a.g1.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0696a implements Runnable {
        public RunnableC0696a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(false);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.b.g0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f44567a;

        /* renamed from: d.b.g0.a.g1.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0697a implements d.b.g0.a.g1.o.b.a {
            public C0697a() {
            }

            @Override // d.b.g0.a.g1.o.b.a
            public void a() {
                if (a.f44565a) {
                    Log.d("SwanAppUpdateManager", "has scope set");
                }
                b.this.f44567a.onCallback(a.g(true));
            }
        }

        public b(d.b.g0.a.i2.u0.b bVar) {
            this.f44567a = bVar;
        }

        @Override // d.b.g0.a.g1.o.b.a
        public void a() {
            Map<String, e> g2 = a.g(true);
            if (g2.size() <= 0) {
                if (a.f44565a) {
                    Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                }
                d.b.g0.a.g1.o.a.h().B(new C0697a());
                return;
            }
            this.f44567a.onCallback(g2);
            if (a.f44565a) {
                Log.d("SwanAppUpdateManager", "callback scope set");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.b.g0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44569a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f44570b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44571c;

        public c(String str, d.b.g0.a.i2.u0.b bVar, String str2) {
            this.f44569a = str;
            this.f44570b = bVar;
            this.f44571c = str2;
        }

        @Override // d.b.g0.a.g1.o.b.a
        public void a() {
            a.j(this.f44569a, this.f44570b, this.f44571c);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements d.b.g0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f44573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44574c;

        public d(String str, d.b.g0.a.i2.u0.b bVar, String str2) {
            this.f44572a = str;
            this.f44573b = bVar;
            this.f44574c = str2;
        }

        @Override // d.b.g0.a.g1.o.b.a
        public void a() {
            d.b.g0.a.g1.o.d.b.f().d(this.f44572a);
            this.f44573b.onCallback(a.g(true).get(this.f44574c));
        }
    }

    public static void f() {
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "cleanAccreditListData");
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            d.b.g0.a.c0.c.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        d.b.g0.a.g1.o.a.h().x(new a());
        y.R().A("node_data_accredit_list", "");
        l();
        d.b.g0.a.g1.o.a.h().A();
    }

    @NonNull
    public static Map<String, e> g(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = f44566b;
        if (arrayMap != null && z) {
            if (f44565a) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            d.b.g0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String p = y.R().p("node_data_accredit_list", "");
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - from sp =" + p);
        if (TextUtils.isEmpty(p)) {
            d.b.g0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(p).optJSONObject("list");
            if (optJSONObject2 == null) {
                d.b.g0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.d(next, optJSONObject));
                }
            }
            f44566b = arrayMap2;
            if (f44565a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("getAccreditListData cost = ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append(" ; size = ");
                sb.append(f44566b == null ? 0 : f44566b.size());
                Log.d("SwanAppUpdateManager", sb.toString());
            }
            d.b.g0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e2) {
            d.b.g0.a.c0.c.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
            return arrayMap2;
        }
    }

    public static void h(@NonNull d.b.g0.a.i2.u0.b<Map<String, e>> bVar) {
        if (f44565a) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        d.b.g0.a.g1.o.a.h().z(new b(bVar));
    }

    public static void i(String str, @NonNull d.b.g0.a.i2.u0.b<e> bVar) {
        String b2 = d.b.g0.a.g1.o.d.b.f().b(str);
        boolean i = d.b.g0.a.j1.m.c.i();
        if (f44565a) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + i);
        }
        if (i) {
            j(str, bVar, b2);
        } else {
            d.b.g0.a.g1.o.a.h().z(new c(str, bVar, b2));
        }
    }

    public static void j(String str, @NonNull d.b.g0.a.i2.u0.b<e> bVar, String str2) {
        e eVar = g(true).get(str);
        if (eVar != null) {
            d.b.g0.a.g1.o.d.b.f().d(str2);
            bVar.onCallback(eVar);
            if (f44565a) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        if (f44565a) {
            Log.d("SwanAppUpdateManager", "has not scope node，required request from server");
        }
        d.b.g0.a.g1.o.a.h().B(new d(str2, bVar, str));
    }

    @Nullable
    public static e k(String str) {
        if (f44565a) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return g(true).get(str);
    }

    public static void l() {
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "resetCache");
        f44566b = null;
    }

    @Override // d.b.g0.a.g1.o.c.b
    @NonNull
    public String a() {
        return "accredit";
    }

    @Override // d.b.g0.a.g1.o.c.b
    public void b() {
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "onFail");
    }

    @Override // d.b.g0.a.g1.o.c.b
    public void c() {
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "onFiltered");
    }

    @Override // d.b.g0.a.g1.o.c.b
    public void d(JSONObject jSONObject, String str) {
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            d.b.g0.a.c0.c.h("SwanAppUpdateManager", "data is null");
            return;
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            d.b.g0.a.c0.c.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        d.b.g0.a.c0.c.h("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        y.R().A("node_data_accredit_list", jSONObject2);
        y.R().A("cur_request_id", str);
        if (d.b.g0.a.j1.m.c.i()) {
            p.k(new RunnableC0696a(this), "updateInfoReload");
        } else {
            l();
        }
    }
}
