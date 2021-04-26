package d.a.h0.a.t1.k;

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
    public d.a.h0.a.p.d.b f44580c;

    public l(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getSlaveIdSync");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("GetSlaveIdSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (this.f44580c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", this.f44580c.c());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e2) {
            if (a0.f44398b) {
                Log.d("GetSlaveIdSyncAction", Log.getStackTraceString(e2));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public void j(d.a.h0.a.p.d.b bVar) {
        this.f44580c = bVar;
    }
}
