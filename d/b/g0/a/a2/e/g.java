package d.b.g0.a.a2.e;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class g extends a0 {
    public g(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getStorageSync");
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
        }
        String string = eVar.S().g().getString(y, null);
        if (string == null && d.b.g0.a.a2.c.f43614f) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "data not found");
            return false;
        }
        JSONObject w = d.b.g0.a.t.c.k.a.w(string);
        if (w == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "JSONException");
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(w, 0);
        return true;
    }
}
