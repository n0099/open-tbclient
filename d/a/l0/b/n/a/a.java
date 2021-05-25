package d.a.l0.b.n.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.l0.a.k;
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
public class a extends d.a.l0.a.n1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46293e = k.f43199a;

    /* renamed from: d.a.l0.b.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0947a implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46295f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46296g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46297h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46298i;

        public C0947a(String str, String str2, String str3, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
            this.f46294e = str;
            this.f46295f = str2;
            this.f46296g = str3;
            this.f46297h = callbackHandler;
            this.f46298i = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            if (bundle != null && !TextUtils.isEmpty(bundle.getString(BdZeusUtil.URL_KEY_MACHINE))) {
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE);
                if (a.f46293e) {
                    Log.d("FaceResultVerifyAction", "stoken=" + string);
                }
                a.this.z(this.f46294e, string, this.f46295f, this.f46296g, this.f46297h, this.f46298i);
                return;
            }
            this.f46297h.handleSchemeDispatchCallback(this.f46296g, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46299a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46300b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Request f46301c;

        public b(String str, CallbackHandler callbackHandler, Request request) {
            this.f46299a = str;
            this.f46300b = callbackHandler;
            this.f46301c = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.this.A(exc == null ? "" : exc.getMessage(), this.f46299a, this.f46300b);
            d.a.l0.a.j2.q.a.b(SwanInterfaceType.FACE_CHECK, 2101, this.f46301c.url().toString(), null, exc != null ? exc.getMessage() : "");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.D(response, this.f46299a, this.f46300b);
            return response;
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/faceResultVerify");
    }

    public final void A(String str, String str2, CallbackHandler callbackHandler) {
        d.a.l0.a.e0.d.g("FaceResultVerifyAction", str);
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
    }

    public final void B(String str, String str2, CallbackHandler callbackHandler, int i2, String str3, Response response) {
        A(str, str2, callbackHandler);
        d.a.l0.a.j2.q.a.c(SwanInterfaceType.FACE_CHECK, i2, str3, response);
    }

    public final void C(@NonNull Request request, String str, CallbackHandler callbackHandler) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(request.url().toString(), request.body(), new b(str, callbackHandler, request));
        aVar.f47977i = request.tag();
        aVar.f47974f = true;
        aVar.f47975g = true;
        aVar.f47976h = true;
        d.a.l0.m.e.a.g().e(aVar);
        d.a.l0.a.j2.q.a.a(SwanInterfaceType.FACE_CHECK);
    }

    public final void D(Response response, String str, CallbackHandler callbackHandler) {
        if (response == null) {
            B("response is null", str, callbackHandler, 2103, null, null);
        } else if (!response.isSuccessful()) {
            B("response code is error", str, callbackHandler, 2104, null, response);
        } else {
            ResponseBody body = response.body();
            if (body == null) {
                B("body is null", str, callbackHandler, 2103, null, response);
                return;
            }
            String str2 = null;
            try {
                str2 = body.string();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            String str3 = str2;
            if (f46293e) {
                Log.d("FaceResultVerifyAction", "response body : " + str3);
            }
            if (TextUtils.isEmpty(str3)) {
                B("body is null", str, callbackHandler, 2103, str3, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                int optInt = jSONObject.optInt("errno");
                if (optInt != 0) {
                    B(jSONObject.optString("errmsg"), str, callbackHandler, optInt, str3, response);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    A("server data is null", str, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0).toString());
                }
            } catch (JSONException e3) {
                if (f46293e) {
                    e3.printStackTrace();
                }
                B("body format error", str, callbackHandler, 2103, str3, response);
            }
        }
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
        } else if (!eVar.j().e(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            return false;
        } else {
            String a2 = d.a.l0.a.u.e.j.h.a(eVar.f40749f);
            JSONObject n = n(a2);
            d.a.l0.b.j.a.t(eVar.x(), new C0947a(optString2, a2, optString, callbackHandler, eVar), BdZeusUtil.URL_KEY_MACHINE);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
            return true;
        }
    }

    @Nullable
    public final Request y(@Nullable String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(d.a.l0.a.d0.c.f41309a);
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/facecheck");
        for (Map.Entry<String, String> entry : d.a.l0.a.d0.b.b().f41308d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        Request.Builder builder = new Request.Builder();
        builder.tag(str);
        if (map != null) {
            builder.post(d.a.l0.a.e2.c.d.b(map));
        }
        builder.url(d.a.l0.a.d0.c.v(build.toString()));
        return builder.build();
    }

    public final void z(String str, String str2, String str3, String str4, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("callbackkey", str);
            jSONObject.put("client_id", eVar.f40749f);
            jSONObject2.put("stoken", str2);
            jSONObject2.put("app_key", eVar.D());
            jSONObject2.put("host_pkgname", d.a.l0.a.e2.c.d.e().getPackageName());
            jSONObject2.put("host_key_hash", d.a.l0.a.e2.c.d.g());
            jSONObject.put("open", jSONObject2);
        } catch (JSONException e2) {
            if (f46293e) {
                e2.printStackTrace();
            }
        }
        hashMap.put("data", jSONObject.toString());
        Request y = y(str3, hashMap);
        if (y == null) {
            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
        } else {
            C(y, str4, callbackHandler);
        }
    }
}
