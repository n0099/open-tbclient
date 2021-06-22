package d.a.m0.a.o2.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/closeTabBarBadge");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.m0.a.e0.d.b("closeTabBarBadge", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int optInt = optParamsAsJo.optInt("index");
        if (a.k()) {
            d.a.m0.a.e0.d.b("CloseTabBarBadgeAction", "fail not TabBar page");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        }
        d.a.m0.a.o2.b.a j = a.j();
        if (j == null) {
            d.a.m0.a.e0.d.b("CloseTabBarBadgeAction", "tabBarViewController is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!j.i(optInt)) {
            d.a.m0.a.e0.d.b("closeTabBarBadge", "close bottom badge fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
