package d.a.l0.a.z0;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {
    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/updateInput");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.b("updateInput", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.l0.a.e0.d.b("updateInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.l0.a.c0.c.f.b bVar = new d.a.l0.a.c0.c.f.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.a.l0.a.e0.d.c("SwanAppAction", "model parse exception:", e2);
        }
        d.a.l0.a.c0.c.f.a aVar = (d.a.l0.a.c0.c.f.a) d.a.l0.a.c0.d.a.a(bVar);
        if (aVar == null) {
            d.a.l0.a.e0.d.b("updateInput", "input组件不存在");
            d.a.l0.a.e0.d.b("SwanAppAction", "can't find input component:#" + bVar.f40845f);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        boolean a2 = aVar.G(bVar).a();
        if (a2) {
            d.a.l0.a.e0.d.g("updateInput", "update success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return a2;
    }
}
