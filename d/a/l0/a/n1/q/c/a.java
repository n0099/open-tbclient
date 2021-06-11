package d.a.l0.a.n1.q.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.f;
import d.a.l0.a.k;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.n1.q.c.b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47421a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, ArrayMap<String, f>> f47422b = new LruCache<>(6);

    /* renamed from: d.a.l0.a.n1.q.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0822a implements d.a.l0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f47423a;

        /* renamed from: d.a.l0.a.n1.q.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0823a implements d.a.l0.a.n1.q.b.a {
            public C0823a() {
            }

            @Override // d.a.l0.a.n1.q.b.a
            public void a() {
                if (a.f47421a) {
                    Log.d("SwanAppUpdateManager", "has scope set");
                }
                C0822a.this.f47423a.onCallback(a.g(true));
            }
        }

        public C0822a(d.a.l0.a.v2.e1.b bVar) {
            this.f47423a = bVar;
        }

        @Override // d.a.l0.a.n1.q.b.a
        public void a() {
            Map<String, f> g2 = a.g(true);
            if (g2.size() > 0) {
                this.f47423a.onCallback(g2);
                if (a.f47421a) {
                    Log.d("SwanAppUpdateManager", "callback scope set");
                    return;
                }
                return;
            }
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "has not scope set，required request from server");
            d.a.l0.a.n1.q.a.g().B(new C0823a());
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47425a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f47426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47427c;

        public b(String str, d.a.l0.a.v2.e1.b bVar, String str2) {
            this.f47425a = str;
            this.f47426b = bVar;
            this.f47427c = str2;
        }

        @Override // d.a.l0.a.n1.q.b.a
        public void a() {
            d.a.l0.a.n1.q.d.b.f().d(this.f47425a);
            this.f47426b.onCallback(a.g(true).get(this.f47427c));
        }
    }

    public static void f() {
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "cleanAccreditListData");
        e i2 = e.i();
        if (i2 == null) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", cleanAccredit");
        d.a.l0.a.n1.q.a.g().w(new a());
        i2.T().B("node_data_accredit_list", "");
        o();
        d.a.l0.a.n1.q.a.g().A();
    }

    @NonNull
    public static Map<String, f> g(boolean z) {
        ArrayMap<String, f> l = l();
        if (l != null && z) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData from cache, size = " + l.size());
            return l;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayMap arrayMap = new ArrayMap();
        e i2 = e.i();
        if (i2 == null) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
            return arrayMap;
        }
        String q = i2.T().q("node_data_accredit_list", "");
        String q2 = i2.T().q("cur_request_id", "");
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", requestId: " + q2 + ", getAccreditListData - from sp =" + q);
        if (TextUtils.isEmpty(q)) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
            return arrayMap;
        }
        try {
            ArrayMap<String, f> m = m(new JSONObject(q));
            if (f47421a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("getAccreditListData cost = ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append(" ; size = ");
                LruCache<String, ArrayMap<String, f>> lruCache = f47422b;
                sb.append(lruCache == null ? 0 : lruCache.size());
                Log.d("SwanAppUpdateManager", sb.toString());
            }
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - from json");
            return m;
        } catch (JSONException e2) {
            d.a.l0.a.e0.d.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
            return arrayMap;
        }
    }

    public static void h(@NonNull d.a.l0.a.v2.e1.b<Map<String, f>> bVar) {
        if (f47421a) {
            Log.d("SwanAppUpdateManager", "API get scope set");
        }
        d.a.l0.a.n1.q.a.g().z(new C0822a(bVar));
    }

    public static void i(String str, @NonNull d.a.l0.a.v2.e1.b<f> bVar) {
        j(str, bVar, d.a.l0.a.n1.q.d.b.f().b(str));
    }

    public static void j(String str, @NonNull d.a.l0.a.v2.e1.b<f> bVar, String str2) {
        f fVar = g(true).get(str);
        if (fVar != null) {
            d.a.l0.a.n1.q.d.b.f().d(str2);
            bVar.onCallback(fVar);
            if (f47421a) {
                Log.d("SwanAppUpdateManager", "callback scope node");
                return;
            }
            return;
        }
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "has not scope node，required request from server");
        d.a.l0.a.n1.q.a.g().B(new b(str2, bVar, str));
    }

    @Nullable
    public static f k(String str) {
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
        return g(true).get(str);
    }

    public static ArrayMap<String, f> l() {
        e Q = e.Q();
        if (Q == null || TextUtils.isEmpty(Q.f44425f)) {
            return null;
        }
        return f47422b.get(Q.f44425f);
    }

    public static ArrayMap<String, f> m(JSONObject jSONObject) {
        JSONObject optJSONObject;
        ArrayMap<String, f> arrayMap = new ArrayMap<>();
        if (jSONObject == null) {
            return arrayMap;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
        if (optJSONObject2 == null) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
            return arrayMap;
        }
        Iterator<String> keys = optJSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                arrayMap.put(next, f.d(next, optJSONObject));
            }
        }
        n(arrayMap);
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "parseScopeInfoMap to cache");
        return arrayMap;
    }

    public static void n(ArrayMap<String, f> arrayMap) {
        e Q;
        if (arrayMap == null || arrayMap.size() <= 0 || (Q = e.Q()) == null || TextUtils.isEmpty(Q.f44425f)) {
            return;
        }
        f47422b.put(Q.f44425f, arrayMap);
    }

    public static void o() {
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "resetCache");
        f47422b.evictAll();
    }

    @Override // d.a.l0.a.n1.q.c.b
    @NonNull
    public String a() {
        return "accredit";
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void b() {
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "onFail");
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void c() {
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "onFiltered");
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "onUpdate ");
        if (jSONObject == null) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "data is null");
            return;
        }
        e i2 = e.i();
        if (i2 == null) {
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        d.a.l0.a.e0.d.h("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + i2.T().p() + ", putAccredit = " + jSONObject2);
        i2.T().B("node_data_accredit_list", jSONObject2);
        d.a.l0.a.e2.a T = i2.T();
        T.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
        o();
    }
}
