package d.b.g0.a.y.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.t1.j;
/* loaded from: classes3.dex */
public class g extends a {
    public g(j jVar) {
        super(jVar, "/swanAPI/canvas/remove");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.y.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.b.g0.a.c0.c.b("SwanAppCanvas", "remove action parse model is null");
            return false;
        }
        d.b.g0.a.a0.c.d.a aVar = (d.b.g0.a.a0.c.d.a) d.b.g0.a.a0.d.a.a(k);
        if (aVar == null) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "remove canvas fail: fina a null component");
            unitedSchemeEntity.result = l(1001);
            return false;
        }
        d.b.g0.a.a0.b.c C = aVar.C();
        boolean a2 = C.a();
        if (!a2) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "remove canvas fail: " + C.f43116b);
        }
        j(unitedSchemeEntity, callbackHandler, a2);
        return a2;
    }
}
