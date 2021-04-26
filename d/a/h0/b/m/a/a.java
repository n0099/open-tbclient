package d.a.h0.b.m.a;

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
import d.a.h0.a.k;
import d.a.h0.a.t1.j;
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
public class a extends d.a.h0.a.g1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45492e = k.f43101a;

    /* renamed from: d.a.h0.b.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0875a implements d.a.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45493e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45494f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45495g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45496h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45497i;

        public C0875a(String str, String str2, String str3, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
            this.f45493e = str;
            this.f45494f = str2;
            this.f45495g = str3;
            this.f45496h = callbackHandler;
            this.f45497i = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            if (bundle != null && !TextUtils.isEmpty(bundle.getString(BdZeusUtil.URL_KEY_MACHINE))) {
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE);
                if (a.f45492e) {
                    Log.d("FaceResultVerifyAction", "stoken=" + string);
                }
                a.this.z(this.f45493e, string, this.f45494f, this.f45495g, this.f45496h, this.f45497i);
                return;
            }
            this.f45496h.handleSchemeDispatchCallback(this.f45495g, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45499b;

        public b(String str, CallbackHandler callbackHandler) {
            this.f45498a = str;
            this.f45499b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.A(exc == null ? "" : exc.getMessage(), this.f45498a, this.f45499b);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.C(response, this.f45498a, this.f45499b);
            return response;
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/faceResultVerify");
    }

    public final void A(String str, String str2, CallbackHandler callbackHandler) {
        d.a.h0.a.c0.c.g("FaceResultVerifyAction", str);
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
    }

    public final void B(Request request, String str, CallbackHandler callbackHandler) {
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a(request.url().toString(), request.body(), new b(str, callbackHandler));
        aVar.f47114i = request.tag();
        aVar.f47111f = true;
        aVar.f47112g = true;
        aVar.f47113h = true;
        d.a.h0.k.e.a.f().e(aVar);
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
            if (f45492e) {
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
                if (f45492e) {
                    e3.printStackTrace();
                }
                A("body format error", str, callbackHandler);
            }
        }
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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
        } else if (!eVar.i().e(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            return false;
        } else {
            String a2 = d.a.h0.a.t.c.h.c.a(eVar.f43823f);
            JSONObject n = n(a2);
            d.a.h0.b.i.a.t(eVar.v(), new C0875a(optString2, a2, optString, callbackHandler, eVar), BdZeusUtil.URL_KEY_MACHINE);
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
        for (Map.Entry<String, String> entry : d.a.h0.a.b0.b.b().f41266d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        if (map != null) {
            builder.post(d.a.h0.a.v1.c.c.b(map));
        }
        builder.url(d.a.h0.a.b0.c.u(build.toString()));
        return builder.build();
    }

    public final void z(String str, String str2, String str3, String str4, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("callbackkey", str);
            jSONObject.put("client_id", eVar.f43823f);
            jSONObject2.put("stoken", str2);
            jSONObject2.put(com.alipay.sdk.cons.b.f1831h, eVar.B());
            jSONObject2.put("host_pkgname", d.a.h0.a.v1.c.c.e().getPackageName());
            jSONObject2.put("host_key_hash", d.a.h0.a.v1.c.c.g());
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            if (f45492e) {
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
