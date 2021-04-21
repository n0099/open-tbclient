package d.b.h0.b.m.i.a;

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
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.w0.c.d;
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

    /* renamed from: d.b.h0.b.m.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0947a implements h.n.b<d.b.h0.b.m.i.b.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.b.m.i.b.a f48166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f48167f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48168g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48169h;

        public C0947a(d.b.h0.b.m.i.b.a aVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f48166e = aVar;
            this.f48167f = context;
            this.f48168g = callbackHandler;
            this.f48169h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.b.h0.b.m.i.b.b bVar) {
            d.b.h0.b.m.i.c.a.b(this.f48166e, bVar);
            a.this.t(this.f48167f, this.f48168g, this.f48169h, this.f48166e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f48170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48171f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48172g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.b.m.i.b.a f48173h;

        public b(Context context, CallbackHandler callbackHandler, String str, d.b.h0.b.m.i.b.a aVar) {
            this.f48170e = context;
            this.f48171f = callbackHandler;
            this.f48172g = str;
            this.f48173h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            d.b.h0.a.c0.c.l("recommend", "get param(l) info fail: " + th.getMessage());
            a.this.t(this.f48170e, this.f48171f, this.f48172g, this.f48173h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a<d.b.h0.b.m.i.b.b> {

        /* renamed from: d.b.h0.b.m.i.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0948a implements d.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f48174a;

            public C0948a(c cVar, j jVar) {
                this.f48174a = jVar;
            }

            @Override // d.b.h0.a.w0.c.d.a
            public void a(d.b.h0.a.t1.k.k0.b bVar) {
                d.b.h0.b.m.i.b.b bVar2 = new d.b.h0.b.m.i.b.b();
                if (bVar != null && !TextUtils.isEmpty(bVar.f47171a)) {
                    bVar2.f48196a = bVar.f47171a;
                    bVar2.f48197b = bVar.f47173c;
                    bVar2.f48198c = bVar.f47172b;
                } else {
                    bVar2.f48196a = "unknown";
                }
                this.f48174a.onNext(bVar2);
                this.f48174a.onCompleted();
            }

            @Override // d.b.h0.a.w0.c.d.a
            public void onFailed(int i) {
                this.f48174a.onError(new Throwable());
            }
        }

        public c(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super d.b.h0.b.m.i.b.b> jVar) {
            d.b.h0.a.w0.a.w().d(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C0948a(this, jVar));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.h0.a.i2.u0.b<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48175e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48176f;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            this.f48175e = callbackHandler;
            this.f48176f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            if (jSONObject == null) {
                d.b.h0.a.c0.c.b("recommend", "response is null");
                this.f48175e.handleSchemeDispatchCallback(this.f48176f, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                return;
            }
            d.b.h0.a.c0.c.g("recommend", "recommend action execute success");
            this.f48175e.handleSchemeDispatchCallback(this.f48176f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f48177a;

        public e(a aVar, d.b.h0.a.i2.u0.b bVar) {
            this.f48177a = bVar;
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
                    if (a0.f47009b) {
                        e2.printStackTrace();
                    }
                }
                d.b.h0.b.m.i.c.a.f(jSONObject2.toString());
            }
            this.f48177a.onCallback(jSONObject);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            d.b.h0.a.c0.c.g("recommend", "parse response");
            String str = StringUtil.NULL_STRING;
            if (response != null && response.body() != null) {
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("info", "parse response fail");
                        jSONObject.put("response code", response.code());
                        if (string != null) {
                            str = "empty";
                        }
                        jSONObject.put("response body", str);
                    } catch (JSONException e2) {
                        if (a0.f47009b) {
                            e2.printStackTrace();
                        }
                    }
                    d.b.h0.b.m.i.c.a.f(jSONObject.toString());
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
                if (a0.f47009b) {
                    e3.printStackTrace();
                }
            }
            d.b.h0.b.m.i.c.a.f(jSONObject2.toString());
            return null;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.b.h0.a.c0.c.c("recommend", "http response with exception:", exc);
            this.f48177a.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
            } catch (JSONException e2) {
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
            }
            d.b.h0.b.m.i.c.a.f(jSONObject.toString());
        }
    }

    public a(d.b.h0.a.t1.j jVar, String str) {
        super(jVar, str);
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.b.h0.a.c0.c.b("recommend", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.h0.a.c0.c.b("recommend", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = a2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("recommend", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("data");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            d.b.h0.a.c0.c.g("recommend", "start perform request");
            s(context, callbackHandler, optString, optJSONObject);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.b.h0.a.c0.c.b("recommend", "param data is empty");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
        return false;
    }

    @NonNull
    public final d.b.h0.a.i2.u0.b<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        return new d(this, callbackHandler, str);
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull d.b.h0.a.i2.u0.b<JSONObject> bVar) {
        return new e(this, bVar);
    }

    public final h.d<d.b.h0.b.m.i.b.b> q(Context context) {
        if (context == null) {
            return null;
        }
        if (!d.b.h0.a.i2.c.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return h.d.c(new c(this));
        }
        return null;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        d.b.h0.a.c0.c.g("recommend", "get request params");
        d.b.h0.b.m.i.b.a aVar = new d.b.h0.b.m.i.b.a(context, jSONObject);
        h.d<d.b.h0.b.m.i.b.b> q = q(context);
        if (q != null) {
            q.H(60L, TimeUnit.MILLISECONDS).E(new C0947a(aVar, context, callbackHandler, str), new b(context, callbackHandler, str, aVar));
            return;
        }
        d.b.h0.a.c0.c.l("recommend", "get param(l) is null");
        t(context, callbackHandler, str, aVar);
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.b.h0.b.m.i.b.a aVar) {
        d.b.h0.a.c0.c.g("recommend", "start real perform request");
        String u = d.b.h0.a.b0.c.u(r());
        d.b.h0.a.i2.u0.b<JSONObject> o = o(callbackHandler, str);
        ResponseCallback<JSONObject> p = p(o);
        MediaType parse = MediaType.parse("application/json");
        d.b.h0.a.c0.c.g("recommend", "encrypt request param");
        String a2 = d.b.h0.b.m.i.c.a.a(aVar.d());
        if (TextUtils.isEmpty(a2)) {
            d.b.h0.a.c0.c.b("recommend", "encrypt request param fail");
            o.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail");
            } catch (JSONException e2) {
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
            }
            d.b.h0.b.m.i.c.a.f(jSONObject.toString());
            return;
        }
        d.b.h0.a.c0.c.g("recommend", "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(u)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
    }
}
