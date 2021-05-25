package d.a.l0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a0 {
    public static final String j = String.format("?swanjs_version=%s", d.a.l0.a.m2.b.h(0));
    public static final String k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
    public static final String l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";

    /* renamed from: c  reason: collision with root package name */
    public boolean f44057c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44058d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44059e;

    /* renamed from: f  reason: collision with root package name */
    public String f44060f;

    /* renamed from: g  reason: collision with root package name */
    public String f44061g;

    /* renamed from: h  reason: collision with root package name */
    public String f44062h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f44063i;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44065f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44066g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f44067h;

        public a(CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.a.l0.a.a2.e eVar) {
            this.f44064e = callbackHandler;
            this.f44065f = jSONObject;
            this.f44066g = context;
            this.f44067h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.p(iVar, this.f44064e, f.this.f44062h);
                return;
            }
            f.this.f44063i = new JSONObject();
            if (this.f44065f.optInt("loadCts") == 1) {
                f.this.u(this.f44066g);
                f fVar = f.this;
                fVar.w(this.f44067h, fVar.f44060f, this.f44064e, "master");
                f fVar2 = f.this;
                fVar2.w(this.f44067h, fVar2.f44061g, this.f44064e, "slave");
                f.this.f44059e = true;
                return;
            }
            f.this.f44059e = false;
            d.a.l0.a.u1.a.a.Q(false);
            d.a.l0.a.u1.a.a.X();
            this.f44064e.handleSchemeDispatchCallback(f.this.f44062h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f44069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44071c;

        public b(d.a.l0.a.a2.e eVar, String str, CallbackHandler callbackHandler) {
            this.f44069a = eVar;
            this.f44070b = str;
            this.f44071c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.e0.d.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
            this.f44071c.handleSchemeDispatchCallback(f.this.f44062h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            if (response.code() == 200 && response.body() != null) {
                f.this.s(this.f44069a, response, this.f44070b, this.f44071c);
            } else {
                d.a.l0.a.e0.d.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                this.f44071c.handleSchemeDispatchCallback(f.this.f44062h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44073a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44074b;

        public c(String str, CallbackHandler callbackHandler) {
            this.f44073a = str;
            this.f44074b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.e0.d.b("setCtsConfig", "download cts file fail");
            this.f44074b.handleSchemeDispatchCallback(f.this.f44062h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            f fVar = f.this;
            fVar.v(response, this.f44073a, fVar.f44062h, this.f44074b);
            return response;
        }
    }

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setCtsConfig");
        this.f44057c = false;
        this.f44058d = false;
        this.f44059e = false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.e0.d.b("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            d.a.l0.a.e0.d.b("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.f44062h = a2.optString("cb");
            if (!a2.has("loadCts")) {
                d.a.l0.a.e0.d.b("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.T().g(context, "mapp_cts_debug", new a(callbackHandler, a2, context, eVar));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final void s(d.a.l0.a.a2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.f44062h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.f44062h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void t(String str, String str2, d.a.l0.a.a2.e eVar, CallbackHandler callbackHandler) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(d.a.l0.a.c1.a.n().m(str), new c(str2, callbackHandler));
        aVar.f47974f = true;
        aVar.f47975g = false;
        aVar.f47976h = true;
        d.a.l0.m.e.a.g().d(aVar);
    }

    public final void u(Context context) {
        if (d.a.l0.a.v2.h.a(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(d.a.l0.a.v2.h.b(context, "aiapps/debug_cts_url.json"));
                this.f44060f = jSONObject.optString("master");
                this.f44061g = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.f44060f)) {
                    this.f44060f = k;
                }
                if (TextUtils.isEmpty(this.f44061g)) {
                    this.f44061g = l;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f44060f = k;
                this.f44061g = l;
                return;
            }
        }
        this.f44060f = k;
        this.f44061g = l;
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                File file2 = new File(file, str + ".js");
                if (d.a.l0.t.g.a(byteStream, file2)) {
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
                        this.f44063i.put("master", jSONArray);
                        this.f44057c = true;
                        x(this.f44063i, callbackHandler, str2);
                        return;
                    } else if (c2 != 1) {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        d.a.l0.a.e0.d.b("setCtsConfig", "error type, get cts url failed");
                        return;
                    } else {
                        this.f44063i.put("slave", jSONArray);
                        this.f44058d = true;
                        x(this.f44063i, callbackHandler, str2);
                        return;
                    }
                }
                d.a.l0.a.e0.d.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception unused) {
                d.a.l0.a.e0.d.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        d.a.l0.a.e0.d.b("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    public final void w(d.a.l0.a.a2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(str, new b(eVar, str2, callbackHandler));
        aVar.f47974f = true;
        aVar.f47975g = false;
        aVar.f47976h = true;
        d.a.l0.m.e.a.g().d(aVar);
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.f44057c && this.f44058d && this.f44059e) {
            d.a.l0.a.u1.a.a.Q(true);
            d.a.l0.a.k2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f44058d = false;
            this.f44057c = false;
            d.a.l0.a.u1.a.a.X();
        }
    }
}
