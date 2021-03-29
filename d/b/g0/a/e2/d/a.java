package d.b.g0.a.e2.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/closeTextarea");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.b.g0.a.c0.c.g("CloseTextAreaAction", "closeTextAreaAction paramsJson: " + optParamsAsJo);
        d.b.g0.a.a0.c.g.b bVar = new d.b.g0.a.a0.c.g.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.b.g0.a.c0.c.c("CloseTextAreaAction", "model parse exception:", e2);
        }
        d.b.g0.a.a0.c.g.a aVar = (d.b.g0.a.a0.c.g.a) d.b.g0.a.a0.d.a.a(bVar);
        if (aVar == null) {
            String str = "can't find textarea component:#" + bVar.f43113f;
            d.b.g0.a.c0.c.b("CloseTextAreaAction", str);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
            return false;
        }
        d.b.g0.a.a0.b.c C = aVar.C();
        if (!C.a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f43117b);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
