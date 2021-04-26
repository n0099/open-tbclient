package d.a.h0.a.y.a;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends a0 {
    public a(j jVar, String str) {
        super(jVar, str);
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : 1001);
    }

    public d.a.h0.a.y.b.a k(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.y.b.a(unitedSchemeEntity.getParams().get("params"));
    }

    public JSONObject l(int i2) {
        return UnitedSchemeUtility.wrapCallbackParams(i2);
    }
}
