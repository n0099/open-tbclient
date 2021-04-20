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
        public final /* synthetic */ d.b.g0.g.x.g.c f49032a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49033b;

        /* renamed from: d.b.g0.g.x.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1012a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f49035e;

            public RunnableC1012a(JSONObject jSONObject) {
                this.f49035e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(a.this.f49033b, true, this.f49035e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.b.g0.g.i0.b.a(aVar.f49033b, false, aVar.f49032a);
            }
        }

        public a(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f49032a = cVar;
            this.f49033b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new RunnableC1012a(jSONObject));
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f49025h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f49032a;
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f49032a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f49032a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<d.b.g0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f49038a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49039b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.x.g.c f49041e;

            public a(d.b.g0.g.x.g.c cVar) {
                this.f49041e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(b.this.f49039b, true, this.f49041e);
            }
        }

        /* renamed from: d.b.g0.g.x.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1013b implements Runnable {
            public RunnableC1013b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.b.g0.g.i0.b.a(bVar.f49039b, false, bVar.f49038a);
            }
        }

        public b(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f49038a = cVar;
            this.f49039b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.g.x.g.c cVar, int i) {
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f49025h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f49038a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.b.g0.g.x.g.c cVar2 = this.f49038a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.b.g0.g.i0.b.c("removeUserCloudStorage", "ok");
            return this.f49038a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f49038a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f49038a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new RunnableC1013b());
        }
    }

    /* renamed from: d.b.g0.g.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1014c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f49044a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49045b;

        /* renamed from: d.b.g0.g.x.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f49047e;

            public a(JSONObject jSONObject) {
                this.f49047e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(C1014c.this.f49045b, true, this.f49047e);
            }
        }

        /* renamed from: d.b.g0.g.x.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1014c c1014c = C1014c.this;
                d.b.g0.g.i0.b.a(c1014c.f49045b, false, c1014c.f49044a);
            }
        }

        public C1014c(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f49044a = cVar;
            this.f49045b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f49025h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f49044a;
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f49044a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f49044a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<d.b.g0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f49050a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49051b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.x.g.c f49053e;

            public a(d.b.g0.g.x.g.c cVar) {
                this.f49053e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(d.this.f49051b, true, this.f49053e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                d.b.g0.g.i0.b.a(dVar.f49051b, false, dVar.f49050a);
            }
        }

        public d(d.b.g0.g.x.g.c cVar, d.b.g0.g.e.d.c cVar2) {
            this.f49050a = cVar;
            this.f49051b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.g.x.g.c cVar, int i) {
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f49025h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f49050a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.b.g0.g.x.g.c cVar2 = this.f49050a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.b.g0.g.i0.b.c("setUserCloudStorage", "ok");
            return this.f49050a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f49025h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f49050a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f49050a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.x.g.c f49056a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49057b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f49058c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f49060e;

            public a(JSONObject jSONObject) {
                this.f49060e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.g.i0.b.a(e.this.f49058c, true, this.f49060e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                d.b.g0.g.i0.b.a(eVar.f49058c, false, eVar.f49056a);
            }
        }

        public e(d.b.g0.g.x.g.c cVar, String str, d.b.g0.g.e.d.c cVar2) {
            this.f49056a = cVar;
            this.f49057b = str;
            this.f49058c = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.g0.g.x.a.f49025h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.g0.g.x.g.c cVar = this.f49056a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", this.f49057b, jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.g0.g.i0.b.c(this.f49057b, "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.g.x.a.f49025h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f49056a.errMsg)) {
                d.b.g0.g.x.g.c cVar = this.f49056a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", this.f49057b, exc.getMessage());
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
            z(3, h2, new C1014c(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
                e2.printStackTrace();
            }
        }
        x(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.b.g0.a.r1.e.T());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
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
                if (d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
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
        if (TextUtils.isEmpty(n) && d.b.g0.g.x.a.f49025h) {
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
            if (d.b.g0.g.x.a.f49025h) {
                e2.printStackTrace();
            }
        }
        q(v(i), jSONObject.toString(), responseCallback);
    }
}
