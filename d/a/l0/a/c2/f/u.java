package d.a.l0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class u extends a0 {
    public u(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/postMessage");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.r1.g.a("postMessage", "PostMsgAction handle");
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        d.a.l0.a.o0.d.d a2 = d.a.l0.a.o0.d.d.a(str);
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        d.a.l0.a.r1.g.a("postMessage", "PostEvent start");
        d.a.l0.a.g1.f.V().z(a2, true);
        d.a.l0.a.r1.g.a("postMessage", "PostEvent end.");
        return true;
    }
}
