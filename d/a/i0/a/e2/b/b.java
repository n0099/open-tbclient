package d.a.i0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41421f;

        public a(b bVar, CallbackHandler callbackHandler, String str) {
            this.f41420e = callbackHandler;
            this.f41421f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<JSONObject> iVar) {
            JSONObject wrapCallbackParams;
            if (iVar.c() && d.a.i0.a.u.e.a.b.s(iVar.f41562a)) {
                JSONObject optJSONObject = iVar.f41562a.optJSONObject("data");
                if (optJSONObject.optBoolean("result")) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                }
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(iVar.b());
                d.a.i0.a.c1.b.j().g(this.f41420e, wrapCallbackParams.toString());
            }
            this.f41420e.handleSchemeDispatchCallback(this.f41421f, wrapCallbackParams.toString());
        }
    }

    public b(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/checkSession");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            d.a.i0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        String D = eVar.D();
        if (TextUtils.isEmpty(D)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key");
            d.a.i0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            d.a.i0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            d.a.i0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        } else if (!eVar.j().e(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
            d.a.i0.a.c1.b.j().g(callbackHandler, unitedSchemeEntity.result.toString());
            return true;
        } else {
            d.a.i0.a.e2.c.j.c g2 = d.a.i0.a.a2.d.g().y().a().b().g((Activity) context, D);
            g2.r("checkSession");
            g2.p(new a(this, callbackHandler, optString));
            g2.a();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
