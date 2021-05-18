package d.a.i0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {
    public h(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/removeSavedFile");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.i0.a.e0.d.b("removeSavedFile", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String M = d.a.i0.a.k2.b.M(optParamsAsJo.optString("filePath"), d.a.i0.a.a2.e.V());
            if (a0.f40775b) {
                Log.d("SaveFileAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                Log.d("SaveFileAction", "——> handle: filePath " + M);
            }
            if (a0.f40775b) {
                Log.d("RemoveSavedFileAction", "——> handle: filePath " + M);
            }
            if (TextUtils.isEmpty(M)) {
                d.a.i0.a.e0.d.b("removeSavedFile", "file path is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            int a2 = eVar.U().a(M);
            if (a0.f40775b) {
                Log.d("RemoveSavedFileAction", "——> handle: statusCode " + a2);
            }
            if (a2 > 2000) {
                d.a.i0.a.e0.d.b("removeSavedFile", "file path status code : " + a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, d.a.i0.a.c2.b.a(a2)));
                return false;
            } else if (d.a.i0.t.d.j(M)) {
                d.a.i0.a.e0.d.g("removeSavedFile", "file delete success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (a0.f40775b) {
                    Log.d("RemoveSavedFileAction", "——> handle:  delete OK ");
                    return true;
                }
                return true;
            } else {
                d.a.i0.a.e0.d.b("removeSavedFile", "file delete fail");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, d.a.i0.a.c2.b.a(2004)));
                if (a0.f40775b) {
                    Log.d("RemoveSavedFileAction", "——> handle:  delete fail ");
                }
                return false;
            }
        }
        d.a.i0.a.e0.d.b("removeSavedFile", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
