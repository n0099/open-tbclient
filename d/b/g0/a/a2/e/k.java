package d.b.g0.a.a2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {
    public k(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/file/save");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.S() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b("saveFile", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String u = d.b.g0.a.a2.b.u(optParamsAsJo.optString("tempFilePath"), eVar.getAppId());
            if (a0.f46287b) {
                Log.d("SaveFileAction", "——> handle: tempFileUrl " + optParamsAsJo.optString("tempFilePath"));
                Log.d("SaveFileAction", "——> handle: tempFilePath " + u);
            }
            if (TextUtils.isEmpty(u)) {
                d.b.g0.a.c0.c.b("saveFile", "temp file path is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            int a2 = eVar.S().a(u);
            if (a0.f46287b) {
                Log.d("SaveFileAction", "——> handle: statusCode " + a2);
            }
            if (a2 > 2000) {
                d.b.g0.a.c0.c.b("saveFile", "file path status code : " + a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, d.b.g0.a.t1.f.a(a2)));
                return false;
            }
            String o = eVar.S().o(u);
            if (TextUtils.isEmpty(o)) {
                d.b.g0.a.c0.c.b("saveFile", "save file path is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.b.g0.a.t1.f.a(2003)));
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("savedFilePath", d.b.g0.a.a2.b.r(o, d.b.g0.a.r1.e.T()));
                if (a0.f46287b) {
                    Log.d("SaveFileAction", "——> handle: saveFilePath saveFilePath " + o + " update saveFilePath " + jSONObject.get("savedFilePath"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException unused) {
                d.b.g0.a.c0.c.l("saveFile", "save file path to scheme fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        d.b.g0.a.c0.c.b("saveFile", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
