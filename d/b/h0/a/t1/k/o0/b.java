package d.b.h0.a.t1.k.o0;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.c0.c;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(j jVar) {
        super(jVar, "/swanAPI/stopPullDownRefresh");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            c.b("stopPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(W.m() instanceof d.b.h0.a.e0.l.e)) {
            c.b("stopPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d.b.h0.a.e0.l.e eVar2 = (d.b.h0.a.e0.l.e) W.m();
            if (eVar2.b0() == null) {
                c.b("stopPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar2.b0().w(false);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            c.g("stopPullDownRefresh", "refresh complete");
            return true;
        }
    }
}
