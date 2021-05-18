package d.a.i0.a.k2.e;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.c2.f.a0;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {
    public e(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/getSavedFileList");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
            ArrayList arrayList = (ArrayList) eVar.U().i();
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.i0.a.k2.a aVar = (d.a.i0.a.k2.a) it.next();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("filePath", d.a.i0.a.k2.b.J(aVar.b(), d.a.i0.a.a2.e.V()));
                        jSONObject.put("createTime", aVar.a());
                        jSONObject.put("size", aVar.c());
                        if (a0.f40775b) {
                            Log.d("GetSavedFileListAction", "——> handle: fileInfo (" + jSONObject.get("filePath") + " , " + jSONObject.get("createTime") + " , " + jSONObject.get("size") + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    } catch (JSONException e2) {
                        d.a.i0.a.e0.d.l("getSavedFileList", "file info to json fail");
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("fileList", jSONArray);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                    return true;
                } catch (JSONException e3) {
                    d.a.i0.a.e0.d.b("getSavedFileList", "file list to json fail");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.a.i0.a.c2.b.a(2003)));
                    if (a0.f40775b) {
                        Log.d("GetSavedFileListAction", "——> handle: jsonException " + e3.getMessage());
                    }
                    return false;
                }
            }
            d.a.i0.a.e0.d.b("getSavedFileList", "file list is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0));
            return true;
        }
        d.a.i0.a.e0.d.b("getSavedFileList", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
