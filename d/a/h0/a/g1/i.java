package d.a.h0.a.g1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t1.k.a0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class i extends d.a.h0.a.g1.a {

    /* loaded from: classes3.dex */
    public class a implements StatResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42558a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f42559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42560c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f42561d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f42562e;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i2, b bVar) {
            this.f42558a = str;
            this.f42559b = httpUrl;
            this.f42560c = str2;
            this.f42561d = i2;
            this.f42562e = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            if (d.a.h0.a.w0.a.N().c()) {
                d.a.h0.a.z1.h.x(this.f42560c, this.f42561d, null);
            }
            if (exc instanceof IOException) {
                this.f42562e.onFailure(null, (IOException) exc);
            } else {
                this.f42562e.onFailure(null, new IOException(exc));
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            d.a.h0.a.e0.s.a.e().n(this.f42558a, this.f42559b, networkStatRecord);
            if (d.a.h0.a.w0.a.N().c()) {
                d.a.h0.a.z1.h.x(this.f42560c, this.f42561d, networkStatRecord);
            }
            this.f42562e.onResponse(null, response);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public d.a.h0.a.r1.e f42563a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f42564b;

        /* renamed from: c  reason: collision with root package name */
        public String f42565c;

        /* renamed from: d  reason: collision with root package name */
        public String f42566d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f42567e;

        /* renamed from: f  reason: collision with root package name */
        public String f42568f;

        /* renamed from: g  reason: collision with root package name */
        public long f42569g = System.currentTimeMillis();

        public b(@NonNull d.a.h0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
            this.f42563a = eVar;
            this.f42564b = jSONObject;
            this.f42565c = str;
            this.f42566d = str2;
            this.f42567e = callbackHandler;
            this.f42568f = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a0.f44398b) {
                Log.d("RequestAction", "onFailure: " + iOException.getMessage());
            }
            int F = this.f42563a.L().F();
            String m = d.a.h0.a.z1.h.m();
            String d2 = k0.n().d();
            SwanAppNetworkUtils.a(d.a.h0.k.e.a.f().getOkHttpClient(), this.f42566d);
            this.f42567e.handleSchemeDispatchCallback(this.f42568f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            d.a.h0.a.z1.h.G(0, this.f42565c, F, iOException.getMessage(), m, d2, this.f42569g, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String A = d.a.h0.a.t.c.h.b.A(this.f42564b);
            String C = d.a.h0.a.t.c.h.b.C(this.f42564b);
            int F = this.f42563a.L().F();
            long currentTimeMillis = System.currentTimeMillis();
            String m = d.a.h0.a.z1.h.m();
            String d2 = k0.n().d();
            String optString = this.f42564b.optString("cb");
            try {
                long B = d.a.h0.a.t.c.h.b.B(response);
                if (B <= Config.FULL_TRACE_LOG_LIMIT) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", d.a.h0.a.g1.a.s(response.headers()));
                    d.a.h0.a.t.c.h.b.H(jSONObject, response.body(), A, C);
                    i.this.y(jSONObject);
                    this.f42567e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } else {
                    d.a.h0.a.t.c.h.b.I(this.f42563a, this.f42565c, B, currentTimeMillis);
                    this.f42567e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                }
            } catch (IOException | JSONException e2) {
                if (a0.f44398b) {
                    Log.d("RequestAction", Log.getStackTraceString(e2));
                }
                this.f42567e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
            int code = response.code();
            String message = response.message();
            if (a0.f44398b) {
                Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f42565c + ", msg=" + message);
            }
            d.a.h0.a.z1.h.G(code, this.f42565c, F, message, m, d2, this.f42569g, System.currentTimeMillis());
        }
    }

    public i(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/request");
    }

    public boolean A(@NonNull d.a.h0.a.r1.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            return false;
        }
        Pair<HttpRequest, Integer> t = d.a.h0.a.t.c.h.b.t(a2, str);
        HttpRequest httpRequest = (HttpRequest) t.first;
        if (httpRequest == null) {
            unitedSchemeEntity.result = t(((Integer) t.second).intValue());
            return false;
        }
        z(eVar, a2, httpRequest, str, callbackHandler);
        return true;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
        }
        if (k(eVar, unitedSchemeEntity)) {
            String a2 = d.a.h0.a.t.c.h.c.a(eVar.f43823f);
            if (A(eVar, unitedSchemeEntity, callbackHandler, a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean x(@NonNull d.a.h0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
            return false;
        }
        String optString = optJSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
        if (TextUtils.isEmpty(optString)) {
            callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(1001, "serviceId is invalid").toString());
            return true;
        }
        d.a.h0.a.z1.h.x(str, eVar.L().F(), null);
        new d.a.h0.g.d.i.c(eVar, jSONObject, str2, new b(eVar, jSONObject, str, str2, callbackHandler, str3)).n(optString);
        return true;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
    }

    public final void z(@NonNull d.a.h0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        HttpUrl url = httpRequest.getOkRequest().url();
        String httpUrl = url.toString();
        String optString = jSONObject.optString("cb");
        if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
            return;
        }
        int F = eVar.L().F();
        if (!d.a.h0.a.w0.a.N().c()) {
            d.a.h0.a.z1.h.x(httpUrl, F, null);
        }
        httpRequest.executeStat(new a(this, str, url, httpUrl, F, new b(eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
    }

    public i(d.a.h0.a.t1.j jVar, String str) {
        super(jVar, str);
    }
}
