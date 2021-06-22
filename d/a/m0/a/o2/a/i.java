package d.a.m0.a.o2.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a {
    public i(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/setTabBarStyle");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("SetTabBarStyleAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (a.k()) {
            d.a.m0.a.e0.d.b("SetTabBarStyleAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        }
        d.a.m0.a.o2.b.a j = a.j();
        if (j == null) {
            d.a.m0.a.e0.d.b("setTabBarStyle", "tabBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.m0.a.e0.d.b("setTabBarStyle", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!j.h(optParamsAsJo.optString("color"), optParamsAsJo.optString("selectedColor"), optParamsAsJo.optString("backgroundColor"), optParamsAsJo.optString("borderStyle"))) {
            d.a.m0.a.e0.d.b("setTabBarStyle", "set bottom bar style fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
