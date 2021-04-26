package d.a.h0.a.c2.a.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c0.c;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(j jVar) {
        super(jVar, "/swanAPI/stopAccelerometer");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("accelerometer", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "stopAccelerometer --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            c.b("accelerometer", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "stopAccelerometer --- illegal context");
            }
            return false;
        } else {
            c.g("accelerometer", "stop listen accelerometer");
            d.a.h0.a.c2.a.a.g().m();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
