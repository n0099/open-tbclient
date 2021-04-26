package d.a.h0.a.s0.h;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.z0.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a0 {
    public d(j jVar) {
        super(jVar, "/swanAPI/setFullscreenOrientationSync");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("setFullscreenOrientationSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal runtime");
            if (a0.f44398b) {
                Log.e("SwanAppAction", "setFullscreenOrientationSync --- illegal runtime");
            }
            return false;
        } else if (context == null) {
            d.a.h0.a.c0.c.b("setFullscreenOrientationSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44398b) {
                Log.e("SwanAppAction", "setFullscreenOrientationSync --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.h0.a.c0.c.b("setFullscreenOrientationSync", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            int optInt = optParamsAsJo.optInt("orientationType", -10000);
            d.a.h0.a.p.d.d B = f.V().B(optParamsAsJo.optString("slaveId"));
            if (!(B instanceof SwanAppWebViewManager)) {
                d.a.h0.a.c0.c.b("setFullscreenOrientationSync", "no WebView with this slaveId");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int j = j(optInt);
            ((SwanAppWebViewManager) B).U0(j);
            if (a0.f44398b) {
                Log.d("setFullscreenOrientationSync", "orientation set to : " + j);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
    }

    public final int j(int i2) {
        if (i2 != -90) {
            if (i2 != 0) {
                return i2 != 90 ? -1 : 0;
            }
            return 1;
        }
        return 8;
    }
}
