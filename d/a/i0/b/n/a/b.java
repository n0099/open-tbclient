package d.a.i0.b.n.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.k;
import d.a.i0.a.v2.v;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.i0.a.n1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46127e = k.f43025a;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46128e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46129f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46130g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f46131h;

        /* renamed from: d.a.i0.b.n.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0937a implements d.a.i0.a.v2.e1.b<String> {
            public C0937a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                a aVar = a.this;
                b.this.E(str, aVar.f46128e, aVar.f46129f, aVar.f46131h);
            }
        }

        public a(CallbackHandler callbackHandler, String str, String str2, d.a.i0.a.a2.e eVar) {
            this.f46128e = callbackHandler;
            this.f46129f = str;
            this.f46130g = str2;
            this.f46131h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.p(iVar, this.f46128e, this.f46129f);
            } else {
                b.z(this.f46130g, new C0937a());
            }
        }
    }

    /* renamed from: d.a.i0.b.n.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0938b implements d.a.i0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46135f;

        public C0938b(b bVar, CallbackHandler callbackHandler, String str) {
            this.f46134e = callbackHandler;
            this.f46135f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f46134e.handleSchemeDispatchCallback(this.f46135f, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f46136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f46137b;

        public c(d.a.i0.a.v2.e1.b bVar, Request request) {
            this.f46136a = bVar;
            this.f46137b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f46136a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
            d.a.i0.a.j2.q.a.b(SwanInterfaceType.REAL_NAME_CHECK, 2101, this.f46137b.url().toString(), null, exc != null ? exc.getMessage() : "");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            b.F(response, this.f46136a);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.a.i0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f46138e;

        public d(d.a.i0.a.v2.e1.b bVar) {
            this.f46138e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle == null) {
                this.f46138e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                return;
            }
            String g2 = v.g(bundle, "callbackKey");
            if (TextUtils.isEmpty(g2)) {
                this.f46138e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, v.g(bundle, "failMsg")).toString());
                return;
            }
            d.a.i0.a.e0.d.g("FaceVerifyAction", g2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callbackKey", g2);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e2) {
                if (b.f46127e) {
                    e2.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            this.f46138e.onCallback(wrapCallbackParams.toString());
        }
    }

    public b(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/faceVerify");
    }

    public static String A(String str) {
        d.a.i0.a.e0.d.g("FaceVerifyAction", str);
        return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
    }

    public static String B(String str, int i2, String str2, Response response) {
        d.a.i0.a.j2.q.a.c(SwanInterfaceType.REAL_NAME_CHECK, i2, str2, response);
        return A(str);
    }

    public static void C(@NonNull Request request, d.a.i0.a.v2.e1.b<String> bVar) {
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(request.url().toString(), request.body(), new c(bVar, request));
        aVar.f47801i = request.tag();
        aVar.f47798f = true;
        aVar.f47799g = true;
        aVar.f47800h = true;
        d.a.i0.m.e.a.g().e(aVar);
        d.a.i0.a.j2.q.a.a(SwanInterfaceType.REAL_NAME_CHECK);
    }

    public static void D(String str, d.a.i0.a.a2.e eVar, d.a.i0.a.v2.e1.b<String> bVar) {
        d.a.i0.b.j.a.K(eVar.x(), str, eVar.f40575f, new d(bVar));
    }

    public static void F(Response response, d.a.i0.a.v2.e1.b<String> bVar) {
        String str = null;
        if (response == null) {
            bVar.onCallback(B("response is null", 2103, null, null));
        } else if (!response.isSuccessful()) {
            bVar.onCallback(B("response code is error", 2104, null, response));
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                bVar.onCallback(B("body is null", 2103, null, response));
                return;
            }
            try {
                str = body.string();
            } catch (IOException e2) {
                if (f46127e) {
                    e2.printStackTrace();
                }
            }
            if (f46127e) {
                Log.d("FaceVerifyAction", "response body : " + str);
            }
            if (TextUtils.isEmpty(str)) {
                bVar.onCallback(B("body is null", 2103, str, response));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                if (optInt != 0) {
                    bVar.onCallback(B(jSONObject.optString("errmsg"), optInt, str, response));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    bVar.onCallback(A("server data is null"));
                } else {
                    bVar.onCallback(String.valueOf(optJSONObject.optInt("real_name")));
                }
            } catch (JSONException e3) {
                if (f46127e) {
                    e3.printStackTrace();
                }
                bVar.onCallback(B("body format error", 2103, str, response));
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        HttpUrl parse = HttpUrl.parse(d.a.i0.a.d0.c.f41135a);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
        for (Map.Entry<String, String> entry : d.a.i0.a.d0.b.b().f41134d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        builder.post(new FormBody.Builder().build());
        builder.url(d.a.i0.a.d0.c.v(build.toString()));
        return builder.build();
    }

    public static void z(String str, d.a.i0.a.v2.e1.b<String> bVar) {
        Request y = y(str);
        if (y == null) {
            bVar.onCallback(null);
        } else {
            C(y, bVar);
        }
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, d.a.i0.a.a2.e eVar) {
        if (str == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
            callbackHandler.handleSchemeDispatchCallback(str2, str);
        } else {
            D(str, eVar, new C0938b(this, callbackHandler, str2));
        }
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.d0()) {
            if (f46127e) {
                Log.d("FaceVerifyAction", "FaceVerifyAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
                return false;
            }
            String a2 = d.a.i0.a.u.e.j.h.a(eVar.f40575f);
            JSONObject n = n(a2);
            eVar.T().h(context, "mapp_i_face_verify", d.a.i0.a.e2.c.d.i(optParamsAsJo), new a(callbackHandler, optString, a2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }
}
