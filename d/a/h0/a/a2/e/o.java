package d.a.h0.a.a2.e;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.k.a0;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends a0 {
    public o(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getStorageInfoSync");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        d.a.h0.a.a2.c S = eVar.S();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) S.g().a()));
            jSONObject.put("currentSize", S.e() / 1024);
            jSONObject.put("limitSize", S.n() / 1024);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            if (a0.f44398b) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
