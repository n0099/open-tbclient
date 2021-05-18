package d.a.i0.a.c2.f.i0.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.res.ui.FloatButton;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/hideOpenAppGuide");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.i("HideFloatButtonGuide", unitedSchemeEntity.toString());
        }
        d.a.i0.a.c2.f.i0.a d2 = d.a.i0.a.c2.f.i0.a.d();
        FloatButton c2 = d2.c();
        if (c2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
        c2.setVisibility(8);
        d2.j(null);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
