package d.b.g0.a.t1.k;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class l extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.p.d.b f46850c;

    public l(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getSlaveIdSync");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46680b) {
            Log.d("GetSlaveIdSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (this.f46850c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", this.f46850c.c());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e2) {
            if (a0.f46680b) {
                Log.d("GetSlaveIdSyncAction", Log.getStackTraceString(e2));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public void j(d.b.g0.a.p.d.b bVar) {
        this.f46850c = bVar;
    }
}
