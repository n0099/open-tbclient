package d.a.l0.a.a0.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public class g extends a {
    public g(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/remove");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.a0.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.a.l0.a.e0.d.b("SwanAppCanvas", "remove action parse model is null");
            return false;
        }
        d.a.l0.a.c0.c.d.a aVar = (d.a.l0.a.c0.c.d.a) d.a.l0.a.c0.d.a.a(k);
        if (aVar == null) {
            d.a.l0.a.e0.d.b("SwanAppCanvas", "remove canvas fail: fina a null component");
            unitedSchemeEntity.result = l(1001);
            return false;
        }
        d.a.l0.a.c0.b.c C = aVar.C();
        boolean a2 = C.a();
        if (!a2) {
            d.a.l0.a.e0.d.b("SwanAppCanvas", "remove canvas fail: " + C.f44526b);
        }
        j(unitedSchemeEntity, callbackHandler, a2);
        return a2;
    }
}
