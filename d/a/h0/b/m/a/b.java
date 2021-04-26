package d.a.h0.b.m.a;

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
import d.a.h0.a.i2.u;
import d.a.h0.a.k;
import d.a.h0.a.t1.j;
import d.a.h0.a.v1.c.i.b;
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
public class b extends d.a.h0.a.g1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45501e = k.f43101a;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45503f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45504g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45505h;

        /* renamed from: d.a.h0.b.m.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0876a implements d.a.h0.a.i2.u0.b<String> {
            public C0876a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                a aVar = a.this;
                b.this.D(str, aVar.f45502e, aVar.f45503f, aVar.f45505h);
            }
        }

        public a(CallbackHandler callbackHandler, String str, String str2, d.a.h0.a.r1.e eVar) {
            this.f45502e = callbackHandler;
            this.f45503f = str;
            this.f45504g = str2;
            this.f45505h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.o(hVar, this.f45502e, this.f45503f);
            } else {
                b.z(this.f45504g, new C0876a());
            }
        }
    }

    /* renamed from: d.a.h0.b.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0877b implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45509f;

        public C0877b(b bVar, CallbackHandler callbackHandler, String str) {
            this.f45508e = callbackHandler;
            this.f45509f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            this.f45508e.handleSchemeDispatchCallback(this.f45509f, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f45510a;

        public c(d.a.h0.a.i2.u0.b bVar) {
            this.f45510a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f45510a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            b.E(response, this.f45510a);
            return response;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.a.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f45511e;

        public d(d.a.h0.a.i2.u0.b bVar) {
            this.f45511e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            if (bundle == null) {
                this.f45511e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                return;
            }
            String g2 = u.g(bundle, "callbackKey");
            if (TextUtils.isEmpty(g2)) {
                this.f45511e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, u.g(bundle, "failMsg")).toString());
                return;
            }
            d.a.h0.a.c0.c.g("FaceVerifyAction", g2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callbackKey", g2);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e2) {
                if (b.f45501e) {
                    e2.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            this.f45511e.onCallback(wrapCallbackParams.toString());
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/faceVerify");
    }

    public static String A(String str) {
        d.a.h0.a.c0.c.g("FaceVerifyAction", str);
        return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
    }

    public static void B(Request request, d.a.h0.a.i2.u0.b<String> bVar) {
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(request.url().toString(), request.body(), new c(bVar));
        aVar.f47114i = request.tag();
        aVar.f47111f = true;
        aVar.f47112g = true;
        aVar.f47113h = true;
        d.a.h0.k.e.a.f().e(aVar);
    }

    public static void C(String str, d.a.h0.a.r1.e eVar, d.a.h0.a.i2.u0.b<String> bVar) {
        d.a.h0.b.i.a.M(eVar.v(), str, eVar.f43823f, new d(bVar));
    }

    public static void E(Response response, d.a.h0.a.i2.u0.b<String> bVar) {
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
                if (f45501e) {
                    e2.printStackTrace();
                }
            }
            if (f45501e) {
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
                if (f45501e) {
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
        for (Map.Entry<String, String> entry : d.a.h0.a.b0.b.b().f41266d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        builder.post(new FormBody.Builder().build());
        builder.url(d.a.h0.a.b0.c.u(build.toString()));
        return builder.build();
    }

    public static void z(String str, d.a.h0.a.i2.u0.b<String> bVar) {
        Request y = y(str);
        if (y == null) {
            bVar.onCallback(null);
        } else {
            B(y, bVar);
        }
    }

    public final void D(String str, CallbackHandler callbackHandler, String str2, d.a.h0.a.r1.e eVar) {
        if (str == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
            callbackHandler.handleSchemeDispatchCallback(str2, str);
        } else {
            C(str, eVar, new C0877b(this, callbackHandler, str2));
        }
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        } else if (eVar.Z()) {
            if (f45501e) {
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
            String a2 = d.a.h0.a.t.c.h.c.a(eVar.f43823f);
            JSONObject n = n(a2);
            eVar.R().h(context, "mapp_i_face_verify", d.a.h0.a.v1.c.c.i(optParamsAsJo), new a(callbackHandler, optString, a2, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }
}
