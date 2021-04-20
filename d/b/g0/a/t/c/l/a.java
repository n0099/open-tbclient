package d.b.g0.a.t.c.l;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0838a implements d.b {
        public C0838a() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(e eVar, JSONObject jSONObject, String str) {
            return a.this.x(eVar, jSONObject, str);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46555a;

        public b(String str) {
            this.f46555a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.u(this.f46555a, exc == null ? "" : exc.getMessage());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            a.this.c(this.f46555a, a.this.w(response));
            return response;
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final Pair<Request, Integer> s(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        RequestBody v = v(eVar, jSONObject);
        if (v == null) {
            return new Pair<>(null, 202);
        }
        return new Pair<>(new Request.Builder().url(d.b.g0.a.w0.a.G().b()).post(v).build(), 0);
    }

    public final void t(@NonNull Request request, String str) {
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(request.url().toString(), request.body(), new b(str));
        aVar.i = request.tag();
        aVar.f49276f = true;
        aVar.f49277g = true;
        aVar.f49278h = true;
        d.b.g0.k.e.a.f().e(aVar);
    }

    public final void u(@NonNull String str, String str2) {
        c(str, new d.b.g0.a.t.e.b(500106, str2));
    }

    public final RequestBody v(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("subscribeId");
        String B = eVar.B();
        String optString2 = jSONObject.optString("templateId");
        if (TextUtils.isEmpty(B) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new FormBody.Builder().add("appkey", B).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
    }

    public d.b.g0.a.t.e.b w(Response response) {
        if (response != null && response.body() != null) {
            try {
                String string = response.body().string();
                if (d.f46321c) {
                    Log.i("Api-Subscription", string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (TextUtils.equals("0", optString) && optJSONObject != null) {
                    return new d.b.g0.a.t.e.b(0, optJSONObject, false);
                }
                return new d.b.g0.a.t.e.b(500106, "subscribe fail");
            } catch (Exception e2) {
                if (d.f46321c) {
                    e2.printStackTrace();
                }
                return new d.b.g0.a.t.e.b(500106, Log.getStackTraceString(e2));
            }
        }
        return new d.b.g0.a.t.e.b(500106, "response body is null");
    }

    public final d.b.g0.a.t.e.b x(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        Pair<Request, Integer> s = s(eVar, jSONObject);
        Request request = (Request) s.first;
        if (request == null) {
            return new d.b.g0.a.t.e.b(((Integer) s.second).intValue(), "params error");
        }
        t(request, str);
        return new d.b.g0.a.t.e.b(0, "success");
    }

    public d.b.g0.a.t.e.b y(String str) {
        if (d.f46321c) {
            Log.d("Api-Subscription", "subscribe with json string:  " + str);
        }
        return i(str, true, new C0838a());
    }
}
