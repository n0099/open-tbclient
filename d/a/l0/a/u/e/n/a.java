package d.a.l0.a.u.e.n;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.l0.a.a2.e;
import d.a.l0.a.u.c.d;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.l0.a.u.e.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0863a implements d.b {
        public C0863a() {
        }

        @Override // d.a.l0.a.u.c.d.b
        public d.a.l0.a.u.h.b a(e eVar, JSONObject jSONObject, String str) {
            return a.this.y(eVar, jSONObject, str);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45148a;

        public b(String str) {
            this.f45148a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.v(this.f45148a, exc == null ? "" : exc.getMessage());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.d(this.f45148a, a.this.x(response));
            return response;
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public final Pair<Request, Integer> t(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        RequestBody w = w(eVar, jSONObject);
        if (w == null) {
            return new Pair<>(null, 202);
        }
        return new Pair<>(new Request.Builder().url(d.a.l0.a.c1.a.R().b()).post(w).build(), 0);
    }

    public final void u(@NonNull Request request, String str) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(request.url().toString(), request.body(), new b(str));
        aVar.f47977i = request.tag();
        aVar.f47974f = true;
        aVar.f47975g = true;
        aVar.f47976h = true;
        d.a.l0.m.e.a.g().e(aVar);
    }

    public final void v(@NonNull String str, String str2) {
        d(str, new d.a.l0.a.u.h.b(500106, str2));
    }

    public final RequestBody w(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("subscribeId");
        String D = eVar.D();
        String optString2 = jSONObject.optString("templateId");
        if (TextUtils.isEmpty(D) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new FormBody.Builder().add("appkey", D).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
    }

    public d.a.l0.a.u.h.b x(Response response) {
        if (response != null && response.body() != null) {
            try {
                String string = response.body().string();
                if (d.f44812c) {
                    Log.i("Api-Subscription", string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (TextUtils.equals("0", optString) && optJSONObject != null) {
                    return new d.a.l0.a.u.h.b(0, optJSONObject, false);
                }
                return new d.a.l0.a.u.h.b(500106, "subscribe fail");
            } catch (Exception e2) {
                if (d.f44812c) {
                    e2.printStackTrace();
                }
                return new d.a.l0.a.u.h.b(500106, Log.getStackTraceString(e2));
            }
        }
        return new d.a.l0.a.u.h.b(500106, "response body is null");
    }

    public final d.a.l0.a.u.h.b y(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        Pair<Request, Integer> t = t(eVar, jSONObject);
        Request request = (Request) t.first;
        if (request == null) {
            return new d.a.l0.a.u.h.b(((Integer) t.second).intValue(), "params error");
        }
        u(request, str);
        return new d.a.l0.a.u.h.b(0, "success");
    }

    public d.a.l0.a.u.h.b z(String str) {
        if (d.f44812c) {
            Log.d("Api-Subscription", "subscribe with json string:  " + str);
        }
        return j(str, true, new C0863a());
    }
}
