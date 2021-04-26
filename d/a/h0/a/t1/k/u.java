package d.a.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class u extends a0 {
    public u(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/postMessage");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.j1.h.a("postMessage", "PostMsgAction handle");
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.h0.a.k0.b.d a2 = d.a.h0.a.k0.b.d.a(str);
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        d.a.h0.a.j1.h.a("postMessage", "PostEvent start");
        d.a.h0.a.z0.f.V().z(a2, true);
        d.a.h0.a.j1.h.a("postMessage", "PostEvent end.");
        return true;
    }
}
