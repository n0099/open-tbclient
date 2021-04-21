package d.b.h0.a.c0.e;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public a f44393c;

    public c(j jVar) {
        super(jVar, "/swanAPI/perfCat");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f47009b) {
            Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f47009b) {
            Log.d("SwanAppPropertyLogAction", "handleSubAction subAction: " + str);
        }
        if (!a0.f47009b) {
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
            if (this.f44393c == null) {
                this.f44393c = new a();
            }
            this.f44393c.h();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            d.b.h0.a.c0.c.g("SwanAppPropertyLogAction", " Start property log：");
            return true;
        } else if (c2 != 1) {
            if (c2 != 2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                return false;
            }
            if (optParamsAsJo == null) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202));
            } else {
                if (this.f44393c != null) {
                    this.f44393c.g(optParamsAsJo.optInt("duration"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
            return true;
        } else {
            JSONObject jSONObject = new JSONObject();
            a aVar = this.f44393c;
            if (aVar == null) {
                d.b.h0.a.c0.c.b("SwanAppPropertyLogAction", "Property log never start");
            } else {
                String i = aVar.i();
                this.f44393c = null;
                f.V().p();
                try {
                    jSONObject.put("wvID", f.V().p());
                    jSONObject.put("path", i);
                } catch (JSONException e2) {
                    if (a0.f47009b) {
                        e2.printStackTrace();
                    }
                }
                if (a0.f47009b) {
                    Log.d("SwanAppPropertyLogAction", "Video dispatch Params : " + jSONObject.toString());
                }
                d.b.h0.a.c0.c.g("SwanAppPropertyLogAction", "Stop property log");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }
}
