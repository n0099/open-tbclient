package d.a.m0.a.o2.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a {
    public b(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/closeTabBar");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.m0.a.e0.d.b("closeTabBar", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (a.k()) {
            d.a.m0.a.e0.d.b("CloseTabBarAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        } else {
            d.a.m0.a.o2.b.a j = a.j();
            if (j == null) {
                d.a.m0.a.e0.d.b("CloseTabBarAction", "tabBarViewController is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!j.j(optParamsAsJo.optBoolean("animation"))) {
                d.a.m0.a.e0.d.b("closeTabBar", "close tab bar fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
