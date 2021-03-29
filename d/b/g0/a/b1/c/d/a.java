package d.b.g0.a.b1.c.d;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes2.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/backgroundAudio");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f46288b) {
            Log.d("AudioBGPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        d.b.g0.a.b1.c.a b2;
        boolean z;
        if (a0.f46288b) {
            Log.d("AudioBGPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject j = j(unitedSchemeEntity.getParam("params"));
        if (j == null) {
            c.b("backgroundAudio", "param is null!");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.b.g0.a.b1.c.c C = eVar.C();
        if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
            b2 = d.b.g0.a.b1.c.a.b(j, new d.b.g0.a.b1.c.a());
        } else {
            b2 = d.b.g0.a.b1.c.a.b(j, C.p());
        }
        if (a0.f46288b) {
            Log.d("AudioBGPlayerAction", "subAction is : " + str);
        }
        JSONObject jSONObject = null;
        char c2 = 65535;
        switch (str.hashCode()) {
            case 312101659:
                if (str.equals("/swanAPI/backgroundAudio/getParamsSync")) {
                    c2 = 6;
                    break;
                }
                break;
            case 335869926:
                if (str.equals("/swanAPI/backgroundAudio/open")) {
                    c2 = 0;
                    break;
                }
                break;
            case 335895760:
                if (str.equals("/swanAPI/backgroundAudio/play")) {
                    c2 = 2;
                    break;
                }
                break;
            case 335978516:
                if (str.equals("/swanAPI/backgroundAudio/seek")) {
                    c2 = 4;
                    break;
                }
                break;
            case 335993246:
                if (str.equals("/swanAPI/backgroundAudio/stop")) {
                    c2 = 5;
                    break;
                }
                break;
            case 820188005:
                if (str.equals("/swanAPI/backgroundAudio/update")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1822525402:
                if (str.equals("/swanAPI/backgroundAudio/pause")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                c.g("backgroundAudio", "open, audioId " + b2.f43278a);
                C.y(b2, callbackHandler);
                z = true;
                break;
            case 1:
                c.g("backgroundAudio", "update, audioId " + b2.f43278a);
                C.I(b2);
                z = true;
                break;
            case 2:
                c.g("backgroundAudio", "play, audioId " + b2.f43278a);
                C.E();
                z = true;
                break;
            case 3:
                c.g("backgroundAudio", "pause, audioId " + b2.f43278a);
                C.z();
                z = true;
                break;
            case 4:
                c.g("backgroundAudio", "seek, audioId " + b2.f43278a + " position " + b2.j);
                C.F(b2.j);
                z = true;
                break;
            case 5:
                c.g("backgroundAudio", "stop, audioId " + b2.f43278a);
                C.H();
                z = true;
                break;
            case 6:
                jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(b2.k, C.s(b2.k));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException e2) {
                    c.b("backgroundAudio", "getParams error " + e2.toString());
                    if (a0.f46288b) {
                        e2.printStackTrace();
                        break;
                    }
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    public final JSONObject j(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (a0.f46288b) {
                    Log.d("AudioBGPlayerAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }
}
