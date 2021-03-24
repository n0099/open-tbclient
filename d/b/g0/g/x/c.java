package d.b.g0.g.x;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.g.x.a {
    public d.b.g0.g.i.b i;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f48639a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48640b;

        /* renamed from: d.b.g0.g.x.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0999a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f48642e;

            public RunnableC0999a(JSONObject jSONObject) {
                this.f48642e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(a.this.f48640b, true, this.f48642e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.b.g0.g.i0.b.a(aVar.f48640b, false, aVar.f48639a);
            }
        }

        public a(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f48639a = cVar;
            this.f48640b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new RunnableC0999a(jSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f48632h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f48639a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.g0.g.i0.b.c("getUserInfo", "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f48639a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f48639a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<d.b.g0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f48645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48646b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.x.g.c f48648e;

            public a(d.b.g0.g.x.g.c cVar) {
                this.f48648e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(b.this.f48646b, true, this.f48648e);
            }
        }

        /* renamed from: d.b.g0.g.x.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1000b implements Runnable {
            public RunnableC1000b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.b.g0.g.i0.b.a(bVar.f48646b, false, bVar.f48645a);
            }
        }

        public b(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f48645a = cVar;
            this.f48646b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.g.x.g.c cVar, int i) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "on success ");
            }
            c.this.i.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.g0.g.x.g.c parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f48632h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f48645a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.b.g0.g.x.g.c cVar2 = this.f48645a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.b.g0.g.i0.b.c("removeUserCloudStorage", "ok");
            return this.f48645a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f48645a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f48645a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new RunnableC1000b());
        }
    }

    /* renamed from: d.b.g0.g.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1001c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f48651a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48652b;

        /* renamed from: d.b.g0.g.x.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f48654e;

            public a(JSONObject jSONObject) {
                this.f48654e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(C1001c.this.f48652b, true, this.f48654e);
            }
        }

        /* renamed from: d.b.g0.g.x.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1001c c1001c = C1001c.this;
                d.b.g0.g.i0.b.a(c1001c.f48652b, false, c1001c.f48651a);
            }
        }

        public C1001c(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f48651a = cVar;
            this.f48652b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new a(jSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f48632h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f48651a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.g0.g.i0.b.c("getUserCloudStorage", "ok"));
            jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f48651a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f48651a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<d.b.g0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f48657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48658b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.x.g.c f48660e;

            public a(d.b.g0.g.x.g.c cVar) {
                this.f48660e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(d.this.f48658b, true, this.f48660e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                d.b.g0.g.i0.b.a(dVar.f48658b, false, dVar.f48657a);
            }
        }

        public d(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f48657a = cVar;
            this.f48658b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.g.x.g.c cVar, int i) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.g0.g.x.g.c parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f48632h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f48657a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.b.g0.g.x.g.c cVar2 = this.f48657a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "ok");
            return this.f48657a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f48657a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f48657a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f48663a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48665c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f48667e;

            public a(JSONObject jSONObject) {
                this.f48667e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(e.this.f48665c, true, this.f48667e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                d.b.g0.g.i0.b.a(eVar.f48665c, false, eVar.f48663a);
            }
        }

        public e(d.b.g0.g.x.g.c cVar, String str, d.b.g0.g.e.d.c cVar2) {
            this.f48663a = cVar;
            this.f48664b = str;
            this.f48665c = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new a(jSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.g0.g.x.a.f48632h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f48632h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f48663a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", this.f48664b, jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.g0.g.i0.b.c(this.f48664b, "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f48632h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f48663a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f48663a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", this.f48664b, exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    public c(@NonNull d.b.g0.g.i.b bVar) {
        this.i = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        t(jsObject, 5);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.g0.g.x.g.c cVar = new d.b.g0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.c("getUserCloudStorage", "fail must login before calling");
            d.b.g0.g.i0.b.a(F, false, cVar);
            x(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            x(jsObject);
            z(3, h2, new C1001c(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.b.g0.g.x.a.f48632h) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.c("getUserCloudStorage", "fail invalid keyList");
            d.b.g0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h2 = F.h("swanIdList");
            if (h2 != null && h2.length > 0) {
                for (String str : h2) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (d.b.g0.g.x.a.f48632h) {
                e2.printStackTrace();
            }
        }
        x(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.b.g0.a.r1.e.T());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.b.g0.g.x.a.f48632h) {
                e3.printStackTrace();
            }
        }
        q(v(1), jSONObject.toString(), new a(new d.b.g0.g.x.g.c(), F));
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.g0.g.x.g.c cVar = new d.b.g0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.c("removeUserCloudStorage", "fail must login before calling");
            d.b.g0.g.i0.b.a(F, false, cVar);
            x(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            x(jsObject);
            z(2, h2, new b(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.b.g0.g.x.a.f48632h) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.c("removeUserCloudStorage", "fail invalid keyList");
            d.b.g0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    public final d.b.g0.g.x.g.b[] s(d.b.g0.g.e.d.c cVar, JsObject[] jsObjectArr, d.b.g0.g.x.g.c cVar2) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            d.b.g0.g.i0.b.a(cVar, false, cVar2);
            return null;
        } else if (length > 128) {
            cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            d.b.g0.g.i0.b.a(cVar, false, cVar2);
            return null;
        } else {
            d.b.g0.g.x.g.b[] bVarArr = new d.b.g0.g.x.g.b[length];
            for (int i = 0; i < length; i++) {
                d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObjectArr[i]);
                if (F != null && F.l() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                    bVarArr[i] = new d.b.g0.g.x.g.b();
                    bVarArr[i].key = F.B("key");
                    bVarArr[i].value = F.B("value");
                    if (!bVarArr[i].a()) {
                        cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                        d.b.g0.g.i0.b.a(cVar, false, cVar2);
                        return null;
                    } else if (!bVarArr[i].b()) {
                        cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                        d.b.g0.g.i0.b.a(cVar, false, cVar2);
                        return null;
                    }
                } else {
                    cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail invalid KVData item");
                    d.b.g0.g.i0.b.a(cVar, false, cVar2);
                    return null;
                }
            }
            return bVarArr;
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.g0.g.x.g.c cVar = new d.b.g0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail must login before calling");
            d.b.g0.g.i0.b.a(F, false, cVar);
            y(F.z("KVDataList"));
            x(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            x(jsObject);
            d.b.g0.g.x.g.b[] s = s(F, e2, cVar);
            y(e2);
            if (s == null) {
                return;
            }
            q(v(4), u(s).toString(), new d(cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (d.b.g0.g.x.a.f48632h) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.b.g0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    public final void t(JsObject jsObject, int i) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        if (i == 5) {
            d.b.g0.g.x.g.c cVar = new d.b.g0.g.x.g.c();
            if (!w()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.b.g0.g.i0.b.c("getFriendCloudStorage", "fail must login before calling");
                d.b.g0.g.i0.b.a(F, false, cVar);
                x(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                x(jsObject);
                z(i, h2, new e(cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.b.g0.g.x.a.f48632h) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.b.g0.g.i0.b.c("getFriendCloudStorage", "fail invalid keyList");
                d.b.g0.g.i0.b.a(F, false, cVar);
                x(jsObject);
                return;
            }
        }
        x(jsObject);
    }

    public final JSONObject u(d.b.g0.g.x.g.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.b.g0.a.r1.e.T());
            JSONArray jSONArray = new JSONArray();
            for (d.b.g0.g.x.g.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put("value", bVar.value);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            if (d.b.g0.g.x.a.f48632h) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final String v(int i) {
        String n;
        if (i == 1) {
            n = d.b.g0.a.w0.a.l().n();
        } else if (i == 2) {
            n = d.b.g0.a.w0.a.l().d();
        } else if (i == 3) {
            n = d.b.g0.a.w0.a.l().v();
        } else if (i != 4) {
            n = i != 5 ? "" : d.b.g0.a.w0.a.l().I();
        } else {
            n = d.b.g0.a.w0.a.l().k();
        }
        if (TextUtils.isEmpty(n) && d.b.g0.g.x.a.f48632h) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return n;
    }

    public final boolean w() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            return false;
        }
        return y.z().e(AppRuntime.getAppContext());
    }

    public final void x(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    public final void y(JsObject[] jsObjectArr) {
        if (jsObjectArr != null) {
            for (JsObject jsObject : jsObjectArr) {
                x(jsObject);
            }
        }
    }

    public final <T> void z(int i, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (strArr.length > 0) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        try {
            jSONObject.put("ma_id", d.b.g0.a.r1.e.T());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e2) {
            if (d.b.g0.g.x.a.f48632h) {
                e2.printStackTrace();
            }
        }
        q(v(i), jSONObject.toString(), responseCallback);
    }
}
