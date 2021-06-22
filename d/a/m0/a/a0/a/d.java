package d.a.m0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes2.dex */
public class d extends a {
    public d(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/insert");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.a0.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.a.m0.a.e0.d.b("SwanAppCanvas", "insert action parse model is null");
            return false;
        } else if (context == null) {
            d.a.m0.a.e0.d.b("SwanAppCanvas", "context is null");
            unitedSchemeEntity.result = l(1001);
            return false;
        } else {
            String str = k.f44629f;
            d.a.m0.a.l1.e.a.a aVar = k.l;
            if (!TextUtils.isEmpty(str) && aVar != null && aVar.i()) {
                d.a.m0.a.c0.b.c w = new d.a.m0.a.c0.c.d.a(context, k).w();
                boolean a2 = w.a();
                if (!a2) {
                    d.a.m0.a.e0.d.b("SwanAppCanvas", "insert canvas fail: " + w.f44634b);
                }
                j(unitedSchemeEntity, callbackHandler, a2);
                return a2;
            }
            d.a.m0.a.e0.d.b("SwanAppCanvas", "canvas id is empty or position is null");
            unitedSchemeEntity.result = l(202);
            return false;
        }
    }
}
