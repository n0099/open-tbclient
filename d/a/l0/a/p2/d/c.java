package d.a.l0.a.p2.d;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {
    public c(e eVar) {
        super(eVar, "/swanAPI/updateTextarea");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("UpdateTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.g("UpdateTextAreaAction", "UpdateTextAreaAction updateParams: " + optParamsAsJo);
        String optString = optParamsAsJo.optString("slaveId");
        String optString2 = optParamsAsJo.optString("inputId");
        d.a.l0.a.c0.c.g.a aVar = (d.a.l0.a.c0.c.g.a) d.a.l0.a.c0.d.a.b(optString, optString2);
        if (aVar == null) {
            String str = "can't find textarea component:#" + optString2;
            d.b("UpdateTextAreaAction", str);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
            return false;
        }
        d.a.l0.a.c0.c.g.b bVar = (d.a.l0.a.c0.c.g.b) aVar.l();
        bVar.g(optParamsAsJo);
        d.a.l0.a.c0.b.c G = aVar.G(bVar);
        if (!G.a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f44526b);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        aVar.S0(optString2);
        return true;
    }
}
