package d.b.h0.a.g1.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.h0.a.c0.c;
import d.b.h0.a.i2.v;
import d.b.h0.a.k;
import d.b.h0.a.r1.d;
import d.b.h0.a.r1.e;
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
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45276d = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public static final long f45277e = TimeUnit.HOURS.toMillis(5);

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f45278f;

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.h0.a.g1.o.c.b> f45279a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f45280b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<d.b.h0.a.g1.o.b.a> f45281c;

    /* renamed from: d.b.h0.a.g1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0727a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f45282a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f45283b;

        public C0727a(List list, ArrayMap arrayMap) {
            this.f45282a = list;
            this.f45283b = arrayMap;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f45276d) {
                Log.e("SwanAppUpdateManager", "onFailure: update request failure ", exc);
            }
            a.this.e(this.f45282a);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            c.h("SwanAppUpdateManager", "response code = " + response.code());
            a.this.t(response, this.f45282a, this.f45283b);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.g1.o.b.a f45285e;

        public b(a aVar, d.b.h0.a.g1.o.b.a aVar2) {
            this.f45285e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45285e.a();
        }
    }

    public a() {
        l();
    }

    public static a h() {
        if (f45278f == null) {
            synchronized (a.class) {
                if (f45278f == null) {
                    f45278f = new a();
                }
            }
        }
        return f45278f;
    }

    public void A() {
        B(null);
    }

    public void B(@Nullable d.b.h0.a.g1.o.b.a aVar) {
        if (aVar != null) {
            this.f45281c.add(aVar);
        }
        g(this.f45279a);
    }

    public final void C(@NonNull List<d.b.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        e y;
        if (list.size() == 0 || (y = e.y()) == null) {
            return;
        }
        String p = y.R().p("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(p)) {
            try {
                jSONObject = new JSONObject(p);
            } catch (JSONException e2) {
                if (f45276d) {
                    e2.printStackTrace();
                }
            }
        }
        for (d.b.h0.a.g1.o.c.b bVar : list) {
            String str = arrayMap.get(bVar.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (f45276d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + bVar.a() + " , version => " + str);
                }
                jSONObject.put(bVar.a(), str);
            } catch (JSONException e3) {
                if (f45276d) {
                    e3.printStackTrace();
                }
            }
        }
        y.R().A("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject d(@NonNull List<d.b.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String T = e.T();
        if (TextUtils.isEmpty(T)) {
            return null;
        }
        String S = e.y().L().S();
        if (TextUtils.isEmpty(S)) {
            S = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", T);
            jSONObject.put("source", S);
        } catch (JSONException e2) {
            if (f45276d) {
                e2.printStackTrace();
            }
        }
        for (d.b.h0.a.g1.o.c.b bVar : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = arrayMap.containsKey(bVar.a()) ? arrayMap.get(bVar.a()) : "";
                if (f45276d) {
                    Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + bVar.a() + " , version => " + str);
                }
                jSONObject2.put("version", str);
                jSONObject.put(bVar.a(), jSONObject2);
            } catch (JSONException e3) {
                if (f45276d) {
                    e3.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final void e(@NonNull List<d.b.h0.a.g1.o.c.b> list) {
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "doRequestFail: ");
        }
        o(list);
        p(false);
    }

    public final void f(@NonNull JSONObject jSONObject, @NonNull List<d.b.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap, String str) {
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
        }
        u();
        boolean z = false;
        for (d.b.h0.a.g1.o.c.b bVar : list) {
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
                    if (f45276d) {
                        Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + bVar.a() + " update");
                    }
                    bVar.d(optJSONObject2, str);
                    String optString = optJSONObject.optString("version", "");
                    if (!TextUtils.isEmpty(optString)) {
                        if (f45276d) {
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

    public final void g(@NonNull List<d.b.h0.a.g1.o.c.b> list) {
        if (list.size() == 0) {
            if (f45276d) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
            }
            q();
            return;
        }
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
        }
        if (this.f45280b.incrementAndGet() > 1) {
            if (f45276d) {
                Log.d("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            return;
        }
        ArrayMap<String, String> j = j(this.f45279a);
        JSONObject d2 = d(list, j);
        if (d2 == null) {
            if (f45276d) {
                Log.w("SwanAppUpdateManager", "doUpdate: finish => build params is null");
            }
            q();
            return;
        }
        if (f45276d) {
            Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
        }
        FormBody build = new FormBody.Builder().add("data", d2.toString()).build();
        String b2 = d.b.h0.a.w0.a.l().b();
        c.h("SwanAppUpdateManager", "swan update url = " + b2);
        k(b2, build, list, j);
    }

    public long i() {
        if (d.e().x()) {
            return d.e().s().R().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
        }
        return System.currentTimeMillis();
    }

    @NonNull
    public final ArrayMap<String, String> j(@NonNull List<d.b.h0.a.g1.o.c.b> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (d.b.h0.a.g1.o.c.b bVar : list) {
            arrayMap.put(bVar.a(), "");
        }
        e y = e.y();
        if (y == null) {
            return arrayMap;
        }
        String p = y.R().p("update_nodes_version", "");
        if (TextUtils.isEmpty(p)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(p);
            for (d.b.h0.a.g1.o.c.b bVar2 : list) {
                arrayMap.put(bVar2.a(), jSONObject.optString(bVar2.a(), ""));
            }
        } catch (JSONException e2) {
            if (f45276d) {
                e2.printStackTrace();
            }
        }
        return arrayMap;
    }

    public final void k(String str, RequestBody requestBody, List<d.b.h0.a.g1.o.c.b> list, ArrayMap<String, String> arrayMap) {
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a(str, requestBody, new C0727a(list, arrayMap));
        aVar.f49605f = true;
        aVar.f49606g = true;
        aVar.f49607h = false;
        d.b.h0.k.e.a.f().e(aVar);
    }

    public final void l() {
        m();
        this.f45280b = new AtomicInteger(0);
        this.f45281c = new CopyOnWriteArrayList<>();
    }

    public final void m() {
        ArrayList arrayList = new ArrayList();
        this.f45279a = arrayList;
        arrayList.add(new d.b.h0.a.g1.o.c.a());
        this.f45279a.add(new d.b.h0.a.g1.o.c.c());
    }

    public final boolean n() {
        long i = i();
        return i <= 0 || System.currentTimeMillis() - i > f45277e;
    }

    public final void o(@NonNull List<d.b.h0.a.g1.o.c.b> list) {
        for (d.b.h0.a.g1.o.c.b bVar : list) {
            bVar.b();
        }
    }

    public final void p(boolean z) {
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
        }
        if (this.f45280b.decrementAndGet() > 0) {
            if (f45276d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
            }
            this.f45280b.set(0);
            if (!d.b.h0.a.j1.m.c.i()) {
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
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
        }
        this.f45280b.set(0);
        Iterator<d.b.h0.a.g1.o.b.a> it = this.f45281c.iterator();
        while (it.hasNext()) {
            d.b.h0.a.v1.c.c.k(new b(this, it.next()));
        }
        this.f45281c.clear();
    }

    public void r(@NonNull d.b.h0.a.a2.g.b bVar, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "parse increment accredit node start");
        }
        String string = bVar.getString("node_data_accredit_list", "");
        boolean j = d.b.h0.a.j1.m.c.j();
        c.h("SwanAppUpdateManager", "cacheData is Empty = " + TextUtils.isEmpty(string) + " ; mergeNodeSwitch = " + j);
        if (TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject();
            v.d(jSONObject3, "list", jSONObject);
            String jSONObject4 = jSONObject3.toString();
            bVar.putString("node_data_accredit_list", jSONObject4);
            if (f45276d) {
                Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
            }
        } else if (!j) {
            if (f45276d) {
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
                    if (f45276d) {
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
                if (f45276d) {
                    Log.d("SwanAppUpdateManager", "local has cache data, pending size = " + s.size());
                }
            } else if (f45276d) {
                Log.e("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                return;
            } else {
                return;
            }
        }
        if (f45276d) {
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

    public final void t(Response response, @NonNull List<d.b.h0.a.g1.o.c.b> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (f45276d) {
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
            if (f45276d) {
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
            if (f45276d) {
                e3.printStackTrace();
            }
            e(list);
        }
    }

    public final void u() {
        if (d.e().x()) {
            d.e().s().R().z(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void v() {
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "release: ");
        }
        if (f45278f == null) {
            return;
        }
        this.f45281c.clear();
        f45278f = null;
    }

    public void w() {
        if (d.e().x()) {
            d.e().s().R().C(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
        }
        y();
    }

    public void x(d.b.h0.a.g1.o.c.b bVar) {
        if (bVar == null) {
            if (f45276d) {
                Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                return;
            }
            return;
        }
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "resetNodeVersion: " + bVar.a());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put(bVar.a(), "");
        C(arrayList, arrayMap);
    }

    public void y() {
        boolean i = d.b.h0.a.j1.m.c.i();
        boolean m = d.e().s().R().m("swan_service_update_degraded", false);
        c.g("SwanAppUpdateManager", "tryUpdate, isUpdateAsyncAb = " + i + " ; isServiceDegraded = " + m);
        if (i && m) {
            return;
        }
        z(null);
    }

    public void z(@Nullable d.b.h0.a.g1.o.b.a aVar) {
        if (n()) {
            if (f45276d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
            }
            B(aVar);
            return;
        }
        if (f45276d) {
            Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
        }
        if (aVar != null) {
            aVar.a();
        }
    }
}
