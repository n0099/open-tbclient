package d.b.g0.a.d2.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a {
    public i(j jVar) {
        super(jVar, "/swanAPI/setTabBarStyle");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("SetTabBarStyleAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (a.k()) {
            d.b.g0.a.c0.c.b("SetTabBarStyleAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        }
        d.b.g0.a.d2.b.a j = a.j();
        if (j == null) {
            d.b.g0.a.c0.c.b("setTabBarStyle", "tabBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.g0.a.c0.c.b("setTabBarStyle", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!j.h(optParamsAsJo.optString("color"), optParamsAsJo.optString("selectedColor"), optParamsAsJo.optString("backgroundColor"), optParamsAsJo.optString("borderStyle"))) {
            d.b.g0.a.c0.c.b("setTabBarStyle", "set bottom bar style fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
