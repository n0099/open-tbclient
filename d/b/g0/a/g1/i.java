package d.b.g0.a.g1;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.t1.k.a0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class i extends d.b.g0.a.g1.a {

    /* loaded from: classes2.dex */
    public class a implements StatResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44916a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f44917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44918c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f44919d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f44920e;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i, b bVar) {
            this.f44916a = str;
            this.f44917b = httpUrl;
            this.f44918c = str2;
            this.f44919d = i;
            this.f44920e = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            if (d.b.g0.a.w0.a.N().d()) {
                d.b.g0.a.z1.h.x(this.f44918c, this.f44919d, null);
            }
            if (exc instanceof IOException) {
                this.f44920e.onFailure(null, (IOException) exc);
            } else {
                this.f44920e.onFailure(null, new IOException(exc));
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            d.b.g0.a.e0.s.a.e().n(this.f44916a, this.f44917b, networkStatRecord);
            if (d.b.g0.a.w0.a.N().d()) {
                d.b.g0.a.z1.h.x(this.f44918c, this.f44919d, networkStatRecord);
            }
            this.f44920e.onResponse(null, response);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.a.r1.e f44921a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f44922b;

        /* renamed from: c  reason: collision with root package name */
        public String f44923c;

        /* renamed from: d  reason: collision with root package name */
        public String f44924d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f44925e;

        /* renamed from: f  reason: collision with root package name */
        public String f44926f;

        /* renamed from: g  reason: collision with root package name */
        public long f44927g = System.currentTimeMillis();

        public b(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
            this.f44921a = eVar;
            this.f44922b = jSONObject;
            this.f44923c = str;
            this.f44924d = str2;
            this.f44925e = callbackHandler;
            this.f44926f = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a0.f46680b) {
                Log.d("RequestAction", "onFailure: " + iOException.getMessage());
            }
            int F = this.f44921a.L().F();
            String m = d.b.g0.a.z1.h.m();
            String d2 = k0.n().d();
            SwanAppNetworkUtils.a(d.b.g0.k.e.a.f().getOkHttpClient(), this.f44924d);
            this.f44925e.handleSchemeDispatchCallback(this.f44926f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            d.b.g0.a.z1.h.G(0, this.f44923c, F, iOException.getMessage(), m, d2, this.f44927g, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String A = d.b.g0.a.t.c.h.b.A(this.f44922b);
            String C = d.b.g0.a.t.c.h.b.C(this.f44922b);
            int F = this.f44921a.L().F();
            long currentTimeMillis = System.currentTimeMillis();
            String m = d.b.g0.a.z1.h.m();
            String d2 = k0.n().d();
            String optString = this.f44922b.optString("cb");
            try {
                long B = d.b.g0.a.t.c.h.b.B(response);
                if (B <= Config.FULL_TRACE_LOG_LIMIT) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", d.b.g0.a.g1.a.s(response.headers()));
                    d.b.g0.a.t.c.h.b.H(jSONObject, response.body(), A, C);
                    i.this.y(jSONObject);
                    this.f44925e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } else {
                    d.b.g0.a.t.c.h.b.I(this.f44921a, this.f44923c, B, currentTimeMillis);
                    this.f44925e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                }
            } catch (IOException | JSONException e2) {
                if (a0.f46680b) {
                    Log.d("RequestAction", Log.getStackTraceString(e2));
                }
                this.f44925e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
            int code = response.code();
            String message = response.message();
            if (a0.f46680b) {
                Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f44923c + ", msg=" + message);
            }
            d.b.g0.a.z1.h.G(code, this.f44923c, F, message, m, d2, this.f44927g, System.currentTimeMillis());
        }
    }

    public i(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/request");
    }

    public boolean A(@NonNull d.b.g0.a.r1.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            return false;
        }
        Pair<HttpRequest, Integer> t = d.b.g0.a.t.c.h.b.t(a2, str);
        HttpRequest httpRequest = (HttpRequest) t.first;
        if (httpRequest == null) {
            unitedSchemeEntity.result = t(((Integer) t.second).intValue());
            return false;
        }
        z(eVar, a2, httpRequest, str, callbackHandler);
        return true;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46680b) {
            Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
        }
        if (k(eVar, unitedSchemeEntity)) {
            String a2 = d.b.g0.a.t.c.h.c.a(eVar.f46132f);
            if (A(eVar, unitedSchemeEntity, callbackHandler, a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean x(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
            return false;
        }
        String optString = optJSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
        if (TextUtils.isEmpty(optString)) {
            callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(1001, "serviceId is invalid").toString());
            return true;
        }
        d.b.g0.a.z1.h.x(str, eVar.L().F(), null);
        new d.b.g0.g.d.i.c(eVar, jSONObject, str2, new b(eVar, jSONObject, str, str2, callbackHandler, str3)).n(optString);
        return true;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
    }

    public final void z(@NonNull d.b.g0.a.r1.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        HttpUrl url = httpRequest.getOkRequest().url();
        String httpUrl = url.toString();
        String optString = jSONObject.optString("cb");
        if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
            return;
        }
        int F = eVar.L().F();
        if (!d.b.g0.a.w0.a.N().d()) {
            d.b.g0.a.z1.h.x(httpUrl, F, null);
        }
        httpRequest.executeStat(new a(this, str, url, httpUrl, F, new b(eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
    }

    public i(d.b.g0.a.t1.j jVar, String str) {
        super(jVar, str);
    }
}
