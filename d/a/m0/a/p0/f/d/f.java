package d.a.m0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.j.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {
    public static final String j = String.format("?swanjs_version=%s", d.a.m0.a.m2.b.h(0));
    public static final String k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
    public static final String l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";

    /* renamed from: c  reason: collision with root package name */
    public boolean f47839c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47840d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47841e;

    /* renamed from: f  reason: collision with root package name */
    public String f47842f;

    /* renamed from: g  reason: collision with root package name */
    public String f47843g;

    /* renamed from: h  reason: collision with root package name */
    public String f47844h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f47845i;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47848g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f47849h;

        public a(CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.a.m0.a.a2.e eVar) {
            this.f47846e = callbackHandler;
            this.f47847f = jSONObject;
            this.f47848g = context;
            this.f47849h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.p(iVar, this.f47846e, f.this.f47844h);
                return;
            }
            f.this.f47845i = new JSONObject();
            if (this.f47847f.optInt("loadCts") == 1) {
                f.this.u(this.f47848g);
                f fVar = f.this;
                fVar.w(this.f47849h, fVar.f47842f, this.f47846e, "master");
                f fVar2 = f.this;
                fVar2.w(this.f47849h, fVar2.f47843g, this.f47846e, "slave");
                f.this.f47841e = true;
                return;
            }
            f.this.f47841e = false;
            d.a.m0.a.u1.a.a.Q(false);
            d.a.m0.a.u1.a.a.X();
            this.f47846e.handleSchemeDispatchCallback(f.this.f47844h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f47851a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47852b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47853c;

        public b(d.a.m0.a.a2.e eVar, String str, CallbackHandler callbackHandler) {
            this.f47851a = eVar;
            this.f47852b = str;
            this.f47853c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.m0.a.e0.d.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
            this.f47853c.handleSchemeDispatchCallback(f.this.f47844h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            if (response.code() == 200 && response.body() != null) {
                f.this.s(this.f47851a, response, this.f47852b, this.f47853c);
            } else {
                d.a.m0.a.e0.d.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                this.f47853c.handleSchemeDispatchCallback(f.this.f47844h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47856b;

        public c(String str, CallbackHandler callbackHandler) {
            this.f47855a = str;
            this.f47856b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.m0.a.e0.d.b("setCtsConfig", "download cts file fail");
            this.f47856b.handleSchemeDispatchCallback(f.this.f47844h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            f fVar = f.this;
            fVar.v(response, this.f47855a, fVar.f47844h, this.f47856b);
            return response;
        }
    }

    public f(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setCtsConfig");
        this.f47839c = false;
        this.f47840d = false;
        this.f47841e = false;
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.m0.a.e0.d.b("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            d.a.m0.a.e0.d.b("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.f47844h = a2.optString("cb");
            if (!a2.has("loadCts")) {
                d.a.m0.a.e0.d.b("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.T().g(context, "mapp_cts_debug", new a(callbackHandler, a2, context, eVar));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final void s(d.a.m0.a.a2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.f47844h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.f47844h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void t(String str, String str2, d.a.m0.a.a2.e eVar, CallbackHandler callbackHandler) {
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(d.a.m0.a.c1.a.n().m(str), new c(str2, callbackHandler));
        aVar.f51756f = true;
        aVar.f51757g = false;
        aVar.f51758h = true;
        d.a.m0.m.e.a.g().d(aVar);
    }

    public final void u(Context context) {
        if (d.a.m0.a.v2.h.a(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(d.a.m0.a.v2.h.b(context, "aiapps/debug_cts_url.json"));
                this.f47842f = jSONObject.optString("master");
                this.f47843g = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.f47842f)) {
                    this.f47842f = k;
                }
                if (TextUtils.isEmpty(this.f47843g)) {
                    this.f47843g = l;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f47842f = k;
                this.f47843g = l;
                return;
            }
        }
        this.f47842f = k;
        this.f47843g = l;
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                File file2 = new File(file, str + ".js");
                if (d.a.m0.t.g.a(byteStream, file2)) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(file2);
                    char c2 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -1081267614) {
                        if (hashCode == 109519319 && str.equals("slave")) {
                            c2 = 1;
                        }
                    } else if (str.equals("master")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        this.f47845i.put("master", jSONArray);
                        this.f47839c = true;
                        x(this.f47845i, callbackHandler, str2);
                        return;
                    } else if (c2 != 1) {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        d.a.m0.a.e0.d.b("setCtsConfig", "error type, get cts url failed");
                        return;
                    } else {
                        this.f47845i.put("slave", jSONArray);
                        this.f47840d = true;
                        x(this.f47845i, callbackHandler, str2);
                        return;
                    }
                }
                d.a.m0.a.e0.d.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception unused) {
                d.a.m0.a.e0.d.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        d.a.m0.a.e0.d.b("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    public final void w(d.a.m0.a.a2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(str, new b(eVar, str2, callbackHandler));
        aVar.f51756f = true;
        aVar.f51757g = false;
        aVar.f51758h = true;
        d.a.m0.m.e.a.g().d(aVar);
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.f47839c && this.f47840d && this.f47841e) {
            d.a.m0.a.u1.a.a.Q(true);
            d.a.m0.a.k2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f47840d = false;
            this.f47839c = false;
            d.a.m0.a.u1.a.a.X();
        }
    }
}
