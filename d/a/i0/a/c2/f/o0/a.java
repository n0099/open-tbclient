package d.a.i0.a.c2.f.o0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.g.g;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/startPullDownRefresh");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar != null) {
            eVar.B().e(eVar.getAppId());
        }
        if (eVar != null && eVar.d0()) {
            if (a0.f40775b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        g W = f.V().W();
        if (W == null) {
            d.b("startPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(W.m() instanceof d.a.i0.a.h0.g.f)) {
            d.b("startPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) W.m();
            if (fVar.h0() == null) {
                d.b("startPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.g("startPullDownRefresh", "start pull refresh");
            fVar.h0().k(true, 100L);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
