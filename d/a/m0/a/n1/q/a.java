package d.a.m0.a.n1.q;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.m0.a.a2.e;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import d.a.m0.a.n1.q.c.c;
import d.a.m0.a.v2.w;
import d.a.m0.n.j.i.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47518d = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47519e;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.m0.a.n1.q.c.b> f47520a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f47521b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.m0.a.n1.q.b.a> f47522c;

    /* renamed from: d.a.m0.a.n1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0824a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f47524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f47525c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47526d;

        public C0824a(String str, List list, ArrayMap arrayMap, String str2) {
            this.f47523a = str;
            this.f47524b = list;
            this.f47525c = arrayMap;
            this.f47526d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.d(this.f47524b);
            d.i("SwanAppUpdateManager", "update request failure: ", exc);
            d.a.m0.a.j2.k.w(this.f47526d, -1, exc.toString());
            d.a.m0.a.j2.q.a.b(SwanInterfaceType.UPDATE, 2101, this.f47526d, null, exc.getMessage());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            String appId = d.a.m0.a.a2.d.g().getAppId();
            if (TextUtils.equals(this.f47523a, appId)) {
                a.this.s(this.f47523a, response, this.f47524b, this.f47525c);
                d.h("SwanAppUpdateManager", "response code = " + response.code());
                if (!response.isSuccessful()) {
                    d.a.m0.a.j2.k.w(this.f47526d, response.code(), response.message());
                }
                return response;
            }
            d.h("SwanAppUpdateManager", "invalid response requestAppId:" + this.f47523a + ";currentAppId:" + appId);
            a.this.d(this.f47524b);
            a.x(this.f47523a);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.n1.q.b.a f47528e;

        public b(a aVar, d.a.m0.a.n1.q.b.a aVar2) {
            this.f47528e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47528e.a();
        }
    }

    public a() {
        k();
    }

    public static a g() {
        if (f47519e == null) {
            synchronized (a.class) {
                if (f47519e == null) {
                    f47519e = new a();
                }
            }
        }
        return f47519e;
    }

    public static void x(String str) {
        e Q = e.Q();
        if (Q == null) {
            return;
        }
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(5L);
        aVar.h(53L);
        d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(Q.L());
        dVar.q(d.a.m0.a.j2.k.m(Q.l()));
        dVar.m(Q.getAppId());
        dVar.a("requestAppId", str);
        d.a.m0.a.j2.k.L(dVar);
    }

    public void A() {
        B(null);
    }

    public void B(@Nullable d.a.m0.a.n1.q.b.a aVar) {
        if (aVar != null) {
            this.f47522c.add(aVar);
        }
        f(this.f47520a);
    }

    public final void C(@NonNull List<d.a.m0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e i2;
        if (list.size() == 0 || (i2 = e.i()) == null) {
            return;
        }
        String q = i2.T().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (f47518d) {
                    e2.printStackTrace();
                }
            }
        }
        for (d.a.m0.a.n1.q.c.b bVar : list) {
            String str = arrayMap.get(bVar.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (f47518d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.a() + " , version => " + str);
                }
                jSONObject.put(bVar.a(), str);
            } catch (JSONException e3) {
                if (f47518d) {
                    e3.printStackTrace();
                }
            }
        }
        i2.T().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<d.a.m0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String D = d.a.m0.a.a2.d.g().r().D();
        if (TextUtils.isEmpty(D)) {
            return null;
        }
        String T = e.i().N().T();
        if (TextUtils.isEmpty(T)) {
            T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", D);
            jSONObject.put("source", T);
        } catch (JSONException e2) {
            if (f47518d) {
                e2.printStackTrace();
            }
        }
        for (d.a.m0.a.n1.q.c.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = arrayMap.containsKey(bVar.a()) ? arrayMap.get(bVar.a()) : "";
                if (f47518d) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.a() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.a(), jSONObject2);
            } catch (JSONException e3) {
                if (f47518d) {
                    e3.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final void d(@NonNull List<d.a.m0.a.n1.q.c.b> list) {
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        n(list);
        o(false);
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<d.a.m0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        t();
        boolean z = false;
        for (d.a.m0.a.n1.q.c.b bVar : list) {
            JSONObject optJSONObject = jSONObject.optJSONObject(bVar.a());
            if (optJSONObject == null) {
                bVar.b();
            } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                bVar.b();
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    bVar.c();
                } else {
                    if (f47518d) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.a() + " update");
                    }
                    bVar.d(str, optJSONObject2, str2);
                    String optString = optJSONObject.optString("version", "");
                    if (!TextUtils.isEmpty(optString)) {
                        if (f47518d) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: " + bVar.a() + " update , version " + optString);
                        }
                        arrayMap.put(bVar.a(), optString);
                        z = true;
                    }
                }
            }
        }
        if (z) {
            C(list, arrayMap);
        }
        o(true);
    }

    public final void f(@NonNull List<d.a.m0.a.n1.q.c.b> list) {
        if (list.size() == 0) {
            d.h("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            p();
            return;
        }
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.f47521b.incrementAndGet() > 1) {
            d.h("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
            return;
        }
        ArrayMap<String, String> i2 = i(this.f47520a);
        JSONObject c2 = c(list, i2);
        if (c2 == null) {
            d.h("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            p();
            return;
        }
        if (f47518d) {
            Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
        }
        FormBody build = new FormBody.Builder().add("data", c2.toString()).build();
        String b2 = d.a.m0.a.c1.a.n().b();
        d.h("SwanAppUpdateManager", "appId =" + d.a.m0.a.a2.d.g().getAppId() + ", update url = " + b2 + ",body=" + c2);
        j(d.a.m0.a.a2.d.g().getAppId(), b2, build, list, i2);
    }

    public long h() {
        if (d.a.m0.a.a2.d.g().C()) {
            return d.a.m0.a.a2.d.g().r().T().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
        }
        return System.currentTimeMillis();
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<d.a.m0.a.n1.q.c.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (d.a.m0.a.n1.q.c.b bVar : list) {
            arrayMap.put(bVar.a(), "");
        }
        e i2 = e.i();
        if (i2 == null) {
            return arrayMap;
        }
        String q = i2.T().q("update_nodes_version", "");
        if (TextUtils.isEmpty(q)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            for (d.a.m0.a.n1.q.c.b bVar2 : list) {
                arrayMap.put(bVar2.a(), jSONObject.optString(bVar2.a(), ""));
            }
        } catch (JSONException e2) {
            if (f47518d) {
                e2.printStackTrace();
            }
        }
        return arrayMap;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<d.a.m0.a.n1.q.c.b> list, ArrayMap<String, String> arrayMap) {
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(str2, requestBody, new C0824a(str, list, arrayMap, str2));
        aVar.f51756f = true;
        aVar.f51757g = true;
        aVar.f51758h = false;
        aVar.k = 20;
        d.a.m0.m.e.a.g().e(aVar);
        d.a.m0.a.j2.q.a.a(SwanInterfaceType.UPDATE);
    }

    public final void k() {
        l();
        this.f47521b = new AtomicInteger(0);
        this.f47522c = new CopyOnWriteArrayList<>();
    }

    public final void l() {
        ArrayList arrayList = new ArrayList();
        this.f47520a = arrayList;
        arrayList.add(new d.a.m0.a.n1.q.c.a());
        this.f47520a.add(new c());
    }

    public final boolean m() {
        long h2 = h();
        if (h2 <= 0) {
            return true;
        }
        return System.currentTimeMillis() - h2 > o.b(d.a.m0.a.a2.d.g().getAppId());
    }

    public final void n(@NonNull List<d.a.m0.a.n1.q.c.b> list) {
        for (d.a.m0.a.n1.q.c.b bVar : list) {
            bVar.b();
        }
    }

    public final void o(boolean z) {
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.f47521b.decrementAndGet() > 0) {
            if (f47518d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.f47521b.set(0);
            if (!z) {
                A();
                return;
            } else {
                p();
                return;
            }
        }
        p();
    }

    public final void p() {
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.f47521b.set(0);
        Iterator<d.a.m0.a.n1.q.b.a> it = this.f47522c.iterator();
        while (it.hasNext()) {
            d.a.m0.a.e2.c.d.k(new b(this, it.next()));
        }
        this.f47522c.clear();
    }

    public void q(@NonNull d.a.m0.a.k2.g.b bVar, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node start");
        }
        String string = bVar.getString("node_data_accredit_list", "");
        d.h("SwanAppUpdateManager", "prefName: " + bVar.i() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
        if (TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject();
            w.f(jSONObject3, "list", jSONObject);
            String jSONObject4 = jSONObject3.toString();
            bVar.putString("node_data_accredit_list", jSONObject4);
            bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
            if (f47518d) {
                Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
            }
        } else {
            HashMap<String, JSONObject> r = r(jSONObject);
            if (r != null && r.size() != 0) {
                JSONObject d2 = w.d(string);
                JSONObject optJSONObject = d2.optJSONObject("list");
                if (optJSONObject == null) {
                    w.f(d2, "list", jSONObject);
                    bVar.putString("node_data_accredit_list", d2.toString());
                    bVar.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                    d.h("SwanAppUpdateManager", "local has cache data, but list node is empty");
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                        w.f(optJSONObject, next, jSONObject2);
                    }
                }
                w.f(d2, "list", optJSONObject);
                bVar.putString("node_data_accredit_list", d2.toString());
                String string2 = bVar.getString("cur_request_id", "");
                if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                    string2 = string2.substring(length - 100);
                }
                bVar.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                d.h("SwanAppUpdateManager", "prefName: " + bVar.i() + ",mergeAccredit = " + d2);
            } else {
                d.h("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                return;
            }
        }
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                hashMap.put(next, optJSONObject);
            }
        }
        return hashMap;
    }

    public final void s(String str, Response response, @NonNull List<d.a.m0.a.n1.q.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "onResponse: update request return");
        }
        String str2 = null;
        if (!response.isSuccessful()) {
            d(list);
            d.a.m0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2104, null, response);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            d(list);
            d.a.m0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, null, response);
            return;
        }
        try {
            str2 = body.string();
        } catch (IOException e2) {
            if (f47518d) {
                e2.printStackTrace();
            }
        }
        d.h("SwanAppUpdateManager", "response body = " + str2);
        if (TextUtils.isEmpty(str2)) {
            d(list);
            d.a.m0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                d(list);
                d.a.m0.a.j2.q.a.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                return;
            }
            String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            d.h("SwanAppUpdateManager", "request_id = " + optString);
            if (optJSONObject == null) {
                d(list);
            } else {
                e(str, optJSONObject, list, arrayMap, optString);
            }
        } catch (JSONException e3) {
            if (f47518d) {
                e3.printStackTrace();
            }
            d(list);
            d.a.m0.a.j2.q.a.c(SwanInterfaceType.UPDATE, 2103, str2, response);
        }
    }

    public final void t() {
        if (d.a.m0.a.a2.d.g().C()) {
            d.a.m0.a.a2.d.g().r().T().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (f47519e == null) {
            return;
        }
        this.f47522c.clear();
        f47519e = null;
    }

    public void v() {
        if (d.a.m0.a.a2.d.g().C()) {
            d.a.m0.a.a2.d.g().r().T().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        y();
    }

    public void w(d.a.m0.a.n1.q.c.b bVar) {
        if (bVar == null) {
            if (f47518d) {
                Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                return;
            }
            return;
        }
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.a());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put(bVar.a(), "");
        C(arrayList, arrayMap);
    }

    public void y() {
        boolean m = d.a.m0.a.a2.d.g().r().T().m("swan_service_update_degraded", false);
        d.g("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
        if (m) {
            return;
        }
        z(null);
    }

    public void z(@Nullable d.a.m0.a.n1.q.b.a aVar) {
        if (m()) {
            if (f47518d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
            }
            B(aVar);
            return;
        }
        if (f47518d) {
            Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
        }
        if (aVar != null) {
            aVar.a();
        }
    }
}
