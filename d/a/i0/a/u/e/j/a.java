package d.a.i0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.i0.a.v2.w;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.u.c.d {

    /* renamed from: d.a.i0.a.u.e.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0843a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44856b;

        public C0843a(String str, String str2) {
            this.f44855a = str;
            this.f44856b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("statusCode", String.valueOf(i2));
                jSONObject2.put("data", jSONObject);
            } catch (JSONException e2) {
                d.a.i0.a.e0.d.a("CallServiceApi", Log.getStackTraceString(e2));
            }
            d.a.i0.a.e0.d.a("CallServiceApi", "Cloud capability '" + this.f44855a + "' request success: data:" + jSONObject2.toString());
            a.this.d(this.f44856b, new d.a.i0.a.u.h.b(0, jSONObject2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return w.d(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String str;
            d.a.i0.a.e0.d.g("CallServiceApi", "Cloud capability request failed: " + this.f44855a + "\n" + Log.getStackTraceString(exc));
            a aVar = a.this;
            String str2 = this.f44856b;
            if (TextUtils.isEmpty(exc.getMessage())) {
                str = "请求失败";
            } else {
                str = exc.getMessage() + "";
            }
            aVar.d(str2, new d.a.i0.a.u.h.b(1001, str));
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b r(String str) {
        if (d.a.i0.a.a2.e.Q() == null) {
            d.a.i0.a.e0.d.a("CallServiceApi", "swan app is null");
            return new d.a.i0.a.u.h.b(1001, "swan app is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("CallServiceApi", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.i0.a.e0.d.a("CallServiceApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.a("CallServiceApi", "callback is null");
            return new d.a.i0.a.u.h.b(201, "callback is null");
        }
        String optString2 = jSONObject.optString("service");
        if (TextUtils.isEmpty(optString2)) {
            d.a.i0.a.e0.d.a("CallServiceApi", "service is empty");
            return new d.a.i0.a.u.h.b(201, "service is empty");
        }
        s(optString2, jSONObject.optJSONObject("data"), optString);
        return new d.a.i0.a.u.h.b(0);
    }

    public final void s(String str, JSONObject jSONObject, String str2) {
        b bVar = new b();
        bVar.g(str);
        bVar.f(jSONObject);
        bVar.c(new C0843a(str, str2));
    }
}
