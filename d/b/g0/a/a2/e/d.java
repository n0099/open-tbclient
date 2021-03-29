package d.b.g0.a.a2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a0 {
    public d(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/file/getSavedFileInfo");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.S() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b("getSavedFile", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String u = d.b.g0.a.a2.b.u(optParamsAsJo.optString("filePath"), d.b.g0.a.r1.e.T());
            if (a0.f46288b) {
                Log.d("GetSavedFileInfoAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                Log.d("GetSavedFileInfoAction", "——> handle: filePath " + u);
            }
            if (TextUtils.isEmpty(u)) {
                d.b.g0.a.c0.c.b("getSavedFile", "file path is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.b.g0.a.a2.a h2 = eVar.S().h(u);
            if (h2 == null) {
                d.b.g0.a.c0.c.b("getSavedFile", "file info is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, d.b.g0.a.t1.f.a(2001)));
                if (a0.f46288b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: file not exist");
                }
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("createTime", Math.round((float) (h2.a() / 1000)));
                jSONObject.put("size", h2.c());
                if (a0.f46288b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: fileInfo (" + jSONObject.get("createTime") + " , " + jSONObject.get("size") + SmallTailInfo.EMOTION_SUFFIX);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                d.b.g0.a.c0.c.l("getSavedFile", "file info to json fail");
                e2.printStackTrace();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.b.g0.a.t1.f.a(2003)));
                if (a0.f46288b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: jsonException ");
                }
                return false;
            }
        }
        d.b.g0.a.c0.c.b("getSavedFile", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
