package d.b.g0.b.m.i.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.location.BDLocation;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.w0.c.d;
import h.d;
import h.j;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a extends a0 {

    /* renamed from: d.b.g0.b.m.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0915a implements h.n.b<d.b.g0.b.m.i.b.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.b.m.i.b.a f47445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f47446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47447g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47448h;

        public C0915a(d.b.g0.b.m.i.b.a aVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f47445e = aVar;
            this.f47446f = context;
            this.f47447g = callbackHandler;
            this.f47448h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.b.g0.b.m.i.b.b bVar) {
            d.b.g0.b.m.i.c.a.b(this.f47445e, bVar);
            a.this.t(this.f47446f, this.f47447g, this.f47448h, this.f47445e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f47449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47451g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.b.m.i.b.a f47452h;

        public b(Context context, CallbackHandler callbackHandler, String str, d.b.g0.b.m.i.b.a aVar) {
            this.f47449e = context;
            this.f47450f = callbackHandler;
            this.f47451g = str;
            this.f47452h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            d.b.g0.a.c0.c.l("recommend", "get param(l) info fail: " + th.getMessage());
            a.this.t(this.f47449e, this.f47450f, this.f47451g, this.f47452h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a<d.b.g0.b.m.i.b.b> {

        /* renamed from: d.b.g0.b.m.i.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0916a implements d.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f47453a;

            public C0916a(c cVar, j jVar) {
                this.f47453a = jVar;
            }

            @Override // d.b.g0.a.w0.c.d.a
            public void a(d.b.g0.a.t1.k.k0.b bVar) {
                d.b.g0.b.m.i.b.b bVar2 = new d.b.g0.b.m.i.b.b();
                if (bVar != null && !TextUtils.isEmpty(bVar.f46450a)) {
                    bVar2.f47475a = bVar.f46450a;
                    bVar2.f47476b = bVar.f46452c;
                    bVar2.f47477c = bVar.f46451b;
                } else {
                    bVar2.f47475a = "unknown";
                }
                this.f47453a.onNext(bVar2);
                this.f47453a.onCompleted();
            }

            @Override // d.b.g0.a.w0.c.d.a
            public void onFailed(int i) {
                this.f47453a.onError(new Throwable());
            }
        }

        public c(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super d.b.g0.b.m.i.b.b> jVar) {
            d.b.g0.a.w0.a.w().d(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C0916a(this, jVar));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.a.i2.u0.b<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47455f;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            this.f47454e = callbackHandler;
            this.f47455f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            if (jSONObject == null) {
                d.b.g0.a.c0.c.b("recommend", "response is null");
                this.f47454e.handleSchemeDispatchCallback(this.f47455f, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                return;
            }
            d.b.g0.a.c0.c.g("recommend", "recommend action execute success");
            this.f47454e.handleSchemeDispatchCallback(this.f47455f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47456a;

        public e(a aVar, d.b.g0.a.i2.u0.b bVar) {
            this.f47456a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("info", "on success but jsonObject is null");
                    jSONObject2.put("statusCode", i);
                } catch (JSONException e2) {
                    if (a0.f46288b) {
                        e2.printStackTrace();
                    }
                }
                d.b.g0.b.m.i.c.a.f(jSONObject2.toString());
            }
            this.f47456a.onCallback(jSONObject);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            d.b.g0.a.c0.c.g("recommend", "parse response");
            String str = StringUtil.NULL_STRING;
            if (response != null && response.body() != null) {
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("info", "parse response fail");
                        jSONObject.put("response code", response.code());
                        if (string != null) {
                            str = SchemeCollecter.CLASSIFY_EMPTY;
                        }
                        jSONObject.put("response body", str);
                    } catch (JSONException e2) {
                        if (a0.f46288b) {
                            e2.printStackTrace();
                        }
                    }
                    d.b.g0.b.m.i.c.a.f(jSONObject.toString());
                    return null;
                }
                return new JSONObject(string);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("info", "parse response fail");
                if (response == null) {
                    jSONObject2.put("response", StringUtil.NULL_STRING);
                } else {
                    jSONObject2.put("response code", response.code());
                    if (response.body() == null) {
                        jSONObject2.put("response body", StringUtil.NULL_STRING);
                    } else {
                        jSONObject2.put("response", "unknown");
                    }
                }
            } catch (JSONException e3) {
                if (a0.f46288b) {
                    e3.printStackTrace();
                }
            }
            d.b.g0.b.m.i.c.a.f(jSONObject2.toString());
            return null;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.g0.a.c0.c.c("recommend", "http response with exception:", exc);
            this.f47456a.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
            } catch (JSONException e2) {
                if (a0.f46288b) {
                    e2.printStackTrace();
                }
            }
            d.b.g0.b.m.i.c.a.f(jSONObject.toString());
        }
    }

    public a(d.b.g0.a.t1.j jVar, String str) {
        super(jVar, str);
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.b.g0.a.c0.c.b("recommend", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("recommend", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = a2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("recommend", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("data");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            d.b.g0.a.c0.c.g("recommend", "start perform request");
            s(context, callbackHandler, optString, optJSONObject);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.b.g0.a.c0.c.b("recommend", "param data is empty");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
        return false;
    }

    @NonNull
    public final d.b.g0.a.i2.u0.b<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        return new d(this, callbackHandler, str);
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull d.b.g0.a.i2.u0.b<JSONObject> bVar) {
        return new e(this, bVar);
    }

    public final h.d<d.b.g0.b.m.i.b.b> q(Context context) {
        if (context == null) {
            return null;
        }
        if (!d.b.g0.a.i2.c.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return h.d.c(new c(this));
        }
        return null;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        d.b.g0.a.c0.c.g("recommend", "get request params");
        d.b.g0.b.m.i.b.a aVar = new d.b.g0.b.m.i.b.a(context, jSONObject);
        h.d<d.b.g0.b.m.i.b.b> q = q(context);
        if (q != null) {
            q.H(60L, TimeUnit.MILLISECONDS).E(new C0915a(aVar, context, callbackHandler, str), new b(context, callbackHandler, str, aVar));
            return;
        }
        d.b.g0.a.c0.c.l("recommend", "get param(l) is null");
        t(context, callbackHandler, str, aVar);
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.b.g0.b.m.i.b.a aVar) {
        d.b.g0.a.c0.c.g("recommend", "start real perform request");
        String u = d.b.g0.a.b0.c.u(r());
        d.b.g0.a.i2.u0.b<JSONObject> o = o(callbackHandler, str);
        ResponseCallback<JSONObject> p = p(o);
        MediaType parse = MediaType.parse("application/json");
        d.b.g0.a.c0.c.g("recommend", "encrypt request param");
        String a2 = d.b.g0.b.m.i.c.a.a(aVar.d());
        if (TextUtils.isEmpty(a2)) {
            d.b.g0.a.c0.c.b("recommend", "encrypt request param fail");
            o.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail");
            } catch (JSONException e2) {
                if (a0.f46288b) {
                    e2.printStackTrace();
                }
            }
            d.b.g0.b.m.i.c.a.f(jSONObject.toString());
            return;
        }
        d.b.g0.a.c0.c.g("recommend", "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(u)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
    }
}
