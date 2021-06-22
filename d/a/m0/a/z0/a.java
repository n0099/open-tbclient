package d.a.m0.a.z0;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.g1.f;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/closeInput");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        SwanEditText c2 = b.d().c();
        if (c2 == null) {
            d.a.m0.a.e0.d.b("closeInput", "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        } else if (f.V().W() == null) {
            d.a.m0.a.e0.d.b("closeInput", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            c2.clearFocus();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
