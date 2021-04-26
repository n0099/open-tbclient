package d.a.h0.g.x;

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
public class b extends d.a.h0.g.x.a {

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.g.i.b f46851i;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<d.a.h0.g.x.g.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.x.g.c f46852a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46853b;

        /* renamed from: d.a.h0.g.x.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0969a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.x.g.a f46855e;

            public RunnableC0969a(d.a.h0.g.x.g.a aVar) {
                this.f46855e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.i0.b.a(a.this.f46853b, true, this.f46855e);
            }
        }

        /* renamed from: d.a.h0.g.x.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0970b implements Runnable {
            public RunnableC0970b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.h0.g.i0.b.a(aVar.f46853b, false, aVar.f46852a);
            }
        }

        public a(d.a.h0.g.x.g.c cVar, d.a.h0.g.e.d.c cVar2) {
            this.f46852a = cVar;
            this.f46853b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.h0.g.x.g.a aVar, int i2) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("CheckIsUserAdvisedToRestApi", "on success");
            }
            b.this.f46851i.post(new RunnableC0969a(aVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.h0.g.x.g.a parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("CheckIsUserAdvisedToRestApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.h0.g.x.a.f46850h) {
                    Log.d("CheckIsUserAdvisedToRestApi", "errno = " + optString);
                }
                d.a.h0.g.x.g.c cVar = this.f46852a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                return null;
            }
            String optString2 = jSONObject.optJSONObject("data").optString("result");
            d.a.h0.g.x.g.a aVar = new d.a.h0.g.x.g.a();
            aVar.result = !TextUtils.equals(optString2, "0");
            aVar.errNo = "0";
            aVar.errMsg = d.a.h0.g.i0.b.c("checkIsUserAdvisedToRest", "ok");
            return aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.e("CheckIsUserAdvisedToRestApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f46852a.errMsg)) {
                d.a.h0.g.x.g.c cVar = this.f46852a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
            }
            b.this.f46851i.post(new RunnableC0970b());
        }
    }

    public b(@NonNull d.a.h0.g.i.b bVar) {
        this.f46851i = bVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null || this.f46851i == null) {
            return;
        }
        d.a.h0.g.x.g.c cVar = new d.a.h0.g.x.g.c();
        try {
            int d2 = F.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.h0.a.r1.e.T());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (d.a.h0.g.x.a.f46850h) {
                    e2.printStackTrace();
                }
            }
            q(d.a.h0.a.w0.a.l().g(), jSONObject.toString(), new a(cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (d.a.h0.g.x.a.f46850h) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.b("checkIsUserAdvisedToRest", e3);
            d.a.h0.g.i0.b.a(F, false, cVar);
        }
    }
}
