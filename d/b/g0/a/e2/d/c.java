package d.b.g0.a.e2.d;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {
    public c(j jVar) {
        super(jVar, "/swanAPI/updateTextarea");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f46287b) {
            Log.d("UpdateTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.g0.a.c0.c.g("UpdateTextAreaAction", "UpdateTextAreaAction updateParams: " + optParamsAsJo);
        String optString = optParamsAsJo.optString("slaveId");
        String optString2 = optParamsAsJo.optString("inputId");
        d.b.g0.a.a0.c.g.a aVar = (d.b.g0.a.a0.c.g.a) d.b.g0.a.a0.d.a.b(optString, optString2);
        if (aVar == null) {
            String str = "can't find textarea component:#" + optString2;
            d.b.g0.a.c0.c.b("UpdateTextAreaAction", str);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
            return false;
        }
        d.b.g0.a.a0.c.g.b bVar = (d.b.g0.a.a0.c.g.b) aVar.l();
        bVar.g(optParamsAsJo);
        d.b.g0.a.a0.b.c G = aVar.G(bVar);
        if (!G.a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f43116b);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        aVar.U0(optString2);
        return true;
    }
}
