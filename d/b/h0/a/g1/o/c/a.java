package d.b.h0.a.g1.o.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import d.b.h0.a.v1.c.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.h0.a.g1.o.c.b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45286a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile ArrayMap<String, e> f45287b;

    /* renamed from: d.b.h0.a.g1.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0728a implements Runnable {
        public RunnableC0728a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(false);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.b.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f45288a;

        /* renamed from: d.b.h0.a.g1.o.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0729a implements d.b.h0.a.g1.o.b.a {
            public C0729a() {
            }

            @Override // d.b.h0.a.g1.o.b.a
            public void a() {
                if (a.f45286a) {
                    Log.d("SwanAppUpdateManager", "has scope set");
                }
                b.this.f45288a.onCallback(a.g(true));
            }
        }

        public b(d.b.h0.a.i2.u0.b bVar) {
            this.f45288a = bVar;
        }

        @Override // d.b.h0.a.g1.o.b.a
        public void a() {
            Map<String, e> g2 = a.g(true);
            if (g2.size() <= 0) {
                if (a.f45286a) {
                    Log.d("SwanAppUpdateManager", "has not scope set，required request from server");
                }
                d.b.h0.a.g1.o.a.h().B(new C0729a());
                return;
            }
            this.f45288a.onCallback(g2);
            if (a.f45286a) {
                Log.d("SwanAppUpdateManager", "callback scope set");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.b.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45290a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f45291b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45292c;

        public c(String str, d.b.h0.a.i2.u0.b bVar, String str2) {
            this.f45290a = str;
            this.f45291b = bVar;
            this.f45292c = str2;
        }

        @Override // d.b.h0.a.g1.o.b.a
        public void a() {
            a.j(this.f45290a, this.f45291b, this.f45292c);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements d.b.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f45294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45295c;

        public d(String str, d.b.h0.a.i2.u0.b bVar, String str2) {
            this.f45293a = str;
            this.f45294b = bVar;
            this.f45295c = str2;
        }

        @Override // d.b.h0.a.g1.o.b.a
        public void a() {
            d.b.h0.a.g1.o.d.b.f().d(this.f45293a);
            this.f45294b.onCallback(a.g(true).get(this.f45295c));
        }
    }

    public static void f() {
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "cleanAccreditListData");
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            d.b.h0.a.c0.c.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        d.b.h0.a.g1.o.a.h().x(new a());
        y.R().A("node_data_accredit_list", "");
        l();
        d.b.h0.a.g1.o.a.h().A();
    }

    @NonNull
    public static Map<String, e> g(boolean z) {
        JSONObject optJSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap<String, e> arrayMap = f45287b;
        if (arrayMap != null && z) {
            if (f45286a) {
                Log.d("SwanAppUpdateManager", "getAccreditListData from cache, size = " + arrayMap.size());
            }
            return arrayMap;
        }
        ArrayMap<String, e> arrayMap2 = new ArrayMap<>();
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            d.b.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap2;
        }
        String p = y.R().p("node_data_accredit_list", "");
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - from sp =" + p);
        if (TextUtils.isEmpty(p)) {
            d.b.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap2;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(p).optJSONObject("list");
            if (optJSONObject2 == null) {
                d.b.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap2;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap2.put(next, e.d(next, optJSONObject));
                }
            }
            f45287b = arrayMap2;
            if (f45286a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("getAccreditListData cost = ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append(" ; size = ");
                sb.append(f45287b == null ? 0 : f45287b.size());
                Log.d("SwanAppUpdateManager", sb.toString());
            }
            d.b.h0.a.c0.c.h("SwanAppUpdateManager", "getAccreditListData - from json");
            return arrayMap2;
        } catch (JSONException e2) {
            d.b.h0.a.c0.c.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
            return arrayMap2;
        }
    }

    public static void h(@NonNull d.b.h0.a.i2.u0.b<Map<String, e>> bVar) {
        if (f45286a) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        d.b.h0.a.g1.o.a.h().z(new b(bVar));
    }

    public static void i(String str, @NonNull d.b.h0.a.i2.u0.b<e> bVar) {
        String b2 = d.b.h0.a.g1.o.d.b.f().b(str);
        boolean i = d.b.h0.a.j1.m.c.i();
        if (f45286a) {
            Log.d("SwanAppUpdateManager", "API get scope info, scopeId = " + str + " ; isUpdateAsyncAb = " + i);
        }
        if (i) {
            j(str, bVar, b2);
        } else {
            d.b.h0.a.g1.o.a.h().z(new c(str, bVar, b2));
        }
    }

    public static void j(String str, @NonNull d.b.h0.a.i2.u0.b<e> bVar, String str2) {
        e eVar = g(true).get(str);
        if (eVar != null) {
            d.b.h0.a.g1.o.d.b.f().d(str2);
            bVar.onCallback(eVar);
            if (f45286a) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        if (f45286a) {
            Log.d("SwanAppUpdateManager", "has not scope node，required request from server");
        }
        d.b.h0.a.g1.o.a.h().B(new d(str2, bVar, str));
    }

    @Nullable
    public static e k(String str) {
        if (f45286a) {
            Log.d("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        }
        return g(true).get(str);
    }

    public static void l() {
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "resetCache");
        f45287b = null;
    }

    @Override // d.b.h0.a.g1.o.c.b
    @NonNull
    public String a() {
        return "accredit";
    }

    @Override // d.b.h0.a.g1.o.c.b
    public void b() {
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "onFail");
    }

    @Override // d.b.h0.a.g1.o.c.b
    public void c() {
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "onFiltered");
    }

    @Override // d.b.h0.a.g1.o.c.b
    public void d(JSONObject jSONObject, String str) {
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            d.b.h0.a.c0.c.h("SwanAppUpdateManager", "data is null");
            return;
        }
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            d.b.h0.a.c0.c.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        d.b.h0.a.c0.c.h("SwanAppUpdateManager", "onUpdate data = " + jSONObject2);
        y.R().A("node_data_accredit_list", jSONObject2);
        y.R().A("cur_request_id", str);
        if (d.b.h0.a.j1.m.c.i()) {
            p.k(new RunnableC0728a(this), "updateInfoReload");
        } else {
            l();
        }
    }
}
