package d.a.h0.a.v1.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.v1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0829a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44819f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44820g;

        public C0829a(CallbackHandler callbackHandler, String str, String str2) {
            this.f44818e = callbackHandler;
            this.f44819f = str;
            this.f44820g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            a.this.k(this.f44818e, this.f44819f, this.f44820g, hVar);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/authorize");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
            d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
            d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
            return false;
        }
        String optString2 = optParamsAsJo.optString("scope");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
            d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
            return false;
        }
        eVar.R().c(context, optString2, false, new C0829a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0097, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, d.a.h0.a.v1.c.h<b.e> hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", str);
            if (hVar != null && hVar.f44952a != null) {
                if (!hVar.c()) {
                    OAuthException a2 = hVar.a();
                    jSONObject.put("errMsg", a2 == null ? "" : a2.getMessage());
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(hVar.b()).toString());
                    d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
                    return;
                }
                jSONObject.put("code", hVar.f44952a.f44966a);
                jSONObject.put("errMsg", hVar.f44952a.f44967b ? "authorize:ok" : "user deny");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.f44952a.f44967b ? 0 : 10003).toString());
                if (hVar.f44952a.f44967b) {
                    return;
                }
                d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
                return;
            }
            int b2 = hVar.b();
            d.a.h0.a.v1.c.c.j("empty auth result", Boolean.TRUE);
            jSONObject.put("errMsg", d.a.h0.a.v1.c.c.f(b2));
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
            d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
        } catch (JSONException unused) {
            d.a.h0.a.v1.c.c.j("json exception", Boolean.TRUE);
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
            d.a.h0.g.c0.c.a(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
        }
    }
}
