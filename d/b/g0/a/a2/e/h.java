package d.b.g0.a.a2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {
    public h(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/file/removeSavedFile");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (context != null && callbackHandler != null && eVar != null && eVar.S() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b("removeSavedFile", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String u = d.b.g0.a.a2.b.u(optParamsAsJo.optString("filePath"), d.b.g0.a.r1.e.T());
            if (a0.f46287b) {
                Log.d("SaveFileAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                Log.d("SaveFileAction", "——> handle: filePath " + u);
            }
            if (a0.f46287b) {
                Log.d("RemoveSavedFileAction", "——> handle: filePath " + u);
            }
            if (TextUtils.isEmpty(u)) {
                d.b.g0.a.c0.c.b("removeSavedFile", "file path is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            int a2 = eVar.S().a(u);
            if (a0.f46287b) {
                Log.d("RemoveSavedFileAction", "——> handle: statusCode " + a2);
            }
            if (a2 > 2000) {
                d.b.g0.a.c0.c.b("removeSavedFile", "file path status code : " + a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, d.b.g0.a.t1.f.a(a2)));
                return false;
            } else if (d.b.g0.p.d.g(u)) {
                d.b.g0.a.c0.c.g("removeSavedFile", "file delete success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (a0.f46287b) {
                    Log.d("RemoveSavedFileAction", "——> handle:  delete OK ");
                    return true;
                }
                return true;
            } else {
                d.b.g0.a.c0.c.b("removeSavedFile", "file delete fail");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, d.b.g0.a.t1.f.a(2004)));
                if (a0.f46287b) {
                    Log.d("RemoveSavedFileAction", "——> handle:  delete fail ");
                }
                return false;
            }
        }
        d.b.g0.a.c0.c.b("removeSavedFile", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
