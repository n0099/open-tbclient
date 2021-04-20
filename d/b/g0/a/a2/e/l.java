package d.b.g0.a.a2.e;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class l extends a0 {
    public l(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/setStorage");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String y = d.b.g0.a.t.c.k.a.y(optParamsAsJo);
        if (y == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (d.b.g0.a.a2.c.b(y)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exceed storage key max length");
            return false;
        } else {
            String x = d.b.g0.a.t.c.k.a.x(optParamsAsJo);
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (d.b.g0.a.a2.c.c(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exceed storage item max length");
                return false;
            } else {
                d.b.g0.a.a2.c S = eVar.S();
                if (S.m(y, x)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1003, "exceed storage max length");
                    return false;
                }
                S.g().putString(y, x);
                d.b.g0.a.f2.d.f44859h.b();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
