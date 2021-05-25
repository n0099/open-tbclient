package d.a.l0.a.c2.f.o0;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(e eVar) {
        super(eVar, "/swanAPI/stopPullDownRefresh");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        g W = f.V().W();
        if (W == null) {
            d.b("stopPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(W.m() instanceof d.a.l0.a.h0.g.f)) {
            d.b("stopPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d.a.l0.a.h0.g.f fVar = (d.a.l0.a.h0.g.f) W.m();
            if (fVar.h0() == null) {
                d.b("stopPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            fVar.h0().w(false);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            d.g("stopPullDownRefresh", "refresh complete");
            return true;
        }
    }
}
