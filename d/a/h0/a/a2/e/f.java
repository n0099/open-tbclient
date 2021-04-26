package d.a.h0.a.a2.e;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class f extends a0 {
    public f(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getStorage");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("SwanAppAction", "start get storage");
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String y = d.a.h0.a.t.c.k.a.y(optParamsAsJo);
        if (y == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String string = eVar.S().g().getString(y, null);
        if (string == null && d.a.h0.a.a2.c.f41212f) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "data not found");
            return false;
        }
        JSONObject w = d.a.h0.a.t.c.k.a.w(string);
        if (w == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "JSONException");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(w, 0));
        return true;
    }
}
