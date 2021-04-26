package d.a.h0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 {
    public g(j jVar) {
        super(jVar, "/swanAPI/login");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f44398b) {
                Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            d.a.h0.g.c0.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                d.a.h0.g.c0.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                d.a.h0.a.t.c.a.b.x(eVar, 1, 201, "params is null");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                d.a.h0.g.c0.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                d.a.h0.a.t.c.a.b.x(eVar, 1, 201, "empty cb");
                return false;
            } else if (!optParamsAsJo.optBoolean("force", true) && !eVar.i().e(context)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                d.a.h0.g.c0.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                d.a.h0.a.t.c.a.b.x(eVar, 43, 10004, "user not logged in");
                return true;
            } else {
                d.a.h0.a.t.c.a.b.s(eVar, (Activity) context, optParamsAsJo, callbackHandler, optString);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
