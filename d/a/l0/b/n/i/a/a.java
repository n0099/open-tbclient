package d.a.l0.b.n.i.a;

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
import d.a.l0.a.c1.d.d;
import d.a.l0.a.c2.f.a0;
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

    /* renamed from: d.a.l0.b.n.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1014a implements h.n.b<d.a.l0.b.n.i.b.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.b.n.i.b.a f50081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f50082f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50083g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50084h;

        public C1014a(d.a.l0.b.n.i.b.a aVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f50081e = aVar;
            this.f50082f = context;
            this.f50083g = callbackHandler;
            this.f50084h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.a.l0.b.n.i.b.b bVar) {
            d.a.l0.b.n.i.c.a.b(this.f50081e, bVar);
            a.this.t(this.f50082f, this.f50083g, this.f50084h, this.f50081e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f50086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50088g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.b.n.i.b.a f50089h;

        public b(Context context, CallbackHandler callbackHandler, String str, d.a.l0.b.n.i.b.a aVar) {
            this.f50086e = context;
            this.f50087f = callbackHandler;
            this.f50088g = str;
            this.f50089h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            d.a.l0.a.e0.d.l("recommend", "get param(l) info fail: " + th.getMessage());
            a.this.t(this.f50086e, this.f50087f, this.f50088g, this.f50089h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a<d.a.l0.b.n.i.b.b> {

        /* renamed from: d.a.l0.b.n.i.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1015a implements d.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f50091a;

            public C1015a(c cVar, j jVar) {
                this.f50091a = jVar;
            }

            @Override // d.a.l0.a.c1.d.d.a
            public void a(d.a.l0.a.c2.f.k0.b bVar) {
                d.a.l0.b.n.i.b.b bVar2 = new d.a.l0.b.n.i.b.b();
                if (bVar != null && !TextUtils.isEmpty(bVar.f44803a)) {
                    bVar2.f50114a = bVar.f44803a;
                    bVar2.f50115b = bVar.f44805c;
                    bVar2.f50116c = bVar.f44804b;
                } else {
                    bVar2.f50114a = "unknown";
                }
                this.f50091a.onNext(bVar2);
                this.f50091a.onCompleted();
            }

            @Override // d.a.l0.a.c1.d.d.a
            public void onFailed(int i2) {
                this.f50091a.onError(new Throwable());
            }
        }

        public c(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super d.a.l0.b.n.i.b.b> jVar) {
            d.a.l0.a.c1.a.E().b(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C1015a(this, jVar));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.v2.e1.b<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50093f;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            this.f50092e = callbackHandler;
            this.f50093f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            if (jSONObject == null) {
                d.a.l0.a.e0.d.b("recommend", "response is null");
                this.f50092e.handleSchemeDispatchCallback(this.f50093f, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                return;
            }
            d.a.l0.a.e0.d.g("recommend", "recommend action execute success");
            this.f50092e.handleSchemeDispatchCallback(this.f50093f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f50094a;

        public e(a aVar, d.a.l0.a.v2.e1.b bVar) {
            this.f50094a = bVar;
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
                    if (a0.f44625b) {
                        e2.printStackTrace();
                    }
                }
                d.a.l0.b.n.i.c.a.f(jSONObject2.toString());
            }
            this.f50094a.onCallback(jSONObject);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            d.a.l0.a.e0.d.g("recommend", "parse response");
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
                        if (a0.f44625b) {
                            e2.printStackTrace();
                        }
                    }
                    d.a.l0.b.n.i.c.a.f(jSONObject.toString());
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
                if (a0.f44625b) {
                    e3.printStackTrace();
                }
            }
            d.a.l0.b.n.i.c.a.f(jSONObject2.toString());
            return null;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.l0.a.e0.d.c("recommend", "http response with exception:", exc);
            this.f50094a.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
            } catch (JSONException e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
            }
            d.a.l0.b.n.i.c.a.f(jSONObject.toString());
        }
    }

    public a(d.a.l0.a.c2.e eVar, String str) {
        super(eVar, str);
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.a.l0.a.e0.d.b("recommend", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.e0.d.b("recommend", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = a2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("recommend", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("data");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            d.a.l0.a.e0.d.g("recommend", "start perform request");
            s(context, callbackHandler, optString, optJSONObject);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.a.l0.a.e0.d.b("recommend", "param data is empty");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
        return false;
    }

    @NonNull
    public final d.a.l0.a.v2.e1.b<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        return new d(this, callbackHandler, str);
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull d.a.l0.a.v2.e1.b<JSONObject> bVar) {
        return new e(this, bVar);
    }

    public final h.d<d.a.l0.b.n.i.b.b> q(Context context) {
        if (context == null) {
            return null;
        }
        if (!d.a.l0.a.v2.d.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            return h.d.b(new c(this));
        }
        return null;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        d.a.l0.a.e0.d.g("recommend", "get request params");
        d.a.l0.b.n.i.b.a aVar = new d.a.l0.b.n.i.b.a(context, jSONObject);
        h.d<d.a.l0.b.n.i.b.b> q = q(context);
        if (q != null) {
            q.E(60L, TimeUnit.MILLISECONDS).C(new C1014a(aVar, context, callbackHandler, str), new b(context, callbackHandler, str, aVar));
            return;
        }
        d.a.l0.a.e0.d.l("recommend", "get param(l) is null");
        t(context, callbackHandler, str, aVar);
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.l0.b.n.i.b.a aVar) {
        d.a.l0.a.e0.d.g("recommend", "start real perform request");
        String v = d.a.l0.a.d0.c.v(r());
        d.a.l0.a.v2.e1.b<JSONObject> o = o(callbackHandler, str);
        ResponseCallback<JSONObject> p = p(o);
        MediaType parse = MediaType.parse("application/json");
        d.a.l0.a.e0.d.g("recommend", "encrypt request param");
        String a2 = d.a.l0.b.n.i.c.a.a(aVar.d());
        if (TextUtils.isEmpty(a2)) {
            d.a.l0.a.e0.d.b("recommend", "encrypt request param fail");
            o.onCallback(null);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail");
            } catch (JSONException e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
            }
            d.a.l0.b.n.i.c.a.f(jSONObject.toString());
            return;
        }
        d.a.l0.a.e0.d.g("recommend", "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
    }
}
