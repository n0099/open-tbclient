package d.b.g0.a.c2.b;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/getMediaVolumeSync");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("getMediaVolumeSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46288b) {
                Log.d("SwanAppAction", "getMediaVolumeSync --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b.g0.a.c0.c.b("getMediaVolumeSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f46288b) {
                Log.d("SwanAppAction", "getMediaVolumeSync --- illegal context");
            }
            return false;
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "get AudioManager error");
                if (a0.f46288b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- get AudioManager error");
                }
                return false;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            if (streamMaxVolume <= 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "max volume get 0");
                if (a0.f46288b) {
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
            if (a0.f46288b) {
                Log.d("SwanAppAction", "getMediaVolumeSync: " + d2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", d2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                if (a0.f46288b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- json exception");
                }
                return false;
            }
        }
    }
}
