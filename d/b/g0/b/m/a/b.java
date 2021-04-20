package d.b.g0.b.m.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import d.b.g0.a.t1.j;
import d.b.g0.a.v1.c.i.b;
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
public class b extends d.b.g0.a.g1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47731e = k.f45443a;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47733f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47734g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47735h;

        /* renamed from: d.b.g0.b.m.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0917a implements d.b.g0.a.i2.u0.b<String> {
            public C0917a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                a aVar = a.this;
                b.this.D(str, aVar.f47732e, aVar.f47733f, aVar.f47735h);
            }
        }

        public a(CallbackHandler callbackHandler, String str, String str2, d.b.g0.a.r1.e eVar) {
            this.f47732e = callbackHandler;
            this.f47733f = str;
            this.f47734g = str2;
            this.f47735h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f47732e, this.f47733f);
            } else {
                b.z(this.f47734g, new C0917a());
            }
        }
    }

    /* renamed from: d.b.g0.b.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0918b implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47738f;

        public C0918b(b bVar, CallbackHandler callbackHandler, String str) {
            this.f47737e = callbackHandler;
            this.f47738f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f47737e.handleSchemeDispatchCallback(this.f47738f, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47739a;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f47739a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47739a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            b.E(response, this.f47739a);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.b.g0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47740e;

        public d(d.b.g0.a.i2.u0.b bVar) {
            this.f47740e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle == null) {
                this.f47740e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                return;
            }
            String g2 = u.g(bundle, "callbackKey");
            if (TextUtils.isEmpty(g2)) {
                this.f47740e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, u.g(bundle, "failMsg")).toString());
                return;
            }
            d.b.g0.a.c0.c.g("FaceVerifyAction", g2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callbackKey", g2);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e2) {
                if (b.f47731e) {
                    e2.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            this.f47740e.onCallback(wrapCallbackParams.toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/faceVerify");
    }

    public static String A(String str) {
        d.b.g0.a.c0.c.g("FaceVerifyAction", str);
        return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
    }

    public static void B(Request request, d.b.g0.a.i2.u0.b<String> bVar) {
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(request.url().toString(), request.body(), new c(bVar));
        aVar.i = request.tag();
        aVar.f49276f = true;
        aVar.f49277g = true;
        aVar.f49278h = true;
        d.b.g0.k.e.a.f().e(aVar);
    }

    public static void C(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.i2.u0.b<String> bVar) {
        d.b.g0.b.i.a.M(eVar.n(), str, eVar.f46132f, new d(bVar));
    }

    public static void E(Response response, d.b.g0.a.i2.u0.b<String> bVar) {
        if (response == null) {
            bVar.onCallback(A("response is null"));
        } else if (!response.isSuccessful()) {
            bVar.onCallback(A("response code is error"));
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                bVar.onCallback(A("body is null"));
                return;
            }
            String str = null;
            try {
                str = body.string();
            } catch (IOException e2) {
                if (f47731e) {
                    e2.printStackTrace();
                }
            }
            if (f47731e) {
                Log.d("FaceVerifyAction", "response body : " + str);
            }
            if (TextUtils.isEmpty(str)) {
                bVar.onCallback(A("body is null"));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno") != 0) {
                    bVar.onCallback(A(jSONObject.optString("errmsg")));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    bVar.onCallback(A("server data is null"));
                } else {
                    bVar.onCallback(String.valueOf(optJSONObject.optInt("real_name")));
                }
            } catch (JSONException e3) {
                if (f47731e) {
                    e3.printStackTrace();
                }
                bVar.onCallback(A("body format error"));
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        HttpUrl parse = HttpUrl.parse(BaseUrlManager.ONLINE_URL);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
        for (Map.Entry<String, String> entry : d.b.g0.a.b0.b.b().f43667d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        builder.post(new FormBody.Builder().build());
        builder.url(d.b.g0.a.b0.c.u(build.toString()));
        return builder.build();
    }

    public static void z(String str, d.b.g0.a.i2.u0.b<String> bVar) {
        Request y = y(str);
        if (y == null) {
            bVar.onCallback(null);
        } else {
            B(y, bVar);
        }
    }

    public final void D(String str, CallbackHandler callbackHandler, String str2, d.b.g0.a.r1.e eVar) {
        if (str == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
            callbackHandler.handleSchemeDispatchCallback(str2, str);
        } else {
            C(str, eVar, new C0918b(this, callbackHandler, str2));
        }
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.Z()) {
            if (f47731e) {
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
            String a2 = d.b.g0.a.t.c.h.c.a(eVar.f46132f);
            JSONObject n = n(a2);
            eVar.R().h(context, "mapp_i_face_verify", d.b.g0.a.v1.c.c.i(optParamsAsJo), new a(callbackHandler, optString, a2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }
}
