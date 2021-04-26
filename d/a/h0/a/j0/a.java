package d.a.h0.a.j0;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import d.a.h0.a.k;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42835a = k.f43101a;

    /* renamed from: d.a.h0.a.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0675a extends ResponseCallback<JSONObject> {
        public C0675a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (a.f42835a) {
                Log.e("AbsDefaultPurger", "onSuccess: ");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (a.f42835a) {
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
            if (a.f42835a) {
                Log.e("AbsDefaultPurger", "onFail: " + exc);
            }
        }
    }

    @NonNull
    public final ResponseCallback<JSONObject> b() {
        return new C0675a(this);
    }

    public void c(String str) {
        d.a.h0.l.i.a.h().c(str);
    }

    public void d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f42835a) {
            Log.d("AbsDefaultPurger", "clearData");
        }
        Set<String> d2 = d.d(list);
        HashSet<String> hashSet = new HashSet(list);
        if (d2 != null) {
            hashSet.removeAll(d2);
        }
        d.a.h0.a.w0.a.Z().b("aiapp_setting_", hashSet, false);
        d.a.h0.a.w0.a.Z().b("aiapp_", hashSet, false);
        for (String str : hashSet) {
            if (f42835a) {
                Log.d("AbsDefaultPurger", "clear storage files: " + str);
            }
            String f2 = d.a.h0.a.a2.b.f(str);
            if (!TextUtils.isEmpty(f2)) {
                d.a.h0.p.d.g(f2);
            }
            String h2 = d.a.h0.a.a2.b.h(str);
            if (!TextUtils.isEmpty(h2)) {
                d.a.h0.p.d.g(h2);
            }
        }
    }

    public void e(String str) {
        d.a.h0.l.i.a.h().g(str);
        d.a.h0.l.i.a.h().e(d.a.h0.l.k.f.class, str);
    }

    public void f(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f42835a) {
            Log.d("AbsDefaultPurger", "resetAccredit");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ma_ids", list);
        JSONObject jSONObject = new JSONObject();
        try {
            d.a.h0.a.v1.c.g a2 = d.a.h0.a.w0.a.m().a();
            jSONObject.put("accredit", new JSONObject(arrayMap));
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) d.a.h0.k.e.a.f().postFormRequest().url(d.a.h0.a.w0.a.l().v())).addParam("data", jSONObject.toString()).cookieManager(a2)).build().executeAsyncOnUIBack(b());
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (f42835a) {
                Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e2);
            }
        }
    }
}
