package d.a.m0.a.n1;

import android.content.Context;
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
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.v2.q0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class i extends d.a.m0.a.n1.a {

    /* loaded from: classes3.dex */
    public class a implements StatResponseCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f47485f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47486g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f47487h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f47488i;
        public final /* synthetic */ c j;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i2, long j, c cVar) {
            this.f47484e = str;
            this.f47485f = httpUrl;
            this.f47486g = str2;
            this.f47487h = i2;
            this.f47488i = j;
            this.j = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            d.a.m0.a.j2.k.z(this.f47486g, this.f47487h, null, this.f47488i, System.currentTimeMillis());
            if (exc instanceof IOException) {
                this.j.onFailure(null, (IOException) exc);
            } else {
                this.j.onFailure(null, new IOException(exc));
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            d.a.m0.a.h0.q.b.g().u(this.f47484e, this.f47485f, networkStatRecord);
            d.a.m0.a.j2.k.z(this.f47486g, this.f47487h, networkStatRecord, this.f47488i, System.currentTimeMillis());
            this.j.onResponse(null, response);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47490f;

        public b(i iVar, CallbackHandler callbackHandler, String str) {
            this.f47489e = callbackHandler;
            this.f47490f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f47489e.handleSchemeDispatchCallback(this.f47490f, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.a2.e f47491a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f47492b;

        /* renamed from: c  reason: collision with root package name */
        public String f47493c;

        /* renamed from: d  reason: collision with root package name */
        public String f47494d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f47495e;

        /* renamed from: f  reason: collision with root package name */
        public String f47496f;

        /* renamed from: g  reason: collision with root package name */
        public long f47497g = System.currentTimeMillis();

        public c(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
            this.f47491a = eVar;
            this.f47492b = jSONObject;
            this.f47493c = str;
            this.f47494d = str2;
            this.f47495e = callbackHandler;
            this.f47496f = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a0.f44733b) {
                Log.d("RequestAction", "onFailure: " + iOException.getMessage());
            }
            int G = this.f47491a.N().G();
            String l = d.a.m0.a.j2.k.l();
            String f2 = q0.n().f();
            SwanAppNetworkUtils.a(d.a.m0.m.e.a.g().getOkHttpClient(), this.f47494d);
            this.f47495e.handleSchemeDispatchCallback(this.f47496f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            d.a.m0.a.j2.k.K(0, this.f47493c, G, iOException.getMessage(), l, f2, this.f47497g, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (!d.a.m0.a.j2.k.n(this.f47493c)) {
                d.a.m0.a.l2.b.l().x(this.f47493c, response.headers("Set-cookie"));
            }
            String B = d.a.m0.a.u.e.j.g.B(this.f47492b);
            String D = d.a.m0.a.u.e.j.g.D(this.f47492b);
            int G = this.f47491a.N().G();
            long currentTimeMillis = System.currentTimeMillis();
            String l = d.a.m0.a.j2.k.l();
            String f2 = q0.n().f();
            String optString = this.f47492b.optString("cb");
            try {
                long C = d.a.m0.a.u.e.j.g.C(response);
                if (C <= Config.FULL_TRACE_LOG_LIMIT) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", d.a.m0.a.n1.a.s(response.headers()));
                    d.a.m0.a.u.e.j.g.J(jSONObject, response.body(), B, D);
                    i.this.y(jSONObject);
                    this.f47495e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } else {
                    d.a.m0.a.u.e.j.g.K(this.f47491a, this.f47493c, C, currentTimeMillis);
                    this.f47495e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                }
            } catch (IOException | JSONException e2) {
                if (a0.f44733b) {
                    Log.d("RequestAction", Log.getStackTraceString(e2));
                }
                this.f47495e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
            int code = response.code();
            String message = response.message();
            if (a0.f44733b) {
                Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f47493c + ", msg=" + message);
            }
            d.a.m0.a.j2.k.K(code, this.f47493c, G, message, l, f2, this.f47497g, System.currentTimeMillis());
        }
    }

    public i(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/request");
    }

    public boolean A(@NonNull d.a.m0.a.a2.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            return false;
        }
        Pair<HttpRequest, Integer> u = d.a.m0.a.u.e.j.g.u(a2, str);
        HttpRequest httpRequest = (HttpRequest) u.first;
        if (httpRequest == null) {
            unitedSchemeEntity.result = t(((Integer) u.second).intValue());
            return false;
        }
        z(eVar, a2, httpRequest, str, callbackHandler);
        return true;
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
        }
        if (k(eVar, unitedSchemeEntity)) {
            String a2 = d.a.m0.a.u.e.j.h.a(eVar.f44533f);
            if (A(eVar, unitedSchemeEntity, callbackHandler, a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean x(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        return d.a.m0.a.c1.a.d().i(eVar, jSONObject, str, str2, new c(eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3));
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
    }

    public final void z(@NonNull d.a.m0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        HttpUrl url = httpRequest.getOkRequest().url();
        String httpUrl = url.toString();
        String optString = jSONObject.optString("cb");
        if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
            return;
        }
        httpRequest.executeStat(new a(this, str, url, httpUrl, eVar.N().G(), System.currentTimeMillis(), new c(eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
    }

    public i(d.a.m0.a.c2.e eVar, String str) {
        super(eVar, str);
    }
}
