package d.a.l0.a.i1.c.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.i1.c.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/backgroundAudio");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("AudioBGPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.i1.c.a b2;
        boolean z;
        if (a0.f44625b) {
            Log.d("AudioBGPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject j = j(unitedSchemeEntity.getParam("params"));
        if (j == null) {
            d.b("backgroundAudio", "param is null!");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        c E = eVar.E();
        if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
            b2 = d.a.l0.a.i1.c.a.b(j, new d.a.l0.a.i1.c.a());
        } else {
            b2 = d.a.l0.a.i1.c.a.b(j, E.q());
        }
        if (a0.f44625b) {
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
                d.g("backgroundAudio", "open, audioId " + b2.f46386a);
                E.z(b2, callbackHandler);
                z = true;
                break;
            case 1:
                d.g("backgroundAudio", "update, audioId " + b2.f46386a);
                E.K(b2);
                z = true;
                break;
            case 2:
                d.g("backgroundAudio", "play, audioId " + b2.f46386a);
                E.F();
                z = true;
                break;
            case 3:
                d.g("backgroundAudio", "pause, audioId " + b2.f46386a);
                E.A();
                z = true;
                break;
            case 4:
                d.g("backgroundAudio", "seek, audioId " + b2.f46386a + " position " + b2.l);
                E.G(b2.l);
                z = true;
                break;
            case 5:
                d.g("backgroundAudio", "stop, audioId " + b2.f46386a);
                E.J();
                z = true;
                break;
            case 6:
                jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(b2.m, E.t(b2.m));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException e2) {
                    d.b("backgroundAudio", "getParams error " + e2.toString());
                    if (a0.f44625b) {
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
                if (a0.f44625b) {
                    Log.d("AudioBGPlayerAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }
}
