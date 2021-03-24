package d.b.g0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.t1.j;
/* loaded from: classes3.dex */
public class i extends a {
    public i(j jVar) {
        super(jVar, "/swanAPI/canvas/update");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.y.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.b.g0.a.c0.c.b("SwanAppCanvas", "update action parse model is null");
            return false;
        }
        String str = k.f43112f;
        d.b.g0.a.e1.d.a.a aVar = k.l;
        if (!TextUtils.isEmpty(str) && aVar != null && aVar.i()) {
            d.b.g0.a.a0.c.d.a aVar2 = (d.b.g0.a.a0.c.d.a) d.b.g0.a.a0.d.a.a(k);
            if (aVar2 == null) {
                d.b.g0.a.c0.c.b("SwanAppCanvas", "update canvas fail: fina a null component");
                unitedSchemeEntity.result = l(1001);
                return false;
            }
            d.b.g0.a.a0.b.c G = aVar2.G(k);
            boolean a2 = G.a();
            if (!a2) {
                d.b.g0.a.c0.c.b("SwanAppCanvas", "update canvas fail: " + G.f43116b);
            }
            j(unitedSchemeEntity, callbackHandler, a2);
            return a2;
        }
        d.b.g0.a.c0.c.b("SwanAppCanvas", "some params invalid");
        unitedSchemeEntity.result = l(202);
        return false;
    }
}
