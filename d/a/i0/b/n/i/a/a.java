package d.a.i0.b.n.i.a;

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
import d.a.i0.a.c1.d.d;
import d.a.i0.a.c2.f.a0;
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

    /* renamed from: d.a.i0.b.n.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0947a implements h.n.b<d.a.i0.b.n.i.b.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.b.n.i.b.a f46231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46232f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46233g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46234h;

        public C0947a(d.a.i0.b.n.i.b.a aVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f46231e = aVar;
            this.f46232f = context;
            this.f46233g = callbackHandler;
            this.f46234h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.a.i0.b.n.i.b.b bVar) {
            d.a.i0.b.n.i.c.a.b(this.f46231e, bVar);
            a.this.t(this.f46232f, this.f46233g, this.f46234h, this.f46231e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46237f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46238g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.b.n.i.b.a f46239h;

        public b(Context context, CallbackHandler callbackHandler, String str, d.a.i0.b.n.i.b.a aVar) {
            this.f46236e = context;
            this.f46237f = callbackHandler;
            this.f46238g = str;
            this.f46239h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            d.a.i0.a.e0.d.l("recommend", "get param(l) info fail: " + th.getMessage());
            a.this.t(this.f46236e, this.f46237f, this.f46238g, this.f46239h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a<d.a.i0.b.n.i.b.b> {

        /* renamed from: d.a.i0.b.n.i.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0948a implements d.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f46241a;

            public C0948a(c cVar, j jVar) {
                this.f46241a = jVar;
            }

            @Override // d.a.i0.a.c1.d.d.a
            public void a(d.a.i0.a.c2.f.k0.b bVar) {
                d.a.i0.b.n.i.b.b bVar2 = new d.a.i0.b.n.i.b.b();
                if (bVar != null && !TextUtils.isEmpty(bVar.f40953a)) {
                    bVar2.f46264a = bVar.f40953a;
                    bVar2.f46265b = bVar.f40955c;
                    bVar2.f46266c = bVar.f40954b;
                } else {
                    bVar2.f46264a = "unknown";
                }
                this.f46241a.onNext(bVar2);
                this.f46241a.onCompleted();
            }

            @Override // d.a.i0.a.c1.d.d.a
            public void onFailed(int i2) {
                this.f46241a.onError(new Throwable());
            }
        }

        public c(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super d.a.i0.b.n.i.b.b> jVar) {
            d.a.i0.a.c1.a.E().b(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C0948a(this, jVar));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.a.v2.e1.b<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46242e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46243f;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            this.f46242e = callbackHandler;
            this.f46243f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            if (jSONObject == null) {
                d.a.i0.a.e0.d.b("recommend", "response is null");
                this.f46242e.handleSchemeDispatchCallback(this.f46243f, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                return;
            }
            d.a.i0.a.e0.d.g("recommend", "recommend action execute success");
            this.f46242e.handleSchemeDispatchCallback(this.f46243f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f46244a;

        public e(a aVar, d.a.i0.a.v2.e1.b bVar) {
            this.f46244a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (jSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("info", "on success but jsonObject is null");
                    jSONObject2.put("statusCode", i2);
                } catch (JSONException e2) {
                    if (a0.f40775b) {
                        e2.printStackTrace();
                    }
                }
                d.a.i0.b.n.i.c.a.f(jSONObject2.toString());
            }
            this.f46244a.onCallback(jSONObject);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            d.a.i0.a.e0.d.g("recommend", "parse response");
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
                        if (a0.f40775b) {
                            e2.printStackTrace();
                        }
                    }
                    d.a.i0.b.n.i.c.a.f(jSONObject.toString());
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
                if (a0.f40775b) {
                    e3.printStackTrace();
                }
            }
            d.a.i0.b.n.i.c.a.f(jSONObject2.toString());
            return null;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.i0.a.e0.d.c("recommend", "http response with exception:", exc);
            this.f46244a.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
            } catch (JSONException e2) {
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
            }
            d.a.i0.b.n.i.c.a.f(jSONObject.toString());
        }
    }

    public a(d.a.i0.a.c2.e eVar, String str) {
        super(eVar, str);
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.a.i0.a.e0.d.b("recommend", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("recommend", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = a2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("recommend", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("data");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            d.a.i0.a.e0.d.g("recommend", "start perform request");
            s(context, callbackHandler, optString, optJSONObject);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.a.i0.a.e0.d.b("recommend", "param data is empty");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
        return false;
    }

    @NonNull
    public final d.a.i0.a.v2.e1.b<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        return new d(this, callbackHandler, str);
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull d.a.i0.a.v2.e1.b<JSONObject> bVar) {
        return new e(this, bVar);
    }

    public final h.d<d.a.i0.b.n.i.b.b> q(Context context) {
        if (context == null) {
            return null;
        }
        if (!d.a.i0.a.v2.d.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return h.d.b(new c(this));
        }
        return null;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        d.a.i0.a.e0.d.g("recommend", "get request params");
        d.a.i0.b.n.i.b.a aVar = new d.a.i0.b.n.i.b.a(context, jSONObject);
        h.d<d.a.i0.b.n.i.b.b> q = q(context);
        if (q != null) {
            q.E(60L, TimeUnit.MILLISECONDS).C(new C0947a(aVar, context, callbackHandler, str), new b(context, callbackHandler, str, aVar));
            return;
        }
        d.a.i0.a.e0.d.l("recommend", "get param(l) is null");
        t(context, callbackHandler, str, aVar);
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.i0.b.n.i.b.a aVar) {
        d.a.i0.a.e0.d.g("recommend", "start real perform request");
        String v = d.a.i0.a.d0.c.v(r());
        d.a.i0.a.v2.e1.b<JSONObject> o = o(callbackHandler, str);
        ResponseCallback<JSONObject> p = p(o);
        MediaType parse = MediaType.parse("application/json");
        d.a.i0.a.e0.d.g("recommend", "encrypt request param");
        String a2 = d.a.i0.b.n.i.c.a.a(aVar.d());
        if (TextUtils.isEmpty(a2)) {
            d.a.i0.a.e0.d.b("recommend", "encrypt request param fail");
            o.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail");
            } catch (JSONException e2) {
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
            }
            d.a.i0.b.n.i.c.a.f(jSONObject.toString());
            return;
        }
        d.a.i0.a.e0.d.g("recommend", "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
    }
}
