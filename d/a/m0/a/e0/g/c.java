package d.a.m0.a.e0.g;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.g1.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public a f45285c;

    public c(e eVar) {
        super(eVar, "/swanAPI/perfCat");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            Log.d("SwanAppPropertyLogAction", "handleSubAction subAction: " + str);
        }
        if (!a0.f44733b) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(403));
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -322942229) {
            if (hashCode != 227833272) {
                if (hashCode == 977180790 && str.equals("/swanAPI/perfCat/on")) {
                    c2 = 0;
                }
            } else if (str.equals("/swanAPI/perfCat/off")) {
                c2 = 1;
            }
        } else if (str.equals("/swanAPI/perfCat/duration")) {
            c2 = 2;
        }
        if (c2 == 0) {
            if (this.f45285c == null) {
                this.f45285c = new a();
            }
            this.f45285c.h();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.m0.a.e0.d.g("SwanAppPropertyLogAction", " Start property log：");
            return true;
        } else if (c2 != 1) {
            if (c2 != 2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                return false;
            }
            if (optParamsAsJo == null) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202));
            } else {
                if (this.f45285c != null) {
                    this.f45285c.g(optParamsAsJo.optInt("duration"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
            return true;
        } else {
            JSONObject jSONObject = new JSONObject();
            a aVar = this.f45285c;
            if (aVar == null) {
                d.a.m0.a.e0.d.b("SwanAppPropertyLogAction", "Property log never start");
            } else {
                String i2 = aVar.i();
                this.f45285c = null;
                f.V().D();
                try {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, f.V().D());
                    jSONObject.put("path", i2);
                } catch (JSONException e2) {
                    if (a0.f44733b) {
                        e2.printStackTrace();
                    }
                }
                if (a0.f44733b) {
                    Log.d("SwanAppPropertyLogAction", "Video dispatch Params : " + jSONObject.toString());
                }
                d.a.m0.a.e0.d.g("SwanAppPropertyLogAction", "Stop property log");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }
}
