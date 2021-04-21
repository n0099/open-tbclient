package d.b.h0.b.m.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.k;
import d.b.h0.a.t1.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.a.g1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48052e = k.f45772a;

    /* renamed from: d.b.h0.b.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0936a implements d.b.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48054f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48055g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48056h;
        public final /* synthetic */ d.b.h0.a.r1.e i;

        public C0936a(String str, String str2, String str3, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
            this.f48053e = str;
            this.f48054f = str2;
            this.f48055g = str3;
            this.f48056h = callbackHandler;
            this.i = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            if (bundle != null && !TextUtils.isEmpty(bundle.getString(BdZeusUtil.URL_KEY_MACHINE))) {
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE);
                if (a.f48052e) {
                    Log.d("FaceResultVerifyAction", "stoken=" + string);
                }
                a.this.z(this.f48053e, string, this.f48054f, this.f48055g, this.f48056h, this.i);
                return;
            }
            this.f48056h.handleSchemeDispatchCallback(this.f48055g, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48058b;

        public b(String str, CallbackHandler callbackHandler) {
            this.f48057a = str;
            this.f48058b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.A(exc == null ? "" : exc.getMessage(), this.f48057a, this.f48058b);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            a.this.C(response, this.f48057a, this.f48058b);
            return response;
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/faceResultVerify");
    }

    public final void A(String str, String str2, CallbackHandler callbackHandler) {
        d.b.h0.a.c0.c.g("FaceResultVerifyAction", str);
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
    }

    public final void B(Request request, String str, CallbackHandler callbackHandler) {
        d.b.h0.k.d.a aVar = new d.b.h0.k.d.a(request.url().toString(), request.body(), new b(str, callbackHandler));
        aVar.i = request.tag();
        aVar.f49605f = true;
        aVar.f49606g = true;
        aVar.f49607h = true;
        d.b.h0.k.e.a.f().e(aVar);
    }

    public final void C(Response response, String str, CallbackHandler callbackHandler) {
        if (response == null) {
            A("response is null", str, callbackHandler);
        } else if (!response.isSuccessful()) {
            A("response code is error", str, callbackHandler);
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                A("body is null", str, callbackHandler);
                return;
            }
            String str2 = null;
            try {
                str2 = body.string();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (f48052e) {
                Log.d("FaceResultVerifyAction", "response body : " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                A("body is null", str, callbackHandler);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optInt("errno") != 0) {
                    A(jSONObject.optString("errmsg"), str, callbackHandler);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    A("server data is null", str, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0).toString());
                }
            } catch (JSONException e3) {
                if (f48052e) {
                    e3.printStackTrace();
                }
                A("body format error", str, callbackHandler);
            }
        }
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
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
        String optString2 = optParamsAsJo.optString("callbackKey");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callbackKey is empty");
            return false;
        } else if (!eVar.z().e(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            return false;
        } else {
            String a2 = d.b.h0.a.t.c.h.c.a(eVar.f46461f);
            JSONObject n = n(a2);
            d.b.h0.b.i.a.t(eVar.n(), new C0936a(optString2, a2, optString, callbackHandler, eVar), BdZeusUtil.URL_KEY_MACHINE);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }

    @Nullable
    public final Request y(@Nullable String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(BaseUrlManager.ONLINE_URL);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/facecheck");
        for (Map.Entry<String, String> entry : d.b.h0.a.b0.b.b().f43996d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        if (map != null) {
            builder.post(d.b.h0.a.v1.c.c.b(map));
        }
        builder.url(d.b.h0.a.b0.c.u(build.toString()));
        return builder.build();
    }

    public final void z(String str, String str2, String str3, String str4, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("callbackkey", str);
            jSONObject.put("client_id", eVar.f46461f);
            jSONObject2.put("stoken", str2);
            jSONObject2.put(com.alipay.sdk.cons.b.f1883h, eVar.B());
            jSONObject2.put("host_pkgname", d.b.h0.a.v1.c.c.e().getPackageName());
            jSONObject2.put("host_key_hash", d.b.h0.a.v1.c.c.g());
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            if (f48052e) {
                e2.printStackTrace();
            }
        }
        hashMap.put("data", jSONObject.toString());
        Request y = y(str3, hashMap);
        if (y == null) {
            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else {
            B(y, str4, callbackHandler);
        }
    }
}
