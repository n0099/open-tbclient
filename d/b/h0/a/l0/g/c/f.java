package d.b.h0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a0 {
    public static final String j = String.format("?swanjs_version=%s", d.b.h0.a.b2.b.f(0));
    public static final String k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
    public static final String l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";

    /* renamed from: c  reason: collision with root package name */
    public boolean f45847c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45848d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45849e;

    /* renamed from: f  reason: collision with root package name */
    public String f45850f;

    /* renamed from: g  reason: collision with root package name */
    public String f45851g;

    /* renamed from: h  reason: collision with root package name */
    public String f45852h;
    public JSONObject i;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45854f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45855g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f45856h;

        public a(CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.b.h0.a.r1.e eVar) {
            this.f45853e = callbackHandler;
            this.f45854f = jSONObject;
            this.f45855g = context;
            this.f45856h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                d.b.h0.a.v1.c.c.o(hVar, this.f45853e, f.this.f45852h);
                return;
            }
            f.this.i = new JSONObject();
            if (this.f45854f.optInt("loadCts") == 1) {
                f.this.u(this.f45855g);
                f fVar = f.this;
                fVar.w(this.f45856h, fVar.f45850f, this.f45853e, "master");
                f fVar2 = f.this;
                fVar2.w(this.f45856h, fVar2.f45851g, this.f45853e, "slave");
                f.this.f45849e = true;
                return;
            }
            f.this.f45849e = false;
            d.b.h0.a.m1.a.a.M(false);
            d.b.h0.a.m1.a.a.T();
            this.f45853e.handleSchemeDispatchCallback(f.this.f45852h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f45857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45859c;

        public b(d.b.h0.a.r1.e eVar, String str, CallbackHandler callbackHandler) {
            this.f45857a = eVar;
            this.f45858b = str;
            this.f45859c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.h0.a.c0.c.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
            this.f45859c.handleSchemeDispatchCallback(f.this.f45852h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            if (response.code() == 200 && response.body() != null) {
                f.this.s(this.f45857a, response, this.f45858b, this.f45859c);
            } else {
                d.b.h0.a.c0.c.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                this.f45859c.handleSchemeDispatchCallback(f.this.f45852h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45861a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45862b;

        public c(String str, CallbackHandler callbackHandler) {
            this.f45861a = str;
            this.f45862b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.h0.a.c0.c.b("setCtsConfig", "download cts file fail");
            this.f45862b.handleSchemeDispatchCallback(f.this.f45852h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            f fVar = f.this;
            fVar.v(response, this.f45861a, fVar.f45852h, this.f45862b);
            return response;
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.f45847c = false;
        this.f45848d = false;
        this.f45849e = false;
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.h0.a.c0.c.b("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            d.b.h0.a.c0.c.b("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.f45852h = a2.optString("cb");
            if (!a2.has("loadCts")) {
                d.b.h0.a.c0.c.b("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.R().g(context, "mapp_cts_debug", new a(callbackHandler, a2, context, eVar));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final void s(d.b.h0.a.r1.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.f45852h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.f45852h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void t(String str, String str2, d.b.h0.a.r1.e eVar, CallbackHandler callbackHandler) {
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a(d.b.h0.a.w0.a.l().z(str), new c(str2, callbackHandler));
        aVar.f49605f = true;
        aVar.f49606g = false;
        aVar.f49607h = true;
        d.b.h0.k.e.a.f().d(aVar);
    }

    public final void u(Context context) {
        if (d.b.h0.a.i2.g.a(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(d.b.h0.a.i2.g.b(context, "aiapps/debug_cts_url.json"));
                this.f45850f = jSONObject.optString("master");
                this.f45851g = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.f45850f)) {
                    this.f45850f = k;
                }
                if (TextUtils.isEmpty(this.f45851g)) {
                    this.f45851g = l;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f45850f = k;
                this.f45851g = l;
                return;
            }
        }
        this.f45850f = k;
        this.f45851g = l;
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                File file2 = new File(file, str + ".js");
                if (d.b.h0.p.f.a(byteStream, file2)) {
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
                        this.i.put("master", jSONArray);
                        this.f45847c = true;
                        x(this.i, callbackHandler, str2);
                        return;
                    } else if (c2 != 1) {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        d.b.h0.a.c0.c.b("setCtsConfig", "error type, get cts url failed");
                        return;
                    } else {
                        this.i.put("slave", jSONArray);
                        this.f45848d = true;
                        x(this.i, callbackHandler, str2);
                        return;
                    }
                }
                d.b.h0.a.c0.c.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception unused) {
                d.b.h0.a.c0.c.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        d.b.h0.a.c0.c.b("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    public final void w(d.b.h0.a.r1.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a(str, new b(eVar, str2, callbackHandler));
        aVar.f49605f = true;
        aVar.f49606g = false;
        aVar.f49607h = true;
        d.b.h0.k.e.a.f().d(aVar);
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.f45847c && this.f45848d && this.f45849e) {
            d.b.h0.a.m1.a.a.M(true);
            d.b.h0.a.a2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f45848d = false;
            this.f45847c = false;
            d.b.h0.a.m1.a.a.T();
        }
    }
}
