package d.b.h0.a.t1.k.m0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(j jVar) {
        super(jVar, "/swanAPI/showNavigationBarLoading");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f47009b) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar != null && eVar.Z()) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.c0.c.b("navigationLoading", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.h0.a.e0.l.c m = W.m();
        if (m == null) {
            d.b.h0.a.c0.c.b("navigationLoading", "swanAppFragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!m.y2()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("navigationLoading", "show navigation loading progressbar fail");
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
