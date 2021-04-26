package d.a.h0.g.x;

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
public class c extends d.a.h0.g.x.a {

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.g.i.b f46858i;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.x.g.c f46859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46860b;

        /* renamed from: d.a.h0.g.x.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0971a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f46862e;

            public RunnableC0971a(JSONObject jSONObject) {
                this.f46862e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.i0.b.a(a.this.f46860b, true, this.f46862e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.h0.g.i0.b.a(aVar.f46860b, false, aVar.f46859a);
            }
        }

        public a(d.a.h0.g.x.g.c cVar, d.a.h0.g.e.d.c cVar2) {
            this.f46859a = cVar;
            this.f46860b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f46858i.post(new RunnableC0971a(jSONObject));
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
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.h0.g.x.a.f46850h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.h0.g.x.g.c cVar = this.f46859a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.h0.g.i0.b.c("getUserInfo", "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f46859a.errMsg)) {
                d.a.h0.g.x.g.c cVar = this.f46859a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
            }
            c.this.f46858i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<d.a.h0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.x.g.c f46865a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46866b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.x.g.c f46868e;

            public a(d.a.h0.g.x.g.c cVar) {
                this.f46868e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.i0.b.a(b.this.f46866b, true, this.f46868e);
            }
        }

        /* renamed from: d.a.h0.g.x.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0972b implements Runnable {
            public RunnableC0972b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.a.h0.g.i0.b.a(bVar.f46866b, false, bVar.f46865a);
            }
        }

        public b(d.a.h0.g.x.g.c cVar, d.a.h0.g.e.d.c cVar2) {
            this.f46865a = cVar;
            this.f46866b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.h0.g.x.g.c cVar, int i2) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "on success ");
            }
            c.this.f46858i.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.h0.g.x.g.c parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.h0.g.x.a.f46850h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.h0.g.x.g.c cVar = this.f46865a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.a.h0.g.x.g.c cVar2 = this.f46865a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.a.h0.g.i0.b.c("removeUserCloudStorage", "ok");
            return this.f46865a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f46865a.errMsg)) {
                d.a.h0.g.x.g.c cVar = this.f46865a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
            }
            c.this.f46858i.post(new RunnableC0972b());
        }
    }

    /* renamed from: d.a.h0.g.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0973c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.x.g.c f46871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46872b;

        /* renamed from: d.a.h0.g.x.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f46874e;

            public a(JSONObject jSONObject) {
                this.f46874e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.i0.b.a(C0973c.this.f46872b, true, this.f46874e);
            }
        }

        /* renamed from: d.a.h0.g.x.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0973c c0973c = C0973c.this;
                d.a.h0.g.i0.b.a(c0973c.f46872b, false, c0973c.f46871a);
            }
        }

        public C0973c(d.a.h0.g.x.g.c cVar, d.a.h0.g.e.d.c cVar2) {
            this.f46871a = cVar;
            this.f46872b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f46858i.post(new a(jSONObject));
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
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.h0.g.x.a.f46850h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.h0.g.x.g.c cVar = this.f46871a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.h0.g.i0.b.c("getUserCloudStorage", "ok"));
            jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f46871a.errMsg)) {
                d.a.h0.g.x.g.c cVar = this.f46871a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
            }
            c.this.f46858i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<d.a.h0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.x.g.c f46877a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46878b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.g.x.g.c f46880e;

            public a(d.a.h0.g.x.g.c cVar) {
                this.f46880e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.i0.b.a(d.this.f46878b, true, this.f46880e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                d.a.h0.g.i0.b.a(dVar.f46878b, false, dVar.f46877a);
            }
        }

        public d(d.a.h0.g.x.g.c cVar, d.a.h0.g.e.d.c cVar2) {
            this.f46877a = cVar;
            this.f46878b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.h0.g.x.g.c cVar, int i2) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f46858i.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.h0.g.x.g.c parseResponse(Response response, int i2) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.h0.g.x.a.f46850h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.h0.g.x.g.c cVar = this.f46877a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.a.h0.g.x.g.c cVar2 = this.f46877a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "ok");
            return this.f46877a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f46877a.errMsg)) {
                d.a.h0.g.x.g.c cVar = this.f46877a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
            }
            c.this.f46858i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.x.g.c f46883a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46884b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46885c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f46887e;

            public a(JSONObject jSONObject) {
                this.f46887e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.g.i0.b.a(e.this.f46885c, true, this.f46887e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                d.a.h0.g.i0.b.a(eVar.f46885c, false, eVar.f46883a);
            }
        }

        public e(d.a.h0.g.x.g.c cVar, String str, d.a.h0.g.e.d.c cVar2) {
            this.f46883a = cVar;
            this.f46884b = str;
            this.f46885c = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.f46858i.post(new a(jSONObject));
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
            if (d.a.h0.g.x.a.f46850h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.a.h0.g.x.a.f46850h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.a.h0.g.x.g.c cVar = this.f46883a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", this.f46884b, jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.a.h0.g.i0.b.c(this.f46884b, "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.g.x.a.f46850h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f46883a.errMsg)) {
                d.a.h0.g.x.g.c cVar = this.f46883a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", this.f46884b, exc.getMessage());
            }
            c.this.f46858i.post(new b());
        }
    }

    public c(@NonNull d.a.h0.g.i.b bVar) {
        this.f46858i = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        t(jsObject, 5);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.a.h0.g.x.g.c cVar = new d.a.h0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.c("getUserCloudStorage", "fail must login before calling");
            d.a.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            x(jsObject);
            z(3, h2, new C0973c(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.a.h0.g.x.a.f46850h) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.c("getUserCloudStorage", "fail invalid keyList");
            d.a.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
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
            if (d.a.h0.g.x.a.f46850h) {
                e2.printStackTrace();
            }
        }
        x(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.h0.a.r1.e.T());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.a.h0.g.x.a.f46850h) {
                e3.printStackTrace();
            }
        }
        q(v(1), jSONObject.toString(), new a(new d.a.h0.g.x.g.c(), F));
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.a.h0.g.x.g.c cVar = new d.a.h0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.c("removeUserCloudStorage", "fail must login before calling");
            d.a.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            x(jsObject);
            z(2, h2, new b(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.a.h0.g.x.a.f46850h) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.c("removeUserCloudStorage", "fail invalid keyList");
            d.a.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    public final d.a.h0.g.x.g.b[] s(d.a.h0.g.e.d.c cVar, JsObject[] jsObjectArr, d.a.h0.g.x.g.c cVar2) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar2.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            d.a.h0.g.i0.b.a(cVar, false, cVar2);
            return null;
        } else if (length > 128) {
            cVar2.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            d.a.h0.g.i0.b.a(cVar, false, cVar2);
            return null;
        } else {
            d.a.h0.g.x.g.b[] bVarArr = new d.a.h0.g.x.g.b[length];
            for (int i2 = 0; i2 < length; i2++) {
                d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObjectArr[i2]);
                if (F != null && F.l() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                    bVarArr[i2] = new d.a.h0.g.x.g.b();
                    bVarArr[i2].key = F.B("key");
                    bVarArr[i2].value = F.B("value");
                    if (!bVarArr[i2].a()) {
                        cVar2.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                        d.a.h0.g.i0.b.a(cVar, false, cVar2);
                        return null;
                    } else if (!bVarArr[i2].b()) {
                        cVar2.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                        d.a.h0.g.i0.b.a(cVar, false, cVar2);
                        return null;
                    }
                } else {
                    cVar2.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail invalid KVData item");
                    d.a.h0.g.i0.b.a(cVar, false, cVar2);
                    return null;
                }
            }
            return bVarArr;
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.a.h0.g.x.g.c cVar = new d.a.h0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail must login before calling");
            d.a.h0.g.i0.b.a(F, false, cVar);
            y(F.z("KVDataList"));
            x(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            x(jsObject);
            d.a.h0.g.x.g.b[] s = s(F, e2, cVar);
            y(e2);
            if (s == null) {
                return;
            }
            q(v(4), u(s).toString(), new d(cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (d.a.h0.g.x.a.f46850h) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.h0.g.i0.b.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.a.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    public final void t(JsObject jsObject, int i2) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        if (i2 == 5) {
            d.a.h0.g.x.g.c cVar = new d.a.h0.g.x.g.c();
            if (!w()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.h0.g.i0.b.c("getFriendCloudStorage", "fail must login before calling");
                d.a.h0.g.i0.b.a(F, false, cVar);
                x(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                x(jsObject);
                z(i2, h2, new e(cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.a.h0.g.x.a.f46850h) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.h0.g.i0.b.c("getFriendCloudStorage", "fail invalid keyList");
                d.a.h0.g.i0.b.a(F, false, cVar);
                x(jsObject);
                return;
            }
        }
        x(jsObject);
    }

    public final JSONObject u(d.a.h0.g.x.g.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.h0.a.r1.e.T());
            JSONArray jSONArray = new JSONArray();
            for (d.a.h0.g.x.g.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put("value", bVar.value);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            if (d.a.h0.g.x.a.f46850h) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final String v(int i2) {
        String E;
        if (i2 == 1) {
            E = d.a.h0.a.w0.a.l().E();
        } else if (i2 == 2) {
            E = d.a.h0.a.w0.a.l().w();
        } else if (i2 == 3) {
            E = d.a.h0.a.w0.a.l().H();
        } else if (i2 != 4) {
            E = i2 != 5 ? "" : d.a.h0.a.w0.a.l().q();
        } else {
            E = d.a.h0.a.w0.a.l().B();
        }
        if (TextUtils.isEmpty(E) && d.a.h0.g.x.a.f46850h) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return E;
    }

    public final boolean w() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            return false;
        }
        return h2.i().e(AppRuntime.getAppContext());
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

    public final <T> void z(int i2, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (strArr.length > 0) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        try {
            jSONObject.put("ma_id", d.a.h0.a.r1.e.T());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e2) {
            if (d.a.h0.g.x.a.f46850h) {
                e2.printStackTrace();
            }
        }
        q(v(i2), jSONObject.toString(), responseCallback);
    }
}
