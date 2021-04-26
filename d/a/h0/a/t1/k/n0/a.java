package d.a.h0.a.t1.k.n0;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.e0.q.d;
import d.a.h0.a.i2.v;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/prefetchAppData");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            Log.d("PrefetchAppData", "handle entity: " + unitedSchemeEntity.getUri().toString());
        }
        String param = unitedSchemeEntity.getParam("params");
        JSONObject b2 = v.b(param);
        PrefetchEvent j = j(b2);
        if (j != null && j.c()) {
            if (!d.a.h0.a.e0.h.a.a.c(b2.optString("netconf", "1"))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                return false;
            }
            d.c().b(j);
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
