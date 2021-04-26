package d.a.h0.a.t1.k.m0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(j jVar) {
        super(jVar, "/swanAPI/setNavigationBarColor");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            Log.d("BarColorAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.c0.c.b("navigationColor", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (optParamsAsJo == null) {
            d.a.h0.a.c0.c.b("navigationColor", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            String optString = optParamsAsJo.optString("frontColor");
            String optString2 = optParamsAsJo.optString("backgroundColor");
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("animation");
            d.a.h0.a.e0.l.c m = W.m();
            if (m == null) {
                d.a.h0.a.c0.c.b("navigationColor", "slave container exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!m.p2(optString, true)) {
                d.a.h0.a.c0.c.b("navigationColor", "set title color fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!m.g2(SwanAppConfigData.s(optString2), true)) {
                d.a.h0.a.c0.c.b("navigationColor", "set title background fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject != null) {
                    m.e2(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                    d.a.h0.a.c0.c.g("navigationColor", "set action bar animator");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
