package d.a.l0.a.n2.b;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/getMediaVolumeSync");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.b("getMediaVolumeSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44625b) {
                Log.d("SwanAppAction", "getMediaVolumeSync --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.a.l0.a.e0.d.b("getMediaVolumeSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44625b) {
                Log.d("SwanAppAction", "getMediaVolumeSync --- illegal context");
            }
            return false;
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "get AudioManager error");
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- get AudioManager error");
                }
                return false;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            if (streamMaxVolume <= 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "max volume get 0");
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- max volume get 0");
                }
                return false;
            }
            double d2 = streamVolume / streamMaxVolume;
            if (d2 < 0.0d) {
                d2 = 0.0d;
            } else if (d2 > 1.0d) {
                d2 = 1.0d;
            }
            if (a0.f44625b) {
                Log.d("SwanAppAction", "getMediaVolumeSync: " + d2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", d2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                if (a0.f44625b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- json exception");
                }
                return false;
            }
        }
    }
}
