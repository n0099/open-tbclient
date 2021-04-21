package d.b.h0.g.x;

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
public class c extends d.b.h0.g.x.a {
    public d.b.h0.g.i.b i;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.x.g.c f49361a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f49362b;

        /* renamed from: d.b.h0.g.x.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1032a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f49364e;

            public RunnableC1032a(JSONObject jSONObject) {
                this.f49364e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.g.i0.b.a(a.this.f49362b, true, this.f49364e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.b.h0.g.i0.b.a(aVar.f49362b, false, aVar.f49361a);
            }
        }

        public a(d.b.h0.g.x.g.c cVar, d.b.h0.g.e.d.c cVar2) {
            this.f49361a = cVar;
            this.f49362b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new RunnableC1032a(jSONObject));
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
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.h0.g.x.a.f49354h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.h0.g.x.g.c cVar = this.f49361a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.h0.g.i0.b.c("getUserInfo", "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f49361a.errMsg)) {
                d.b.h0.g.x.g.c cVar = this.f49361a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<d.b.h0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.x.g.c f49367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f49368b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.x.g.c f49370e;

            public a(d.b.h0.g.x.g.c cVar) {
                this.f49370e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.g.i0.b.a(b.this.f49368b, true, this.f49370e);
            }
        }

        /* renamed from: d.b.h0.g.x.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1033b implements Runnable {
            public RunnableC1033b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.b.h0.g.i0.b.a(bVar.f49368b, false, bVar.f49367a);
            }
        }

        public b(d.b.h0.g.x.g.c cVar, d.b.h0.g.e.d.c cVar2) {
            this.f49367a = cVar;
            this.f49368b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.h0.g.x.g.c cVar, int i) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "on success ");
            }
            c.this.i.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.h0.g.x.g.c parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.h0.g.x.a.f49354h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.h0.g.x.g.c cVar = this.f49367a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.b.h0.g.x.g.c cVar2 = this.f49367a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.b.h0.g.i0.b.c("removeUserCloudStorage", "ok");
            return this.f49367a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f49367a.errMsg)) {
                d.b.h0.g.x.g.c cVar = this.f49367a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new RunnableC1033b());
        }
    }

    /* renamed from: d.b.h0.g.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1034c extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.x.g.c f49373a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f49374b;

        /* renamed from: d.b.h0.g.x.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f49376e;

            public a(JSONObject jSONObject) {
                this.f49376e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.g.i0.b.a(C1034c.this.f49374b, true, this.f49376e);
            }
        }

        /* renamed from: d.b.h0.g.x.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1034c c1034c = C1034c.this;
                d.b.h0.g.i0.b.a(c1034c.f49374b, false, c1034c.f49373a);
            }
        }

        public C1034c(d.b.h0.g.x.g.c cVar, d.b.h0.g.e.d.c cVar2) {
            this.f49373a = cVar;
            this.f49374b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.h0.g.x.a.f49354h) {
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
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.h0.g.x.a.f49354h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.h0.g.x.g.c cVar = this.f49373a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.h0.g.i0.b.c("getUserCloudStorage", "ok"));
            jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f49373a.errMsg)) {
                d.b.h0.g.x.g.c cVar = this.f49373a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<d.b.h0.g.x.g.c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.x.g.c f49379a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f49380b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.g.x.g.c f49382e;

            public a(d.b.h0.g.x.g.c cVar) {
                this.f49382e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.g.i0.b.a(d.this.f49380b, true, this.f49382e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                d.b.h0.g.i0.b.a(dVar.f49380b, false, dVar.f49379a);
            }
        }

        public d(d.b.h0.g.x.g.c cVar, d.b.h0.g.e.d.c cVar2) {
            this.f49379a = cVar;
            this.f49380b = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.h0.g.x.g.c cVar, int i) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "on success");
            }
            c.this.i.post(new a(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.h0.g.x.g.c parseResponse(Response response, int i) throws Exception {
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String string = body.string();
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.h0.g.x.a.f49354h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.h0.g.x.g.c cVar = this.f49379a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                return null;
            }
            d.b.h0.g.x.g.c cVar2 = this.f49379a;
            cVar2.errNo = "0";
            cVar2.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "ok");
            return this.f49379a;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.e("OpenDataApi", "on fail");
            }
            if (TextUtils.isEmpty(this.f49379a.errMsg)) {
                d.b.h0.g.x.g.c cVar = this.f49379a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.x.g.c f49385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49386b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f49387c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f49389e;

            public a(JSONObject jSONObject) {
                this.f49389e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.g.i0.b.a(e.this.f49387c, true, this.f49389e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                d.b.h0.g.i0.b.a(eVar.f49387c, false, eVar.f49385a);
            }
        }

        public e(d.b.h0.g.x.g.c cVar, String str, d.b.h0.g.e.d.c cVar2) {
            this.f49385a = cVar;
            this.f49386b = str;
            this.f49387c = cVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (d.b.h0.g.x.a.f49354h) {
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
            if (d.b.h0.g.x.a.f49354h) {
                Log.d("OpenDataApi", "parse response: " + string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("errno");
            if (!TextUtils.equals(optString, "0")) {
                if (d.b.h0.g.x.a.f49354h) {
                    Log.d("OpenDataApi", "errno = " + optString);
                }
                d.b.h0.g.x.g.c cVar = this.f49385a;
                cVar.errNo = optString;
                cVar.errMsg = String.format("%s: fail Error: %s", this.f49386b, jSONObject.optString("errmsg"));
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errNo", "0");
            jSONObject2.put("errMsg", d.b.h0.g.i0.b.c(this.f49386b, "ok"));
            jSONObject2.put("data", jSONObject.optJSONArray("data"));
            return jSONObject2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d.b.h0.g.x.a.f49354h) {
                Log.e("OpenDataApi", "on fail");
                exc.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f49385a.errMsg)) {
                d.b.h0.g.x.g.c cVar = this.f49385a;
                cVar.errNo = "100";
                cVar.errMsg = String.format("%s: fail Error: %s", this.f49386b, exc.getMessage());
            }
            c.this.i.post(new b());
        }
    }

    public c(@NonNull d.b.h0.g.i.b bVar) {
        this.i = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        t(jsObject, 5);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.h0.g.x.g.c cVar = new d.b.h0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.h0.g.i0.b.c("getUserCloudStorage", "fail must login before calling");
            d.b.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            x(jsObject);
            z(3, h2, new C1034c(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.b.h0.g.x.a.f49354h) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.h0.g.i0.b.c("getUserCloudStorage", "fail invalid keyList");
            d.b.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
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
            if (d.b.h0.g.x.a.f49354h) {
                e2.printStackTrace();
            }
        }
        x(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.b.h0.a.r1.e.T());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.b.h0.g.x.a.f49354h) {
                e3.printStackTrace();
            }
        }
        q(v(1), jSONObject.toString(), new a(new d.b.h0.g.x.g.c(), F));
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.h0.g.x.g.c cVar = new d.b.h0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.h0.g.i0.b.c("removeUserCloudStorage", "fail must login before calling");
            d.b.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            x(jsObject);
            z(2, h2, new b(cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (d.b.h0.g.x.a.f49354h) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.h0.g.i0.b.c("removeUserCloudStorage", "fail invalid keyList");
            d.b.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    public final d.b.h0.g.x.g.b[] s(d.b.h0.g.e.d.c cVar, JsObject[] jsObjectArr, d.b.h0.g.x.g.c cVar2) {
        int length = jsObjectArr.length;
        if (length < 1) {
            cVar2.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
            d.b.h0.g.i0.b.a(cVar, false, cVar2);
            return null;
        } else if (length > 128) {
            cVar2.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
            d.b.h0.g.i0.b.a(cVar, false, cVar2);
            return null;
        } else {
            d.b.h0.g.x.g.b[] bVarArr = new d.b.h0.g.x.g.b[length];
            for (int i = 0; i < length; i++) {
                d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObjectArr[i]);
                if (F != null && F.l() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                    bVarArr[i] = new d.b.h0.g.x.g.b();
                    bVarArr[i].key = F.B("key");
                    bVarArr[i].value = F.B("value");
                    if (!bVarArr[i].a()) {
                        cVar2.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                        d.b.h0.g.i0.b.a(cVar, false, cVar2);
                        return null;
                    } else if (!bVarArr[i].b()) {
                        cVar2.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                        d.b.h0.g.i0.b.a(cVar, false, cVar2);
                        return null;
                    }
                } else {
                    cVar2.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail invalid KVData item");
                    d.b.h0.g.i0.b.a(cVar, false, cVar2);
                    return null;
                }
            }
            return bVarArr;
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.h0.g.x.g.c cVar = new d.b.h0.g.x.g.c();
        if (!w()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail must login before calling");
            d.b.h0.g.i0.b.a(F, false, cVar);
            y(F.z("KVDataList"));
            x(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            x(jsObject);
            d.b.h0.g.x.g.b[] s = s(F, e2, cVar);
            y(e2);
            if (s == null) {
                return;
            }
            q(v(4), u(s).toString(), new d(cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (d.b.h0.g.x.a.f49354h) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.b.h0.g.i0.b.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.b.h0.g.i0.b.a(F, false, cVar);
            x(jsObject);
        }
    }

    public final void t(JsObject jsObject, int i) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        if (i == 5) {
            d.b.h0.g.x.g.c cVar = new d.b.h0.g.x.g.c();
            if (!w()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.b.h0.g.i0.b.c("getFriendCloudStorage", "fail must login before calling");
                d.b.h0.g.i0.b.a(F, false, cVar);
                x(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                x(jsObject);
                z(i, h2, new e(cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.b.h0.g.x.a.f49354h) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.b.h0.g.i0.b.c("getFriendCloudStorage", "fail invalid keyList");
                d.b.h0.g.i0.b.a(F, false, cVar);
                x(jsObject);
                return;
            }
        }
        x(jsObject);
    }

    public final JSONObject u(d.b.h0.g.x.g.b[] bVarArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.b.h0.a.r1.e.T());
            JSONArray jSONArray = new JSONArray();
            for (d.b.h0.g.x.g.b bVar : bVarArr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", bVar.key);
                jSONObject2.put("value", bVar.value);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            if (d.b.h0.g.x.a.f49354h) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final String v(int i) {
        String n;
        if (i == 1) {
            n = d.b.h0.a.w0.a.l().n();
        } else if (i == 2) {
            n = d.b.h0.a.w0.a.l().d();
        } else if (i == 3) {
            n = d.b.h0.a.w0.a.l().v();
        } else if (i != 4) {
            n = i != 5 ? "" : d.b.h0.a.w0.a.l().I();
        } else {
            n = d.b.h0.a.w0.a.l().k();
        }
        if (TextUtils.isEmpty(n) && d.b.h0.g.x.a.f49354h) {
            Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
        }
        return n;
    }

    public final boolean w() {
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
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
            jSONObject.put("ma_id", d.b.h0.a.r1.e.T());
            jSONObject.put("key_list", jSONArray);
        } catch (JSONException e2) {
            if (d.b.h0.g.x.a.f49354h) {
                e2.printStackTrace();
            }
        }
        q(v(i), jSONObject.toString(), responseCallback);
    }
}
