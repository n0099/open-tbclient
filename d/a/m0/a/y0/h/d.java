package d.a.m0.a.y0.h;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.g1.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(e eVar) {
        super(eVar, "/swanAPI/setFullscreenOrientationSync");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("setFullscreenOrientationSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal runtime");
            if (a0.f44733b) {
                Log.e("SwanAppAction", "setFullscreenOrientationSync --- illegal runtime");
            }
            return false;
        } else if (context == null) {
            d.a.m0.a.e0.d.b("setFullscreenOrientationSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44733b) {
                Log.e("SwanAppAction", "setFullscreenOrientationSync --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("setFullscreenOrientationSync", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            int optInt = optParamsAsJo.optInt("orientationType", -10000);
            d.a.m0.a.p.e.d B = f.V().B(optParamsAsJo.optString("slaveId"));
            if (!(B instanceof SwanAppWebViewManager)) {
                d.a.m0.a.e0.d.b("setFullscreenOrientationSync", "no WebView with this slaveId");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int j = j(optInt);
            ((SwanAppWebViewManager) B).a1(j);
            if (a0.f44733b) {
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
