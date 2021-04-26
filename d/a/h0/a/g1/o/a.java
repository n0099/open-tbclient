package d.a.h0.a.g1.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.h0.a.c0.c;
import d.a.h0.a.i2.v;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
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
    public static final boolean f42590d = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public static final long f42591e = TimeUnit.HOURS.toMillis(5);

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f42592f;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.h0.a.g1.o.c.b> f42593a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f42594b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.h0.a.g1.o.b.a> f42595c;

    /* renamed from: d.a.h0.a.g1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0666a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f42596a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f42597b;

        public C0666a(List list, ArrayMap arrayMap) {
            this.f42596a = list;
            this.f42597b = arrayMap;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f42590d) {
                Log.e("SwanAppUpdateManager", "onFailure: update request failure ", exc);
            }
            a.this.e(this.f42596a);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            c.h("SwanAppUpdateManager", "response code = " + response.code());
            a.this.t(response, this.f42596a, this.f42597b);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.g1.o.b.a f42599e;

        public b(a aVar, d.a.h0.a.g1.o.b.a aVar2) {
            this.f42599e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42599e.a();
        }
    }

    public a() {
        l();
    }

    public static a h() {
        if (f42592f == null) {
            synchronized (a.class) {
                if (f42592f == null) {
                    f42592f = new a();
                }
            }
        }
        return f42592f;
    }

    public void A() {
        B(null);
    }

    public void B(@Nullable d.a.h0.a.g1.o.b.a aVar) {
        if (aVar != null) {
            this.f42595c.add(aVar);
        }
        g(this.f42593a);
    }

    public final void C(@NonNull List<d.a.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e h2;
        if (list.size() == 0 || (h2 = e.h()) == null) {
            return;
        }
        String p = h2.R().p("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(p)) {
            try {
                jSONObject = new JSONObject(p);
            } catch (JSONException e2) {
                if (f42590d) {
                    e2.printStackTrace();
                }
            }
        }
        for (d.a.h0.a.g1.o.c.b bVar : list) {
            String str = arrayMap.get(bVar.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (f42590d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.a() + " , version => " + str);
                }
                jSONObject.put(bVar.a(), str);
            } catch (JSONException e3) {
                if (f42590d) {
                    e3.printStackTrace();
                }
            }
        }
        h2.R().A("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject d(@NonNull List<d.a.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String T = e.T();
        if (TextUtils.isEmpty(T)) {
            return null;
        }
        String S = e.h().L().S();
        if (TextUtils.isEmpty(S)) {
            S = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", T);
            jSONObject.put("source", S);
        } catch (JSONException e2) {
            if (f42590d) {
                e2.printStackTrace();
            }
        }
        for (d.a.h0.a.g1.o.c.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = arrayMap.containsKey(bVar.a()) ? arrayMap.get(bVar.a()) : "";
                if (f42590d) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.a() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.a(), jSONObject2);
            } catch (JSONException e3) {
                if (f42590d) {
                    e3.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final void e(@NonNull List<d.a.h0.a.g1.o.c.b> list) {
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        o(list);
        p(false);
    }

    public final void f(@NonNull JSONObject jSONObject, @NonNull List<d.a.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap, String str) {
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        u();
        boolean z = false;
        for (d.a.h0.a.g1.o.c.b bVar : list) {
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
                    if (f42590d) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.a() + " update");
                    }
                    bVar.d(optJSONObject2, str);
                    String optString = optJSONObject.optString("version", "");
                    if (!TextUtils.isEmpty(optString)) {
                        if (f42590d) {
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
        p(true);
    }

    public final void g(@NonNull List<d.a.h0.a.g1.o.c.b> list) {
        if (list.size() == 0) {
            if (f42590d) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            q();
            return;
        }
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.f42594b.incrementAndGet() > 1) {
            if (f42590d) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> j = j(this.f42593a);
        JSONObject d2 = d(list, j);
        if (d2 == null) {
            if (f42590d) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            q();
            return;
        }
        if (f42590d) {
            Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
        }
        FormBody build = new FormBody.Builder().add("data", d2.toString()).build();
        String b2 = d.a.h0.a.w0.a.l().b();
        c.h("SwanAppUpdateManager", "swan update url = " + b2);
        k(b2, build, list, j);
    }

    public long i() {
        if (d.e().z()) {
            return d.e().p().R().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
        }
        return System.currentTimeMillis();
    }

    @NonNull
    public final ArrayMap<String, String> j(@NonNull List<d.a.h0.a.g1.o.c.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (d.a.h0.a.g1.o.c.b bVar : list) {
            arrayMap.put(bVar.a(), "");
        }
        e h2 = e.h();
        if (h2 == null) {
            return arrayMap;
        }
        String p = h2.R().p("update_nodes_version", "");
        if (TextUtils.isEmpty(p)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(p);
            for (d.a.h0.a.g1.o.c.b bVar2 : list) {
                arrayMap.put(bVar2.a(), jSONObject.optString(bVar2.a(), ""));
            }
        } catch (JSONException e2) {
            if (f42590d) {
                e2.printStackTrace();
            }
        }
        return arrayMap;
    }

    public final void k(String str, RequestBody requestBody, List<d.a.h0.a.g1.o.c.b> list, ArrayMap<String, String> arrayMap) {
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(str, requestBody, new C0666a(list, arrayMap));
        aVar.f47111f = true;
        aVar.f47112g = true;
        aVar.f47113h = false;
        d.a.h0.k.e.a.f().e(aVar);
    }

    public final void l() {
        m();
        this.f42594b = new AtomicInteger(0);
        this.f42595c = new CopyOnWriteArrayList<>();
    }

    public final void m() {
        ArrayList arrayList = new ArrayList();
        this.f42593a = arrayList;
        arrayList.add(new d.a.h0.a.g1.o.c.a());
        this.f42593a.add(new d.a.h0.a.g1.o.c.c());
    }

    public final boolean n() {
        long i2 = i();
        return i2 <= 0 || System.currentTimeMillis() - i2 > f42591e;
    }

    public final void o(@NonNull List<d.a.h0.a.g1.o.c.b> list) {
        for (d.a.h0.a.g1.o.c.b bVar : list) {
            bVar.b();
        }
    }

    public final void p(boolean z) {
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.f42594b.decrementAndGet() > 0) {
            if (f42590d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.f42594b.set(0);
            if (!d.a.h0.a.j1.m.c.i()) {
                A();
                return;
            } else if (z) {
                return;
            } else {
                A();
                return;
            }
        }
        q();
    }

    public final void q() {
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.f42594b.set(0);
        Iterator<d.a.h0.a.g1.o.b.a> it = this.f42595c.iterator();
        while (it.hasNext()) {
            d.a.h0.a.v1.c.c.k(new b(this, it.next()));
        }
        this.f42595c.clear();
    }

    public void r(@NonNull d.a.h0.a.a2.g.b bVar, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node start");
        }
        String string = bVar.getString("node_data_accredit_list", "");
        boolean j = d.a.h0.a.j1.m.c.j();
        c.h("SwanAppUpdateManager", "cacheData is Empty = " + TextUtils.isEmpty(string) + " ; mergeNodeSwitch = " + j);
        if (TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject();
            v.d(jSONObject3, "list", jSONObject);
            String jSONObject4 = jSONObject3.toString();
            bVar.putString("node_data_accredit_list", jSONObject4);
            if (f42590d) {
                Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
            }
        } else if (!j) {
            if (f42590d) {
                Log.d("SwanAppUpdateManager", "local has no cache data, mergeNodeSwitch = false");
                return;
            }
            return;
        } else {
            HashMap<String, JSONObject> s = s(jSONObject);
            if (s != null && s.size() != 0) {
                JSONObject b2 = v.b(string);
                JSONObject optJSONObject = b2.optJSONObject("list");
                if (optJSONObject == null) {
                    v.d(b2, "list", jSONObject);
                    bVar.putString("node_data_accredit_list", b2.toString());
                    if (f42590d) {
                        Log.e("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && (jSONObject2 = s.get(next)) != null) {
                        v.d(optJSONObject, next, jSONObject2);
                    }
                }
                v.d(b2, "list", optJSONObject);
                bVar.putString("node_data_accredit_list", b2.toString());
                if (f42590d) {
                    Log.d("SwanAppUpdateManager", "local has cache data, pending size = " + s.size());
                }
            } else if (f42590d) {
                Log.e("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                return;
            } else {
                return;
            }
        }
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final HashMap<String, JSONObject> s(@NonNull JSONObject jSONObject) {
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

    public final void t(Response response, @NonNull List<d.a.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "onResponse: update request return");
        }
        if (!response.isSuccessful()) {
            e(list);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            e(list);
            return;
        }
        String str = null;
        try {
            str = body.string();
        } catch (IOException e2) {
            if (f42590d) {
                e2.printStackTrace();
            }
        }
        c.h("SwanAppUpdateManager", "response body = " + str);
        if (TextUtils.isEmpty(str)) {
            e(list);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                e(list);
                return;
            }
            String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            c.h("SwanAppUpdateManager", "request_id = " + optString);
            if (optJSONObject == null) {
                e(list);
            } else {
                f(optJSONObject, list, arrayMap, optString);
            }
        } catch (JSONException e3) {
            if (f42590d) {
                e3.printStackTrace();
            }
            e(list);
        }
    }

    public final void u() {
        if (d.e().z()) {
            d.e().p().R().z(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void v() {
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (f42592f == null) {
            return;
        }
        this.f42595c.clear();
        f42592f = null;
    }

    public void w() {
        if (d.e().z()) {
            d.e().p().R().C(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        y();
    }

    public void x(d.a.h0.a.g1.o.c.b bVar) {
        if (bVar == null) {
            if (f42590d) {
                Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                return;
            }
            return;
        }
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.a());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put(bVar.a(), "");
        C(arrayList, arrayMap);
    }

    public void y() {
        boolean i2 = d.a.h0.a.j1.m.c.i();
        boolean m = d.e().p().R().m("swan_service_update_degraded", false);
        c.g("SwanAppUpdateManager", "tryUpdate, isUpdateAsyncAb = " + i2 + " ; isServiceDegraded = " + m);
        if (i2 && m) {
            return;
        }
        z(null);
    }

    public void z(@Nullable d.a.h0.a.g1.o.b.a aVar) {
        if (n()) {
            if (f42590d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
            }
            B(aVar);
            return;
        }
        if (f42590d) {
            Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
        }
        if (aVar != null) {
            aVar.a();
        }
    }
}
