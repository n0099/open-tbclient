package d.b.g0.a.t0;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a0 {
    public e(j jVar) {
        super(jVar, "/swanAPI/updateInput");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("updateInput", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.g0.a.c0.c.b("updateInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.a0.c.f.b bVar = new d.b.g0.a.a0.c.f.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.b.g0.a.c0.c.c("SwanAppAction", "model parse exception:", e2);
        }
        d.b.g0.a.a0.c.f.a aVar = (d.b.g0.a.a0.c.f.a) d.b.g0.a.a0.d.a.a(bVar);
        if (aVar == null) {
            d.b.g0.a.c0.c.b("updateInput", "input组件不存在");
            d.b.g0.a.c0.c.b("SwanAppAction", "can't find input component:#" + bVar.f43113f);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        boolean a2 = aVar.G(bVar).a();
        if (a2) {
            d.b.g0.a.c0.c.g("updateInput", "update success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return a2;
    }
}
