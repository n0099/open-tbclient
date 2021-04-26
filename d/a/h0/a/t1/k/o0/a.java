package d.a.h0.a.t1.k.o0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c0.c;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/startPullDownRefresh");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            c.b("startPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(W.m() instanceof d.a.h0.a.e0.l.e)) {
            c.b("startPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d.a.h0.a.e0.l.e eVar2 = (d.a.h0.a.e0.l.e) W.m();
            if (eVar2.f0() == null) {
                c.b("startPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.g("startPullDownRefresh", "start pull refresh");
            eVar2.f0().k(true, 100L);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
