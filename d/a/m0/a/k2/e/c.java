package d.a.m0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.a.m0.a.c2.f.a0;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {
    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/getInfo");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        String L;
        if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("fileInfo", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("filePath");
            if (d.a.m0.a.k2.b.s(optString) == PathType.BD_FILE) {
                L = d.a.m0.a.k2.b.M(optString, d.a.m0.a.a2.e.V());
            } else {
                L = d.a.m0.a.k2.b.s(optString) == PathType.RELATIVE ? d.a.m0.a.k2.b.L(optString, eVar, eVar.Z()) : "";
            }
            if (a0.f44733b) {
                Log.d("GetFileInfoAction", "——> handle: fileUrl " + optString);
                Log.d("GetFileInfoAction", "——> handle: filePath " + L);
            }
            if (TextUtils.isEmpty(L)) {
                d.a.m0.a.e0.d.b("fileInfo", "absolute filePath is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            File file = new File(L);
            String b2 = d.a.m0.a.v2.o.b(TextUtils.equals(optParamsAsJo.optString("digestAlgorithm", PackageTable.MD5), PackageTable.MD5) ? "MD5" : "SHA-1", file, false);
            if (TextUtils.isEmpty(b2)) {
                d.a.m0.a.e0.d.b("fileInfo", "hash is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, d.a.m0.a.c2.b.a(2001)));
                if (a0.f44733b) {
                    Log.d("GetFileInfoAction", "——> handle: file not exist");
                }
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LightappBusinessClient.MTD_DIGEST, b2);
                jSONObject.put("size", file.length());
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.a.m0.a.c2.b.a(2003)));
                if (a0.f44733b) {
                    Log.d("GetFileInfoAction", "——> handle: jsonException ");
                }
                return false;
            }
        }
        d.a.m0.a.e0.d.b("fileInfo", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
