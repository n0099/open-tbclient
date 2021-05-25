package d.a.l0.a.n1;

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
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.v2.q0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class i extends d.a.l0.a.n1.a {

    /* loaded from: classes3.dex */
    public class a implements StatResponseCallback {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f43701f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43702g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43703h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f43704i;
        public final /* synthetic */ c j;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i2, long j, c cVar) {
            this.f43700e = str;
            this.f43701f = httpUrl;
            this.f43702g = str2;
            this.f43703h = i2;
            this.f43704i = j;
            this.j = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.j2.k.z(this.f43702g, this.f43703h, null, this.f43704i, System.currentTimeMillis());
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
            d.a.l0.a.h0.q.b.g().u(this.f43700e, this.f43701f, networkStatRecord);
            d.a.l0.a.j2.k.z(this.f43702g, this.f43703h, networkStatRecord, this.f43704i, System.currentTimeMillis());
            this.j.onResponse(null, response);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43706f;

        public b(i iVar, CallbackHandler callbackHandler, String str) {
            this.f43705e = callbackHandler;
            this.f43706f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f43705e.handleSchemeDispatchCallback(this.f43706f, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.a2.e f43707a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f43708b;

        /* renamed from: c  reason: collision with root package name */
        public String f43709c;

        /* renamed from: d  reason: collision with root package name */
        public String f43710d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f43711e;

        /* renamed from: f  reason: collision with root package name */
        public String f43712f;

        /* renamed from: g  reason: collision with root package name */
        public long f43713g = System.currentTimeMillis();

        public c(@NonNull d.a.l0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
            this.f43707a = eVar;
            this.f43708b = jSONObject;
            this.f43709c = str;
            this.f43710d = str2;
            this.f43711e = callbackHandler;
            this.f43712f = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (a0.f40949b) {
                Log.d("RequestAction", "onFailure: " + iOException.getMessage());
            }
            int G = this.f43707a.N().G();
            String l = d.a.l0.a.j2.k.l();
            String f2 = q0.n().f();
            SwanAppNetworkUtils.a(d.a.l0.m.e.a.g().getOkHttpClient(), this.f43710d);
            this.f43711e.handleSchemeDispatchCallback(this.f43712f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            d.a.l0.a.j2.k.K(0, this.f43709c, G, iOException.getMessage(), l, f2, this.f43713g, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (!d.a.l0.a.j2.k.n(this.f43709c)) {
                d.a.l0.a.l2.b.l().x(this.f43709c, response.headers("Set-cookie"));
            }
            String B = d.a.l0.a.u.e.j.g.B(this.f43708b);
            String D = d.a.l0.a.u.e.j.g.D(this.f43708b);
            int G = this.f43707a.N().G();
            long currentTimeMillis = System.currentTimeMillis();
            String l = d.a.l0.a.j2.k.l();
            String f2 = q0.n().f();
            String optString = this.f43708b.optString("cb");
            try {
                long C = d.a.l0.a.u.e.j.g.C(response);
                if (C <= Config.FULL_TRACE_LOG_LIMIT) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", d.a.l0.a.n1.a.s(response.headers()));
                    d.a.l0.a.u.e.j.g.J(jSONObject, response.body(), B, D);
                    i.this.y(jSONObject);
                    this.f43711e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } else {
                    d.a.l0.a.u.e.j.g.K(this.f43707a, this.f43709c, C, currentTimeMillis);
                    this.f43711e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                }
            } catch (IOException | JSONException e2) {
                if (a0.f40949b) {
                    Log.d("RequestAction", Log.getStackTraceString(e2));
                }
                this.f43711e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
            int code = response.code();
            String message = response.message();
            if (a0.f40949b) {
                Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f43709c + ", msg=" + message);
            }
            d.a.l0.a.j2.k.K(code, this.f43709c, G, message, l, f2, this.f43713g, System.currentTimeMillis());
        }
    }

    public i(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/request");
    }

    public boolean A(@NonNull d.a.l0.a.a2.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            return false;
        }
        Pair<HttpRequest, Integer> u = d.a.l0.a.u.e.j.g.u(a2, str);
        HttpRequest httpRequest = (HttpRequest) u.first;
        if (httpRequest == null) {
            unitedSchemeEntity.result = t(((Integer) u.second).intValue());
            return false;
        }
        z(eVar, a2, httpRequest, str, callbackHandler);
        return true;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
        }
        if (k(eVar, unitedSchemeEntity)) {
            String a2 = d.a.l0.a.u.e.j.h.a(eVar.f40749f);
            if (A(eVar, unitedSchemeEntity, callbackHandler, a2)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean x(@NonNull d.a.l0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        return d.a.l0.a.c1.a.d().i(eVar, jSONObject, str, str2, new c(eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3));
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
    }

    public final void z(@NonNull d.a.l0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        HttpUrl url = httpRequest.getOkRequest().url();
        String httpUrl = url.toString();
        String optString = jSONObject.optString("cb");
        if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
            return;
        }
        httpRequest.executeStat(new a(this, str, url, httpUrl, eVar.N().G(), System.currentTimeMillis(), new c(eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
    }

    public i(d.a.l0.a.c2.e eVar, String str) {
        super(eVar, str);
    }
}
