package d.a.l0.b.n.a;

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
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.k;
import d.a.l0.a.v2.v;
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
public class b extends d.a.l0.a.n1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46303e = k.f43199a;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46305f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46306g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46307h;

        /* renamed from: d.a.l0.b.n.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0948a implements d.a.l0.a.v2.e1.b<String> {
            public C0948a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                a aVar = a.this;
                b.this.E(str, aVar.f46304e, aVar.f46305f, aVar.f46307h);
            }
        }

        public a(CallbackHandler callbackHandler, String str, String str2, d.a.l0.a.a2.e eVar) {
            this.f46304e = callbackHandler;
            this.f46305f = str;
            this.f46306g = str2;
            this.f46307h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.p(iVar, this.f46304e, this.f46305f);
            } else {
                b.z(this.f46306g, new C0948a());
            }
        }
    }

    /* renamed from: d.a.l0.b.n.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0949b implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46310e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46311f;

        public C0949b(b bVar, CallbackHandler callbackHandler, String str) {
            this.f46310e = callbackHandler;
            this.f46311f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f46310e.handleSchemeDispatchCallback(this.f46311f, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f46312a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f46313b;

        public c(d.a.l0.a.v2.e1.b bVar, Request request) {
            this.f46312a = bVar;
            this.f46313b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f46312a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
            d.a.l0.a.j2.q.a.b(SwanInterfaceType.REAL_NAME_CHECK, 2101, this.f46313b.url().toString(), null, exc != null ? exc.getMessage() : "");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            b.F(response, this.f46312a);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f46314e;

        public d(d.a.l0.a.v2.e1.b bVar) {
            this.f46314e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle == null) {
                this.f46314e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                return;
            }
            String g2 = v.g(bundle, "callbackKey");
            if (TextUtils.isEmpty(g2)) {
                this.f46314e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, v.g(bundle, "failMsg")).toString());
                return;
            }
            d.a.l0.a.e0.d.g("FaceVerifyAction", g2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callbackKey", g2);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e2) {
                if (b.f46303e) {
                    e2.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            this.f46314e.onCallback(wrapCallbackParams.toString());
        }
    }

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/faceVerify");
    }

    public static String A(String str) {
        d.a.l0.a.e0.d.g("FaceVerifyAction", str);
        return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
    }

    public static String B(String str, int i2, String str2, Response response) {
        d.a.l0.a.j2.q.a.c(SwanInterfaceType.REAL_NAME_CHECK, i2, str2, response);
        return A(str);
    }

    public static void C(@NonNull Request request, d.a.l0.a.v2.e1.b<String> bVar) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(request.url().toString(), request.body(), new c(bVar, request));
        aVar.f47977i = request.tag();
        aVar.f47974f = true;
        aVar.f47975g = true;
        aVar.f47976h = true;
        d.a.l0.m.e.a.g().e(aVar);
        d.a.l0.a.j2.q.a.a(SwanInterfaceType.REAL_NAME_CHECK);
    }

    public static void D(String str, d.a.l0.a.a2.e eVar, d.a.l0.a.v2.e1.b<String> bVar) {
        d.a.l0.b.j.a.K(eVar.x(), str, eVar.f40749f, new d(bVar));
    }

    public static void F(Response response, d.a.l0.a.v2.e1.b<String> bVar) {
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
                if (f46303e) {
                    e2.printStackTrace();
                }
            }
            if (f46303e) {
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
                if (f46303e) {
                    e3.printStackTrace();
                }
                bVar.onCallback(B("body format error", 2103, str, response));
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        HttpUrl parse = HttpUrl.parse(d.a.l0.a.d0.c.f41309a);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
        for (Map.Entry<String, String> entry : d.a.l0.a.d0.b.b().f41308d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        builder.post(new FormBody.Builder().build());
        builder.url(d.a.l0.a.d0.c.v(build.toString()));
        return builder.build();
    }

    public static void z(String str, d.a.l0.a.v2.e1.b<String> bVar) {
        Request y = y(str);
        if (y == null) {
            bVar.onCallback(null);
        } else {
            C(y, bVar);
        }
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, d.a.l0.a.a2.e eVar) {
        if (str == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
            callbackHandler.handleSchemeDispatchCallback(str2, str);
        } else {
            D(str, eVar, new C0949b(this, callbackHandler, str2));
        }
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.d0()) {
            if (f46303e) {
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
            String a2 = d.a.l0.a.u.e.j.h.a(eVar.f40749f);
            JSONObject n = n(a2);
            eVar.T().h(context, "mapp_i_face_verify", d.a.l0.a.e2.c.d.i(optParamsAsJo), new a(callbackHandler, optString, a2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }
}
