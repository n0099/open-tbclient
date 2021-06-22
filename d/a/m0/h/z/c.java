package d.a.m0.h.z;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.h.z.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.l0.c f51558b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.z.g.c f51559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y.b.a f51560b;

        /* renamed from: d.a.m0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1121a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f51562e;

            public RunnableC1121a(JSONObject jSONObject) {
                this.f51562e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.h.m0.c.a(a.this.f51560b, true, this.f51562e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.m0.h.m0.c.a(aVar.f51560b, false, aVar.f51559a);
            }
        }

        public a(d.a.m0.h.z.g.c cVar, d.a.m0.a.y.b.a aVar) {
            this.f51559a = cVar;
            this.f51560b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f51558b.post(new RunnableC1121a(jSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.m0.h.z.a.f51550a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.m0.h.z.g.c cVar = this.f51559a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.m0.h.m0.c.c("getUserInfo", "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f51559a.errMsg)) {
                d.a.m0.h.z.g.c cVar = this.f51559a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
            }
            c.this.f51558b.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<d.a.m0.h.z.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.z.g.c f51565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y.b.a f51566b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.h.z.g.c f51568e;

            public a(d.a.m0.h.z.g.c cVar) {
                this.f51568e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.h.m0.c.a(b.this.f51566b, true, this.f51568e);
            }
        }

        /* renamed from: d.a.m0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1122b implements Runnable {
            public RunnableC1122b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.a.m0.h.m0.c.a(bVar.f51566b, false, bVar.f51565a);
            }
        }

        public b(d.a.m0.h.z.g.c cVar, d.a.m0.a.y.b.a aVar) {
            this.f51565a = cVar;
            this.f51566b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.m0.h.z.g.c cVar, int i2) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "on success ");
            }
            c.this.f51558b.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.m0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.m0.h.z.a.f51550a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.m0.h.z.g.c cVar = this.f51565a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.a.m0.h.z.g.c cVar2 = this.f51565a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.a.m0.h.m0.c.c("removeUserCloudStorage", "ok");
            return this.f51565a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f51565a.errMsg)) {
                d.a.m0.h.z.g.c cVar = this.f51565a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
            }
            c.this.f51558b.post(new RunnableC1122b());
        }
    }

    /* renamed from: d.a.m0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1123c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.z.g.c f51571a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y.b.a f51572b;

        /* renamed from: d.a.m0.h.z.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f51574e;

            public a(JSONObject jSONObject) {
                this.f51574e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.h.m0.c.a(C1123c.this.f51572b, true, this.f51574e);
            }
        }

        /* renamed from: d.a.m0.h.z.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1123c c1123c = C1123c.this;
                d.a.m0.h.m0.c.a(c1123c.f51572b, false, c1123c.f51571a);
            }
        }

        public C1123c(d.a.m0.h.z.g.c cVar, d.a.m0.a.y.b.a aVar) {
            this.f51571a = cVar;
            this.f51572b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f51558b.post(new a(jSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.m0.h.z.a.f51550a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.m0.h.z.g.c cVar = this.f51571a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.m0.h.m0.c.c("getUserCloudStorage", "ok"));
            jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f51571a.errMsg)) {
                d.a.m0.h.z.g.c cVar = this.f51571a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
            }
            c.this.f51558b.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<d.a.m0.h.z.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.z.g.c f51577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y.b.a f51578b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.h.z.g.c f51580e;

            public a(d.a.m0.h.z.g.c cVar) {
                this.f51580e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.h.m0.c.a(d.this.f51578b, true, this.f51580e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                d.a.m0.h.m0.c.a(dVar.f51578b, false, dVar.f51577a);
            }
        }

        public d(d.a.m0.h.z.g.c cVar, d.a.m0.a.y.b.a aVar) {
            this.f51577a = cVar;
            this.f51578b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.m0.h.z.g.c cVar, int i2) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f51558b.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.m0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.m0.h.z.a.f51550a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.m0.h.z.g.c cVar = this.f51577a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.a.m0.h.z.g.c cVar2 = this.f51577a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "ok");
            return this.f51577a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f51577a.errMsg)) {
                d.a.m0.h.z.g.c cVar = this.f51577a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
            }
            c.this.f51558b.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.z.g.c f51583a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51584b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y.b.a f51585c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f51587e;

            public a(JSONObject jSONObject) {
                this.f51587e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.h.m0.c.a(e.this.f51585c, true, this.f51587e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                d.a.m0.h.m0.c.a(eVar.f51585c, false, eVar.f51583a);
            }
        }

        public e(d.a.m0.h.z.g.c cVar, String str, d.a.m0.a.y.b.a aVar) {
            this.f51583a = cVar;
            this.f51584b = str;
            this.f51585c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f51558b.post(new a(jSONObject));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.m0.h.z.a.f51550a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.m0.h.z.a.f51550a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.m0.h.z.g.c cVar = this.f51583a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", this.f51584b, jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.m0.h.m0.c.c(this.f51584b, "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.m0.h.z.a.f51550a) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f51583a.errMsg)) {
                d.a.m0.h.z.g.c cVar = this.f51583a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", this.f51584b, exc.getMessage());
            }
            c.this.f51558b.post(new b());
        }
    }

    public c(@NonNull d.a.m0.a.l0.c cVar) {
        this.f51558b = cVar;
    }

    public final d.a.m0.h.z.g.b[] c(d.a.m0.a.y.b.a aVar, JsObject[] jsObjectArr, d.a.m0.h.z.g.c cVar) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            d.a.m0.h.m0.c.a(aVar, false, cVar);
            return null;
        } else if (length > 128) {
            cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            d.a.m0.h.m0.c.a(aVar, false, cVar);
            return null;
        } else {
            d.a.m0.h.z.g.b[] bVarArr = new d.a.m0.h.z.g.b[length];
            for (int i2 = 0; i2 < length; i2++) {
                d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObjectArr[i2]);
                if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                    bVarArr[i2] = new d.a.m0.h.z.g.b();
                    bVarArr[i2].key = G.C("key");
                    bVarArr[i2].value = G.C("value");
                    if (!bVarArr[i2].a()) {
                        cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                        d.a.m0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    } else if (!bVarArr[i2].b()) {
                        cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                        d.a.m0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    }
                } else {
                    cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail invalid KVData item");
                    d.a.m0.h.m0.c.a(aVar, false, cVar);
                    return null;
                }
            }
            return bVarArr;
        }
    }

    public final void d(JsObject jsObject, int i2) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        if (i2 == 5) {
            d.a.m0.h.z.g.c cVar = new d.a.m0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.m0.h.m0.c.c("getFriendCloudStorage", "fail must login before calling");
                d.a.m0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = G.h("keyList");
                h(jsObject);
                j(i2, h2, new e(cVar, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.a.m0.h.z.a.f51550a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.m0.h.m0.c.c("getFriendCloudStorage", "fail invalid keyList");
                d.a.m0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(d.a.m0.h.z.g.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.m0.a.a2.e.V());
            JSONArray jSONArray = new JSONArray();
            for (d.a.m0.h.z.g.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put("value", bVar.value);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            if (d.a.m0.h.z.a.f51550a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final String f(int i2) {
        String o;
        if (i2 == 1) {
            o = d.a.m0.h.t.a.b().o();
        } else if (i2 == 2) {
            o = d.a.m0.h.t.a.b().k();
        } else if (i2 == 3) {
            o = d.a.m0.h.t.a.b().p();
        } else if (i2 != 4) {
            o = i2 != 5 ? "" : d.a.m0.h.t.a.b().i();
        } else {
            o = d.a.m0.h.t.a.b().m();
        }
        if (TextUtils.isEmpty(o) && d.a.m0.h.z.a.f51550a) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return o;
    }

    public final boolean g() {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return false;
        }
        return i2.j().e(AppRuntime.getAppContext());
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        d(jsObject, 5);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.m0.h.z.g.c cVar = new d.a.m0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.m0.h.m0.c.c("getUserCloudStorage", "fail must login before calling");
            d.a.m0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(3, h2, new C1123c(cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.m0.h.z.a.f51550a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.m0.h.m0.c.c("getUserCloudStorage", "fail invalid keyList");
            d.a.m0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h2 = G.h("swanIdList");
            if (h2 != null && h2.length > 0) {
                for (String str : h2) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (d.a.m0.h.z.a.f51550a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.m0.a.a2.e.V());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.a.m0.h.z.a.f51550a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(new d.a.m0.h.z.g.c(), G));
    }

    public final void h(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    public final void i(JsObject[] jsObjectArr) {
        if (jsObjectArr != null) {
            for (JsObject jsObject : jsObjectArr) {
                h(jsObject);
            }
        }
    }

    public final <T> void j(int i2, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (strArr.length > 0) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        try {
            jSONObject.put("ma_id", d.a.m0.a.a2.e.V());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e2) {
            if (d.a.m0.h.z.a.f51550a) {
                e2.printStackTrace();
            }
        }
        a(f(i2), jSONObject.toString(), responseCallback);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.m0.h.z.g.c cVar = new d.a.m0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.m0.h.m0.c.c("removeUserCloudStorage", "fail must login before calling");
            d.a.m0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(2, h2, new b(cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.m0.h.z.a.f51550a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.m0.h.m0.c.c("removeUserCloudStorage", "fail invalid keyList");
            d.a.m0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.m0.h.z.g.c cVar = new d.a.m0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail must login before calling");
            d.a.m0.h.m0.c.a(G, false, cVar);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            d.a.m0.h.z.g.b[] c2 = c(G, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.m0.h.z.a.f51550a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.m0.h.m0.c.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.a.m0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }
}
