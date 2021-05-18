package d.a.i0.a.n0;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import d.a.i0.a.e2.c.h;
import d.a.i0.a.k;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43402a = k.f43025a;

    /* renamed from: d.a.i0.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0747a extends ResponseCallback<JSONObject> {
        public C0747a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (a.f43402a) {
                Log.e("AbsDefaultPurger", "onSuccess: ");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (a.f43402a) {
                Log.d("AbsDefaultPurger", "parseResponse");
            }
            if (response == null || response.body() == null) {
                return null;
            }
            String string = response.body().string();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new JSONObject(string);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (a.f43402a) {
                Log.e("AbsDefaultPurger", "onFail: " + exc);
            }
        }
    }

    @NonNull
    public final ResponseCallback<JSONObject> c() {
        return new C0747a(this);
    }

    public void d(String str) {
        d.a.i0.n.g.a.h().c(str);
    }

    public void e(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f43402a) {
            Log.d("AbsDefaultPurger", "clearData");
        }
        Set<String> d2 = e.d(list);
        HashSet<String> hashSet = new HashSet(list);
        if (d2 != null) {
            hashSet.removeAll(d2);
        }
        d.a.i0.a.k2.h.d.j().g("aiapp_setting_", hashSet, false);
        d.a.i0.a.k2.h.d.j().g("aiapp_", hashSet, false);
        for (String str : hashSet) {
            if (f43402a) {
                Log.d("AbsDefaultPurger", "clear storage files: " + str);
            }
            String v = d.a.i0.a.k2.b.v(str);
            if (!TextUtils.isEmpty(v)) {
                d.a.i0.t.d.L(v);
            }
            String x = d.a.i0.a.k2.b.x(str);
            if (!TextUtils.isEmpty(x)) {
                d.a.i0.t.d.L(x);
            }
        }
    }

    public void f(String str) {
        d.a.i0.n.g.a.h().g(str);
        d.a.i0.n.g.a.h().e(d.a.i0.n.h.f.class, str);
    }

    public void g(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f43402a) {
            Log.d("AbsDefaultPurger", "resetAccredit");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ma_ids", list);
        JSONObject jSONObject = new JSONObject();
        try {
            h a2 = d.a.i0.a.c1.a.p().a();
            jSONObject.put("accredit", new JSONObject(arrayMap));
            String t = d.a.i0.a.c1.a.n().t();
            d.a.i0.m.a b2 = d.a.i0.m.b.b();
            if (b2 == null) {
                if (!f43402a) {
                    d.a.i0.a.e0.d.b("AbsDefaultPurger", "get network obj failed on resetAccredit");
                } else {
                    throw new RuntimeException("SwanNetworkRuntime.getSwanNetwork return null , check inject");
                }
            }
            d.a.i0.m.e.a g2 = d.a.i0.m.e.a.g();
            if (!g2.c()) {
                b2 = null;
            }
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) g2.postFormRequest().url(t)).addParam("data", jSONObject.toString()).userAgent(b2 != null ? b2.a() : "")).cookieManager(a2)).build().executeAsyncOnUIBack(c());
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (f43402a) {
                Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e2);
            }
        }
    }
}
