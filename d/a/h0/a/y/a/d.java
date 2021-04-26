package d.a.h0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.t1.j;
/* loaded from: classes2.dex */
public class d extends a {
    public d(j jVar) {
        super(jVar, "/swanAPI/canvas/insert");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.y.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.a.h0.a.c0.c.b("SwanAppCanvas", "insert action parse model is null");
            return false;
        } else if (context == null) {
            d.a.h0.a.c0.c.b("SwanAppCanvas", "context is null");
            unitedSchemeEntity.result = l(1001);
            return false;
        } else {
            String str = k.f41092f;
            d.a.h0.a.e1.d.a.a aVar = k.l;
            if (!TextUtils.isEmpty(str) && aVar != null && aVar.i()) {
                d.a.h0.a.a0.b.c w = new d.a.h0.a.a0.c.d.a(context, k).w();
                boolean a2 = w.a();
                if (!a2) {
                    d.a.h0.a.c0.c.b("SwanAppCanvas", "insert canvas fail: " + w.f41097b);
                }
                j(unitedSchemeEntity, callbackHandler, a2);
                return a2;
            }
            d.a.h0.a.c0.c.b("SwanAppCanvas", "canvas id is empty or position is null");
            unitedSchemeEntity.result = l(202);
            return false;
        }
    }
}
