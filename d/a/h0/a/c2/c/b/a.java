package d.a.h0.a.c2.c.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c2.c.a;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/getBatteryInfo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (j(context, eVar, unitedSchemeEntity)) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (a0.f44398b) {
                    Log.d("SwanAppAction", "getBatteryInfo --- params is empty");
                }
                d.a.h0.a.c0.c.b("battery", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (a0.f44398b) {
                    Log.d("SwanAppAction", "getBatteryInfo --- cb is empty");
                }
                d.a.h0.a.c0.c.b("battery", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            a.C0606a a2 = d.a.h0.a.c2.c.a.a(context);
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (a0.f44398b) {
                Log.d("battery", "/swanAPI/getBatteryInfo = level: " + a2.f41789a + " ; plugged: " + a2.f41790b);
            }
            JSONObject k = k(a2);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                if (a0.f44398b) {
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
