package d.b.g0.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.t1.j;
/* loaded from: classes2.dex */
public class d extends a {
    public d(j jVar) {
        super(jVar, "/swanAPI/canvas/insert");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.y.b.a k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = l(201);
            d.b.g0.a.c0.c.b("SwanAppCanvas", "insert action parse model is null");
            return false;
        } else if (context == null) {
            d.b.g0.a.c0.c.b("SwanAppCanvas", "context is null");
            unitedSchemeEntity.result = l(1001);
            return false;
        } else {
            String str = k.f43113f;
            d.b.g0.a.e1.d.a.a aVar = k.l;
            if (!TextUtils.isEmpty(str) && aVar != null && aVar.i()) {
                d.b.g0.a.a0.b.c w = new d.b.g0.a.a0.c.d.a(context, k).w();
                boolean a2 = w.a();
                if (!a2) {
                    d.b.g0.a.c0.c.b("SwanAppCanvas", "insert canvas fail: " + w.f43117b);
                }
                j(unitedSchemeEntity, callbackHandler, a2);
                return a2;
            }
            d.b.g0.a.c0.c.b("SwanAppCanvas", "canvas id is empty or position is null");
            unitedSchemeEntity.result = l(202);
            return false;
        }
    }
}
