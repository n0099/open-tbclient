package d.b.h0.a.e0.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.z0.f;
import d.b.h0.g.f.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/sConsole");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f47009b) {
            Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        boolean optBoolean;
        if (a0.f47009b) {
            Log.d("ConsoleAction", "handleSubAction subAction: " + str);
        }
        if (!d.b.h0.a.c0.a.a() && !d.b.h0.a.c0.c.d() && !TextUtils.equals(str, "/swanAPI/sConsole/debugSwitch")) {
            return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1923550429:
                if (str.equals("/swanAPI/sConsole/sanIncData2Console")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1792428120:
                if (str.equals("/swanAPI/sConsole/sanFullData2Console")) {
                    c2 = 4;
                    break;
                }
                break;
            case -797920904:
                if (str.equals("/swanAPI/sConsole/hide")) {
                    c2 = 2;
                    break;
                }
                break;
            case -797593805:
                if (str.equals("/swanAPI/sConsole/show")) {
                    c2 = 1;
                    break;
                }
                break;
            case -161927599:
                if (str.equals("/swanAPI/sConsole/postMessage")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1089933937:
                if (str.equals("/swanAPI/sConsole/debugSwitch")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2136057821:
                if (str.equals("/swanAPI/sConsole/getSanDataFromActiveSlave")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (optParamsAsJo != null && (optBoolean = optParamsAsJo.optBoolean("enableDebug")) != d.b.h0.a.c0.a.a()) {
                    d.b.h0.a.c0.a.c(context, optBoolean);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    d.b.h0.a.c0.c.g("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                }
                return true;
            case 1:
                f.V().F().D(true);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                d.b.h0.a.c0.c.g("ConsoleAction", "sConsole show");
                return true;
            case 2:
                f.V().F().D(false);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                d.b.h0.a.c0.c.g("ConsoleAction", "sConsole hide");
                return true;
            case 3:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    d.b.h0.a.c0.c.g("ConsoleAction", "send san inc data");
                    b.d(optParamsAsJo.toString());
                } else {
                    d.b.h0.a.c0.c.b("ConsoleAction", "san inc data is null");
                }
                return true;
            case 4:
                if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                    d.b.h0.a.c0.c.g("ConsoleAction", "send san full data");
                    b.c(optParamsAsJo.toString());
                } else {
                    d.b.h0.a.c0.c.b("ConsoleAction", "san full data is null");
                }
                return true;
            case 5:
                d.b.h0.a.c0.c.g("ConsoleAction", "request san full data");
                b.b();
                return true;
            case 6:
                g.h(optParamsAsJo);
                return true;
            default:
                return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
    }
}
