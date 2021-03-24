package d.b.g0.g.x;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.g.x.a {
    public d.b.g0.g.i.b i;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<d.b.g0.g.x.g.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f48633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48634b;

        /* renamed from: d.b.g0.g.x.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0997a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.x.g.a f48636e;

            public RunnableC0997a(d.b.g0.g.x.g.a aVar) {
                this.f48636e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(a.this.f48634b, true, this.f48636e);
            }
        }

        /* renamed from: d.b.g0.g.x.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0998b implements Runnable {
            public RunnableC0998b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.b.g0.g.i0.b.a(aVar.f48634b, false, aVar.f48633a);
            }
        }

        public a(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f48633a = cVar;
            this.f48634b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.g.x.g.a aVar, int i) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("CheckIsUserAdvisedToRestApi", "on success");
            }
            b.this.i.post(new RunnableC0997a(aVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.g0.g.x.g.a parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("CheckIsUserAdvisedToRestApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f48632h) {
                    Log.d("CheckIsUserAdvisedToRestApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f48633a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                return null;
            }
            String optString2 = jSONObject.optJSONObject("data").optString("result");
            d.b.g0.g.x.g.a aVar = new d.b.g0.g.x.g.a();
            aVar.result = !TextUtils.equals(optString2, "0");
            aVar.errNo = "0";
            aVar.errMsg = d.b.g0.g.i0.b.c("checkIsUserAdvisedToRest", "ok");
            return aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.e("CheckIsUserAdvisedToRestApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f48633a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f48633a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
            }
            b.this.i.post(new RunnableC0998b());
        }
    }

    public b(@NonNull d.b.g0.g.i.b bVar) {
        this.i = bVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null || this.i == null) {
            return;
        }
        d.b.g0.g.x.g.c cVar = new d.b.g0.g.x.g.c();
        try {
            int d2 = F.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.b.g0.a.r1.e.T());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (d.b.g0.g.x.a.f48632h) {
                    e2.printStackTrace();
                }
            }
            q(d.b.g0.a.w0.a.l().r(), jSONObject.toString(), new a(cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (d.b.g0.g.x.a.f48632h) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.b("checkIsUserAdvisedToRest", e3);
            d.b.g0.g.i0.b.a(F, false, cVar);
        }
    }
}
