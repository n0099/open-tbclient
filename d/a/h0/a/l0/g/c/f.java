package d.a.h0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a0 {
    public static final String j = String.format("?swanjs_version=%s", d.a.h0.a.b2.b.f(0));
    public static final String k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
    public static final String l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";

    /* renamed from: c  reason: collision with root package name */
    public boolean f43179c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43180d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43181e;

    /* renamed from: f  reason: collision with root package name */
    public String f43182f;

    /* renamed from: g  reason: collision with root package name */
    public String f43183g;

    /* renamed from: h  reason: collision with root package name */
    public String f43184h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f43185i;

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43187f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43188g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f43189h;

        public a(CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.a.h0.a.r1.e eVar) {
            this.f43186e = callbackHandler;
            this.f43187f = jSONObject;
            this.f43188g = context;
            this.f43189h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.o(hVar, this.f43186e, f.this.f43184h);
                return;
            }
            f.this.f43185i = new JSONObject();
            if (this.f43187f.optInt("loadCts") == 1) {
                f.this.u(this.f43188g);
                f fVar = f.this;
                fVar.w(this.f43189h, fVar.f43182f, this.f43186e, "master");
                f fVar2 = f.this;
                fVar2.w(this.f43189h, fVar2.f43183g, this.f43186e, "slave");
                f.this.f43181e = true;
                return;
            }
            f.this.f43181e = false;
            d.a.h0.a.m1.a.a.M(false);
            d.a.h0.a.m1.a.a.T();
            this.f43186e.handleSchemeDispatchCallback(f.this.f43184h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f43191a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43192b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43193c;

        public b(d.a.h0.a.r1.e eVar, String str, CallbackHandler callbackHandler) {
            this.f43191a = eVar;
            this.f43192b = str;
            this.f43193c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.h0.a.c0.c.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
            this.f43193c.handleSchemeDispatchCallback(f.this.f43184h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            if (response.code() == 200 && response.body() != null) {
                f.this.s(this.f43191a, response, this.f43192b, this.f43193c);
            } else {
                d.a.h0.a.c0.c.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                this.f43193c.handleSchemeDispatchCallback(f.this.f43184h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43195a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43196b;

        public c(String str, CallbackHandler callbackHandler) {
            this.f43195a = str;
            this.f43196b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.h0.a.c0.c.b("setCtsConfig", "download cts file fail");
            this.f43196b.handleSchemeDispatchCallback(f.this.f43184h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            f fVar = f.this;
            fVar.v(response, this.f43195a, fVar.f43184h, this.f43196b);
            return response;
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.f43179c = false;
        this.f43180d = false;
        this.f43181e = false;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            d.a.h0.a.c0.c.b("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.f43184h = a2.optString("cb");
            if (!a2.has("loadCts")) {
                d.a.h0.a.c0.c.b("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.R().g(context, "mapp_cts_debug", new a(callbackHandler, a2, context, eVar));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final void s(d.a.h0.a.r1.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.f43184h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.f43184h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void t(String str, String str2, d.a.h0.a.r1.e eVar, CallbackHandler callbackHandler) {
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(d.a.h0.a.w0.a.l().l(str), new c(str2, callbackHandler));
        aVar.f47111f = true;
        aVar.f47112g = false;
        aVar.f47113h = true;
        d.a.h0.k.e.a.f().d(aVar);
    }

    public final void u(Context context) {
        if (d.a.h0.a.i2.g.a(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(d.a.h0.a.i2.g.b(context, "aiapps/debug_cts_url.json"));
                this.f43182f = jSONObject.optString("master");
                this.f43183g = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.f43182f)) {
                    this.f43182f = k;
                }
                if (TextUtils.isEmpty(this.f43183g)) {
                    this.f43183g = l;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f43182f = k;
                this.f43183g = l;
                return;
            }
        }
        this.f43182f = k;
        this.f43183g = l;
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                File file2 = new File(file, str + ".js");
                if (d.a.h0.p.f.a(byteStream, file2)) {
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
                        this.f43185i.put("master", jSONArray);
                        this.f43179c = true;
                        x(this.f43185i, callbackHandler, str2);
                        return;
                    } else if (c2 != 1) {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        d.a.h0.a.c0.c.b("setCtsConfig", "error type, get cts url failed");
                        return;
                    } else {
                        this.f43185i.put("slave", jSONArray);
                        this.f43180d = true;
                        x(this.f43185i, callbackHandler, str2);
                        return;
                    }
                }
                d.a.h0.a.c0.c.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception unused) {
                d.a.h0.a.c0.c.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        d.a.h0.a.c0.c.b("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    public final void w(d.a.h0.a.r1.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(str, new b(eVar, str2, callbackHandler));
        aVar.f47111f = true;
        aVar.f47112g = false;
        aVar.f47113h = true;
        d.a.h0.k.e.a.f().d(aVar);
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.f43179c && this.f43180d && this.f43181e) {
            d.a.h0.a.m1.a.a.M(true);
            d.a.h0.a.a2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f43180d = false;
            this.f43179c = false;
            d.a.h0.a.m1.a.a.T();
        }
    }
}
