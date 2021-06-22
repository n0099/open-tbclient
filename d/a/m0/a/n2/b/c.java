package d.a.m0.a.n2.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {
    public c(e eVar) {
        super(eVar, "/swanAPI/stopMediaVolumeListen");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("stopMediaVolumeListen", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            if (a0.f44733b) {
                Log.d("SwanAppAction", "stopMediaVolumeListen --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.a.m0.a.e0.d.b("stopMediaVolumeListen", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            if (a0.f44733b) {
                Log.d("SwanAppAction", "stopMediaVolumeListen --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("stopMediaVolumeListen", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("id");
            if (TextUtils.isEmpty(optString)) {
                d.a.m0.a.e0.d.b("stopMediaVolumeListen", "id is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!d.e().j(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
