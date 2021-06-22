package d.a.m0.a.w1.f;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(e eVar) {
        super(eVar, "/swanAPI/community/closeReplyEditor");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (d.a.m0.a.w1.e.c().b()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0, "");
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "closeReplyEditor failed");
        return false;
    }
}
