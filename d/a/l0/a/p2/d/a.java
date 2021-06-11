package d.a.l0.a.p2.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/closeTextarea");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.g("CloseTextAreaAction", "closeTextAreaAction paramsJson: " + optParamsAsJo);
        d.a.l0.a.c0.c.g.b bVar = new d.a.l0.a.c0.c.g.b();
        try {
            bVar.a(optParamsAsJo);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.c("CloseTextAreaAction", "model parse exception:", e2);
        }
        d.a.l0.a.c0.c.g.a aVar = (d.a.l0.a.c0.c.g.a) d.a.l0.a.c0.d.a.a(bVar);
        if (aVar == null) {
            String str = "can't find textarea component:#" + bVar.f44521f;
            d.b("CloseTextAreaAction", str);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
            return false;
        }
        d.a.l0.a.c0.b.c C = aVar.C();
        if (!C.a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f44526b);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
