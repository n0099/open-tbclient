package d.a.m0.a.k2.e;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class m extends a0 {
    public m(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/setStorageSync");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String C = d.a.m0.a.u.e.m.a.C(optParamsAsJo);
        if (C == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (d.a.m0.a.k2.c.b(C)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exceed storage key max length");
            return false;
        } else {
            String B = d.a.m0.a.u.e.m.a.B(optParamsAsJo);
            if (B == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (d.a.m0.a.k2.c.c(B)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exceed storage item max length");
                return false;
            } else {
                d.a.m0.a.k2.c U = eVar.U();
                if (U.m(C, B)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1003, "exceed storage max length");
                    return false;
                }
                U.g().putString(C, B);
                d.a.m0.a.q2.d.f48017h.b();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
    }
}
