package d.a.i0.h.z;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.i0.h.z.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.l0.c f47593b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<d.a.i0.h.z.g.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.z.g.c f47594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47595b;

        /* renamed from: d.a.i0.h.z.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1049a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.h.z.g.a f47597e;

            public RunnableC1049a(d.a.i0.h.z.g.a aVar) {
                this.f47597e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.h.m0.c.a(a.this.f47595b, true, this.f47597e);
            }
        }

        /* renamed from: d.a.i0.h.z.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1050b implements Runnable {
            public RunnableC1050b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.i0.h.m0.c.a(aVar.f47595b, false, aVar.f47594a);
            }
        }

        public a(d.a.i0.h.z.g.c cVar, d.a.i0.a.y.b.a aVar) {
            this.f47594a = cVar;
            this.f47595b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.i0.h.z.g.a aVar, int i2) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("CheckAdvisedToRestApi", "on success");
            }
            b.this.f47593b.post(new RunnableC1049a(aVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.i0.h.z.g.a parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("CheckAdvisedToRestApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.i0.h.z.a.f47592a) {
                    Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                }
                d.a.i0.h.z.g.c cVar = this.f47594a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                return null;
            }
            String optString2 = jSONObject.optJSONObject("data").optString("result");
            d.a.i0.h.z.g.a aVar = new d.a.i0.h.z.g.a();
            aVar.result = !TextUtils.equals(optString2, "0");
            aVar.errNo = "0";
            aVar.errMsg = d.a.i0.h.m0.c.c("checkIsUserAdvisedToRest", "ok");
            return aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.e("CheckAdvisedToRestApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f47594a.errMsg)) {
                d.a.i0.h.z.g.c cVar = this.f47594a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
            }
            b.this.f47593b.post(new RunnableC1050b());
        }
    }

    public b(@NonNull d.a.i0.a.l0.c cVar) {
        this.f47593b = cVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null || this.f47593b == null) {
            return;
        }
        d.a.i0.h.z.g.c cVar = new d.a.i0.h.z.g.c();
        try {
            int d2 = G.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.i0.a.a2.e.V());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (d.a.i0.h.z.a.f47592a) {
                    e2.printStackTrace();
                }
            }
            a(d.a.i0.h.t.a.b().e(), jSONObject.toString(), new a(cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.i0.h.z.a.f47592a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.b("checkIsUserAdvisedToRest", e3);
            d.a.i0.h.m0.c.a(G, false, cVar);
        }
    }
}
