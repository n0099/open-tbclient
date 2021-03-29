package d.b.g0.a.c2.i;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c0.c;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/getAutoRotationSync");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("getAutoRotationSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46288b) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            c.b("getAutoRotationSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f46288b) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
            }
            return false;
        } else {
            try {
                int i = Settings.System.getInt(context.getApplicationContext().getContentResolver(), "accelerometer_rotation");
                if (a0.f46288b) {
                    Log.d("SwanAppAction", "getAutoRotationSync --- isRotateOn: " + i);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isRotateOn", i != 0);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException unused) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                    if (a0.f46288b) {
                        Log.e("SwanAppAction", "getAutoRotationSync --- json exception");
                    }
                    return false;
                }
            } catch (Exception e2) {
                if (a0.f46288b) {
                    e2.printStackTrace();
                    Log.e("SwanAppAction", "getAutoRotationSync --- can't get setting");
                }
                return false;
            }
        }
    }
}
