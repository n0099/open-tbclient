package d.b.h0.a.v1.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.v1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0890a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47403f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47404g;

        public C0890a(CallbackHandler callbackHandler, String str, String str2) {
            this.f47402e = callbackHandler;
            this.f47403f = str;
            this.f47404g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            a.this.k(this.f47402e, this.f47403f, this.f47404g, hVar);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/authorize");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
            d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
            d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
            return false;
        }
        String optString2 = optParamsAsJo.optString("scope");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
            d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
            return false;
        }
        eVar.R().c(context, optString2, false, new C0890a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, d.b.h0.a.v1.c.h<b.e> hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", str);
            if (hVar != null && hVar.f47529a != null) {
                if (!hVar.c()) {
                    OAuthException a2 = hVar.a();
                    jSONObject.put("errMsg", a2 == null ? "" : a2.getMessage());
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(hVar.b()).toString());
                    d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
                    return;
                }
                jSONObject.put("code", hVar.f47529a.f47543a);
                jSONObject.put("errMsg", hVar.f47529a.f47544b ? "authorize:ok" : "user deny");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.f47529a.f47544b ? 0 : 10003).toString());
                if (hVar.f47529a.f47544b) {
                    return;
                }
                d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
                return;
            }
            int b2 = hVar.b();
            d.b.h0.a.v1.c.c.j("empty auth result", Boolean.TRUE);
            jSONObject.put("errMsg", d.b.h0.a.v1.c.c.f(b2));
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
            d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
        } catch (JSONException unused) {
            d.b.h0.a.v1.c.c.j("json exception", Boolean.TRUE);
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
            d.b.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
        }
    }
}
