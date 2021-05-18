package d.a.i0.a.e2.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.i0.a.e2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0603a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41418g;

        public C0603a(CallbackHandler callbackHandler, String str, String str2) {
            this.f41416e = callbackHandler;
            this.f41417f = str;
            this.f41418g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            a.this.k(this.f41416e, this.f41417f, this.f41418g, iVar);
        }
    }

    static {
        boolean z = k.f43025a;
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/authorize");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
            d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
            d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
            return false;
        }
        String optString2 = optParamsAsJo.optString("scope");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
            d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
            return false;
        }
        eVar.T().c(context, optString2, false, new C0603a(callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, d.a.i0.a.e2.c.i<b.e> iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", str);
            if (iVar != null && iVar.f41562a != null) {
                if (!iVar.c()) {
                    OAuthException a2 = iVar.a();
                    jSONObject.put("errMsg", a2 == null ? "" : a2.getMessage());
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(iVar.b()).toString());
                    d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                    return;
                }
                jSONObject.put("code", iVar.f41562a.f41576a);
                jSONObject.put("errMsg", iVar.f41562a.f41577b ? "authorize:ok" : "user deny");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.f41562a.f41577b ? 0 : 10003).toString());
                if (iVar.f41562a.f41577b) {
                    return;
                }
                d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                return;
            }
            int b2 = iVar.b();
            d.a.i0.a.e2.c.d.j("empty auth result", Boolean.TRUE);
            jSONObject.put("errMsg", d.a.i0.a.e2.c.d.f(b2));
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
            d.a.i0.a.e2.c.d.s("AuthorizeAction", "null == result || null == result.mData");
            d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
        } catch (JSONException unused) {
            d.a.i0.a.e2.c.d.j("json exception", Boolean.TRUE);
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
            d.a.i0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
        }
    }
}
