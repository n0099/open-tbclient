package d.a.i0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a0 {
    public static final String j = String.format("?swanjs_version=%s", d.a.i0.a.m2.b.h(0));
    public static final String k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
    public static final String l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";

    /* renamed from: c  reason: collision with root package name */
    public boolean f43881c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43882d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43883e;

    /* renamed from: f  reason: collision with root package name */
    public String f43884f;

    /* renamed from: g  reason: collision with root package name */
    public String f43885g;

    /* renamed from: h  reason: collision with root package name */
    public String f43886h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f43887i;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43888e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43889f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43890g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f43891h;

        public a(CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.a.i0.a.a2.e eVar) {
            this.f43888e = callbackHandler;
            this.f43889f = jSONObject;
            this.f43890g = context;
            this.f43891h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.p(iVar, this.f43888e, f.this.f43886h);
                return;
            }
            f.this.f43887i = new JSONObject();
            if (this.f43889f.optInt("loadCts") == 1) {
                f.this.u(this.f43890g);
                f fVar = f.this;
                fVar.w(this.f43891h, fVar.f43884f, this.f43888e, "master");
                f fVar2 = f.this;
                fVar2.w(this.f43891h, fVar2.f43885g, this.f43888e, "slave");
                f.this.f43883e = true;
                return;
            }
            f.this.f43883e = false;
            d.a.i0.a.u1.a.a.Q(false);
            d.a.i0.a.u1.a.a.X();
            this.f43888e.handleSchemeDispatchCallback(f.this.f43886h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f43893a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43894b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43895c;

        public b(d.a.i0.a.a2.e eVar, String str, CallbackHandler callbackHandler) {
            this.f43893a = eVar;
            this.f43894b = str;
            this.f43895c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.i0.a.e0.d.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
            this.f43895c.handleSchemeDispatchCallback(f.this.f43886h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            if (response.code() == 200 && response.body() != null) {
                f.this.s(this.f43893a, response, this.f43894b, this.f43895c);
            } else {
                d.a.i0.a.e0.d.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                this.f43895c.handleSchemeDispatchCallback(f.this.f43886h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43898b;

        public c(String str, CallbackHandler callbackHandler) {
            this.f43897a = str;
            this.f43898b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.i0.a.e0.d.b("setCtsConfig", "download cts file fail");
            this.f43898b.handleSchemeDispatchCallback(f.this.f43886h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            f fVar = f.this;
            fVar.v(response, this.f43897a, fVar.f43886h, this.f43898b);
            return response;
        }
    }

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setCtsConfig");
        this.f43881c = false;
        this.f43882d = false;
        this.f43883e = false;
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            d.a.i0.a.e0.d.b("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.f43886h = a2.optString("cb");
            if (!a2.has("loadCts")) {
                d.a.i0.a.e0.d.b("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.T().g(context, "mapp_cts_debug", new a(callbackHandler, a2, context, eVar));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final void s(d.a.i0.a.a2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.f43886h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.f43886h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void t(String str, String str2, d.a.i0.a.a2.e eVar, CallbackHandler callbackHandler) {
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(d.a.i0.a.c1.a.n().m(str), new c(str2, callbackHandler));
        aVar.f47798f = true;
        aVar.f47799g = false;
        aVar.f47800h = true;
        d.a.i0.m.e.a.g().d(aVar);
    }

    public final void u(Context context) {
        if (d.a.i0.a.v2.h.a(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(d.a.i0.a.v2.h.b(context, "aiapps/debug_cts_url.json"));
                this.f43884f = jSONObject.optString("master");
                this.f43885g = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.f43884f)) {
                    this.f43884f = k;
                }
                if (TextUtils.isEmpty(this.f43885g)) {
                    this.f43885g = l;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f43884f = k;
                this.f43885g = l;
                return;
            }
        }
        this.f43884f = k;
        this.f43885g = l;
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                File file2 = new File(file, str + ".js");
                if (d.a.i0.t.g.a(byteStream, file2)) {
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
                        this.f43887i.put("master", jSONArray);
                        this.f43881c = true;
                        x(this.f43887i, callbackHandler, str2);
                        return;
                    } else if (c2 != 1) {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        d.a.i0.a.e0.d.b("setCtsConfig", "error type, get cts url failed");
                        return;
                    } else {
                        this.f43887i.put("slave", jSONArray);
                        this.f43882d = true;
                        x(this.f43887i, callbackHandler, str2);
                        return;
                    }
                }
                d.a.i0.a.e0.d.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception unused) {
                d.a.i0.a.e0.d.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        d.a.i0.a.e0.d.b("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    public final void w(d.a.i0.a.a2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(str, new b(eVar, str2, callbackHandler));
        aVar.f47798f = true;
        aVar.f47799g = false;
        aVar.f47800h = true;
        d.a.i0.m.e.a.g().d(aVar);
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.f43881c && this.f43882d && this.f43883e) {
            d.a.i0.a.u1.a.a.Q(true);
            d.a.i0.a.k2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f43882d = false;
            this.f43881c = false;
            d.a.i0.a.u1.a.a.X();
        }
    }
}
