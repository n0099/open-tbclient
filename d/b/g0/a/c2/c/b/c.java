package d.b.g0.a.c2.c.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c2.c.a;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/getBatteryInfoSync");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (j(context, eVar, unitedSchemeEntity)) {
            a.C0634a a2 = d.b.g0.a.c2.c.a.a(context);
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                return false;
            }
            if (a0.f46287b) {
                Log.d("battery", "/swanAPI/getBatteryInfoSync = level: " + a2.f43775a + " ; plugged: " + a2.f43776b);
            }
            JSONObject k = k(a2);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                if (a0.f46287b) {
                    Log.d("SwanAppAction", "getBatteryInfoSync --- json error");
                }
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(k, 0);
            return true;
        }
        return false;
    }
}
