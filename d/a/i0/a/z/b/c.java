package d.a.i0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class c extends a {
    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/remove");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.i0.a.c0.c.c.a aVar = (d.a.i0.a.c0.c.c.a) d.a.i0.a.c0.d.a.a(m(unitedSchemeEntity));
        if (aVar != null) {
            d.a.i0.a.c0.b.c C = aVar.C();
            if (!C.a()) {
                d.a.i0.a.e0.d.b("CameraRemoveAction", "remove camera fail: " + C.f40676b);
            }
            k(unitedSchemeEntity, callbackHandler, true);
            return true;
        }
        k(unitedSchemeEntity, callbackHandler, false);
        return false;
    }

    public d.a.i0.a.c0.b.b m(UnitedSchemeEntity unitedSchemeEntity) {
        String l = l(unitedSchemeEntity);
        if (k.f43025a) {
            Log.d("CameraRemoveAction", "parseData:" + l);
        }
        return new d.a.i0.a.z.e.a(l);
    }
}
