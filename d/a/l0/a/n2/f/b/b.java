package d.a.l0.a.n2.f.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(e eVar) {
        super(eVar, "/swanAPI/stopCompass");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.b("compass", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44625b) {
                Log.d("SwanAppAction", "stopCompass --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b("compass", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44625b) {
                Log.d("SwanAppAction", "stopCompass --- illegal context");
            }
            return false;
        } else {
            d.g("compass", "stop listen compass");
            d.a.l0.a.n2.f.a.i().q();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
