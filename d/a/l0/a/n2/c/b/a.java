package d.a.l0.a.n2.c.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.n2.c.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    public a(e eVar) {
        super(eVar, "/swanAPI/getBatteryInfo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (j(context, eVar, unitedSchemeEntity)) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "getBatteryInfo --- params is empty");
                }
                d.b("battery", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "getBatteryInfo --- cb is empty");
                }
                d.b("battery", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            a.C0826a a2 = d.a.l0.a.n2.c.a.a(context);
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (a0.f44625b) {
                Log.d("battery", "/swanAPI/getBatteryInfo = level: " + a2.f47468a + " ; plugged: " + a2.f47469b);
            }
            JSONObject k = k(a2);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "getBatteryInfoSync --- json error");
                }
                return false;
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(k, 0).toString(), optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return false;
    }
}
