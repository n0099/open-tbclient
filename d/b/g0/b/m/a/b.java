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
    public static final boolean f47338e = k.f45050a;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47341g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47342h;

        /* renamed from: d.b.g0.b.m.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0904a implements d.b.g0.a.i2.u0.b<String> {
            public C0904a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                a aVar = a.this;
                b.this.D(str, aVar.f47339e, aVar.f47340f, aVar.f47342h);
            }
        }

        public a(CallbackHandler callbackHandler, String str, String str2, d.b.g0.a.r1.e eVar) {
            this.f47339e = callbackHandler;
            this.f47340f = str;
            this.f47341g = str2;
            this.f47342h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f47339e, this.f47340f);
            } else {
                b.z(this.f47341g, new C0904a());
            }
        }
    }

    /* renamed from: d.b.g0.b.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0905b implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47344e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47345f;

        public C0905b(b bVar, CallbackHandler callbackHandler, String str) {
            this.f47344e = callbackHandler;
            this.f47345f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f47344e.handleSchemeDispatchCallback(this.f47345f, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47346a;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f47346a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47346a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            b.E(response, this.f47346a);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.b.g0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47347e;

        public d(d.b.g0.a.i2.u0.b bVar) {
            this.f47347e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle == null) {
                this.f47347e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                return;
            }
            String g2 = u.g(bundle, "callbackKey");
            if (TextUtils.isEmpty(g2)) {
                this.f47347e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, u.g(bundle, "failMsg")).toString());
                return;
            }
            d.b.g0.a.c0.c.g("FaceVerifyAction", g2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callbackKey", g2);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e2) {
                if (b.f47338e) {
                    e2.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            this.f47347e.onCallback(wrapCallbackParams.toString());
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
        aVar.f48883f = true;
        aVar.f48884g = true;
        aVar.f48885h = true;
        d.b.g0.k.e.a.f().e(aVar);
    }

    public static void C(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.i2.u0.b<String> bVar) {
        d.b.g0.b.i.a.M(eVar.n(), str, eVar.f45739f, new d(bVar));
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
                if (f47338e) {
                    e2.printStackTrace();
                }
            }
            if (f47338e) {
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
                if (f47338e) {
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
        for (Map.Entry<String, String> entry : d.b.g0.a.b0.b.b().f43274d.entrySet()) {
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
            C(str, eVar, new C0905b(this, callbackHandler, str2));
        }
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.Z()) {
            if (f47338e) {
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
            String a2 = d.b.g0.a.t.c.h.c.a(eVar.f45739f);
            JSONObject n = n(a2);
            eVar.R().h(context, "mapp_i_face_verify", d.b.g0.a.v1.c.c.i(optParamsAsJo), new a(callbackHandler, optString, a2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }
}
