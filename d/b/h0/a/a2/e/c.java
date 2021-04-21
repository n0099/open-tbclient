package d.b.h0.a.a2.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.b.h0.a.t1.k.a0;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {
    public c(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/file/getInfo");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        String t;
        if (context != null && callbackHandler != null && eVar != null && eVar.S() != null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.h0.a.c0.c.b("fileInfo", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("filePath");
            if (d.b.h0.a.a2.b.c(optString) == PathType.BD_FILE) {
                t = d.b.h0.a.a2.b.u(optString, d.b.h0.a.r1.e.T());
            } else {
                t = d.b.h0.a.a2.b.c(optString) == PathType.RELATIVE ? d.b.h0.a.a2.b.t(optString, eVar, eVar.W()) : "";
            }
            if (a0.f47009b) {
                Log.d("GetFileInfoAction", "——> handle: fileUrl " + optString);
                Log.d("GetFileInfoAction", "——> handle: filePath " + t);
            }
            if (TextUtils.isEmpty(t)) {
                d.b.h0.a.c0.c.b("fileInfo", "absolute filePath is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            File file = new File(t);
            String b2 = d.b.h0.a.i2.n.b(TextUtils.equals(optParamsAsJo.optString("digestAlgorithm", PackageTable.MD5), PackageTable.MD5) ? "MD5" : "SHA-1", file, false);
            if (TextUtils.isEmpty(b2)) {
                d.b.h0.a.c0.c.b("fileInfo", "hash is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, d.b.h0.a.t1.f.a(2001)));
                if (a0.f47009b) {
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
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d.b.h0.a.t1.f.a(2003)));
                if (a0.f47009b) {
                    Log.d("GetFileInfoAction", "——> handle: jsonException ");
                }
                return false;
            }
        }
        d.b.h0.a.c0.c.b("fileInfo", "execute fail");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
