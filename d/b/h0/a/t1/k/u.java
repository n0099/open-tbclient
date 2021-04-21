package d.b.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class u extends a0 {
    public u(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/postMessage");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.j1.h.a("postMessage", "PostMsgAction handle");
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.b.h0.a.k0.b.d a2 = d.b.h0.a.k0.b.d.a(str);
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        d.b.h0.a.j1.h.a("postMessage", "PostEvent start");
        d.b.h0.a.z0.f.V().e(a2, true);
        d.b.h0.a.j1.h.a("postMessage", "PostEvent end.");
        return true;
    }
}
