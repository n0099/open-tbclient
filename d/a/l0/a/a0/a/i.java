package d.a.l0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public class i extends a {
    public i(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/update");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.a0.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.a.l0.a.e0.d.b("SwanAppCanvas", "update action parse model is null");
            return false;
        }
        String str = k.f44521f;
        d.a.l0.a.l1.e.a.a aVar = k.l;
        if (!TextUtils.isEmpty(str) && aVar != null && aVar.i()) {
            d.a.l0.a.c0.c.d.a aVar2 = (d.a.l0.a.c0.c.d.a) d.a.l0.a.c0.d.a.a(k);
            if (aVar2 == null) {
                d.a.l0.a.e0.d.b("SwanAppCanvas", "update canvas fail: fina a null component");
                unitedSchemeEntity.result = l(1001);
                return false;
            }
            d.a.l0.a.c0.b.c G = aVar2.G(k);
            boolean a2 = G.a();
            if (!a2) {
                d.a.l0.a.e0.d.b("SwanAppCanvas", "update canvas fail: " + G.f44526b);
            }
            j(unitedSchemeEntity, callbackHandler, a2);
            return a2;
        }
        d.a.l0.a.e0.d.b("SwanAppCanvas", "some params invalid");
        unitedSchemeEntity.result = l(202);
        return false;
    }
}
