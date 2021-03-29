package d.b.g0.a.t1.k.i0.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.res.ui.FloatButton;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
/* loaded from: classes2.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideOpenAppGuide");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f46288b) {
            Log.i("HideFloatButtonGuide", unitedSchemeEntity.toString());
        }
        d.b.g0.a.t1.k.i0.a d2 = d.b.g0.a.t1.k.i0.a.d();
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
