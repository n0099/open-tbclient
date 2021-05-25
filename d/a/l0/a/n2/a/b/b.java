package d.a.l0.a.n2.a.b;

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
        super(eVar, "/swanAPI/stopAccelerometer");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.b("accelerometer", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "stopAccelerometer --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b("accelerometer", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f40949b) {
                Log.d("SwanAppAction", "stopAccelerometer --- illegal context");
            }
            return false;
        } else {
            d.g("accelerometer", "stop listen accelerometer");
            d.a.l0.a.n2.a.a.a().g();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
