package d.b.h0.a.c2.e.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.c0.c;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(j jVar) {
        super(jVar, "/swanAPI/stopCompass");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("compass", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "stopCompass --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            c.b("compass", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "stopCompass --- illegal context");
            }
            return false;
        } else {
            c.g("compass", "stop listen compass");
            d.b.h0.a.c2.e.a.i().q();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
