package d.a.l0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {
    public k(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/save");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.l0.a.e0.d.b("saveFile", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String M = d.a.l0.a.k2.b.M(optParamsAsJo.optString("tempFilePath"), eVar.getAppId());
            if (a0.f44625b) {
                Log.d("SaveFileAction", "——> handle: tempFileUrl " + optParamsAsJo.optString("tempFilePath"));
                Log.d("SaveFileAction", "——> handle: tempFilePath " + M);
            }
            if (TextUtils.isEmpty(M)) {
                d.a.l0.a.e0.d.b("saveFile", "temp file path is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            int a2 = eVar.U().a(M);
            if (a0.f44625b) {
                Log.d("SaveFileAction", "——> handle: statusCode " + a2);
            }
            if (a2 > 2000) {
                d.a.l0.a.e0.d.b("saveFile", "file path status code : " + a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, d.a.l0.a.c2.b.a(a2)));
                return false;
            }
            String o = eVar.U().o(M);
            if (TextUtils.isEmpty(o)) {
                d.a.l0.a.e0.d.b("saveFile", "save file path is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.a.l0.a.c2.b.a(2003)));
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("savedFilePath", d.a.l0.a.k2.b.J(o, d.a.l0.a.a2.e.V()));
                if (a0.f44625b) {
                    Log.d("SaveFileAction", "——> handle: saveFilePath saveFilePath " + o + " update saveFilePath " + jSONObject.get("savedFilePath"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException unused) {
                d.a.l0.a.e0.d.l("saveFile", "save file path to scheme fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        d.a.l0.a.e0.d.b("saveFile", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
