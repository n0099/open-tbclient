package d.b.h0.a.t1.k;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class m extends a0 {
    public m(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/isLoginSync");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("isLogin", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        boolean e2 = eVar.z().e(context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", e2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException unused) {
            d.b.h0.a.c0.c.b("isLogin", "json parse fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
