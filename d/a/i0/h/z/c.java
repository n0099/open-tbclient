package d.a.i0.h.z;

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
public class c extends d.a.i0.h.z.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.l0.c f47600b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.z.g.c f47601a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47602b;

        /* renamed from: d.a.i0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1051a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f47604e;

            public RunnableC1051a(JSONObject jSONObject) {
                this.f47604e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.h.m0.c.a(a.this.f47602b, true, this.f47604e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.i0.h.m0.c.a(aVar.f47602b, false, aVar.f47601a);
            }
        }

        public a(d.a.i0.h.z.g.c cVar, d.a.i0.a.y.b.a aVar) {
            this.f47601a = cVar;
            this.f47602b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f47600b.post(new RunnableC1051a(jSONObject));
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
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.i0.h.z.a.f47592a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.i0.h.z.g.c cVar = this.f47601a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.i0.h.m0.c.c("getUserInfo", "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f47601a.errMsg)) {
                d.a.i0.h.z.g.c cVar = this.f47601a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
            }
            c.this.f47600b.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<d.a.i0.h.z.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.z.g.c f47607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47608b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.h.z.g.c f47610e;

            public a(d.a.i0.h.z.g.c cVar) {
                this.f47610e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.h.m0.c.a(b.this.f47608b, true, this.f47610e);
            }
        }

        /* renamed from: d.a.i0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1052b implements Runnable {
            public RunnableC1052b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.a.i0.h.m0.c.a(bVar.f47608b, false, bVar.f47607a);
            }
        }

        public b(d.a.i0.h.z.g.c cVar, d.a.i0.a.y.b.a aVar) {
            this.f47607a = cVar;
            this.f47608b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.i0.h.z.g.c cVar, int i2) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "on success ");
            }
            c.this.f47600b.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.i0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.i0.h.z.a.f47592a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.i0.h.z.g.c cVar = this.f47607a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.a.i0.h.z.g.c cVar2 = this.f47607a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.a.i0.h.m0.c.c("removeUserCloudStorage", "ok");
            return this.f47607a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f47607a.errMsg)) {
                d.a.i0.h.z.g.c cVar = this.f47607a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
            }
            c.this.f47600b.post(new RunnableC1052b());
        }
    }

    /* renamed from: d.a.i0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1053c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.z.g.c f47613a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47614b;

        /* renamed from: d.a.i0.h.z.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f47616e;

            public a(JSONObject jSONObject) {
                this.f47616e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.h.m0.c.a(C1053c.this.f47614b, true, this.f47616e);
            }
        }

        /* renamed from: d.a.i0.h.z.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1053c c1053c = C1053c.this;
                d.a.i0.h.m0.c.a(c1053c.f47614b, false, c1053c.f47613a);
            }
        }

        public C1053c(d.a.i0.h.z.g.c cVar, d.a.i0.a.y.b.a aVar) {
            this.f47613a = cVar;
            this.f47614b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f47600b.post(new a(jSONObject));
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
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.i0.h.z.a.f47592a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.i0.h.z.g.c cVar = this.f47613a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.i0.h.m0.c.c("getUserCloudStorage", "ok"));
            jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f47613a.errMsg)) {
                d.a.i0.h.z.g.c cVar = this.f47613a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
            }
            c.this.f47600b.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<d.a.i0.h.z.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.z.g.c f47619a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47620b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.h.z.g.c f47622e;

            public a(d.a.i0.h.z.g.c cVar) {
                this.f47622e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.h.m0.c.a(d.this.f47620b, true, this.f47622e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                d.a.i0.h.m0.c.a(dVar.f47620b, false, dVar.f47619a);
            }
        }

        public d(d.a.i0.h.z.g.c cVar, d.a.i0.a.y.b.a aVar) {
            this.f47619a = cVar;
            this.f47620b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.i0.h.z.g.c cVar, int i2) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f47600b.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.i0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.i0.h.z.a.f47592a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.i0.h.z.g.c cVar = this.f47619a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.a.i0.h.z.g.c cVar2 = this.f47619a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "ok");
            return this.f47619a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f47619a.errMsg)) {
                d.a.i0.h.z.g.c cVar = this.f47619a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
            }
            c.this.f47600b.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.z.g.c f47625a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47626b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47627c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f47629e;

            public a(JSONObject jSONObject) {
                this.f47629e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.i0.h.m0.c.a(e.this.f47627c, true, this.f47629e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                d.a.i0.h.m0.c.a(eVar.f47627c, false, eVar.f47625a);
            }
        }

        public e(d.a.i0.h.z.g.c cVar, String str, d.a.i0.a.y.b.a aVar) {
            this.f47625a = cVar;
            this.f47626b = str;
            this.f47627c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f47600b.post(new a(jSONObject));
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
            if (d.a.i0.h.z.a.f47592a) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.i0.h.z.a.f47592a) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.i0.h.z.g.c cVar = this.f47625a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", this.f47626b, jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.i0.h.m0.c.c(this.f47626b, "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.i0.h.z.a.f47592a) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f47625a.errMsg)) {
                d.a.i0.h.z.g.c cVar = this.f47625a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", this.f47626b, exc.getMessage());
            }
            c.this.f47600b.post(new b());
        }
    }

    public c(@NonNull d.a.i0.a.l0.c cVar) {
        this.f47600b = cVar;
    }

    public final d.a.i0.h.z.g.b[] c(d.a.i0.a.y.b.a aVar, JsObject[] jsObjectArr, d.a.i0.h.z.g.c cVar) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            d.a.i0.h.m0.c.a(aVar, false, cVar);
            return null;
        } else if (length > 128) {
            cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            d.a.i0.h.m0.c.a(aVar, false, cVar);
            return null;
        } else {
            d.a.i0.h.z.g.b[] bVarArr = new d.a.i0.h.z.g.b[length];
            for (int i2 = 0; i2 < length; i2++) {
                d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObjectArr[i2]);
                if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                    bVarArr[i2] = new d.a.i0.h.z.g.b();
                    bVarArr[i2].key = G.C("key");
                    bVarArr[i2].value = G.C("value");
                    if (!bVarArr[i2].a()) {
                        cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                        d.a.i0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    } else if (!bVarArr[i2].b()) {
                        cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                        d.a.i0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    }
                } else {
                    cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail invalid KVData item");
                    d.a.i0.h.m0.c.a(aVar, false, cVar);
                    return null;
                }
            }
            return bVarArr;
        }
    }

    public final void d(JsObject jsObject, int i2) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        if (i2 == 5) {
            d.a.i0.h.z.g.c cVar = new d.a.i0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.i0.h.m0.c.c("getFriendCloudStorage", "fail must login before calling");
                d.a.i0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = G.h("keyList");
                h(jsObject);
                j(i2, h2, new e(cVar, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.a.i0.h.z.a.f47592a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.i0.h.m0.c.c("getFriendCloudStorage", "fail invalid keyList");
                d.a.i0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(d.a.i0.h.z.g.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.i0.a.a2.e.V());
            JSONArray jSONArray = new JSONArray();
            for (d.a.i0.h.z.g.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put("value", bVar.value);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            if (d.a.i0.h.z.a.f47592a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final String f(int i2) {
        String o;
        if (i2 == 1) {
            o = d.a.i0.h.t.a.b().o();
        } else if (i2 == 2) {
            o = d.a.i0.h.t.a.b().k();
        } else if (i2 == 3) {
            o = d.a.i0.h.t.a.b().p();
        } else if (i2 != 4) {
            o = i2 != 5 ? "" : d.a.i0.h.t.a.b().i();
        } else {
            o = d.a.i0.h.t.a.b().m();
        }
        if (TextUtils.isEmpty(o) && d.a.i0.h.z.a.f47592a) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return o;
    }

    public final boolean g() {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
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
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.i0.h.z.g.c cVar = new d.a.i0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.c("getUserCloudStorage", "fail must login before calling");
            d.a.i0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(3, h2, new C1053c(cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.i0.h.z.a.f47592a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.c("getUserCloudStorage", "fail invalid keyList");
            d.a.i0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
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
            if (d.a.i0.h.z.a.f47592a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.i0.a.a2.e.V());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.a.i0.h.z.a.f47592a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(new d.a.i0.h.z.g.c(), G));
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
            jSONObject.put("ma_id", d.a.i0.a.a2.e.V());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e2) {
            if (d.a.i0.h.z.a.f47592a) {
                e2.printStackTrace();
            }
        }
        a(f(i2), jSONObject.toString(), responseCallback);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.i0.h.z.g.c cVar = new d.a.i0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.c("removeUserCloudStorage", "fail must login before calling");
            d.a.i0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(2, h2, new b(cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.i0.h.z.a.f47592a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.c("removeUserCloudStorage", "fail invalid keyList");
            d.a.i0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        d.a.i0.h.z.g.c cVar = new d.a.i0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail must login before calling");
            d.a.i0.h.m0.c.a(G, false, cVar);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            d.a.i0.h.z.g.b[] c2 = c(G, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.i0.h.z.a.f47592a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.i0.h.m0.c.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.a.i0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }
}
