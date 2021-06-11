package d.a.l0.a.c2.f.n0;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.h0.c.a.b;
import d.a.l0.a.h0.o.d;
import d.a.l0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/prefetchAppData");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("PrefetchAppData", "handle entity: " + unitedSchemeEntity.getUri().toString());
        }
        String param = unitedSchemeEntity.getParam("params");
        JSONObject d2 = w.d(param);
        PrefetchEvent j = j(d2);
        if (j != null && j.f()) {
            if (!b.c(d2.optString("netconf", "1"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                return false;
            }
            d.e().d(j);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params: " + param);
        return false;
    }

    public final PrefetchEvent j(@NonNull JSONObject jSONObject) {
        PrefetchEvent.b bVar = new PrefetchEvent.b();
        bVar.e(jSONObject.optString("state"));
        bVar.d(jSONObject.optString("schema"));
        bVar.c(jSONObject.optString("scene"));
        bVar.a(jSONObject.optString("appKey"));
        return bVar.b();
    }
}
