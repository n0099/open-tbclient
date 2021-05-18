package d.a.i0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 {
    public g(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/login");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar != null && eVar.d0()) {
            if (a0.f40775b) {
                Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            d.a.i0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                d.a.i0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                d.a.i0.a.u.e.a.c.B(eVar, 1, 201, "params is null");
                return false;
            }
            String optString = optParamsAsJo.optString("invokeFrom");
            String str = optString.equals("component") ? "loginButton" : "loginApi";
            k.N(str, "create");
            String optString2 = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                d.a.i0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                d.a.i0.a.u.e.a.c.B(eVar, 1, 201, "empty cb");
                return false;
            } else if (!optParamsAsJo.optBoolean("force", true) && !eVar.j().e(context)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                d.a.i0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                d.a.i0.a.u.e.a.c.B(eVar, 43, 10004, "user not logged in");
                return true;
            } else {
                if (!eVar.j().e(context)) {
                    k.M("show", 1, optString);
                }
                if (!d.a.i0.a.a2.d.g().r().j().e(context)) {
                    k.N(str, "passLogin");
                }
                d.a.i0.a.u.e.a.c.v(eVar, (Activity) context, optParamsAsJo, callbackHandler, optString2, true, str);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
