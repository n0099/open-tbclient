package d.a.h0.a.x.b;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.k;
import d.a.h0.a.t1.j;
/* loaded from: classes2.dex */
public class c extends a {
    public c(j jVar) {
        super(jVar, "/swanAPI/camera/remove");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.a.a0.c.c.a aVar = (d.a.h0.a.a0.c.c.a) d.a.h0.a.a0.d.a.a(m(unitedSchemeEntity));
        if (aVar != null) {
            d.a.h0.a.a0.b.c C = aVar.C();
            if (!C.a()) {
                d.a.h0.a.c0.c.b("CameraRemoveAction", "remove camera fail: " + C.f41097b);
            }
            k(unitedSchemeEntity, callbackHandler, true);
            return true;
        }
        k(unitedSchemeEntity, callbackHandler, false);
        return false;
    }

    public d.a.h0.a.a0.b.b m(UnitedSchemeEntity unitedSchemeEntity) {
        String l = l(unitedSchemeEntity);
        if (k.f43101a) {
            Log.d("CameraRemoveAction", "parseData:" + l);
        }
        return new d.a.h0.a.x.e.a(l);
    }
}
