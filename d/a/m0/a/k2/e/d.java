package d.a.m0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.m0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {
    public d(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/getSavedFileInfo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("getSavedFile", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String M = d.a.m0.a.k2.b.M(optParamsAsJo.optString("filePath"), d.a.m0.a.a2.e.V());
            if (a0.f44733b) {
                Log.d("GetSavedFileInfoAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                Log.d("GetSavedFileInfoAction", "——> handle: filePath " + M);
            }
            if (TextUtils.isEmpty(M)) {
                d.a.m0.a.e0.d.b("getSavedFile", "file path is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.m0.a.k2.a h2 = eVar.U().h(M);
            if (h2 == null) {
                d.a.m0.a.e0.d.b("getSavedFile", "file info is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, d.a.m0.a.c2.b.a(2001)));
                if (a0.f44733b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: file not exist");
                }
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("createTime", Math.round((float) (h2.a() / 1000)));
                jSONObject.put("size", h2.c());
                if (a0.f44733b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: fileInfo (" + jSONObject.get("createTime") + " , " + jSONObject.get("size") + SmallTailInfo.EMOTION_SUFFIX);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                d.a.m0.a.e0.d.l("getSavedFile", "file info to json fail");
                e2.printStackTrace();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.a.m0.a.c2.b.a(2003)));
                if (a0.f44733b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: jsonException ");
                }
                return false;
            }
        }
        d.a.m0.a.e0.d.b("getSavedFile", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
