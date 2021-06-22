package d.a.m0.a.n2.k;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/getAutoRotationSync");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.b("getAutoRotationSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44733b) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b("getAutoRotationSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44733b) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
            }
            return false;
        } else {
            try {
                int i2 = Settings.System.getInt(context.getApplicationContext().getContentResolver(), "accelerometer_rotation");
                if (a0.f44733b) {
                    Log.d("SwanAppAction", "getAutoRotationSync --- isRotateOn: " + i2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isRotateOn", i2 != 0);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException unused) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                    if (a0.f44733b) {
                        Log.e("SwanAppAction", "getAutoRotationSync --- json exception");
                    }
                    return false;
                }
            } catch (Exception e2) {
                if (a0.f44733b) {
                    e2.printStackTrace();
                    Log.e("SwanAppAction", "getAutoRotationSync --- can't get setting");
                }
                return false;
            }
        }
    }
}
