package d.a.l0.h.z;

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
public class b extends d.a.l0.h.z.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.l0.c f51443b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<d.a.l0.h.z.g.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.z.g.c f51444a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f51445b;

        /* renamed from: d.a.l0.h.z.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1116a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.h.z.g.a f51447e;

            public RunnableC1116a(d.a.l0.h.z.g.a aVar) {
                this.f51447e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.h.m0.c.a(a.this.f51445b, true, this.f51447e);
            }
        }

        /* renamed from: d.a.l0.h.z.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1117b implements Runnable {
            public RunnableC1117b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.l0.h.m0.c.a(aVar.f51445b, false, aVar.f51444a);
            }
        }

        public a(d.a.l0.h.z.g.c cVar, d.a.l0.a.y.b.a aVar) {
            this.f51444a = cVar;
            this.f51445b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.l0.h.z.g.a aVar, int i2) {
            if (d.a.l0.h.z.a.f51442a) {
                Log.d("CheckAdvisedToRestApi", "on success");
            }
            b.this.f51443b.post(new RunnableC1116a(aVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.l0.h.z.g.a parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.l0.h.z.a.f51442a) {
                Log.d("CheckAdvisedToRestApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.l0.h.z.a.f51442a) {
                    Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                }
                d.a.l0.h.z.g.c cVar = this.f51444a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                return null;
            }
            String optString2 = jSONObject.optJSONObject("data").optString("result");
            d.a.l0.h.z.g.a aVar = new d.a.l0.h.z.g.a();
            aVar.result = !TextUtils.equals(optString2, "0");
            aVar.errNo = "0";
            aVar.errMsg = d.a.l0.h.m0.c.c("checkIsUserAdvisedToRest", "ok");
            return aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.l0.h.z.a.f51442a) {
                Log.e("CheckAdvisedToRestApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f51444a.errMsg)) {
                d.a.l0.h.z.g.c cVar = this.f51444a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
            }
            b.this.f51443b.post(new RunnableC1117b());
        }
    }

    public b(@NonNull d.a.l0.a.l0.c cVar) {
        this.f51443b = cVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null || this.f51443b == null) {
            return;
        }
        d.a.l0.h.z.g.c cVar = new d.a.l0.h.z.g.c();
        try {
            int d2 = G.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.l0.a.a2.e.V());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (d.a.l0.h.z.a.f51442a) {
                    e2.printStackTrace();
                }
            }
            a(d.a.l0.h.t.a.b().e(), jSONObject.toString(), new a(cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.l0.h.z.a.f51442a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.l0.h.m0.c.b("checkIsUserAdvisedToRest", e3);
            d.a.l0.h.m0.c.a(G, false, cVar);
        }
    }
}
