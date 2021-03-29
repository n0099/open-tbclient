package d.b.g0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a0 {
    public static final String j = String.format("?swanjs_version=%s", d.b.g0.a.b2.b.f(0));
    public static final String k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
    public static final String l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";

    /* renamed from: c  reason: collision with root package name */
    public boolean f45126c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45127d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45128e;

    /* renamed from: f  reason: collision with root package name */
    public String f45129f;

    /* renamed from: g  reason: collision with root package name */
    public String f45130g;

    /* renamed from: h  reason: collision with root package name */
    public String f45131h;
    public JSONObject i;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45133f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45134g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45135h;

        public a(CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.b.g0.a.r1.e eVar) {
            this.f45132e = callbackHandler;
            this.f45133f = jSONObject;
            this.f45134g = context;
            this.f45135h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f45132e, f.this.f45131h);
                return;
            }
            f.this.i = new JSONObject();
            if (this.f45133f.optInt("loadCts") == 1) {
                f.this.u(this.f45134g);
                f fVar = f.this;
                fVar.w(this.f45135h, fVar.f45129f, this.f45132e, "master");
                f fVar2 = f.this;
                fVar2.w(this.f45135h, fVar2.f45130g, this.f45132e, "slave");
                f.this.f45128e = true;
                return;
            }
            f.this.f45128e = false;
            d.b.g0.a.m1.a.a.M(false);
            d.b.g0.a.m1.a.a.T();
            this.f45132e.handleSchemeDispatchCallback(f.this.f45131h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45138c;

        public b(d.b.g0.a.r1.e eVar, String str, CallbackHandler callbackHandler) {
            this.f45136a = eVar;
            this.f45137b = str;
            this.f45138c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.g0.a.c0.c.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
            this.f45138c.handleSchemeDispatchCallback(f.this.f45131h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            if (response.code() == 200 && response.body() != null) {
                f.this.s(this.f45136a, response, this.f45137b, this.f45138c);
            } else {
                d.b.g0.a.c0.c.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                this.f45138c.handleSchemeDispatchCallback(f.this.f45131h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45141b;

        public c(String str, CallbackHandler callbackHandler) {
            this.f45140a = str;
            this.f45141b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.g0.a.c0.c.b("setCtsConfig", "download cts file fail");
            this.f45141b.handleSchemeDispatchCallback(f.this.f45131h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            f fVar = f.this;
            fVar.v(response, this.f45140a, fVar.f45131h, this.f45141b);
            return response;
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/debug/setCtsConfig");
        this.f45126c = false;
        this.f45127d = false;
        this.f45128e = false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("setCtsConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (eVar == null) {
            d.b.g0.a.c0.c.b("setCtsConfig", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            this.f45131h = a2.optString("cb");
            if (!a2.has("loadCts")) {
                d.b.g0.a.c0.c.b("setCtsConfig", "loadCts is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.R().g(context, "mapp_cts_debug", new a(callbackHandler, a2, context, eVar));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final void s(d.b.g0.a.r1.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
            } else {
                callbackHandler.handleSchemeDispatchCallback(this.f45131h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackHandler.handleSchemeDispatchCallback(this.f45131h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void t(String str, String str2, d.b.g0.a.r1.e eVar, CallbackHandler callbackHandler) {
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(d.b.g0.a.w0.a.l().z(str), new c(str2, callbackHandler));
        aVar.f48884f = true;
        aVar.f48885g = false;
        aVar.f48886h = true;
        d.b.g0.k.e.a.f().d(aVar);
    }

    public final void u(Context context) {
        if (d.b.g0.a.i2.g.a(context, "aiapps/debug_cts_url.json")) {
            try {
                JSONObject jSONObject = new JSONObject(d.b.g0.a.i2.g.b(context, "aiapps/debug_cts_url.json"));
                this.f45129f = jSONObject.optString("master");
                this.f45130g = jSONObject.optString("slave");
                if (TextUtils.isEmpty(this.f45129f)) {
                    this.f45129f = k;
                }
                if (TextUtils.isEmpty(this.f45130g)) {
                    this.f45130g = l;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f45129f = k;
                this.f45130g = l;
                return;
            }
        }
        this.f45129f = k;
        this.f45130g = l;
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        if (response.code() == 200 && response.body() != null) {
            try {
                InputStream byteStream = response.body().byteStream();
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                File file2 = new File(file, str + ".js");
                if (d.b.g0.p.f.a(byteStream, file2)) {
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
                        this.f45126c = true;
                        x(this.i, callbackHandler, str2);
                        return;
                    } else if (c2 != 1) {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        d.b.g0.a.c0.c.b("setCtsConfig", "error type, get cts url failed");
                        return;
                    } else {
                        this.i.put("slave", jSONArray);
                        this.f45127d = true;
                        x(this.i, callbackHandler, str2);
                        return;
                    }
                }
                d.b.g0.a.c0.c.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            } catch (Exception unused) {
                d.b.g0.a.c0.c.b("setCtsConfig", "save cts file fail");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
        }
        d.b.g0.a.c0.c.b("setCtsConfig", "download cts file fail,code is " + response.code());
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
    }

    public final void w(d.b.g0.a.r1.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(str, new b(eVar, str2, callbackHandler));
        aVar.f48884f = true;
        aVar.f48885g = false;
        aVar.f48886h = true;
        d.b.g0.k.e.a.f().d(aVar);
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        if (this.f45126c && this.f45127d && this.f45128e) {
            d.b.g0.a.m1.a.a.M(true);
            d.b.g0.a.a2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f45127d = false;
            this.f45126c = false;
            d.b.g0.a.m1.a.a.T();
        }
    }
}
